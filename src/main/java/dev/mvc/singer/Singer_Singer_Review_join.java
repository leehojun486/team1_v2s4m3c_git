package dev.mvc.singer;

public class Singer_Singer_Review_join {
   //s.singerno,
   //r.singerno as r_singerno, r.reviewno, r.memberno, r.reviewcon, r.reviewrec, r.reviewdate, r.reviewcmtcnt
   //-------------------------------------------------------------------
   // singer table
   // -------------------------------------------------------------------
   /** 부모 테이블 카테고리 그룹 번호 */
   private int singerno;
   
   // -------------------------------------------------------------------
   // singer_review table
   // -------------------------------------------------------------------  
   /** 리뷰 번호 */
   private int reviewno;  
   /** 가수 번호 */
   private int r_singerno;
   /**  멤버 번호 */
   private int memberno;
   /** 리뷰 내용 */
   private String reviewcon;
   /** 좋아요 수 */
   private int reviewrec;
   /** 리뷰 날짜 */
   private String reviewdate;
   /** 리뷰 답글 수 */
   private int reviewcmtcnt;
   
   // --------------------------------------------------------------------
 
   public int getSingerno() {
     return singerno;
   }
   public void setSingerno(int singerno) {
     this.singerno = singerno;
   }
   public int getReviewno() {
     return reviewno;
   }
   public void setReviewno(int reviewno) {
     this.reviewno = reviewno;
   }
   public int getR_singerno() {
     return r_singerno;
   }
   public void setR_singerno(int r_singerno) {
     this.r_singerno = r_singerno;
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
