 package dev.mvc.follow;

import java.util.HashMap;
import java.util.List;

import dev.mvc.faq.FaqVO;
import dev.mvc.member.MemberVO;

public interface FollowDAOInter {
  /**
   * ���
   * @param followVO
   * @return
   */
  public int create(FollowVO followVO);
  
  /**
   * ȸ�� ��ȸ
   * @param follower
   * @return
   */
  public List<FollowVO> read(HashMap<String, Object> map);
  
  /**
   * ���� �������� �˻�
   * @param map
   * @return 0: ��ġ���� ����, 1: ��ġ��
   */
  public int follow_check(HashMap<String, Object> map);
  
  /**
   * ���� ���
   * @param map
   * @return �������
   */
  public int delete(int followno);
  

}
