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
  * ��� ��
  * @return
  */
  @RequestMapping(value="/faq/create.do", method=RequestMethod.GET )
  public ModelAndView create(){
    ModelAndView mav = new ModelAndView();
    
   
    mav.setViewName("/faq/create"); // webapp/member/create.jsp
    return mav; // forward
  }
  

  /**
   * ���ó��
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
    mav.addObject("url", "create_continue"); // create_continue.jsp, redirect parameter ����
    mav.setViewName("redirect:/faq/msg.do"); 
    

    return mav;
  }
      
  /**
   * ���ΰ�ħ�� �����ϴ� �޽��� ���
   * @return
   */
  @RequestMapping(value="/faq/msg.do", method=RequestMethod.GET)
  public ModelAndView msg(String url){
    ModelAndView mav = new ModelAndView();
    
    // ��� ó�� �޽���: create_msg --> /contents/create_msg.jsp
    // ���� ó�� �޽���: update_msg --> /contents/update_msg.jsp
    // ���� ó�� �޽���: delete_msg --> /contents/delete_msg.jsp
    mav.setViewName("/faq/" + url); // forward
    
    return mav; // forward
  }
  
  /**
   * ��� + �˻� + ����¡ ����
   * http://localhost:9090/resort/contents/list.do
   * http://localhost:9090/resort/contents/list.do?cateno=1&word=������&nowPage=1
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
    
    // ���ڿ� ���ڿ� Ÿ���� �����ؾ������� Obejct ���
    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("faqno" , faqno);
    map.put("faqword", faqword);     // #{word}
    map.put("nowPage", nowPage);  // �������� ����� ���ڵ��� ������ �����ϱ����� ���     
    
    // �˻� ���
    List<Faq_AdminVO> list = faqProc.list_all_search_paging_join(map);
    mav.addObject("list", list);
    
    // �˻��� ���ڵ� ����
    int search_count = faqProc.search_count(map);
    mav.addObject("search_count", search_count);  
    


    /*
     * SPAN�±׸� �̿��� �ڽ� ���� ����, 1 ���������� ���� 
     * ���� ������: 11 / 22   [����] 11 12 13 14 15 16 17 18 19 20 [����] 
     * 
     * @param listFile ��� ���ϸ� 
     * @param cateno ī�װ���ȣ 
     * @param search_count �˻�(��ü) ���ڵ�� 
     * @param nowPage     ���� ������
     * @param word �˻���
     * @return ����¡ ���� ���ڿ�
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
  * ��ü ���
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
  * ���� ��
  * @return
  */
 @RequestMapping(value="/faq/update.do", method=RequestMethod.GET )
 public ModelAndView update(int faqno) {
   ModelAndView mav = new ModelAndView();
   
   FaqVO faqVO = this.faqProc.read_update(faqno); // ������ �б�
   mav.addObject("faqVO", faqVO); // request.setAttribute("contentsVO", contentsVO);
   
   mav.setViewName("/faq/update"); // webapp/contents/update.jsp
   
   return mav;
 }
 
 // http://localhost:9090/resort/faq/update.do
 /**
  * ���� ó��
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
   
   int passwd_cnt = 0; // �н����� ��ġ ���ڵ� ����
   int cnt = 0;             // ������ ���ڵ� ���� 
   
   passwd_cnt = this.faqProc.passwd_check(hashMap);
 
   if (passwd_cnt == 1) { // �н����尡 ��ġ�� ��� �� ����
     cnt = this.faqProc.update(faqVO);
   }

   mav.addObject("cnt", cnt);
   mav.addObject("passwd_cnt", passwd_cnt); // request�� ����
   
     
   mav.setViewName("/faq/update_msg"); // webapp/contents/update_msg.jsp
   
   return mav;
 }
 /**
  * �α��� ���θ� üũ������ �ٸ� ������� ���� ���� �� �� �ִ� ȭ���� ��µ�.
  * ���� ��, attachfile Ajax ��� ���� ����
  * @return
  */
  @RequestMapping(value="/faq/delete.do", method=RequestMethod.GET )
  public ModelAndView delete(HttpSession session, int faqno) {
    ModelAndView mav = new ModelAndView();
    
    int adminno = (int)session.getAttribute("adminno");
    
    if (adminno == this.faqProc.read(faqno).getAdminno()) {
      FaqVO faqVO = this.faqProc.read_update(faqno); // ������ �б�
      mav.addObject("faqVO", faqVO); // request.setAttribute("contentsVO", contentsVO);
      
      mav.setViewName("/faq/delete"); // webapp/contents/delete.jsp
    } else {
      mav.setViewName("redirect:/admin/mconfirm_fail_msg.jsp");
    }
    
    return mav;
  }
 
 // http://localhost:9090/resort/contents/delete.do
 /**
  * ���� ó�� +  ���� ����
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
   
   int passwd_cnt = 0; // �н����� ��ġ ���ڵ� ����
   int cnt = 0;             // ������ ���ڵ� ���� 
   
   passwd_cnt = this.faqProc.passwd_check(hashMap);
   boolean sw = false;
   
   if (passwd_cnt == 1) { // �н����尡 ��ġ�� ��� �� ����
     cnt = this.faqProc.delete(faqno);
     
     String upDir = Tool.getRealPath(request, "/faq/storage/main_images"); // ���� ���

   }

   mav.addObject("cnt", cnt); // request�� ����
   mav.addObject("passwd_cnt", passwd_cnt); // request�� ����
   mav.addObject("nowPage", nowPage); // request�� ����
   // System.out.println("--> ContentsCont.java nowPage: " + nowPage);
   
   mav.addObject("url", "delete_msg"); // delete_msg.jsp, redirect parameter ����
   
   // mav.setViewName("/contents/delete_msg"); // webapp/contents/delete_msg.jsp
   mav.setViewName("redirect:/faq/msg.do"); 
   
   return mav;
 }
}





