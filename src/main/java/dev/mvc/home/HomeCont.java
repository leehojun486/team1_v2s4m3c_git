package dev.mvc.home;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeCont {
  @Autowired
  @Qualifier("dev.mvc.home.HomeProc")
  private HomeProcInter homeProc;

  public HomeCont() {
    System.out.println("--> homeCont created.");
  }

  /**
   * 등록폼 
   * 
   * @return
   */
  @RequestMapping(value = "/home/create.do", method = RequestMethod.GET)
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/home/create"); 
    return mav; // forward
  }

  
  /**
   * 등록 처리 http://localhost:9090/resort/categrp/create.do
   * 
   * @return
   */
  @RequestMapping(value = "/home/create.do", method = RequestMethod.POST)
  public ModelAndView create(HomeVO homeVO) {


    ModelAndView mav = new ModelAndView();

    int cnt = this.homeProc.create(homeVO); // 등록 처리
    
    if (cnt == 0) {
      mav.addObject("cnt", cnt); 

      mav.addObject("url", "create_msg"); 
      mav.setViewName("redirect:/home/msg.do"); 
      
    } else {
      mav.setViewName("redirect:/home/list.do");
    }
    
    return mav;
  }
  
  /**
   * 등록 처리 http://localhost:9090/resort/categrp/create.do
   * 
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/home/create_ajax.do", method = RequestMethod.POST,
                          produces = "text/plain;charset=UTF-8")
  public String create_ajax(HomeVO homeVO) {

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    int cnt = this.homeProc.create(homeVO); // 등록 처리
    
    JSONObject json = new JSONObject();
    json.put("cnt", cnt);

    return json.toString();
  }


  /**
   * 목록 http://localhost:9090/team1/home/list.do
   * 
   * @return
   */
  @RequestMapping(value = "/home/list.do", method = RequestMethod.GET)
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/home/list_ajax"); 

    List<HomeVO> list = this.homeProc.list_seqno_asc();
    mav.addObject("list", list);

    return mav; 
  }
  
  /**
   * 조회 + 수정폼 http://localhost:9090/team1/home/read_update.do
   * 
   * @return
   */
  @RequestMapping(value = "/home/read_update.do", method = RequestMethod.GET)
  public ModelAndView read_update(int homeno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/home/read_update"); 

    HomeVO homeVO = this.homeProc.read(homeno);
    mav.addObject("homeVO", homeVO);

    List<HomeVO> list = this.homeProc.list_seqno_asc();
    mav.addObject("list", list);

    return mav; // forward
  }
  
  /**
   * Ajax + read http://localhost:9090/tema1/home/read_ajax.do
   * 
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/home/read_ajax.do", method = RequestMethod.GET,
                          produces = "text/plain;charset=UTF-8")
  public String read_ajax(int homeno) {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    HomeVO homeVO = this.homeProc.read(homeno);

    JSONObject json = new JSONObject();
    json.put("categrpno", homeno);
    json.put("name", homeVO.getName());
    json.put("seqno", homeVO.getSeqno());


    return json.toString();
  }
  /**
   * 수정 처리
   * 
   * @param homeVO
   * @return
   */
  @RequestMapping(value = "/home/update.do", method = RequestMethod.POST)
  public ModelAndView update(HomeVO homeVO) {

    ModelAndView mav = new ModelAndView();

    int cnt = this.homeProc.update(homeVO);
    mav.addObject("cnt", cnt);

    mav.setViewName("/home/update_msg"); 

    return mav;
  }
  
  /**
   * Ajax 기반 등록 처리 http://localhost:9090/team1/home/update_ajax.do
   * 
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/home/update_ajax.do", method = RequestMethod.POST,
                          produces = "text/plain;charset=UTF-8")
  public String update_ajax(HomeVO homeVO) {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    int cnt = this.homeProc.update(homeVO); // 등록 처리
    
    JSONObject json = new JSONObject();
    json.put("cnt", cnt);

    return json.toString();
  }

  /**
   * 삭제폼
   * @return
   */
  @RequestMapping(value = "/home/read_delete.do", method = RequestMethod.GET)
  public ModelAndView read_delete(int homeno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/home/read_delete"); 

    HomeVO homeVO = this.homeProc.read(homeno);
    mav.addObject("homeVO", homeVO);

    List<HomeVO> list = this.homeProc.list_seqno_asc();
    mav.addObject("list", list);
 
    return mav; // forward
  }
  /**
   * 삭제 처리
   * @param homeno
   * @return
   */
  @RequestMapping(value = "/home/delete.do", method = RequestMethod.POST)
  public ModelAndView delete(int homeno) {
    ModelAndView mav = new ModelAndView();

    int cnt = this.homeProc.delete(homeno);
    // mav.addObject("cnt", cnt); // request에 저장

    // mav.setViewName("/categrp/delete_msg"); // /webapp/categrp/delete_msg.jsp

    if (cnt == 0) {
      mav.addObject("cnt", cnt); // request.setAttribute("cnt", cnt)

      mav.addObject("url", "delete_msg"); // create_msg.jsp, redirect parameter 적용
      mav.setViewName("redirect:/home/msg.do"); 
      
    } else {
      mav.setViewName("redirect:/home/list.do");
    }
    
    return mav;
  }
  /**
   * 삭제 처리 + Ajax
   * @param homeno
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/home/delete_ajax.do", method = RequestMethod.POST,
                          produces = "text/plain;charset=UTF-8")
  public String delete_ajax(int homeno) {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    int cnt = this.homeProc.delete(homeno);
    
    JSONObject json = new JSONObject();
    json.put("cnt", cnt);
    
    return json.toString();
  }
}

