DROP TABLE music;
DROP SEQUENCE music_seq; 

/**********************************/
/*      Table Name: 음악        */
/**********************************/
CREATE TABLE MUSIC(
		MUSICNO                       		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		TITLE                           		VARCHAR2(50)		 NOT NULL,
		SINGER                        		VARCHAR2(20)		 NOT NULL,
		ALBUM                         		VARCHAR2(30)		 NOT NULL,
		GENRE                         		VARCHAR2(30)		 NOT NULL,
		LIKESU                        		NUMBER(10)		 DEFAULT 0		 NOT NULL,
        PLAYSU                        		NUMBER(10)		 DEFAULT 0		 NOT NULL,
		YOUTUBE                       		VARCHAR2(1000)		 NULL ,
		ALBUMNO                       		NUMBER(10)		 NULL ,
		SINGERNO                      		NUMBER(10)		 NULL ,
		GENRENO                       		NUMBER(10)		 NULL ,
  FOREIGN KEY (ALBUMNO) REFERENCES ALBUM (ALBUMNO),
  FOREIGN KEY (SINGERNO) REFERENCES SINGER (SINGERNO),
  FOREIGN KEY (GENRENO) REFERENCES GENRE (GENRENO)
);
COMMENT ON TABLE MUSIC is '음악';
COMMENT ON COLUMN MUSIC.MUSICNO is '음악번호';
COMMENT ON COLUMN MUSIC.TITLE is '음악제목';
COMMENT ON COLUMN MUSIC.SINGER is '가수';
COMMENT ON COLUMN MUSIC.ALBUM is '앨범';
COMMENT ON COLUMN MUSIC.GENRE is '장르';
COMMENT ON COLUMN MUSIC.LIKESU is '좋아요 수';
COMMENT ON COLUMN MUSIC.PLAYSU is '재생 수';
COMMENT ON COLUMN MUSIC.YOUTUBE is '유튜브주소';
COMMENT ON COLUMN MUSIC.ALBUMNO is '앨범번호';
COMMENT ON COLUMN MUSIC.SINGERNO is '가수번호';
COMMENT ON COLUMN MUSIC.GENRENO is '장르번호';

 -- 시퀀스 생성
CREATE SEQUENCE music_seq
  START WITH 1             
  INCREMENT BY 1          
  MAXVALUE 9999999999 
  CACHE 2                     
  NOCYCLE;   
--*************************************************************************--

  -- 컬럼 확인
SELECT * 
FROM music
ORDER BY musicno ASC; 

  -- 테스트 용 생성
INSERT INTO music(musicno, title, singer, album, genre, likesu, playsu, youtube, albumno, singerno, genreno)
VALUES(music_seq.nextval, '숨', '박효신', 'I am A Dreamer', '발라드', 23513, 1000215, 'youtube', 1, 1, 1);
                           
INSERT INTO music(musicno, title, singer, album, genre, likesu, playsu, youtube, albumno, singerno, genreno)
VALUES(music_seq.nextval, '끝사랑', '김범수', 'Solista Part.2', '발라드', 2613, 211273, 'youtube', 2, 2, 1);
                           
INSERT INTO music(musicno, title, singer, album, genre, likesu, playsu, youtube, albumno, singerno, genreno)
VALUES(music_seq.nextval, '사랑했나봐', '윤도현', 'Difference', '락', 1783, 102191, 'youtube', 3, 3, 3);

  -- 삭제 *음악재생리스트(music_playlist 존재시 삭제불가)*
DELETE music
WHERE musicno = 3;

  -- 재 생성
INSERT INTO music(musicno, title, singer, album, genre, likesu, playsu, youtube, albumno, singerno, genreno)
VALUES(music_seq.nextval, '사랑했나봐', '윤도현', 'Difference', '락', 1783, 102191, 'youtube', 3, 3, 3);

  -- 수정
UPDATE music
SET title='사랑했나봐.'
WHERE musicno = 3;

COMMIT;