package dev.mvc.singer;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.tool.Tool;
import dev.mvc.tool.Upload;



@Controller
public class SingerCont {
  @Autowired
  @Qualifier("dev.mvc.singer.SingerProc")
  private SingerProcInter singerProc;
  

  
  public SingerCont() {
    System.out.println("--> SingerCont Created !");
  }
  
  /**
   * http://localhost:9090/team1/singer/create.do
   * 
   * @param singerVO
   * @return
   */
  @RequestMapping(value = "/singer/create.do", method = RequestMethod.GET)
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/singer/create"); // /webapp/singer/create.jsp
    
    return mav;
  }
  
    /**
    * http://localhost:9090/team1/singer/create.do
    * @param request
    * @param singerVO
    * @return
    */
  @RequestMapping(value = "/singer/create.do", method = RequestMethod.POST)
  public ModelAndView create(HttpServletRequest request, SingerVO singerVO) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/singer/create_msg"); // /wepapp/singer/create_msg.jsp
    
    // -------------------------------------------------------------------
    // 파일 전송 코드 시작
    // -------------------------------------------------------------------
    String portrait = "";     // main image
    String thumb1 = ""; // preview image
        
    String upDir = Tool.getRealPath(request, "/singer/storage/main_images"); // 절대 경로
    // 전송 파일이 없어서도 fnamesMF 객체가 생성됨.
    // <input type='file' class="form-control" name='file1MF' id='file1MF' 
    //    value='' placeholder="파일 선택" multiple="multiple">
    MultipartFile mf = singerVO.getPortraitMF();
    long size1 = mf.getSize();  // 파일 크기
    if (size1 > 0) { // 파일 크기 체크
      // mp3 = mf.getOriginalFilename(); // 원본 파일명, spring.jpg
      // 파일 저장 후 업로드된 파일명이 리턴됨, spring.jsp, spring_1.jpg...
      portrait = Upload.saveFileSpring(mf, upDir); 
      
      if (Tool.isImage(portrait)) { // 이미지인지 검사
        // thumb 이미지 생성후 파일명 리턴됨, width: 200, height: 150
        thumb1 = Tool.preview(upDir, portrait, 200, 150); 
      }
    }
    singerVO.setPortrait(portrait);
    singerVO.setThumb1(thumb1);
    singerVO.setSize1(size1);
    // -------------------------------------------------------------------
    // 파일 전송 코드 종료
    // -------------------------------------------------------------------
    
    int cnt = this.singerProc.create(singerVO);
    mav.addObject("cnt", cnt);// request.setAttribute("cnt", cnt)

    return mav;
  }
  
  /**
   * http://localhost:9090/team1/singer/list.do
   * 
   * @return
   */
  @RequestMapping(value = "/singer/list.do", method = RequestMethod.GET)
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/singer/list"); // /webapp/singer/list.jsp

    List<SingerVO> list = this.singerProc.list_singerno_asc();
    mav.addObject("list", list);

    return mav; // forward
  }
  
  /**
   * http://localhost:9090/team1/singer/read.do
   * @param singerno
   * @return
   */
  // @RequestMapping(value = "/singer/read.do", method = RequestMethod.GET)
  // public ModelAndView read(int singerno) {
  //   ModelAndView mav = new ModelAndView();

  //  SingerVO singerVO = this.singerProc.read(singerno); 
  //  mav.addObject("singerVO", singerVO);
    
  //  mav.setViewName("/singer/read"); 
  //  return mav;
  // }
  
  /**
   * http://localhost:9090/team1/singer/read_join.do
   * @param singerno
   * @return
   */
  @RequestMapping(value = "/singer/read.do", method = RequestMethod.GET)
  public ModelAndView read_join(int singerno) {
    ModelAndView mav = new ModelAndView();
  
    SingerVO singerVO = this.singerProc.read(singerno); 
    mav.addObject("singerVO", singerVO);
  
    List<Singer_Singer_Review_join> list = this.singerProc.read_join(singerno);
    mav.addObject("list", list);
    
    mav.setViewName("/singer/read_join"); 
    return mav;
  }
  
   /** http://localhost:9090/ojt/reply/read_join.do?singerno=1
    * @param contentsno
    * @return
    */
   @ResponseBody
   @RequestMapping(value = "/singer/list_join.do",
                               method = RequestMethod.GET,
                               produces = "text/plain;charset=UTF-8")
   public String list_join(int singerno) {
     // String msg="JSON 출력";
     // return msg;
     
     List<Singer_Singer_Review_join> list = this.singerProc.read_join(singerno);
     List<Singer_Review_Member_join> memberlist = this.singerProc.read_member_join(singerno);
     
     JSONObject obj = new JSONObject();
     obj.put("list", list);
     obj.put("memberlist", memberlist);
  
     return obj.toString();     
   }
  
  
  
  /**
   * http://localhost:9090/team1/singer/update.do
   * @param singerno
   * @return
   */
  @RequestMapping(value = "/singer/update.do", method=RequestMethod.GET)
  public ModelAndView read_update(int singerno) {
    ModelAndView mav = new ModelAndView();
    
    SingerVO singerVO = this.singerProc.read_update(singerno);
    mav.addObject("singerVO", singerVO);
    
    mav.setViewName("/singer/update");
    
    return mav;
  }
  
  /**
   * http://localhost:9090/resort/singer/update.do
   * @param singerVO
   * @return
   */
  @RequestMapping(value = "/singer/update.do", method = RequestMethod.POST)
  public ModelAndView update(SingerVO singerVO) {
    ModelAndView mav = new ModelAndView();

    mav.addObject("singerno", singerVO.getSingerno());

    int cnt = this.singerProc.update(singerVO);
    mav.addObject("cnt", cnt); // request�뿉 ���옣

    if (cnt == 1) {
      mav.setViewName("/singer/update_msg"); // webapp/singer/update_msg.jsp
    } else {
      mav.setViewName("/singer/update_msg"); // webapp/singer/update_msg.jsp
    }

    return mav;
  }
  
  /**
   * http://localhost:9090/team1/singer/delete.do
   * @param singerno
   * @return
   */
  @RequestMapping(value ="/singer/delete.do", method = RequestMethod.GET)
  public ModelAndView read_delete(int singerno) {
    ModelAndView mav = new ModelAndView();
    
    SingerVO singerVO = this.singerProc.read_update(singerno);
    mav.addObject("singerVO", singerVO);
    
    mav.setViewName("/singer/delete");
    
    return mav;
  }
  
  /**
   * http://localhost:9090/team1/singer/delete.do
   * @param singerVO
   * @return
   */
  @RequestMapping(value = "/singer/delete.do", method = RequestMethod.POST)
  public ModelAndView delete(SingerVO singerVO) {
    ModelAndView mav = new ModelAndView();
    int singerno = singerVO.getSingerno();
    
    String singer = this.singerProc.read(singerno).getName();
    
    mav.addObject("singerno", singerVO.getSingerno());

    int cnt = this.singerProc.delete(singerno);
    
    mav.addObject("cnt", cnt); // request�뿉 ���옣
    mav.addObject("singer", singer);
    
    if (cnt == 1) {
      mav.setViewName("/singer/delete_msg"); // webapp/singer/delete_msg.jsp
    } else {
      mav.setViewName("/singer/delete_msg"); // webapp/singer/delete_msg.jsp
    }

    return mav;
  }
  
  /**
   * 메인이미지 등록폼
   * http://localhost:9090/team1/singer/img_create.do
   * @return
   */
  @RequestMapping(value="/singer/img_create.do", method=RequestMethod.GET)
  public ModelAndView img_create(int singerno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/singer/img_create");
    
    SingerVO singerVO = this.singerProc.read(singerno);
    mav.addObject("singerVO", singerVO);
    
    return mav;
  }
  
  /**
   * 메인이미지 등록 처리
   * http://localhost:9090/team1/singer/create.do
   * @return
   */
  @RequestMapping(value="/singer/img_create.do", method=RequestMethod.POST)
  public ModelAndView img_create(HttpServletRequest request ,SingerVO singerVO) {
    
    ModelAndView mav = new ModelAndView();
    
    
    mav.setViewName("redirect:/singer/read.do?singerno=" + singerVO.getSingerno());
    
    int cnt = 0;             // 수정된 레코드 갯수 
    
    SingerVO vo = this.singerProc.read(singerVO.getSingerno());
    // -------------------------------------------------------------------
    // 파일 전송 코드 시작
    // -------------------------------------------------------------------
    String portrait = "";     // main image
    String thumb1 = ""; // preview image
    long size1 = 0;
    
    String upDir = Tool.getRealPath(request, "/singer/storage/main_images"); // 절대 경로
    
    upDir = Tool.getRealPath(request, "/singer/storage/main_images"); // 절대 경로
    MultipartFile mf = singerVO.getPortraitMF();
    size1 = mf.getSize();  // 파일 크기
    if (size1 > 0) { // 파일 크기 체크
      // mp3 = mf.getOriginalFilename(); // 원본 파일명, spring.jpg
      // 파일 저장 후 업로드된 파일명이 리턴됨, spring.jsp, spring_1.jpg...
      portrait = Upload.saveFileSpring(mf, upDir); 
      if (Tool.isImage(portrait)) { // 이미지인지 검사
        // thumb 이미지 생성후 파일명 리턴됨, width: 200, height: 150
        thumb1 = Tool.preview(upDir, portrait, 200, 150); 
      }
    }
    vo.setPortrait(portrait);
    vo.setThumb1(thumb1);
    vo.setSize1(size1);
    // -------------------------------------------------------------------
    // 파일 전송 코드 종료
    // -------------------------------------------------------------------

    cnt = this.singerProc.img_create(vo);
    mav.addObject("cnt", cnt); // request에 저장
    
    
    return mav;
  }
  
  /**
   * 메인이미지 수정폼
   * http://localhost:9090/team1/singer/img_update.do
   * @return
   */
  @RequestMapping(value="/singer/img_update.do", method=RequestMethod.GET)
  public ModelAndView img_update(int singerno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/singer/img_update");
    
    SingerVO singerVO = this.singerProc.read(singerno);
    mav.addObject("singerVO", singerVO);
    
    return mav;
  }
  
  /**
   * 메인이미지 수정 처리
   * 기존 이미지 삭제후 새로운 이미지 등록(수정 처리)
   * http://localhost:9090/team1/singer/img_update.do
   * @return
   */
  @RequestMapping(value="/singer/img_update.do", method=RequestMethod.POST)
  public ModelAndView img_update(HttpServletRequest request ,
                                                         SingerVO singerVO) {
    ModelAndView mav = new ModelAndView();
    int singerno = singerVO.getSingerno();
    mav.setViewName("redirect:/singer/read.do?singerno=" + singerno);
    
    int cnt = 0;             // 수정된 레코드 갯수 

    // -------------------------------------------------------------------
    // 파일 삭제 코드 시작
    // -------------------------------------------------------------------
    // 삭제할 파일 정보를 읽어옴.
    SingerVO vo = this.singerProc.read(singerno);
    
    String portrait = vo.getPortrait().trim();     // main image
    String thumb1 = vo.getThumb1().trim(); // preview image
    long size1 = 0;
    boolean sw = false;
    
    String upDir = Tool.getRealPath(request, "/singer/storage/main_images"); // 절대 경로
    sw = Tool.deleteFile(upDir, vo.getPortrait());  // Folder에서 1건의 파일 삭제
    sw = Tool.deleteFile(upDir, vo.getThumb1());  // Folder에서 1건의 파일 삭제
    // -------------------------------------------------------------------
    // 파일 삭제 코드 종료
    // -------------------------------------------------------------------
    // -------------------------------------------------------------------
    // 파일 전송 코드 시작
    // -------------------------------------------------------------------
    upDir = Tool.getRealPath(request, "/singer/storage/main_images"); // 절대 경로
    MultipartFile mf = singerVO.getPortraitMF();
    size1 = mf.getSize();  // 파일 크기
    if (size1 > 0) { // 파일 크기 체크
      // mp3 = mf.getOriginalFilename(); // 원본 파일명, spring.jpg
      // 파일 저장 후 업로드된 파일명이 리턴됨, spring.jsp, spring_1.jpg...
      portrait = Upload.saveFileSpring(mf, upDir); 
      if (Tool.isImage(portrait)) { // 이미지인지 검사
        // thumb 이미지 생성후 파일명 리턴됨, width: 200, height: 150
        thumb1 = Tool.preview(upDir, portrait, 200, 150); 
      }
    }
    
    
    vo.setPortrait(portrait);
    vo.setThumb1(thumb1);
    vo.setSize1(size1);
    // -------------------------------------------------------------------
    // 파일 전송 코드 종료
    // -------------------------------------------------------------------
    cnt = this.singerProc.img_update(vo);
    
    mav.addObject("cnt", cnt); // request에 저장
    return mav;
  }
  
  /**
   * 메인이미지 삭제 처리
   * http://localhost:9090/team1/singer/img_delete.do
   * @return
   */
  @RequestMapping(value="/singer/img_delete.do", method=RequestMethod.POST)
  public ModelAndView img_delete(HttpServletRequest request ,
                                                        int singerno) {
    ModelAndView mav = new ModelAndView();
    
    
    mav.setViewName("redirect:/singer/read.do?singerno=" + singerno);
    
    int cnt = 0;             // 수정된 레코드 갯수 

    
    // -------------------------------------------------------------------
    // 파일 삭제 코드 시작
    // -------------------------------------------------------------------
    // 삭제할 파일 정보를 읽어옴.
    SingerVO singerVO = this.singerProc.read(singerno);
    
    String portrait = singerVO.getPortrait().trim();     // main image
    String thumb1 = singerVO.getThumb1().trim(); // preview image
    long size1 = singerVO.getSize1();
    String upDir = Tool.getRealPath(request, "/singer/storage/main_images"); // 절대 경로
    boolean sw = false;
    
    if (portrait.length() > 0) {
      sw = Tool.deleteFile(upDir, singerVO.getPortrait());  // Folder에서 1건의 파일 삭제
    }
    if (thumb1.length() > 0) {
      sw = Tool.deleteFile(upDir, singerVO.getThumb1());  // Folder에서 1건의 파일 삭제
    }
    portrait = "";
    thumb1 = "";
    size1 = 0;
    
    singerVO.setPortrait(portrait);
    singerVO.setThumb1(thumb1);
    singerVO.setSize1(size1);
    // -------------------------------------------------------------------
    // 파일 전송 코드 종료
    // -------------------------------------------------------------------
    
    cnt = this.singerProc.img_delete(singerVO);

    mav.addObject("cnt", cnt); // request에 저장
    
    
    return mav;
  }
  
  /**
   * 좋아요 상향 up
   * @param singerno 조회할 카테고리 번호
   * @return
   */
  @RequestMapping(value="/singer/update_singerrec_up.do",  method=RequestMethod.GET )
  public ModelAndView update_singerrec_up(int singerno) {
    ModelAndView mav = new ModelAndView();
    
    int cnt = this.singerProc.update_singerrec_up(singerno);
    mav.addObject("cnt", cnt); // request에 저장
    
    SingerVO singerVO = this.singerProc.read(singerno);
    mav.addObject("singerVO", singerVO);
    
    mav.setViewName("redirect:/singer/read.do?singerno=" + singerVO.getSingerno());
    
    return mav;
  }
  
  /**
   * 좋아요 하향 down
   * @param reviewcmtno 조회할 카테고리 번호
   * @return
   */
  @RequestMapping(value="/singer/update_singerrec_down.do",  method=RequestMethod.GET )
  public ModelAndView update_singerrec_down(int singerno) {
    ModelAndView mav = new ModelAndView();
    
    int cnt = this.singerProc.update_singerrec_down(singerno);
    mav.addObject("cnt", cnt); // request에 저장
    
    SingerVO singerVO = this.singerProc.read(singerno);
    mav.addObject("singerVO", singerVO);
    
    mav.setViewName("redirect:/singer/read.do?singerno=" + singerVO.getSingerno());
    
    return mav;
  }
  
}
