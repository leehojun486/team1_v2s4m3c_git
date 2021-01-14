package dev.mvc.faq;

import org.springframework.web.multipart.MultipartFile;

public class Faq_AdminVO {
  
  /**Faq 번호**/
  private int faqno;
  /**FAQ 내용**/
  private String faqtitle;
  /**FAQ 내용**/
  private String faqcontent;
  /**회원번호**/
  private int adminno;
  /** 회원 비밀번호**/
  private String adminpass;
  /**댓글수**/
  private int faqreplycnt;
  /** 들여쓰기 / 답변차수**/
  private int faqindent;
  /**그룹 번호**/
  private int faqgrpno;
  /** 답변 순서**/
  private int faqansnum;
  /** 검색어**/
  private String faqword;
  /** 등록일**/
  private String faqrdate;
  // -----------------------------------------------------  
  // 답변 관련 종료
  /** id를 mid로 사용 */
  private String aid;
  public int getFaqno() {
    return faqno;
  }
  public void setFaqno(int faqno) {
    this.faqno = faqno;
  }
  public String getFaqtitle() {
    return faqtitle;
  }
  public void setFaqtitle(String faqtitle) {
    this.faqtitle = faqtitle;
  }
  public String getFaqcontent() {
    return faqcontent;
  }
  public void setFaqcontent(String faqcontent) {
    this.faqcontent = faqcontent;
  }
  public int getAdminno() {
    return adminno;
  }
  public void setAdminno(int adminno) {
    this.adminno = adminno;
  }
  public String getAdminpass() {
    return adminpass;
  }
  public void setAdminpass(String adminpass) {
    this.adminpass = adminpass;
  }
  public int getFaqreplycnt() {
    return faqreplycnt;
  }
  public void setFaqreplycnt(int faqreplycnt) {
    this.faqreplycnt = faqreplycnt;
  }
  public int getFaqindent() {
    return faqindent;
  }
  public void setFaqindent(int faqindent) {
    this.faqindent = faqindent;
  }
  public int getFaqgrpno() {
    return faqgrpno;
  }
  public void setFaqgrpno(int faqgrpno) {
    this.faqgrpno = faqgrpno;
  }
  public int getFaqansnum() {
    return faqansnum;
  }
  public void setFaqansnum(int faqansnum) {
    this.faqansnum = faqansnum;
  }
  public String getFaqword() {
    return faqword;
  }
  public void setFaqword(String faqword) {
    this.faqword = faqword;
  }
  public String getFaqrdate() {
    return faqrdate;
  }
  public void setFaqrdate(String faqrdate) {
    this.faqrdate = faqrdate;
  }
  public String getAid() {
    return aid;
  }
  public void setAid(String aid) {
    this.aid = aid;
  }
  
  }
