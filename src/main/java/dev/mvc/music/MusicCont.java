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
   * 생성 :: http://localhost:9090/team1/music/create.do
   * 
   * @return
   */
  @RequestMapping(value = "/music/create.do", method = RequestMethod.GET)
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();

    List<GenreVO> list_genre = this.genreProc.list();
    mav.addObject("list_genre", list_genre);

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
   * 등록 처리 http://localhost:9090/team1/music/create.do
   * 
   * @return
   */
  @RequestMapping(value = "/music/create.do", method = RequestMethod.POST)
  public ModelAndView create(HttpServletRequest request, MusicVO musicVO) {

    ModelAndView mav = new ModelAndView();
//    // -------------------------------------------------------------------
//    // 파일 전송 코드 시작
//    // -------------------------------------------------------------------
//    String file1 = "";     // main image
//    String thumb1 = ""; // preview image
//        
//    String upDir = Tool.getRealPath(request, "/music/storage/main_images"); // 절대 경로
//    
//    // 전송 파일이 없어서도 fnamesMF 객체가 생성됨.
//    // <input type='file' class="form-control" name='file1MF' id='file1MF' 
//    //           value='' placeholder="파일 선택" multiple="multiple">
//    MultipartFile mf = musicVO.getFile1MF();
//    
//    long size1 = mf.getSize();  // 파일 크기
//    if (size1 > 0) { // 파일 크기 체크
//      // mp3 = mf.getOriginalFilename(); // 원본 파일명, spring.jpg
//      // 파일 저장 후 업로드된 파일명이 리턴됨, spring.jsp, spring_1.jpg...
//      file1 = Upload.saveFileSpring(mf, upDir); 
//      
//      if (Tool.isImage(file1)) { // 이미지인지 검사
//        // thumb 이미지 생성후 파일명 리턴됨, width: 200, height: 150
//        thumb1 = Tool.preview(upDir, file1, 200, 150); 
//      }
//    }    
//    musicVO.setFile1(file1);
//    musicVO.setThumb1(thumb1);
//    musicVO.setSize1(size1);
//    // -------------------------------------------------------------------
//    // 파일 전송 코드 종료
//    // -------------------------------------------------------------------

    int cnt = this.musicProc.create(musicVO); // Call by Reference :: 메모리 공유 목적, HashCode 전달

    // -------------------------------------------------------------------
    // PK의 return
    // -------------------------------------------------------------------
    System.out.println("--> musicVO: " + musicVO.getMusicno());
    mav.addObject("musicVO", musicVO.getMusicno()); // redirect parameter 적용
    // -------------------------------------------------------------------

    mav.addObject("cnt", cnt); // request.setAttribute("cnt", cnt)

    mav.addObject("url", "create_continue"); // create_continue.jsp, redirect parameter 적용
    mav.setViewName("redirect:/music/msg.do");

    return mav; // forward
  }

  /**
   * 새로고침을 방지하는 메시지 출력
   * 
   * @return
   */
  @RequestMapping(value = "/music/msg.do", method = RequestMethod.GET)
  public ModelAndView msg(String url) {
    ModelAndView mav = new ModelAndView();

    // 등록 처리 메시지: create_msg --> /contents/create_msg.jsp
    // 수정 처리 메시지: update_msg --> /contents/update_msg.jsp
    // 삭제 처리 메시지: delete_msg --> /contents/delete_msg.jsp
    mav.setViewName("/music/" + url); // forward

    return mav; // forward
  }

//     /**
//     * 목록 조회 ::
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
   * 가수번호에 따른 조회 :: http://localhost:9090/team1/music/list_by_singerno.do
   * 
   * @param singerno
   * @return
   */
  @RequestMapping(value = "/music/list_by_singerno.do", method = RequestMethod.GET)
  public ModelAndView list_by_singerno(int singerno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/music/list"); // :: /webapp/music/list.jsp

    List<MusicVO> list = this.musicProc.list_by_singerno(singerno);
    mav.addObject("list", list);

    return mav;
  }

