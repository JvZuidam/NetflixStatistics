use master;
DROP DATABASE IF EXISTS NetflixStatistixs; 
CREATE DATABASE NetflixStatistixs;
GO
use NetflixStatistixs;

CREATE TABLE Account (
	AccountId int NOT NULL PRIMARY KEY,
	AccountName varchar(50) NOT NULL,
	Street varchar(50) NOT NULL,
	Zipcode varchar(6) NOT NULL,
	Adress varchar(4) NOT NULL,
	City varchar(50) NOT NULL,
);
CREATE TABLE Profile (
	ProfileId int NOT NULL PRIMARY KEY,
	ProfileName varchar(20) NOT NULL,
	Age int NOT NULL,
	AccountId int NOT NULL,

	CONSTRAINT ProfileFK
		FOREIGN KEY (AccountId) 
		REFERENCES Account(AccountId)
			ON DELETE CASCADE
);
CREATE TABLE Program (
	ProgramId int NOT NULL PRIMARY KEY,
	Title varchar(50) NOT NULL,
);
CREATE TABLE Watched(
	WatchedId int NOT NULL PRIMARY KEY,
	ProfileId int NOT NULL,
	ProgramId int NOT NULL,
	Percentage int NOT NULL,
	FOREIGN KEY(ProgramId) REFERENCES Program(ProgramId),

	CONSTRAINT WatchedFK
		FOREIGN KEY(ProfileId) 
		REFERENCES Profile(ProfileId)
			ON DELETE CASCADE
);
CREATE TABLE Movie (
	MovieId int NOT NULL PRIMARY KEY,
	Genre varchar(20) NOT NULL,
	Language varchar(2) NOT NULL,
	PgRating varchar(3) NOT NULL,
	ProgramId int NOT NULL,

	CONSTRAINT MovieFK
		FOREIGN KEY (ProgramId) 
		REFERENCES Program(ProgramId)
			ON DELETE CASCADE
);
CREATE TABLE Series (
	SeriesId int NOT NULL PRIMARY KEY,
	SeriesTitle varchar(50) NOT NULL,
	Genre varchar(20) NOT NULL,
	Language varchar(2) NOT NULL,
	PgRating varchar(3) NOT NULL,
	ProgramId int NOT NULL,

	CONSTRAINT SeriesFK
		FOREIGN KEY (ProgramId) 
		REFERENCES Program(ProgramId)
			ON DELETE CASCADE
);
CREATE TABLE Episode (
	EpisodeId int NOT Null PRIMARY KEY,
	FollowNumber varchar(7) NOT NULL,
	SeriesId int NOT NULL,
	EpisodeTitle varchar(20) NOT NULL,
	Playtime int NOT NULL,

	CONSTRAINT EpisodeFK
		FOREIGN KEY (SeriesId) 
		REFERENCES Series(SeriesId)
			ON DELETE CASCADE
);

INSERT INTO Account VALUES (1215426, 'Fam. van Raalte', 'Schopenhauerdijkje', '3991ML', '5', 'Houten')
INSERT INTO Profile VALUES (5, 'Frank', 18, 1215426)
INSERT INTO Program VALUES (10, 'Breaking Bad')
INSERT INTO Watched VALUES (1, 5, 10, 100)

SELECT * FROM Account;
SELECT * FROM Profile;
SELECT * FROM Program;
SELECT * FROM Watched;

DELETE FROM Account;

SELECT * FROM Account;
SELECT * FROM Profile;
SELECT * FROM Program;
SELECT * FROM Watched;