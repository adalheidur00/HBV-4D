CREATE TABLE IF NOT EXISTS Users (
    id INTEGER PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    phoneNumber TEXT NOT NULL,
);

CREATE TABLE IF NOT EXISTS Tours (
    id INTEGER PRIMARY KEY,
    tourName TEXT ,
    description TEXT ,
    price INT,
    date TEXT,
    city TEXT,
    schedule TEXT,
    availability int,
    reviewId INTEGER REFERENCES Reviews(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Reviews (
    id INTEGER PRIMARY KEY,
    userId INTEGER REFERENCES Users(id) ON DELETE CASCADE,
    firstName TEXT REFERENCES Users(name) ON DELETE CASCADE,
    tourId INT REFERENCES Tours(id) ON DELETE CASCADE,
    rating INTEGER,
    comment TEXT
);


INSERT INTO Users (name, email, phoneNumber) VALUES ('Alla', 'alla@hi.is', '1234567')

INSERT INTO Tours (id, tourName, description, price, date, city, schedule, availability)
VALUES
(1, 'Scenic Mountain Hike', 'A beautiful hike through the mountains.', 9000, '2025-05-20', 'Reykjavik', '10:00 AM', 20),
(2, 'Northern Lights Tour', 'Experience the magic of the Aurora Borealis.', 18000, '2025-12-15', 'Akureyri', '9:00 PM', 10),
(3, 'Golden Circle Tour', 'See geysers, waterfalls, and historic sites.', 35000, '2025-07-10', 'Thingvellir', '8:00 AM', 30);

INSERT INTO Reviews (id, userId, firstName, tourId, rating, comment)
VALUES
(1, 101, 'Embla', 1, 5, 'Amazing experience, loved every moment!'),
(2, 102, 'Guðný', 1, 4, 'Great views, but the hike was a bit tough.'),
(3, 103, 'Guðrún', 2, 5, 'Northern Lights were breathtaking!'),
(4, 104, 'Valbjörn', 3, 3, 'The tour was okay, but a bit overpriced.');

UPDATE Tours SET reviewId = 1 WHERE id = 1;
UPDATE Tours SET reviewId = 3 WHERE id = 2;
UPDATE Tours SET reviewId = 4 WHERE id = 3;
