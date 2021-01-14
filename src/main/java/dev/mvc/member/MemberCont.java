package dev.mvc.member;



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
public class MemberCont {
  @Autowired
  @Qualifier("dev.mvc.member.MemberProc")
  private MemberProcInter memberProc;
  
  /*
   * @Autowired
   * 
   * @Qualifier("dev.mvc.follow.FollowProc") private FollowProcInter followProc;
   */

  public MemberCont() {
}
  // http://localhost:9090/resort/member/checkID.do?id=user1
  /**
  * ID 중복 체크, JSON 출력
  * @return
  */
  @ResponseBody
  @RequestMapping(value="/member/checkID.do", method=RequestMethod.GET ,
                         produces = "text/plain;charset=UTF-8" )
  public String checkID(String memberid) {
    int cnt = this.memberProc.checkID(memberid);
   
    JSONObject json = new JSONObject();
    json.put("cnt", cnt);
   
    return json.toString(); 
  }
  
  /**
  * 등록 폼
  * @return
  */
  @RequestMapping(value="/member/create.do", method=RequestMethod.GET )
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/member/create"); // webapp/member/create.jsp
   
    return mav; // forward
  }

  /**
   * 등록 처리
   * @param memberVO
   * @return
   */
  @RequestMapping(value="/member/create.do", method=RequestMethod.POST)
  public ModelAndView create(HttpServletRequest request, MemberVO memberVO){
    ModelAndView mav = new ModelAndView();
    // -------------------------------------------------------------------
    // 파일 전송 코드 시작
    // -------------------------------------------------------------------
    String memberimg = "";     // main image
    String memberpreview = ""; // preview image
        
    String upDir = Tool.getRealPath(request, "/member/storage/main_images"); // 절대 경로
    
    // 전송 파일이 없어서도 fnamesMF 객체가 생성됨.
    // <input type='file' class="form-control" name='file1MF' id='file1MF' 
    //           value='' placeholder="파일 선택" multiple="multiple">
    MultipartFile mf = memberVO.getMemberimgMF();
    
    long memberimgsize = mf.getSize();  // 파일 크기
    if (memberimgsize > 0) { // 파일 크기 체크
      // mp3 = mf.getOriginalFilename(); // 원본 파일명, spring.jpg
      // 파일 저장 후 업로드된 파일명이 리턴됨, spring.jsp, spring_1.jpg...
      memberimg = Upload.saveFileSpring(mf, upDir); 
      
      if (Tool.isImage(memberimg)) { // 이미지인지 검사
        // thumb 이미지 생성후 파일명 리턴됨, width: 200, height: 150
        memberpreview = Tool.preview(upDir, memberimg, 200, 150); 
      }
      
    }    
    
    memberVO.setMemberimg(memberimg);
    memberVO.setMemberpreview(memberpreview);
    memberVO.setMemberimgsize(memberimgsize);;
    // -------------------------------------------------------------------
    // 파일 전송 코드 종료
    // -------------------------------------------------------------------
    // Call By Reference: 메모리 공유, Hashcode 전달
    int cnt = this.memberProc.create(memberVO); 
    
    // -------------------------------------------------------------------
    // PK의 return
    // -------------------------------------------------------------------
    System.out.println("--> memberno: " + memberVO.getMemberno());
    mav.addObject("memberno", memberVO.getMemberno()); // redirect parameter 적용
    // -------------------------------------------------------------------
    
    mav.addObject("cnt", cnt); // request.setAttribute("cnt", cnt)
    mav.addObject("url", "create_msg"); // create_continue.jsp, redirect parameter 적용
    mav.setViewName("redirect:/member/msg.do"); 
    return mav; // forward
  }
  /**
   * 회원조회
   * @return
   */
  @RequestMapping(value="/member/list.do", method=RequestMethod.GET)
  public ModelAndView list(){
    ModelAndView mav = new ModelAndView();
    
    List<MemberVO> list = this.memberProc.list();    
    mav.addObject("list", list);
    mav.setViewName("/member/list"); // webapp/member/list.jsp
 
    return mav; // forward
  }
  
  /**
   * 새로고침을 방지하는 메시지 출력
   * @return
   */
  @RequestMapping(value="/member/msg.do", method=RequestMethod.GET)
  public ModelAndView msg(String url){
    ModelAndView mav = new ModelAndView();
    
    // 등록 처리 메시지: create_msg --> /contents/create_msg.jsp
    // 수정 처리 메시지: update_msg --> /contents/update_msg.jsp
    // 삭제 처리 메시지: delete_msg --> /contents/delete_msg.jsp
    mav.setViewName("/member/" + url); // forward
    
    return mav; // forward
  }
  
  /**
   * 회원 정보 조회 , 수정
   * @param memberno
   * @return
   */
  @RequestMapping(value="/member/read.do", method=RequestMethod.GET)
  public ModelAndView read(int memberno){
    ModelAndView mav = new ModelAndView();
    
    MemberVO memberVO = this.memberProc.read(memberno);
    mav.addObject("memberVO", memberVO);
    mav.setViewName("/member/read"); // webapp/member/read.jsp
    
    return mav; // forward
  }
  /**
   * 회원 정보 수정 처리
   * @param memberVO
   * @return
   */
  @RequestMapping(value="/member/update.do", method=RequestMethod.POST)
  public ModelAndView update(MemberVO memberVO){
    ModelAndView mav = new ModelAndView();
    
    // System.out.println("id: " + memberVO.getId());
    
    int cnt= memberProc.update(memberVO);
    mav.addObject("cnt", cnt); // redirect parameter 적용
    mav.addObject("memberno", memberVO.getMemberno()); // redirect parameter 적용
    mav.addObject("url", "update_msg"); // update_msg.jsp, redirect parameter 적용

    mav.setViewName("redirect:/member/msg.do");
    
    return mav;
  }
  /**
   * 회원 삭제
   * @param memberno
   * @return
   */
  @RequestMapping(value="/member/delete.do", method=RequestMethod.GET)
  public ModelAndView delete(int memberno){
    ModelAndView mav = new ModelAndView();
    
    MemberVO memberVO = this.memberProc.read(memberno);
    mav.addObject("memberVO", memberVO);
    mav.setViewName("/member/delete"); // webapp/member/delete.jsp
    
    return mav; // forward
  }
 
  /**
   * 회원 삭제 처리
   * @param memberVO
   * @return
   */
  @RequestMapping(value="/member/delete.do", method=RequestMethod.POST)
  public ModelAndView delete_proc(int memberno){
    ModelAndView mav = new ModelAndView();
    
    // System.out.println("id: " + memberVO.getId());
    MemberVO memberVO = this.memberProc.read(memberno);
    
    int cnt= memberProc.delete(memberno);
    mav.addObject("cnt", cnt); // redirect parameter 적용
    mav.addObject("mname", memberVO.getMembername()); // redirect parameter 적용
    mav.addObject("url", "delete_msg"); // delete_msg.jsp, redirect parameter 적용
    
    mav.setViewName("redirect:/member/msg.do");
    
    return mav;
  }
  
  /**
   * 패스워드를 변경합니다.
   * @param memberno
   * @return
   */
  @RequestMapping(value="/member/passwd_update.do", method=RequestMethod.GET)
  public ModelAndView passwd_update(int memberno){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/member/passwd_update");
    
    return mav;
  }
  
  /**
   * 패스워드 변경 처리
   * @param memberno 회원 번호
   * @param current_passwd 현재 패스워드
   * @param new_passwd 새로운 패스워드
   * @return
   */
  @RequestMapping(value="/member/passwd_update.do", method=RequestMethod.POST)
  public ModelAndView passwd_update(int memberno, String current_passwd, String new_passwd){
    ModelAndView mav = new ModelAndView();
    
    // 현재 패스워드 검사
    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("memberno", memberno);
    map.put("memberpass", current_passwd);
    
    int cnt = memberProc.passwd_check(map);
    int update_cnt = 0; // 변경된 패스워드 수
    
    if (cnt == 1) { // 현재 패스워드가 일치하는 경우
      map.put("memberpass", new_passwd); // 새로운 패스워드를 저장
      update_cnt = memberProc.passwd_update(map); // 패스워드 변경 처리
      mav.addObject("update_cnt", update_cnt);  // 변경된 패스워드의 갯수    
    }

    mav.addObject("cnt", cnt); // 패스워드 일치 여부
    mav.addObject("url", "passwd_update_msg");
    
    mav.setViewName("redirect:/member/msg.do");
    
    return mav;
  }

  /**
   * 로그인 폼
   * @return
   */
  // http://localhost:9090/ojt/member/login.do 
  @RequestMapping(value = "/member/login.do", 
                             method = RequestMethod.GET)
  public ModelAndView login_cookie(HttpServletRequest request) {
    ModelAndView mav = new ModelAndView();
    
    Cookie[] cookies = request.getCookies();
    Cookie cookie = null;

    String ck_id = ""; // id 저장
    String ck_id_save = ""; // id 저장 여부를 체크
    String ck_passwd = ""; // passwd 저장
    String ck_passwd_save = ""; // passwd 저장 여부를 체크

    if (cookies != null) {
      for (int i=0; i < cookies.length; i++){
        cookie = cookies[i]; // 쿠키 객체 추출
        
        if (cookie.getName().equals("ck_id")){
          ck_id = cookie.getValue(); 
        }else if(cookie.getName().equals("ck_id_save")){
          ck_id_save = cookie.getValue();  // Y, N
        }else if (cookie.getName().equals("ck_passwd")){
          ck_passwd = cookie.getValue();         // 1234
        }else if(cookie.getName().equals("ck_passwd_save")){
          ck_passwd_save = cookie.getValue();  // Y, N
        }
      }
    }
    
    mav.addObject("ck_id", ck_id); 
    mav.addObject("ck_id_save", ck_id_save);
    mav.addObject("ck_passwd", ck_passwd);
    mav.addObject("ck_passwd_save", ck_passwd_save);
    
    mav.setViewName("/member/login_ck_form");
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
  // http://localhost:9090/ojt/member/login.do 
  @RequestMapping(value = "/member/login.do", 
                             method = RequestMethod.POST)
  public ModelAndView login_cookie_proc(
                             HttpServletRequest request,
                             HttpServletResponse response,
                             HttpSession session,
                             String memberid, String memberpass,
                             @RequestParam(value="id_save", defaultValue="") String id_save,
                             @RequestParam(value="passwd_save", defaultValue="") String passwd_save) {
    ModelAndView mav = new ModelAndView();
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("memberid", memberid);
    map.put("memberpass", memberpass);
    
    int count = memberProc.login(map);
    if (count == 1) { // 로그인 성공
      // System.out.println(id + " 로그인 성공");
      MemberVO memberVO = memberProc.readById(memberid);
      session.setAttribute("memberno", memberVO.getMemberno());
      session.setAttribute("memberid", memberid);
      session.setAttribute("membername", memberVO.getMembername());
      
      // -------------------------------------------------------------------
      // id 관련 쿠기 저장
      // -------------------------------------------------------------------
      if (id_save.equals("Y")) { // id를 저장할 경우, Checkbox를 체크한 경우
        Cookie ck_id = new Cookie("ck_id", memberid);
        ck_id.setMaxAge(60 * 60 * 72 * 10); // 30 day, 초단위
        response.addCookie(ck_id); // id 저장
      } else { // N, id를 저장하지 않는 경우, Checkbox를 체크 해제한 경우
        Cookie ck_id = new Cookie("ck_id", "");
        ck_id.setMaxAge(0);
        response.addCookie(ck_id); // id 저장
      }
      // id를 저장할지 선택하는  CheckBox 체크 여부
      Cookie ck_id_save = new Cookie("ck_id_save", id_save);
      ck_id_save.setMaxAge(60 * 60 * 72 * 10); // 30 day
      response.addCookie(ck_id_save);
      // -------------------------------------------------------------------

      // -------------------------------------------------------------------
      // Password 관련 쿠기 저장
      // -------------------------------------------------------------------
      if (passwd_save.equals("Y")) { // 패스워드 저장할 경우
        Cookie ck_passwd = new Cookie("ck_passwd", memberpass);
        ck_passwd.setMaxAge(60 * 60 * 72 * 10); // 30 day
        response.addCookie(ck_passwd);
      } else { // N, 패스워드를 저장하지 않을 경우
        Cookie ck_passwd = new Cookie("ck_passwd", "");
        ck_passwd.setMaxAge(0);
        response.addCookie(ck_passwd);
      }
      // passwd를 저장할지 선택하는  CheckBox 체크 여부
      Cookie ck_passwd_save = new Cookie("ck_passwd_save", passwd_save);
      ck_passwd_save.setMaxAge(60 * 60 * 72 * 10); // 30 day
      response.addCookie(ck_passwd_save);
      // -------------------------------------------------------------------
      
      mav.setViewName("redirect:/index.do");  
    } else {
      mav.setViewName("redirect:/member/login_fail_msg.jsp");
    }
        
    return mav;
  }
  
  
  /**
   * 로그아웃 처리
   * @param session
   * @return
   */
  @RequestMapping(value="/member/logout.do", 
                             method=RequestMethod.GET)
  public ModelAndView logout(HttpSession session){
    ModelAndView mav = new ModelAndView();
    session.invalidate(); // 모든 session 변수 삭제
    
    mav.setViewName("redirect:/member/logout_msg.jsp");
    
    return mav;
  }
 
}
  


