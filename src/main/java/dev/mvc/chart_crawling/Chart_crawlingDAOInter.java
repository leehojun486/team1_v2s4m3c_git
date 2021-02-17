 package dev.mvc.chart_crawling;

import java.util.HashMap;
import java.util.List;


public interface Chart_crawlingDAOInter {
  
  /**
   * 회占쏙옙 占쏙옙체 占쏙옙占�
   * @return
   */
  public List<Chart_crawlingVO> list();
  
  /**
   * <xmp>
   *  �넻�빀 VO 湲곕컲 join
   *  <select id="read_join" resultType="chart_singer_join"> 
   * </xmp>
   * @return
   */
  public List<Chart_singer_joinVO> read_join(String name); 
  
}
