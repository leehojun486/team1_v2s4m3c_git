 package dev.mvc.faq;

import java.util.HashMap;
import java.util.List;







public interface FaqDAOInter {
 
  /**
   * 등록
   * @param faqVO
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
   * @param faqno
   * @return
   */
  public FaqVO read(int faqno);
  
  /**
   * 수정 처리
   * @param faqVO
   * @return
   */
  public int update(FaqVO faqVO);
  
  /**
   * 전체 레코드 갯수
   * @return
   */
  public int total_count();
  
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
   * 검색 + 페이징 목록 + Member join
   * @param map
   * @return
   */
  public List<Faq_AdminVO> list_all_search_paging_join(HashMap<String, Object> map);
  
}
