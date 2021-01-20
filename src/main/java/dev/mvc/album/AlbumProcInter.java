package dev.mvc.album;

import java.util.List;

public interface AlbumProcInter {

  /**
   * 생성 <Xmp> <insert id="create" parameterType="AlbumVO"> </Xmp>
   * @param albumVO
   * @return
   */
  public int create(AlbumVO albumVO);
  
  /**
   * 목록 조회 <Xmp> <select id="list" resultType="GenreVO"> </Xmp>
   * @return
   */
  public List<AlbumVO> list();
  
  /**
   * 단일 조회 <Xmp> <select id="read" resultType="AlbumVO" parameterType="int"> </Xmp>
   * @param albumno
   * @return
   */
  public AlbumVO read(int albumno);
}
