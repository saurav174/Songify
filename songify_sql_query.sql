create table if not exists user
( userid varchar(200) Primary key unique not null,
  user_name varchar(100) not null,
  email varchar(100) not null,
  password varchar(100) not null,
  phone_number varchar(12),
  role varchar(20));
  create table if not exists singer
( singerid varchar(200) Primary key unique not null,
  singer_name varchar(100) not null,
  singer_song varchar(100) not null);
create table if not exists movies
( movieid varchar(200) Primary key unique not null,
  movie_name varchar(100) not null,
  movie_song varchar(100) not null);
create table if not exists album
( albumid varchar(200) Primary key unique not null,
  album_name varchar(100) not null,
  album_song varchar(100) not null);
  
  create table if not exists genere
( genreid varchar(200) Primary key unique not null,
  genre_name varchar(100) not null,
  genre_song varchar(100) not null);
  create table if not exists song
( songid varchar(200) Primary key unique not null,
  song_name varchar(100) not null,
  song_location varchar(100) not null);