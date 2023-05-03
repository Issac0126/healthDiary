
CREATE TABLE member (
    member_number	NUMBER(10) PRIMARY KEY NOT NULL,
    member_name VARCHAR2(20) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    grade VARCHAR2(10) DEFAULT 'BRONZE' NOT NULL,
    reg_date DATE DEFAULT sysdate NOT NULL
);

CREATE TABLE exercise (
	exe_num	NUMBER(10)		NOT NULL,
	exe_name	VARCHAR2(30)		NOT NULL,
	exe_measure	VARCHAR2(20)		NULL
);

CREATE TABLE record (
	record_num	NUMBER(10)	NOT NULL PRIMARY KEY,
	member_number	NUMBER(10)	NOT NULL,
	exe_num	NUMBER(10)	NOT NULL,
	record_score NUMBER(10)	NOT NULL,
	record_day DATE DEFAULT sysdate	NULL
);

SELECT * FROM member;
SELECT * FROM exercise;
SELECT * FROM record;

CREATE SEQUENCE member_seq
    START WITH 1
    MAXVALUE 10000;
    
CREATE SEQUENCE exercise_seq
    START WITH 1
    MAXVALUE 10000;

CREATE SEQUENCE record_seq
    START WITH 1
    MAXVALUE 10000;


-- 기본데이터
INSERT INTO exercise VALUES (exercise_seq.NEXTVAL, '스쿼트', 'C');
INSERT INTO exercise VALUES (exercise_seq.NEXTVAL, '러닝머신', 'S');
INSERT INTO exercise VALUES (exercise_seq.NEXTVAL, '자전거', 'S');
INSERT INTO exercise VALUES (exercise_seq.NEXTVAL, '턱걸이', 'C');




-- 더미데이터
INSERT INTO member (member_number, member_name, phone_number)
VALUES (member_seq.NEXTVAL, '김뽀삐', '010-1234-5678');

INSERT INTO member (member_number, member_name, phone_number, reg_date)
VALUES (member_seq.NEXTVAL, '홍길동', '010-5555-6666', '54/10/10');

INSERT INTO member (member_number, member_name, phone_number)
VALUES (member_seq.NEXTVAL, '감빠뻐', '010-4444-6576');

INSERT INTO member (member_number, member_name, phone_number, reg_date, grade)
VALUES (member_seq.NEXTVAL, '이경민', '010-0000-0000', '17/02/26','DIAMOND');

INSERT INTO member (member_number, member_name, phone_number, reg_date)
VALUES (member_seq.NEXTVAL, '세글자', '010-3333-6333', '22/12/05');

INSERT INTO member (member_number, member_name, phone_number)
VALUES (member_seq.NEXTVAL, '구구구', '02-9998-9989');

INSERT INTO member (member_number, member_name, phone_number, reg_date)
VALUES (member_seq.NEXTVAL, '신난다', '010-2541-7541', '22/12/08');

INSERT INTO member (member_number, member_name, phone_number)
VALUES (member_seq.NEXTVAL, '금요일', '010-3333-7777');

INSERT INTO member (member_number, member_name, phone_number, reg_date, grade)
VALUES (member_seq.NEXTVAL, '으갸갹', '010-2540-4555', '20/12/08', 'BRONZE');

INSERT INTO member (member_number, member_name, phone_number, reg_date, grade)
VALUES (member_seq.NEXTVAL, '밈뮴머', '010-2789-4555', '19/5/08', 'BRONZE');

INSERT INTO member (member_number, member_name, phone_number, reg_date, grade)
VALUES (member_seq.NEXTVAL, '하동호', '010-2789-4555', '18/3/08', 'BRONZE');

INSERT INTO member (member_number, member_name, phone_number, reg_date, grade)
VALUES (member_seq.NEXTVAL, '오윤원', '010-4989-7578', '18/5/09', 'BRONZE');

INSERT INTO member (member_number, member_name, phone_number, reg_date, grade)
VALUES (member_seq.NEXTVAL, '바밤바', '010-4989-7578', '18/6/11', 'BRONZE');

INSERT INTO record VALUES (record_seq.NEXTVAL, 22, 2, 30, '23/05/01');
INSERT INTO record VALUES (record_seq.NEXTVAL, 22, 2, 20, '23/04/30');
INSERT INTO record VALUES (record_seq.NEXTVAL, 22, 2, 30, '22/01/25');
INSERT INTO record VALUES (record_seq.NEXTVAL, 23, 3, 180, '23/05/02');
INSERT INTO record VALUES (record_seq.NEXTVAL, 25, 2, 130, '23/04/30');
INSERT INTO record VALUES (record_seq.NEXTVAL, 25, 1, 5, '23/04/25');
INSERT INTO record VALUES (record_seq.NEXTVAL, 25, 1, 12, '23/01/16');

COMMIT;
