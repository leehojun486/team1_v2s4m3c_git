package dev.mvc.membermusic;

import java.util.HashMap;
import java.util.List;

public interface MemberMusicProcInter {

  /**
   * 회원 개인음악테이블 생성
   * <Xmp> <insert id="create" parameterType="MemberMusicVO"> </Xmp>
   * @param MemberMusicVO
   * @return
   */
  public int create(MemberMusicVO MemberMusicVO);

  /**
   * 목록 조회
   * <Xmp> <select id="list" resultType="MemberMusicVO"> </Xmp>
   * @return
   */
  public List<MemberMusicVO> list();
  
  /**
   *  중복 제거
   *  <Xmp> <select id="list_memberno" resultType="MemberMusicVO"> </Xmp>
   * @param memberno  
   * @return
   */
  public List<MemberMusicVO> list_memberno();
  
  /**
   * 회원번호에 따른 개별 목록 조회
   * <Xmp>  <select id="read" resultType="MemberMusicVO" parameterType="int"> </Xmp>
   * @param memberno
   * @return
   */ 
  public MemberMusicVO read(int memberno);

  /**
   * 삭제
   * @param musicno
   * @param memberno
   * @return
   */
  public int delete(HashMap<String, Object> hashMap);
}
