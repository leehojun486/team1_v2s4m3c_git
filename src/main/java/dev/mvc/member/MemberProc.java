package dev.mvc.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import dev.mvc.tool.Tool;

  @Component("dev.mvc.member.MemberProc")
  public class MemberProc implements MemberProcInter {
    
    @Autowired
    private MemberDAOInter memberDAO; 
    
   
    public MemberProc() {
      System.out.println("--> MemberProc created.");
    }
    
    @Override
    public int create(MemberVO memberVO) {
      int cnt = this.memberDAO.create(memberVO);
      
      return cnt;
      
    }
    @Override
    public int checkID(String memberid) {
      int cnt = this.memberDAO.checkID(memberid);
      return cnt;
    }
    
    @Override
    public List<MemberVO> list() {
    List<MemberVO> list = this.memberDAO.list();
    return list;
  }

    @Override
    public MemberVO read(int memberno) {
      MemberVO memberVO = this.memberDAO.read(memberno);
      return memberVO;
    }

    @Override
    public MemberVO readById(String memberid) {
      MemberVO memberVO = this.memberDAO.readById(memberid);
      
      return memberVO;
    }

    @Override
    public int update(MemberVO memberVO) {
      int cnt = 0;
      cnt  = this.memberDAO.update(memberVO);
      return cnt;
    }

    @Override
    public int delete(int memberno) {
      int cnt = this.memberDAO.delete(memberno);
      return cnt;
    }

    @Override
    public int passwd_check(HashMap<String, Object> map) {
      int cnt = this.memberDAO.passwd_check(map);
      
      return cnt;
    }

    @Override
    public int passwd_update(HashMap<String, Object> map) {
      int cnt=  this.memberDAO.passwd_update(map);
      return cnt;
    }
    
    @Override
    public int img_create(MemberVO memberVO) {
      int cnt = this.memberDAO.update_img(memberVO);
      return cnt;
    }

    @Override
    public int img_update(MemberVO memberVO) {
      int cnt = this.memberDAO.update_img(memberVO);
      return cnt;
    }

    @Override
    public int img_delete(MemberVO memberVO) {
      int cnt = this.memberDAO.update_img(memberVO);
      return cnt;
    }
    
    @Override
    public int login(Map<String, Object> map) {
      int cnt = this.memberDAO.login(map);
      return cnt;
    }
    
    @Override
    public boolean isMember(HttpSession session){
      boolean sw = false; // 로그인하지 않은 것으로 초기화
      
      String id = (String)session.getAttribute("id");
      
      if (id != null){
        sw = true;  // 로그인 한 경우
      }
      return sw;
    }  
  }
  

