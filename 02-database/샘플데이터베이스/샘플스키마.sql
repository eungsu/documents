alter session set nls_date_format='YYYY-MM-DD';


CREATE TABLE EMP ( 
  EMPNO     NUMBER(4, 0), 
  ENAME     VARCHAR2(50), 
  JOB       VARCHAR2(50), 
  MGR       NUMBER(4, 0), 
  HIREDATE  DATE, 
  SAL       NUMBER(7, 2),
  COMM      NUMBER(7, 2), 
  DEPTNO    NUMBER(2, 0));

insert into emp values (7369,'SMITH','CLERK',7902,'1980-12-17',800,null,20);
insert into emp values (7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);
insert into emp values (7521,'WARD','SALESMAN',7698,'1982-02-22',1250,500,30);
insert into emp values (7566,'JONES','MANAGER',7839,'1981-04-02',2975,null,20);
insert into emp values (7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,1400,30);
insert into emp values (7698,'BLAKE','MANAGER',7839,'1981-05-01',2850,null,30);
insert into emp values (7782,'CLARK','MANAGER',7839,'1981-06-09',2450,null,10);
insert into emp values (7788,'SCOTT','ANALYST',7566,'1987-04-17',3000,null,20);
insert into emp values (7839,'KING','PRESIDENT',null,'1981-11-17',5000,null,10);
insert into emp values (7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30);
insert into emp values (7876,'ADAMS','CLERK',7788,'1987-05-23',1100,null,20);
insert into emp values (7900,'JAMES','CLERK',7698,'1981-12-03',950,null,30);
insert into emp values (7902,'FORD','ANALYST',7566,'1981-12-03',3000,null,20);
insert into emp values (7934,'MILLER','CLERK',7782,'1982-01-23',1300,null,10);


CREATE UNIQUE INDEX PK_EMP ON EMP (EMPNO) ;
ALTER TABLE EMP ADD  CONSTRAINT PK_EMP PRIMARY KEY (EMPNO);


CREATE TABLE DEPT (
  DEPTNO   NUMBER(2,0), 
  DNAME    VARCHAR2(30), 
  LOC      VARCHAR2(30));

insert into dept values (10,'ACCOUNTING','NEW YORK');
insert into dept values (20,'RESEARCH','DALLAS');
insert into dept values (30,'SALES','CHICAGO');
insert into dept values (40,'OPERATIONS','BOSTON');

CREATE UNIQUE INDEX PK_DEPT ON DEPT (DEPTNO);
ALTER TABLE DEPT ADD  CONSTRAINT PK_DEPT PRIMARY KEY (DEPTNO);

ALTER TABLE EMP ADD CONSTRAINT FK_DEPTNO FOREIGN KEY (DEPTNO) REFERENCES DEPT (DEPTNO);





create table professor
(profno number(4) primary key,
 name  varchar2(20) not null, 
 id  varchar2(20) not null,
 position varchar2 (20) not null,
 pay number (3) not null,
 hiredate  date not null,
 bonus number(4) ,
 deptno  number(3),
 email  varchar2(100),
 hpage  varchar2(100)) tablespace users;

insert into professor
values(1001,'조인형','captain','정교수',550,to_date('1980-06-23','YYYY-MM-DD'),100,101,'captain@abc.net','http://www.abc.net');

insert into professor
values(1002,'박승곤','sweety','조교수',380,to_date('1987-01-30','YYYY-MM-DD'),60,101,'sweety@abc.net','http://www.abc.net');

insert into professor
values (1003,'송도권','powerman','전임강사',270,to_date('1998-03-22','YYYY-MM-DD'),null,101,'pman@power.com','http://www.power.com');

insert into professor
values (2001,'양선희','lamb1','전임강사',250,to_date('2001-09-01','YYYY-MM-DD'),null,102,'lamb1@hamail.net',null);

insert into professor
values (2002,'김영조','number1','조교수',350,to_date('1985-11-30','YYYY-MM-DD'),80,102,'number1@naver.com','http://num1.naver.com');

insert into professor
values (2003,'주승재','bluedragon','정교수',490,to_date('1982-04-29','YYYY-MM-DD'),90,102,'bdragon@naver.com',null);

insert into professor
values (3001,'김도형','angel1004','정교수',530,to_date('1981-10-23','YYYY-MM-DD'),110,103,'angel1004@hanmir.com',null);

