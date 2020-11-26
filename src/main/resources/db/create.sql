SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS  heroes (
id int PRIMARY KEY auto_increment,
name VARCHAR,
power VARCHAR,
weakness VARCHAR,
age int,
squadId int);

CREATE TABLE IF NOT EXISTS  squads (
id int PRIMARY KEY auto_increment,
squadName VARCHAR,
cause VARCHAR,
max_size int
);