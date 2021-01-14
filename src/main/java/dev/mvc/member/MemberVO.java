package dev.mvc.member;

import org.springframework.web.multipart.MultipartFile;

/*
    memberno                          NUMBER(10)     NOT NULL    PRIMARY KEY,
    name                              VARCHAR2(50)     NOT NULL,
    nicname                           VARCHAR2(50)     NOT NULL,
    memberiml                         VARCHAR2(50)     NOT NULL,
    memberid                          VARCHAR2(50)     NOT NULL,
    memberpass                        VARCHAR2(50)     NOT NULL,
    rdate                                  DATE            NOT NULL
 */
public class MemberVO {
  /** ȸ����ȣ*/
  private int memberno;
  /** ȸ���̸�*/
  private String membername = "";
  /** �г���*/
  private String membernicname = "";
  /** �̸���*/
  private String membereml = "";
  /** ���̵�*/
  private String memberid = "";
  /** ��й�ȣ*/
  private String memberpass;
  /** ȸ�����Գ�¥*/
  private String memberdate;
  /**ȸ���̹���*/
  private String memberimg= "";
  /**ȸ���̹��� �̸�����*/
  private String memberpreview="";
  /**ȸ���̹��� ũ�� */
  private long memberimgsize;
  /** �̹��� MultipartFile */
  private MultipartFile memberimgMF;
  
  private String memberzip= "";
  private String memberadd1= "";
  private String memberadd2= "";
  
  
  public String getMemberzip() {
    return memberzip;
  }
  public void setMemberzip(String memberzip) {
    this.memberzip = memberzip;
  }
  public String getMemberadd1() {
    return memberadd1;
  }
  public void setMemberadd1(String memberadd1) {
    this.memberadd1 = memberadd1;
  }
  public String getMemberadd2() {
    return memberadd2;
  }
  public void setMemberadd2(String memberadd2) {
    this.memberadd2 = memberadd2;
  }
  public MultipartFile getMemberimgMF() {
    return memberimgMF;
  }
  public void setMemberimgMF(MultipartFile memberimgMF) {
    this.memberimgMF = memberimgMF;
  }
  public String getMemberimg() {
    return memberimg;
  }
  public void setMemberimg(String memberimg) {
    this.memberimg = memberimg;
  }
  public String getMemberpreview() {
    return memberpreview;
  }
  public void setMemberpreview(String memberpreview) {
    this.memberpreview = memberpreview;
  }
  public long getMemberimgsize() {
    return memberimgsize;
  }
  public void setMemberimgsize(long memberimgsize) {
    this.memberimgsize = memberimgsize;
  }
  public int getMemberno() {
    return memberno;
  }
  public void setMemberno(int memberno) {
    this.memberno = memberno;
  }
  public String getMembername() {
    return membername;
  }
  public void setMembername(String membername) {
    this.membername = membername;
  }
  public String getMembernicname() {
    return membernicname;
  }
  public void setMembernicname(String membernicname) {
    this.membernicname = membernicname;
  }
  public String getMembereml() {
    return membereml;
  }
  public void setMembereml(String membereml) {
    this.membereml = membereml;
  }
  public String getMemberid() {
    return memberid;
  }
  public void setMemberid(String memberid) {
    this.memberid = memberid;
  }
  public String getMemberpass() {
    return memberpass;
  }
  public void setMemberpass(String memeberpass) {
    this.memberpass = memeberpass;
  }
  public String getMemberdate() {
    return memberdate;
  }
  public void setMemberdate(String memberdate) {
    this.memberdate = memberdate;
  }
 
}


