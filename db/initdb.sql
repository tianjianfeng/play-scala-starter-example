CREATE ROLE tianjianfeng login;
ALTER ROLE tianjianfeng WITH PASSWORD 'password';

CREATE DATABASE "activity" OWNER tianjianfeng;
