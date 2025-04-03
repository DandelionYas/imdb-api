CREATE SCHEMA IF NOT EXISTS imdb;
SET SCHEMA imdb;

-- Create Tables and Fetch data
CREATE TABLE title_crew(
    tconst    VARCHAR(15),
    directors VARCHAR(6000),
    writers VARCHAR(50000))
AS SELECT * FROM CSVREAD('classpath:/datasets/title.crew.tsv',  null, 'fieldSeparator=' || CHAR (9));