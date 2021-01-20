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

COMMENT ON TABLE singer is '����';
COMMENT ON COLUMN singer.singerno is '���� ��ȣ';
COMMENT ON COLUMN singer.name is '�̸�';
COMMENT ON COLUMN singer.sex is '����';
COMMENT ON COLUMN singer.country is '����';
COMMENT ON COLUMN singer.intro is '�Ұ�';
COMMENT ON COLUMN singer.portrait is '�ʻ�ȭ';
COMMENT ON COLUMN singer.thumb1 is '�ʻ�ȭ Preview';
COMMENT ON COLUMN singer.size1 is '�ʻ�ȭ ũ��';
COMMENT ON COLUMN singer.singerrec is '������õ��';

*/

public class SingerVO {
  /** ������ȣ*/
  private int singerno;
  /** �̸�*/
  private String name = "";
  /** ����*/
  private String sex = "";
  /** ����*/
  private String country = "";
  /** �Ұ�*/
  private String intro ="";
  /** �ʻ�ȭ*/
  private String portrait = "";
  /** �ʻ�ȭ Preview*/
  private String thumb1 = "";
  /** �ʻ�ȭ ũ�� */
  private long size1;
  /** ������õ�� */
  private int singerrec;
  /** �ʻ�ȭ Preview*/
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
