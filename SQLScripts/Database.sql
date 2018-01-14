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
CREATE TABLE Movie (
	MovieId int NOT NULL PRIMARY KEY,
	MovieTitle varchar(60) NOT NULL,
	Genre varchar(20) NOT NULL,
	Language varchar(2) NOT NULL,
	PgRating varchar(3) NOT NULL,
	Playtime varchar(4) NOT NULL
);
CREATE TABLE Series (
	SeriesId int NOT NULL PRIMARY KEY,
	SeriesTitle varchar(50) NOT NULL,
	Genre varchar(20) NOT NULL,
	Language varchar(2) NOT NULL,
	PgRating varchar(3) NOT NULL,
);
CREATE TABLE Episode (
	EpisodeId int NOT NULL PRIMARY KEY,
	FollowNumber varchar(7) NOT NULL,
	SeriesId int NOT NULL,
	EpisodeTitle varchar(20) NOT NULL,
	Playtime varchar(4) NOT NULL,

	CONSTRAINT EpisodeFK
		FOREIGN KEY (SeriesId) 
		REFERENCES Series(SeriesId)
			ON DELETE CASCADE
);
CREATE TABLE WatchedSeries(
	WatchedId int NOT NULL PRIMARY KEY,
	ProfileId int NOT NULL,
	EpisodeId int NOT NULL,
	Percentage int NOT NULL,
	FOREIGN KEY(EpisodeId) REFERENCES Episode(EpisodeId),

	CONSTRAINT WatchedSeriesFK
		FOREIGN KEY(ProfileId) 
		REFERENCES Profile(ProfileId)
			ON DELETE CASCADE
);
CREATE TABLE WatchedMovies(
	WatchedId int NOT NULL PRIMARY KEY,
	ProfileId int NOT NULL,
	MovieId int NOT NULL,
	Percentage int NOT NULL,
	FOREIGN KEY(MovieId) REFERENCES Movie(MovieId),

	CONSTRAINT WatchedMoviesFK
		FOREIGN KEY(ProfileId) 
		REFERENCES Profile(ProfileId)
			ON DELETE CASCADE
);