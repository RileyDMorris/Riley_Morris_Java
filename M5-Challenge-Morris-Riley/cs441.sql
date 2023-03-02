CREATE TABLE Dish (
name CHAR(11) NOT NULL,
Popularity INT,
Flavor CHAR(20),
RestaurantName CHAR(255),
PRIMARY KEY (name, RestaurantName),
FOREIGN KEY (RestaurantName) REFERENCES Restaurant RestaurantName,
ON DELETE CASCADE);

CREATE TABLE Restaurant (
RestaurantName CHAR(255) NOT NULL,
Type CHAR(255),
Size INT,
Address CHAR(255),
PRIMARY KEY (RestaurantName, Address),
FOREIGN KEY (Address) REFERENCES Building Address,
ON DELETE CASCADE);

CREATE TABLE Building (
Address CHAR(255) NOT NULL,
Area INT,
PRIMARY KEY (Address))

CREATE TABLE Chef (
SSN CHAR(11) NOT NULL,
Name CHAR(255),
Salary INT,
RestaurantName CHAR(255),
PRIMARY KEY (SSN),
FOREIGN KEY (RestaurantName) REFERENCES Restaurant RestaurantName);

CREATE TABLE Customer (
ID INT NOT NULL,
Name CHAR(255),
Birthday DATE,
PRIMARY KEY (ID));

CREATE TABLE Orders (
Name CHAR(255) NOT NULL,
ID INT,
Date DATE,
PRIMARY KEY (Name, ID),
FOREIGN KEY (Name) REFERENCES Dish Name,
FOREIGN KEY (ID) REFERENCES Customer ID);

CREATE TABLE CookedBy (
Name CHAR(255) NOT NULL,
SSN INT,
PRIMARY KEY (Name, SSN),
FOREIGN KEY (Name) REFERENCES Dish Name,
FOREIGN KEY (SSN) REFERENCES Chef SSN);