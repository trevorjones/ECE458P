CREATE DATABASE IF NOT EXISTS e_voting;

DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Candidates;

CREATE TABLE Users (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name CHAR(30) NOT NULL,
  pass CHAR(64) NOT NULL, #FOR SHA256 HASH
  voted BOOLEAN NOT NULL DEFAULT false,
  PRIMARY KEY (id)
);

CREATE TABLE Candidates (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name CHAR(30) NOT NULL,
  num_votes BIGINT NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
);