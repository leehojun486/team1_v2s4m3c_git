package dev.mvc.singer_review;

public class Singer_reviewVO {
  /*
   * CREATE TABLE singer_review( reviewno NUMBER(10) NOT NULL PRIMARY KEY,
   * singerno NUMBER(10) NULL , memberno NUMBER(10) NULL , reviewcon VARCHAR2(500)
   * NOT NULL, reviewrec NUMERIC(10) DEFAULT 0 NOT NULL, reviewdate DATE NOT NULL,
   * reviewcmtcnt NUMBER(10) DEFAULT 0 NOT NULL, FOREIGN KEY (memberno) REFERENCES
   * member (memberno), FOREIGN KEY (singerno) REFERENCES singer (singerno) );
   * 
   * COMMENT ON TABLE singer_review is '리뷰'; COMMENT ON COLUMN
   * singer_review.reviewno is '리뷰번호'; COMMENT ON COLUMN singer_review.singerno is
   * '가수번호'; COMMENT ON COLUMN singer_review.memberno is '회원번호'; COMMENT ON COLUMN
   * singer_review.reviewcon is '내용'; COMMENT ON COLUMN singer_review.reviewrec is
   * '추천수'; COMMENT ON COLUMN singer_review.reviewdate is '작성일'; COMMENT ON COLUMN
   * singer_review.reviewcmtcnt is '리뷰답글수';
   */
  
  /** 리뷰 번호 */
  private int reviewno;
  /** 가수 번호 */
  private int singerno;
  /** 회원 번호 */
  private int memberno;
  /** 내용 */
  private String reviewcon = "";
  /** 추천수 */
  private int reviewrec;
  /** 리뷰 작성일 */
  private String reviewdate;
  /** 리뷰답글수 */
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
