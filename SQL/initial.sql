CREATE TABLE Animal(
        AnimalId SERIAL PRIMARY KEY  ,
        AnimalName VARCHAR(20) NOT NULL  ,
        AnimalSpeed INTEGER NOT NULL ,
        AnimalPower INTEGER NOT NULL ,
        Winner BOOLEAN DEFAULT FALSE
    );