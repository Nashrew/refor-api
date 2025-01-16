DROP TABLE IF EXISTS "reforestations";

CREATE TABLE IF NOT EXISTS "reforestations" (
    "id" VARCHAR(60) DEFAULT RANDOM_UUID() PRIMARY KEY,
    "name" VARCHAR NOT NULL,
    "currentPercentage" DECIMAL(5, 2),
    "targetPercentage" DECIMAL(5, 2)
);