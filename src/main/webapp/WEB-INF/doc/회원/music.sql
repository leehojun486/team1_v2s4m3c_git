/**********************************/
/* ���̺���� */
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
  memberno INT NOT NULL AUTO_INCREMENT, -- ȸ�� ��ȣ, ���ڵ带 �����ϴ� �÷� 
  id           VARCHAR(20)   NOT NULL UNIQUE, -- ���̵�, �ߺ� �ȵ�, ���ڵ带 ���� 
  passwd    VARCHAR(20)   NOT NULL, -- �н�����, ������ ����
  mname    VARCHAR(20)   NOT NULL, -- ����, �ѱ� 10�� ���� ����
  tel          VARCHAR(14)   NOT NULL, -- ��ȭ��ȣ
  zipcode   VARCHAR(5)        NULL, -- �����ȣ, 12345
  address1  VARCHAR(80)       NULL, -- �ּ� 1
  address2  VARCHAR(50)       NULL, -- �ּ� 2
  mdate     DATETIME            NOT NULL, -- ������    
  PRIMARY KEY (mno)             -- �ѹ� ��ϵ� ���� �ߺ� �ȵ� 
  */
/**********************************/
/* Table Name: ȸ�� */
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

COMMENT ON TABLE member is 'ȸ��';
COMMENT ON COLUMN member.memberno is 'ȸ����ȣ';
COMMENT ON COLUMN member.membername is '�̸�';
COMMENT ON COLUMN member.membernicname is '�г���';
COMMENT ON COLUMN member.memberimg is 'ȸ���̹���';
COMMENT ON COLUMN member.memberpreview is 'ȸ���̹����̸�����';
COMMENT ON COLUMN member.memberimgsize is '�̹���ũ��';
COMMENT ON COLUMN member.membereml is '�̸���';
COMMENT ON COLUMN member.memberid is '���̵�';
COMMENT ON COLUMN member.memberpass is '��й�ȣ';
COMMENT ON COLUMN member.memberdate is 'ȸ�� ������';
COMMENT ON COLUMN member.memberzip is '�����ȣ';
COMMENT ON COLUMN member.memberadd1 is '�ּ�1';
COMMENT ON COLUMN member.memberadd1 is '�ּ�2';
/**********************************/
/* Table Name: ȸ������ */
/**********************************/
CREATE TABLE follow(
		followno                      		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		followvisible                 		CHAR(1)		 DEFAULT 'N'		 NOT NULL,
		followdate                    		DATE		 NOT NULL,
		memberno                      		NUMBER(10)		 NOT NULL,
        cnt                                     NUMBER(10),  
  FOREIGN KEY (memberno) REFERENCES member (memberno)
);



COMMENT ON TABLE follow is 'ȸ������';
COMMENT ON COLUMN follow.followno is '������ȣ';
COMMENT ON COLUMN follow.followvisible is '����Ȱ��/��Ȱ��';
COMMENT ON COLUMN follow.followdate is '�����';
COMMENT ON COLUMN follow.memberno is 'ȸ����ȣ';

/**********************************/
/* Table Name: ���� ����Ʈ */
/**********************************/
CREATE TABLE followlist(
		followno                      		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		followlistprint               		NUMBER(10)		 NOT NULL,
  FOREIGN KEY (followno) REFERENCES follow (followno)
);

COMMENT ON TABLE followlist is '���� ����Ʈ';
COMMENT ON COLUMN followlist.followno is '������ȣ';
COMMENT ON COLUMN followlist.followlistprint is '�������';


--SEQUENCE
CREATE SEQUENCE member_seq
  START WITH 1              -- ���� ��ȣ
  INCREMENT BY 1          -- ������
  MAXVALUE 9999999999 -- �ִ밪: 9999999 --> NUMBER(7) ����
  CACHE 2                       -- 2���� �޸𸮿����� ���
  NOCYCLE;                     -- �ٽ� 1���� �����Ǵ� ���� ����
  
  commit;

--SEQUENCE
CREATE SEQUENCE follow_seq
  START WITH 1              -- ���� ��ȣ
  INCREMENT BY 1          -- ������
  MAXVALUE 9999999999 -- �ִ밪: 9999999 --> NUMBER(7) ����
  CACHE 2                       -- 2���� �޸𸮿����� ���
  NOCYCLE;                     -- �ٽ� 1���� �����Ǵ� ���� ����
  
  --SEQUENCE
CREATE SEQUENCE followlist_seq
  START WITH 1              -- ���� ��ȣ
  INCREMENT BY 1          -- ������
  MAXVALUE 9999999999 -- �ִ밪: 9999999 --> NUMBER(7) ����
  CACHE 2                       -- 2���� �޸𸮿����� ���
  NOCYCLE;                     -- �ٽ� 1���� �����Ǵ� ���� ����
  

--���
 INSERT INTO member(memberno, membername, membernicname, membereml, memberid, memberpass, memberdate)
 VALUES(member_seq.nextval, 'ȣ����', '������','xx@naver.com', 'moon', 'passwd', sysdate);
 commit;

--��� <����>
 INSERT INTO follow(memberno, followno, followvisible, followdate)
 VALUES(1,follow_seq.nextval, 'N', sysdate);

--���
 SELECT memberno, membername, membereml , memberid, memberpass, memberdate
 FROM member
 ORDER BY memberno ASC;

---��� <����>
 SELECT mb_no, fo_num, fo_nicname , fo_visible, fo_date
 FROM follow
 ORDER BY fo_num ASC;

--����
 UPDATE members
 SET mb_name ='������'
 WHERE  mb_no=1;

--���� <����>
 UPDATE follow
 SET fo_visible='Y', fo_nicname= 'soldesk'
 WHERE  fo_num=1;

--����
 DELETE members
 WHERE memberno = 1;


    SELECT COUNT(*) as passwd_cnt
    FROM member
    WHERE memberno='1' AND memberpass= '1234';
    
    UPDATE member
    SET  membername='������', membernicname ='ȣ����', membereml='�˰�����'
    WHERE memberno = 1;
    
    commit;


 INSERT INTO member(memberno, membername, membernicname, membereml, memberid, memberpass, memberdate,
                               memberimg ,memberpreview , memberimgsize)
 VALUES(member_seq.nextval, #{membername}, #{membernicname}, #{membereml}, #{memberid},#{memberpass}, sysdate,
             #{memberimg}, #{memberpreview} , #{memberimgsize})
