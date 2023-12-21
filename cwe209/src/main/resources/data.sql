insert into users(id, username, password, usertype, firstname, lastname, address)
values (1, 'bruce', 'wayne', 'user', 'Bruce','Wayne','NY'),
       (2, 'peter', 'security_rules', 'user', 'Peter','Pan', 'Neverland'),
       (3, 'tom', 'guessmeifyoucan', 'user', 'Tom','Riddle','Bulgaria'),
       (4, 'admin', 'admin', 'admin','Petar','Nikolic','Novi Beograd 52');


insert into products(id, ingredients, name, description, producttype, price, image)
values (1,
        'flour, sugar, cocoa, vanilla extract, eggs, sweet cream, butter, chocolate',
        'Chocolate Delight',
        'Chocolate Delight is a three-layer chocolate cake. The cake is filled with whipped chocolate ganache, making each bite a burst of chocolate! It is topped with a chocolate cream cheese glaze and chocolate chips. A true paradise for chocolate lovers!',
        'cake',
        2700,
        'jpeg'),
        (2,
        'flour, sugar, cocoa, butter, eggs, cherry liqueur, cherries, dark chocolate, sweet cream',
        'Black Forest',
        'This Black Forest cake combines rich layers of chocolate cake with fresh cherries, cherry liqueur, and a simple sweet cream glaze.',
        'cake',
        2500,
        'jpeg'),
        (3,
                'butter, eggs, sugar, flour, pistachios, orange juice, berries, lemon juice, vanilla extract, mascarpone cheese',
                'Mascarpone Cake',
                'If you crave Italian desserts, this cake won''t leave you indifferent! Our mascarpone cake is made with plenty of fruit, covered with a delicious berry sauce, and filled with mascarpone filling.',
                'cake',
                2700,
                'jpeg'),
                (4,
                'flour, sugar, Dutch cocoa, eggs, vanilla extract,butter, pistachios, dark chocolate, sweet cream',
                'Chocolate Pistachio',
                'A tall three-layer naked cake with layers of moist chocolate cake, chocolate ganache, crispy chocolate crumbs, and a luxurious pistachio cream.',
                'cake',
                3000,
                'jpeg'
                ),
                (5,
                'cookie crumbs, butter, sugar, cake flour, eggs, sour cream, lime juice, sweet cream, salt, lime zest,vanilla paste',
                'Divine Lime',
                'Want a lime pie in the form of a cake? Here it is! This lime cake features juicy lime layers baked on a cookie crust, then covered with a buttercream lime glaze and filled with homemade lime filling. Absolutely incredible and so decadent!',
                'cake',
                2650,
                'jpeg'
                ),
                (6,
                'flour, sugar, cocoa, raspberries, eggs, sweet cream, butter, dark chocolate, milk chocolate',
                'Chocolate Raspberry',
                'This rich, moist chocolate cake makes an impressive birthday centerpiece, especially if you believe that a birthday cake must always contain chocolate, and plenty of it.',
                'cake',
                3000,
                'jpeg'
                ),
                (7,
                'flour, cocoa, sugar, Greek yogurt, eggs, milk, vanilla extract, butter, chocolate',
                'Chocolate Muffins',
                'Craving chocolate for breakfast? Try these double chocolate muffins! Soft and chocolatey batter topped with chocolate chips and baked to perfection.',
                'pastry',
                300,
                'jpeg'
                ),
                (8,
                'dark chocolate, butter, eggs, sugar, flour',
                'Soufflé',
                'Indulge your senses with our exceptional chocolate soufflé. This heavenly dessert is a symphony of rich, velvety chocolate, baked to perfection. Enjoy the airy, soufflé texture that melts in your mouth, creating a blissful chocolate experience.',
                'pastry',
                420,
                'jpeg'
                ),
                (9,
                'cookies, sugar, butter, cream cheese, cherries',
                'Cherry Delight',
                'Indulge in a premium cherry dessert, a heavenly blend of sweet cherries, cream cheese, and a buttery crust. This no-bake delight is an irresistible treat that is easy to make and impossible to resist. A burst of fruity goodness in every bite, this dessert is a true pleasure for your palate!',
                'pastry',
                400,
                'jpeg'
                ),
                (10,
                'espresso, ladyfingers, mascarpone cheese, black rum, eggs, sugar, sweet cream, vanilla extract, salt, cocoa',
                'Tiramisu',
                'Tiramisu is a timeless Italian no-bake dessert that combines espresso-soaked ladyfingers and a creamy lightly sweetened mascarpone cheese filling.',
                'pastry',
                350,
                'jpeg'
                ),
                (11,
                'butter, sugar, hazelnuts, flour, eggs, orange zest, dark chocolate, sweet cream',
                'Chocolate Tart',
                'Satisfy your chocolate cravings with our masterpiece Chocolate Tart. This decadent dessert features a rich, velvety chocolate filling nestled in a crispy, buttery crust. A symphony of indulgence, it is a luxurious treat that will captivate your senses with every bite. Elevate your dessert experience with our exceptional chocolate tart.',
                'pastry',
                450,
                'jpeg'
                ),
                (12,
                'oreo, butter, lemon juice, lemon zest, pomegranate juice, sugar, eggs, sweet cream, salt, dark chocolate, pomegranate',
                'Persephone Tart',
                'Indulge in the enchanting Persephone Tart—a divine blend of silky chocolate ganache and jewel-like pomegranate in a buttery crust. This heavenly creation harmonizes rich cocoa with the vibrant burst of pomegranate, offering a luxurious and mesmerizing dessert experience.',
                'pastry',
                520,
                'jpeg'
                );

insert into promocodes(id, name, discount)
values (1, '24ForNew2024', 24),
        (2, 'Store15', 15);

