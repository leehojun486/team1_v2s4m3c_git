package dev.mvc.playlist;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.member.MemberProcInter;
import dev.mvc.music_playlist.Music_PlaylistProcInter;
import dev.mvc.music_playlist.Music_PlaylistVO;


@Controller
public class PlaylistCont {
  @Autowired
  @Qualifier("dev.mvc.member.MemberProc")
  private MemberProcInter memberProc;
  @Autowired
  @Qualifier("dev.mvc.playlist.PlaylistProc")
  private PlaylistProcInter playlistProc;
  @Autowired
  @Qualifier("dev.mvc.music_playlist.Music_PlaylistProc")
  private Music_PlaylistProcInter music_playlistProc;

  public PlaylistCont() {
    System.out.println("--> PlaylistCont created.");
  }

  /**
   * 등록폼 http://localhost:9090/team1/playlist/create.do
   * 
   * @return
   */
  @RequestMapping(value = "/playlist/create.do", method = RequestMethod.GET)
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/playlist/create"); // /webapp/playlist/create.jsp
    return mav; // forward
  }

  /**
   * 등록 처리 http://localhost:9090/resort/playlist/create.do
   * 
   * @return
   */
  @RequestMapping(value = "/playlist/create.do", method = RequestMethod.POST)
  public ModelAndView create(PlaylistVO playlistVO) {
    // request.setAttribute("playlistVO", playlistVO) 자동 실행

    ModelAndView mav = new ModelAndView();
    mav.setViewName("/playlist/create_msg"); // /webapp/categrp/create_msg.jsp

    int cnt = this.playlistProc.create(playlistVO); // 등록 처리
    mav.addObject("cnt", cnt); // request.setAttribute("cnt", cnt)

    return mav; // forward
  }

  /**
   * 목록 http://localhost:9090/team1/playlist/list.do
   * 
   * @return
   */
  @RequestMapping(value = "/playlist/list.do", method = RequestMethod.GET)
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView();
    
    mav.setViewName("/playlist/list"); // /webapp/playlist/list.jsp
    List<PlaylistVO> list = this.playlistProc.list_playlistno_asc();
    mav.addObject("list", list);
    return mav; // forward
  }
  
  /**
   * 조회 + 수정폼 http://localhost:9090/team1/playlist/read_update.do
   * 
   * @return
   */
  @RequestMapping(value = "/playlist/read_update.do", method = RequestMethod.GET)
  public ModelAndView read_update(int playlistno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/playlist/read_update"); // /webapp/playlist/read_update.jsp
    
    PlaylistVO playlistVO = this.playlistProc.read(playlistno);
    mav.addObject("playlistVO", playlistVO);

    List<PlaylistVO> list = this.playlistProc.list_playlistno_asc();
    mav.addObject("list", list);

    return mav; // forward
  }
  
  /**
   * 회원별 조회 수정폼
   * 
   * @return
   */
  @RequestMapping(value = "/playlist/user_read_update.do", method = RequestMethod.GET)
  public ModelAndView user_read_update(int playlistno, int memberno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/playlist/user_read_update"); // /webapp/playlist/read_update.jsp
    
    PlaylistVO playlistVO = this.playlistProc.read(playlistno);
    mav.addObject("playlistVO", playlistVO);

    List<PlaylistVO> list = this.playlistProc.read_by_memberno(memberno);
    mav.addObject("list", list);

    return mav; // forward
  }
  
  /**
   * 회원별 플레이리스트
   * 
   * @return
   */
  @RequestMapping(value = "/playlist/read_by_memberno.do", method = RequestMethod.GET)
  public ModelAndView read_by_memberno(int memberno) {
    List<PlaylistVO> list = this.playlistProc.read_by_memberno(memberno);
    
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/playlist/read_by_memberno"); // /webapp/playlist/read_update.jsp
    mav.addObject("memberno", memberno);
    mav.addObject("list", list);

    return mav; // forward
  }
  
  /**
   * 수정 처리
   * 
   * @param playlistVO
   * @return
   */
  @RequestMapping(value = "/playlist/update.do", method = RequestMethod.POST)
  public ModelAndView update(PlaylistVO playlistVO) {

    ModelAndView mav = new ModelAndView();

    int cnt = this.playlistProc.update(playlistVO);
    mav.addObject("cnt", cnt); // request에 저장

    mav.setViewName("/playlist/update_msg"); // webapp/playlist/update_msg.jsp

    return mav;
  }
  
  /**
   * 회원 수정 처리
   * 
   * @param playlistVO
   * @return
   */
  @RequestMapping(value = "/playlist/user_update.do", method = RequestMethod.POST)
  public ModelAndView user_update(PlaylistVO playlistVO) {

    ModelAndView mav = new ModelAndView();

    int cnt = this.playlistProc.user_update(playlistVO);
    mav.addObject("cnt", cnt); // request에 저장
    mav.setViewName("/playlist/user_update_msg"); // webapp/playlist/update_msg.jsp
    System.out.println("----------------");

    return mav;
  }
  
  /**
   * 삭제폼 http://localhost:9090/resort/playlist/read_delete.do
   * @return
   */
  @RequestMapping(value = "/playlist/read_delete.do", method = RequestMethod.GET)
  public ModelAndView read_delete(int playlistno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/playlist/read_delete"); // /webapp/playlist/read_delete.jsp

    PlaylistVO playlistVO = this.playlistProc.read(playlistno);
    mav.addObject("playlistVO", playlistVO);

    List<PlaylistVO> list = this.playlistProc.list_playlistno_asc();
    mav.addObject("list", list);

    return mav; // forward
  }
  
  /**
   * 회원 삭제폼 http://localhost:9090/resort/playlist/read_delete.do
   * @return
   */
  @RequestMapping(value = "/playlist/user_read_delete.do", method = RequestMethod.GET)
  public ModelAndView user_read_delete(int playlistno, int memberno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/playlist/user_read_delete"); // /webapp/playlist/read_delete.jsp

    PlaylistVO playlistVO = this.playlistProc.read(playlistno);
    mav.addObject("playlistVO", playlistVO);

    List<PlaylistVO> list = this.playlistProc.read_by_memberno(memberno);
    mav.addObject("list", list);

    return mav; // forward
  }
  /**
   * 삭제 처리
   * @param playlistno
   * @return
   */
  @RequestMapping(value = "/playlist/user_delete.do", method = RequestMethod.POST)
  public ModelAndView delete(int playlistno, int memberno) {
    ModelAndView mav = new ModelAndView();
    
    HashMap<String, Object> hashMap = new HashMap<String, Object>();
    hashMap.put("playlistno", playlistno);
    hashMap.put("memberno", memberno);
    mav.addObject("memberno", memberno);
    int cnt = this.playlistProc.user_delete(hashMap);
    System.out.println("회원삭제 되는중");
    mav.addObject("cnt", cnt); // request에 저장

    mav.setViewName("/playlist/user_delete_msg"); // /webapp/playlist/delete_msg.jsp

    return mav;
  }
  
  /**
   * 삭제 처리
   * @param playlistno
   * @return
   */
  @RequestMapping(value = "/playlist/delete.do", method = RequestMethod.POST)
  public ModelAndView delete(int playlistno) {
    ModelAndView mav = new ModelAndView();

    int cnt = this.playlistProc.delete(playlistno);
    mav.addObject("cnt", cnt); // request에 저장

    mav.setViewName("/playlist/delete_msg"); // /webapp/playlist/delete_msg.jsp

    return mav;
  }
  /**
   * 좋아요 증가
   * @param playlistno
   * @return
   */
  @RequestMapping(value = "/playlist/likes_up.do", method = RequestMethod.GET)
  public ModelAndView likes_up(int playlistno) {
    ModelAndView mav = new ModelAndView();
    PlaylistVO playlistVO = this.playlistProc.read(playlistno);
    int memberno = playlistVO.getmemberno();
    int cnt = this.playlistProc.likes_up(playlistno);
    System.out.println("cnt: "+ cnt );
    mav.addObject("cnt", cnt); // request에 저장
    mav.addObject("playlistVO", playlistVO);
    mav.setViewName("redirect:/playlist/read_by_memberno.do?memberno="+memberno+""); // webapp/playlist/update_msg.jsp
    
    
    
    
    /*
     * int cnt = this.cateProc.update_seqno_down(cateno); mav.addObject("cnt", cnt);
     * // request에 저장
     * 
     * CateVO cateVO = this.cateProc.read(cateno); mav.addObject("cateVO", cateVO);
     * 
     * mav.setViewName("redirect:/cate/list.do?categrpno="+cateVO.getCategrpno());
     */
    

    return mav;
  }
  
}

