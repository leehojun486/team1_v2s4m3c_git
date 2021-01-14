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
  @Qualifier("dev.mvc.admin.AdminProc") // �̸� ����
  private AdminProcInter adminProc;
  /**
  * ID �ߺ� üũ, JSON ���
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
 * ������ ��� ��
 */
   @RequestMapping(value="/admin/create.do", method=RequestMethod.GET )
   public ModelAndView create() {
     ModelAndView mav = new ModelAndView();
     mav.setViewName("/admin/create"); // webapp/admin/create.jsp
    
     return mav; // forward
   }
   /**
    * ��� ó��
    * @param adminVO
    * @return
    */
   @RequestMapping(value="/admin/create.do", method=RequestMethod.POST)
   public ModelAndView create(HttpServletRequest request, AdminVO adminVO){
     ModelAndView mav = new ModelAndView();
     // -------------------------------------------------------------------
     // ���� ���� �ڵ� ����
     // -------------------------------------------------------------------
     
     int cnt = this.adminProc.create(adminVO); 
     
     // -------------------------------------------------------------------
     // PK�� return
     // -------------------------------------------------------------------
     System.out.println("--> adminno: " + adminVO.getAdminno());
     mav.addObject("adminno", adminVO.getAdminno()); // redirect parameter ����
     // -------------------------------------------------------------------
     
     mav.addObject("cnt", cnt); // request.setAttribute("cnt", cnt)
     mav.addObject("url", "create_msg"); // create_continue.jsp, redirect parameter ����
     mav.setViewName("redirect:/admin/msg.do"); 
     return mav; // forward
   }
   /**
    * ��������ȸ
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
    * ���ΰ�ħ�� �����ϴ� �޽��� ���
    * @return
    */
   @RequestMapping(value="/admin/msg.do", method=RequestMethod.GET)
   public ModelAndView msg(String url){
     ModelAndView mav = new ModelAndView();
     
     // ��� ó�� �޽���: create_msg --> /contents/create_msg.jsp
     // ���� ó�� �޽���: update_msg --> /contents/update_msg.jsp
     // ���� ó�� �޽���: delete_msg --> /contents/delete_msg.jsp
     mav.setViewName("/admin/" + url); // forward
     
     return mav; // forward
   }
   /**
    * ȸ�� ���� ��ȸ , ����
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
    * ȸ�� ���� ���� ó��
    * @param adminVO
    * @return
    */
   @RequestMapping(value="/admin/update.do", method=RequestMethod.POST)
   public ModelAndView update(AdminVO adminVO){
     ModelAndView mav = new ModelAndView();
     
     // System.out.println("id: " + adminVO.getId());
     
     int cnt= adminProc.update(adminVO);
     mav.addObject("cnt", cnt); // redirect parameter ����
     mav.addObject("adminno", adminVO.getAdminno()); // redirect parameter ����
     mav.addObject("url", "update_msg"); // update_msg.jsp, redirect parameter ����

     mav.setViewName("redirect:/admin/msg.do");
     
     return mav;
   }
   /**
    * ȸ�� ����
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
    * ȸ�� ���� ó��
    * @param adminVO
    * @return
    */
   @RequestMapping(value="/admin/delete.do", method=RequestMethod.POST)
   public ModelAndView delete_proc(int adminno){
     ModelAndView mav = new ModelAndView();
     
     // System.out.println("id: " + adminVO.getId());
     AdminVO adminVO = this.adminProc.read(adminno);
     
     int cnt= adminProc.delete(adminno);
     mav.addObject("cnt", cnt); // redirect parameter ����
     mav.addObject("mname", adminVO.getAdminname()); // redirect parameter ����
     mav.addObject("url", "delete_msg"); // delete_msg.jsp, redirect parameter ����
     
     mav.setViewName("redirect:/admin/msg.do");
     
     return mav;
   }
   
   /**
    * �н����带 �����մϴ�.
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
    * �н����� ���� ó��
    * @param adminno ȸ�� ��ȣ
    * @param current_passwd ���� �н�����
    * @param new_passwd ���ο� �н�����
    * @return
    */
   @RequestMapping(value="/admin/passwd_update.do", method=RequestMethod.POST)
   public ModelAndView passwd_update(int adminno, String current_passwd, String new_passwd){
     ModelAndView mav = new ModelAndView();
     
     // ���� �н����� �˻�
     HashMap<String, Object> map = new HashMap<String, Object>();
     map.put("adminno", adminno);
     map.put("adminpass", current_passwd);
     
     int cnt = adminProc.passwd_check(map);
     int update_cnt = 0; // ����� �н����� ��
     
     if (cnt == 1) { // ���� �н����尡 ��ġ�ϴ� ���
       map.put("adminpass", new_passwd); // ���ο� �н����带 ����
       update_cnt = adminProc.passwd_update(map); // �н����� ���� ó��
       mav.addObject("update_cnt", update_cnt);  // ����� �н������� ����    
     }

     mav.addObject("cnt", cnt); // �н����� ��ġ ����
     mav.addObject("url", "passwd_update_msg");
     
     mav.setViewName("redirect:/admin/msg.do");
     
     return mav;
   }
   /**
    * �α��� ��
    * @return
    */
   // http://localhost:9090/ojt/admin/login.do 
   @RequestMapping(value = "/admin/login.do", 
                              method = RequestMethod.GET)
   public ModelAndView login_cookie(HttpServletRequest request) {
     ModelAndView mav = new ModelAndView();
     
     Cookie[] cookies = request.getCookies();
     Cookie cookie = null;

     String ck_adminid = ""; // id ����
     String ck_adminid_save = ""; // id ���� ���θ� üũ
     String ck_adminpasswd = ""; // passwd ����
     String ck_adminpasswd_save = ""; // passwd ���� ���θ� üũ

     if (cookies != null) {
       for (int i=0; i < cookies.length; i++){
         cookie = cookies[i]; // ��Ű ��ü ����
         
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
    * �α��� ó��
    * @param request Cookie�� �б����� �ʿ�
    * @param response Cookie�� �������� �ʿ�
    * @param session �α��� ������ �޸𸮿� ���
    * @param id  ȸ�� ���̵�
    * @param passwd ȸ�� �н�����
    * @param id_save ȸ�� ���̵� Cookie�� ���� ����
    * @param passwd_save �н����� Cookie�� ���� ����
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
     if (count == 1) { // �α��� ����
       // System.out.println(id + " �α��� ����");
       AdminVO adminVO = adminProc.readById(adminid);
       session.setAttribute("adminno", adminVO.getAdminno());
       session.setAttribute("adminid",adminid);
       session.setAttribute("adminname", adminVO.getAdminname());
       
       // -------------------------------------------------------------------
       // id ���� ��� ����
       // -------------------------------------------------------------------
       if (adminid_save.equals("Y")) { // id�� ������ ���, Checkbox�� üũ�� ���
         Cookie ck_adminid = new Cookie("ck_adminid", adminid);
         ck_adminid.setMaxAge(60 * 60 * 72 * 10); // 30 day, �ʴ���
         response.addCookie(ck_adminid); // id ����
       } else { // N, id�� �������� �ʴ� ���, Checkbox�� üũ ������ ���
         Cookie ck_adminid = new Cookie("ck_adminid", "");
         ck_adminid.setMaxAge(0);
         response.addCookie(ck_adminid); // id ����
       }
       // id�� �������� �����ϴ�  CheckBox üũ ����
       Cookie ck_adminid_save = new Cookie("ck_adminid_save", adminid_save);
       ck_adminid_save.setMaxAge(60 * 60 * 72 * 10); // 30 day
       response.addCookie(ck_adminid_save);
       // -------------------------------------------------------------------

       // -------------------------------------------------------------------
       // Password ���� ��� ����
       // -------------------------------------------------------------------
       if (adminpasswd_save.equals("Y")) { // �н����� ������ ���
         Cookie ck_adminpasswd = new Cookie("ck_adminpasswd", adminpass);
         ck_adminpasswd.setMaxAge(60 * 60 * 72 * 10); // 30 day
         response.addCookie(ck_adminpasswd);
       } else { // N, �н����带 �������� ���� ���
         Cookie ck_adminpasswd = new Cookie("ck_adminpasswd", "");
         ck_adminpasswd.setMaxAge(0);
         response.addCookie(ck_adminpasswd);
       }
       // passwd�� �������� �����ϴ�  CheckBox üũ ����
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
    * �α׾ƿ� ó��
    * @param session
    * @return
    */
   @RequestMapping(value="/admin/logout.do", 
                              method=RequestMethod.GET)
   public ModelAndView logout(HttpSession session){
     ModelAndView mav = new ModelAndView();
     session.invalidate(); // ��� session ���� ����
     
     mav.setViewName("redirect:/admin/logout_msg.jsp");
     
     return mav;
   }
  
  
  
}


