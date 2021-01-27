package dev.mvc.genre;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GenreCont {
  
  @Autowired
  @Qualifier("dev.mvc.genre.GenreProc")
  private GenreProcInter genreProc;
    
  public GenreCont() {
    System.out.println("--team1> GenreCont Created !");
  }
  /*      ---------------------------------------------        */
  
  /**
   * 생성    ::   http://localhost:9090/team1/genre/create.do
   * @param genreVO
   * @return
   */
  @RequestMapping(value = "/genre/create.do", method = RequestMethod.GET)
  public ModelAndView create(GenreVO genreVO) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/genre/create");
    
    return mav;
  }
  
  /**
   * 등록처리     :: http://localhost:9090/team1/genre/create.do
   * @param request
   * @param genreVO
   * @return
   */
 @RequestMapping(value = "/genre/create.do", method = RequestMethod.POST)
 public ModelAndView create(HttpServletRequest request,GenreVO genreVO) {
   ModelAndView mav = new ModelAndView();
   mav.setViewName("/genre/create_msg"); // /wepapp/genre/create_msg.jsp

   int cnt = this.genreProc.create(genreVO);
   mav.addObject("cnt", cnt);// request.setAttribute("cnt", cnt)

   return mav;
 }
 
   /**
    * 등록처리 _Ajax    :: http://localhost:9090/team1/genre/create.do
    * @param request
    * @param genreVO
    * @return
    */
  @ResponseBody
  @RequestMapping(value = "/genre/create_ajax.do", method = RequestMethod.POST,
                  produces = "text/plain;charset=UTF-8")
  public String create_ajax(GenreVO genreVO) {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    int cnt = this.genreProc.create(genreVO); // 등록 처리
    
    JSONObject json = new JSONObject();
    json.put("cnt", cnt);
  
    return json.toString();
  } 
  
//    /**
//     * 목록    ::    http://localhost:9090/team1/genre/list.do
//     * @return
//     */
//   @RequestMapping(value = "/genre/list.do", method=RequestMethod.GET)
//    public ModelAndView list() {
//      ModelAndView mav = new ModelAndView();
//      mav.setViewName("genre/list");
//      
//      List<GenreVO> list = this.genreProc.list();
//      mav.addObject("list", list);
//      
//      return mav;
//    }
 
   /**
    * 목록_Ajax    ::    http://localhost:9090/team1/genre/list_ajax.do
    * @return
    */
  @RequestMapping(value = "/genre/list.do", method=RequestMethod.GET)
   public ModelAndView list() {
     ModelAndView mav = new ModelAndView();
     mav.setViewName("genre/list_ajax");
     
     List<GenreVO> list = this.genreProc.list();
     mav.addObject("list", list);
     
     return mav;
   }
 
//   /**
//    * 조회 ::
//    * http://localhost:9090/team1/read.do
//    * @param genreno
//    * @return
//    */
//   @RequestMapping(value = "/genre/read.do", method = RequestMethod.GET)
//    public ModelAndView read(int genreno) {
//      ModelAndView mav = new ModelAndView();
//      mav.setViewName("/genre/read"); // :: /webapp/genre/read.jsp 
//      
//      GenreVO genreVO = this.genreProc.read(genreno);
//      mav.addObject("genreVO", genreVO);
//      return mav;
//    }
 
 /**
  * 조회_ajax ::
  * http://localhost:9090/team1/read_ajax.do
  * @param genreno
  * @return
  */
  @ResponseBody
  @RequestMapping(value = "/genre/read_ajax.do", method = RequestMethod.GET,
                  produces = "text/plain;charset=UTF-8")
  public String read_ajax(int genreno) {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    GenreVO genreVO = this.genreProc.read(genreno);
    
    JSONObject json = new JSONObject();
    json.put("genreno", genreno);
    json.put("genrename", genreVO.getGenrename());
    
    return json.toString();
  }
  
  /**
   * Ajax 기반 등록 처리 http://localhost:9090/resort/genre/update_ajax.do
   * 
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/genre/update_ajax.do", method = RequestMethod.POST,
                          produces = "text/plain;charset=UTF-8")
  public String update_ajax(GenreVO genreVO) {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    int cnt = this.genreProc.update(genreVO); // 등록 처리
    
    JSONObject json = new JSONObject();
    json.put("cnt", cnt);

    return json.toString();
  }
  
  /**
   * 삭제처리_Ajax
   * @param genreno
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/genre/delete_ajax.do", method = RequestMethod.POST,
                          produces = "text/plain;charset=UTF-8")
  public String delete_ajax(int genreno) {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    int cnt = this.genreProc.delete(genreno);
    
    JSONObject json = new JSONObject();
    json.put("cnt", cnt);
    
    return json.toString();
  }
  
}
