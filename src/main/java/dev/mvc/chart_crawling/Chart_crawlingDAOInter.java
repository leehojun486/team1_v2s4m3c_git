 package dev.mvc.chart_crawling;

import java.util.HashMap;
import java.util.List;

import dev.mvc.faq.FaqVO;
import dev.mvc.member.MemberVO;

public interface Chart_crawlingDAOInter {
  
  /**
   * 회원 전체 목록
   * @return
   */
  public List<Chart_crawlingVO> list();
  

}
