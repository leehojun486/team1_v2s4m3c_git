package dev.mvc.notice;

/*noticeno                             NUMBER(10)     NOT NULL    PRIMARY KEY,
   title                              VARCHAR2(300)    NOT NULL,
   contents                                   CLOB     NOT NULL,
   rdate                                      DATE     NOT NULL */

public class NoticeVO {
  
  /** 공지사항 번호 */
  private int noticeno;
  /** 공지사항 제목 */
  private String title;
  /** 공지사항 내용 */
  private String contents;
  /** 등록 날짜 */
  private String rdate;
  
  public int getNoticeno() {
    return noticeno;
  }
  public void setNoticeno(int noticeno) {
    this.noticeno = noticeno;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContents() {
    return contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
  }
  public String getRdate() {
    return rdate;
  }
  public void setRdate(String rdate) {
    this.rdate = rdate;
  }
  
}
