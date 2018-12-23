DROP TABLE IF EXISTS job;


CREATE TABLE job
(
  id    INTEGER PRIMARY KEY ,
  job   VARCHAR,
  type  VARCHAR NOT NULL,
  user_job VARCHAR,
  device VARCHAR NOT NULL,
  amount INTeger NOT NULL,
  time   TIMESTAMP DEFAULT NOW()

);


