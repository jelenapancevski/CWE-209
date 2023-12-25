package com.rbs.cwe209.controller;

import com.rbs.cwe209.model.Product;
import com.rbs.cwe209.model.Promotion;
import com.rbs.cwe209.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.core.io.ResourceLoader;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PromotionsController {
    @Autowired
    private ResourceLoader resourceLoader;
    public PromotionsController(PromotionRepository promotionRepository) {

        this.promotionRepository = promotionRepository;
    }
    PromotionRepository promotionRepository;

    @GetMapping("/promotions")
    public String getProducts(Model model) {

        List<Promotion> promotions = promotionRepository.getAll();
        model.addAttribute("promotions",promotions);
        return "promotions";
    }
    @GetMapping("/promotion/{id}")
    public String getPromotion(Model model,@PathVariable Long id) /*throws SQLException*/ {

        String folderPath = "classpath:/static/promotions/";
        try {
            // Load the folder as a resource
            org.springframework.core.io.Resource folderResource = resourceLoader.getResource(folderPath);
            if (folderResource.exists()) System.out.println("postoji");
            // Get a list of files in the folder
            File[] files = folderResource.getFile().listFiles();
            List <String> filepaths = new ArrayList<>();
            for (int i=0;i<files.length;i++){
                filepaths.add(files[i].getPath());
            }

            // Add the list of files to the model
            model.addAttribute("files", filepaths);
        }
        catch(IOException e){

        }



        Promotion promotion = promotionRepository.getPromotion(id);
        if(promotion==null){
            model.addAttribute("errorMessage","No product with id = "+id+" cannot find an image /promotions/"+id+".jpg");
        }
        model.addAttribute("promotion",promotion);
        return "promotion";
    }
}
