DROP TABLE playlist;
DROP SEQUENCE playlist_seq; 

/**********************************/
/* Table Name: 플레이리스트 */
/**********************************/
CREATE TABLE PLAYLIST(
		PLAYLISTNO                    		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		PLAYLISTNAME                  		VARCHAR2(20)		 NOT NULL,
		CNTMUSIC                      		NUMBER(10)		 DEFAULT 0		 NOT NULL,
		LIKES                         		NUMBER(20)		 DEFAULT 0		 NOT NULL,
		MEMBERNO                      		NUMBER(10)		 NULL ,
  FOREIGN KEY (MEMBERNO) REFERENCES MEMBER (MEMBERNO)
);
COMMENT ON TABLE PLAYLIST is '플레이리스트';
COMMENT ON COLUMN PLAYLIST.PLAYLISTNO is '플레이리스트번호';
COMMENT ON COLUMN PLAYLIST.PLAYLISTNAME is '플레이리스트이름';
COMMENT ON COLUMN PLAYLIST.CNTMUSIC is '음악 수';
COMMENT ON COLUMN PLAYLIST.LIKES is '플레이리스트 좋아요 수';
COMMENT ON COLUMN PLAYLIST.MEMBERNO is '회원번호';

CREATE SEQUENCE playlist_seq
  START WITH 1             
  INCREMENT BY 1          
  MAXVALUE 9999999999 
  CACHE 2                     
  NOCYCLE;   
--*************************************************************************--

  -- 컬럼 확인
SELECT * 
FROM playlist
ORDER BY playlistno ASC; 

  -- 테스트 용 생성
INSERT INTO playlist(playlistno, playlistname, cntmusic, likes, memberno)
VALUES(playlist_seq.nextval, '재생리스트1', 0, 0, 1);
  
INSERT INTO playlist(playlistno, playlistname, cntmusic, likes, memberno)
VALUES(playlist_seq.nextval, '재생리스트2', 0, 0, 2);

INSERT INTO playlist(playlistno, playlistname, cntmusic, likes, memberno)
VALUES(playlist_seq.nextval, '재생리스트3', 0, 0, 3);
  
  -- 삭제
DELETE playlist
WHERE playlistno = 1;

  -- 재 생성
INSERT INTO playlist(playlistno, playlistname, cntmusic, likes, memberno)
VALUES(1, '재생리스트1', 0, 0, 1);

  -- 수정
UPDATE playlist
SET playlistname='재생리스트one'
WHERE playlistno = 1;

COMMIT;