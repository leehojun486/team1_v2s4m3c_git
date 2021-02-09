DROP TABLE question;
DROP SEQUENCE question_seq; 

/**********************************/
/*       Table Name: 질문       */
/**********************************/
CREATE TABLE QUESTION(
		QUESTIONNO                    		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		QUESTIONLIST                  		VARCHAR2(100)		 NOT NULL,
		QUESTIONCNT                   		NUMBER(7)		 DEFAULT 0		 NOT NULL,
		SURVEYNO                      		NUMBER(10)		 NULL ,
  FOREIGN KEY (SURVEYNO) REFERENCES SURVEY (SURVEYNO)
);
COMMENT ON TABLE QUESTION is '질문';
COMMENT ON COLUMN QUESTION.QUESTIONNO is '질문번호';
COMMENT ON COLUMN QUESTION.QUESTIONLIST is '질문목록';
COMMENT ON COLUMN QUESTION.QUESTIONCNT is '질문 수';
COMMENT ON COLUMN QUESTION.SURVEYNO is '설문조사번호';

CREATE SEQUENCE question_seq
  START WITH 1              
  INCREMENT BY 1         
  MAXVALUE 9999999999 
  CACHE 2                      
  NOCYCLE;                
--*************************************************************************--

  -- 컬럼 확인
SELECT * 
FROM question
ORDER BY questionno ASC; 

  -- 테스트 용 생성
INSERT INTO question(questionno, questionlist, questioncnt, surveyno)
VALUES(question_seq.nextval, '질문목록1', 1, 1);
  
INSERT INTO question(questionno, questionlist, questioncnt, surveyno)
VALUES(question_seq.nextval, '질문목록2', 1, 2);

INSERT INTO question(questionno, questionlist, questioncnt, surveyno)
VALUES(question_seq.nextval, '질문목록3', 1, 3);
  
  -- 삭제
DELETE question
WHERE questionno = 1;

  -- 재 생성
INSERT INTO question(questionno, questionlist, questioncnt, surveyno)
VALUES(1, '질문목록1', 1, 1);

  -- 수정
UPDATE question
SET questionlist='질문목록one'
WHERE questionno = 1;

COMMIT;
