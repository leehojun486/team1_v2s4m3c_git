package dev.mvc.follow;

import org.springframework.web.multipart.MultipartFile;

/*
   CREATE TABLE follow(
    followno                          NUMBER(10)     NOT NULL    PRIMARY KEY,
    followvisible                     CHAR(1)    DEFAULT 'N'     NOT NULL,
    followdate                        DATE     NOT NULL,
    memberno                          NUMBER(10)     NOT NULL,
  FOREIGN KEY (memberno) REFERENCES member (memberno)
);
 */
public class FollowVO {
  private int followno;
  private int follower;
  private int memberno;
  
  private String mnic="";
  private String mid="";

  

  public String getMid() {
    return mid;
  }
  public void setMid(String mid) {
    this.mid = mid;
  }
  public String getMnic() {
    return mnic;
  }
  public void setMnic(String mnic) {
    this.mnic = mnic;
  }
  public int getFollowno() {
    return followno;
  }
  public void setFollowno(int followno) {
    this.followno = followno;
  }
  public int getFollower() {
    return follower;
  }
  public void setFollower(int follower) {
    this.follower = follower;
  }
  public int getMemberno() {
    return memberno;
  }
  public void setMemberno(int memberno) {
    this.memberno = memberno;
  }


  

  
  

 
  


 
 
}


