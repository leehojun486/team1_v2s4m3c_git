package dev.mvc.membermusic;
 
//    /**********************************/
//    /* Table Name: 개인음악테이블 */
//    /**********************************/
//    CREATE TABLE MEMBERMUSIC(
//        MEMBERMUSICNO                     NUMBER(6)    NOT NULL    PRIMARY KEY,
//        MEMBERNO                          NUMBER(10)     NULL ,
//        MEMBERNAME                        VARCHAR2(20)     NULL ,
//        MUSICNO                           NUMBER(10)     NULL ,
//        MUSICTITLE                        VARCHAR2(50)     NULL ,
//        SINGERNO                          NUMBER(10)     NULL ,
//        SINGER                            VARCHAR2(20)     NULL ,
//        LIKELIST                          CHAR(1)    NULL ,
//      FOREIGN KEY (MEMBERNO) REFERENCES MEMBER (MEMBERNO),
//      FOREIGN KEY (MUSICNO) REFERENCES MUSIC (MUSICNO)
//    );
//    
//    COMMENT ON TABLE MEMBERMUSIC is '개인음악테이블';
//    COMMENT ON COLUMN MEMBERMUSIC.MEMBERMUSICNO is '개인음악테이블번호';
//    COMMENT ON COLUMN MEMBERMUSIC.MEMBERNO is '회원 번호';
//    COMMENT ON COLUMN MEMBERMUSIC.MEMBERNAME is '회원 이름';
//    COMMENT ON COLUMN MEMBERMUSIC.MUSICNO is '음악 번호';
//    COMMENT ON COLUMN MEMBERMUSIC.MUSICTITLE is '음악 제목';
//    COMMENT ON COLUMN MEMBERMUSIC.SINGERNO is '가수 번호';
//    COMMENT ON COLUMN MEMBERMUSIC.SINGER is '가수';
//    COMMENT ON COLUMN MEMBERMUSIC.LIKELIST is '좋아요';
//    

public class MemberMusicVO {
  
  private int membermusicno;
  private int memberno;
  private String membername = "";
  private int musicno;
  private String musictitle = "";
  private String singer = "";
  private int singerno;
  private String likelist = "";
  /*-*/
  
  public int getMembermusicno() {
    return membermusicno;
  }
  public void setMembermusicno(int membermusicno) {
    this.membermusicno = membermusicno;
  }
  public int getMemberno() {
    return memberno;
  }
  public void setMemberno(int memberno) {
    this.memberno = memberno;
  }
  public int getMusicno() {
    return musicno;
  }
  public void setMusicno(int musicno) {
    this.musicno = musicno;
  }
  public String getMembername() {
    return membername;
  }
  public void setMembername(String membername) {
    this.membername = membername;
  }
  public String getMusictitle() {
    return musictitle;
  }
  public void setMusictitle(String musictitle) {
    this.musictitle = musictitle;
  }
  public String getSinger() {
    return singer;
  }
  public void setSinger(String singer) {
    this.singer = singer;
  }
  public String getLikelist() {
    return likelist;
  }
  public void setLikelist(String likelist) {
    this.likelist = likelist;
  }
  public int getSingerno() {
    return singerno;
  }
  public void setSingerno(int singerno) {
    this.singerno = singerno;
  }
  
}
