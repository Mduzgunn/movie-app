create table role(id int, name varchar(20));

create table languages(id int, name varchar(20));

create table type(id int, name varchar(20));




create table movies(id int AUTO_INCREMENT, name varchar(40), releaseYear int, genreId int, languageId int,
                    story varchar(200),
                    createdBy int,
                    createdTimestamp datetime, lastUpdtTimestamp datetime,
                    active varchar(1), base64Img varchar(255));


create table users(id int AUTO_INCREMENT, firstName varchar(30), lastName varchar(30), emailId varchar(30), password varchar(150), admin varchar(1),
                   createdTimestamp datetime, active varchar(1));