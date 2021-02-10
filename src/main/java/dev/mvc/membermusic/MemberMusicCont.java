package dev.mvc.membermusic;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.member.MemberProcInter;
import dev.mvc.member.MemberVO;
import dev.mvc.music.MusicProcInter;
import dev.mvc.music.MusicVO;
import dev.mvc.singer.SingerProcInter;

@Controller
public class MemberMusicCont {
  @Autowired
  @Qualifier("dev.mvc.membermusic.MemberMusicProc")
  private MemberMusicProcInter membermusicProc;

  @Autowired
  @Qualifier("dev.mvc.member.MemberProc")
  private MemberProcInter memberProc;
  
  @Autowired
  @Qualifier("dev.mvc.singer.SingerProc")
  private SingerProcInter singerProc;

  @Autowired
  @Qualifier("dev.mvc.music.MusicProc")
  private MusicProcInter musicProc;

  public MemberMusicCont() {
    System.out.println("--team1> MemberMusicCont created !");
  }
  /*--------------------------------*/

//  /**
//   * 등록 폼 :: http://localhost:9090/team1/membermusic/create.do
//   * 
//   * @return
//   */
//  @RequestMapping(value = "/membermusic/create.do", method = RequestMethod.GET)
//  public ModelAndView create() {
//    ModelAndView mav = new ModelAndView();
//    mav.setViewName("/membermusic/create"); // :: /webapp/membermusic/create.jsp
//
//    return mav;
//  }

//    /**
//     * 등록처리 :: http://localhost:9090/team1/membermusic/create.do
//     * 
//     * @param request
//     * @param memberVO
//     * @return
//     */
//    @RequestMapping(value = "/membermusic/create.do", method = RequestMethod.POST)
//    public ModelAndView create(MemberMusicVO membermusicVO) {
//      ModelAndView mav = new ModelAndView();
//      mav.setViewName("/membermusic/create_msg"); // :: /wepapp/membermusic/create_msg.jsp
//  
//      int cnt = this.membermusicProc.create(membermusicVO);
//      mav.addObject("cnt", cnt);// request.setAttribute("cnt", cnt)
//  
//      return mav;
//    }
  
  /**
   * 등록처리(좋아요리스트에 추가처리) :: http://localhost:9090/team1/membermusic/create.do
   * 
   * @param request
   * @param memberVO
   * @return
   */
  /*
   * @RequestMapping(value = "/membermusic/create.do", method = RequestMethod.GET)
   * public ModelAndView create(MemberMusicVO membermusicVO, MusicVO musicVO) {
   * ModelAndView mav = new ModelAndView();
   * 
   * if (musicVO.getLikelist().equalsIgnoreCase("N")) { musicVO.setLikelist("Y");
   * membermusicVO.setLikelist("Y"); } else {
   * 
   * }
   * 
   * int cnt = this.musicProc.add_likelist(musicVO); mav.addObject("cnt", cnt);//
   * request.setAttribute("cnt", cnt) cnt =
   * this.membermusicProc.create(membermusicVO); mav.addObject("cnt", cnt);
   * 
   * mav.setViewName("redirect:/music/add_likelist.do"); // request 객체가 전달이 안됨.
   * 
   * return mav; }
   */

  /**
   * 삭제처리 (좋아요취소시 컬럼 삭제)
   * @param membermusicno
   * @return
   */
  /*
   * @RequestMapping(value="/membermusic/delete.do", method=RequestMethod.GET)
   * public ModelAndView delete(MemberMusicVO membermusicVO, MusicVO musicVO) {
   * ModelAndView mav = new ModelAndView();
   * 
   * HashMap<String, Object> hashMap = new HashMap<String, Object>();
   * hashMap.put("musicno", musicVO.getMusicno()); hashMap.put("memberno",
   * membermusicVO.getMemberno());
   * 
   * if (musicVO.getLikelist().equalsIgnoreCase("Y")) { musicVO.setLikelist("N");
   * membermusicVO.setLikelist("N"); } else {
   * 
   * }
   * 
   * int cnt = this.musicProc.delete_likelist(musicVO); mav.addObject("cnt",
   * cnt);// request.setAttribute("cnt", cnt) cnt = 
   * this.membermusicProc.delete(hashMap); mav.addObject("cnt", cnt);
   * 
   * mav.setViewName("redirect:/music/delete_likelist.do"); // request 객체가 전달이 안됨.
   *  
   * return mav; }
   */
  
  
  
  /**
   * 목록 :: http://localhost:9090/team1/membermusic/list.do (main)
   * 
   * @return
   */
  @RequestMapping(value = "/membermusic/list.do", method = RequestMethod.GET)
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/membermusic/list"); // :: /webapp/membermusic/list.jsp

//    SingerVO singerVO = this.singerProc.read(singerno);
//    mav.addObject("singerVO", singerVO);
    
//    List<SingerVO> list_s = this.singerProc.list_singer();
//    mav.addObject("list_s", list_s);
    
    List<MemberMusicVO> list = this.membermusicProc.list();
    mav.addObject("list", list);

    return mav; // forward }
  }

  /**
   * 목록 (중복제거) -main :: http://localhost:9090/team1/membermusic/list.do (main)
   * 
   * @return
   */
  @RequestMapping(value = "/membermusic/list_memberno.do", method = RequestMethod.GET)
  public ModelAndView list_memberno() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/membermusic/list"); // :: /webapp/membermusic/list.jsp

    List<MemberMusicVO> list = this.membermusicProc.list_memberno();
    mav.addObject("list", list);

    return mav; // forward
  }

  /**
   * 조회 + 수정폼 http://localhost:9090/team1/membermusic/list_read.do
   * 
   * @return
   */
  @RequestMapping(value = "/membermusic/list_read.do", method = RequestMethod.GET)
  public ModelAndView list_read(int memberno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/membermusic/list_read"); // :: /webapp/membermusic/list_read.jsp

    MemberVO memberVO = this.memberProc.read(memberno);
    mav.addObject("memberVO", memberVO);
    
    MemberMusicVO membermusicVO = this.membermusicProc.read(memberno);
    mav.addObject("membermusicVO", membermusicVO);
    
    MusicVO musicVO = this.musicProc.read(membermusicVO.getMusicno());
    mav.addObject("musicVO", musicVO);
    
    List<MusicVO> list_m =this.musicProc.list();
    mav.addObject("list_m", list_m);

    List<MemberMusicVO> list = this.membermusicProc.list_memberno();
    mav.addObject("list", list);

    return mav;
  }

}
