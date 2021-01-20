package dev.mvc.singer;

//   CREATE TABLE singer(
//       singerno                          NUMBER(10)     NOT NULL    PRIMARY KEY,
//       singer                            VARCHAR2(20)     NOT NULL,
//       agency                            VARCHAR2(30)     NOT NULL,
//       age                               NUMBER(10)     NOT NULL,
//       sex                               VARCHAR2(5)    NOT NULL
//   );
//
//   COMMENT ON TABLE singer is '가수';
//   COMMENT ON COLUMN singer.singerno is '가수 번호';
//   COMMENT ON COLUMN singer.singer is '가수';
//   COMMENT ON COLUMN singer.agency is '소속사';
//   COMMENT ON COLUMN singer.age is '나이';
//   COMMENT ON COLUMN singer.sex is '성별';

public class SingerVO {
  /** 가수 번호*/
  int singerno;
  /** 가수 이름*/
  String singer = "";
  /** 소속사*/
  String agency = "";
  /** 나이*/
  int age;
  /** 성별*/
  String sex ="";
  
  public int getSingerno() {
    return singerno;
  }
  public void setSingerno(int singerno) {
    this.singerno = singerno;
  }
  public String getSinger() {
    return singer;
  }
  public void setSinger(String singer) {
    this.singer = singer;
  }
  public String getAgency() {
    return agency;
  }
  public void setAgency(String agency) {
    this.agency = agency;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public String getSex() {
    return sex;
  }
  public void setSex(String sex) {
    this.sex = sex;
  }
  

}
