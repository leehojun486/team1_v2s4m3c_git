DROP TABLE notice;
DROP SEQUENCE notice_seq; 

/**********************************/
/*    Table Name: 공지사항    */
/**********************************/
CREATE TABLE NOTICE(
		NOTICENO                      		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		TITLE                         		VARCHAR2(300)		 NOT NULL,
		CONTENTS                      		CLOB		 NOT NULL,
		RDATE                         		DATE		 NOT NULL
);
COMMENT ON TABLE NOTICE is '공지사항';
COMMENT ON COLUMN NOTICE.NOTICENO is '공지사항번호';
COMMENT ON COLUMN NOTICE.TITLE is '공지사항제목';
COMMENT ON COLUMN NOTICE.CONTENTS is '내용';
COMMENT ON COLUMN NOTICE.RDATE is '작성일';

CREATE SEQUENCE notice_seq
  START WITH 1             
  INCREMENT BY 1          
  MAXVALUE 9999999999 
  CACHE 2                     
  NOCYCLE;   
--*************************************************************************--

  -- 컬럼 확인
SELECT * 
FROM notice
ORDER BY noticeno ASC; 

  -- 테스트 용 생성
INSERT INTO notice(noticeno, title, contents, rdate)
VALUES(notice_seq.nextval, '공지사항', '내용', sysdate);
  
INSERT INTO notice(noticeno, title, contents, rdate)
VALUES(notice_seq.nextval, '공지사항2', '내용2', sysdate);

INSERT INTO notice(noticeno, title, contents, rdate)
VALUES(notice_seq.nextval, '공지사항3', '내용3', sysdate);

  -- 삭제
DELETE notice
WHERE noticeno = 1;

  -- 재 생성
INSERT INTO notice(noticeno, title, contents, rdate)
VALUES(1, '공지사항', '내용', sysdate);

  -- 수정
UPDATE notice
SET contents='내용이 바뀜'
WHERE noticeno = 1;

COMMIT;