package dev.mvc.singer;

import org.springframework.web.multipart.MultipartFile;

/*CREATE TABLE singer(
    singerno                            NUMBER(10)       NOT NULL       PRIMARY KEY,
    name                              VARCHAR2(50)       NOT NULL,
    sex                                 VARCHAR2(10)       NOT NULL,
    country                           VARCHAR2(50)        DEFAULT '-' NOT NULL,
    intro                               VARCHAR2(1000)      DEFAULT '-' NOT NULL,
    portrait                           VARCHAR(100)          NULL,
    thumb1                          VARCHAR(100)          NULL,
    size1                                 NUMBER(10)      DEFAULT 0 NULL,
    singerrec                         NUMBER(10)      DEFAULT '0'   NOT NULL
);

COMMENT ON TABLE singer is '가수';
COMMENT ON COLUMN singer.singerno is '가수 번호';
COMMENT ON COLUMN singer.name is '이름';
COMMENT ON COLUMN singer.sex is '성별';
COMMENT ON COLUMN singer.country is '국적';
COMMENT ON COLUMN singer.intro is '소개';
COMMENT ON COLUMN singer.portrait is '초상화';
COMMENT ON COLUMN singer.thumb1 is '초상화 Preview';
COMMENT ON COLUMN singer.size1 is '초상화 크기';
COMMENT ON COLUMN singer.singerrec is '가수추천수';

*/

public class SingerVO {
  /** 가수번호*/
  private int singerno;
  /** 이름*/
  private String name = "";
  /** 성별*/
  private String sex = "";
  /** 국적*/
  private String country = "";
  /** 소개*/
  private String intro ="";
  /** 초상화*/
  private String portrait = "";
  /** 초상화 Preview*/
  private String thumb1 = "";
  /** 초상화 크기 */
  private long size1;
  /** 가수추천수 */
  private int singerrec;
  /** 초상화 Preview*/
  private String genre = "";
  
  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public int getSingerrec() {
    return singerrec;
  }

  public void setSingerrec(int singerrec) {
    this.singerrec = singerrec;
  }

  private MultipartFile portraitMF;

  public int getSingerno() {
    return singerno;
  }

  public void setSingerno(int singerno) {
    this.singerno = singerno;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getIntro() {
    return intro;
  }

  public void setIntro(String intro) {
    this.intro = intro;
  }

  public String getPortrait() {
    return portrait;
  }

  public void setPortrait(String portrait) {
    this.portrait = portrait;
  }

  public String getThumb1() {
    return thumb1;
  }

  public void setThumb1(String thumb1) {
    this.thumb1 = thumb1;
  }

  public long getSize1() {
    return size1;
  }

  public void setSize1(long size1) {
    this.size1 = size1;
  }

  public MultipartFile getPortraitMF() {
    return portraitMF;
  }

  public void setPortraitMF(MultipartFile portrait1mf) {
    portraitMF = portrait1mf;
  }
  
}
