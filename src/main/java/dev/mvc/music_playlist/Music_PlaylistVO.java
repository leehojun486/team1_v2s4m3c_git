package dev.mvc.music_playlist;


// music_playlistno                  NUMBER(10)     NOT NULL    PRIMARY KEY,
// playlistno                        NUMBER(10)     NOT NULL,
// playing_seq                       NUMBER(10)     NOT NULL,
// musicno                           NUMBER(10)     NOT NULL,

public class Music_PlaylistVO {
  /** 재생목록 번호 */
  private int music_playlistno = 0;
  /** 플레이 리스트 번호 */
  private int playlistno = 0;
  /** 재생 순서 */
  private int playing_seq = 0;
  /** 음악 번호 */
  private int musicno = 0;
  
  public int getMusic_playlistno() {
    return music_playlistno;
  }
  public void setMusic_playlistno(int music_playlistno) {
    this.music_playlistno = music_playlistno;
  }
  public int getPlaylistno() {
    return playlistno;
  }
  public void setPlaylistno(int playlistno) {
    this.playlistno = playlistno;
  }
  public int getPlaying_seq() {
    return playing_seq;
  }
  public void setPlaying_seq(int playing_seq) {
    this.playing_seq = playing_seq;
  }
  public int getMusicno() {
    return musicno;
  }
  public void setMusicno(int musicno) {
    this.musicno = musicno;
  }
  

}
