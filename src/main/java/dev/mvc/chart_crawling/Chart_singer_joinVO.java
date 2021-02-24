package dev.mvc.chart_crawling;


/*
    SELECT c.chartno,
                c.music, s.singerno, c.artist, s.name
    FROM singer s, chart_crawling c
    WHERE c.artist = #{name}
    ORDER BY singerno ASC
 */
public class Chart_singer_joinVO {
  private int chartno;
  private String music;
  private int singerno;
  private String artist;
  private String name;
  
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
  public int getSingerno() {
    return singerno;
  }
  public void setSingerno(int singerno) {
    this.singerno = singerno;
  }
  public String getArtist() {
    return artist;
  }
  public void setArtist(String artist) {
    this.artist = artist;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  

}


