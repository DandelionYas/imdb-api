CREATE SCHEMA IF NOT EXISTS imdb;
SET SCHEMA imdb;

-- Create Tables and Fetch data
CREATE TABLE crew(
    tconst    VARCHAR(15) PRIMARY KEY,
    directors VARCHAR(6000),
    writers VARCHAR(50000))
AS SELECT * FROM CSVREAD('./datasets/title.crew.tsv',  null, 'fieldSeparator=' || CHAR (9));

CREATE TABLE person(
    nconst VARCHAR(15) PRIMARY KEY,
    primaryName VARCHAR(200),
    birthYear VARCHAR(20),
    deathYear VARCHAR(20),
    primaryProfession VARCHAR(500),
    knownForTitles VARCHAR(1000))
AS SELECT * FROM CSVREAD('./datasets/name.basics.tsv',  null, 'fieldSeparator=' || CHAR (9));

CREATE TABLE title(
    tconst VARCHAR(15) PRIMARY KEY,
    titleType VARCHAR(25),
    primaryTitle VARCHAR(1000),
    originalTitle VARCHAR(1000),
    isAdult VARCHAR(128),
    startYear VARCHAR(255),
    endYear VARCHAR(255),
    runtimeMinutes VARCHAR(128),
    genres VARCHAR(500))
AS SELECT * FROM CSVREAD('./datasets/title.basics.tsv',  null, 'fieldSeparator=' || CHAR (9));

CREATE TABLE rating(
    tconst VARCHAR(15) PRIMARY KEY,
    averageRating FLOAT,
    numVotes INT)
AS SELECT * FROM CSVREAD('./datasets/title.ratings.tsv',  null, 'fieldSeparator=' || CHAR (9));

CREATE TABLE principal(
    tconst VARCHAR(15),
    ordering INT PRIMARY KEY,
    nconst VARCHAR(15),
    category VARCHAR(50),
    job VARCHAR(300),
    characters VARCHAR(1500))
AS SELECT * FROM CSVREAD('./datasets/title.principals.tsv',  null, 'fieldSeparator=' || CHAR (9));