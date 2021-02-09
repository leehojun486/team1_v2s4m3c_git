DROP TABLE survey;
DROP SEQUENCE survey_seq; 

/**********************************/
/* Table Name: 설문조사 */
/**********************************/
CREATE TABLE SURVEY(
		SURVEYNO                      		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		TITLE                         		VARCHAR2(100)		 NOT NULL,
		RDATE                         		DATE		 NOT NULL
);
COMMENT ON TABLE SURVEY is '설문조사';
COMMENT ON COLUMN SURVEY.SURVEYNO is '설문조사번호';
COMMENT ON COLUMN SURVEY.TITLE is '설문조사제목';
COMMENT ON COLUMN SURVEY.RDATE is '작성일';

CREATE SEQUENCE survey_seq
  START WITH 1              
  INCREMENT BY 1         
  MAXVALUE 9999999999 
  CACHE 2                      
  NOCYCLE;                
--*************************************************************************--

  -- 컬럼 확인
SELECT * 
FROM survey
ORDER BY surveyno ASC; 

  -- 테스트 용 생성
INSERT INTO survey(surveyno, title, rdate)
VALUES(survey_seq.nextval, '설문조사1', sysdate);

INSERT INTO survey(surveyno, title, rdate)
VALUES(survey_seq.nextval, '설문조사2', sysdate);

INSERT INTO survey(surveyno, title, rdate)
VALUES(survey_seq.nextval, '설문조사3', sysdate);

  -- 삭제
DELETE survey
WHERE surveyno = 1;

  -- 재 생성
INSERT INTO survey(surveyno, title, rdate)
VALUES(1, '설문조사1', sysdate);

  -- 수정
UPDATE survey
SET title='설문조사one'
WHERE surveyno = 1;

COMMIT;