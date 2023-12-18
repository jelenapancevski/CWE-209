insert into users(id, username, password, usertype)
values (1, 'bruce', 'wayne', 'user'),
       (2, 'peter', 'security_rules', 'user'),
       (3, 'tom', 'guessmeifyoucan', 'user'),
       (4, 'admin', 'admin', 'admin');


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
        'jpeg');



