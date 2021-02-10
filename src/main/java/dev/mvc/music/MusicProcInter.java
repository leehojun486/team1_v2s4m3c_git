package dev.mvc.music;

import java.util.HashMap;
import java.util.List;

public interface MusicProcInter {

  /**
   * 생성 :: <Xmp> <insert id="create" parameterType="MusicVO"> </Xmp>
   * 
   * @param musicVO
   * @return
   */
  public int create(MusicVO musicVO);

  /**
   * 목록조회 :: <Xmp> <select id="list" resultType="MusicVO"> </Xmp>
   * 
   * @return
   */
  public List<MusicVO> list();

  /**
   * 가수번호로 목록조회 <Xmp> <select id="list_by_singerno" resultType="MusicVO"> </Xmp>
   * 
   * @param singerno
   * @return
   */
  public List<MusicVO> list_by_singerno(int singerno);

  /**
   * 목록 - 출력순서 정렬 :: <select id="list_seqno_asc" resultType="MusicVO">
   * 
   * @return
   */
  public List<MusicVO> list_seqno_asc();

  /**
   * 글 읽기 :: <Xmp> <select id="read" resultType="MusicVO" parameterType="int">
   * </Xmp>
   * 
   * @param musicno
   * @return
   */
  public MusicVO read(int musicno);

  /**
   * 좋아요 리스트 추가하기
   * 
   * @param musicVO
   * @return
   */
  /* public int add_likelist(MusicVO musicVO); */

  /**
   * 좋아요 리스트 삭제하기
   * 
   * @param musicVO
   * @return
   */
  /* public int delete_likelist(MusicVO musicVO); */

  /**
   * 검색 목록
   * 
   * @param MusicVO
   * @return
   */
  public List<MusicVO> list_search(MusicVO musicVO);

  /**
   * 통합 VO 기반 join
   * 
   * @return
   */
  public List<Genre_Music_Join> list_join();

  /**
   * 통합 VO 기반 join
   * 
   * @return
   */
  public List<Genre_Music_Join> list_join_by_genreno(int genreno);

  /**
   * 전체 레코드 갯수
   * 
   * @return
   */
  public int total_count();

  /**
   * 장르별 검색 레코드 갯수
   * 
   * @param hashMap
   * @return
   */
  public int search_count(HashMap<String, Object> hashMap);

  /**
   * 검색 + 페이징 목록
   * 
   * @param map
   * @return
   */
  public List<MusicVO> list_by_genreno_search_paging(HashMap<String, Object> map);

  /**
   * 페이지 목록 문자열 생성, Box 형태
   * 
   * @param listFile     목록 파일명
   * @param genreno      카테고리번호
   * @param search_count 검색 갯수
   * @param nowPage      현재 페이지, nowPage는 1부터 시작
   * @param word         검색어
   * @return
   */
  public String pagingBox(String listFile, int genreno, int search_count, int nowPage, String word);

  /**
   * 수정용 조회
   * @param musicno
   * @return
   */
  public MusicVO read_update(int musicno);

  /**
   * 수정
   * 
   * @param musicVO
   * @return
   */
  public int update(MusicVO musicVO);

  /**
   * 패스워드 검사
   * 
   * @param hashmap
   * @return
   */
  public int passwd_check(HashMap<String, Object> hashmap);

  /**
   * 삭제
   * 
   * @param musicno
   * @return
   */
  public int delete(int musicno);

}
