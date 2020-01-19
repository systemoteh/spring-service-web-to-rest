drop table IF EXISTS student;

create TABLE student (
  id INT PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  middle_name VARCHAR(250) DEFAULT NULL,
  last_name VARCHAR(250) NOT NULL,
  birth_date VARCHAR(250) DEFAULT NULL,
  email VARCHAR(250) DEFAULT NULL
);

-- SPRING SECURITY (words user and role reserved for DBMS)
create TABLE IF NOT EXISTS users (
  id INT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);

create TABLE IF NOT EXISTS roles (
  id INT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

-- Table for mapping users and roles
create TABLE IF NOT EXISTS users_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),
  UNIQUE (user_id, role_id)
);

drop sequence IF EXISTS student_seq;

create sequence student_seq
minvalue 1
maxvalue 9223372036854775807
start with 1
increment by 1
cache 8
nocycle;

drop sequence IF EXISTS users_seq;

create sequence users_seq
minvalue 1
maxvalue 9223372036854775807
start with 1
increment by 1
cache 8
nocycle;

drop sequence IF EXISTS roles_seq;

create sequence roles_seq
minvalue 1
maxvalue 9223372036854775807
start with 1
increment by 1
cache 8
nocycle;

drop sequence IF EXISTS user_roles_seq;

create sequence users_roles_seq
minvalue 1
maxvalue 9223372036854775807
start with 1
increment by 1
cache 8
nocycle;

insert into student (id, first_name, middle_name, last_name, birth_date, email) values
 (student_seq.nextval, 'Ivan', 'Ivanovich', 'Ivanov', '2001-01-01', 'ivanov@mail.ru'),
 (student_seq.nextval, 'Petr', 'Petrovich', 'Petrov', '2002-02-02', 'petrov@yandex.ru'),
 (student_seq.nextval, 'Sidor', 'Sidorovich', 'Sidorov', '2003-03-03', 'sidorov@gmail.com');

-- login: user      password: user
-- login: admin     password: admin
insert into users (id, username, password) values
(users_seq.nextval, 'user', '$2a$04$TA3vJwtPAcBzSXBVUFIRou9qymYuKd.qF97Ia8dc1tzRpTss9roTG'),
(users_seq.nextval, 'admin', '$2a$04$cMJ4Hhur5MQuyn41MbNRLOuYyhtq5VUucAf8uw0g.CXbjb.jtWWR2');

insert into roles (id, name) values
(roles_seq.nextval, 'USER_ROLE'),
(roles_seq.nextval, 'ADMIN_ROLE');

insert into users_roles (user_id, role_id) values
(users_roles_seq.nextval, 1),
(users_roles_seq.nextval, 2);