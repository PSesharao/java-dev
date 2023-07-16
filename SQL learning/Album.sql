create database AlbumDB;
use AlbumDB;
create table album
(
id varchar(20) primary key ,
name varchar(20) not null ,
price int not null,
rating float not null
);

create table song
(
id varchar(20) primary key ,
name varchar(20) not null ,
likes int not null,
language varchar(20) not null 
);


create table album_song
(
albumId varchar(20) not null,
songId varchar(20)  not null,
foreign key (albumId) references album(id) ,
foreign key (songId) references song(id) 
);

create table artist
(
id varchar(20) primary key ,
name varchar(20) not null ,
gender varchar(20) not null ,
age int not null
);

create table song_artist
(
songId varchar(20) not null ,
artistId varchar(20) not null ,
foreign key (artistId) references artist(id) ,
foreign key (songId) references song(id) 
);

insert into artist (id , name , gender , age ) values
('art1','spbalu','Male',64); 

insert into artist (id , name , gender , age ) values
('art2','jesudasu','Male',65); 

insert into artist (id , name , gender , age ) values
('art3','chitra','Female',55); 

insert into artist (id , name , gender , age ) values
('art4','spsailaja','Female',55);


select * from artist;

 insert into song (id ,name ,likes , language ) values 
 ('song1','samajavaragamana',50000,'telugu');


insert into song (id ,name ,likes , language ) values 
 ('song2','buttabomma',40000,'telugu');
  
 insert into song (id ,name ,likes , language ) values 
 ('song3','ankein mein',30000,'hindi');
 
 insert into song (id ,name ,likes , language ) values 
 ('song4','senorita',20000,'german');
 
 select * from song;
 
 
insert into album (id ,name , price , rating )
 values ('album1','melody',1000,4.8);

insert into album (id ,name , price , rating )
 values ('album2','romance',800, 4.5);
 
insert into album (id ,name , price , rating )
values ('album3','jazz',750,3.5);
 
insert into album (id ,name , price , rating )
values ('album4','rock',500,3.0);

insert into album (id ,name , price , rating )
values ('album5','disco', 750 , 2.8);
 
select * from album;

insert into song_artist (songId ,artistId )
values ('song1','art1');

insert into song_artist (songId ,artistId )
values ('song1','art2');

insert into song_artist (songId ,artistId )
values ('song2','art3');

insert into song_artist (songId ,artistId )
values ('song2','art1');

insert into song_artist (songId ,artistId )
values ('song3','art2');
 
 insert into song_artist (songId ,artistId )
values ('song3','art4');

insert into song_artist (songId ,artistId )
values ('song4','art1');

insert into song_artist (songId ,artistId )
values ('song4','art2');

insert into album_song (albumId ,songId )
values ('album1','song1');
 
insert into album_song (albumId ,songId )
values ('album1','song3');

insert into album_song (albumId ,songId )
values ('album2','song4');

insert into album_song (albumId ,songId )
values ('album2','song1');

insert into album_song (albumId ,songId )
values ('album3','song1');

insert into album_song (albumId ,songId )
values ('album3','song2');

insert into album_song (albumId ,songId )
values ('album4','song3');

insert into album_song (albumId ,songId )
values ('album4','song2');


-- query 1
select song.name 
from song_artist inner join song on(song_artist.songId = song.id)
where song_artist.artistId = 'art1';

-- query 2 
select album.name 
from album inner join album_song on (album.id = album_song .albumId ) 
inner join song_artist on (song_artist.songId = album_song.songId)
where song_artist.artistId = 'art1' and album.price >= all (select album .price from album);

-- query 3

select count(distinct language)
from song inner join song_artist on(song.id = song_artist.songId )
where song_artist.artistId = 'art1';

-- query 4

select album.name 
from album 
order by  price,rating ;

-- query 5

 select album.name 
from album 
order by name desc;

-- stored procedure 

DELIMITER #

CREATE PROCEDURE GetAllsongs()

BEGIN
	SELECT song.name  FROM song;
END #

DELIMITER ;

CALL GetAllsongs();





