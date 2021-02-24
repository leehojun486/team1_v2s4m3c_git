package dev.mvc.music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.album.AlbumProcInter;
import dev.mvc.album.AlbumVO;
import dev.mvc.genre.GenreProcInter;
import dev.mvc.genre.GenreVO;
import dev.mvc.member.MemberProcInter;
import dev.mvc.membermusic.MemberMusicProcInter;
import dev.mvc.singer.SingerProcInter;
import dev.mvc.singer.SingerVO;

@Controller
public class MusicCont {
  @Autowired
  @Qualifier("dev.mvc.music.MusicProc")
  private MusicProcInter musicProc;

  @Autowired
  @Qualifier("dev.mvc.singer.SingerProc")
  private SingerProcInter singerProc;

  @Autowired
  @Qualifier("dev.mvc.album.AlbumProc")
  private AlbumProcInter albumProc;

  @Autowired
  @Qualifier("dev.mvc.genre.GenreProc")
  private GenreProcInter genreProc;

  @Autowired
  @Qualifier("dev.mvc.membermusic.MemberMusicProc")
  private MemberMusicProcInter membermusicProc;

  @Autowired
  @Qualifier("dev.mvc.member.MemberProc")
  private MemberProcInter memberProc;

  public MusicCont() {
    System.out.println("--team1> MusicCont Created!");
  }
  /*-----------------------------------------------------*/

  /**
   * �깮�꽦 :: http://localhost:9090/team1/music/create.do
   * 
   * @return
   */
  @RequestMapping(value = "/music/create.do", method = RequestMethod.GET)
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    /*
     * MusicVO musicVO = this.musicProc.read(musicno);
     * 
     * HashMap<String, Object> map = new HashMap<String, Object>();
     * map.put("genreno", musicVO.getGenreno()); map.put("genre",
     * musicVO.getGenre());
     */
    mav.setViewName("/music/create"); // :: /webapp/music/create.jsp

    return mav;
  }

  /**
   * �벑濡� 泥섎━ http://localhost:9090/team1/music/create.do
   * 
   * @return
   */
  @RequestMapping(value = "/music/create.do", method = RequestMethod.POST)
  public ModelAndView create(HttpServletRequest request, MusicVO musicVO) {

    ModelAndView mav = new ModelAndView();
//    // -------------------------------------------------------------------
//    // �뙆�씪 �쟾�넚 肄붾뱶 �떆�옉
//    // -------------------------------------------------------------------
//    String file1 = "";     // main image
//    String thumb1 = ""; // preview image
//        
//    String upDir = Tool.getRealPath(request, "/music/storage/main_images"); // �젅�� 寃쎈줈
//    
//    // �쟾�넚 �뙆�씪�씠 �뾾�뼱�꽌�룄 fnamesMF 媛앹껜媛� �깮�꽦�맖.
//    // <input type='file' class="form-control" name='file1MF' id='file1MF' 
//    //           value='' placeholder="�뙆�씪 �꽑�깮" multiple="multiple">
//    MultipartFile mf = musicVO.getFile1MF();
//    
//    long size1 = mf.getSize();  // �뙆�씪 �겕湲�
//    if (size1 > 0) { // �뙆�씪 �겕湲� 泥댄겕
//      // mp3 = mf.getOriginalFilename(); // �썝蹂� �뙆�씪紐�, spring.jpg
//      // �뙆�씪 ���옣 �썑 �뾽濡쒕뱶�맂 �뙆�씪紐낆씠 由ы꽩�맖, spring.jsp, spring_1.jpg...
//      file1 = Upload.saveFileSpring(mf, upDir); 
//      
//      if (Tool.isImage(file1)) { // �씠誘몄��씤吏� 寃��궗
//        // thumb �씠誘몄� �깮�꽦�썑 �뙆�씪紐� 由ы꽩�맖, width: 200, height: 150
//        thumb1 = Tool.preview(upDir, file1, 200, 150); 
//      }
//    }    
//    musicVO.setFile1(file1);
//    musicVO.setThumb1(thumb1);
//    musicVO.setSize1(size1);
//    // -------------------------------------------------------------------
//    // �뙆�씪 �쟾�넚 肄붾뱶 醫낅즺
//    // -------------------------------------------------------------------

    int cnt = this.musicProc.create(musicVO); // Call by Reference :: 硫붾え由� 怨듭쑀 紐⑹쟻, HashCode �쟾�떖

    // -------------------------------------------------------------------
    // PK�쓽 return
    // -------------------------------------------------------------------
    System.out.println("--> musicVO: " + musicVO.getMusicno());
    mav.addObject("musicVO", musicVO.getMusicno()); // redirect parameter �쟻�슜
    // -------------------------------------------------------------------

    mav.addObject("cnt", cnt); // request.setAttribute("cnt", cnt)

    mav.addObject("url", "create_continue"); // create_continue.jsp, redirect parameter �쟻�슜
    mav.setViewName("redirect:/music/msg.do");

    return mav; // forward
  }

  /**
   * �깉濡쒓퀬移⑥쓣 諛⑹��븯�뒗 硫붿떆吏� 異쒕젰
   * 
   * @return
   */
  @RequestMapping(value = "/music/msg.do", method = RequestMethod.GET)
  public ModelAndView msg(String url) {
    ModelAndView mav = new ModelAndView();

    // �벑濡� 泥섎━ 硫붿떆吏�: create_msg --> /contents/create_msg.jsp
    // �닔�젙 泥섎━ 硫붿떆吏�: update_msg --> /contents/update_msg.jsp
    // �궘�젣 泥섎━ 硫붿떆吏�: delete_msg --> /contents/delete_msg.jsp
    mav.setViewName("/music/" + url); // forward

    return mav; // forward
  }

