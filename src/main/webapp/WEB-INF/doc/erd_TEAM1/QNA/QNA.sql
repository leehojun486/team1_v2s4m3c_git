DROP TABLE qna;
DROP SEQUENCE qna_seq;

/**********************************/
/*      Table Name: QNA       */
/**********************************/
CREATE TABLE qna(
      qnano NUMERIC(10) NOT NULL PRIMARY KEY,
      memberno NUMERIC(10) NOT NULL,
      adminno NUMERIC(6) NULL,
      qnatitle VARCHAR(50) NOT NULL,
      qnacontent VARCHAR(500) NOT NULL,
      qnacondition VARCHAR(50) NOT NULL,
      qnapasswd VARCHAR(15) NOT NULL,
      qnardate DATE NOT NULL,
  FOREIGN KEY (adminno) REFERENCES admin (adminno),
  FOREIGN KEY (memberno) REFERENCES member (memberno)
);
COMMENT ON TABLE QNA is '질문과 답변';
COMMENT ON COLUMN QNA.qnano is 'QNA번호';
COMMENT ON COLUMN QNA.memberno is '회원번호';
COMMENT ON COLUMN QNA.adminno is '관리자번호';
COMMENT ON COLUMN QNA.qnatitle is 'QNA제목';
COMMENT ON COLUMN QNA.qnacontent is 'QNA내용';
COMMENT ON COLUMN QNA.qnacondition is 'QNA답변상태';
COMMENT ON COLUMN QNA.qnapasswd is 'QNA비밀번호';
COMMENT ON COLUMN QNA.qnardate is 'QNA작성일';

CREATE SEQUENCE qna_seq
  START WITH 1              -- 시작 번호
  INCREMENT BY 1          -- 증가값
  MAXVALUE 9999999999 -- 최대값: 9999999 --> NUMBER(7) 대응
  CACHE 2                       -- 2번은 메모리에서만 계산
  NOCYCLE;                     -- 다시 1부터 생성되는 것을 방지
--*************************************************************************--
  