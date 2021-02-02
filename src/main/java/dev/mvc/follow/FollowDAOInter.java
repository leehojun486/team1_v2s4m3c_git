 package dev.mvc.follow;

import java.util.HashMap;
import java.util.List;

import dev.mvc.faq.FaqVO;
import dev.mvc.member.MemberVO;

public interface FollowDAOInter {
  /**
   * 등록
   * @param followVO
   * @return
   */
  public int create(FollowVO followVO);
  
  /**
   * 회원 조회
   * @param follower
   * @return
   */
  public List<FollowVO> read(HashMap<String, Object> map);
  
  /**
   * 현재 구독인지 검사
   * @param map
   * @return 0: 일치하지 않음, 1: 일치함
   */
  public int follow_check(HashMap<String, Object> map);
  
  /**
   * 구독 취소
   * @param map
   * @return 구독취소
   */
  public int delete(int followno);
  

}