insert into professor
values (3002,'나한열','naone10','조교수',330,to_date('1997-07-01','YYYY-MM-DD'),50,103,'naone10@empal.com',null);

insert into professor
values (3003,'김현정','only-u','전임강사',290,to_date('2002-02-24','YYYY-MM-DD'),null,103,'only_u@abc.com',null);

insert into professor
values (4001,'심슨','simson','정교수',570,to_date('1981-10-23','YYYY-MM-DD'),130,201,'chebin@daum.net',null);

insert into professor
values (4002,'최슬기','gogogo','조교수',330,to_date('2009-08-30','YYYY-MM-DD'),null,201,'gogogo@def.com',null);

insert into professor
values (4003,'박원범','mypride','조교수',310,to_date('1999-12-01','YYYY-MM-DD'),50,202,'mypride@hanmail.net',null);

insert into professor
values (4004,'차범철','ironman','전임강사',260,to_date('2009-01-28','YYYY-MM-DD'),null,202,'ironman@naver.com',null);

insert into professor
values (4005,'바비','standkang','정교수',500,to_date('1985-09-18','YYYY-MM-DD'),80,203,'standkang@naver.com',null);

insert into professor 
values (4006,'전민','napeople','전임강사',220,to_date('2010-06-28','YYYY-MM-DD'),null,301,'napeople@jass.com',null);

insert into professor
values (4007,'허은','silver-her','조교수',290,to_date('2001-05-23','YYYY-MM-DD'),30,301,'silver-her@daum.net',null);

commit;

create table department
( deptno number(3) primary key ,
  dname varchar2(50) not null,
  part number(3),
  build  varchar2(50))tablespace users;

insert into department 
values (101,'컴퓨터공학과',100,'정보관');

insert into department
values (102,'멀티미디어공학과',100,'멀티미디어관');

insert into department
values (103,'소프트웨어공학과',100,'소프트웨어관');

insert into department
values (201,'전자공학과',200,'전자제어관');

insert into department
values (202,'기계공학과',200,'기계실험관');

insert into department
values (203,'화학공학과',200,'화학실습관');

insert into department
values (301,'문헌정보학과',300,'인문관');

insert into department
values (100,'컴퓨터정보학부',10,null);

insert into department
values (200,'메카트로닉스학부',10,null);

insert into department
values (300,'인문사회학부',20,null);

insert into department
values (10,'공과대학',null,null);

insert into department
values (20,'인문대학',null,null);

commit;
 



create table student
( studno number(4) primary key,
  name   varchar2(30) not null,
  id varchar2(30) not null unique,
  grade number check(grade between 1 and 6),
  jumin char(13) not null,
  birthday  date,
  tel varchar2(20),
  height  number(4),
  weight  number(3),
  deptno1 number(3),
  deptno2 number(3),
  profno  number(4)) tablespace users;

insert into student values (
9411,'서진수','75true',4,'7510231901810',to_date('1975-10-23','YYYY-MM-DD'),'055)381-2158',180,72,101,201,1001);

insert into student values (
9412,'서재수','pooh94',4,'7502241128467',to_date('1975-02-24','YYYY-MM-DD'),'051)426-1700',172,64,102,null,2001);

insert into student values (
9413,'이미경','angel000',4,'7506152123648',to_date('1975-06-15','YYYY-MM-DD'),'053)266-8947',168,52,103,203,3002);

insert into student values (
9414,'김재수','gunmandu',4,'7512251063421',to_date('1975-12-25','YYYY-MM-DD'),'02)6255-9875',177,83,201,null,4001);

insert into student values (
9415,'박동호','pincle1',4,'7503031639826',to_date('1975-03-03','YYYY-MM-DD'),'031)740-6388',182,70,202,null,4003);

insert into student values (
9511,'김신영','bingo',3,'7601232186327',to_date('1976-01-23','YYYY-MM-DD'),'055)333-6328',164,48,101,null,1002);

insert into student values (
9512,'신은경','jjang1',3,'7604122298371',to_date('1976-04-12','YYYY-MM-DD'),'051)418-9627',161,42,102,201,2002);

insert into student values (
9513,'오나라','nara5',3,'7609112118379',to_date('1976-09-11','YYYY-MM-DD'),'051)724-9618',177,55,202,null,4003);

insert into student values (
9514,'구유미','guyume',3,'7601202378641',to_date('1976-01-20','YYYY-MM-DD'),'055)296-3784',160,58,301,101,4007);

