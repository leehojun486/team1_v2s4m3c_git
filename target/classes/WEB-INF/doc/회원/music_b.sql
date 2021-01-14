/**********************************/
/* Table Name: 회원 */
/**********************************/
CREATE TABLE members(
		memberno                      		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		name                          		VARCHAR2(50)		 NOT NULL,
		nicname                       		VARCHAR2(50)		 NOT NULL,
		memberiml                     		VARCHAR2(50)		 NOT NULL,
		memberid                      		VARCHAR2(50)		 NOT NULL,
		memberpass                    		VARCHAR2(50)		 NOT NULL,
		rdate                         		DATE		 NOT NULL,
		follow_num                    		NUMBER(10)		 NULL 
);

COMMENT ON TABLE members is '회원';
COMMENT ON COLUMN members.memberno is '회원번호';
COMMENT ON COLUMN members.name is '이름';
COMMENT ON COLUMN members.nicname is '닉네임';
COMMENT ON COLUMN members.memberiml is '이메일';
COMMENT ON COLUMN members.memberid is '아이디';
COMMENT ON COLUMN members.memberpass is '비밀번호';
COMMENT ON COLUMN members.rdate is '회원 생성일';
COMMENT ON COLUMN members.follow_num is '구독번호';


/**********************************/
/* Table Name: 회원구독 */
/**********************************/
CREATE TABLE follow(
		memberno                      		NUMBER(10)		 NOT NULL,
		follow_num                    		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		nicname                       		VARCHAR2(50)		 NOT NULL,
		follow_visible                		CHAR(1)		 DEFAULT 'N'		 NOT NULL,
		follow_date                   		DATE		 NOT NULL,
  FOREIGN KEY (memberno) REFERENCES members (memberno)
);

COMMENT ON TABLE follow is '회원구독';
COMMENT ON COLUMN follow.memberno is '회원번호';
COMMENT ON COLUMN follow.follow_num is '구독번호';
COMMENT ON COLUMN follow.nicname is '닉네임';
COMMENT ON COLUMN follow.follow_visible is '구독';
COMMENT ON COLUMN follow.follow_date is '등록일';


/**********************************/
/* Table Name: 좋아요 */
/**********************************/
CREATE TABLE like(
		musicnum                      		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		memberno                      		NUMBER(10)		 NOT NULL,
		like_visible                  		CHAR(1)		 DEFAULT 'N'		 NOT NULL,
  FOREIGN KEY (memberno) REFERENCES members (memberno)
);

COMMENT ON TABLE like is '좋아요';
COMMENT ON COLUMN like.musicnum is '음악번호';
COMMENT ON COLUMN like.memberno is '회원번호';
COMMENT ON COLUMN like.like_visible is '좋아요';


