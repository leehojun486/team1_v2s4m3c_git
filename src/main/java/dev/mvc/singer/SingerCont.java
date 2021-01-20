package dev.mvc.singer;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.music.MusicProcInter;
import dev.mvc.music.MusicVO;

@Controller
public class SingerCont {

  @Autowired
  @Qualifier("dev.mvc.music.MusicProc")
  private MusicProcInter musicProc;
  
  @Autowired
  @Qualifier("dev.mvc.singer.SingerProc")
  private SingerProcInter singerProc;
  
  public SingerCont() {
    System.out.println("--team1> SingerCont Created !");
  }
  
  /**
   * 등록폼     ::  http://localhost:9090/team1/singer/create.do
   * 
   * @param singerVO
   * @return
   */
  @RequestMapping(value = "/singer/create.do", method = RequestMethod.GET)
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/singer/create"); // /webapp/singer/create.jsp
    
    return mav;
  }
  
   /**
    * 등록처리     :: http://localhost:9090/team1/singer/create.do
    * 
    * @return
    */
  @RequestMapping(value = "/singer/create.do", method = RequestMethod.POST)
  public ModelAndView create(SingerVO singerVO) {
    ModelAndView mav = new ModelAndView();
    
    int cnt = this.singerProc.create(singerVO);
    mav.addObject("cnt", cnt);// request.setAttribute("cnt", cnt)

    mav.setViewName("/singer/create_msg"); // /wepapp/singer/create_msg.jsp
    return mav;
  }
  
  /**
   * 목록      :: http://localhost:9090/team1/singer/list.do
   * 
   * @return
   */
  @RequestMapping(value = "/singer/list.do", method = RequestMethod.GET)
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/singer/list"); // /webapp/singer/list.jsp

    List<SingerVO> list = this.singerProc.list_singer();
    mav.addObject("list", list);

    return mav; // forward
  }
  
  /**
   * 조회       ::    http://localhost:9090/team1/singer/read.do
   * @param singerno
   * @return
   */
  @RequestMapping(value = "/singer/read.do", method = RequestMethod.GET)
  public ModelAndView read(int singerno) {
    ModelAndView mav = new ModelAndView();

    SingerVO singerVO = this.singerProc.read(singerno); 
    mav.addObject("singerVO", singerVO);
    
    List<MusicVO> list = this.musicProc.list_by_singerno(singerno);
    mav.addObject("list", list);
    
    mav.setViewName("/singer/read"); 
    return mav;
  }
  
  /**
   * 수정을 위한 조회     ::    http://localhost:9090/team1/singer/update.do
   * @param singerno
   * @return
   */
  @RequestMapping(value = "/singer/update.do", method=RequestMethod.GET)
  public ModelAndView read_update(int singerno) {
    ModelAndView mav = new ModelAndView();
    
    SingerVO singerVO = this.singerProc.read_update(singerno);
    mav.addObject("singerVO", singerVO);
    
    mav.setViewName("/singer/update");
    
    return mav;
  }
  
  /**
   * 수정 처리         ::         http://localhost:9090/resort/singer/update.do
   * @param singerVO
   * @return
   */
  @RequestMapping(value = "/singer/update.do", method = RequestMethod.POST)
  public ModelAndView update(SingerVO singerVO) {
    ModelAndView mav = new ModelAndView();

    mav.addObject("singerno", singerVO.getSingerno());

    int cnt = this.singerProc.update(singerVO);
    mav.addObject("cnt", cnt); // request에 저장

    if (cnt == 1) {
      mav.setViewName("/singer/update_msg"); // webapp/singer/update_msg.jsp
    } else {
      mav.setViewName("/singer/update_msg"); // webapp/singer/update_msg.jsp
    }

    return mav;
  }
  
  /**
   * 삭제 폼      ::         http://localhost:9090/team1/singer/delete.do
   * @param singerno
   * @return
   */
  @RequestMapping(value ="/singer/delete.do", method = RequestMethod.GET)
  public ModelAndView read_delete(int singerno) {
    ModelAndView mav = new ModelAndView();
    
    SingerVO singerVO = this.singerProc.read_update(singerno);
    mav.addObject("singerVO", singerVO);
    
    mav.setViewName("/singer/delete");
    
    return mav;
  }
  
  /**
   * 삭제 처리         ::         http://localhost:9090/resort/singer/delete.do
   * @param singerVO
   * @return
   */
  @RequestMapping(value = "/singer/delete.do", method = RequestMethod.POST)
  public ModelAndView delete(SingerVO singerVO) {
    ModelAndView mav = new ModelAndView();
    int singerno = singerVO.getSingerno();
    
    String singer = this.singerProc.read(singerno).getSinger();
    
    mav.addObject("singerno", singerVO.getSingerno());

    int cnt = this.singerProc.delete(singerno);
    
    mav.addObject("cnt", cnt); // request에 저장
    mav.addObject("singer", singer);
    
    if (cnt == 1) {
      mav.setViewName("/singer/delete_msg"); // webapp/singer/delete_msg.jsp
    } else {
      mav.setViewName("/singer/delete_msg"); // webapp/singer/delete_msg.jsp
    }

    return mav;
  }
  
}
