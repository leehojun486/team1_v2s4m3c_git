package dev.mvc.singer;

import java.util.List;

public interface SingerProcInter {

  /**
   * 가수 등록 <Xmp> <insert id="create" parameterType="SingerVO"> </Xmp> 
   * @param singerVO
   * @return
   */
  public int create(SingerVO singerVO);
  
  /**
   * 가수 (목록)조회 <Xmp> <select id="list_singer" resultType="SingerVO"> </Xmp>
   * @return SingerVO
   */
  public List<SingerVO> list_singer();
  
  /**
   * 가수 조회 <Xmp> <select id="read" resultType="SingerVO" parameterType="int"> </Xmp>
   * @param singerno
   * @return
   */
  public SingerVO read(int singerno);
  
  /**
   * 수정 목적 조회 <Xmp> <select id="read" resultType="SingerVO" parameterType="int"> </Xmp>
   * @param singerno
   * @return
   */
  public SingerVO read_update(int singerno);
  
  /**
   * 수정 <Xmp> <update id="update" parameterType="singerVO"> </Xmp>
   * @param singerVO
   * @return
   */
  public int update(SingerVO singerVO);
  
  /**
   * 삭제 <Xmp>  <delete id="delete" parameterType="int"> </Xmp>
   * @param singerno
   * @return
   */
  public int delete(int singerno);
}
