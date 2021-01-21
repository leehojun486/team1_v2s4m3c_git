package dev.mvc.genre;

//CREATE TABLE genre(
//    genreno                             NUMBER(10)     NOT NULL    PRIMARY KEY,
//    genre                               VARCHAR(50)    NOT NULL        
//    cnt                                 NUMBER(7)      DEFAULT 0     NOT NULL,
//    );
//
//COMMENT ON TABLE genre is '�옣瑜�';
//COMMENT ON COLUMN genre.genreno is '�옣瑜� 踰덊샇';
//COMMENT ON COLUMN genre.genre is '�옣瑜�';
//COMMENT ON COLUMN genre.cnt is '�옣瑜� �닔';

public class GenreVO {
  int genreno;
  String genrename = "";
  
  /*-*/
    
  public int getGenreno() {
    return genreno;
  }
  public void setGenreno(int genreno) {
    this.genreno = genreno;
  }
  public String getGenrename() {
    return genrename;
  }
  public void setGenrename(String genrename) {
    this.genrename = genrename;  
  }
  
}