insert into student values (
9515,'임세현','shyun1',3,'7610122196482',to_date('1976-10-12','YYYY-MM-DD'),'02)312-9838',171,54,201,null,4001);

insert into student values (
9611,'일지매','onejimae',2,'7711291186223',to_date('1977-11-29','YYYY-MM-DD'),'02)6788-4861',182,72,101,null,1002);

insert into student values (
9612,'김진욱','samjang7',2,'7704021358674',to_date('1977-04-02','YYYY-MM-DD'),'055)488-2998',171,70,102,null,2001);

insert into student values (
9613,'안광훈','nonnon1',2,'7709131276431',to_date('1977-09-13','YYYY-MM-DD'),'053)736-4981',175,82,201,null,4002);

insert into student values (
9614,'김문호','munho',2,'7702261196365',to_date('1977-02-26','YYYY-MM-DD'),'02)6175-3945',166,51,201,null,4003);

insert into student values (
9615,'노정호','star123',2,'7712141254963',to_date('1977-12-14','YYYY-MM-DD'),'051)785-6984',184,62,301,null,4007);

insert into student values (
9711,'이윤나','prettygirl',1,'7808192157498',to_date('1978-08-19','YYYY-MM-DD'),'055)278-3649',162,48,101,null,null);

insert into student values (
9712,'안은수','silverwt',1,'7801051776346',to_date('1978-01-05','YYYY-MM-DD'),'02)381-5440',175,63,201,null,null);

insert into student values (
9713,'인영민','youngmin',1,'7808091786954',to_date('1978-08-09','YYYY-MM-DD'),'031)345-5677',173,69,201,null,null);

insert into student values (
9714,'김주현','kimjh',1,'7803241981987',to_date('1978-03-24','YYYY-MM-DD'),'055)423-9870',179,81,102,null,null);

insert into student values (
9715,'허우','wooya2702',1,'7802232116784',to_date('1978-02-23','YYYY-MM-DD'),'02)6122-2345',163,51,103,null,null);



CREATE TABLE EMP2 (
 EMPNO       NUMBER  PRIMARY KEY,
 NAME        VARCHAR2(30) NOT NULL,
 BIRTHDAY    DATE,
 DEPTNO      VARCHAR2(4) NOT NULL,
 EMP_TYPE    VARCHAR2(20),
 TEL         VARCHAR2(20),
 HOBBY       VARCHAR2(50),
 PAY         NUMBER,
 POSITION    VARCHAR2(50),
 PEMPNO      NUMBER
);

