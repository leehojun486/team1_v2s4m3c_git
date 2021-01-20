package dev.mvc.genre;

import java.util.List;



public interface GenreDAOInter {
  /**
   * <Xmp>
   * ī�װ� �׷� ���
   * <insert id="create" parameterType="genreVO"> 
   * </Xmp>
   * @param genreVO
   * @return ó���� ���ڵ� ����
   */
  public int create(GenreVO genreVO);
  
  /**
   * ���
   * <xmp>
   * <select id="list_genreno_asc" resultType="genreVO">
   * </xmp> 
   * @return ���ڵ� ���
   */
  public List<GenreVO> list_genreno_asc();
  
  /**
   * ���
   * <xmp>
   * <select id="list_genreno_asc" resultType="genreVO">
   * </xmp> 
   * @return ���ڵ� ���
   */
  public List<GenreVO> list_by_homeno(int homeno);
  
  /**
   * ��ȸ
   * <xmp>
   *   <select id="read" resultType="genreVO" parameterType="int">
   * </xmp>  
   * @param genreno
   * @return
   */
  public GenreVO read(String genrename);
  
  /**
   * ���� ó��
   * <xmp>
   *   <update id="update" parameterType="genreVO"> 
   * </xmp>
   * @param genreVO
   * @return ó���� ���ڵ� ����
   */
  public int update(GenreVO genreVO);
  
  /**
   * ���� ó��
   * <xmp>
   *   <delete id="delete" parameterType="int">
   * </xmp> 
   * @param genreno
   * @return ó���� ���ڵ� ����
   */
  public int delete(int genreno);

  /**
   *  ���� VO ��� join
   * @return
   */
  public List<Home_Genre_join> list_join();  
  
  /**
   *  ���� VO ��� join
   * @return
   */
  public List<Home_Genre_join> list_join_by_homeno(int homeno);  
  
}
