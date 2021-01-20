package dev.mvc.music_playlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface Music_PlaylistDAOInter {
 
  /**
   * <Xmp>
   * 플레이 리스트 등록
   * <insert id="create" parameterType="Music_PlaylistVO"> 
   * </Xmp>
   * @param music_PlaylistVO
   * @return 처리된 레코드 갯수
   */
  public int create(Music_PlaylistVO music_PlaylistVO);
  
  /**
   * 목록
   * <xmp>
   * <select id="list_music_playlistno_asc" resultType="Music_PlaylistVO">
   * </xmp> 
   * @return 레코드 목록
   */
  public List<Music_PlaylistVO> list_music_playlistno_asc();
 
  /**
   * 조회
   * <xmp>
   *   <select id="read" resultType="Music_PlaylistVO" parameterType="int">
   * </xmp>  
   * @param music_playlistno
   * @return
   */
  public Music_PlaylistVO read(int music_playlistno);
  
  /**
   * 수정 처리
   * <xmp>
   *   <update id="update" parameterType="Music_PlaylistVO"> 
   * </xmp>
   * @param music_PlaylistVO
   * @return 처리된 레코드 갯수
   */
  public int update(Music_PlaylistVO music_PlaylistVO);
 
  /**
   * 삭제 처리
   * <xmp>
   *   <delete id="delete" parameterType="int">
   * </xmp> 
   * @param music_playlistno
   * @return 처리된 레코드 갯수
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
   * 음악별 검색 목록
   * @param hashMap
   * @return
   */
  public List<Music_Playlist_Music_joinVO> list_by_join_search(HashMap<String, Object> hashMap);
  
  /**
   * 검색 + 페이징 목록
   * @param map
   * @return
   */
  public ArrayList<Music_Playlist_Music_joinVO> list_by_join_search_paging(HashMap<String, Object> map);
  
  /**
   * 음악별 검색 레코드 갯수
   * @param hashMap
   * @return
   */
  public int search_count(HashMap<String, Object> hashMap);
  
  public int count_music(int playlistno);
  
  

  
}
