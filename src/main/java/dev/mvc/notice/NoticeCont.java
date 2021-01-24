package dev.mvc.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
   * 삭제 처리http://localhost:9090/team1/notice/read.do
   * @param noticeno
   * @return
   */
  @RequestMapping(value = "/notice/delete.do", method = RequestMethod.GET)
  public ModelAndView delete(int noticeno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/notice/delete_msg"); // /webapp/notice/read.jsp
    int cnt = this.noticeproc.delete(noticeno);
    mav.addObject("cnt", cnt);
    return mav;
  }
  
}