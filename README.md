# RESTful APIs for IMDB dataset

## Import dataset into the application
### Prerequisites
Create a new folder named "datasets" in the root of the project and copy all .tsv files into it:
```shell
cd path/to/root
mkdir datasets
cp path/to/tsv-files/*.tsv path/to/root/datasets/
```
And Empty schema added in src/main/resources/schema.sql to have the feature of working without any data. 
So, you need to remove this file if you want to import real data.
```shell
rm path/to/root/src/main/resources/schema.sql
```

### Choosing best import approach
Based on [Stackoverflow](https://stackoverflow.com/questions/72505609/how-to-import-huge-tsv-file-into-h2-in-memory-database-with-spring-boot) and [H2 DB Documentation](https://www.h2database.com/html/functions.html#csvread),
 we can use CSVREAD() to import the data first into a temporary table and then use the table in queries. Although CSVREAD() is mainly implemented for csv files, we can read tsv files by specifying *rowSeparator*:
```SQL
SELECT * FROM CSVREAD('./datasets/title.ratings.tsv', null, 'rowSeparator=' || CHAR(9));
```
Actually Documentation was outdated or wrong! 'rowSeparator' is not supported for CSVREAD. I checked the write method and noticed it's using 'fieldSeparator'. So, the correct command will be like this:
```SQL
SELECT * FROM CSVREAD('./datasets/title.ratings.tsv', null, 'fieldSeparator=' || CHAR(9));
```

I used fast import approach as mentioned in [H2 DB Documentation](https://h2database.com/html/performance.html#fast_import)
```SQL
CREATE TABLE(...) ... AS SELECT ... is faster than CREATE TABLE(...); INSERT INTO ... SELECT ...
```

## API Documentation
You can access OpenAPI documentation through the following link:
```thymeleafurlexpressions
http://localhost:8080/swagger-ui/index.html
```