package dev.mvc.faq;

import org.springframework.web.multipart.MultipartFile;

public class Faq_AdminVO {
  
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
  /** �˻���**/
  private String faqword;
  /** �����**/
  private String faqrdate;
  // -----------------------------------------------------  
  // �亯 ���� ����
  /** id�� mid�� ��� */
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
