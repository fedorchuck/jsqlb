# JSQLB (Java SQL Builder) is a little Java library for dynamically generating SQL 

[![Build Status](https://travis-ci.org/fedorchuck/jsqlb.svg?branch=master)](https://travis-ci.org/fedorchuck/jsqlb)
[![Apache License Version 2.0](https://img.shields.io/badge/license-Apache%20License%202.0-brightgreen.svg)](https://github.com/fedorchuck/jsqlb/blob/master/LICENSE.md)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.fedorchuck/jsqlb/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.fedorchuck/jsqlb)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/1ba5d5716baf47b498e14d0dee661404)](https://www.codacy.com/app/vl.fedorchuck/jsqlb?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=fedorchuck/jsqlb&amp;utm_campaign=Badge_Grade)
[![Codacy Badge](https://api.codacy.com/project/badge/Coverage/1ba5d5716baf47b498e14d0dee661404)](https://www.codacy.com/app/vl.fedorchuck/jsqlb?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=fedorchuck/jsqlb&amp;utm_campaign=Badge_Coverage)

SQL:
```sql
INSERT INTO table1 ( column1, column3, column4, column5 ) VALUES ( ?, ?, ?, ? ) RETURNING * 
```
JSQLB:
```groovy
new PostgreSQL().insert(table1, table1.getColumnsExcept(table1.getColumn("column2"))).returning().getSQL()
```

Another methods you can find in [test](https://github.com/fedorchuck/jsqlb/blob/master/src/test/java/com/github/fedorchuck/jsqlb/postgresql/PostgreSQL_CRUD_Test.java)
, and/or in [this](https://github.com/fedorchuck/remote-logger/blob/master/src/main/java/com/github/fedorchuck/remote_logger/dal/UsersDataDatabase.java) project.

