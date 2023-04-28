
CREATE TABLE member (
    user_number	NUMBER(10) PRIMARY KEY NOT NULL,
    user_name VARCHAR2(20) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    grade VARCHAR2(10) DEFAULT 'BRONZE' NOT NULL,
    reg_date DATE DEFAULT sysdate NOT NULL,
    in_room	VARCHAR2(5)	DEFAULT 'false' NOT NULL
);

CREATE TABLE exercise (
	exe_num	NUMBER(10)		NOT NULL,
	exe_name	VARCHAR2(30)		NOT NULL,
	exe_measure	VARCHAR2(20)		NULL
);

CREATE TABLE record (
	record_num	NUMBER(10)	NOT NULL PRIMARY KEY,
	user_number	NUMBER(10)	NOT NULL,
	exe_num	NUMBER(10)	NOT NULL,
	record_score NUMBER(10)	NOT NULL,
	exe_level	NUMBER(10)	NOT NULL,
	record_day DATE DEFAULT sysdate	NULL
);


SELECT * FROM member;
SELECT * FROM exercise;
SELECT * FROM record;
DROP TABLE exercise;

CREATE SEQUENCE member_seq
    START WITH 1
    MAXVALUE 10000;
    
CREATE SEQUENCE exercise_seq
    START WITH 1
    MAXVALUE 10000;

CREATE SEQUENCE record_seq
    START WITH 1
    MAXVALUE 10000;
    
DROP SEQUENCE exercise_seq;

INSERT INTO exercise
VALUES (exercise_seq.NEXTVAL, '스쿼트', 'C');
INSERT INTO exercise
VALUES (exercise_seq.NEXTVAL, '러닝머신', 'S');

DELETE FROM exercise
WHERE exe_num = 1;



