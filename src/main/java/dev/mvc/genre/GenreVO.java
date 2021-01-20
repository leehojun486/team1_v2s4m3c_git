package dev.mvc.genre;

public class GenreVO {
  
  
  /*장르 번호 */
  private int genreno = 0;
  /*장르 번호 */
  private int homeno = 0;
  /*장르 이름 */
  private String genrename = "";
  /*날짜 */
  private String rdate="";
  /** 출력 모드 */
  private int seqno;

  
  
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

    
    


}
