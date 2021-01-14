drop table follow;
drop table members;
drop table 
/**********************************/
/* Table Name: ȸ�� */
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

COMMENT ON TABLE members is 'ȸ��';
COMMENT ON COLUMN members.memberno is 'ȸ����ȣ';
COMMENT ON COLUMN members.membername is '�̸�';
COMMENT ON COLUMN members.membernicname is '�г���';
COMMENT ON COLUMN members.membereml is '�̸���';
COMMENT ON COLUMN members.memberid is '���̵�';
COMMENT ON COLUMN members.memberpass is '��й�ȣ';
COMMENT ON COLUMN members.memberdate is 'ȸ�� ������';
COMMENT ON COLUMN members.followno is '������ȣ';


/**********************************/
/* Table Name: ȸ������ */
/**********************************/
CREATE TABLE follow(
		followno                      		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		followvisible                 		CHAR(1)		 DEFAULT 'N'		 NOT NULL,
		followdate                    		DATE		 NOT NULL,
		memberno                      		NUMBER(10)		 NOT NULL,
		followlistno                  		NUMBER(10)		 NOT NULL,
  FOREIGN KEY (memberno) REFERENCES members (memberno)
);

COMMENT ON TABLE follow is 'ȸ������';
COMMENT ON COLUMN follow.followno is '������ȣ';
COMMENT ON COLUMN follow.followvisible is '����Ȱ��/��Ȱ��';
COMMENT ON COLUMN follow.followdate is '�����';
COMMENT ON COLUMN follow.memberno is 'ȸ����ȣ';
COMMENT ON COLUMN follow.followlistno is '�������';


/**********************************/
/* Table Name: ���� ����Ʈ */
/**********************************/
CREATE TABLE follow_list(
		followno                      		NUMBER(10)		 NOT NULL,
		followlistprint               		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
  FOREIGN KEY (followno) REFERENCES follow (followno)
);

COMMENT ON TABLE follow_list is '���� ����Ʈ';
COMMENT ON COLUMN follow_list.followno is '������ȣ';
COMMENT ON COLUMN follow_list.followlistprint is '�������';


