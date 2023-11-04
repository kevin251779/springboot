-- DDL
-- User table
CREATE TABLE user (
    userid INT NOT NULL AUTO_INCREMENT,
    username NVARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    account VARCHAR(50) NOT NULL,
    password VARCHAR(255);
    PRIMARY KEY (userid)	
);

--Product table
CREATE TABLE product (
    no INT NOT NULL AUTO_INCREMENT, 
    productname NVARCHAR(255) NOT NULL, 
    price INT NOT NULL,
    feerate DECIMAL(4, 2) NOT NULL,
    PRIMARY KEY (no)
);

--Like List table
CREATE TABLE likelist (
    sn INT NOT NULL AUTO_INCREMENT,
    ordername INT NOT NULL, 
    account VARCHAR(50) NOT NULL, 
    totalfee INT NOT NULL, 
    totalamount INT NOT NULL,
    PRIMARY KEY (sn)
);




