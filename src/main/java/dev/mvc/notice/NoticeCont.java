package dev.mvc.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.member.MemberVO;
import dev.mvc.tool.Tool;
import dev.mvc.tool.Upload;

@Controller
public class NoticeCont {
  @Autowired
  @Qualifier("dev.mvc.notice.NoticeProc")
  private NoticeProcInter noticeproc;
  
  public NoticeCont() {
    System.out.println("--> NoticeCont created");
  }
  
  /**
   * 공지사항 등록 http://localhost:9090/team1/notice/create.do
   * @return
   */
  @RequestMapping(value = "/notice/create.do", method = RequestMethod.GET)
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/notice/create"); // /webapp/notice/create.jsp
    return mav; // forward
  }
  
  @RequestMapping(value = "/notice/create.do", method = RequestMethod.POST)
  public ModelAndView create(NoticeVO noticeVO) {

    ModelAndView mav = new ModelAndView();
    int cnt = this.noticeproc.create(noticeVO);
    
    mav.addObject("cnt", cnt);
    mav.addObject("url", "create_msg"); // // webapp/notice/create_msg.jsp
    
    mav.setViewName("/notice/create_msg"); // /webapp/notice/create_msg.jsp
    return mav; // forward
  }
  
  /**
   * 목록 http://localhost:9090/team1/notice/list_all.do
   * @return
   */
  @RequestMapping(value = "/notice/list_all.do", method = RequestMethod.GET)
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/notice/list_all"); // /webapp/notice/list_all.jsp
    List<NoticeVO> list = this.noticeproc.list_all();
    mav.addObject("list", list);
    return mav;
  }
  
  /**
   * 조회 http://localhost:9090/team1/notice/read.do
   * @param noticeno
   * @return
   */
  @RequestMapping(value = "/notice/read.do", method = RequestMethod.GET)
  public ModelAndView read(int noticeno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/notice/read"); // /webapp/notice/read.jsp
    NoticeVO noticeVO = this.noticeproc.read(noticeno);
    mav.addObject("noticeVO", noticeVO);
    return mav;
  }
  
  /**
   * 수정 폼 http://localhost:9090/team1/notice/read.do
   * @param noticeno
   * @return
   */
  @RequestMapping(value = "/notice/update_form.do", method = RequestMethod.GET)
  public ModelAndView update(int noticeno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/notice/update_form"); // /webapp/notice/read.jsp
    NoticeVO noticeVO = this.noticeproc.read(noticeno);
    mav.addObject("noticeVO", noticeVO);
    return mav;
  }
  
  /**
   * 수정 처리 http://localhost:9090/team1/notice/read.do
   * @param noticeno
   * @return
   */
  @RequestMapping(value = "/notice/update.do", method = RequestMethod.POST)
  public ModelAndView update(NoticeVO noticeVO) {
    ModelAndView mav = new ModelAndView();
    int cnt = this.noticeproc.update(noticeVO);
    mav.setViewName("/notice/update_msg"); // /webapp/notice/update_msg.jsp
    mav.addObject("cnt", cnt);
    return mav;
  }
  
  /**
   * Ajax + read http://localhost:9090/resort/categrp/read_ajax.do
   * 
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/notice/read_ajax.do", method = RequestMethod.GET,
                          produces = "text/plain;charset=UTF-8")
  public String read_ajax(int noticeno) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    NoticeVO noticeVO = this.noticeproc.read(noticeno);

    JSONObject json = new JSONObject();
    json.put("noticeno", noticeno);
    json.put("title", noticeVO.getTitle());
    return json.toString();
  }
  
  /**
   * 삭제 처리 + Ajax
   * @param noticeno
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/notice/delete_ajax.do", method = RequestMethod.POST,
                          produces = "text/plain;charset=UTF-8")
  public String delete_ajax(int noticeno) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    int cnt = this.noticeproc.delete(noticeno);
    
    JSONObject json = new JSONObject();
    json.put("cnt", cnt);
    System.out.println("cnt:"+ cnt);
    
    return json.toString();
  }
  
}