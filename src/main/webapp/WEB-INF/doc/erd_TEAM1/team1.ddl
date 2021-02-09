/**********************************/
/* Table Name: 장르 */
/**********************************/
CREATE TABLE GENRE(
		GENRENO                       		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		GENRENAME                     		VARCHAR2(50)		 NOT NULL
);

COMMENT ON TABLE GENRE is '장르';
COMMENT ON COLUMN GENRE.GENRENO is '장르번호';
COMMENT ON COLUMN GENRE.GENRENAME is '장르이름';


/**********************************/
/* Table Name: 앨범 */
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


/**********************************/
/* Table Name: 가수 */
/**********************************/
CREATE TABLE SINGER(
		SINGERNO                      		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		NAME                          		VARCHAR2(50)		 NOT NULL,
		SEX                           		VARCHAR2(10)		 NOT NULL,
		COUNTRY                       		VARCHAR2(50)		 DEFAULT '-'		 NOT NULL,
		INTRO                         		VARCHAR2(1000)		 DEFAULT '-'		 NOT NULL,
		PORTRAIT                      		VARCHAR2(100)		 NULL ,
		THUMB1                        		VARCHAR2(100)		 NULL ,
		SIZE1                         		NUMBER(10)		 DEFAULT 0		 NOT NULL,
		SINGERREC                     		NUMBER(10)		 DEFAULT 0		 NOT NULL,
		GENRE                         		VARCHAR2(50)		 NULL 
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


/**********************************/
/* Table Name: 음악 */
/**********************************/
CREATE TABLE MUSIC(
		MUSICNO                       		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		TITLE                         		VARCHAR2(50)		 NOT NULL,
		SINGER                        		VARCHAR2(20)		 NOT NULL,
		ALBUM                         		VARCHAR2(30)		 NOT NULL,
		GENRE                         		VARCHAR2(30)		 NOT NULL,
		RDATE                         		DATE		 NOT NULL,
		LYRICS                        		CLOB		 NULL ,
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
		WORD                          		VARCHAR2(300)		 NULL ,
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


/**********************************/
/* Table Name: 회원 */
/**********************************/
CREATE TABLE MEMBER(
		MEMBERNO                      		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		MEMBERNAME                    		VARCHAR2(50)		 NOT NULL,
		MEMBERNICNAME                 		VARCHAR2(50)		 NOT NULL,
		MEMBERIMG                     		VARCHAR2(100)		 NULL ,
		MEMBERPREVIEW                 		VARCHAR2(100)		 NULL ,
		MEMBERIMGSIZE                 		NUMBER(20)		 NULL ,
		MEMBEREML                     		VARCHAR2(50)		 NOT NULL,
		MEMBERID                      		VARCHAR2(50)		 NOT NULL,
		MEMBERPASS                    		VARCHAR2(50)		 NOT NULL,
		MEMBERDATE                    		DATE		 NOT NULL,
		MEMBERZIP                     		VARCHAR2(20)		 NULL ,
		MEMBERADD1                    		VARCHAR2(80)		 NULL ,
		MEMBERADD2                    		VARCHAR2(50)		 NULL 
);

COMMENT ON TABLE MEMBER is '회원';
COMMENT ON COLUMN MEMBER.MEMBERNO is '회원번호';
COMMENT ON COLUMN MEMBER.MEMBERNAME is '회원이름';
COMMENT ON COLUMN MEMBER.MEMBERNICNAME is '회원닉네임';
COMMENT ON COLUMN MEMBER.MEMBERIMG is '회원이미지';
COMMENT ON COLUMN MEMBER.MEMBERPREVIEW is '회원이미지미리보기';
COMMENT ON COLUMN MEMBER.MEMBERIMGSIZE is '회원이미지파일크기';
COMMENT ON COLUMN MEMBER.MEMBEREML is '회원이메일';
COMMENT ON COLUMN MEMBER.MEMBERID is '회원아이디';
COMMENT ON COLUMN MEMBER.MEMBERPASS is '회원비밀번호';
COMMENT ON COLUMN MEMBER.MEMBERDATE is '회원생성일';
COMMENT ON COLUMN MEMBER.MEMBERZIP is '회원압축파일';
COMMENT ON COLUMN MEMBER.MEMBERADD1 is '회원주소1';
COMMENT ON COLUMN MEMBER.MEMBERADD2 is '회원주소2';


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


/**********************************/
/* Table Name: 음악재생리스트 */
/**********************************/
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


/**********************************/
/* Table Name: 공지사항 */
/**********************************/
CREATE TABLE NOTICE(
		NOTICENO                      		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		TITLE                         		VARCHAR2(300)		 NOT NULL,
		CONTENTS                      		CLOB		 NOT NULL,
		RDATE                         		DATE		 NOT NULL
);

COMMENT ON TABLE NOTICE is '공지사항';
COMMENT ON COLUMN NOTICE.NOTICENO is '공지사항번호';
COMMENT ON COLUMN NOTICE.TITLE is '공지사항제목';
COMMENT ON COLUMN NOTICE.CONTENTS is '내용';
COMMENT ON COLUMN NOTICE.RDATE is '작성일';


/**********************************/
/* Table Name: 가수리뷰 */
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


/**********************************/
/* Table Name: 관리자 */
/**********************************/
CREATE TABLE ADMIN(
		ADMINNO                       		NUMBER(6)		 NOT NULL		 PRIMARY KEY,
		ADMINID                       		VARCHAR2(20)		 NOT NULL,
		ADMINPASS                     		VARCHAR2(60)		 NOT NULL,
		ADMINNAME                     		VARCHAR2(20)		 NOT NULL
);

COMMENT ON TABLE ADMIN is '관리자';
COMMENT ON COLUMN ADMIN.ADMINNO is '관리자번호';
COMMENT ON COLUMN ADMIN.ADMINID is '관리자아이디';
COMMENT ON COLUMN ADMIN.ADMINPASS is '관리자비밀번호';
COMMENT ON COLUMN ADMIN.ADMINNAME is '관리자이름';


/**********************************/
/* Table Name: 자주묻는질문 */
/**********************************/
CREATE TABLE FAQ(
		FAQNO                         		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		FAQTITLE                      		VARCHAR2(50)		 NOT NULL,
		FAQCONTENT                    		VARCHAR2(50)		 NULL ,
		ADMINPASS                     		VARCHAR2(15)		 NOT NULL,
		FAQWORD                       		VARCHAR2(300)		 NULL ,
		FAQRDATE                      		DATE		 NOT NULL,
		ADMINNO                       		NUMBER(6)		 NULL ,
  FOREIGN KEY (ADMINNO) REFERENCES ADMIN (ADMINNO)
);

COMMENT ON TABLE FAQ is '자주묻는질문';
COMMENT ON COLUMN FAQ.FAQNO is '질문번호';
COMMENT ON COLUMN FAQ.FAQTITLE is '질문제목';
COMMENT ON COLUMN FAQ.FAQCONTENT is '질문내용';
COMMENT ON COLUMN FAQ.ADMINPASS is '관리자비밀번호';
COMMENT ON COLUMN FAQ.FAQWORD is '질문단어';
COMMENT ON COLUMN FAQ.FAQRDATE is '질문작성일';
COMMENT ON COLUMN FAQ.ADMINNO is '관리자번호';


/**********************************/
/* Table Name: 설문조사 */
/**********************************/
CREATE TABLE SURVEY(
		SURVEYNO                      		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		TITLE                         		VARCHAR2(100)		 NOT NULL,
		RDATE                         		DATE		 NOT NULL
);

COMMENT ON TABLE SURVEY is '설문조사';
COMMENT ON COLUMN SURVEY.SURVEYNO is '설문조사번호';
COMMENT ON COLUMN SURVEY.TITLE is '설문조사제목';
COMMENT ON COLUMN SURVEY.RDATE is '작성일';


/**********************************/
/* Table Name: 질문 */
/**********************************/
CREATE TABLE QUESTION(
		QUESTIONNO                    		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		QUESTIONLIST                  		VARCHAR2(100)		 NOT NULL,
		QUESTIONCNT                   		NUMBER(7)		 DEFAULT 0		 NOT NULL,
		SURVEYNO                      		NUMBER(10)		 NULL ,
  FOREIGN KEY (SURVEYNO) REFERENCES SURVEY (SURVEYNO)
);

COMMENT ON TABLE QUESTION is '질문';
COMMENT ON COLUMN QUESTION.QUESTIONNO is '질문번호';
COMMENT ON COLUMN QUESTION.QUESTIONLIST is '질문목록';
COMMENT ON COLUMN QUESTION.QUESTIONCNT is '질문 수';
COMMENT ON COLUMN QUESTION.SURVEYNO is '설문조사번호';


