package dev.mvc.admin;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




@Component("dev.mvc.admin.AdminProc")
public class AdminProc implements AdminProcInter {
  @Autowired
  private AdminDAOInter adminDAO; 
  
  @Override
  public int create(AdminVO adminVO) {
    int cnt = this.adminDAO.create(adminVO);
    
    return cnt;
    
  }
  @Override
  public int checkID(String adminid) {
    int cnt = this.adminDAO.checkID(adminid);
    return cnt;
  }
  
  @Override
  public List<AdminVO> list() {
  List<AdminVO> list = this.adminDAO.list();
  return list;
}

  @Override
  public AdminVO read(int adminno) {
    AdminVO adminVO = this.adminDAO.read(adminno);
    return adminVO;
  }
  @Override
  public AdminVO readById(String adminid) {
    AdminVO adminVO = this.adminDAO.readById(adminid);
    
    return adminVO;
  }

  @Override
  public int update(AdminVO adminVO) {
    int cnt = 0;
    cnt  = this.adminDAO.update(adminVO);
    return cnt;
  }

  @Override
  public int delete(int adminno) {
    int cnt = this.adminDAO.delete(adminno);
    return cnt;
  }

  @Override
  public int passwd_check(HashMap<String, Object> map) {
    int cnt = this.adminDAO.passwd_check(map);
    
    return cnt;
  }

  @Override
  public int passwd_update(HashMap<String, Object> map) {
    int cnt=  this.adminDAO.passwd_update(map);
    return cnt;
  }
  
  @Override
  public int login(Map<String, Object> map) {
    int cnt = this.adminDAO.login(map);
    return cnt;
  }
  
  @Override
  public boolean isAdmin(HttpSession session){
    boolean sw = false; // 로그인하지 않은 것으로 초기화
    
    String adminid = (String)session.getAttribute("adminid");
    
    if (adminid != null){
      sw = true;  // 로그인 한 경우
    }
    return sw;
  }  
}

