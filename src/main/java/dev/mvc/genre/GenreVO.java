package dev.mvc.genre;

//CREATE TABLE genre(
//    genreno                             NUMBER(10)     NOT NULL    PRIMARY KEY,
//    genre                               VARCHAR(50)    NOT NULL        
//    cnt                                 NUMBER(7)      DEFAULT 0     NOT NULL,
//    );
//
//COMMENT ON TABLE genre is '장르';
//COMMENT ON COLUMN genre.genreno is '장르 번호';
//COMMENT ON COLUMN genre.genre is '장르';
//COMMENT ON COLUMN genre.cnt is '장르 수';

public class GenreVO {
  int genreno;
  String genre = "";
  int cnt;
  
  /*-*/
  
  public int getGenreno() {
    return genreno;
  }
  public void setGenreno(int genreno) {
    this.genreno = genreno;
  }
  public String getGenre() {
    return genre;
  }
  public void setGenre(String genre) {
    this.genre = genre;
  }
  public int getCnt() {
    return cnt;
  }
  public void setCnt(int cnt) {
    this.cnt = cnt;
  }
  
  
}
