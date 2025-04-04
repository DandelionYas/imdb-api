-- Create empty schema for light startup
CREATE SCHEMA IF NOT EXISTS imdb;
SET SCHEMA imdb;

CREATE TABLE IF NOT EXISTS crew(
    tconst    VARCHAR(15) PRIMARY KEY,
    directors VARCHAR(6000),
    writers VARCHAR(50000));

CREATE TABLE IF NOT EXISTS person(
    nconst VARCHAR(15) PRIMARY KEY,
    primaryName VARCHAR(200),
    birthYear VARCHAR(20),
    deathYear VARCHAR(20),
    primaryProfession VARCHAR(500),
    knownForTitles VARCHAR(1000));

CREATE TABLE IF NOT EXISTS title(
    tconst VARCHAR(15) PRIMARY KEY,
    titleType VARCHAR(25),
    primaryTitle VARCHAR(1000),
    originalTitle VARCHAR(1000),
    isAdult VARCHAR(128),
    startYear VARCHAR(255),
    endYear VARCHAR(255),
    runtimeMinutes VARCHAR(128),
    genres VARCHAR(500));

CREATE TABLE IF NOT EXISTS rating(
    tconst VARCHAR(15) PRIMARY KEY,
    averageRating FLOAT,
    numVotes INT);

CREATE TABLE IF NOT EXISTS principal(
    tconst VARCHAR(15),
    ordering INT PRIMARY KEY,
    nconst VARCHAR(15),
    category VARCHAR(50),
    job VARCHAR(300),
    characters VARCHAR(1500));

-- Uncomment the following line to dump the DB schema
-- SCRIPT SIMPLE TO 'dump.txt';