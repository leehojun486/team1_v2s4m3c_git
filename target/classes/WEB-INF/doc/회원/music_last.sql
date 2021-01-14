/**********************************/
/* Table Name: ȸ�� */
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

COMMENT ON TABLE members is 'ȸ��';
COMMENT ON COLUMN members.mb_no is 'ȸ����ȣ';
COMMENT ON COLUMN members.mb_name is '�̸�';
COMMENT ON COLUMN members.mb_nicname is '�г���';
COMMENT ON COLUMN members.mb_iml is '�̸���';
COMMENT ON COLUMN members.mb_id is '���̵�';
COMMENT ON COLUMN members.mb_pass is '��й�ȣ';
COMMENT ON COLUMN members.mb_date is 'ȸ�� ������';


/**********************************/
/* Table Name: ȸ������ */
/**********************************/
CREATE TABLE follow(
		mb_no                         		NUMBER(10)		 NOT NULL,
		fo_num                        		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		fo_nicname                    		VARCHAR2(50)		 NOT NULL,
		fo_visible                    		CHAR(1)		 DEFAULT 'N'		 NOT NULL,
		fo_date                       		DATE		 NOT NULL,
  FOREIGN KEY (mb_no) REFERENCES members (mb_no)
);

COMMENT ON TABLE follow is 'ȸ������';
COMMENT ON COLUMN follow.mb_no is 'ȸ����ȣ';
COMMENT ON COLUMN follow.fo_num is '������ȣ';
COMMENT ON COLUMN follow.fo_nicname is '�г���';
COMMENT ON COLUMN follow.fo_visible is '����';
COMMENT ON COLUMN follow.fo_date is '�����';


/**********************************/
/* Table Name: ���ƿ� */
/**********************************/
CREATE TABLE like(
		musicnum                      		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		memberno                      		NUMBER(10)		 NOT NULL,
		like_visible                  		CHAR(1)		 DEFAULT 'N'		 NOT NULL
);

COMMENT ON TABLE like is '���ƿ�';
COMMENT ON COLUMN like.musicnum is '���ǹ�ȣ';
COMMENT ON COLUMN like.memberno is 'ȸ����ȣ';
COMMENT ON COLUMN like.like_visible is '���ƿ�';