//     /**
//     * 紐⑸줉 議고쉶 ::
//     * http://localhost:9090/team1/music/list.do  
//     * @return
//     */
//    @RequestMapping(value = "/music/list.do", method = RequestMethod.GET)
//    public ModelAndView list() {
//      ModelAndView mav = new ModelAndView();
//      mav.setViewName("/music/list"); // :: /webapp/music/list.jsp
//      
//      MemberVO memberVO = new MemberVO();
//      
//      String mname = memberVO.getMname(); 
//      mav.addObject("mname", mname);
//      
//      List<MusicVO> list = this.musicProc.list();
//      mav.addObject("list", list);
//      
//      return mav;
//    }

  /**
   * 媛��닔踰덊샇�뿉 �뵲瑜� 議고쉶 :: http://localhost:9090/team1/music/list_by_singerno.do
   * 
   * @param singerno
   * @return
   */
  @RequestMapping(value = "/music/list_by_singerno.do", method = RequestMethod.GET)
  public ModelAndView list_by_singerno() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/music/list"); // :: /webapp/music/list.jsp

    List<MusicVO> list = this.musicProc.list_by_singerno();
    mav.addObject("list", list);

    return mav;
  }

//            /**                   ::>> 紐⑸줉 + 寃��깋 + �럹�씠吏� 吏��썝�쑝濡� 蹂�寃� 
//             * 紐⑸줉 + 寃��깋 吏��썝   
//             * http://localhost:9090/team1/music/list.do
//             * http://localhost:9090/team1/music/list.do?word=諛뺥슚�떊
//             * @param cateno
//             * @param word
//             * @return
//             */
//            @RequestMapping(value = "/music/list.do", 
//                                                 method = RequestMethod.GET)
//            public ModelAndView list_search(
//                /* @RequestParam(value="cateno", defaultValue="1") int cateno, */
//                @RequestParam(value="word", defaultValue="") String word, MusicVO musicVO) { 
//              
//              ModelAndView mav = new ModelAndView();
//              mav.setViewName("/music/list");   
//              
//          //    // �닽�옄�� 臾몄옄�뿴 ���엯�쓣 ���옣�빐�빞�븿�쑝濡� Obejct �궗�슜
//          //    HashMap<String, Object> map = new HashMap<String, Object>();
//          //    map.put("cateno", cateno); // #{cateno}
//          //    map.put("word", word);     // #{word}
//              
//              // 寃��깋 紐⑸줉
//              List<MusicVO> list = musicProc.list_search(musicVO);
//              mav.addObject("list", list);
//              
//          //      // 寃��깋�맂 �젅肄붾뱶 媛��닔
//          //      int search_count = contentsProc.search_count(map);
//          //      mav.addObject("search_count", search_count);
//          
//          //    musicVO = musicProc.read(musicVO.getMusicno());
//          //    mav.addObject("musicVO", musicVO);
//              
//              return mav;
//            }    

  /**
   * 紐⑸줉 + 寃��깋 + �럹�씠吏� 吏��썝 http://localhost:9090/team1/music/list.do
   * http://localhost:9090/team1/music/list.do?genre=1&word=�뼇�떎�씪&nowPage=1
   * 
   * @param genreno
   * @param word
   * @param nowPage
   * @return
   */
  @RequestMapping(value = "/music/list.do", method = RequestMethod.GET)
  public ModelAndView list_by_genreno_search_paging(String title, 
                               @RequestParam(value="nowPage", defaultValue="1")int nowPage) {
    System.out.println("--> nowPage: " + nowPage);

    ModelAndView mav = new ModelAndView();

    // �닽�옄�� 臾몄옄�뿴 ���엯�쓣 ���옣�빐�빞�븿�쑝濡� Obejct �궗�슜
    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("title", title); // #{genreno}
    map.put("nowPage", nowPage); // �럹�씠吏��뿉 異쒕젰�븷 �젅肄붾뱶�쓽 踰붿쐞瑜� �궛異쒗븯湲곗쐞�빐 �궗�슜

    // 寃��깋 紐⑸줉
    List<MusicVO> list = musicProc.list_by_genreno_search_paging(map);
    mav.addObject("list", list);

    // 寃��깋�맂 �젅肄붾뱶 媛��닔
    int search_count = musicProc.search_count(map); // search_count �븿�닔 �뾾�쓬
    mav.addObject("search_count", search_count);


//        SingerVO singerVO = singerProc.read(cateVO.getCategrpno());
//        mav.addObject("singerVO", singerVO);

    /*
     * SPAN�깭洹몃�� �씠�슜�븳 諛뺤뒪 紐⑤뜽�쓽 吏��썝, 1 �럹�씠吏�遺��꽣 �떆�옉 �쁽�옱 �럹�씠吏�: 11 / 22 [�씠�쟾] 11 12 13 14 15 16 17
     * 18 19 20 [�떎�쓬]
     * 
     * @param listFile 紐⑸줉 �뙆�씪紐�
     * 
     * @param genreno 移댄뀒怨좊━踰덊샇
     * 
     * @param search_count 寃��깋(�쟾泥�) �젅肄붾뱶�닔
     * 
     * @param nowPage �쁽�옱 �럹�씠吏�
     * 
     * @param word 寃��깋�뼱
     * 
     * @return �럹�씠吏� �깮�꽦 臾몄옄�뿴
     */
    String paging = musicProc.pagingBox("list.do", search_count, nowPage, title);
    mav.addObject("paging", paging);

    mav.addObject("nowPage", nowPage);

    // /music/list_by_genreno_search_paging.jsp
    mav.setViewName("/music/list_by_genreno_search_paging");

    return mav;
  }

  // http://localhost:9090/team1/music/list_join.do
  /**
   * Genre + Music join �쟾泥� 紐⑸줉 <!-- 誘멸뎄�쁽 以� --!>
   * 
   * @return
   */
  @RequestMapping(value = "/cate/list_join.do", method = RequestMethod.GET)
  public ModelAndView list_join() {
    ModelAndView mav = new ModelAndView();

    List<Genre_Music_Join> list = this.musicProc.list_join();
    mav.addObject("list", list); // request.setAttribute("list", list);

    mav.setViewName("/music/list_join"); // webapp/music/list_join.jsp
    return mav;
  }

