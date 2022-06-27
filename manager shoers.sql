create database manage_shoers;
use manage_shoers;
CREATE TABLE account (
  id int auto_increment primary key,
  username varchar(255) DEFAULT NULL,
  password varchar(50) DEFAULT NULL,
  phone varchar(50) DEFAULT NULL,
  mail varchar(50) DEFAULT NULL,
  status varchar(50) DEFAULT NULL,
  role varchar(50) DEFAULT NULL,
  token varchar(255) DEFAULT NULL
) ;

CREATE TABLE product (
  id int auto_increment primary key,
  name varchar(255) DEFAULT NULL,
  type_id int DEFAULT NULL,
  brand_id int DEFAULT NULL,
  size varchar(50) DEFAULT NULL,
  color varchar(50) DEFAULT NULL,
  img_url varchar(255) DEFAULT NULL,
  status varchar(50) DEFAULT NULL

) ;

CREATE TABLE brand (
  id int auto_increment primary key,
  name varchar(255) DEFAULT NULL,
  status varchar(50) DEFAULT NULL

) ;

CREATE TABLE shoers_type (
  id int auto_increment primary key,
  name varchar(255) DEFAULT NULL,
  status varchar(50) DEFAULT NULL

) ;
