package dev.mvc.faq;

public class FaqVO {
//  faqno                             NUMBER(10) PRIMARY KEY NOT NULL, --ID�� �������� ����
//  memberno                      NUMBER(10)      NOT NULL,
//  faqtitle                           VARCHAR2(50)   NOT NULL, --ssar 
//  faqcontent                      VARCHAR2(50)  NOT NULL,
//  memberpass                            VARCHAR2(15)   NOT NULL,
//  faqreplycnt                          NUMBER(7)    DEFAULT 0     NOT NULL,
//  faqvisible                            CHAR(1)    DEFAULT 'Y'     NOT NULL,
//  faqip                                  VARCHAR2(15)     NOT NULL,
//  faqindent                             NUMBER(2)    DEFAULT 0     NOT NULL,
//  faqansnum                            NUMBER(3)    DEFAULT 0     NOT NULL,
//  faqword                               VARCHAR2(300)    NULL , 
//  faqrdate                                 DATE               NOT NULL,
  
  /**Faq ��ȣ**/
  private int faqno;
  /**FAQ ����**/
  private String faqtitle;
  /**FAQ ����**/
  private String faqcontent;
  /**ȸ����ȣ**/
  private int adminno;
  /** ȸ�� ��й�ȣ**/
  private String adminpass;
  /**��ۼ�**/
  private int faqreplycnt;
  /** �鿩���� / �亯����**/
  private int faqindent;
  /**�׷� ��ȣ**/
  private int faqgrpno;
  /** �亯 ����**/
  private int faqansnum;
  /** �˻���**/
  private String faqword;
  /** �����**/
  private String faqrdate;
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
  
  
  
  
  
  
  
  
  

  
}
