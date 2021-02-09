DROP TABLE music;
DROP SEQUENCE music_seq; 

/**********************************/
/*      Table Name: 음악        */
/**********************************/
CREATE TABLE MUSIC(
		MUSICNO                       		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		TITLE                         		VARCHAR2(50)		 NOT NULL,
		SINGER                        		VARCHAR2(20)		 NOT NULL,
		ALBUM                         		VARCHAR2(30)		 NOT NULL,
		GENRE                         		VARCHAR2(30)		 NOT NULL,
		RDATE                         		DATE		 NOT NULL,
		LYRICS                        		CLOB  	 NULL ,
		LIKELIST                      		CHAR(1)		 DEFAULT 'N'		 NOT NULL,
		LIKESU                        		NUMBER(10)		 DEFAULT 0		 NOT NULL,
		MP3                           		VARCHAR2(1000)		 NULL ,
		FILE1                         		VARCHAR2(100)		 NULL ,
		THUMB1                        		VARCHAR2(100)		 NULL ,
		MUSICLONG                     		NUMBER(10)		 NULL ,
		PASSWD                        		VARCHAR2(15)		 NULL ,
		YOUTUBE                       		VARCHAR2(1000)		 NULL ,
		REPLYCNT                      		NUMBER(7)		 DEFAULT 0		 NOT NULL,
		CNT                           		NUMBER(7)		 DEFAULT 0		 NOT NULL,
		WORD                        		VARCHAR2(300)		 NULL ,
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
COMMENT ON COLUMN MUSIC.RDATE is '등록일';
COMMENT ON COLUMN MUSIC.LYRICS is '가사';
COMMENT ON COLUMN MUSIC.LIKELIST is '좋아요리스트추가';
COMMENT ON COLUMN MUSIC.LIKESU is '좋아요 수';
COMMENT ON COLUMN MUSIC.MP3 is 'mp3';
COMMENT ON COLUMN MUSIC.FILE1 is '파일';
COMMENT ON COLUMN MUSIC.THUMB1 is '썸네일';
COMMENT ON COLUMN MUSIC.MUSICLONG is '재생시간';
COMMENT ON COLUMN MUSIC.PASSWD is '비밀번호';
COMMENT ON COLUMN MUSIC.YOUTUBE is '유튜브주소';
COMMENT ON COLUMN MUSIC.REPLYCNT is '댓글 수';
COMMENT ON COLUMN MUSIC.CNT is '음악 게시글 수';
COMMENT ON COLUMN MUSIC.WORD is '내용';
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
INSERT INTO music(musicno, title, singer, album, genre, rdate, lyrics, likelist, likesu, mp3, file1, thumb1, musiclong, passwd, youtube,
                           replycnt, cnt, word, albumno, singerno, genreno)
VALUES(music_seq.nextval, '숨', '박효신', 'I am A Dreamer', '발라드', sysdate, '꿈을 꾸고 있나봐 ...', 'N', 23513, 'mp3.mp3', 'file1.f', 'thumb1.t', 215, '1234', 'youtube',
                           155, 155, '박효신 노래', 1, 1, 1);
                           
INSERT INTO music(musicno, title, singer, album, genre, rdate, lyrics, likelist, likesu, mp3, file1, thumb1, musiclong, passwd, youtube,
                           replycnt, cnt, word, albumno, singerno, genreno)
VALUES(music_seq.nextval, '끝사랑', '김범수', 'Solista Part.2', '발라드', sysdate, '그대 오직 그대만이..', 'N', 2613, 'mp3.mp3', 'file1.f', 'thumb1.t', 273, '1234', 'youtube',
                           10, 10, '얼굴없는 가수', 2, 2, 1);
                           
INSERT INTO music(musicno, title, singer, album, genre, rdate, lyrics, likelist, likesu, mp3, file1, thumb1, musiclong, passwd, youtube,
                           replycnt, cnt, word, albumno, singerno, genreno)
VALUES(music_seq.nextval, '사랑했나봐', '윤도현', 'Difference', '락', sysdate, '사랑했나봐 잊을 수 없나봐...', 'Y', 1783, 'mp3.mp3', 'file1.f', 'thumb1.t', 191, '1234', 'youtube',
                           27, 27, '윤도현밴드', 3, 3, 3);

  -- 삭제 *음악재생리스트(music_playlist 존재시 삭제불가)*
DELETE music
WHERE musicno = 3;

  -- 재 생성
INSERT INTO music(musicno, title, singer, album, genre, rdate, lyrics, likelist, likesu, mp3, file1, thumb1, musiclong, passwd, youtube,
                           replycnt, cnt, word, albumno, singerno, genreno)
VALUES(3, '사랑했나봐', '윤도현', 'Difference', '락', sysdate, '사랑했나봐 잊을 수 없나봐...', 'Y', 1783, 'mp3.mp3', 'file1.f', 'thumb1.t', 191, '1234', 'youtube',
                           27, 27, '윤도현밴드', 3, 3, 3);

  -- 수정
UPDATE music
SET word='밴드활동'
WHERE musicno = 3;

COMMIT;