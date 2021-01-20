package dev.mvc.music_playlist;

public class Music_Playlist_Music_joinVO {
  //-------------------------------------------------------------------
  //Music table
  // -------------------------------------------------------------------
  /** 부모 테이블 음악 번호 */
  private int m_musicno;
  /** 부모 테이블 음악*/
  private String m_music;
  
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
  
 }

