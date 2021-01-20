/**********************************/
/* Table Name: 회원 */
/**********************************/
DROP TABLE member;
CREATE TABLE member(
    memberno                             NUMBER(10)     NOT NULL    PRIMARY KEY,
    membername                          VARCHAR2(20)     NOT NULL,
    file1                                   VARCHAR(100)          NULL,
    thumb1                              VARCHAR(100)          NULL,
    size1                                 NUMBER(10)      DEFAULT 0 NULL  
);


DROP SEQUENCE member_seq;
CREATE SEQUENCE member_seq
  START WITH 1              -- 시작 번호
  INCREMENT BY 1          -- 증가값
  MAXVALUE 9999999999 -- 최대값: 9999999 --> NUMBER(7) 대응
  CACHE 2                       -- 2번은 메모리에서만 계산
  NOCYCLE;                     -- 다시 1부터 생성되는 것을 방지
/*잠깐사용*/
-- 등록
INSERT INTO member(memberno, membername, file1, thumb1, size1)
VALUES(member_seq.nextval,'휜둥이','summer.jpg', 'summer_t.jpg', 23657);
INSERT INTO member(memberno, membername, file1, thumb1, size1)
VALUES(member_seq.nextval,'바둑이','summer.jpg', 'summer_t.jpg', 23657);
INSERT INTO member(memberno, membername, file1, thumb1, size1)
VALUES(member_seq.nextval,'알파고','summer.jpg', 'summer_t.jpg', 23657);

-- 목록
SELECT memberno,membername,file1, thumb1, size1
FROM member
ORDER BY memberno ASC;
-- 조회
SELECT memberno,membername
FROM member
WHERE memberno=1;
-- 수정
UPDATE member
SET member_name='시진핑'
WHERE memberno=1;
commit;
-- 삭제
DELETE member
WHERE memberno = 1;

COMMIT;
SELECT * FROM member;
COMMENT ON TABLE member is '회원';
COMMENT ON COLUMN member.memberno is '회원 번호';


/**********************************/
/* Table Name: 플레이 리스트 */
/**********************************/
DROP TABLE playlist;
CREATE TABLE playlist(
    playlistno                        NUMBER(10)     NOT NULL    PRIMARY KEY,
    playlistname                      VARCHAR2(20)     NOT NULL,
    cntmusic                          NUMBER(10)     DEFAULT 0     NOT NULL,
    memberno                             NUMBER(10)     NOT NULL,
    likes                              NUMBER(20)     DEFAULT 0     NOT NULL,
  FOREIGN KEY (memberno) REFERENCES member (memberno)
);

COMMENT ON TABLE playlist is '플레이 리스트';
COMMENT ON COLUMN playlist.playlistno is '플레이 리스트 번호';
COMMENT ON COLUMN playlist.playlistname is '플레이 리스트 이름';
COMMENT ON COLUMN playlist.cntmusic is '수록된 음악수';
COMMENT ON COLUMN playlist.memberno is '회원 번호';
COMMENT ON COLUMN playlist.likes is '좋아요';

DROP SEQUENCE playlist_seq;
CREATE SEQUENCE playlist_seq
  START WITH 1              -- 시작 번호
  INCREMENT BY 1          -- 증가값
  MAXVALUE 9999999999 -- 최대값: 9999999 --> NUMBER(7) 대응
  CACHE 2                       -- 2번은 메모리에서만 계산
  NOCYCLE;                     -- 다시 1부터 생성되는 것을 방지
-- 등록  
INSERT INTO playlist(playlistno, playlistname, cntmusic, memberno, likes)
VALUES(playlist_seq.nextval, '플레이리스트1', 1, 1, 1);

INSERT INTO playlist(playlistno, playlistname, cntmusic, memberno, likes)
VALUES(playlist_seq.nextval, '플레이리스트2', 1, 1, 1);

INSERT INTO playlist(playlistno, playlistname, cntmusic, memberno, likes)
VALUES(playlist_seq.nextval, '플레이리스트3', 1, 1, 1);

INSERT INTO playlist(playlistno, playlistname,  memberno )
VALUES(playlist_seq.nextval, '플레이리스트5',  1);
COMMIT;

