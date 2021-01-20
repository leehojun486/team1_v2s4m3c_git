/**********************************/
/* Table Name: ȸ�� */
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
  START WITH 1              -- ���� ��ȣ
  INCREMENT BY 1          -- ������
  MAXVALUE 9999999999 -- �ִ밪: 9999999 --> NUMBER(7) ����
  CACHE 2                       -- 2���� �޸𸮿����� ���
  NOCYCLE;                     -- �ٽ� 1���� �����Ǵ� ���� ����
/*�����*/
-- ���
INSERT INTO member(memberno, membername, file1, thumb1, size1)
VALUES(member_seq.nextval,'�ص���','summer.jpg', 'summer_t.jpg', 23657);
INSERT INTO member(memberno, membername, file1, thumb1, size1)
VALUES(member_seq.nextval,'�ٵ���','summer.jpg', 'summer_t.jpg', 23657);
INSERT INTO member(memberno, membername, file1, thumb1, size1)
VALUES(member_seq.nextval,'���İ�','summer.jpg', 'summer_t.jpg', 23657);

-- ���
SELECT memberno,membername,file1, thumb1, size1
FROM member
ORDER BY memberno ASC;
-- ��ȸ
SELECT memberno,membername
FROM member
WHERE memberno=1;
-- ����
UPDATE member
SET member_name='������'
WHERE memberno=1;
commit;
-- ����
DELETE member
WHERE memberno = 1;

COMMIT;
SELECT * FROM member;
COMMENT ON TABLE member is 'ȸ��';
COMMENT ON COLUMN member.memberno is 'ȸ�� ��ȣ';


/**********************************/
/* Table Name: �÷��� ����Ʈ */
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

COMMENT ON TABLE playlist is '�÷��� ����Ʈ';
COMMENT ON COLUMN playlist.playlistno is '�÷��� ����Ʈ ��ȣ';
COMMENT ON COLUMN playlist.playlistname is '�÷��� ����Ʈ �̸�';
COMMENT ON COLUMN playlist.cntmusic is '���ϵ� ���Ǽ�';
COMMENT ON COLUMN playlist.memberno is 'ȸ�� ��ȣ';
COMMENT ON COLUMN playlist.likes is '���ƿ�';

DROP SEQUENCE playlist_seq;
CREATE SEQUENCE playlist_seq
  START WITH 1              -- ���� ��ȣ
  INCREMENT BY 1          -- ������
  MAXVALUE 9999999999 -- �ִ밪: 9999999 --> NUMBER(7) ����
  CACHE 2                       -- 2���� �޸𸮿����� ���
  NOCYCLE;                     -- �ٽ� 1���� �����Ǵ� ���� ����
-- ���  
INSERT INTO playlist(playlistno, playlistname, cntmusic, memberno, likes)
VALUES(playlist_seq.nextval, '�÷��̸���Ʈ1', 1, 1, 1);

INSERT INTO playlist(playlistno, playlistname, cntmusic, memberno, likes)
VALUES(playlist_seq.nextval, '�÷��̸���Ʈ2', 1, 1, 1);

INSERT INTO playlist(playlistno, playlistname, cntmusic, memberno, likes)
VALUES(playlist_seq.nextval, '�÷��̸���Ʈ3', 1, 1, 1);

INSERT INTO playlist(playlistno, playlistname,  memberno )
VALUES(playlist_seq.nextval, '�÷��̸���Ʈ5',  1);
COMMIT;

SELECT * FROM playlist;
-- ���
SELECT playlistno, playlistname, cntmusic, memberno, likes
FROM playlist
ORDER BY playlistno ASC;
-- ��ȸ
SELECT playlistno, playlistname, cntmusic, memberno, likes
FROM playlist
WHERE playlistno=1;
--ȸ���� �÷��̸���Ʈ
SELECT playlistno, playlistname, cntmusic, memberno, likes
FROM playlist
WHERE memberno=1;

-- ����
UPDATE playlist
SET playlistname='�÷��̸���Ʈ4', cntmusic=1, memberno=1, likes=1
WHERE playlistno=1;
commit;
-- ����
DELETE playlist
WHERE playlistno = 1;
--$$$$$$$$$$$$$$$[ȸ������]$$$$$$$$$$$$$--
UPDATE playlist
SET playlistname='ȸ������'
WHERE playlistno=1 AND memberno=1;

DELETE playlist
WHERE playlistno = 2 AND memberno=1;




/**********************************/
/* Table Name: ���� */
/**********************************/
DROP TABLE music;
CREATE TABLE music(
    musicno                           NUMBER(10)     NOT NULL      PRIMARY KEY,
    music_lnk                         VARCHAR(100),
    music                             VARCHAR(100)   NOT NULL
);

CREATE SEQUENCE music_seq
  START WITH 1              -- ���� ��ȣ
  INCREMENT BY 1          -- ������
  MAXVALUE 9999999999 -- �ִ밪: 9999999 --> NUMBER(7) ����
  CACHE 2                       -- 2���� �޸𸮿����� ���
  NOCYCLE;                     -- �ٽ� 1���� �����Ǵ� ���� ����
  

