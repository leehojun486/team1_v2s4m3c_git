package dev.mvc.playlist;

import java.util.HashMap;
import java.util.List;


public interface PlaylistDAOInter {
  /**
   * <Xmp>
   * 플레이 리스트 등록
   * <insert id="create" parameterType="PlaylistVO"> 
   * </Xmp>
   * @param playlistVO
   * @return 처리된 레코드 갯수
   */
  public int create(PlaylistVO playlistVO);
  
  /**
   * 목록
   * <xmp>
   * <select id="list_playlistno_asc" resultType="PlaylistVO">
   * </xmp> 
   * @return 레코드 목록
   */
  public List<PlaylistVO> list_playlistno_asc();
  
  /**
   * 조회
   * <xmp>
   *   <select id="read" resultType="PlaylistVO" parameterType="int">
   * </xmp>  
   * @param playlistno
   * @return
   */
  public PlaylistVO read(int playlistno);
  
  /**
   * 회원 플레이리스트 조회
   * <xmp>
   *   <select id="read" resultType="PlaylistVO" parameterType="int">
   * </xmp>  
   * @param playlistno
   * @return
   */
  public List<PlaylistVO> read_by_memberno(int memberno);
  
  /**
   * 수정 처리
   * <xmp>
   *   <update id="update" parameterType="PlaylistVO"> 
   * </xmp>
   * @param playlistVO
   * @return 처리된 레코드 갯수
   */
  public int update(PlaylistVO playlistVO);
  
  /**
   * 회원 수정
   * @param playlistVO
   * @return
   */
  public int user_update(PlaylistVO playlistVO);
  
  /**
   * 삭제 처리
   * <xmp>
   *   <delete id="delete" parameterType="int">
   * </xmp> 
   * @param playlistno
   * @return 처리된 레코드 갯수
   */
  public int delete(int playlistno);
  
  /**
   * 회원 삭제
   * @param hashMap
   * @return
   */
  public int user_delete(HashMap<String, Object> hashMap);
  
  /**
   * 
   * @param playlistno
   * @return
   */
  public int likes_up(int playlistno);
  

}
