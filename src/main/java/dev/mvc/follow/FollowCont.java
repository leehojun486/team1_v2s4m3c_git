package dev.mvc.follow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.member.MemberProcInter;
import dev.mvc.member.MemberVO;
import dev.mvc.tool.Tool;
import dev.mvc.tool.Upload;

@Controller
public class FollowCont {
 
  @Autowired
  @Qualifier("dev.mvc.member.MemberProc")
  private MemberProcInter memberProc;
  
  @Autowired
  @Qualifier("dev.mvc.follow.FollowProc")
  private FollowProcInter followProc;
  
  

  public FollowCont() {
    System.out.println("--> Followcont created");
}
  /**
  * ��� ��
  * @return
  */
  @RequestMapping(value="/follow/create.do", method=RequestMethod.GET )
  public ModelAndView create( @RequestParam(value="memberno", defaultValue="") int memberno ,
      @RequestParam(value="follower", defaultValue="") int follower){
    ModelAndView mav = new ModelAndView();    
    mav.addObject("follower" , follower);
    mav.addObject("memberno" , memberno);
    
    mav.setViewName("/follow/create"); // webapp/member/create.jsp
    return mav; // forward
  }
  
  /**
   * ���ó��
   * http://localhost:9090/resort/cate/create.do
   * 
   * @return
   */
  @RequestMapping(value = "/follow/create.do", method = RequestMethod.POST)
  public ModelAndView create_proc( FollowVO followVO ) {
    ModelAndView mav = new ModelAndView();
    

    // System.out.println("--> categrpno: " + cateVO.getCategrpno());
    int cnt = this.followProc.create( followVO);
    mav.addObject("cnt", cnt);
    
    mav.addObject("url", "create_continue"); // create_continue.jsp, redirect parameter ����
    mav.setViewName("redirect:/follow/msg.do"); 
    

    return mav;
  }
  
  /**
   * ���ΰ�ħ�� �����ϴ� �޽��� ���
   * @return
   */
  @RequestMapping(value="/follow/msg.do", method=RequestMethod.GET)
  public ModelAndView msg(String url){
    ModelAndView mav = new ModelAndView();
    
    // ��� ó�� �޽���: create_msg --> /contents/create_msg.jsp
    // ���� ó�� �޽���: update_msg --> /contents/update_msg.jsp
    // ���� ó�� �޽���: delete_msg --> /contents/delete_msg.jsp
    mav.setViewName("/follow/" + url); // forward
    
    return mav; // forward
  }
 
  /**
   * ȸ�� ��ȸ
   * @param memberno
   * @return
   */
  @RequestMapping(value="/follow/read.do", method=RequestMethod.GET)
  public ModelAndView read( 
      @RequestParam(value="follower", defaultValue="") int follower,
      @RequestParam(value="memberno", defaultValue="") int memberno){
    ModelAndView mav = new ModelAndView();
    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("follower" , follower);
    map.put("memberno" , memberno);
    
    List<FollowVO> list = this.followProc.read(map);
    mav.addObject("list", list);
    mav.setViewName("/follow/read"); // webapp/member/read.jsp
    
    return mav; // forward
  }
  
  /**
   * ȸ�� ����
   * @param memberno
   * @return
   */
  @RequestMapping(value="/follow/delete.do", method=RequestMethod.GET)
  public ModelAndView delete_form(@RequestParam(value="followno", defaultValue="") int followno){
    ModelAndView mav = new ModelAndView();
    mav.addObject("followno" , followno);
    System.out.println(followno);

    mav.setViewName("/follow/delete"); // webapp/member/delete.jsp
    
    return mav; // forward
  }
 
  @RequestMapping(value="/follow/delete.do", method=RequestMethod.POST)
  public ModelAndView delete(int followno){
    ModelAndView mav = new ModelAndView();
    System.out.println(followno);
   int cnt = followProc.delete(followno);
    mav.addObject("cnt", cnt);
    mav.addObject("url", "delete_msg");
    
    mav.setViewName("redirect:/follow/msg.do");
    
    return mav;
  }
  
}
  


