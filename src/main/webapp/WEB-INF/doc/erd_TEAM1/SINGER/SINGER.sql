DROP TABLE singer;
DROP SEQUENCE singer_seq; 

/**********************************/
/*      Table Name: 가수       */
/**********************************/
CREATE TABLE SINGER(
		SINGERNO                      		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		NAME                          		VARCHAR2(50)		 NOT NULL,                            
		SEX                           		VARCHAR2(10)		 NOT NULL,
        COUNTRY                       		VARCHAR2(50)		 DEFAULT '-'       NOT NULL,
		INTRO                         		VARCHAR2(1000)		 DEFAULT '-'	 NOT NULL,
		PORTRAIT                      		VARCHAR2(100)		 NULL ,
		THUMB1                        		VARCHAR2(100)		 NULL ,
		SIZE1                          		NUMBER(10)		 DEFAULT 0	     NOT NULL,     
		SINGERREC                     		NUMBER(10)		 DEFAULT 0		 NOT NULL,
        genre VARCHAR(50)
);
COMMENT ON TABLE SINGER is '가수';
COMMENT ON COLUMN SINGER.SINGERNO is '가수번호';
COMMENT ON COLUMN SINGER.NAME is '가수이름';                                        
COMMENT ON COLUMN SINGER.SEX is '성별';
COMMENT ON COLUMN SINGER.COUNTRY is '국적';
COMMENT ON COLUMN SINGER.INTRO is '소개';
COMMENT ON COLUMN SINGER.PORTRAIT is '초상화';
COMMENT ON COLUMN SINGER.THUMB1 is '썸네일';
COMMENT ON COLUMN SINGER.SIZE1 is '파일크기';                                            
COMMENT ON COLUMN SINGER.SINGERREC is 'REC';
COMMENT ON COLUMN SINGER.GENRE is '장르';

  -- 시퀀스 생성
CREATE SEQUENCE singer_seq
  START WITH 1             
  INCREMENT BY 1          
  MAXVALUE 9999999999 
  CACHE 2                     
  NOCYCLE; 
--*************************************************************************--

  -- 컬럼 확인
SELECT * 
FROM singer
ORDER BY singerno ASC; 

  -- 테스트 용 생성
INSERT INTO singer(singerno, name, sex, country, intro, portrait, thumb1, size1, singerrec, genre)
VALUES (singer_seq.nextval, '박효신', '남성', '한국', '대장', 'phs.img', 'thumb.t', 2153, 10, 1);
  
INSERT INTO singer(singerno, name, sex, country, intro, portrait, thumb1, size1, singerrec, genre)
VALUES (singer_seq.nextval, '김범수', '남성', '한국', '얼굴없는 가수', 'kbs.img', 'thumb.t', 1533, 10, 1);

INSERT INTO singer(singerno, name, sex, country, intro, portrait, thumb1, size1, singerrec, genre)
VALUES (singer_seq.nextval, '윤도현', '남성', '한국', '락커', 'ydh.img', 'thumb.t', 7153, 20, 3);

  -- 삭제
DELETE singer
WHERE singerno = 1;

  -- 재 생성
INSERT INTO singer(singerno, name, sex, country, intro, portrait, thumb1, size1, singerrec, genre)
VALUES (1, '박효신', '남성', '한국', '대장', 'phs.img', 'thumb.t', 2153, 10, 1);

  -- 수정
UPDATE singer
SET intro='윤도현 밴드'
WHERE singerno = 3;

COMMIT;