package dev.mvc.album;

/*    CREATE TABLE album(
    albumno                         NUMBER(10)     NOT NULL    PRIMARY KEY,
    title                             VARCHAR2(30)     NOT NULL,
    artist                            VARCHAR2(20)     NOT NULL,
    genreno                         NUMBER(10)         NOT NULL,
    genre                             VARCHAR2(50)     NOT NULL,
    listno                             NUMBER(5)          NOT NULL,
    music                             VARCHAR2(50)     NOT NULL,
    FOREIGN KEY (genreno)     REFERENCES   genre  (genreno)
);

COMMENT ON TABLE album is '앨범';
COMMENT ON COLUMN album.albumno is '앨범 번호';
COMMENT ON COLUMN album.title is '앨범 제목';
COMMENT ON COLUMN album.artist is '아티스트';
COMMENT ON COLUMN album.genre is '장르';
COMMENT ON COLUMN album.genreno is '장르 번호';
COMMENT ON COLUMN album.listno is '수록곡 순서';
COMMENT ON COLUMN album.music is '노래 제목';    */

public class AlbumVO {

  int albumno;
  String title = "";
  String artist = "";
  int genreno;
  String genre = "";
  int listno;
  String musictitle = "";
  /*-*/
  
  
  public int getAlbumno() {
    return albumno;
  }
  public void setAlbumno(int albumno) {
    this.albumno = albumno;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getArtist() {
    return artist;
  }
  public void setArtist(String artist) {
    this.artist = artist;
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
  public int getListno() {
    return listno;
  }
  public void setListno(int listno) {
    this.listno = listno;
  }
  public String getMusictitle() {
    return musictitle;
  }
  public void setMusictitle(String musictitle) {
    this.musictitle = musictitle;
  }

  
}