DROP TABLE singer_review;
DROP SEQUENCE singer_review_seq; 

/**********************************/
/*   Table Name: 가수리뷰     */
/**********************************/
CREATE TABLE SINGER_REVIEW(
		REVIEWNO                      		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		REVIEWCON                     		VARCHAR2(500)		 NOT NULL,
		REVIEWREC                     		NUMBER(10)		 DEFAULT 0		 NOT NULL,
		REVIEWDATE                    		DATE		 NOT NULL,
		REVIEWCMTCNT                  		NUMBER(10)		 DEFAULT 0		 NOT NULL,
		SINGERNO                      		NUMBER(10)		 NULL ,
		MEMBERNO                      		NUMBER(10)		 NULL ,
  FOREIGN KEY (SINGERNO) REFERENCES SINGER (SINGERNO),
  FOREIGN KEY (MEMBERNO) REFERENCES MEMBER (MEMBERNO)
);
COMMENT ON TABLE SINGER_REVIEW is '가수리뷰';
COMMENT ON COLUMN SINGER_REVIEW.REVIEWNO is '리뷰번호';
COMMENT ON COLUMN SINGER_REVIEW.REVIEWCON is '리뷰내용';
COMMENT ON COLUMN SINGER_REVIEW.REVIEWREC is '리뷰REC';
COMMENT ON COLUMN SINGER_REVIEW.REVIEWDATE is '작성일';
COMMENT ON COLUMN SINGER_REVIEW.REVIEWCMTCNT is '리뷰코멘트 수';
COMMENT ON COLUMN SINGER_REVIEW.SINGERNO is '가수번호';
COMMENT ON COLUMN SINGER_REVIEW.MEMBERNO is '회원번호';

CREATE SEQUENCE singer_review_seq
  START WITH 1             
  INCREMENT BY 1          
  MAXVALUE 9999999999 
  CACHE 2                     
  NOCYCLE;   
--*************************************************************************--

  -- 컬럼 확인
SELECT * 
FROM singer_review
ORDER BY reviewno ASC; 

  -- 테스트 용 생성
INSERT INTO singer_review(reviewno, reviewcon, reviewrec, reviewdate, reviewcmtcnt, singerno, memberno)
VALUES (singer_review_seq.nextval, '듣기 좋아요', 1, sysdate, 1, 1, 1);
  
INSERT INTO singer_review(reviewno, reviewcon, reviewrec, reviewdate, reviewcmtcnt, singerno, memberno)
VALUES (singer_review_seq.nextval, '좋네요', 10, sysdate, 2, 2, 2);

INSERT INTO singer_review(reviewno, reviewcon, reviewrec, reviewdate, reviewcmtcnt, singerno, memberno)
VALUES (singer_review_seq.nextval, '싫어요', 20, sysdate, 3, 3, 3);

  -- 삭제
DELETE singer_review
WHERE reviewno = 1;

  -- 재 생성
INSERT INTO singer_review(reviewno, reviewcon, reviewrec, reviewdate, reviewcmtcnt, singerno, memberno)
VALUES (1, '듣기 좋아요', 1, sysdate, 1, 1, 1);

  -- 수정
UPDATE singer_review
SET reviewcon='좋은가봐요'
WHERE reviewno = 3;

COMMIT;