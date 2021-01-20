package dev.mvc.singer_review;

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
public class Singer_reviewCont {
  @Autowired
  @Qualifier("dev.mvc.singer_review.Singer_reviewProc")
  private Singer_reviewProcInter singer_reviewProc;
  
  public Singer_reviewCont() {
    System.out.println("--> Singer_reviewCont created.");
  }
  
  /**
   * 등록폼
   * http://localhost:9090/team1/singer_review/create.do
   * @return
   */
  @RequestMapping(value="/singer_review/create.do", method=RequestMethod.GET)
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/singer_review/create");
    
    return mav;
  }
  
  /**
   * 등록폼
   * http://localhost:9090/resort/singer_review/create.do
   * @return
   */
  @RequestMapping(value="/singer_review/create.do", method=RequestMethod.POST)
  public ModelAndView create(Singer_reviewVO singer_reviewVO) {
    ModelAndView mav = new ModelAndView();

    int cnt = this.singer_reviewProc.create(singer_reviewVO);
    mav.setViewName("redirect:/singer/read.do?singerno="+singer_reviewVO.getSingerno());
    mav.addObject("cnt", cnt);
    
    return mav;
  }
  
  /**
   * 조회
   * http://localhost:9090/team1/review/read.do
   * @return
   */
  @RequestMapping(value="/singer_review/read.do", method=RequestMethod.GET)
  public ModelAndView read(int reviewno) {
    
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/singer_review/read"); // /webapp/review/read.jsp
    
    Singer_reviewVO singer_reviewVO = this.singer_reviewProc.read(reviewno);
    mav.addObject("singer_reviewVO", singer_reviewVO);

    return mav;
  }
  
  /**
   * 수정 폼
   * @return
   */
  @RequestMapping(value="/singer_review/update.do", method=RequestMethod.GET )
  public ModelAndView update(int reviewno) {
    ModelAndView mav = new ModelAndView();
    
    Singer_reviewVO singer_reviewVO = this.singer_reviewProc.read(reviewno); // 수정용 읽기
    mav.addObject("singer_reviewVO", singer_reviewVO); // request.setAttribute("contentsVO", contentsVO);
    
    List<Singer_reviewVO> list = this.singer_reviewProc.list_date_asc();
    mav.addObject("list", list);
    
    mav.setViewName("/singer_review/update"); // webapp/contents/update.jsp
    
    return mav;
  }
  
  // http://localhost:9090/resort/contents/update.do
  /**
   * 수정 처리
   * @param singer_reviewVO
   * @return
   */
  @RequestMapping(value="/singer_review/update.do", method=RequestMethod.POST )
  public ModelAndView update(Singer_reviewVO singer_reviewVO) {
    ModelAndView mav = new ModelAndView();

    mav.addObject("reviewno", singer_reviewVO.getReviewno());
    
    int cnt = 0;             // 수정된 레코드 갯수 
    cnt = this.singer_reviewProc.update(singer_reviewVO);

    mav.addObject("cnt", cnt); // request에 저장
    
    System.out.println("cnt : " + cnt);
        
    if (cnt == 1) {
      // mav.setViewName("redirect:/contents/update_msg.jsp"); // webapp/contents/update_msg.jsp
      mav.setViewName("redirect:/singer/read.do?singerno="+singer_reviewVO.getSingerno());
      // mav.setViewName("redirect:/contents/list.do"); // spring 재호출
    } else { 
      mav.setViewName("redirect:/singer/read.do?singerno="+singer_reviewVO.getSingerno());
    }
    
    return mav;
  }
  
 /**
  * 삭제 처리
  * @param singer_reviewVO
  * @return
  */
 @RequestMapping(value="/singer_review/delete.do", method=RequestMethod.GET )
 public ModelAndView delete(int reviewno) {
   ModelAndView mav = new ModelAndView();

   mav.addObject("reviewno", reviewno);
   Singer_reviewVO singer_reviewVO = this.singer_reviewProc.read(reviewno);

   int cnt = 0;             // 수정된 레코드 갯수   
   cnt = this.singer_reviewProc.delete(reviewno);

   mav.addObject("cnt", cnt); // request에 저장
   
   System.out.println("cnt : " + cnt);
       
   mav.setViewName("redirect:/singer/read.do?singerno="+singer_reviewVO.getSingerno());
   
   return mav;
 }
  
 /**
  * 좋아요 상향 up 10 ▷ 1
  * @param reviewno 조회할 카테고리 번호
  * @return
  */
 @ResponseBody
 @RequestMapping(value="/singer_review/update_reviewrec_up.do",  method=RequestMethod.GET ,
                               produces = "text/plain;charset=UTF-8")
 public String update_reviewrec_up(int reviewno) {
   int cnt = this.singer_reviewProc.update_reviewrec_up(reviewno);

   JSONObject json = new JSONObject();
   json.put("cnt", cnt);
 
   return json.toString(); 
 }
 
 /**
  * 좋아요 하향 up 10 ▷ 1
  * @param reviewno 조회할 카테고리 번호
  * @return
  */
 @RequestMapping(value="/singer_review/update_reviewrec_down.do",  method=RequestMethod.GET )
 public ModelAndView update_reviewrec_down(int reviewno) {
   ModelAndView mav = new ModelAndView();
   
   int cnt = this.singer_reviewProc.update_reviewrec_down(reviewno);
   mav.addObject("cnt", cnt); // request에 저장
   
   Singer_reviewVO singer_reviewVO = this.singer_reviewProc.read(reviewno);
   mav.addObject("singer_reviewVO", singer_reviewVO);
   
   mav.setViewName("redirect:/singer/read.do?singerno="+singer_reviewVO.getSingerno());
   
   return mav;
 }
  
  
  /**
   * 새로고침을 방지하는 메시지 출력
   * 
   * @param 
   * @return
   */
  @RequestMapping(value = "/singer_review/msg.do", method = RequestMethod.GET)
  public ModelAndView msg(String url) {
    ModelAndView mav = new ModelAndView();

    // 등록 처리 메시지: create_msg --> /contents/create_msg.jsp
    // 수정 처리 메시지: update_msg --> /contents/update_msg.jsp
    // 삭제 처리 메시지: delete_msg --> /contents/delete_msg.jsp
    mav.setViewName("/singer_review/" + url); // forward

    return mav; // forward
  }
  
}
