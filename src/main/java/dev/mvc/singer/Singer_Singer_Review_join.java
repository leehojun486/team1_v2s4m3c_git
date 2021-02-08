

package dev.mvc.singer;

public class Singer_Singer_Review_join{
   //s.singerno,
   //r.singerno as r_singerno, r.reviewno, r.memberno, r.reviewcon, r.reviewrec, r.reviewdate, r.reviewcmtcnt
   //-------------------------------------------------------------------
   // singer table
   // -------------------------------------------------------------------
   /** �θ� ���̺� ī�װ� �׷� ��ȣ */
   private int singerno;
   
   // -------------------------------------------------------------------
   // singer_review table
   // -------------------------------------------------------------------  
   /** ���� ��ȣ */
   private int reviewno;  
   /** ���� ��ȣ */
   private int r_singerno;
   /**  ��� ��ȣ */
   private int memberno;
   /** ���� ���� */
   private String reviewcon;
   /** ���ƿ� �� */
   private int reviewrec;
   /** ���� ��¥ */
   private String reviewdate;
   /** ���� ��� �� */
   private int reviewcmtcnt;
   
   private int pagen;
   
   // --------------------------------------------------------------------
 
   public int getPagen() {
    return pagen;
  }
  public void setPagen(int pagen) {
    this.pagen = pagen;
  }
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

