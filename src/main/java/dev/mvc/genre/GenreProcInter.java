package dev.mvc.genre;

import java.util.List;

public interface GenreProcInter {

  /**
   * 생성 <Xmp> <insert id="create" parameterType="GenreVO"> </Xmp>
   * @param genreVO
   * @return
   */
  public int create(GenreVO genreVO);
  
  /**
   * 목록 조회 <Xmp> <select id="list" resultType="GenreVO"> </Xmp>
   * @return GenreVO
   */
  public List<GenreVO> list();
  
  /**
   * 목록 - 출력순서 정렬
   *  :: <select id="list_seqno_asc" resultType="GenreVO">
   * @return
   */
  public List<GenreVO> list_seqno_asc();
  
  /**
   * 단일 조회<Xmp> <select id="read" resultType="GenreVO" parameterType="int"> </Xmp>
   * @param genreno
   * @return
   */
  public GenreVO read(int genreno);
  
  /**
   * 수정 <Xmp> <update id="update" parameterType="GenreVO"> </Xmp>
   * @param genreVO
   * @return
   */
  public int update(GenreVO genreVO);
  
  /**
   * 삭제 <Xmp> <delete id="delete" parameterType="int"> </Xmp>
   * @param genreno
   * @return
   */
  public int delete(int genreno);
}