INSERT INTO EMP2 VALUES (19900101,'나사장',TO_DATE('19640125','YYYYMMDD'),'0001','정규직','054)223-0001','음악감상',100000000,'대표이사',null);
INSERT INTO EMP2 VALUES (19960101,'전부장',TO_DATE('19730322','YYYYMMDD'),'1000','정규직','02)6255-8000','독서',72000000,'부장',19900101);
INSERT INTO EMP2 VALUES (19970201,'최일도',TO_DATE('19750415','YYYYMMDD'),'1000','정규직','02)6255-8005','운동',50000000,'과장',19960101);
INSERT INTO EMP2 VALUES (19930331,'백원만',TO_DATE('19760525','YYYYMMDD'),'1001','정규직','02)6255-8010','자전거타기',60000000,'차장',19960101);
INSERT INTO EMP2 VALUES (19950303,'천만득',TO_DATE('19730615','YYYYMMDD'),'1002','정규직','02)6255-8020','마라톤',56000000,'과장',19960101);
INSERT INTO EMP2 VALUES (19966102,'일지매',TO_DATE('19720705','YYYYMMDD'),'1003','정규직','052)223-4000','음악감상',75000000,'부장',19900101);
INSERT INTO EMP2 VALUES (19930402,'유관순',TO_DATE('19720815','YYYYMMDD'),'1004','정규직','042)998-7005','등산',51000000,'과장',19966102);
INSERT INTO EMP2 VALUES (19960303,'김문호',TO_DATE('19710925','YYYYMMDD'),'1005','정규직','031)564-3340','등산',35000000,'대리',19966102);
INSERT INTO EMP2 VALUES (19970112,'노정호',TO_DATE('19761105','YYYYMMDD'),'1006','정규직','054)223-4500','수영',68000000,'부장',19900101);
INSERT INTO EMP2 VALUES (19960212,'이윤나',TO_DATE('19721215','YYYYMMDD'),'1007','정규직','054)223-4600',null,49000000,'과장',19970112);
INSERT INTO EMP2 VALUES (20000101,'이태백',TO_DATE('19850125','YYYYMMDD'),'1008','계약직','051)123-4567','등산', 30000000,'',19960212);
INSERT INTO EMP2 VALUES (20000102,'김설악',TO_DATE('19830322','YYYYMMDD'),'1009','계약직','031)234-5678','낚시', 30000000,'',19960212);
INSERT INTO EMP2 VALUES (20000203,'최오대',TO_DATE('19820415','YYYYMMDD'),'1010','계약직','02)2345-6789','바둑', 30000000,'',19960212);
INSERT INTO EMP2 VALUES (20000334,'박지리',TO_DATE('19810525','YYYYMMDD'),'1011','계약직','053)456-7890','노래', 30000000,'',19960212);
INSERT INTO EMP2 VALUES (20000305,'정북악',TO_DATE('19800615','YYYYMMDD'),'1008','수습직','051)567-8901','독서', 22000000,'',19960212);
INSERT INTO EMP2 VALUES (20006106,'유도봉',TO_DATE('19800705','YYYYMMDD'),'1009','수습직','031)678-9012','술',   22000000,'',19960212);
INSERT INTO EMP2 VALUES (20000407,'윤주왕',TO_DATE('19800815','YYYYMMDD'),'1010','수습직','02)2789-0123','오락', 22000000,'',19960212);
INSERT INTO EMP2 VALUES (20000308,'강월악',TO_DATE('19800925','YYYYMMDD'),'1011','인턴직','053)890-1234','골프', 20000000,'',19960212);
INSERT INTO EMP2 VALUES (20000119,'장금강',TO_DATE('19801105','YYYYMMDD'),'1004','인턴직','042)901-2345','술',   20000000,'',19930402);
INSERT INTO EMP2 VALUES (20000210,'나한라',TO_DATE('19801215','YYYYMMDD'),'1005','인턴직','031)345-3456','독서', 20000000,'',19960303);
COMMIT;


CREATE TABLE DEPT2 (
 DCODE   VARCHAR2(4)  PRIMARY KEY,
 DNAME   VARCHAR2(50) NOT NULL,
 PDEPT VARCHAR2(4) ,
 AREA        VARCHAR2(50)
);

INSERT INTO DEPT2 VALUES ('0001','사장실','','포항본사');
INSERT INTO DEPT2 VALUES ('1000','경영지원부','0001','서울지사');
INSERT INTO DEPT2 VALUES ('1001','재무관리팀','1000','서울지사');
INSERT INTO DEPT2 VALUES ('1002','총무팀','1000','서울지사');
INSERT INTO DEPT2 VALUES ('1003','기술부','0001','포항본사');
INSERT INTO DEPT2 VALUES ('1004','H/W지원','1003','대전지사');
INSERT INTO DEPT2 VALUES ('1005','S/W지원','1003','경기지사');
INSERT INTO DEPT2 VALUES ('1006','영업부','0001','포항본사');
INSERT INTO DEPT2 VALUES ('1007','영업기획팀','1006','포항본사');
INSERT INTO DEPT2 VALUES ('1008','영업1팀','1007','부산지사');
INSERT INTO DEPT2 VALUES ('1009','영업2팀','1007','경기지사');
INSERT INTO DEPT2 VALUES ('1010','영업3팀','1007','서울지사');
INSERT INTO DEPT2 VALUES ('1011','영업4팀','1007','울산지사');



CREATE TABLE cal
   (week  varchar2(1),
    day   varchar2(10),
    num_day varchar2(10)) ;

insert into cal values ('1','일','1');
insert into cal values ('1','월','2');
insert into cal values ('1','화','3');
insert into cal values ('1','수','4');
insert into cal values ('1','목','5');
insert into cal values ('1','금','6');
insert into cal values ('1','토','7');
insert into cal values ('2','일','8');
insert into cal values ('2','월','9');
insert into cal values ('2','화','10');
insert into cal values ('2','수','11');
insert into cal values ('2','목','12');
insert into cal values ('2','금','13');
insert into cal values ('2','토','14');
insert into cal values ('3','일','15');
insert into cal values ('3','월','16');
insert into cal values ('3','화','17');
insert into cal values ('3','수','18');
insert into cal values ('3','목','19');
insert into cal values ('3','금','20');
insert into cal values ('3','토','21');
insert into cal values ('4','일','22');
insert into cal values ('4','월','23');
insert into cal values ('4','화','24');
insert into cal values ('4','수','25');
insert into cal values ('4','목','26');
insert into cal values ('4','금','27');
insert into cal values ('4','토','28');
insert into cal values ('5','일','29');
insert into cal values ('5','월','30');
insert into cal values ('5','화','31');
commit ;


