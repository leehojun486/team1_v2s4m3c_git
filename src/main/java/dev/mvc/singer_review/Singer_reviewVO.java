package dev.mvc.singer_review;

public class Singer_reviewVO {
  /*
   * CREATE TABLE singer_review( reviewno NUMBER(10) NOT NULL PRIMARY KEY,
   * singerno NUMBER(10) NULL , memberno NUMBER(10) NULL , reviewcon VARCHAR2(500)
   * NOT NULL, reviewrec NUMERIC(10) DEFAULT 0 NOT NULL, reviewdate DATE NOT NULL,
   * reviewcmtcnt NUMBER(10) DEFAULT 0 NOT NULL, FOREIGN KEY (memberno) REFERENCES
   * member (memberno), FOREIGN KEY (singerno) REFERENCES singer (singerno) );
   * 
   * COMMENT ON TABLE singer_review is '����'; COMMENT ON COLUMN
   * singer_review.reviewno is '�����ȣ'; COMMENT ON COLUMN singer_review.singerno is
   * '������ȣ'; COMMENT ON COLUMN singer_review.memberno is 'ȸ����ȣ'; COMMENT ON COLUMN
   * singer_review.reviewcon is '����'; COMMENT ON COLUMN singer_review.reviewrec is
   * '��õ��'; COMMENT ON COLUMN singer_review.reviewdate is '�ۼ���'; COMMENT ON COLUMN
   * singer_review.reviewcmtcnt is '�����ۼ�';
   */
  
  /** ���� ��ȣ */
  private int reviewno;
  /** ���� ��ȣ */
  private int singerno;
  /** ȸ�� ��ȣ */
  private int memberno;
  /** ���� */
  private String reviewcon = "";
  /** ��õ�� */
  private int reviewrec;
  /** ���� �ۼ��� */
  private String reviewdate;
  /** �����ۼ� */
  private int reviewcmtcnt;
  
  
  public int getReviewno() {
    return reviewno;
  }
  public void setReviewno(int reviewno) {
    this.reviewno = reviewno;
  }
  public int getSingerno() {
    return singerno;
  }
  public void setSingerno(int singerno) {
    this.singerno = singerno;
  }
  public int getMemberno() {
    return memberno;
  }
  public void setMemberno(int memberno) {
    this.memberno = memberno;
  }
  public String getReviewcon() {
    return reviewcon;
  }
  public void setReviewcon(String reviewcon) {
    this.reviewcon = reviewcon;
  }
  public int getReviewrec() {
    return reviewrec;
  }
  public void setReviewrec(int reviewrec) {
    this.reviewrec = reviewrec;
  }
  public String getReviewdate() {
    return reviewdate;
  }
  public void setReviewdate(String reviewdate) {
    this.reviewdate = reviewdate;
  }
  public int getReviewcmtcnt() {
    return reviewcmtcnt;
  }
  public void setReviewcmtcnt(int reviewcmtcnt) {
    this.reviewcmtcnt = reviewcmtcnt;
  }
  

}
