package dev.mvc.chart_crawling;

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
public class Chart_crawlingCont {
 
  
  @Autowired
  @Qualifier("dev.mvc.chart_crawling.Chart_crawlingProc")
  private Chart_crawlingProcInter chart_crawlingProc;
  
  

  public Chart_crawlingCont() {
    System.out.println("--> Followcont created");
}
  /**
   * 차튼 조회
   * @return
   */
  @RequestMapping(value="/chart/list.do", method=RequestMethod.GET)
  public ModelAndView list(){
    ModelAndView mav = new ModelAndView();
    
    List<Chart_crawlingVO> list = this.chart_crawlingProc.list();    
    mav.addObject("list", list);
    mav.setViewName("/chart/list"); // webapp/member/list.jsp
 
    return mav; // forward
  }
  
}
  


