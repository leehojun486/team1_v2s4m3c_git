package dev.mvc.playlist;
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
