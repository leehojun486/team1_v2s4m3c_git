DROP TABLE faq;
DROP SEQUENCE faq_seq; 

/**********************************/
/* Table Name: 자주묻는질문 */
/**********************************/
CREATE TABLE FAQ(
		FAQNO                         		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		FAQTITLE                      		VARCHAR2(50)		 NOT NULL,
		FAQCONTENT                    		VARCHAR2(50)		 NULL ,
		ADMINPASS                     		VARCHAR2(15)		 NOT NULL,
		FAQWORD                       		VARCHAR2(300)		 NULL ,
		FAQRDATE                      		DATE		 NOT NULL,
		ADMINNO                       		NUMBER(6)		 NULL ,
  FOREIGN KEY (ADMINNO) REFERENCES ADMIN (ADMINNO)
);
COMMENT ON TABLE FAQ is '자주묻는질문';
COMMENT ON COLUMN FAQ.FAQNO is '질문번호';
COMMENT ON COLUMN FAQ.FAQTITLE is '질문제목';
COMMENT ON COLUMN FAQ.FAQCONTENT is '질문내용';
COMMENT ON COLUMN FAQ.ADMINPASS is '관리자비밀번호';
COMMENT ON COLUMN FAQ.FAQWORD is '질문단어';
COMMENT ON COLUMN FAQ.FAQRDATE is '질문작성일';
COMMENT ON COLUMN FAQ.ADMINNO is '관리자번호';

CREATE SEQUENCE faq_seq
  START WITH 1             
  INCREMENT BY 1          
  MAXVALUE 9999999999 
  CACHE 2                     
  NOCYCLE;   
--*************************************************************************--

  -- 컬럼 확인
SELECT * 
FROM faq
ORDER BY faqno ASC; 

  -- 테스트 용 생성
INSERT INTO faq(faqno, faqtitle, faqcontent, adminpass, faqword, faqrdate, adminno)
VALUES (faq_seq.nextval, '질문1', '무엇을 질문할까요', '1234', '질문', sysdate, 1);

INSERT INTO faq(faqno, faqtitle, faqcontent, adminpass, faqword, faqrdate, adminno)
VALUES (faq_seq.nextval, '질문2', '무엇을 질문할까요2', '1234', '질문', sysdate, 1);

INSERT INTO faq(faqno, faqtitle, faqcontent, adminpass, faqword, faqrdate, adminno)
VALUES (faq_seq.nextval, '질문3', '무엇을 질문할까요3', '1234', '질문', sysdate, 2);

  -- 삭제
DELETE faq
WHERE faqno = 1;

  -- 재 생성
INSERT INTO faq(faqno, faqtitle, faqcontent, adminpass, faqword, faqrdate, adminno)
VALUES (1, '질문1', '무엇을 질문할까요', '1234', '질문', sysdate, 1);

  -- 수정
UPDATE faq
SET faqtitle='질문변경'
WHERE faqno = 3;

COMMIT;