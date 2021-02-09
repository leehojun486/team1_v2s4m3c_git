DROP TABLE admin;
DROP SEQUENCE admin_seq; 

/**********************************/
/* Table Name: 관리자 */
/**********************************/
CREATE TABLE ADMIN(
		ADMINNO                       		NUMBER(6)		 NOT NULL		 PRIMARY KEY,
		ADMINID                       		VARCHAR2(20)		 NOT NULL,
		ADMINPASS                     		VARCHAR2(60)		 NOT NULL,
		ADMINNAME                     		VARCHAR2(20)		 NOT NULL
);
COMMENT ON TABLE ADMIN is '관리자';
COMMENT ON COLUMN ADMIN.ADMINNO is '관리자번호';
COMMENT ON COLUMN ADMIN.ADMINID is '관리자아이디';
COMMENT ON COLUMN ADMIN.ADMINPASS is '관리자비밀번호';
COMMENT ON COLUMN ADMIN.ADMINNAME is '관리자이름';

CREATE SEQUENCE admin_seq
  START WITH 1             
  INCREMENT BY 1          
  MAXVALUE 9999999999 
  CACHE 2                     
  NOCYCLE;   
--*************************************************************************--

  -- 컬럼 확인
SELECT * 
FROM admin
ORDER BY adminno ASC; 

  -- 테스트 용 생성
INSERT INTO admin(adminno, adminid, adminpass, adminname)
VALUES (admin_seq.nextval, 'id', '1234', '관리자');
  
INSERT INTO admin(adminno, adminid, adminpass, adminname)
VALUES (admin_seq.nextval, 'id2', '1234', '관리자2');

INSERT INTO admin(adminno, adminid, adminpass, adminname)
VALUES (admin_seq.nextval, 'id3', '1234', '관리자3');

  -- 삭제
DELETE admin
WHERE adminno = 1;

  -- 재 생성
INSERT INTO admin(adminno, adminid, adminpass, adminname)
VALUES (1, 'id', '1234', '관리자');

  -- 수정
UPDATE admin
SET adminid='admin'
WHERE adminno = 3;

COMMIT;