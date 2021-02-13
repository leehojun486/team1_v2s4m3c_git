package dev.mvc.music_playlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface Music_PlaylistDAOInter {
 
  /**
   * <Xmp>
   * �÷��� ����Ʈ ���
   * <insert id="create" parameterType="Music_PlaylistVO"> 
   * </Xmp>
   * @param music_PlaylistVO
   * @return ó���� ���ڵ� ����
   */
  public int create(Music_PlaylistVO music_PlaylistVO);
  
  /**
   * ���
   * <xmp>
   * <select id="list_music_playlistno_asc" resultType="Music_PlaylistVO">
   * </xmp> 
   * @return ���ڵ� ���
   */
  
  public List<Music_PlaylistVO> list_music_playlistno_asc();
 
  /**
   * ��ȸ
   * <xmp>
   *   <select id="read" resultType="Music_PlaylistVO" parameterType="int">
   * </xmp>  
   * @param music_playlistno
   * @return
   */
  public Music_PlaylistVO read(int music_playlistno);
  
  /**
   * ���� ó��
   * <xmp>
   *   <update id="update" parameterType="Music_PlaylistVO"> 
   * </xmp>
   * @param music_PlaylistVO
   * @return ó���� ���ڵ� ����
   */
  public int update(Music_PlaylistVO music_PlaylistVO);
 
  /**
   * ���� ó��
   * <xmp>
   *   <delete id="delete" parameterType="int">
   * </xmp> 
   * @param music_playlistno
   * @return ó���� ���ڵ� ����
   */
  public int delete(int music_playlistno);
  /**
   * 
   * @param playlistno
   * @return
   */
  public List<Music_PlaylistVO> list_by_playlistno(int playlistno);
  
  /**
   * 
   * @param playlistno
   * @return
   */
  public List<Music_Playlist_Music_joinVO> list_by_join(int playlistno);
  
  /**
   * ���Ǻ� �˻� ���
   * @param hashMap
   * @return
   */
  public List<Music_Playlist_Music_joinVO> list_by_join_search(HashMap<String, Object> hashMap);
  
  /**
   * �˻� + ����¡ ���
   * @param map
   * @return
   */
  public ArrayList<Music_Playlist_Music_joinVO> list_by_join_search_paging(HashMap<String, Object> map);
  
  /**
   * ���Ǻ� �˻� ���ڵ� ����
   * @param hashMap
   * @return
   */
  public int search_count(HashMap<String, Object> hashMap);
  
  public int count_music(int playlistno);
  
  public int insert(Music_PlaylistVO music_PlaylistVO);
  
  

  
}
