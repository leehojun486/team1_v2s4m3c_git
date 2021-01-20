package dev.mvc.music;

import org.springframework.web.multipart.MultipartFile;

//  SELECT g.genreno as g_genreno, g.genre as g_genre,
//         m.musicno, m.title, m.singer, m.album, m.mp3, m.singerno, m.albumno, m.cnt
//  FROM genre g, music m
//  WHERE g.genreno = m.genreno
//  ORDER BY g.genreno ASC;

public class Genre_Music_Join {

  // -------------------------------------------------------------------
  // genre table
  // -------------------------------------------------------------------
  private int g_genreno;
  private String g_genre = "";
  
  // -------------------------------------------------------------------
  // music table
  // -------------------------------------------------------------------
  private int musicno;
  private String title ="";
  private String signer ="";
  private String alubm ="";
  private String mp3 ="";
  private MultipartFile mp3MF;
  private int singerno;
  private int albumno;
  private int cnt;
  
  /*---*/
  
  public int getG_genreno() {
    return g_genreno;
  }
  public void setG_genreno(int g_genreno) {
    this.g_genreno = g_genreno;
  }
  public String getG_genre() {
    return g_genre;
  }
  public void setG_genre(String g_genre) {
    this.g_genre = g_genre;
  }
  public int getMusicno() {
    return musicno;
  }
  public void setMusicno(int musicno) {
    this.musicno = musicno;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getSigner() {
    return signer;
  }
  public void setSigner(String signer) {
    this.signer = signer;
  }
  public String getAlubm() {
    return alubm;
  }
  public void setAlubm(String alubm) {
    this.alubm = alubm;
  }
  public String getMp3() {
    return mp3;
  }
  public void setMp3(String mp3) {
    this.mp3 = mp3;
  }
  public MultipartFile getMp3MF() {
    return mp3MF;
  }
  public void setMp3MF(MultipartFile mp3mf) {
    mp3MF = mp3mf;
  }
  public int getSingerno() {
    return singerno;
  }
  public void setSingerno(int singerno) {
    this.singerno = singerno;
  }
  public int getAlbumno() {
    return albumno;
  }
  public void setAlbumno(int albumno) {
    this.albumno = albumno;
  }
  public int getCnt() {
    return cnt;
  }
  public void setCnt(int cnt) {
    this.cnt = cnt;
  }
  

  
  
  
}
