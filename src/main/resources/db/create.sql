SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS hero (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  age int,
  power varchar,
  weakness varchar,
  squad INTEGER
);

CREATE TABLE IF NOT EXISTS squad (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  cause varchar,
  max_size int,
);