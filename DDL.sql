create schema projeto-topicosespeciais;

use projeto-topicosespeciais;

create user 'root'@'localhost' identified by 'root123';

grant select, insert, delete, update on projeto-topicosespeciais.* to root@'localhost';