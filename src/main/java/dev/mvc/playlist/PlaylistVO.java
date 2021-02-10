package dev.mvc.playlist;

import org.springframework.web.multipart.MultipartFile;

// playlistno                        NUMBER(10)     NOT NULL    PRIMARY KEY,
// playlistname                      VARCHAR2(20)     NOT NULL,
// cntmusic                          NUMBER(10)     NOT NULL,
// memberno                             NUMBER(10)     NOT NULL,
// likes                              NUMBER(20)     DEFAULT 0     NOT NULL,
public class PlaylistVO {
    /** �÷��� ����Ʈ ��ȣ */
    private int playlistno = 0;
    /** �÷��� ����Ʈ �̸� */
    private String playlistname = "";
    /** ���ϵ� ���� �� */
    private int cntmusic = 0;
    /** ȸ�� ��ȣ */
    private int memberno = 0;
    /** ���ƿ� �� */
    private int likes = 0;
    
    private String fname = "";
    
    private String thumbnail = "";
    
    private long fsize;
    
    private MultipartFile fnamesMF;
    
    public MultipartFile getFnamesMF() {
      return fnamesMF;
    }
    public void setFnamesMF(MultipartFile fnamesMF) {
      this.fnamesMF = fnamesMF;
    }
    public int getPlaylistno() {
      return playlistno;
    }
    public void setPlaylistno(int playlistno) {
      this.playlistno = playlistno;
    }
    public String getPlaylistname() {
      return playlistname;
    }
    public void setPlaylistname(String playlistname) {
      this.playlistname = playlistname;
    }
    public int getCntmusic() {
      return cntmusic;
    }
    public void setCntmusic(int cntmusic) {
      this.cntmusic = cntmusic;
    }
    public int getmemberno() {
      return memberno;
    }
    public String getFname() {
      return fname;
    }
    public void setFname(String fname) {
      this.fname = fname;
    }
    public String getThumbnail() {
      return thumbnail;
    }
    public void setThumbnail(String thumbnail) {
      this.thumbnail = thumbnail;
    }
    public long getFsize() {
      return fsize;
    }
    public void setFsize(long fsize) {
      this.fsize = fsize;
    }
    public void setmemberno(int memberno) {
      this.memberno = memberno;
    }
    public int getLikes() {
      return likes;
    }
    public void setLikes(int likes) {
      this.likes = likes;
    }

}
