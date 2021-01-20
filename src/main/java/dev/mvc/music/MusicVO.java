package dev.mvc.music;

import org.springframework.web.multipart.MultipartFile;

//  /**********************************/
//  /* Table Name: 음악 */
//  /**********************************/
//  CREATE TABLE MUSIC(
//      MUSICNO                           NUMBER(10)     NOT NULL    PRIMARY KEY,
//      TITLE                             VARCHAR2(50)     NOT NULL,
//      SINGER                            VARCHAR2(20)     NOT NULL,
//      ALBUM                             VARCHAR2(30)     NOT NULL,
//      GENRENO                           NUMBER(10)     NOT NULL,
//      GENRE                             VARCHAR2(50)     NOT NULL,
//      RDATE                             DATE     NOT NULL,
//      LYRICS                            CLOB(4000)     NULL ,
//      LIKELIST                          CHAR(1)    NOT NULL,
//      LIKESU                            NUMBER(10)     NOT NULL,
//      MP3                               VARCHAR2(1000)     NULL ,
//      FILE1                             VARCHAR2(100)    NULL ,
//      THUMB1                            VARCHAR2(100)    NULL ,
//      SIZE1                             NUMBER(10)     NULL ,
//      MUSICLONG                         NUMBER(10)     NULL ,
//      PASSWD                            VARCHAR2(15)     NOT NULL,
//      YOUTUBE                           VARCHAR2(1000)     NULL ,
//      REPLYCNT                          NUMBER(7)    DEFAULT 0     NOT NULL,
//      CNT                               NUMBER(7)    DEFAULT 0     NOT NULL,
//      WORD                              VARCHAR2(300)    NULL ,
//      MEMBERNO                          NUMBER(10)     NULL ,
//      SINGERNO                          NUMBER(10)     NULL ,
//      ALBUMNO                           NUMBER(10)     NULL ,
//    FOREIGN KEY (SINGERNO) REFERENCES SINGER (SINGERNO),
//    FOREIGN KEY (ALBUMNO) REFERENCES ALBUM (ALBUMNO),
//    FOREIGN KEY (GENRENO) REFERENCES GENRE (GENRENO)
//  );
//  
//  COMMENT ON TABLE MUSIC is '음악';
//  COMMENT ON COLUMN MUSIC.MUSICNO is '음악 번호';
//  COMMENT ON COLUMN MUSIC.TITLE is '음악 제목';
//  COMMENT ON COLUMN MUSIC.SINGER is '가수';
//  COMMENT ON COLUMN MUSIC.ALBUM is '앨범 제목';
//  COMMENT ON COLUMN MUSIC.GENRENO is '장르 번호';
//  COMMENT ON COLUMN MUSIC.GENRE is '장르';
//  COMMENT ON COLUMN MUSIC.RDATE is '등록일';
//  COMMENT ON COLUMN MUSIC.LYRICS is '가사';
//  COMMENT ON COLUMN MUSIC.LIKELIST is '좋아요리스트추가';
//  COMMENT ON COLUMN MUSIC.LIKESU is '좋아요';
//  COMMENT ON COLUMN MUSIC.MP3 is 'mp3file';
//  COMMENT ON COLUMN MUSIC.FILE1 is '메인 이미지';
//  COMMENT ON COLUMN MUSIC.THUMB1 is '메인 이미지 Preview';
//  COMMENT ON COLUMN MUSIC.SIZE1 is '메인 이미지 크기';
//  COMMENT ON COLUMN MUSIC.MUSICLONG is '재생 시간';
//  COMMENT ON COLUMN MUSIC.PASSWD is '패스워드';
//  COMMENT ON COLUMN MUSIC.YOUTUBE is 'youtube';
//  COMMENT ON COLUMN MUSIC.REPLYCNT is '댓글수';
//  COMMENT ON COLUMN MUSIC.CNT is '조회수';
//  COMMENT ON COLUMN MUSIC.WORD is '검색어';
//  COMMENT ON COLUMN MUSIC.SINGERNO is '회원 번호';
//  COMMENT ON COLUMN MUSIC.SINGERNO is '가수 번호';
//  COMMENT ON COLUMN MUSIC.ALBUMNO is '앨범 번호';

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
    private MultipartFile mp3MF;
    /** 이미지 */
    private String file1 = "";
    private MultipartFile file1MF;
    /** preview 이미지 preview */
    private String thumb1 = "";
    /** 저장된 파일 사이즈 */
    private long size1;
    private int musiclong;
    private int singerno;
    private int albumno;
    private String passwd ="";
    private int replycnt;
    private int cnt =0;
    private String youtube;
    private String word ="";
    private int memebrno;
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
    public MultipartFile getMp3MF() {
      return mp3MF;
    }
    public void setMp3MF(MultipartFile mp3mf) {
      mp3MF = mp3mf;
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
    public long getSize1() {
      return size1;
    }
    public void setSize1(long size1) {
      this.size1 = size1;
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
    public int getMemebrno() {
      return memebrno;
    }
    public void setMemebrno(int memebrno) {
      this.memebrno = memebrno;
    }
    

}
