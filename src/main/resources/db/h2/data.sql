insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_USER');

insert into user (username, password, enabled) values ('a', '$2a$10$gdxoLLOHQLj0QnOMwptrROXiVmXb7PA/NeH3OBHSScsOeslVzemNm', 1);
insert into user (username, password, enabled) values ('b', '$2a$10$5vL6I288nyK5992/iH2mPuGUl5yZGEYpkpc77ClZIEaCb1yfmozeG', 1);

insert into user_role values('1', '1');
insert into user_role values('1', '2');
insert into user_role values('2', '1');