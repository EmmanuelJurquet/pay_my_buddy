CREATE DATABASE pay_my_buddy;

use pay_my_buddy;
CREATE TABLE identification (

id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,

email VARCHAR(255) NOT NULL UNIQUE,

password VARCHAR(100)
;


CREATE TABLE User_Profile (

user_Id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,


firstname VARCHAR(100) NOT NULL ,

lastName VARCHAR (100) NOT NULL,

birthdate DATE (20) NOT NULL,

address VARCHAR (255) NOT NULL,

phone VARCHAR (100) NOT NULL, 

city VARCHAR (255) NOT NULL, 

zip VARCHAR (255) NOT NULL,

FOREIGN KEY (identification)
 REFERENCES id(identification)
)
;


CREATE DATABASE pay_my_buddy_Tests;

use pay_my_buddy_tests;


CREATE TABLE identification (

id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,

email VARCHAR(255) NOT NULL UNIQUE,

password VARCHAR(100)
;


CREATE TABLE User_Profile (

user_Id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
FOREIGN KEY (identification)
 REFERENCES id(identification));

firstname VARCHAR(100) NOT NULL ,

lastName VARCHAR (100) NOT NULL,

birthdate DATE (20) NOT NULL,

address VARCHAR (255) NOT NULL,

phone VARCHAR (100) NOT NULL, 

city VARCHAR (255) NOT NULL, 

zip VARCHAR (255) NOT NULL
)
;

