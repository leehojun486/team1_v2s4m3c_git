package dev.mvc.singer;

public class Singer_Review_Member_join {
    // SELECT r.memberno, r.singerno, r.reviewrec,
    // m.memberno as m_memberno, m.memberid, m.memberpreview
   //-------------------------------------------------------------------
   // singer_review table
   // -------------------------------------------------------------------
   /** �θ� ���̺� ī�װ� �׷� ��ȣ */
   private int singerno;
   private int memberno;
   private int reviewrec;
   
   // -------------------------------------------------------------------
   // singer_review table
   // -------------------------------------------------------------------  
   private int m_memberno;
   private String memberid;
   private String memberpreview;
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
   public int getMemberno() {
     return memberno;
   }
   public void setMemberno(int memberno) {
     this.memberno = memberno;
   }
   public int getReviewrec() {
     return reviewrec;
   }
   public void setReviewrec(int reviewrec) {
     this.reviewrec = reviewrec;
   }
   public int getM_memberno() {
     return m_memberno;
   }
   public void setM_memberno(int m_memberno) {
     this.m_memberno = m_memberno;
   }
   public String getMemberid() {
     return memberid;
   }
   public void setMemberid(String memberid) {
     this.memberid = memberid;
   }
   public String getMemberpreview() {
     return memberpreview;
   }
   public void setMemberpreview(String memberpreview) {
     this.memberpreview = memberpreview;
   }
   

}