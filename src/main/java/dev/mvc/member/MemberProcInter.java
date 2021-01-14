package dev.mvc.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;


public interface MemberProcInter {
  /**
   * ���
   * 
   * @param memberVO
   * @return
   */
  public int create(MemberVO memberVO);

  /**
   * �ߺ� ���̵� �˻�
   * @param id
   * @return �ߺ� ���̵� ����
   */
  public int checkID(String memberid);
  
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
  * �̹��� ���
  * @param contentsVO
  * @return
  */
 public int img_create(MemberVO memberVO);
 
 /**
  * �̹��� ����
  * @param contentsVO
  * @return
  */
 public int img_update(MemberVO memberVO);

 /**
  * �̹��� ����
  * @param contentsVO
  * @return
  */
 public int img_delete(MemberVO memberVO);
 
 /**
  * �α��� ó��
  */
 public int login(Map<String, Object> map);
 
 /**
  * �α��ε� ȸ�� �������� �˻��մϴ�.
  * @param session
  * @return true: ������
  */
 public boolean isMember(HttpSession session);   

}
