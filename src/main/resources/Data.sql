CREATE DATABASE pay_my_buddy;

use pay_my_buddy;
CREATE TABLE identification (

id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,

userEmail VARCHAR(255) NOT NULL UNIQUE,

userPassword VARCHAR(100)
;
INSERT INTO identification (`userEmail`, `userPassword`) values ('emmanueljurquet@gmail.com, nouveaumotdepasse');
INSERT INTO identification (`userEmail`, `userPassword`) values ('hanna@gmail.com');
CREATE TABLE User_Profile (

id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,

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
INSERT INTO User_Profile (`firstname`, `lastname`, `birthdate`,`address`, `phone`, `city`, `zip`) values ('Emmanuel',' Jurquet',16/03/1979,'10 rue of nowhere',' 07-58-65-98','Paris', '75000');
INSERT INTO User_Profile (`firstname`, `lastname`, `birthdate`,`address`, `phone`, `city`, `zip`) values ('Audrey', 'Guillet',10/04/1979,'10 rue of nowhere', '07-58-55-84','Paris', '75000');
CREATE DATABASE pay_my_buddy_Tests;

use pay_my_buddy_tests;


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
 REFERENCES id(identification));


