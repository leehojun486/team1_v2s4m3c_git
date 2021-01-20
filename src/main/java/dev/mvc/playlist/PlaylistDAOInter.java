package dev.mvc.playlist;

import java.util.HashMap;
import java.util.List;


public interface PlaylistDAOInter {
  /**
   * <Xmp>
   * �÷��� ����Ʈ ���
   * <insert id="create" parameterType="PlaylistVO"> 
   * </Xmp>
   * @param playlistVO
   * @return ó���� ���ڵ� ����
   */
  public int create(PlaylistVO playlistVO);
  
  /**
   * ���
   * <xmp>
   * <select id="list_playlistno_asc" resultType="PlaylistVO">
   * </xmp> 
   * @return ���ڵ� ���
   */
  public List<PlaylistVO> list_playlistno_asc();
  
  /**
   * ��ȸ
   * <xmp>
   *   <select id="read" resultType="PlaylistVO" parameterType="int">
   * </xmp>  
   * @param playlistno
   * @return
   */
  public PlaylistVO read(int playlistno);
  
  /**
   * ȸ�� �÷��̸���Ʈ ��ȸ
   * <xmp>
   *   <select id="read" resultType="PlaylistVO" parameterType="int">
   * </xmp>  
   * @param playlistno
   * @return
   */
  public List<PlaylistVO> read_by_memberno(int memberno);
  
  /**
   * ���� ó��
   * <xmp>
   *   <update id="update" parameterType="PlaylistVO"> 
   * </xmp>
   * @param playlistVO
   * @return ó���� ���ڵ� ����
   */
  public int update(PlaylistVO playlistVO);
  
  /**
   * ȸ�� ����
   * @param playlistVO
   * @return
   */
  public int user_update(PlaylistVO playlistVO);
  
  /**
   * ���� ó��
   * <xmp>
   *   <delete id="delete" parameterType="int">
   * </xmp> 
   * @param playlistno
   * @return ó���� ���ڵ� ����
   */
  public int delete(int playlistno);
  
  /**
   * ȸ�� ����
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
