/**********************************/
/* Table Name: 회원 */
/**********************************/
CREATE TABLE members(
		mb_no                         		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		mb_name                       		VARCHAR2(50)		 NOT NULL,
		mb_nicname                    		VARCHAR2(50)		 NOT NULL,
		mb_iml                        		VARCHAR2(50)		 NOT NULL,
		mb_id                         		VARCHAR2(50)		 NOT NULL,
		mb_pass                       		VARCHAR2(50)		 NOT NULL,
		mb_date                       		DATE		 NOT NULL
);

COMMENT ON TABLE members is '회원';
COMMENT ON COLUMN members.mb_no is '회원번호';
COMMENT ON COLUMN members.mb_name is '이름';
COMMENT ON COLUMN members.mb_nicname is '닉네임';
COMMENT ON COLUMN members.mb_iml is '이메일';
COMMENT ON COLUMN members.mb_id is '아이디';
COMMENT ON COLUMN members.mb_pass is '비밀번호';
COMMENT ON COLUMN members.mb_date is '회원 생성일';


/**********************************/
/* Table Name: 회원구독 */
/**********************************/
CREATE TABLE follow(
		mb_no                         		NUMBER(10)		 NOT NULL,
		fo_num                        		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		fo_nicname                    		VARCHAR2(50)		 NOT NULL,
		fo_visible                    		CHAR(1)		 DEFAULT 'N'		 NOT NULL,
		fo_date                       		DATE		 NOT NULL,
  FOREIGN KEY (mb_no) REFERENCES members (mb_no)
);

COMMENT ON TABLE follow is '회원구독';
COMMENT ON COLUMN follow.mb_no is '회원번호';
COMMENT ON COLUMN follow.fo_num is '구독번호';
COMMENT ON COLUMN follow.fo_nicname is '닉네임';
COMMENT ON COLUMN follow.fo_visible is '구독';
COMMENT ON COLUMN follow.fo_date is '등록일';


/**********************************/
/* Table Name: 좋아요 */
/**********************************/
CREATE TABLE like(
		musicnum                      		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		memberno                      		NUMBER(10)		 NOT NULL,
		like_visible                  		CHAR(1)		 DEFAULT 'N'		 NOT NULL
);

COMMENT ON TABLE like is '좋아요';
COMMENT ON COLUMN like.musicnum is '음악번호';
COMMENT ON COLUMN like.memberno is '회원번호';
COMMENT ON COLUMN like.like_visible is '좋아요';


