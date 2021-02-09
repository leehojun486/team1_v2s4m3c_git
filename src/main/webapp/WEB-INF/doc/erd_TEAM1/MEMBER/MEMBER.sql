DROP TABLE member;
DROP SEQUENCE member_seq; 

/**********************************/
/*       Table Name: 회원       */
/**********************************/
CREATE TABLE MEMBER(
		MEMBERNO                      		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		MEMBERNAME                    		VARCHAR2(50)		 NOT NULL,
		MEMBERNICNAME                 		VARCHAR2(50)		 NOT NULL,
		MEMBERIMG                     		VARCHAR2(100)		 NULL ,
		MEMBERPREVIEW                 		VARCHAR2(100)		 NULL ,
		MEMBERIMGSIZE                 		NUMBER(20)		 NULL ,
		MEMBEREML                     		VARCHAR2(50)		 NOT NULL,
		MEMBERID                      		VARCHAR2(50)		 NOT NULL,
		MEMBERPASS                  		VARCHAR2(50)		 NOT NULL,
		MEMBERDATE                    		DATE		 NOT NULL,
		MEMBERZIP                     		VARCHAR2(20)		 NULL ,
		MEMBERADD1                    		VARCHAR2(80)		 NULL ,
		MEMBERADD2                    		VARCHAR2(50)		 NULL 
);
COMMENT ON TABLE MEMBER is '회원';
COMMENT ON COLUMN MEMBER.MEMBERNO is '회원번호';
COMMENT ON COLUMN MEMBER.MEMBERNAME is '회원이름';
COMMENT ON COLUMN MEMBER.MEMBERNICNAME is '회원닉네임';
COMMENT ON COLUMN MEMBER.MEMBERIMG is '회원이미지';
COMMENT ON COLUMN MEMBER.MEMBERPREVIEW is '회원이미지미리보기';
COMMENT ON COLUMN MEMBER.MEMBERIMGSIZE is '회원이미지파일크기';
COMMENT ON COLUMN MEMBER.MEMBEREML is '회원이메일';
COMMENT ON COLUMN MEMBER.MEMBERID is '회원아이디';
COMMENT ON COLUMN MEMBER.MEMBERPASS is '회원비밀번호';
COMMENT ON COLUMN MEMBER.MEMBERDATE is '회원생성일';
COMMENT ON COLUMN MEMBER.MEMBERZIP is '회원압축파일';
COMMENT ON COLUMN MEMBER.MEMBERADD1 is '회원주소1';
COMMENT ON COLUMN MEMBER.MEMBERADD2 is '회원주소2';

CREATE SEQUENCE member_seq
  START WITH 1             
  INCREMENT BY 1          
  MAXVALUE 9999999999 
  CACHE 2                     
  NOCYCLE;   
--*************************************************************************--

  -- 컬럼 확인
SELECT * 
FROM member
ORDER BY memberno ASC; 

  -- 테스트 용 생성
INSERT INTO member(memberno, membername, membernicname, memberimg, memberpreview, memberimgsize, membereml, memberid, memberpass, memberdate, memberzip, memberadd1, memberadd2)
VALUES (member_seq.nextval, '김철수', '철수', 'cs.img', 'cs.pre', 5231, 'cs@naver.com', 'kcs', '1234', sysdate, 'cs.zip', '서울', '마포구');
  
INSERT INTO member(memberno, membername, membernicname, memberimg, memberpreview, memberimgsize, membereml, memberid, memberpass, memberdate, memberzip, memberadd1, memberadd2)
VALUES (member_seq.nextval, '이뚱이', '뚱이', 'dde.img', 'dde.pre', 2341, 'dde@naver.com', 'edde', '1234', sysdate, 'dde.zip', '서울', '동대문구');

INSERT INTO member(memberno, membername, membernicname, memberimg, memberpreview, memberimgsize, membereml, memberid, memberpass, memberdate, memberzip, memberadd1, memberadd2)
VALUES (member_seq.nextval, '박뚜비', '뚜비', 'ddb.img', 'ddb.pre', 8231, 'ddb@daum.net', 'bddb', '1234', sysdate, 'ddb.zip', '경기도', '저수지');
 
  -- 삭제
DELETE member
WHERE memberno = 1;

  -- 재 생성
INSERT INTO member(memberno, membername, membernicname, memberimg, memberpreview, memberimgsize, membereml, memberid, memberpass, memberdate, memberzip, memberadd1, memberadd2)
VALUES (1, '김철수', '철수', 'cs.img', 'cs.pre', 5231, 'cs@naver.com', 'kcs', '1234', sysdate, 'cs.zip', '서울', '마포구');
  
  -- 수정
UPDATE member
SET membernicname='나나'
WHERE memberno = 3;

COMMIT;