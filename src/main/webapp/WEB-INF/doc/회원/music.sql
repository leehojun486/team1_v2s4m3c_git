/**********************************/
/* 테이블삭제 */
/**********************************/
 DROP TABLE member;
 DROP TABLE follow;
 DROP TABLE followlist;
 DROP SEQUENCE follow_seq;
 DROP SEQUENCE member_seq;
 DROP SEQUENCE followlist_seq;
 
select * from member;
select * from follow;
  /*
  memberno INT NOT NULL AUTO_INCREMENT, -- 회원 번호, 레코드를 구분하는 컬럼 
  id           VARCHAR(20)   NOT NULL UNIQUE, -- 아이디, 중복 안됨, 레코드를 구분 
  passwd    VARCHAR(20)   NOT NULL, -- 패스워드, 영숫자 조합
  mname    VARCHAR(20)   NOT NULL, -- 성명, 한글 10자 저장 가능
  tel          VARCHAR(14)   NOT NULL, -- 전화번호
  zipcode   VARCHAR(5)        NULL, -- 우편번호, 12345
  address1  VARCHAR(80)       NULL, -- 주소 1
  address2  VARCHAR(50)       NULL, -- 주소 2
  mdate     DATETIME            NOT NULL, -- 가입일    
  PRIMARY KEY (mno)             -- 한번 등록된 값은 중복 안됨 
  */
/**********************************/
/* Table Name: 회원 */
/**********************************/
CREATE TABLE member(
		memberno                      		    NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		membername                    		VARCHAR2(50)		 NOT NULL,
		membernicname                 		VARCHAR2(50)		 NOT NULL,
        memberimg                             VARCHAR2(100),
        memberpreview                         VARCHAR2(100),
        memberimgsize                          number(20),
		membereml                     		VARCHAR2(50)		 NOT NULL,
        memberzip                           VARCHAR(5 ),
        memberadd1                           VARCHAR(80),
        memberadd2                           VARCHAR(50),
		memberid                      		VARCHAR2(50)		 NOT NULL,
		memberpass                    		VARCHAR2(50)		 NOT NULL,
		memberdate                    		DATE		 NOT NULL
);

COMMENT ON TABLE member is '회원';
COMMENT ON COLUMN member.memberno is '회원번호';
COMMENT ON COLUMN member.membername is '이름';
COMMENT ON COLUMN member.membernicname is '닉네임';
COMMENT ON COLUMN member.memberimg is '회원이미지';
COMMENT ON COLUMN member.memberpreview is '회원이미지미리보기';
COMMENT ON COLUMN member.memberimgsize is '이미지크기';
COMMENT ON COLUMN member.membereml is '이메일';
COMMENT ON COLUMN member.memberid is '아이디';
COMMENT ON COLUMN member.memberpass is '비밀번호';
COMMENT ON COLUMN member.memberdate is '회원 생성일';
COMMENT ON COLUMN member.memberzip is '우편번호';
COMMENT ON COLUMN member.memberadd1 is '주소1';
COMMENT ON COLUMN member.memberadd1 is '주소2';
/**********************************/
/* Table Name: 회원구독 */
/**********************************/
CREATE TABLE follow(
		followno                      		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		followvisible                 		CHAR(1)		 DEFAULT 'N'		 NOT NULL,
		followdate                    		DATE		 NOT NULL,
		memberno                      		NUMBER(10)		 NOT NULL,
        cnt                                     NUMBER(10),  
  FOREIGN KEY (memberno) REFERENCES member (memberno)
);



COMMENT ON TABLE follow is '회원구독';
COMMENT ON COLUMN follow.followno is '구독번호';
COMMENT ON COLUMN follow.followvisible is '구독활성/비활성';
COMMENT ON COLUMN follow.followdate is '등록일';
COMMENT ON COLUMN follow.memberno is '회원번호';

/**********************************/
/* Table Name: 구독 리스트 */
/**********************************/
CREATE TABLE followlist(
		followno                      		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		followlistprint               		NUMBER(10)		 NOT NULL,
  FOREIGN KEY (followno) REFERENCES follow (followno)
);

COMMENT ON TABLE followlist is '구독 리스트';
COMMENT ON COLUMN followlist.followno is '구독번호';
COMMENT ON COLUMN followlist.followlistprint is '구독출력';


--SEQUENCE
CREATE SEQUENCE member_seq
  START WITH 1              -- 시작 번호
  INCREMENT BY 1          -- 증가값
  MAXVALUE 9999999999 -- 최대값: 9999999 --> NUMBER(7) 대응
  CACHE 2                       -- 2번은 메모리에서만 계산
  NOCYCLE;                     -- 다시 1부터 생성되는 것을 방지
  
  commit;

--SEQUENCE
CREATE SEQUENCE follow_seq
  START WITH 1              -- 시작 번호
  INCREMENT BY 1          -- 증가값
  MAXVALUE 9999999999 -- 최대값: 9999999 --> NUMBER(7) 대응
  CACHE 2                       -- 2번은 메모리에서만 계산
  NOCYCLE;                     -- 다시 1부터 생성되는 것을 방지
  
  --SEQUENCE
CREATE SEQUENCE followlist_seq
  START WITH 1              -- 시작 번호
  INCREMENT BY 1          -- 증가값
  MAXVALUE 9999999999 -- 최대값: 9999999 --> NUMBER(7) 대응
  CACHE 2                       -- 2번은 메모리에서만 계산
  NOCYCLE;                     -- 다시 1부터 생성되는 것을 방지
  

--등록
 INSERT INTO member(memberno, membername, membernicname, membereml, memberid, memberpass, memberdate)
 VALUES(member_seq.nextval, '호날두', '날강두','xx@naver.com', 'moon', 'passwd', sysdate);
 commit;

--등록 <구독>
 INSERT INTO follow(memberno, followno, followvisible, followdate)
 VALUES(1,follow_seq.nextval, 'N', sysdate);

--목록
 SELECT memberno, membername, membereml , memberid, memberpass, memberdate
 FROM member
 ORDER BY memberno ASC;

---목록 <구독>
 SELECT mb_no, fo_num, fo_nicname , fo_visible, fo_date
 FROM follow
 ORDER BY fo_num ASC;

--수정
 UPDATE members
 SET mb_name ='강아지'
 WHERE  mb_no=1;

--수정 <구독>
 UPDATE follow
 SET fo_visible='Y', fo_nicname= 'soldesk'
 WHERE  fo_num=1;

--삭제
 DELETE members
 WHERE memberno = 1;


    SELECT COUNT(*) as passwd_cnt
    FROM member
    WHERE memberno='1' AND memberpass= '1234';
    
    UPDATE member
    SET  membername='강아지', membernicname ='호날두', membereml='똥강아지'
    WHERE memberno = 1;
    
    commit;


 INSERT INTO member(memberno, membername, membernicname, membereml, memberid, memberpass, memberdate,
                               memberimg ,memberpreview , memberimgsize)
 VALUES(member_seq.nextval, #{membername}, #{membernicname}, #{membereml}, #{memberid},#{memberpass}, sysdate,
             #{memberimg}, #{memberpreview} , #{memberimgsize})
