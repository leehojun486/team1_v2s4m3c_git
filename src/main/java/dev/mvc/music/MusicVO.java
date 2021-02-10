package dev.mvc.music;

/**********************************/
/*      Table Name: 음악        */
/**********************************/
//    CREATE TABLE MUSIC(
//        MUSICNO                           NUMBER(10)     NOT NULL    PRIMARY KEY,
//        TITLE                               VARCHAR2(50)     NOT NULL,
//        SINGER                            VARCHAR2(20)     NOT NULL,
//        ALBUM                             VARCHAR2(30)     NOT NULL,
//        GENRE                             VARCHAR2(30)     NOT NULL,
//        LIKESU                            NUMBER(10)     DEFAULT 0     NOT NULL,
//        PLAYSU                            NUMBER(10)     DEFAULT 0     NOT NULL,
//        YOUTUBE                           VARCHAR2(1000)     NULL ,
//        ALBUMNO                           NUMBER(10)     NULL ,
//        SINGERNO                          NUMBER(10)     NULL ,
//        GENRENO                           NUMBER(10)     NULL ,
//      FOREIGN KEY (ALBUMNO) REFERENCES ALBUM (ALBUMNO),
//      FOREIGN KEY (SINGERNO) REFERENCES SINGER (SINGERNO),
//      FOREIGN KEY (GENRENO) REFERENCES GENRE (GENRENO)
//    );
//    COMMENT ON TABLE MUSIC is '음악';
//    COMMENT ON COLUMN MUSIC.MUSICNO is '음악번호';
//    COMMENT ON COLUMN MUSIC.TITLE is '음악제목';
//    COMMENT ON COLUMN MUSIC.SINGER is '가수';
//    COMMENT ON COLUMN MUSIC.ALBUM is '앨범';
//    COMMENT ON COLUMN MUSIC.GENRE is '장르';
//    COMMENT ON COLUMN MUSIC.LIKESU is '좋아요 수';
//    COMMENT ON COLUMN MUSIC.PLAYSU is '재생 수';
//    COMMENT ON COLUMN MUSIC.YOUTUBE is '유튜브주소';
//    COMMENT ON COLUMN MUSIC.ALBUMNO is '앨범번호';
//    COMMENT ON COLUMN MUSIC.SINGERNO is '가수번호';
//    COMMENT ON COLUMN MUSIC.GENRENO is '장르번호';

  public class MusicVO {
    private int musicno;
    private String title = "";
    private String singer = "";
    private String album = "";
    private String genre = "";
    private int likesu;
    private int playsu;
    private String youtube = "";
    private int albumno;
    private int singerno;
    private int genreno;
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
    public String getGenre() {
      return genre;
    }
    public void setGenre(String genre) {
      this.genre = genre;
    }
    public int getLikesu() {
      return likesu;
    }
    public void setLikesu(int likesu) {
      this.likesu = likesu;
    }
    public int getPlaysu() {
      return playsu;
    }
    public void setPlaysu(int playsu) {
      this.playsu = playsu;
    }
    public String getYoutube() {
      return youtube;
    }
    public void setYoutube(String youtube) {
      this.youtube = youtube;
    }
    public int getAlbumno() {
      return albumno;
    }
    public void setAlbumno(int albumno) {
      this.albumno = albumno;
    }
    public int getSingerno() {
      return singerno;
    }
    public void setSingerno(int singerno) {
      this.singerno = singerno;
    }
    public int getGenreno() {
      return genreno;
    }
    public void setGenreno(int genreno) {
      this.genreno = genreno;
    }
}
