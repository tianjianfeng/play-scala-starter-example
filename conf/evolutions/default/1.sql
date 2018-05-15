# --- !Ups

CREATE TABLE "organiser" (
    id SERIAL primary key,
    name varchar(255) NOT NULL unique,
    "createdAt" timestamp not null DEFAULT current_timestamp
);



# --- !Downs

drop table if exists "organiser" ;

drop table if exists "venue" ;
