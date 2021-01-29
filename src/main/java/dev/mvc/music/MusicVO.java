package dev.mvc.music;

import org.springframework.web.multipart.MultipartFile;

//  /**********************************/
//  /* Table Name: 음악 */
//  /**********************************/
//  CREATE TABLE MUSIC(
//    musicno NUMERIC(10) NOT NULL PRIMARY KEY,
//    title VARCHAR(50) NOT NULL,
//    singer VARCHAR(20) NOT NULL,
//    album VARCHAR(30) NOT NULL,
//    genreno NUMERIC(10) NOT NULL,
//    genre VARCHAR(50) NOT NULL,
//    rdate DATE NOT NULL,
//    lyrics CLOB,
//    likelist CHAR(1) NOT NULL,
//    likesu NUMERIC(10) NOT NULL,
//    mp3 VARCHAR(1000),
//    file1 VARCHAR(100),
//    thumb1 VARCHAR(100),
//    musiclong NUMERIC(10),
//    passwd VARCHAR(15) NOT NULL,
//    youtube VARCHAR(1000),
//    replycnt NUMERIC(7) DEFAULT 0 NOT NULL,
//    cnt NUMERIC(7) DEFAULT 0 NOT NULL,
//    word VARCHAR(300),
//    memberno NUMERIC(10),
//    singerno NUMERIC(10) DEFAULT 0 NOT NULL,
//    albumno NUMERIC(10) DEFAULT 0 NOT NULL,
//    FOREIGN KEY (singerno) REFERENCES singer (singerno),
//    FOREIGN KEY (albumno) REFERENCES album (albumno)
//  );

  public class MusicVO {
    private int musicno;
    private String title = "";
    private String singer = "";
    private String album = "";
    private int genreno;
    private String genre = "";
    private String rdate = "";
    private String lyrics = "";
    private String likelist = "";
    private int likesu;
    /** MP3 Spring */
    
    private String mp3 ="";
    private String file1 = "";
    private MultipartFile file1MF;
    /** preview 이미지 preview */
    private String thumb1 = "";
    /** 저장된 파일 사이즈 */
    private int musiclong;
    private String passwd ="";
    private String youtube;
    private int replycnt;
    private int cnt =0;
    private String word ="";
    
    private int memberno;
    private int singerno;
    private int albumno;
    
    /*-*/
    
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
    public String getSinger() {
      return singer;
    }
    public void setSinger(String singer) {
      this.singer = singer;
    }
    public String getAlbum() {
      return album;
    }
    public void setAlbum(String album) {
      this.album = album;
    }
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
    public String getRdate() {
      return rdate;
    }
    public void setRdate(String rdate) {
      this.rdate = rdate;
    }
    public int getLikesu() {
      return likesu;
    }
    public void setLikesu(int likesu) {
      this.likesu = likesu;
    }
    public int getMusiclong() {
      return musiclong;
    }
    public void setMusiclong(int musiclong) {
      this.musiclong = musiclong;
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
    public String getLyrics() {
      return lyrics;
    }
    public void setLyrics(String lyrics) {
      this.lyrics = lyrics;
    }
    public String getLikelist() {
      return likelist;
    }
    public void setLikelist(String likelist) {
      this.likelist = likelist;
    }
    public String getMp3() {
      return mp3;
    }
    public void setMp3(String mp3) {
      this.mp3 = mp3;
    }
    public String getFile1() {
      return file1;
    }
    public void setFile1(String file1) {
      this.file1 = file1;
    }
    public MultipartFile getFile1MF() {
      return file1MF;
    }
    public void setFile1MF(MultipartFile file1mf) {
      file1MF = file1mf;
    }
    public String getThumb1() {
      return thumb1;
    }
    public void setThumb1(String thumb1) {
      this.thumb1 = thumb1;
    }
    public String getPasswd() {
      return passwd;
    }
    public void setPasswd(String passwd) {
      this.passwd = passwd;
    }
    public int getReplycnt() {
      return replycnt;
    }
    public void setReplycnt(int replycnt) {
      this.replycnt = replycnt;
    }
    public int getCnt() {
      return cnt;
    }
    public void setCnt(int cnt) {
      this.cnt = cnt;
    }
    public String getYoutube() {
      return youtube;
    }
    public void setYoutube(String youtube) {
      this.youtube = youtube;
    }
    public String getWord() {
      return word;
    }
    public void setWord(String word) {
      this.word = word;
    }
    public int getMemberno() {
      return memberno;
    }
    public void setMemberno(int memberno) {
      this.memberno = memberno;
    }
    
    

}