SELECT * FROM playlist;
-- 목록
SELECT playlistno, playlistname, cntmusic, memberno, likes
FROM playlist
ORDER BY playlistno ASC;
-- 조회
SELECT playlistno, playlistname, cntmusic, memberno, likes
FROM playlist
WHERE playlistno=1;
--회원의 플레이리스트
SELECT playlistno, playlistname, cntmusic, memberno, likes
FROM playlist
WHERE memberno=1;

-- 수정
UPDATE playlist
SET playlistname='플레이리스트4', cntmusic=1, memberno=1, likes=1
WHERE playlistno=1;
commit;
-- 삭제
DELETE playlist
WHERE playlistno = 1;
--$$$$$$$$$$$$$$$[회원버젼]$$$$$$$$$$$$$--
UPDATE playlist
SET playlistname='회원수정'
WHERE playlistno=1 AND memberno=1;

DELETE playlist
WHERE playlistno = 2 AND memberno=1;




/**********************************/
/* Table Name: 음악 */
/**********************************/
DROP TABLE music;
CREATE TABLE music(
    musicno                           NUMBER(10)     NOT NULL      PRIMARY KEY,
    music_lnk                         VARCHAR(100),
    music                             VARCHAR(100)   NOT NULL
);

CREATE SEQUENCE music_seq
  START WITH 1              -- 시작 번호
  INCREMENT BY 1          -- 증가값
  MAXVALUE 9999999999 -- 최대값: 9999999 --> NUMBER(7) 대응
  CACHE 2                       -- 2번은 메모리에서만 계산
  NOCYCLE;                     -- 다시 1부터 생성되는 것을 방지
  

INSERT INTO music(musicno, music_lnk, music)
VALUES(music_seq.nextval, 'aaa','음악1');

INSERT INTO music(musicno, music_lnk, music)
VALUES(music_seq.nextval, 'bbb','음악2');

INSERT INTO music(musicno, music_lnk, music)
VALUES(music_seq.nextval, 'ccc','음악3');

INSERT INTO music(musicno, music_lnk, music)
VALUES(music_seq.nextval, 'ddd','음악4');

commit;


/**********************************/
/* Table Name: 재생 음악 */
/**********************************/
DROP TABLE music_playlist;
CREATE TABLE music_playlist(
    music_playlistno                  NUMBER(10)     NOT NULL    PRIMARY KEY,
    playlistno                        NUMBER(10)     NOT NULL,
    playing_seq                       NUMBER(10)     NOT NULL,
    musicno                           NUMBER(10)     NOT NULL,
  FOREIGN KEY (playlistno) REFERENCES playlist (playlistno),
  FOREIGN KEY (musicno) REFERENCES music (musicno)
);

COMMENT ON TABLE music_playlist is '재생 음악';
COMMENT ON COLUMN music_playlist.music_playlistno is '재생 음악 번호';
COMMENT ON COLUMN music_playlist.playlistno is '플레이 리스트 번호';
COMMENT ON COLUMN music_playlist.playing_seq is '재생 순서';
COMMENT ON COLUMN music_playlist.musicno is '음악 번호';

DROP SEQUENCE music_playlist_seq;
CREATE SEQUENCE music_playlist_seq
  START WITH 1              -- 시작 번호
  INCREMENT BY 1          -- 증가값
  MAXVALUE 9999999999 -- 최대값: 9999999 --> NUMBER(7) 대응
  CACHE 2                       -- 2번은 메모리에서만 계산
  NOCYCLE;                     -- 다시 1부터 생성되는 것을 방지
  
-- 등록  
INSERT INTO music_playlist(music_playlistno, playlistno, playing_seq, musicno)
VALUES(music_playlist_seq.nextval, 1, 1, 1);

INSERT INTO music_playlist(music_playlistno, playlistno, playing_seq, musicno)
VALUES(music_playlist_seq.nextval, 1, 1, 2);

INSERT INTO music_playlist(music_playlistno, playlistno, playing_seq, musicno)
VALUES(music_playlist_seq.nextval, 1, 1, 3);

