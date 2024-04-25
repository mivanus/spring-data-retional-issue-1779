https://github.com/spring-projects/spring-data-relational/issues/1779

In some cases select statement contains duplicate key columns which causes BadSqlGrammarException when "order by" gets included in sql.