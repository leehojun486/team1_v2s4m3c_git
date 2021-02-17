package dev.mvc.chart_crawling;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


  @Component("dev.mvc.chart_crawling.Chart_crawlingProc")
  public class Chart_crawlingProc implements Chart_crawlingProcInter {
    
    @Autowired
    private Chart_crawlingDAOInter chart_crawlingDAO; 
    
    @Override
    public List<Chart_crawlingVO> list() {
    List<Chart_crawlingVO> list = this.chart_crawlingDAO.list();
    return list;
  }
    @Override
    public List<Chart_singer_joinVO> read_join(String name) {
      List<Chart_singer_joinVO> list = this.chart_crawlingDAO.read_join(name);
      return list;
    }
    


}
    
    
  
  

