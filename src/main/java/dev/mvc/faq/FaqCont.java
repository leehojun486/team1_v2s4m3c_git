package dev.mvc.faq;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import dev.mvc.admin.AdminProcInter;
import dev.mvc.tool.Tool;
import dev.mvc.tool.Upload;

@Controller
public class FaqCont {
  @Autowired
  @Qualifier("dev.mvc.faq.FaqProc")
  private FaqProcInter faqProc;
  
  
  public FaqCont() {
    
    System.out.println("--> faqCont created.");
  }
  
  
  /**
  * 등록 폼
  * @return
  */
  @RequestMapping(value="/faq/create.do", method=RequestMethod.GET )
  public ModelAndView create(){
    ModelAndView mav = new ModelAndView();
    
   
    mav.setViewName("/faq/create"); // webapp/member/create.jsp
    return mav; // forward
  }
  

  /**
   * 등록처리
   * http://localhost:9090/resort/cate/create.do
   * 
   * @return
   */
  @RequestMapping(value = "/faq/create.do", method = RequestMethod.POST)
  public ModelAndView create(FaqVO faqVO) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/faq/create_msg");

    // System.out.println("--> categrpno: " + cateVO.getCategrpno());
    int cnt = this.faqProc.create(faqVO);
    
    System.out.println("--> faqno: " + faqVO.getFaqno());
    mav.addObject("cnt", cnt);
    
    
    mav.addObject("faqno", faqVO.getFaqno());
    mav.addObject("url", "create_continue"); // create_continue.jsp, redirect parameter 적용
    mav.setViewName("redirect:/faq/msg.do"); 
    

    return mav;
  }
      
  /**
   * 새로고침을 방지하는 메시지 출력
   * @return
   */
  @RequestMapping(value="/faq/msg.do", method=RequestMethod.GET)
  public ModelAndView msg(String url){
    ModelAndView mav = new ModelAndView();
    
    // 등록 처리 메시지: create_msg --> /contents/create_msg.jsp
    // 수정 처리 메시지: update_msg --> /contents/update_msg.jsp
    // 삭제 처리 메시지: delete_msg --> /contents/delete_msg.jsp
    mav.setViewName("/faq/" + url); // forward
    
    return mav; // forward
  }
  
  /**
   * 목록 + 검색 + 페이징 지원
   * http://localhost:9090/resort/contents/list.do
   * http://localhost:9090/resort/contents/list.do?cateno=1&word=스위스&nowPage=1
   * @param cateno
   * @param word
   * @param nowPage
   * @return
   */
  @RequestMapping(value = "/faq/list_all.do", 
                                       method = RequestMethod.GET)
  public ModelAndView list_all_search_paging(
      @RequestParam(value="faqno", defaultValue="1") int faqno,
      @RequestParam(value="faqword", defaultValue="전체") String faqword,
      @RequestParam(value="nowPage", defaultValue="1") int nowPage
      ) { 
    System.out.println("--> nowPage: " + nowPage);
    
    ModelAndView mav = new ModelAndView();
    
    // 숫자와 문자열 타입을 저장해야함으로 Obejct 사용
    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("faqno" , faqno);
    map.put("faqword", faqword);     // #{word}
    map.put("nowPage", nowPage);  // 페이지에 출력할 레코드의 범위를 산출하기위해 사용     
    
    // 검색 목록
    List<Faq_AdminVO> list = faqProc.list_all_search_paging_join(map);
    mav.addObject("list", list);
    
    // 검색된 레코드 갯수
    int search_count = faqProc.search_count(map);
    mav.addObject("search_count", search_count);  
    


    /*
     * SPAN태그를 이용한 박스 모델의 지원, 1 페이지부터 시작 
     * 현재 페이지: 11 / 22   [이전] 11 12 13 14 15 16 17 18 19 20 [다음] 
     * 
     * @param listFile 목록 파일명 
     * @param cateno 카테고리번호 
     * @param search_count 검색(전체) 레코드수 
     * @param nowPage     현재 페이지
     * @param word 검색어
     * @return 페이징 생성 문자열
     */ 
    String paging = faqProc.pagingBox("list_all.do"  ,search_count, nowPage, faqword);
    mav.addObject("paging", paging);

    mav.addObject("nowPage", nowPage);

    // /contents/list_by_cateno_table_img1_search_paging.jsp
    mav.setViewName("/faq/list_all_search_paging_join");
    
    return mav;
  }    
