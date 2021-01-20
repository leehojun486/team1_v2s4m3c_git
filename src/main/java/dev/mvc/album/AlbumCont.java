package dev.mvc.album;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.genre.GenreProcInter;
import dev.mvc.genre.GenreVO;

@Controller
public class AlbumCont {
  
  @Autowired
  @Qualifier("dev.mvc.genre.GenreProc")
  private GenreProcInter genreProc;
  
  @Autowired
  @Qualifier("dev.mvc.album.AlbumProc")
  private AlbumProcInter albumProc;
    
  public AlbumCont() {
    System.out.println("--team1> AlbumCont Created !");
  }
  /*      ---------------------------------------------        */
  
  /**
   * 생성 ::
   * http://localhost:9090/team1/album/create.do
   * @param albumVO
   * @return
   */
  @RequestMapping(value = "/album/create.do", method = RequestMethod.GET)
  public ModelAndView create(AlbumVO albumVO) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/album/create");
    
    return mav;
  }
  
  /**
   * 생성 처리 ::
   * http://localhost:9090/team1/album/create.do
   * @param request
   * @param albumVO
   * @return
   */
  @RequestMapping(value = "/album/create.do", method = RequestMethod.POST)
  public ModelAndView create(HttpServletRequest request, AlbumVO albumVO) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/album/create_msg"); //  ::  /webapp/album/create_msg.jsp
    
    int cnt = this.albumProc.create(albumVO);
    mav.addObject("cnt", cnt);  //request.setAttribute("cnt", cnt);
    
    return mav;
  }
  
  /**
   * 목록 조회 ::
   * http://localhost:9090/team1/album/list.do
   * @return
   */
  @RequestMapping(value = "/album/list.do", method = RequestMethod.GET)
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/album/list"); //  ::  /webapp/album/list.jsp
    
    List<AlbumVO> list = this.albumProc.list();
    mav.addObject("list", list);
    
    return mav;
  }
  
  /**
   * 조회 ::
   * http://localhost:9090/team1/album/read.do
   * @param albumno
   * @return
   */
  @RequestMapping(value = "/album/read.do", method = RequestMethod.GET)
  public ModelAndView read(int albumno) {
    ModelAndView mav = new ModelAndView ();
    mav.setViewName("/album/read"); // :: /webapp/album/read.jsp
    
    AlbumVO albumVO = this.albumProc.read(albumno);
    mav.addObject("albumVO", albumVO);
    
    GenreVO genreVO = this.genreProc.read(albumno);
    mav.addObject("genreVO",  genreVO);
    return mav;
  }
  
}
