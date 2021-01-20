package dev.mvc.genre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.home.HomeProcInter;
import dev.mvc.home.HomeVO;





@Controller
public class GenreCont {
  @Autowired
  @Qualifier("dev.mvc.genre.GenreProc")
  private GenreProcInter genreProc;

  @Autowired
  @Qualifier("dev.mvc.home.HomeProc")
  private HomeProcInter homeProc;
  public GenreCont() {
    System.out.println("--> genreCont created.");
  }

  /**
   * 등록폼 http://localhost:9090/team1/genre/create.do
   * 
   * @return
   */
  @RequestMapping(value = "/genre/create.do", method = RequestMethod.GET)
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/genre/create"); // /webapp/genre/create.jsp
    return mav; // forward
  }

  /**
   * 등록 처리 http://localhost:9090/resort/categrp/create.do
   * 
   * @return
   */
  @RequestMapping(value = "/genre/create.do", method = RequestMethod.POST)
  public ModelAndView create(GenreVO genreVO) {
    // request.setAttribute("genreVO", genreVO) 자동 실행

    ModelAndView mav = new ModelAndView();
    mav.setViewName("/genre/create_msg"); // /webapp/categrp/create_msg.jsp

    int cnt = this.genreProc.create(genreVO); // 등록 처리
    mav.addObject("cnt", cnt); // request.setAttribute("cnt", cnt)

    return mav; // forward
  }

  /**
   * 목록 http://localhost:9090/team1/genre/list.do
   * 
   * @return
   */
  @RequestMapping(value = "/genre/list_all.do", method = RequestMethod.GET)
  public ModelAndView list_all() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/genre/list_all"); // /webapp/genre/list.jsp

    List<GenreVO> list = this.genreProc.list_genreno_asc();
    mav.addObject("list", list);

    return mav; // forward
  }
  /**
   * 목록 http://localhost:9090/resort/cate/list.do
   * 
   * @return
   */
  @RequestMapping(value = "/genre/list.do", method = RequestMethod.GET)
  public ModelAndView list(int homeno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/genre/list"); // /webapp/cate/list.jsp
 
    HomeVO homeVO = this.homeProc.read(homeno);
    mav.addObject("homeVO",homeVO);
    
    // List<CateVO> list = this.cateProc.list_cateno_asc();
    List<GenreVO> list = this.genreProc.list_by_homeno(homeno);
    mav.addObject("list", list);

    return mav; // forward
  }
  
  
  /**
   * 조회 + 수정폼 http://localhost:9090/team1/genre/read_update.do
   * 
   * @return
   */
  @RequestMapping(value = "/genre/read_update.do", method = RequestMethod.GET)
  public ModelAndView read_update(String genrename, int homeno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/genre/read_update"); // /webapp/genre/read_update.jsp

    GenreVO genreVO = this.genreProc.read(genrename);
    mav.addObject("genreVO", genreVO);

    List<GenreVO> list = this.genreProc.list_by_homeno(homeno);
    mav.addObject("list", list);

    return mav; // forward
  }
  /**
   * 수정 처리
   * 
   * @param genreVO
   * @return
   */
  @RequestMapping(value = "/genre/update.do", method = RequestMethod.POST)
  public ModelAndView update(GenreVO genreVO) {

    ModelAndView mav = new ModelAndView();

    int cnt = this.genreProc.update(genreVO);
    mav.addObject("cnt", cnt); // request에 저장

    mav.setViewName("/genre/update_msg"); // webapp/genre/update_msg.jsp

    return mav;
  }
  /**
   * 삭제폼 http://localhost:9090/resort/genre/read_delete.do
   * @return
   */
  @RequestMapping(value = "/genre/read_delete.do", method = RequestMethod.GET)
  public ModelAndView read_delete(String genrename,int homeno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/genre/read_delete"); // /webapp/genre/read_delete.jsp

    GenreVO genreVO = this.genreProc.read(genrename);
    mav.addObject("genreVO", genreVO);

    List<GenreVO> list = this.genreProc.list_by_homeno(homeno);
    mav.addObject("list", list);
    
  
    return mav; // forward
  }
  /**
   * 삭제 처리
   * @param genreno
   * @return
   */
  @RequestMapping(value = "/genre/delete.do", method = RequestMethod.POST)
  public ModelAndView delete(int genreno) {
    ModelAndView mav = new ModelAndView();

    int cnt = this.genreProc.delete(genreno);
    mav.addObject("cnt", cnt); // request에 저장

    mav.setViewName("/genre/delete_msg"); // /webapp/genre/delete_msg.jsp

    return mav;
  }
//http://localhost:9090/resort/cate/list_join.do
 /**
  * categrp + cate join 전체 목록
  * @return
  */
 @RequestMapping(value="/genre/list_join.do", method=RequestMethod.GET )
 public ModelAndView list_join() {
   ModelAndView mav = new ModelAndView();
   
   List<Home_Genre_join> list = this.genreProc.list_join();
   mav.addObject("list", list); // request.setAttribute("list", list);

   mav.setViewName("/genre/list_join"); // webapp/cate/list_join.jsp
   return mav;
 }
 

}

