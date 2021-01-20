/**********************************/
/* Table Name: ȸ�� */
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

COMMENT ON TABLE members is 'ȸ��';
COMMENT ON COLUMN members.memberno is 'ȸ����ȣ';
COMMENT ON COLUMN members.name is '�̸�';
COMMENT ON COLUMN members.nicname is '�г���';
COMMENT ON COLUMN members.memberiml is '�̸���';
COMMENT ON COLUMN members.memberid is '���̵�';
COMMENT ON COLUMN members.memberpass is '��й�ȣ';
COMMENT ON COLUMN members.rdate is 'ȸ�� ������';
COMMENT ON COLUMN members.follow_num is '������ȣ';


/**********************************/
/* Table Name: ȸ������ */
/**********************************/
CREATE TABLE follow(
		memberno                      		NUMBER(10)		 NOT NULL,
		follow_num                    		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		nicname                       		VARCHAR2(50)		 NOT NULL,
		follow_visible                		CHAR(1)		 DEFAULT 'N'		 NOT NULL,
		follow_date                   		DATE		 NOT NULL,
  FOREIGN KEY (memberno) REFERENCES members (memberno)
);

COMMENT ON TABLE follow is 'ȸ������';
COMMENT ON COLUMN follow.memberno is 'ȸ����ȣ';
COMMENT ON COLUMN follow.follow_num is '������ȣ';
COMMENT ON COLUMN follow.nicname is '�г���';
COMMENT ON COLUMN follow.follow_visible is '����';
COMMENT ON COLUMN follow.follow_date is '�����';


/**********************************/
/* Table Name: ���ƿ� */
/**********************************/
CREATE TABLE like(
		musicnum                      		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		memberno                      		NUMBER(10)		 NOT NULL,
		like_visible                  		CHAR(1)		 DEFAULT 'N'		 NOT NULL,
  FOREIGN KEY (memberno) REFERENCES members (memberno)
);

COMMENT ON TABLE like is '���ƿ�';
COMMENT ON COLUMN like.musicnum is '���ǹ�ȣ';
COMMENT ON COLUMN like.memberno is 'ȸ����ȣ';
COMMENT ON COLUMN like.like_visible is '���ƿ�';


