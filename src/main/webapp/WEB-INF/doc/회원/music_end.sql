drop table follow;
drop table members;
drop table 
/**********************************/
/* Table Name: 회원 */
/**********************************/
CREATE TABLE members(
		memberno                      		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		membername                    		VARCHAR2(50)		 NOT NULL,
		membernicname                 		VARCHAR2(50)		 NOT NULL,
		membereml                     		VARCHAR2(50)		 NOT NULL,
		memberid                      		VARCHAR2(50)		 NOT NULL,
		memberpass                    		VARCHAR2(50)		 NOT NULL,
		memberdate                    		DATE		 NOT NULL,
		followno                      		NUMBER(10)		 NOT NULL
);

COMMENT ON TABLE members is '회원';
COMMENT ON COLUMN members.memberno is '회원번호';
COMMENT ON COLUMN members.membername is '이름';
COMMENT ON COLUMN members.membernicname is '닉네임';
COMMENT ON COLUMN members.membereml is '이메일';
COMMENT ON COLUMN members.memberid is '아이디';
COMMENT ON COLUMN members.memberpass is '비밀번호';
COMMENT ON COLUMN members.memberdate is '회원 생성일';
COMMENT ON COLUMN members.followno is '구독번호';


/**********************************/
/* Table Name: 회원구독 */
/**********************************/
CREATE TABLE follow(
		followno                      		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		followvisible                 		CHAR(1)		 DEFAULT 'N'		 NOT NULL,
		followdate                    		DATE		 NOT NULL,
		memberno                      		NUMBER(10)		 NOT NULL,
		followlistno                  		NUMBER(10)		 NOT NULL,
  FOREIGN KEY (memberno) REFERENCES members (memberno)
);

COMMENT ON TABLE follow is '회원구독';
COMMENT ON COLUMN follow.followno is '구독번호';
COMMENT ON COLUMN follow.followvisible is '구독활성/비활성';
COMMENT ON COLUMN follow.followdate is '등록일';
COMMENT ON COLUMN follow.memberno is '회원번호';
COMMENT ON COLUMN follow.followlistno is '구독출력';


/**********************************/
/* Table Name: 구독 리스트 */
/**********************************/
CREATE TABLE follow_list(
		followno                      		NUMBER(10)		 NOT NULL,
		followlistprint               		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
  FOREIGN KEY (followno) REFERENCES follow (followno)
);

COMMENT ON TABLE follow_list is '구독 리스트';
COMMENT ON COLUMN follow_list.followno is '구독번호';
COMMENT ON COLUMN follow_list.followlistprint is '구독출력';


