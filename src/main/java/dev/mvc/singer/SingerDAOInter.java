package dev.mvc.singer;

import java.util.List;


public interface SingerDAOInter {
  
  /**
   * @param singerVO
   * @return
   */
  public int create(SingerVO singerVO);
  
  /**
   * @return SingerVO
   */
  public List<SingerVO> list_singerno_asc();
  
  /**
   * @param singerno
   * @return
   */
  public SingerVO read(int singerno);
  
  /**
   * @param singerno
   * @return
   */
  public SingerVO read_update(int singerno);
  
  /**
   * @param singerVO
   * @return
   */
  public int update(SingerVO singerVO);
  
  /**
   * @param singerno
   * @return
   */
  public int delete(int singerno);
  
  /**
   * 이미지수정 처리
   * <xmp>
   *   <update id="update_img" parameterType="ContentsVO"> 
   * </xmp>
   * @param contentsVO
   * @return 처리된 레코드 갯수
   */
  public int update_img(SingerVO singerVO);
  
  /**
   * 좋아요 상향
   * <xmp>
   * <update id="update_singerrec_up" parameterType="int">
   * </xmp>
   * @param singerno
   * @return 처리된 레코드 갯수
   */
  public int update_singerrec_up(int singerno);
  
  /**
   * 좋아요 하향
   * <xmp>
   * <update id="update_singerrec_down" parameterType="int">
   * </xmp>
   * @param singerno
   * @return 처리된 레코드 갯수
   */
  public int update_singerrec_down(int singerno);
  
  /**
   * <xmp>
   *  통합 VO 기반 join
   *  <select id="list_join" resultType="Singer_Singer_Review_join"> 
   * </xmp>
   * @return
   */
  public List<Singer_Singer_Review_join> read_join(int singerno); 
  
  /**
   * <xmp>
   *  통합 VO 기반 join
   *  <select id="list_member_join" resultType="Singer_Review_Member_join"> 
   * </xmp>
   * @return
   */
  public List<Singer_Review_Member_join> read_member_join(int singerno); 
  
}
