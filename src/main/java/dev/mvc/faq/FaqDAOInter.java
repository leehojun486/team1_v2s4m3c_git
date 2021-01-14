 package dev.mvc.faq;

import java.util.HashMap;
import java.util.List;







public interface FaqDAOInter {
 
  /**
   * ���
   * @param faqVO
   * @return
   */
  public int create(FaqVO faqVO);
  
  /**
   * ��� ī�װ��� ��ϵ� �۸��
   * @return
   */
  public List<FaqVO> list_all();

  /**
   * ��ȸ
   * @param faqno
   * @return
   */
  public FaqVO read(int faqno);
  
  /**
   * ���� ó��
   * @param faqVO
   * @return
   */
  public int update(FaqVO faqVO);
  
  /**
   * ��ü ���ڵ� ����
   * @return
   */
  public int total_count();
  
  /**
   * �н����� �˻�
   * @param hashMap
   * @return
   */
  public int passwd_check(HashMap<String, Object> hashMap);
  
  /**
   * ����
   * @param contentsno
   * @return
   */
  public int delete(int faqno);
  
  /**
   * ī�װ��� �˻� ���ڵ� ����
   * @param hashMap
   * @return
   */
  public int search_count(HashMap<String, Object> hashMap);
  
  /**
   * �˻� + ����¡ ��� + Member join
   * @param map
   * @return
   */
  public List<Faq_AdminVO> list_all_search_paging_join(HashMap<String, Object> map);
  
}
