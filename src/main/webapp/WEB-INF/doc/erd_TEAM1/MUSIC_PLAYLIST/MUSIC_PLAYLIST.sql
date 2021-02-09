DROP TABLE music_playlist;
DROP SEQUENCE music_playlist_seq; 

/************************************/
/* Table Name: 음악재생리스트 */
/************************************/
CREATE TABLE MUSIC_PLAYLIST(
		MUSIC_PLAYLISTNO              		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		PLAYING_SEQ                   		NUMBER(10)		 NOT NULL,
		PLAYLISTNO                    		NUMBER(10)		 NULL ,
		MUSICNO                       		NUMBER(10)		 NULL ,
  FOREIGN KEY (PLAYLISTNO) REFERENCES PLAYLIST (PLAYLISTNO),
  FOREIGN KEY (MUSICNO) REFERENCES MUSIC (MUSICNO)
);
COMMENT ON TABLE MUSIC_PLAYLIST is '음악재생리스트';
COMMENT ON COLUMN MUSIC_PLAYLIST.MUSIC_PLAYLISTNO is '음악재생리스트번호';
COMMENT ON COLUMN MUSIC_PLAYLIST.PLAYING_SEQ is '재생시퀀스번호';
COMMENT ON COLUMN MUSIC_PLAYLIST.PLAYLISTNO is '플레이리스트번호';
COMMENT ON COLUMN MUSIC_PLAYLIST.MUSICNO is '음악번호';

CREATE SEQUENCE music_playlist_seq
  START WITH 1             
  INCREMENT BY 1          
  MAXVALUE 9999999999 
  CACHE 2                     
  NOCYCLE;   
--*************************************************************************--

  -- 컬럼 확인
SELECT * 
FROM music_playlist
ORDER BY music_playlistno ASC; 

  -- 테스트 용 생성
INSERT INTO music_playlist(music_playlistno, playing_seq, playlistno, musicno)
VALUES(music_playlist_seq.nextval, 1, 1, 1);
  
  -- 삭제
DELETE music_playlist
WHERE music_playlistno = 1;

  -- 재 생성
INSERT INTO music_playlist(music_playlistno, playing_seq, playlistno, musicno)
VALUES(1, 1, 1, 1);

  -- 수정
UPDATE music_playlist
SET musicno=3
WHERE music_playlistno = 2;

COMMIT;