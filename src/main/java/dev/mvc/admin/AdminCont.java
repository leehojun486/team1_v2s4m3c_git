package dev.mvc.admin;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.tool.Tool;
import dev.mvc.tool.Upload;



@Controller
public class AdminCont {
  @Autowired
  @Qualifier("dev.mvc.admin.AdminProc") // 이름 지정
  private AdminProcInter adminProc;
  /**
  * ID 중복 체크, JSON 출력
  * @return
  */
  @ResponseBody
  @RequestMapping(value="/admin/checkID.do", method=RequestMethod.GET ,
                         produces = "text/plain;charset=UTF-8" )
  public String checkID(String adminid) {
    int cnt = this.adminProc.checkID(adminid);
   
    JSONObject json = new JSONObject();
    json.put("cnt", cnt);
   
    return json.toString(); 
  }
/**
 * 관리자 등록 폼
 */
   @RequestMapping(value="/admin/create.do", method=RequestMethod.GET )
   public ModelAndView create() {
     ModelAndView mav = new ModelAndView();
     mav.setViewName("/admin/create"); // webapp/admin/create.jsp
    
     return mav; // forward
   }
   /**
    * 등록 처리
    * @param adminVO
    * @return
    */
   @RequestMapping(value="/admin/create.do", method=RequestMethod.POST)
   public ModelAndView create(HttpServletRequest request, AdminVO adminVO){
     ModelAndView mav = new ModelAndView();
     // -------------------------------------------------------------------
     // 파일 전송 코드 시작
     // -------------------------------------------------------------------
     
     int cnt = this.adminProc.create(adminVO); 
     
     // -------------------------------------------------------------------
     // PK의 return
     // -------------------------------------------------------------------
     System.out.println("--> adminno: " + adminVO.getAdminno());
     mav.addObject("adminno", adminVO.getAdminno()); // redirect parameter 적용
     // -------------------------------------------------------------------
     
     mav.addObject("cnt", cnt); // request.setAttribute("cnt", cnt)
     mav.addObject("url", "create_msg"); // create_continue.jsp, redirect parameter 적용
     mav.setViewName("redirect:/admin/msg.do"); 
     return mav; // forward
   }
   /**
    * 관리자조회
    * @return
    */
   @RequestMapping(value="/admin/list.do", method=RequestMethod.GET)
   public ModelAndView list(){
     ModelAndView mav = new ModelAndView();
     
     List<AdminVO> list = this.adminProc.list();    
     mav.addObject("list", list);
     mav.setViewName("/admin/list"); // webapp/admin/list.jsp
  
     return mav; // forward
   }
   
   /**
    * 새로고침을 방지하는 메시지 출력
    * @return
    */
   @RequestMapping(value="/admin/msg.do", method=RequestMethod.GET)
   public ModelAndView msg(String url){
     ModelAndView mav = new ModelAndView();
     
     // 등록 처리 메시지: create_msg --> /contents/create_msg.jsp
     // 수정 처리 메시지: update_msg --> /contents/update_msg.jsp
     // 삭제 처리 메시지: delete_msg --> /contents/delete_msg.jsp
     mav.setViewName("/admin/" + url); // forward
     
     return mav; // forward
   }
   /**
    * 회원 정보 조회 , 수정
    * @param adminno
    * @return
    */
   @RequestMapping(value="/admin/read.do", method=RequestMethod.GET)
   public ModelAndView read(int adminno){
     ModelAndView mav = new ModelAndView();
     
     AdminVO adminVO = this.adminProc.read(adminno);
     mav.addObject("adminVO", adminVO);
     mav.setViewName("/admin/read"); // webapp/admin/read.jsp
     
     return mav; // forward
   }
   /**
    * 회원 정보 수정 처리
    * @param adminVO
    * @return
    */
   @RequestMapping(value="/admin/update.do", method=RequestMethod.POST)
   public ModelAndView update(AdminVO adminVO){
     ModelAndView mav = new ModelAndView();
     
     // System.out.println("id: " + adminVO.getId());
     
     int cnt= adminProc.update(adminVO);
     mav.addObject("cnt", cnt); // redirect parameter 적용
     mav.addObject("adminno", adminVO.getAdminno()); // redirect parameter 적용
     mav.addObject("url", "update_msg"); // update_msg.jsp, redirect parameter 적용

     mav.setViewName("redirect:/admin/msg.do");
     
     return mav;
   }
   /**
    * 회원 삭제
    * @param adminno
    * @return
    */
   @RequestMapping(value="/admin/delete.do", method=RequestMethod.GET)
   public ModelAndView delete(int adminno){
     ModelAndView mav = new ModelAndView();
     
     AdminVO adminVO = this.adminProc.read(adminno);
     mav.addObject("adminVO", adminVO);
     mav.setViewName("/admin/delete"); // webapp/admin/delete.jsp
     
     return mav; // forward
   }
  