//  // http://localhost:9090/resort/cate/list.do 湲곗〈�쓽 url �궗�슜
//  /**
//   * categrp + cate join �쟾泥� 紐⑸줉
//   * @return
//   */
//  @RequestMapping(value="/cate/list.do", method=RequestMethod.GET )
//  public ModelAndView list_join_by_categrpno(int categrpno) {
//    ModelAndView mav = new ModelAndView();
//    
//    CategrpVO categrpVO = this.categrpProc.read(categrpno);
//    mav.addObject("categrpVO", categrpVO);
//    
//    List<Categrp_Cate_join> list = this.cateProc.list_join_by_categrpno(categrpno);
//    mav.addObject("list", list); // request.setAttribute("list", list);
//
//    mav.setViewName("/cate/list_join_by_categrpno"); // webapp/cate/list_join_by_categrpno.jsp
//    return mav;
//  } <!-- 李멸퀬 �냼�뒪 --!>

  /**
   * 寃고빀�맂 �옣瑜� 蹂� �쓬�븙 紐⑸줉 http://localhost:9090/team1/music/list_index_left.do
   * 
   * @param request
   * @return
   */
  @RequestMapping(value = "/music/list_index_left.do", method = RequestMethod.GET)
  public ModelAndView list_index_left(HttpServletRequest request) {
    // System.out.println("--> list_index() GET called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/music/list_index_left"); // webapp/music/list_index_left.jsp

    List<GenreVO> genre_list = genreProc.list_seqno_asc(); // �옣瑜� 紐⑸줉

    // Genre: name, Music: name 寃고빀 紐⑸줉
    ArrayList<String> name_title_list = new ArrayList<String>();

    StringBuffer url = new StringBuffer(); // �쓬�븙 �젣紐� 留곹겕 議고빀

    // �옣瑜� 媛��닔 留뚰겮 �닚�솚
    for (int index = 0; index < genre_list.size(); index++) {
      GenreVO genreVO = genre_list.get(index); // �븯�굹�쓽 �옣瑜� 異붿텧

      // �옣瑜대챸 異붽�
      name_title_list.add("<LI class='genre_name'>" + genreVO.getGenrename() + "</LI>");

      // �쓬�븙 Join 紐⑸줉, �듅�젙 �옣瑜댁뿉 �빐�떦�븯�뒗 �쓬�븙媛��졇�샂.
      List<Genre_Music_Join> music_list = musicProc.list_join_by_genreno(genreVO.getGenreno());

      // �쓬�븙 媛��닔留뚰겮 �닚�솚
      for (int j = 0; j < music_list.size(); j++) {
        Genre_Music_Join genre_music_join = music_list.get(j);

        String name = genre_music_join.getTitle(); // �쓬�븙�젣紐�
        int cnt = genre_music_join.getCnt();

//       url.append("<LI class='music_name'>");
//       url.append("  <A href='" + request.getContextPath()+ "/music/list.do?musicno="+genre_music_join.getMusicno()+"'>");
//       url.append(name);
//       url.append("  </A>");
//       url.append("  <span style='font-size: 0.9em; color: #555555;'>("+"�솵"+")</span>");
//       url.append("</LI>");
//       
//       name_title_list.add(url.toString()); // 異쒕젰 紐⑸줉�뿉 �븯�굹�쓽 cate紐� 異붽� 
//       
//       url.delete(0, url.toString().length()); // �깉濡쒖슫 移댄뀒怨좊━ 紐⑸줉�쓣 援ъ꽦�븯湲곗쐞�빐 StringBuffer 臾몄옄�뿴 �궘�젣

        // �쓬�몴 踰꾪듉 �늻瑜� �떆 :: �쑀�뒠釉� url 蹂�寃� <A href=' '> �솵 </A>
        url.append("<LI class='music_name'>");
        url.append("  <A href='" + request.getContextPath() + "/music/read.do?musicno=" + genre_music_join.getMusicno()
            + "'>");
        url.append(name);
        url.append("  </A>");
        url.append("  <span style='font-size: 0.9em; color: #555555;'>��");
        url.append("<A href=' '>Youtube�솵</A>��</span>");
        url.append("</LI>");

        name_title_list.add(url.toString()); // 異쒕젰 紐⑸줉�뿉 �븯�굹�쓽 cate紐� 異붽�

        url.delete(0, url.toString().length()); // �깉濡쒖슫 移댄뀒怨좊━ 紐⑸줉�쓣 援ъ꽦�븯湲곗쐞�빐 StringBuffer 臾몄옄�뿴 �궘�젣

      }
    }

    mav.addObject("name_title_list", name_title_list);
    mav.addObject("total_count", musicProc.total_count());
    return mav;
  }

  /**
   * 湲� �씫湲� :: http://localhost:9090/team1/music/read.do
   * 
   * @param musicno
   * @return
   */

  @RequestMapping(value = "/music/read.do", method = RequestMethod.GET)
  public ModelAndView read(int musicno) {
    ModelAndView mav = new ModelAndView();

    MusicVO musicVO = this.musicProc.read(musicno);
    mav.addObject("musicVO", musicVO);

//    SingerVO singerVO = this.singerProc.read(musicno);
//    mav.addObject("singerVO", singerVO);
//
    AlbumVO albumVO = this.albumProc.read(musicno);
    mav.addObject("albumVO", albumVO);
//
//    GenreVO genreVO = this.genreProc.read(musicno);
//    mav.addObject("genreVO", genreVO);

    mav.setViewName("/music/read"); // :: /webapp/music/read.jsp

    return mav;
  }

  /**
   * 異쒕젰紐⑤뱶 蹂�寃�
   * 
   * @param musicVO
   * @return
   */
  /*
   * @RequestMapping(value = "/music/add_likelist.do", method = RequestMethod.GET)
   * public ModelAndView add_likelist(MusicVO musicVO) { ModelAndView mav = new
   * ModelAndView();
   * 
   * System.out.println("-->" + musicVO.getLikelist());
   * 
   * int cnt = this.musicProc.add_likelist(musicVO); mav.addObject("cnt", cnt); //
   * request�뿉 ���옣
   * 
   * mav.setViewName("redirect:/music/list.do"); // request 媛앹껜媛� �쟾�떖�씠 �븞�맖.
   * 
   * return mav; }
   */

  /**
   * 異쒕젰紐⑤뱶 蹂�寃�
   * 
   * @param musicVO
   * @return
   */
  /*
   * @RequestMapping(value = "/music/delete_likelist.do", method =
   * RequestMethod.GET) public ModelAndView delete_likelist(MusicVO musicVO) {
   * ModelAndView mav = new ModelAndView();
   * 
   * int cnt = this.musicProc.delete_likelist(musicVO); mav.addObject("cnt", cnt);
   * // request�뿉 ���옣
   * 
   * mav.setViewName("redirect:/music/list.do"); // request 媛앹껜媛� �쟾�떖�씠 �븞�맖.
   * 
   * return mav; }
   */

  /**
   * �닔�젙 �뤌
   *  :: http://localhost:9090/team1/music/update.do
   * @return
   */
  @RequestMapping(value = "/music/update.do", method = RequestMethod.GET)
  public ModelAndView update(int musicno) {
    ModelAndView mav = new ModelAndView();

    MusicVO musicVO = this.musicProc.read(musicno);
    mav.addObject("musicVO", musicVO);

    mav.setViewName("music/update");

    return mav;
  }

  /**
   * �닔�젙 泥섎━         ::         http://localhost:9090/team1_git/music/update.do
   * @param musicVO
   * @return
   */
  @RequestMapping(value = "/music/update.do", method = RequestMethod.POST)
  public ModelAndView update(MusicVO musicVO) {
    ModelAndView mav = new ModelAndView();
    int musicno = musicVO.getMusicno();
    
    mav.addObject("musicno", musicno);

    int cnt =  this.musicProc.update(musicVO); // �닔�젙�맂 �젅肄붾뱶 媛��닔 
    
    mav.addObject("cnt", cnt); // request�뿉 ���옣
    mav.setViewName("/music/update_msg"); // webapp/music/update_msg.jsp
    
    return mav;
  }
  
  /**
   * �닔�젙 泥섎━
   *  :: http://localhost:9090/team1/music/update.do
   * @param musicVO
   * @return
   */
  /*
   * @RequestMapping(value = "/music/update.do", method = RequestMethod.POST)
   * public ModelAndView update(MusicVO musicVO) { ModelAndView mav = new
   * ModelAndView();
   * 
   * GenreVO genreVO = this.genreProc.read(musicVO.getGenreno());
   * mav.addObject("genre_name", genreVO.getGenrename()); mav.addObject("genreno",
   * genreVO.getGenreno());
   * 
   * SingerVO singerVO = this.singerProc.read(musicVO.getSingerno());
   * mav.addObject("singer_name", singerVO.getName()); mav.addObject("singerno",
   * singerVO.getSingerno());
   * 
   * HashMap<String, Object> hashMap = new HashMap<String, Object>();
   * hashMap.put("musicno", musicVO.getMusicno()); hashMap.put("passwd",
   * musicVO.getPasswd());
   * 
   * int passwd_cnt = 0; // �뙣�뒪�썙�뱶 �씪移� �젅肄붾뱶 媛��닔 int cnt = 0; // �닔�젙�맂 �젅肄붾뱶 媛��닔
   * 
   * passwd_cnt = this.musicProc.passwd_check(hashMap);
   * 
   * if (passwd_cnt == 0) { // �뙣�뒪�썙�뱶媛� �씪移섑븷 寃쎌슦 湲� �닔�젙 cnt =
   * this.musicProc.update(musicVO); }
   * 
   * mav.addObject("cnt", cnt); // request�뿉 ���옣 mav.addObject("passwd_cnt",
   * passwd_cnt); // request�뿉 ���옣
   * 
   * mav.setViewName("/music/update_msg"); // webapp/music/update_msg.jsp
   * 
   * return mav; }
   */

  
  /**
   * �궘�젣 �뤌, attachfile Ajax 湲곕컲 �궘�젣 吏��썝
   *  :: http://localhost:9090/team1_git/music/delete.do?musicno=1
   * @return
   */
  @RequestMapping(value="/music/delete.do", method=RequestMethod.GET )
  public ModelAndView delete(int musicno) {
    ModelAndView mav = new ModelAndView();
  
    MusicVO musicVO = this.musicProc.read(musicno); 
    mav.addObject("musicVO", musicVO);
    
    mav.setViewName("/music/delete"); // webapp/music/delete.jsp
  
    return mav;
  }
  
  /**
   * �궘�젣 泥섎━         ::         http://localhost:9090/tema1_git/music/delete.do
   * @param musicVO
   * @return
   */  
  @RequestMapping(value = "/music/delete.do", method = RequestMethod.POST)
  public ModelAndView delete(MusicVO musicVO,
                             String passwd) {
    ModelAndView mav = new ModelAndView();
    int musicno = musicVO.getMusicno();
    
    String music = this.musicProc.read(musicno).getTitle();
    
    HashMap<String, Object> hashMap = new HashMap<String, Object>();
    hashMap.put("musicno", musicno);
    hashMap.put("passwd", passwd);
    
    mav.addObject("musicno", musicVO.getMusicno());

    int passwd_cnt = 0; // �뙣�뒪�썙�뱶 �씪移� �젅肄붾뱶 媛��닔
    int cnt = 0;        // �궘�젣�맂 �젅肄붾뱶 媛��닔 
    
    passwd_cnt = this.musicProc.passwd_check(hashMap);
    
    if (passwd_cnt == 1) { // �뙣�뒪�썙�뱶媛� �씪移섑븷 寃쎌슦 湲� �궘�젣
      cnt = this.musicProc.delete(musicno);
      mav.setViewName("/music/delete_msg"); // webapp/music/delete_msg.jsp
    } else {
      mav.setViewName("/music/delete_msg"); // webapp/music/delete_msg.jsp
    }
    mav.addObject("cnt", cnt); // request�뿉 ���옣
    mav.addObject("passwd_cnt", passwd_cnt);
    mav.addObject("music", music);
    
    return mav;
  }
  
  /**
   * �궘�젣 泥섎━ +  �뙆�씪 �궘�젣
   *  :: http://localhost:9090/team1_git/music/delete.do
   * @param musicVO
   * @return
   */
  /*
   * @RequestMapping(value="/music/delete.do", method=RequestMethod.POST ) public
   * ModelAndView delete(HttpServletRequest request, int musicno, String passwd,
   * 
   * @RequestParam(value="word", defaultValue="") String word,
   * 
   * @RequestParam(value="nowPage", defaultValue="1") int nowPage) { ModelAndView
   * mav = new ModelAndView();
   * 
   * MusicVO musicVO = this.musicProc.read(musicno); String title =
   * musicVO.getTitle(); mav.addObject("title", title);
   * 
   * HashMap<String, Object> hashMap = new HashMap<String, Object>();
   * hashMap.put("musicno", musicno); hashMap.put("passwd", passwd);
   * 
   * int passwd_cnt = 0; // �뙣�뒪�썙�뱶 �씪移� �젅肄붾뱶 媛��닔 int cnt = 0; // �닔�젙�맂 �젅肄붾뱶 媛��닔
   * 
   * passwd_cnt = this.musicProc.passwd_check(hashMap); boolean sw = false;
   * 
   * if (passwd_cnt == 1) { // �뙣�뒪�썙�뱶媛� �씪移섑븷 寃쎌슦 湲� �궘�젣 cnt =
   * this.musicProc.delete(musicno); if (cnt == 1) { //
   * musicProc.decreaseCnt(musicno); //�쓬�븙 移댄뀒怨좊━�쓽 �닔 媛먯냼
   * 
   * //
   * -----------------------------------------------------------------------------
   * -------- // 留덉�留� �럹�씠吏��쓽 �젅肄붾뱶 �궘�젣�떆�쓽 �럹�씠吏� 踰덊샇 -1 泥섎━ HashMap<String, Object> map = new
   * HashMap<String, Object>(); map.put("musicno", musicno); map.put("word",
   * word); // �븯�굹�쓽 �럹�씠吏�媛� 3媛쒖쓽 �젅肄붾뱶濡� 援ъ꽦�릺�뒗 寃쎌슦 �쁽�옱 9媛쒖쓽 �젅肄붾뱶媛� �궓�븘 �엳�쑝硫� if
   * (musicProc.search_count(map) % Musics.RECORD_PER_PAGE == 0) { nowPage =
   * nowPage - 1; if (nowPage < 1) { nowPage = 1; // �떆�옉 �럹�씠吏� } } //
   * -----------------------------------------------------------------------------
   * -------- }
   * 
   * String upDir = Tool.getRealPath(request, "/music/storage/main_images"); // �젅��
   * 寃쎈줈 sw = Tool.deleteFile(upDir, musicVO.getFile1()); // Folder�뿉�꽌 1嫄댁쓽 �뙆�씪 �궘�젣 sw
   * = Tool.deleteFile(upDir, musicVO.getThumb1()); // Folder�뿉�꽌 1嫄댁쓽 �뙆�씪 �궘�젣
   * 
   * }
   * 
   * mav.addObject("cnt", cnt); // request�뿉 ���옣 mav.addObject("passwd_cnt",
   * passwd_cnt); // request�뿉 ���옣 mav.addObject("nowPage", nowPage); // request�뿉 ���옣
   * // System.out.println("--> ContentsCont.java nowPage: " + nowPage);
   * 
   * mav.addObject("musicno", musicVO.getMusicno()); // redirect parameter �쟻�슜
   * mav.addObject("url", "delete_msg"); // delete_msg.jsp, redirect parameter �쟻�슜
   * 
   * // mav.setViewName("/contents/delete_msg"); // webapp/contents/delete_msg.jsp
   * mav.setViewName("redirect:/music/msg.do");
   * 
   * return mav; }
   */
  
  
  /**
   * 濡쒓렇�씤 �뿬遺�留� 泥댄겕�븿�쑝濡� �떎瑜� �궗�슜�옄�쓽 湲��쓣 �궘�젣 �븷 �닔 �엳�뒗 �솕硫댁씠 異쒕젰�맖.
   * �궘�젣 �뤌, attachfile Ajax 湲곕컲 �궘�젣 吏��썝
   * @return
   */  
  /*
   @RequestMapping(value="/music/delete.do", method=RequestMethod.GET )
   public ModelAndView delete(HttpSession session, int musicno) {
     ModelAndView mav = new ModelAndView();
     
     int memberno = (int)session.getAttribute("memberno");
     
     if (memberno == this.musicProc.read(musicno).getMemberno()) {
       MusicVO musicVO = this.musicProc.read_update(musicno); 
       mav.addObject("musicVO", musicVO); 
       
       mav.setViewName("/music/delete"); // webapp/music/delete.jsp
     } else {
       mav.setViewName("redirect:/member/mconfirm_fail_msg.jsp"); // need
     }
     
     return mav;
   }   */
}