create table gift
( gno  number ,
  gname varchar2(50) ,
  g_start  number ,
  g_end  number );

insert into gift values(1,'참치세트',1,100000);
insert into gift values(2,'샴푸세트',100001,200000);
insert into gift values(3,'세차용품세트',200001,300000);
insert into gift values(4,'주방용품세트',300001,400000);
insert into gift values(5,'산악용자전거',400001,500000);
insert into gift values(6,'LCD모니터',500001,600000);
insert into gift values(7,'노트북',600001,700000);
insert into gift values(8,'벽걸이TV',700001,800000);
insert into gift values(9,'드럼세탁기',800001,900000);
insert into gift values(10,'양쪽문냉장고',900001,1000000);
commit ;


create table gogak
(gno  number(8) ,
 gname varchar2(50) ,
 jumin char(13) ,
 point number) ;

insert into gogak values (20010001,'서진수','7510231369820',980000);
insert into gogak values (20010002,'서재수','7502241128467',73000);
insert into gogak values (20010003,'이미경','7506152123648',320000);
insert into gogak values (20010004,'김재수','7512251063421',65000);
insert into gogak values (20010005,'박동호','7503031639826',180000);
insert into gogak values (20010006,'김신영','7601232186327',153000);
insert into gogak values (20010007,'신은경','7604212298371',273000);
insert into gogak values (20010008,'오나라','7609112118379',315000);
insert into gogak values (20010009,'김설희','7601202378641',542000);
insert into gogak values (20010010,'임세현','7610122196482',265000);
insert into gogak values (20010011,'최순규','7711291186223',110000);
insert into gogak values (20010012,'정현영','7704021358674',99000);
insert into gogak values (20010013,'안광훈','7709131276431',470000);
insert into gogak values (20010014,'모병환','7702261196365',298000);
insert into gogak values (20010015,'노정호','7712141254963',420000);
insert into gogak values (20010016,'이윤나','7808192157498',598000);
insert into gogak values (20010017,'안은수','7801051776346',625000);
insert into gogak values (20010018,'인영민','7808091786954',670000);
insert into gogak values (20010019,'김지영','7803242114563',770000);
insert into gogak values (20010020,'허우','7802232116784',730000);
commit ;



create table hakjum
(grade char(3) ,
 min_point  number ,
 max_point  number );

insert into hakjum values ('A+',96,100);
insert into hakjum values ('A0',90,95);
insert into hakjum values ('B+',86,89);
insert into hakjum values ('B0',80,85);
insert into hakjum values ('C+',76,79);
insert into hakjum values ('C0',70,75);
insert into hakjum values ('D',0,69);




create table exam_01
(studno  number ,
 total number);

insert into exam_01 values (9411,97);
insert into exam_01 values (9412,78);
insert into exam_01 values (9413,83);
insert into exam_01 values (9414,62);
insert into exam_01 values (9415,88);
insert into exam_01 values (9511,92);
insert into exam_01 values (9512,87);
insert into exam_01 values (9513,81);
insert into exam_01 values (9514,79);
insert into exam_01 values (9515,95);
insert into exam_01 values (9611,89);
insert into exam_01 values (9612,77);
insert into exam_01 values (9613,86);
insert into exam_01 values (9614,82);
insert into exam_01 values (9615,87);
insert into exam_01 values (9711,91);
insert into exam_01 values (9712,88);
insert into exam_01 values (9713,82);
insert into exam_01 values (9714,83);
insert into exam_01 values (9715,84);



create table p_grade
( position  varchar2(20) ,
  s_age number ,
  e_age number ,
  s_year number ,
  e_year number ,
  s_pay  number ,
  e_pay  number );

insert into p_grade values ('주임',0,24,1,2,12000000,29990000);
insert into p_grade values ('대리',25,28,3,5,30000000,45000000);
insert into p_grade values ('과장',29,32,6,8,45010000,51000000);
insert into p_grade values ('차장',33,36,9,10,51010000,60000000);
insert into p_grade values ('부장',37,40,11,13,60010000,75000000);
insert into p_grade values ('이사',41,55,14,99,75010000,100000000);