   /**
    * 회원 삭제 처리
    * @param adminVO
    * @return
    */
   @RequestMapping(value="/admin/delete.do", method=RequestMethod.POST)
   public ModelAndView delete_proc(int adminno){
     ModelAndView mav = new ModelAndView();
     
     // System.out.println("id: " + adminVO.getId());
     AdminVO adminVO = this.adminProc.read(adminno);
     
     int cnt= adminProc.delete(adminno);
     mav.addObject("cnt", cnt); // redirect parameter 적용
     mav.addObject("mname", adminVO.getAdminname()); // redirect parameter 적용
     mav.addObject("url", "delete_msg"); // delete_msg.jsp, redirect parameter 적용
     
     mav.setViewName("redirect:/admin/msg.do");
     
     return mav;
   }
   
   /**
    * 패스워드를 변경합니다.
    * @param adminno
    * @return
    */
   @RequestMapping(value="/admin/passwd_update.do", method=RequestMethod.GET)
   public ModelAndView passwd_update(int adminno){
     ModelAndView mav = new ModelAndView();
     mav.setViewName("/admin/passwd_update");
     
     return mav;
   }
   
   /**
    * 패스워드 변경 처리
    * @param adminno 회원 번호
    * @param current_passwd 현재 패스워드
    * @param new_passwd 새로운 패스워드
    * @return
    */
   @RequestMapping(value="/admin/passwd_update.do", method=RequestMethod.POST)
   public ModelAndView passwd_update(int adminno, String current_passwd, String new_passwd){
     ModelAndView mav = new ModelAndView();
     
     // 현재 패스워드 검사
     HashMap<String, Object> map = new HashMap<String, Object>();
     map.put("adminno", adminno);
     map.put("adminpass", current_passwd);
     
     int cnt = adminProc.passwd_check(map);
     int update_cnt = 0; // 변경된 패스워드 수
     
     if (cnt == 1) { // 현재 패스워드가 일치하는 경우
       map.put("adminpass", new_passwd); // 새로운 패스워드를 저장
       update_cnt = adminProc.passwd_update(map); // 패스워드 변경 처리
       mav.addObject("update_cnt", update_cnt);  // 변경된 패스워드의 갯수    
     }

     mav.addObject("cnt", cnt); // 패스워드 일치 여부
     mav.addObject("url", "passwd_update_msg");
     
     mav.setViewName("redirect:/admin/msg.do");
     
     return mav;
   }
   /**
    * 로그인 폼
    * @return
    */
   // http://localhost:9090/ojt/admin/login.do 
   @RequestMapping(value = "/admin/login.do", 
                              method = RequestMethod.GET)
   public ModelAndView login_cookie(HttpServletRequest request) {
     ModelAndView mav = new ModelAndView();
     
     Cookie[] cookies = request.getCookies();
     Cookie cookie = null;

     String ck_adminid = ""; // id 저장
     String ck_adminid_save = ""; // id 저장 여부를 체크
     String ck_adminpasswd = ""; // passwd 저장
     String ck_adminpasswd_save = ""; // passwd 저장 여부를 체크

     if (cookies != null) {
       for (int i=0; i < cookies.length; i++){
         cookie = cookies[i]; // 쿠키 객체 추출
         
         if (cookie.getName().equals("ck_adminid")){
           ck_adminid = cookie.getValue(); 
         }else if(cookie.getName().equals("ck_adminid_save")){
           ck_adminid_save = cookie.getValue();  // Y, N
         }else if (cookie.getName().equals("ck_adminpasswd")){
           ck_adminpasswd = cookie.getValue();         // 1234
         }else if(cookie.getName().equals("ck_adminpasswd_save")){
           ck_adminpasswd_save = cookie.getValue();  // Y, N
         }
       }
     }
     
     mav.addObject("ck_adminid", ck_adminid); 
     mav.addObject("ck_adminid_save", ck_adminid_save);
     mav.addObject("ck_adminpasswd", ck_adminpasswd);
     mav.addObject("ck_adminpasswd_save", ck_adminpasswd_save);
     
     mav.setViewName("/admin/login_ck_form");
     return mav;
   }

