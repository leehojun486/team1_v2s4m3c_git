package dev.mvc.playlist;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.member.MemberProcInter;
import dev.mvc.music_playlist.Music_PlaylistProcInter;
import dev.mvc.music_playlist.Music_PlaylistVO;
import dev.mvc.tool.Tool;
import dev.mvc.tool.Upload;


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
   * 占쏙옙占쏙옙占� http://localhost:9090/team1/playlist/create.do
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
   * 占쏙옙占� 처占쏙옙 http://localhost:9090/resort/playlist/create.do
   * 
   * @return
   */
  @RequestMapping(value = "/playlist/create.do", method = RequestMethod.POST)
  public ModelAndView create(HttpServletRequest request, PlaylistVO playlistVO) {
    // request.setAttribute("playlistVO", playlistVO) 占쌘듸옙 占쏙옙占쏙옙

    ModelAndView mav = new ModelAndView();
    System.out.println(playlistVO.getFnamesMF());
    
 // -------------------------------------------------------------------
    // �뙆�씪 �쟾�넚 肄붾뱶 �떆�옉
    // -------------------------------------------------------------------
    String fname = "";     // main image
    String thumbnail = ""; // preview image
        
    String upDir = Tool.getRealPath(request, "/playlist/storage/main_images"); // �젅�� 寃쎈줈
    
    // �쟾�넚 �뙆�씪�씠 �뾾�뼱�꽌�룄 fnamesMF 媛앹껜媛� �깮�꽦�맖.
    // <input type='file' class="form-control" name='file1MF' id='file1MF' 
    //           value='' placeholder="�뙆�씪 �꽑�깮" multiple="multiple">
    MultipartFile mf = playlistVO.getFnamesMF();
    
    long fsize = mf.getSize();  // �뙆�씪 �겕湲�
    if (fsize > 0) { // �뙆�씪 �겕湲� 泥댄겕
      // mp3 = mf.getOriginalFilename(); // �썝蹂� �뙆�씪紐�, spring.jpg
      // �뙆�씪 ���옣 �썑 �뾽濡쒕뱶�맂 �뙆�씪紐낆씠 由ы꽩�맖, spring.jsp, spring_1.jpg...
      fname = Upload.saveFileSpring(mf, upDir); 
      
      if (Tool.isImage(fname)) { // �씠誘몄��씤吏� 寃��궗
        // thumb �씠誘몄� �깮�꽦�썑 �뙆�씪紐� 由ы꽩�맖, width: 200, height: 150
        thumbnail = Tool.preview(upDir, fname, 200, 150); 
      }
      
    }    
    playlistVO.setFname(fname);
    playlistVO.setThumbnail(thumbnail);
    playlistVO.setFsize(fsize);
    // -------------------------------------------------------------------
    // �뙆�씪 �쟾�넚 肄붾뱶 醫낅즺
    // -------------------------------------------------------------------
    mav.setViewName("/playlist/create_msg"); // /webapp/categrp/create_msg.jsp

    int cnt = this.playlistProc.create(playlistVO); // 占쏙옙占� 처占쏙옙
    mav.addObject("cnt", cnt); // request.setAttribute("cnt", cnt)
    System.out.println(fsize);
    System.out.println(fname);
    System.out.println(thumbnail);
    System.out.println(playlistVO.getPlaylistno());

    return mav; // forward
  }

  /**
   * 占쏙옙占� http://localhost:9090/team1/playlist/list.do
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
  
  @RequestMapping(value = "/playlist/member_playlist.do", method = RequestMethod.GET)
  public ModelAndView member_playlist(int memberno) {
    ModelAndView mav = new ModelAndView();
    
    mav.setViewName("/playlist/member_playlist"); // /webapp/playlist/list.jsp
    List<PlaylistVO> list = this.playlistProc.read_by_memberno(memberno);
    mav.addObject("list", list);
    return mav; // forward
  }
  
  /**
   * 占쏙옙회 + 占쏙옙占쏙옙占쏙옙 http://localhost:9090/team1/playlist/read_update.do
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
   * 회占쏙옙占쏙옙 占쏙옙회 占쏙옙占쏙옙占쏙옙
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
   * 회占쏙옙占쏙옙 占시뤄옙占싱몌옙占쏙옙트
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
   * 占쏙옙占쏙옙 처占쏙옙
   * 
   * @param playlistVO
   * @return
   */
  @RequestMapping(value = "/playlist/update.do", method = RequestMethod.POST)
  public ModelAndView update(PlaylistVO playlistVO) {

    ModelAndView mav = new ModelAndView();

    int cnt = this.playlistProc.update(playlistVO);
    mav.addObject("cnt", cnt); // request占쏙옙 占쏙옙占쏙옙

    mav.setViewName("/playlist/update_msg"); // webapp/playlist/update_msg.jsp

    return mav;
  }
  
  /**
   * 회占쏙옙 占쏙옙占쏙옙 처占쏙옙
   * 
   * @param playlistVO
   * @return
   */
  @RequestMapping(value = "/playlist/user_update.do", method = RequestMethod.POST)
  public ModelAndView user_update(PlaylistVO playlistVO) {

    ModelAndView mav = new ModelAndView();

    int cnt = this.playlistProc.user_update(playlistVO);
    mav.addObject("cnt", cnt); // request占쏙옙 占쏙옙占쏙옙
    mav.setViewName("/playlist/user_update_msg"); // webapp/playlist/update_msg.jsp
    System.out.println("----------------");

    return mav;
  }
  
  /**
   * 占쏙옙占쏙옙占쏙옙 http://localhost:9090/resort/playlist/read_delete.do
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
   * 회占쏙옙 占쏙옙占쏙옙占쏙옙 http://localhost:9090/resort/playlist/read_delete.do
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
   * 占쏙옙占쏙옙 처占쏙옙
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
    System.out.println("회占쏙옙占쏙옙占쏙옙 占실댐옙占쏙옙");
    mav.addObject("cnt", cnt); // request占쏙옙 占쏙옙占쏙옙

    mav.setViewName("/playlist/user_delete_msg"); // /webapp/playlist/delete_msg.jsp

    return mav;
  }
  
  /**
   * 占쏙옙占쏙옙 처占쏙옙
   * @param playlistno
   * @return
   */
  @RequestMapping(value = "/playlist/delete.do", method = RequestMethod.POST)
  public ModelAndView delete(int playlistno) {
    ModelAndView mav = new ModelAndView();

    int cnt = this.playlistProc.delete(playlistno);
    mav.addObject("cnt", cnt); // request占쏙옙 占쏙옙占쏙옙

    mav.setViewName("/playlist/delete_msg"); // /webapp/playlist/delete_msg.jsp

    return mav;
  }
  /**
   * 占쏙옙占싣울옙 占쏙옙占쏙옙
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
    mav.addObject("cnt", cnt); // request占쏙옙 占쏙옙占쏙옙
    mav.addObject("playlistVO", playlistVO);
    mav.setViewName("redirect:/playlist/read_by_memberno.do?memberno="+memberno+""); // webapp/playlist/update_msg.jsp
    
    
    
    
    /*
     * int cnt = this.cateProc.update_seqno_down(cateno); mav.addObject("cnt", cnt);
     * // request占쏙옙 占쏙옙占쏙옙
     * 
     * CateVO cateVO = this.cateProc.read(cateno); mav.addObject("cateVO", cateVO);
     * 
     * mav.setViewName("redirect:/cate/list.do?categrpno="+cateVO.getCategrpno());
     */
    

    return mav;
  }
  
}

