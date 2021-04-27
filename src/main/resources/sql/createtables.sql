-- create table ingredients(
--   ingredientid int unsigned not null auto_increment primary key,
--   ingredientname varchar(32) not null unique key,
--   ingredientdescription varchar(255) null,
--   ingredienttype enum('grain', 'meat') not null,
--   ingredientrecipeid null,
-- );

-- create table recipeingredients(
--   recipeid int unsigned not null,
--   ingredientline int unsigned not null,
--   ingredientid int unsigned not null auto_increment primary key,
--   qty varchar(10) not null, 
--   uom varchar(10) not null,
--   instruction varchar(32) null,
--   constraint unique key recipeingredient (recipeid, ingredientid),
--   constraint unique key recipeingredientline (recipeid, ingredientline)
-- );

-- create table recipes(
--   recipeid int unsigned not null auto_increment primary key,
--   title varchar(64) not null,
--   version varchar(10) null,
--   author varchar(32) null default 'Anthony Redmond',
--   serveqty int null,
--   serveqtytype enum('people', 'adults', 'children', 'infants') null,
--   preptime int null,
--   cooktime int null,
--   portion varchar(10) null,
--   portionuom varchar(10),
--   constraint unique key recipetitleandauthor(title, version, author)
-- );

insert recipes (title, version, author, serveqty, preptime, cooktime, 
               portion, portionuom)
values('Char Siu Sauce', 1, 'Anthony Redmond', null, null, null, null, null);
-- returning titleid; 

set @recipeid = 1;

insert ingredients(ingredientname)
values('Chinese fermented red bean curd'),
('maltose or honey'),
( 'Chinese Shaoxing wine'),
('soy sauce'),
('oyster sauce'),
('dark and thick soy sauce'),
('five-spice powder'),
('white pepper powder'),
('sugar');

insert recipeingredients(recipeid, ingredientline, qty, uom, ingredientid)
values(@recipeid, 1, '2', 'pieces', (select ingredientid from ingredients where ingredientname ='Chinese fermented red bean curd')),
(@recipeid, 2, '1', 'tablespoon', (select ingredientid from ingredients where ingredientname ='maltose or honey')),
(@recipeid, 3, '1', 'tablespoon', (select ingredientid from ingredients where ingredientname ='Chinese Shaoxing wine')),
(@recipeid, 4, '1', 'tablespoon', (select ingredientid from ingredients where ingredientname ='soy sauce')),
(@recipeid, 5, '1', 'tablespoon', (select ingredientid from ingredients where ingredientname ='oyster sauce')),
(@recipeid, 6, '1', 'teaspoon', (select ingredientid from ingredients where ingredientname ='dark and thick soy sauce')),
(@recipeid, 7, '1', 'teaspoon', (select ingredientid from ingredients where ingredientname ='five-spice powder')),
(@recipeid, 8, '1/4', 'teaspoon', (select ingredientid from ingredients where ingredientname ='white pepper powder')),
(@recipeid, 9, '3 1/25', 'oz', (select ingredientid from ingredients where ingredientname ='sugar'));

insert recipes(title, version, author, serveqty, preptime, cooktime, 
               portion, portionuom)
values('Pork Belly Char Siu ', 1, 'Anthony Redmond', 3, 15, 30, null, null);

set @recipeid = 2;

insert ingredients(ingredientname)
values('skinless pork belly'),
('garlic');

insert recipeingredients(recipeid, ingredientline, qty, uom, instruction, ingredientid)
values(@recipeid, 1, '1', 'lb', 'cut into 2 long strips', (select ingredientid from ingredients where ingredientname= 'skinless pork belly')),
(@recipeid, 2, '2', 'tablespoons', 'finely chopped', (select ingredientid from ingredients where ingredientname= 'garlic')),
(@recipeid, 3, '8', 'tablespoon', 'freshly made', (select ingredientid from ingredients where ingredientname= 'Char Siu Sauce'));
