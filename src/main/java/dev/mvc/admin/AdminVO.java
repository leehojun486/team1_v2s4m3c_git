package dev.mvc.admin;

public class AdminVO {
  
  /**������ ��ȣ**/
  private int adminno;
  /**������ ���̵�**/
  private String adminid;
  /**������ ��й�ȣ**/
  private String adminpass;
  /**������ �г���**/
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
