# RESTful APIs for IMDB dataset

## Import dataset into the application
Based on [Stackoverflow](https://stackoverflow.com/questions/72505609/how-to-import-huge-tsv-file-into-h2-in-memory-database-with-spring-boot) and [H2 DB Documentation](https://www.h2database.com/html/functions.html#csvread),
 we can use CSVREAD() to import the data first into a temporary table and then use the table in queries. Although CSVREAD() is mainly implemented for csv files, we can read tsv files by specifying *rowSeparator*:
```SQL
SELECT * FROM CSVREAD('data/test.tsv', null, 'rowSeparator=' || CHAR(9));
```