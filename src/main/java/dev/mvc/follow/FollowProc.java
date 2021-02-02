package dev.mvc.follow;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import dev.mvc.faq.FaqVO;
import dev.mvc.member.MemberVO;
import dev.mvc.tool.Tool;

  @Component("dev.mvc.follow.FollowProc")
  public class FollowProc implements FollowProcInter {
    
    @Autowired
    private FollowDAOInter followDAO; 
    
    public FollowProc() {
      System.out.println("--> FollowProc created.");
    }
    
    @Override
    public int create(FollowVO followVO) {
       int cnt = this.followDAO.create(followVO);
      return cnt;
    }
    
    @Override
    public List<FollowVO> read(HashMap<String, Object> map) {
     List< FollowVO > list = this.followDAO.read(map);
      return list;
    }
    
    @Override
    public int delete(int followno) {
      int cnt=  this.followDAO.delete(followno);
      return cnt;
    }
    
    @Override
    public int follow_check(HashMap<String, Object> map) {
      int cnt = this.followDAO.follow_check(map);
      
      return cnt;
    }

}
    
    
  
  

