package dev.mvc.admin;

public class AdminVO {
  
  /**관리자 번호**/
  private int adminno;
  /**관리자 아이디**/
  private String adminid;
  /**관리자 비밀번호**/
  private String adminpass;
  /**관리자 닉네임**/
  private String adminname;
  
  public int getAdminno() {
    return adminno;
  }
  public void setAdminno(int adminno) {
    this.adminno = adminno;
  }
  public String getAdminid() {
    return adminid;
  }
  public void setAdminid(String adminid) {
    this.adminid = adminid;
  }
  public String getAdminpass() {
    return adminpass;
  }
  public void setAdminpass(String adminpass) {
    this.adminpass = adminpass;
  }
  public String getAdminname() {
    return adminname;
  }
  public void setAdminname(String adminname) {
    this.adminname = adminname;
  }
}
