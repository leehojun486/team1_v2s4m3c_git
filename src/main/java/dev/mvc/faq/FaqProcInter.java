package dev.mvc.faq;

import java.util.HashMap;
import java.util.List;


public interface FaqProcInter {
  /**
   * 등록
   * @param faqsVO
   * @return
   */
  public int create(FaqVO faqVO);
  
  /**
   * 모든 카테고리의 등록된 글목록
   * @return
   */
  public List<FaqVO> list_all();
  
  /**
   * 조회
   * @param contentsno
   * @return
   */
  public FaqVO read(int faqno);
  
  /**
   * 수정용 조회
   * @param faqno
   * @return
   */
  public FaqVO read_update(int faqno);
  
  /**
   * 수정 처리
   * @param contentsVO
   * @return
   */
  public int update(FaqVO faqVO);
  
  /**
   * 패스워드 검사
   * @param hashMap
   * @return
   */
  public int passwd_check(HashMap<String, Object> hashMap);
  
  
  /**
   * 삭제
   * @param contentsno
   * @return
   */
  public int delete(int faqno);
  
  /**
   * 카테고리별 검색 레코드 갯수
   * @param hashMap
   * @return
   */
  public int search_count(HashMap<String, Object> hashMap);
  
  /**
   * 전체 레코드 갯수
   * @return
   */
  public int total_count();
  /**
   * 페이지 목록 문자열 생성, Box 형태
   * @param listFile 목록 파일명 
   * @param categrpno 카테고리번호
   * @param search_count 검색 갯수
   * @param nowPage 현재 페이지, nowPage는 1부터 시작
   * @param word 검색어
   * @return
   */
  public String pagingBox(String listFile, int search_count, int nowPage, String faqword);

  /**
   * 검색 + 페이징 목록 + Member join
   * @param map
   * @return
   */
  public List<Faq_AdminVO> list_all_search_paging_join(HashMap<String, Object> map);
  

  
  
  
}