   /**
    * 로그인 처리
    * @param request Cookie를 읽기위해 필요
    * @param response Cookie를 쓰기위해 필요
    * @param session 로그인 정보를 메모리에 기록
    * @param id  회원 아이디
    * @param passwd 회원 패스워드
    * @param id_save 회원 아이디 Cookie에 저장 여부
    * @param passwd_save 패스워드 Cookie에 저장 여부
    * @return
    */
   // http://localhost:9090/ojt/admin/login.do 
   @RequestMapping(value = "/admin/login.do", 
                              method = RequestMethod.POST)
   public ModelAndView login_cookie_proc(
                              HttpServletRequest request,
                              HttpServletResponse response,
                              HttpSession session,
                              String adminid, String adminpass,
                              @RequestParam(value="adminid_save", defaultValue="") String adminid_save,
                              @RequestParam(value="adminpasswd_save", defaultValue="") String adminpasswd_save) {
     ModelAndView mav = new ModelAndView();
     Map<String, Object> map = new HashMap<String, Object>();
     map.put("adminid", adminid);
     map.put("adminpass", adminpass);
     
     int count = adminProc.login(map);
     if (count == 1) { // 로그인 성공
       // System.out.println(id + " 로그인 성공");
       AdminVO adminVO = adminProc.readById(adminid);
       session.setAttribute("adminno", adminVO.getAdminno());
       session.setAttribute("adminid",adminid);
       session.setAttribute("adminname", adminVO.getAdminname());
       
       // -------------------------------------------------------------------
       // id 관련 쿠기 저장
       // -------------------------------------------------------------------
       if (adminid_save.equals("Y")) { // id를 저장할 경우, Checkbox를 체크한 경우
         Cookie ck_adminid = new Cookie("ck_adminid", adminid);
         ck_adminid.setMaxAge(60 * 60 * 72 * 10); // 30 day, 초단위
         response.addCookie(ck_adminid); // id 저장
       } else { // N, id를 저장하지 않는 경우, Checkbox를 체크 해제한 경우
         Cookie ck_adminid = new Cookie("ck_adminid", "");
         ck_adminid.setMaxAge(0);
         response.addCookie(ck_adminid); // id 저장
       }
       // id를 저장할지 선택하는  CheckBox 체크 여부
       Cookie ck_adminid_save = new Cookie("ck_adminid_save", adminid_save);
       ck_adminid_save.setMaxAge(60 * 60 * 72 * 10); // 30 day
       response.addCookie(ck_adminid_save);
       // -------------------------------------------------------------------

       // -------------------------------------------------------------------
       // Password 관련 쿠기 저장
       // -------------------------------------------------------------------
       if (adminpasswd_save.equals("Y")) { // 패스워드 저장할 경우
         Cookie ck_adminpasswd = new Cookie("ck_adminpasswd", adminpass);
         ck_adminpasswd.setMaxAge(60 * 60 * 72 * 10); // 30 day
         response.addCookie(ck_adminpasswd);
       } else { // N, 패스워드를 저장하지 않을 경우
         Cookie ck_adminpasswd = new Cookie("ck_adminpasswd", "");
         ck_adminpasswd.setMaxAge(0);
         response.addCookie(ck_adminpasswd);
       }
       // passwd를 저장할지 선택하는  CheckBox 체크 여부
       Cookie ck_adminpasswd_save = new Cookie("ck_adminpasswd_save", adminpasswd_save);
       ck_adminpasswd_save.setMaxAge(60 * 60 * 72 * 10); // 30 day
       response.addCookie(ck_adminpasswd_save);
       // -------------------------------------------------------------------
       
       mav.setViewName("redirect:/index.do");  
     } else {
       mav.setViewName("redirect:/admin/login_fail_msg.jsp");
     }
     return mav;
   }
   
   
   /**
    * 로그아웃 처리
    * @param session
    * @return
    */
   @RequestMapping(value="/admin/logout.do", 
                              method=RequestMethod.GET)
   public ModelAndView logout(HttpSession session){
     ModelAndView mav = new ModelAndView();
     session.invalidate(); // 모든 session 변수 삭제
     
     mav.setViewName("redirect:/admin/logout_msg.jsp");
     
     return mav;
   }
  
  
  
}


