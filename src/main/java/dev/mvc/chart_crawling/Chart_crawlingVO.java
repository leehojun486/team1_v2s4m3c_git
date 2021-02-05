package dev.mvc.chart_crawling;

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
public class Chart_crawlingVO {
  private int chartno;
  private String music="";
  private String artist="";
  public int getChartno() {
    return chartno;
  }
  public void setChartno(int chartno) {
    this.chartno = chartno;
  }
  public String getMusic() {
    return music;
  }
  public void setMusic(String music) {
    this.music = music;
  }
  public String getArtist() {
    return artist;
  }
  public void setArtist(String artist) {
    this.artist = artist;
  }

  

 


  

  
  

 
  


 
 
}


