package dev.mvc.faq;

import java.util.HashMap;
import java.util.List;


public interface FaqProcInter {
  /**
   * ���
   * @param faqsVO
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
   * @param contentsno
   * @return
   */
  public FaqVO read(int faqno);
  
  /**
   * ������ ��ȸ
   * @param faqno
   * @return
   */
  public FaqVO read_update(int faqno);
  
  /**
   * ���� ó��
   * @param contentsVO
   * @return
   */
  public int update(FaqVO faqVO);
  
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
   * ��ü ���ڵ� ����
   * @return
   */
  public int total_count();
  /**
   * ������ ��� ���ڿ� ����, Box ����
   * @param listFile ��� ���ϸ� 
   * @param categrpno ī�װ���ȣ
   * @param search_count �˻� ����
   * @param nowPage ���� ������, nowPage�� 1���� ����
   * @param word �˻���
   * @return
   */
  public String pagingBox(String listFile, int search_count, int nowPage, String faqword);

  /**
   * �˻� + ����¡ ��� + Member join
   * @param map
   * @return
   */
  public List<Faq_AdminVO> list_all_search_paging_join(HashMap<String, Object> map);
  

  
  
  
}
