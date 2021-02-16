package dev.mvc.music_playlist;

public class Music_Playlist_Music_joinVO {
  //-------------------------------------------------------------------
  //Music table
  // -------------------------------------------------------------------
  /** �θ� ���̺� ���� ��ȣ */
  private int r;
  public int getR() {
    return r;
  }
  public void setR(int r) {
    this.r = r;
  }
  private int m_musicno;
  /** �θ� ���̺� ����*/
  private String m_music;
  private String m_singer;
  public String getM_singer() {
    return m_singer;
  }
  public void setM_singer(String m_singer) {
    this.m_singer = m_singer;
  }
  private String youtube;
  
  //-------------------------------------------------------------------
 //Music_playlist table
 // -------------------------------------------------------------------
  private int music_playlistno;
  private int playlistno;
  private int playing_seq;
  private int musicno;
 public int getM_musicno() {
   return m_musicno;
 }
 public void setM_musicno(int m_musicno) {
   this.m_musicno = m_musicno;
 }
 public String getM_music() {
   return m_music;
 }
 public void setM_music(String m_music) {
   this.m_music = m_music;
 }
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
 public String getYoutube() {
   return youtube;
 }
 public void setYoutube(String youtube) {
   this.youtube = youtube;
 }
  
 }

