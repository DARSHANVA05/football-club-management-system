create table club (
club_id bigint not null auto_increment, 
club_name varchar(255), 
country varchar(255), 
stadium varchar(255), 
primary key (club_id));

create table players (
player_id bigint not null auto_increment, 
first_name varchar(255), 
last_name varchar(255), 
nationality varchar(255), 
team_name varchar(255), 
jersey_number varchar(255), 
position varchar(255), 
club_id bigint, 
primary key (player_id),
FOREIGN KEY (club_id) REFERENCES club(club_id) on delete cascade);

create table coaches (
coach_id bigint not null auto_increment, 
first_name varchar(255), 
last_name varchar(255), 
nationality varchar(255), 
designation varchar(255), 
team_name varchar(255), 
club_id bigint, 
primary key (coach_id),
FOREIGN KEY (club_id) REFERENCES club(club_id) on delete cascade);

create table fixtures(
sl_no long,
home_Team varchar(255),
away_team varchar(255),
match_date date,
match_time time,
stadium varchar(255)
);

use team;
drop table club;
drop table coaches;
drop table players;

insert into club values (01,"MCFC","England","Etihad Stadium");
commit;

insert into club values (1,"Manchester City FC","England","Etihad Stadium");
insert into club values (2,"Liverpool FC","England","Anfield");
insert into club values (3,"Tottenham Hotspur FC","England","Tottenham Hotspur Stadium");
insert into club values (4,"Arsenal FC","England","Emirates Stadium");
insert into club values (5,"Aston Villa FC","England","Villa Park");
insert into club values (6,"Chelsea FC","England","Stamford Bridge");
insert into club values (7,"Manchester United FC","England","Old Trafford");
insert into club values (8,"Newcastle United FC","England","St.James' Park");

insert into fixtures value(1,"Manchester City FC","Liverpool FC","25-02-2024","05:00","Etihad Stadium");
insert into fixtures value(2,"Tottenham Hotspur","Arsenal FC","25-02-2024","10:00","Tottenham Hotspur Stadium");
insert into fixtures value(3,"Aston Villa FC","Chelsea FC","26-02-2024","10:00","Villa Park");
insert into fixtures value(4,"Manchester United FC","Newcastle United FC","26-02-2024","05:00","Old Trafford");
insert into fixtures value(5,"Liverpool FC","Tottenham Hotspur FC","27-02-2024","07:00","Anfield");
insert into fixtures value(6,"Arsenal FC","Aston Villa FC","27-02-2024","10:00","Emirates Stadium");
insert into fixtures value(7,"Chelsea FC","Manchester United FC","28-02-2024","05:00","Stamford Bridge");
insert into fixtures value(8,"Newcastle United FC","Manchester United FC","28-02-2024","09:00","Anfield");
insert into fixtures value(9,"Manchester City FC","Tottenham Hotspur FC","29-02-2024","07:00","Etihad Stadium");
insert into fixtures value(10,"Liverpool FC","Arsenal FC","29-02-2024","10:00","Anfield");
insert into fixtures value(11,"Tottenham Hotspur FC","Aston Villa FC","01-03-2024","07:00","Tottenham Hotspur");
insert into fixtures value(12,"Arsenal FC","Chelsea FC","01-03-2024","07:00","Emirates Stadium");
insert into fixtures value(13,"Aston Villa FC","Manchester United FC	","02-03-2024","05:00","Villa Park");
insert into fixtures value(14,"Chelsea FC","Newcastle United FC","02-03-2024","09:00","Stamford Bridge");
insert into fixtures value(15,"Manchester United FC","Manchester City FC","03-03-2024","07:00","Old Trafford");
insert into fixtures value(16,"Manchester City FC","Arsenal FC","03-03-2024","10:00","Etihad Stadium");
insert into fixtures value(17,"Liverpool FC","Aston Villa FC","04-03-2024","05:00","Anfield");
insert into fixtures value(18,"Tottenham Hotspur FC","Chelsea FC","04-03-2024","09:00","Tottenham Hotspur");
insert into fixtures value(19,"Arsenal FC","Manchester United FC","05-03-2024","07:00","Emirates Stadium");
insert into fixtures value(20,"Aston Villa FC","Newcastle United FC","05-03-2024","10:00","Villa Park");
insert into fixtures value(21,"Chelsea FC","Manchester City FC","06-03-2024","07:00","Stamford Bridge");
insert into fixtures value(22,"Manchester United FC","Liverpool FC","06-03-2024","10:00","Tottenham Hotspur");
insert into fixtures value(23,"Newcastle United FC","Tottenham Hotspur FC","07-03-2024","07:00","St. James' Park");