INSERT INTO music(musicno, music_lnk, music)
VALUES(music_seq.nextval, 'aaa','����1');

INSERT INTO music(musicno, music_lnk, music)
VALUES(music_seq.nextval, 'bbb','����2');

INSERT INTO music(musicno, music_lnk, music)
VALUES(music_seq.nextval, 'ccc','����3');

INSERT INTO music(musicno, music_lnk, music)
VALUES(music_seq.nextval, 'ddd','����4');

commit;


/**********************************/
/* Table Name: ��� ���� */
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

COMMENT ON TABLE music_playlist is '��� ����';
COMMENT ON COLUMN music_playlist.music_playlistno is '��� ���� ��ȣ';
COMMENT ON COLUMN music_playlist.playlistno is '�÷��� ����Ʈ ��ȣ';
COMMENT ON COLUMN music_playlist.playing_seq is '��� ����';
COMMENT ON COLUMN music_playlist.musicno is '���� ��ȣ';

DROP SEQUENCE music_playlist_seq;
CREATE SEQUENCE music_playlist_seq
  START WITH 1              -- ���� ��ȣ
  INCREMENT BY 1          -- ������
  MAXVALUE 9999999999 -- �ִ밪: 9999999 --> NUMBER(7) ����
  CACHE 2                       -- 2���� �޸𸮿����� ���
  NOCYCLE;                     -- �ٽ� 1���� �����Ǵ� ���� ����
  
-- ���  
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
-- ���
SELECT music_playlistno, playlistno, playing_seq, musicno
FROM music_playlist
ORDER BY playlistno ASC;
-- ��ȸ
SELECT music_playlistno, playlistno, playing_seq, musicno
FROM music_playlist
WHERE music_playlistno=1;
-- ����
UPDATE music_playlist
SET musicno=4
WHERE music_playlistno=1;
commit;
-- ����
DELETE music_playlist
WHERE music_playlistno = 1;

-- ����,�÷��̸���Ʈ ����

SELECT mp.music_playlistno, mp.playlistno, mp.playing_seq, m.music as m_music, m.musicno as m_musicno
FROM music_playlist mp, music m
WHERE mp.musicno = m.musicno AND mp.playlistno =1
ORDER BY playing_seq ASC;

COMMIT;

-- �˻��� ���ڵ�/ �˻��� ���ڵ� ��
SELECT mp.music_playlistno, mp.playlistno, mp.playing_seq, m.music as m_music, m.musicno as m_musicno
FROM music_playlist mp, music m
WHERE mp.musicno = m.musicno AND mp.playlistno =1 AND m.music LIKE '%����2%'
ORDER BY playing_seq ASC;

SELECT COUNT(*) as cnt
FROM music_playlist mp, music m
WHERE mp.musicno = m.musicno AND mp.playlistno =1 AND m.music LIKE '%����2%';

-- �˻��� ����¡
SELECT music_playlistno, playlistno, playing_seq, m_music, m_musicno, r
FROM(
    SELECT music_playlistno, playlistno, playing_seq, m_music, m_musicno, rownum as r
    FROM (
        SELECT mp.music_playlistno, mp.playlistno, mp.playing_seq, m.music as m_music, m.musicno as m_musicno
        FROM music_playlist mp, music m
        WHERE mp.musicno = m.musicno AND mp.playlistno =1 AND m.music LIKE '%����%'
        ORDER BY playing_seq ASC
    )
)
WHERE r >= 1 AND r <=3;

-- ȸ�� �� �÷��̸���Ʈ ���
INSERT INTO playlist(playlistno, playlistname, memberno)
VALUES(playlist_seq.nextval, '������',  1);

SELECT * FROM playlist;

/**********************************/
/* Table Name:     ��������        */
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
  START WITH 1              -- ���� ��ȣ
  INCREMENT BY 1          -- ������
  MAXVALUE 9999999999 -- �ִ밪: 9999999 --> NUMBER(7) ����
  CACHE 2                       -- 2���� �޸𸮿����� ���
  NOCYCLE;                     -- �ٽ� 1���� �����Ǵ� ���� ����

-- ���
INSERT INTO notice(noticeno, title, contents, rdate)
VALUES(notice_seq.nextval,'����1','����1', sysdate);
INSERT INTO notice(noticeno, title, contents, rdate)
VALUES(notice_seq.nextval,'����2','����2', sysdate);
INSERT INTO notice(noticeno, title, contents, rdate)
VALUES(notice_seq.nextval,'����3','����3', sysdate);

-- ���
SELECT noticeno, title ,rdate
FROM notice
ORDER BY noticeno DESC;

-- ��ȸ
SELECT noticeno, title, contents, rdate
FROM notice
WHERE noticeno = 1;

-- ����
UPDATE notice
SET title='������', contents='�߱���', rdate=sysdate
WHERE noticeno = 1;

commit;
-- ����
DELETE notice
WHERE noticeno = 1;












  
  
