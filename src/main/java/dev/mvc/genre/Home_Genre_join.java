package dev.mvc.genre;

public class Home_Genre_join {
  public int getR_homeno() {
    return r_homeno;
  }
  public void setR_homeno(int r_homeno) {
    this.r_homeno = r_homeno;
  }
  public String getR_name() {
    return r_name;
  }
  public void setR_name(String r_name) {
    this.r_name = r_name;
  }
  public int getGenreno() {
    return genreno;
  }
  public void setGenreno(int genreno) {
    this.genreno = genreno;
  }
  public int getHomeno() {
    return homeno;
  }
  public void setHomeno(int homeno) {
    this.homeno = homeno;
  }
  public String getGenrename() {
    return genrename;
  }
  public void setGenrename(String genrename) {
    this.genrename = genrename;
  }
  public String getRdate() {
    return rdate;
  }
  public void setRdate(String rdate) {
    this.rdate = rdate;
  }
  public int getSeqno() {
    return seqno;
  }
  public void setSeqno(int seqno) {
    this.seqno = seqno;
  }
  // -------------------------------------------------------------------
  // Categrp table
  // -------------------------------------------------------------------
  /** �θ� ���̺� ī�װ� �׷� ��ȣ */
  private int r_homeno;
  /** �θ� ���̺� ī�װ� �׷� �̸� */
  private String r_name;
  // -------------------------------------------------------------------
  // Cate table
  // -------------------------------------------------------------------  
  /*�帣 ��ȣ */
  private int genreno = 0;
  /*�帣 ��ȣ */
  private int homeno = 0;
  /*�帣 �̸� */
  private String genrename = "";
  /*��¥ */
  private String rdate="";
  /** ��� ��� */
  private int seqno;
}
