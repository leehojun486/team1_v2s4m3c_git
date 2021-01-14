 package dev.mvc.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public interface MemberDAOInter {
 
  /**
   * �ߺ� ���̵� �˻�
   * @param id
   * @return �ߺ� ���̵� ����
   */
  public int checkID(String memberid);
  /**
   * ȸ������
   * @param MEMBERVO
   * @return ��ϵ� ����
   */
  public int create(MemberVO memberVO);
  
  /**
   * ȸ�� ��ü ���
   * @return
   */
  public List<MemberVO> list();
  
  /**
   * ȸ�� ��ȸ
   * @param memberno
   * @return
   */
  public MemberVO read(int memberno);
  
  /**
   * ȸ�� ���� ��ȸ
   * @param memberid
   * @return
   */
  public MemberVO readById(String memberid);
  /**
  * ���� ó��
  * @param memberVO
  * @return
  */
 public int update(MemberVO memberVO);
 
 /**
  * ȸ�� ���� ó��
  * @param memberno
  * @return
  */
 public int delete(int memberno);
 
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
  * �̹��� ����
  * @param contentsVO
  * @return
  */
 public int update_img(MemberVO memberVO);
 
 /**
  * �α��� ó��
  */
 public int login(Map<String, Object> map);
 
 
  
}
