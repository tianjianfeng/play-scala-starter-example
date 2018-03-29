# --- !Ups

CREATE TABLE "organiser" (
    "id" bigint(20) NOT NULL AUTO_INCREMENT,
    "name" varchar(255) NOT NULL,
    "createdAt" timestamp not null DEFAULT current_timestamp,
    PRIMARY KEY ("id")
);

--CREATE TABLE "venue" (
--    "id" bigint(20) NOT NULL AUTO_INCREMENT,
--    "name" varchar(255) NOT NULL,
--    "organiserId" bigint references "organiser"("id"),
--    PRIMARY KEY ("id")
--);


# --- !Downs

drop table "organiser" if exists;

drop table "venue" if exists;
