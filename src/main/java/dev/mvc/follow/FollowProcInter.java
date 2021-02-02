package dev.mvc.follow;

import java.util.HashMap;
import java.util.List;

import dev.mvc.member.MemberVO;


public interface FollowProcInter {

  /**
   * ���
   * @param faqsVO
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
   * ����������  �˻�
   * @param map
   * @return 0: ��ġ���� ����, 1: ��ġ��
   */
  public int follow_check(HashMap<String, Object> map);
  
  /**
   * ����
   * @param followno
   * @return
   */
  public int delete(int followno);
}
