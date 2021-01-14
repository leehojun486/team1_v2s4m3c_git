 package dev.mvc.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;




public interface AdminDAOInter {
 
  /**
   * �ߺ� ���̵� �˻�
   * @param id
   * @return �ߺ� ���̵� ����
   */
  public int checkID(String adminid);
  /**
   * ȸ������
   * @param MEMBERVO
   * @return ��ϵ� ����
   */
  public int create(AdminVO adminVO);
  
  /**
   * ȸ�� ��ü ���
   * @return
   */
  public List<AdminVO> list();
  
  /**
   * ȸ�� ��ȸ
   * @param memberno
   * @return
   */
  public AdminVO read(int adminno);
  
  /**
   * ȸ�� ���� ��ȸ
   * @param memberid
   * @return
   */
  public AdminVO readById(String adminid);
  
  
  /**
  * ���� ó��
  * @param memberVO
  * @return
  */
 public int update(AdminVO adminVO);
 
 /**
  * ȸ�� ���� ó��
  * @param memberno
  * @return
  */
 public int delete(int adminno);
 
 /**
  * ���� �н����� �˻�
  * @param map
  * @return 0: ��ġ���� ����, 1: ��ġ��
  */
 public int passwd_check(HashMap<String, Object> map);
 
 /**
  * �н����� ����
  * @param map
  * @return ����� �н����� ����
  */
 public int passwd_update(HashMap<String, Object> map);
 
 /**
  * �α��� ó��
  */
 public int login(Map<String, Object> map);
 
 
  
}
