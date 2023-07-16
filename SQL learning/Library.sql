create database librarydb ;
use librarydb;

create table author 
(
id varchar(10) primary key,
name varchar(20) not null ,
gender varchar(10) not null ,
age int not null
);

create table book
(
id varchar(10) primary key,
name varchar(20) not null ,
price int not null,
language varchar(20) not null
);

create table library
(
id varchar(10) primary key ,
name varchar(20) not null 
);

create table book_author
(
bookId varchar(10) not null,
authorId varchar(10) not null,
foreign key (bookId ) references book(id),
foreign key (authorId) references author(id)
);

create table library_book
(
libId varchar(10) not null ,
bookId varchar(10) not null,
foreign key (libId) references library(id),
foreign key (bookId ) references book(id)
);

insert into author (id , name , gender , age ) 
values ('auth1','Chethan Bhaghat','Male',37);

insert into author (id , name , gender , age ) 
values ('auth2','Arundhati Roy','Female',45);

insert into author (id , name , gender , age ) 
values ('auth3','Jumpa lahiri','Female',40);

insert into author (id , name , gender , age ) 
values ('auth4','Vikram Seth','Male',50);

insert into book (id, name ,price , language)
values ('book1', '2states' , 600 , 'English') ;

 insert into book (id, name ,price , language)
values ('book2', 'small things' , 700 , 'Tamil') ;

insert into book (id, name ,price , language)
values ('book3', 'suitable boy' , 750 , 'Telugu') ;

insert into book (id, name ,price , language)
values ('book4', 'Maladies' , 840 , 'Hindi') ;

insert into library (id , name)
values ('lib1' , 'congress');

insert into library (id , name)
values ('lib2' , 'vatican');

insert into library (id , name)
values ('lib3' , 'national');

insert into library (id , name)
values ('lib4' , 'bodleian');

insert into book_author (bookId ,authorId )
values ('book1' , 'auth1');

insert into book_author (bookId ,authorId )
values ('book1' , 'auth3');

insert into book_author (bookId ,authorId )
values ('book2' , 'auth2');

insert into book_author (bookId ,authorId )
values ('book2' , 'auth4');

insert into book_author (bookId ,authorId )
values ('book3' , 'auth3');

insert into book_author (bookId ,authorId )
values ('book3' , 'auth2');

insert into book_author (bookId ,authorId )
values ('book4' , 'auth4');

insert into book_author (bookId ,authorId )
values ('book4' , 'auth1');

insert into library_book (libId ,bookId ) 
values ('lib1' , 'book2');

insert into library_book (libId ,bookId ) 
values ('lib1' , 'book3');

insert into library_book (libId ,bookId ) 
values ('lib2' , 'book2');

insert into library_book (libId ,bookId ) 
values ('lib2' , 'book1');

insert into library_book (libId ,bookId ) 
values ('lib3' , 'book3');

insert into library_book (libId ,bookId ) 
values ('lib3' , 'book4');

insert into library_book (libId ,bookId ) 
values ('lib4' , 'book1');

insert into library_book (libId ,bookId ) 
values ('lib4' , 'book3');

-- query 1 (a)

select distinct library.name 
from library inner join library_book on (library.id = library_book.libId )
inner join book_author on (library_book.bookId = book_author.bookId ) 
where book_author.authorId = 'auth1';

-- query 1 (b)

select distinct book.name
from book inner join library_book on (book.id = library_book.bookId )
where library_book.libId in
(select library_book.libId 
from library_book inner join book_author on (library_book.bookId = book_author.bookId) 
where book_author.authorId = 'auth1');


-- query 2
select book.name 
from book inner join book_author on (book_author.bookId = book.id) 
inner join author on (author.id = book_author.authorId ) where author.age <= all (select age from author);

-- query 3

select distinct book.name
from book inner join library_book on (book.id = library_book.bookId )
where book.language = 'Telugu' and library_book.libId = 'lib1';

-- query 4(a)

select distinct book.name 
from book inner join library_book on (book.id = library_book.bookId ) 
where book.price <= all( select price from book);


-- query 4(b)

select distinct book.name 
from book inner join library_book on (book.id = library_book.bookId ) 
where book.price >= all( select price from book);


