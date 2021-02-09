DROP TABLE genre;
DROP SEQUENCE genre_seq; 

/**********************************/
/*      Table Name: 장르        */
/**********************************/
CREATE TABLE GENRE(
		GENRENO                       		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		GENRENAME                     		VARCHAR2(50)		 NOT NULL
);
COMMENT ON TABLE GENRE is '장르';
COMMENT ON COLUMN GENRE.GENRENO is '장르번호';
COMMENT ON COLUMN GENRE.GENRENAME is '장르이름';

  -- 시퀀스 생성
CREATE SEQUENCE genre_seq
  START WITH 1             
  INCREMENT BY 1          
  MAXVALUE 9999999999 
  CACHE 2                     
  NOCYCLE; 
--*************************************************************************--

  -- 컬럼 확인
SELECT * 
FROM genre
ORDER BY genreno ASC; 

  -- 테스트 용 생성
INSERT INTO genre(genreno, genrename)
VALUES (genre_seq.nextval, '발라드');

INSERT INTO genre(genreno, genrename)
VALUES (genre_seq.nextval, '팝송');

INSERT INTO genre(genreno, genrename)
VALUES (genre_seq.nextval, '락');

  -- 삭제
DELETE genre
WHERE genreno = 1;

  -- 재 생성
INSERT INTO genre(genreno, genrename)
VALUES (1, '발라드');

  -- 수정
UPDATE genre
SET genrename='어쿠스틱'
WHERE genreno = 2;

COMMIT;