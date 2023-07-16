create database Player_DB;

use Player_DB;

create table Team
(
team_Id int primary key ,
team_name varchar(6) not null 
);

insert into Team (team_Id , team_name)
values (1,"CSK");

insert into Team (team_Id , team_name)
values (2,"RCB");

insert into Team (team_Id , team_name)
values (3,"MI");

insert into Team (team_Id , team_name)
values (4,"RR");

insert into Team (team_Id , team_name)
values (5,"SRH");

insert into Team (team_Id , team_name)
values (6,"KKR");


create table player
(
 player_no int  primary key auto_increment ,
 player_name varchar(20) not null ,
 categeory varchar(20) not null ,
 highest_score int not null,
 best_figures varchar(10)
);

create table Team_Player
(
 player_no int not null,
 team_id int not null,
 foreign key (player_no)  references player(player_no) ,
 foreign key (team_id ) references Team(team_Id)
);


DELIMITER # 
CREATE PROCEDURE getplayers(team_name varchar(6))
BEGIN 
	select player.player_name , player.categeory
    from player inner join Team_Player on(player.player_no = Team_Player.player_no)
    inner join Team on(Team_Player.team_id = Team.team_Id ) where Team.team_name = team_name order by player.player_name;
    END #
DELIMITER ;

CALL getplayers('CSK');



