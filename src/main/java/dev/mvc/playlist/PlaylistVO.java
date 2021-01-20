package dev.mvc.playlist;
// playlistno                        NUMBER(10)     NOT NULL    PRIMARY KEY,
// playlistname                      VARCHAR2(20)     NOT NULL,
// cntmusic                          NUMBER(10)     NOT NULL,
// memberno                             NUMBER(10)     NOT NULL,
// likes                              NUMBER(20)     DEFAULT 0     NOT NULL,
public class PlaylistVO {
    /** 플레이 리스트 번호 */
    private int playlistno = 0;
    /** 플레이 리스트 이름 */
    private String playlistname = "";
    /** 수록된 음악 수 */
    private int cntmusic = 0;
    /** 회원 번호 */
    private int memberno = 0;
    /** 좋아요 수 */
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
