package dev.mvc.genre;

import java.util.List;



public interface GenreDAOInter {
  /**
   * <Xmp>
   * 카테고리 그룹 등록
   * <insert id="create" parameterType="genreVO"> 
   * </Xmp>
   * @param genreVO
   * @return 처리된 레코드 갯수
   */
  public int create(GenreVO genreVO);
  
  /**
   * 목록
   * <xmp>
   * <select id="list_genreno_asc" resultType="genreVO">
   * </xmp> 
   * @return 레코드 목록
   */
  public List<GenreVO> list_genreno_asc();
  
  /**
   * 목록
   * <xmp>
   * <select id="list_genreno_asc" resultType="genreVO">
   * </xmp> 
   * @return 레코드 목록
   */
  public List<GenreVO> list_by_homeno(int homeno);
  
  /**
   * 조회
   * <xmp>
   *   <select id="read" resultType="genreVO" parameterType="int">
   * </xmp>  
   * @param genreno
   * @return
   */
  public GenreVO read(String genrename);
  
  /**
   * 수정 처리
   * <xmp>
   *   <update id="update" parameterType="genreVO"> 
   * </xmp>
   * @param genreVO
   * @return 처리된 레코드 갯수
   */
  public int update(GenreVO genreVO);
  
  /**
   * 삭제 처리
   * <xmp>
   *   <delete id="delete" parameterType="int">
   * </xmp> 
   * @param genreno
   * @return 처리된 레코드 갯수
   */
  public int delete(int genreno);

  /**
   *  통합 VO 기반 join
   * @return
   */
  public List<Home_Genre_join> list_join();  
  
  /**
   *  통합 VO 기반 join
   * @return
   */
  public List<Home_Genre_join> list_join_by_homeno(int homeno);  
  
}