//            /**                   ::>> 목록 + 검색 + 페이징 지원으로 변경 
//             * 목록 + 검색 지원   
//             * http://localhost:9090/team1/music/list.do
//             * http://localhost:9090/team1/music/list.do?word=박효신
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
//          //    // 숫자와 문자열 타입을 저장해야함으로 Obejct 사용
//          //    HashMap<String, Object> map = new HashMap<String, Object>();
//          //    map.put("cateno", cateno); // #{cateno}
//          //    map.put("word", word);     // #{word}
//              
//              // 검색 목록
//              List<MusicVO> list = musicProc.list_search(musicVO);
//              mav.addObject("list", list);
//              
//          //      // 검색된 레코드 갯수
//          //      int search_count = contentsProc.search_count(map);
//          //      mav.addObject("search_count", search_count);
//          
//          //    musicVO = musicProc.read(musicVO.getMusicno());
//          //    mav.addObject("musicVO", musicVO);
//              
//              return mav;
//            }    

  /**
   * 목록 + 검색 + 페이징 지원 http://localhost:9090/team1/music/list.do
   * http://localhost:9090/team1/music/list.do?genre=1&word=양다일&nowPage=1
   * 
   * @param genreno
   * @param word
   * @param nowPage
   * @return
   */
  @RequestMapping(value = "/music/list.do", method = RequestMethod.GET)
  public ModelAndView list_by_genreno_search_paging(@RequestParam(value = "genreno", defaultValue = "1") int genreno, // 기본값
                                                                                                                      // 지정(값
                                                                                                                      // 못받을
                                                                                                                      // 시
                                                                                                                      // 대비)
      @RequestParam(value = "word", defaultValue = "") String word,
      @RequestParam(value = "nowPage", defaultValue = "1") int nowPage) {
    System.out.println("--> nowPage: " + nowPage);

    ModelAndView mav = new ModelAndView();

    // 숫자와 문자열 타입을 저장해야함으로 Obejct 사용
    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("genreno", genreno); // #{genreno}
    map.put("word", word); // #{word}
    map.put("nowPage", nowPage); // 페이지에 출력할 레코드의 범위를 산출하기위해 사용

    // 검색 목록
    List<MusicVO> list = musicProc.list_by_genreno_search_paging(map);
    mav.addObject("list", list);

    // 검색된 레코드 갯수
    int search_count = musicProc.search_count(map); // search_count 함수 없음
    mav.addObject("search_count", search_count);

    GenreVO genreVO = genreProc.read(genreno);
    mav.addObject("genreVO", genreVO);

//        SingerVO singerVO = singerProc.read(cateVO.getCategrpno());
//        mav.addObject("singerVO", singerVO);

    /*
     * SPAN태그를 이용한 박스 모델의 지원, 1 페이지부터 시작 현재 페이지: 11 / 22 [이전] 11 12 13 14 15 16 17
     * 18 19 20 [다음]
     * 
     * @param listFile 목록 파일명
     * 
     * @param genreno 카테고리번호
     * 
     * @param search_count 검색(전체) 레코드수
     * 
     * @param nowPage 현재 페이지
     * 
     * @param word 검색어
     * 
     * @return 페이징 생성 문자열
     */
    String paging = musicProc.pagingBox("list.do", genreno, search_count, nowPage, word);
    mav.addObject("paging", paging);

    mav.addObject("nowPage", nowPage);

    // /music/list_by_genreno_search_paging.jsp
    mav.setViewName("/music/list_by_genreno_search_paging");

    return mav;
  }

  // http://localhost:9090/team1/music/list_join.do
  /**
   * Genre + Music join 전체 목록 <!-- 미구현 중 --!>
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

//  // http://localhost:9090/resort/cate/list.do 기존의 url 사용
//  /**
//   * categrp + cate join 전체 목록
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
//  } <!-- 참고 소스 --!>

  /**
   * 결합된 장르 별 음악 목록 http://localhost:9090/team1/music/list_index_left.do
   * 
   * @param request
   * @return
   */
  @RequestMapping(value = "/music/list_index_left.do", method = RequestMethod.GET)
  public ModelAndView list_index_left(HttpServletRequest request) {
    // System.out.println("--> list_index() GET called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/music/list_index_left"); // webapp/music/list_index_left.jsp

    List<GenreVO> genre_list = genreProc.list_seqno_asc(); // 장르 목록

    // Genre: name, Music: name 결합 목록
    ArrayList<String> name_title_list = new ArrayList<String>();

    StringBuffer url = new StringBuffer(); // 음악 제목 링크 조합

    // 장르 갯수 만큼 순환
    for (int index = 0; index < genre_list.size(); index++) {
      GenreVO genreVO = genre_list.get(index); // 하나의 장르 추출

      // 장르명 추가
      name_title_list.add("<LI class='genre_name'>" + genreVO.getGenrename() + "</LI>");

      // 음악 Join 목록, 특정 장르에 해당하는 음악가져옴.
      List<Genre_Music_Join> music_list = musicProc.list_join_by_genreno(genreVO.getGenreno());

      // 음악 갯수만큼 순환
      for (int j = 0; j < music_list.size(); j++) {
        Genre_Music_Join genre_music_join = music_list.get(j);

        String name = genre_music_join.getTitle(); // 음악제목
        int cnt = genre_music_join.getCnt();

//       url.append("<LI class='music_name'>");
//       url.append("  <A href='" + request.getContextPath()+ "/music/list.do?musicno="+genre_music_join.getMusicno()+"'>");
//       url.append(name);
//       url.append("  </A>");
//       url.append("  <span style='font-size: 0.9em; color: #555555;'>("+"♪"+")</span>");
//       url.append("</LI>");
//       
//       name_title_list.add(url.toString()); // 출력 목록에 하나의 cate명 추가 
//       
//       url.delete(0, url.toString().length()); // 새로운 카테고리 목록을 구성하기위해 StringBuffer 문자열 삭제

        // 음표 버튼 누를 시 :: 유튜브 url 변경 <A href=' '> ♪ </A>
        url.append("<LI class='music_name'>");
        url.append("  <A href='" + request.getContextPath() + "/music/read.do?musicno=" + genre_music_join.getMusicno()
            + "'>");
        url.append(name);
        url.append("  </A>");
        url.append("  <span style='font-size: 0.9em; color: #555555;'>《");
        url.append("<A href=' '>Youtube♪</A>》</span>");
        url.append("</LI>");

        name_title_list.add(url.toString()); // 출력 목록에 하나의 cate명 추가

        url.delete(0, url.toString().length()); // 새로운 카테고리 목록을 구성하기위해 StringBuffer 문자열 삭제

      }
    }

    mav.addObject("name_title_list", name_title_list);
    mav.addObject("total_count", musicProc.total_count());
    return mav;
  }

  /**
   * 글 읽기 :: http://localhost:9090/team1/music/read.do
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
   * 출력모드 변경
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
   * request에 저장
   * 
   * mav.setViewName("redirect:/music/list.do"); // request 객체가 전달이 안됨.
   * 
   * return mav; }
   */

  /**
   * 출력모드 변경
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
   * // request에 저장
   * 
   * mav.setViewName("redirect:/music/list.do"); // request 객체가 전달이 안됨.
   * 
   * return mav; }
   */

  /**
   * 수정 폼
   *  :: http://localhost:9090/team1/music/update.do
   * @return
   */
  @RequestMapping(value = "/music/update.do", method = RequestMethod.GET)
  public ModelAndView update(int musicno) {
    ModelAndView mav = new ModelAndView();

    MusicVO musicVO = this.musicProc.read_update(musicno);
    mav.addObject("musicVO", musicVO);

    mav.setViewName("music/update");

    return mav;
  }

  /**
   * 수정 처리         ::         http://localhost:9090/team1_git/music/update.do
   * @param musicVO
   * @return
   */
  @RequestMapping(value = "/music/update.do", method = RequestMethod.POST)
  public ModelAndView update(MusicVO musicVO) {
    ModelAndView mav = new ModelAndView();
    int musicno = musicVO.getMusicno();
    
    mav.addObject("musicno", musicno);

    int cnt = 0;        // 수정된 레코드 갯수 
    
    cnt = this.musicProc.update(musicVO);
    mav.setViewName("/music/update_msg"); // webapp/music/update_msg.jsp
    
    mav.addObject("cnt", cnt); // request에 저장
    
    return mav;
  }
  
  /**
   * 수정 처리
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
   * int passwd_cnt = 0; // 패스워드 일치 레코드 갯수 int cnt = 0; // 수정된 레코드 갯수
   * 
   * passwd_cnt = this.musicProc.passwd_check(hashMap);
   * 
   * if (passwd_cnt == 0) { // 패스워드가 일치할 경우 글 수정 cnt =
   * this.musicProc.update(musicVO); }
   * 
   * mav.addObject("cnt", cnt); // request에 저장 mav.addObject("passwd_cnt",
   * passwd_cnt); // request에 저장
   * 
   * mav.setViewName("/music/update_msg"); // webapp/music/update_msg.jsp
   * 
   * return mav; }
   */

  
  /**
   * 삭제 폼, attachfile Ajax 기반 삭제 지원
   *  :: http://localhost:9090/team1_git/music/delete.do?musicno=1
   * @return
   */
  @RequestMapping(value="/music/delete.do", method=RequestMethod.GET )
  public ModelAndView delete(int musicno) {
    ModelAndView mav = new ModelAndView();
  
    MusicVO musicVO = this.musicProc.read_update(musicno); 
    mav.addObject("musicVO", musicVO);
    
    mav.setViewName("/music/delete"); // webapp/music/delete.jsp
  
    return mav;
  }
  
  /**
   * 삭제 처리         ::         http://localhost:9090/tema1_git/music/delete.do
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

    int passwd_cnt = 0; // 패스워드 일치 레코드 갯수
    int cnt = 0;        // 삭제된 레코드 갯수 
    
    passwd_cnt = this.musicProc.passwd_check(hashMap);
    
    if (passwd_cnt == 1) { // 패스워드가 일치할 경우 글 삭제
      cnt = this.musicProc.delete(musicno);
      mav.setViewName("/music/delete_msg"); // webapp/music/delete_msg.jsp
    } else {
      mav.setViewName("/music/delete_msg"); // webapp/music/delete_msg.jsp
    }
    mav.addObject("cnt", cnt); // request에 저장
    mav.addObject("passwd_cnt", passwd_cnt);
    mav.addObject("music", music);
    
    return mav;
  }
  
  /**
   * 삭제 처리 +  파일 삭제
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
   * int passwd_cnt = 0; // 패스워드 일치 레코드 갯수 int cnt = 0; // 수정된 레코드 갯수
   * 
   * passwd_cnt = this.musicProc.passwd_check(hashMap); boolean sw = false;
   * 
   * if (passwd_cnt == 1) { // 패스워드가 일치할 경우 글 삭제 cnt =
   * this.musicProc.delete(musicno); if (cnt == 1) { //
   * musicProc.decreaseCnt(musicno); //음악 카테고리의 수 감소
   * 
   * //
   * -----------------------------------------------------------------------------
   * -------- // 마지막 페이지의 레코드 삭제시의 페이지 번호 -1 처리 HashMap<String, Object> map = new
   * HashMap<String, Object>(); map.put("musicno", musicno); map.put("word",
   * word); // 하나의 페이지가 3개의 레코드로 구성되는 경우 현재 9개의 레코드가 남아 있으면 if
   * (musicProc.search_count(map) % Musics.RECORD_PER_PAGE == 0) { nowPage =
   * nowPage - 1; if (nowPage < 1) { nowPage = 1; // 시작 페이지 } } //
   * -----------------------------------------------------------------------------
   * -------- }
   * 
   * String upDir = Tool.getRealPath(request, "/music/storage/main_images"); // 절대
   * 경로 sw = Tool.deleteFile(upDir, musicVO.getFile1()); // Folder에서 1건의 파일 삭제 sw
   * = Tool.deleteFile(upDir, musicVO.getThumb1()); // Folder에서 1건의 파일 삭제
   * 
   * }
   * 
   * mav.addObject("cnt", cnt); // request에 저장 mav.addObject("passwd_cnt",
   * passwd_cnt); // request에 저장 mav.addObject("nowPage", nowPage); // request에 저장
   * // System.out.println("--> ContentsCont.java nowPage: " + nowPage);
   * 
   * mav.addObject("musicno", musicVO.getMusicno()); // redirect parameter 적용
   * mav.addObject("url", "delete_msg"); // delete_msg.jsp, redirect parameter 적용
   * 
   * // mav.setViewName("/contents/delete_msg"); // webapp/contents/delete_msg.jsp
   * mav.setViewName("redirect:/music/msg.do");
   * 
   * return mav; }
   */
  
  
  /**
   * 로그인 여부만 체크함으로 다른 사용자의 글을 삭제 할 수 있는 화면이 출력됨.
   * 삭제 폼, attachfile Ajax 기반 삭제 지원
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
