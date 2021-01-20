package dev.mvc.singer_review;

import java.util.List;

public interface Singer_reviewProcInter {

  /**
   * <Xmp>
   * ���
   * <insert id="create" parameterType="Singer_reviewVO"> 
   * </Xmp>
   * @param singer_reviewVO
   * @return ó���� ���ڵ� ����
   */
  public int create(Singer_reviewVO singer_reviewVO);
  
  /**
   * ���
   * <xmp>
   * <select id="list_date_asc" resultType="ReviewVO">
   * </xmp> 
   * @return ���ڵ� ���
   */
  public List<Singer_reviewVO> list_date_asc();
  
  /**
   * ��ȸ
   * @param reviewno
   * @return
   */
  public Singer_reviewVO read(int reviewno);
  
  /**
   * ����
   * @param reviewno
   * @return
   */
  public int update(Singer_reviewVO singer_reviewVO);
  
  /**
   * ���� ó��
   * @param reviewno
   * @return ó���� ���ڵ� ����
   */
  public int delete(int reviewno);
  
  /**
   * ���ƿ� ����
   * <xmp>
   * <update id="update_reviewrec_up" parameterType="int">
   * </xmp>
   * @param reviewno
   * @return ó���� ���ڵ� ����
   */
  public int update_reviewrec_up(int reviewno);
  
  /**
   * ���ƿ� ����
   * <xmp>
   * <update id="update_reviewrec_down" parameterType="int">
   * </xmp>
   * @param reviewno
   * @return ó���� ���ڵ� ����
   */
  public int update_reviewrec_down(int reviewno);
  
  /**
   * ��ۼ� ����
   * <xmp>
   * <update id="update_reviewcmtcnt_up" parameterType="int">
   * </xmp>
   * @param reviewno
   * @return ó���� ���ڵ� ����
   */
  public int update_reviewcmtcnt_up(int reviewno);
  
  /**
   * ��ۼ� ����
   * <xmp>
   * <update id="update_reviewcmtcnt_down" parameterType="int">
   * </xmp>
   * @param reviewno
   * @return ó���� ���ڵ� ����
   */
  public int update_reviewcmtcnt_down(int reviewno);
  
}
