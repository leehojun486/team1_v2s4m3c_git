DROP TABLE album;
DROP SEQUENCE album_seq; 

/**********************************/
/*      Table Name: 앨범       */
/**********************************/
CREATE TABLE ALBUM(
		ALBUMNO                       		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		TITLE                         		VARCHAR2(30)		 NOT NULL,
		ARTIST                        		VARCHAR2(20)		 NOT NULL,
		GENRE                         		VARCHAR2(50)		 NOT NULL,
		MUSICTITLE                    		VARCHAR2(50)		 NOT NULL,
		LISTNO                        		NUMBER(3)		 NOT NULL,
		GENRENO                       		NUMBER(10)		 NULL ,
  FOREIGN KEY (GENRENO) REFERENCES GENRE (GENRENO)
);

COMMENT ON TABLE ALBUM is '앨범';
COMMENT ON COLUMN ALBUM.ALBUMNO is '앨범번호';
COMMENT ON COLUMN ALBUM.TITLE is '앨범제목';
COMMENT ON COLUMN ALBUM.ARTIST is '아티스트';
COMMENT ON COLUMN ALBUM.GENRE is '장르';
COMMENT ON COLUMN ALBUM.MUSICTITLE is '타이틀음악제목';
COMMENT ON COLUMN ALBUM.LISTNO is '타이틀음악번호';
COMMENT ON COLUMN ALBUM.GENRENO is '장르번호';

CREATE SEQUENCE album_seq
  START WITH 1             
  INCREMENT BY 1          
  MAXVALUE 9999999999 
  CACHE 2                     
  NOCYCLE;   
--*************************************************************************--

  -- 컬럼 확인
SELECT * 
FROM album
ORDER BY albumno ASC; 

  -- 테스트 용 생성
INSERT INTO album(albumno, title, artist, genre, musictitle, listno, genreno)
VALUES(album_seq.nextval, 'I am A Dreamer', '박효신', '발라드', '숨', 1, 1);

INSERT INTO album(albumno, title, artist, genre, musictitle, listno, genreno)
VALUES(album_seq.nextval, 'solista part.2', '김범수', '발라드', '끝사랑', 1, 1);

INSERT INTO album(albumno, title, artist, genre, musictitle, listno, genreno)
VALUES(album_seq.nextval, 'Difference', '윤도현', '락', '사랑했나봐', 1, 3);

  -- 삭제
DELETE album
WHERE albumno = 1;

  -- 재 생성
INSERT INTO album(albumno, title, artist, genre, musictitle, listno, genreno)
VALUES(1, 'I am A Dreamer', '박효신', '발라드', '숨', 1, 1);

  -- 수정
UPDATE album
SET title='Solista Part.2'
WHERE albumno = 2;

COMMIT;