package dev.mvc.singer_review;

import java.util.List;

public interface Singer_reviewProcInter {

  /**
   * <Xmp>
   * 등록
   * <insert id="create" parameterType="Singer_reviewVO"> 
   * </Xmp>
   * @param singer_reviewVO
   * @return 처리된 레코드 갯수
   */
  public int create(Singer_reviewVO singer_reviewVO);
  
  /**
   * 목록
   * <xmp>
   * <select id="list_date_asc" resultType="ReviewVO">
   * </xmp> 
   * @return 레코드 목록
   */
  public List<Singer_reviewVO> list_date_asc();
  
  /**
   * 조회
   * @param reviewno
   * @return
   */
  public Singer_reviewVO read(int reviewno);
  
  /**
   * 수정
   * @param reviewno
   * @return
   */
  public int update(Singer_reviewVO singer_reviewVO);
  
  /**
   * 삭제 처리
   * @param reviewno
   * @return 처리된 레코드 갯수
   */
  public int delete(int reviewno);
  
  /**
   * 좋아요 상향
   * <xmp>
   * <update id="update_reviewrec_up" parameterType="int">
   * </xmp>
   * @param reviewno
   * @return 처리된 레코드 갯수
   */
  public int update_reviewrec_up(int reviewno);
  
  /**
   * 좋아요 하향
   * <xmp>
   * <update id="update_reviewrec_down" parameterType="int">
   * </xmp>
   * @param reviewno
   * @return 처리된 레코드 갯수
   */
  public int update_reviewrec_down(int reviewno);
  
  /**
   * 답글수 상향
   * <xmp>
   * <update id="update_reviewcmtcnt_up" parameterType="int">
   * </xmp>
   * @param reviewno
   * @return 처리된 레코드 갯수
   */
  public int update_reviewcmtcnt_up(int reviewno);
  
  /**
   * 답글수 하향
   * <xmp>
   * <update id="update_reviewcmtcnt_down" parameterType="int">
   * </xmp>
   * @param reviewno
   * @return 처리된 레코드 갯수
   */
  public int update_reviewcmtcnt_down(int reviewno);
  
}