//http://localhost:9090/resort/contents/read.do
 /**
  * 전체 목록
  * @return
  */
 @RequestMapping(value="/faq/read.do", method=RequestMethod.GET )
 public ModelAndView read(int faqno) {
   ModelAndView mav = new ModelAndView();

   FaqVO faqVO = this.faqProc.read(faqno);
   mav.addObject("faqVO", faqVO); // request.setAttribute("contentsVO", contentsVO);

   
   mav.setViewName("/faq/read"); // /webapp/contents/read_img_attachfile_reply_add_pg.jsp
   
   return mav;
 }
 
 /**
  * 수정 폼
  * @return
  */
 @RequestMapping(value="/faq/update.do", method=RequestMethod.GET )
 public ModelAndView update(int faqno) {
   ModelAndView mav = new ModelAndView();
   
   FaqVO faqVO = this.faqProc.read_update(faqno); // 수정용 읽기
   mav.addObject("faqVO", faqVO); // request.setAttribute("contentsVO", contentsVO);
   
   mav.setViewName("/faq/update"); // webapp/contents/update.jsp
   
   return mav;
 }
 
 // http://localhost:9090/resort/faq/update.do
 /**
  * 수정 처리
  * @param faqVO
  * @return
  */
 @RequestMapping(value="/faq/update.do", method=RequestMethod.POST )
 public ModelAndView update(FaqVO faqVO) {
   ModelAndView mav = new ModelAndView();
   
   mav.addObject("faqno", faqVO.getFaqno());   
   
   HashMap<String, Object> hashMap = new HashMap<String, Object>();
   hashMap.put("faqno", faqVO.getFaqno());
   hashMap.put("adminpass", faqVO.getAdminpass());
   
   int passwd_cnt = 0; // 패스워드 일치 레코드 갯수
   int cnt = 0;             // 수정된 레코드 갯수 
   
   passwd_cnt = this.faqProc.passwd_check(hashMap);
 
   if (passwd_cnt == 1) { // 패스워드가 일치할 경우 글 수정
     cnt = this.faqProc.update(faqVO);
   }

   mav.addObject("cnt", cnt);
   mav.addObject("passwd_cnt", passwd_cnt); // request에 저장
   
     
   mav.setViewName("/faq/update_msg"); // webapp/contents/update_msg.jsp
   
   return mav;
 }
 /**
  * 로그인 여부만 체크함으로 다른 사용자의 글을 삭제 할 수 있는 화면이 출력됨.
  * 삭제 폼, attachfile Ajax 기반 삭제 지원
  * @return
  */
  @RequestMapping(value="/faq/delete.do", method=RequestMethod.GET )
  public ModelAndView delete(HttpSession session, int faqno) {
    ModelAndView mav = new ModelAndView();
    
    int adminno = (int)session.getAttribute("adminno");
    
    if (adminno == this.faqProc.read(faqno).getAdminno()) {
      FaqVO faqVO = this.faqProc.read_update(faqno); // 수정용 읽기
      mav.addObject("faqVO", faqVO); // request.setAttribute("contentsVO", contentsVO);
      
      mav.setViewName("/faq/delete"); // webapp/contents/delete.jsp
    } else {
      mav.setViewName("redirect:/admin/mconfirm_fail_msg.jsp");
    }
    
    return mav;
  }
 
 // http://localhost:9090/resort/contents/delete.do
 /**
  * 삭제 처리 +  파일 삭제
  * @param contentsVO
  * @return
  */
 @RequestMapping(value="/faq/delete.do", method=RequestMethod.POST )
 public ModelAndView delete(HttpServletRequest request,
                                          int faqno, 
                                          String adminpass,
                                          @RequestParam(value="word", defaultValue="") String word,
                                          @RequestParam(value="nowPage", defaultValue="1") int nowPage) {
   ModelAndView mav = new ModelAndView();
  
   FaqVO faqVO = this.faqProc.read(faqno);
   String faqtitle = faqVO.getFaqtitle();
   mav.addObject("faqtitle", faqtitle);
   
   HashMap<String, Object> hashMap = new HashMap<String, Object>();
   hashMap.put("faqno", faqno);
   hashMap.put("adminpass", adminpass);
   
   int passwd_cnt = 0; // 패스워드 일치 레코드 갯수
   int cnt = 0;             // 수정된 레코드 갯수 
   
   passwd_cnt = this.faqProc.passwd_check(hashMap);
   boolean sw = false;
   
   if (passwd_cnt == 1) { // 패스워드가 일치할 경우 글 수정
     cnt = this.faqProc.delete(faqno);
     
     String upDir = Tool.getRealPath(request, "/faq/storage/main_images"); // 절대 경로

   }

   mav.addObject("cnt", cnt); // request에 저장
   mav.addObject("passwd_cnt", passwd_cnt); // request에 저장
   mav.addObject("nowPage", nowPage); // request에 저장
   // System.out.println("--> ContentsCont.java nowPage: " + nowPage);
   
   mav.addObject("url", "delete_msg"); // delete_msg.jsp, redirect parameter 적용
   
   // mav.setViewName("/contents/delete_msg"); // webapp/contents/delete_msg.jsp
   mav.setViewName("redirect:/faq/msg.do"); 
   
   return mav;
 }
}





