CREATE TABLE recipes (
  id SERIAL,
  title VARCHAR(50),
  making_time VARCHAR(50),
  serves VARCHAR(50),
  ingredients VARCHAR(255),
  cost integer,
  created_at timestamp,
  updated_at timestamp
);