INSERT INTO music_playlist(music_playlistno, playlistno, playing_seq, musicno)
VALUES(music_playlist_seq.nextval, 1, 2, 4);

COMMIT;

SELECT * FROM music_playlist;
-- 목록
SELECT music_playlistno, playlistno, playing_seq, musicno
FROM music_playlist
ORDER BY playlistno ASC;
-- 조회
SELECT music_playlistno, playlistno, playing_seq, musicno
FROM music_playlist
WHERE music_playlistno=1;
-- 수정
UPDATE music_playlist
SET musicno=4
WHERE music_playlistno=1;
commit;
-- 삭제
DELETE music_playlist
WHERE music_playlistno = 1;

-- 음악,플레이리스트 조인

SELECT mp.music_playlistno, mp.playlistno, mp.playing_seq, m.music as m_music, m.musicno as m_musicno
FROM music_playlist mp, music m
WHERE mp.musicno = m.musicno AND mp.playlistno =1
ORDER BY playing_seq ASC;

COMMIT;

-- 검색된 레코드/ 검색된 레코드 수
SELECT mp.music_playlistno, mp.playlistno, mp.playing_seq, m.music as m_music, m.musicno as m_musicno
FROM music_playlist mp, music m
WHERE mp.musicno = m.musicno AND mp.playlistno =1 AND m.music LIKE '%음악2%'
ORDER BY playing_seq ASC;

SELECT COUNT(*) as cnt
FROM music_playlist mp, music m
WHERE mp.musicno = m.musicno AND mp.playlistno =1 AND m.music LIKE '%음악2%';

-- 검색과 페이징
SELECT music_playlistno, playlistno, playing_seq, m_music, m_musicno, r
FROM(
    SELECT music_playlistno, playlistno, playing_seq, m_music, m_musicno, rownum as r
    FROM (
        SELECT mp.music_playlistno, mp.playlistno, mp.playing_seq, m.music as m_music, m.musicno as m_musicno
        FROM music_playlist mp, music m
        WHERE mp.musicno = m.musicno AND mp.playlistno =1 AND m.music LIKE '%음악%'
        ORDER BY playing_seq ASC
    )
)
WHERE r >= 1 AND r <=3;

-- 회원 별 플레이리스트 등록
INSERT INTO playlist(playlistno, playlistname, memberno)
VALUES(playlist_seq.nextval, '잔잔한',  1);

SELECT * FROM playlist;

/**********************************/
/* Table Name:     공지사항        */
/**********************************/
DROP TABLE notice;
CREATE TABLE notice(
    noticeno                             NUMBER(10)     NOT NULL    PRIMARY KEY,
    title                              VARCHAR2(300)    NOT NULL,
    contents                                   CLOB     NOT NULL,
    rdate                                      DATE     NOT NULL 
);

DROP SEQUENCE notice_seq;
CREATE SEQUENCE notice_seq
  START WITH 1              -- 시작 번호
  INCREMENT BY 1          -- 증가값
  MAXVALUE 9999999999 -- 최대값: 9999999 --> NUMBER(7) 대응
  CACHE 2                       -- 2번은 메모리에서만 계산
  NOCYCLE;                     -- 다시 1부터 생성되는 것을 방지

-- 등록
INSERT INTO notice(noticeno, title, contents, rdate)
VALUES(notice_seq.nextval,'제목1','내용1', sysdate);
INSERT INTO notice(noticeno, title, contents, rdate)
VALUES(notice_seq.nextval,'제목2','내용2', sysdate);
INSERT INTO notice(noticeno, title, contents, rdate)
VALUES(notice_seq.nextval,'제목3','내용3', sysdate);

-- 목록
SELECT noticeno, title ,rdate
FROM notice
ORDER BY noticeno DESC;

-- 조회
SELECT noticeno, title, contents, rdate
FROM notice
WHERE noticeno = 1;

-- 수정
UPDATE notice
SET title='시진핑', contents='중국몽', rdate=sysdate
WHERE noticeno = 1;

commit;
-- 삭제
DELETE notice
WHERE noticeno = 1;












  
  
