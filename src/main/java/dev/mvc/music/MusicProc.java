package dev.mvc.music;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dev.mvc.music.MusicProc")
public class MusicProc implements MusicProcInter {
  @Autowired
  private MusicDAOInter musicDAO;
  
  public MusicProc() {
    System.out.println("--team1> MusicProc created!");
  }
  
  /*-----------------------------------------------*/
  
  @Override
  public int create(MusicVO musicVO) {
    int cnt = this.musicDAO.create(musicVO);
    
    return cnt;
  }

  @Override
  public List<MusicVO> list() {
    List<MusicVO> list = this.musicDAO.list();

    return list;
  }
  
  @Override
  public List<MusicVO> list_by_singerno(int singerno) {
    List<MusicVO> list = this.musicDAO.list_by_singerno(singerno);
    
    return list;
  }
  
  @Override  
  public List<MusicVO> list_seqno_asc() {
    List<MusicVO> list = this.musicDAO.list_seqno_asc();
    return list;
  }

  @Override
  public MusicVO read(int musicno) {
    MusicVO musicVO = this.musicDAO.read(musicno);
    
    return musicVO;
  }

  /*
   * @Override public int add_likelist(MusicVO musicVO) {
   * musicVO.setLikelist("Y");
   * 
   * int cnt = this.musicDAO.add_likelist(musicVO);
   * 
   * return cnt; }
   */

  /*
   * @Override public int delete_likelist(MusicVO musicVO) {
   * musicVO.setLikelist("N");
   * 
   * int cnt = this.musicDAO.add_likelist(musicVO);
   * 
   * return cnt; }
   */

  @Override
  public List<MusicVO> list_search(MusicVO musicVO) {
    List<MusicVO> list = musicDAO.list_search(musicVO);
    
    return list;
  }
  
  @Override
  public List<Genre_Music_Join> list_join() {
    List<Genre_Music_Join> list = this.musicDAO.list_join();
    return list;
  }
  
  @Override
  public List<Genre_Music_Join> list_join_by_genreno(int genreno) {
    List<Genre_Music_Join> list = this.musicDAO.list_join_by_genreno(genreno);
    return list;
  }
  
  @Override
  public int total_count() {
    int cnt = this.musicDAO.total_count();
    return cnt;
  }
  
  @Override
  public int search_count(HashMap<String, Object> hashMap) {
    int count = musicDAO.search_count(hashMap);
    return count;
  }

  @Override
  public List<MusicVO> list_by_genreno_search_paging(HashMap<String, Object> map) {
  /* 
      페이지에서 출력할 시작 레코드 번호 계산 기준값, nowPage는 1부터 시작
   1 페이지 시작 rownum: nowPage = 1, (1 - 1) * 10 --> 0 
   2 페이지 시작 rownum: nowPage = 2, (2 - 1) * 10 --> 10
   3 페이지 시작 rownum: nowPage = 3, (3 - 1) * 10 --> 20
   */
  
    int beginOfPage = ((Integer)map.get("nowPage") - 1) * Musics.RECORD_PER_PAGE; // RECORD_PER_PAGE :: 10으로 임의 설정해둠
    
    // 시작 rownum 결정
    // 1 페이지 = 0 + 1, 2 페이지 = 10 + 1, 3 페이지 = 20 + 1 
    int startNum = beginOfPage + 1; 
    
    //  종료 rownum
    // 1 페이지 = 0 + 10, 2 페이지 = 0 + 20, 3 페이지 = 0 + 30
    int endNum = beginOfPage + Musics.RECORD_PER_PAGE;   
    /*
    1 페이지: WHERE r >= 1 AND r <= 10
    2 페이지: WHERE r >= 11 AND r <= 20
    3 페이지: WHERE r >= 21 AND r <= 30
    */
    map.put("startNum", startNum);
    map.put("endNum", endNum);
   
    List<MusicVO> list = this.musicDAO.list_by_genreno_search_paging(map);
   
    return list;
  }
  
  /** 
   * SPAN태그를 이용한 박스 모델의 지원, 1 페이지부터 시작 
   * 현재 페이지: 11 / 22   [이전] 11 12 13 14 15 16 17 18 19 20 [다음] 
   *
   * @param listFile 목록 파일명 
   * @param genreno 장르번호 
   * @param search_count 검색(전체) 레코드수 
   * @param nowPage     현재 페이지
   * @param word 검색어
   * @return 페이징 생성 문자열
   */ 
  @Override
  public String pagingBox(String listFile, int genreno, int search_count, int nowPage, String word){ 
    int totalPage = (int)(Math.ceil((double)search_count/Musics.RECORD_PER_PAGE)); // 전체 페이지  , ceil :: 올림
    int totalGrp = (int)(Math.ceil((double)totalPage/Musics.PAGE_PER_BLOCK));// 전체 그룹 
    int nowGrp = (int)(Math.ceil((double)nowPage/Musics.PAGE_PER_BLOCK));    // 현재 그룹 
    int startPage = ((nowGrp - 1) * Musics.PAGE_PER_BLOCK) + 1; // 특정 그룹의 페이지 목록 시작  
    int endPage = (nowGrp * Musics.PAGE_PER_BLOCK);             // 특정 그룹의 페이지 목록 종료   
     
    StringBuffer str = new StringBuffer(); 
     
    str.append("<style type='text/css'>"); 
    str.append("  #paging {text-align: center; margin-top: 5px; font-size: 1em;}"); 
    str.append("  #paging A:link {text-decoration:none; color:black; font-size: 1em;}"); 
    str.append("  #paging A:hover{text-decoration:none; background-color: #FFFFFF; color:black; font-size: 1em;}"); 
    str.append("  #paging A:visited {text-decoration:none;color:black; font-size: 1em;}"); 
    str.append("  .span_box_1{"); 
    str.append("    text-align: center;");    
    str.append("    font-size: 1em;"); 
    str.append("    border: 1px;"); 
    str.append("    border-style: solid;"); 
    str.append("    border-color: #cccccc;"); 
    str.append("    padding:1px 6px 1px 6px; /*위, 오른쪽, 아래, 왼쪽*/"); 
    str.append("    margin:1px 2px 1px 2px; /*위, 오른쪽, 아래, 왼쪽*/"); 
    str.append("  }"); 
    str.append("  .span_box_2{"); 
    str.append("    text-align: center;");    
    str.append("    background-color: #668db4;"); 
    str.append("    color: #FFFFFF;"); 
    str.append("    font-size: 1em;"); 
    str.append("    border: 1px;"); 
    str.append("    border-style: solid;"); 
    str.append("    border-color: #cccccc;"); 
    str.append("    padding:1px 6px 1px 6px; /*위, 오른쪽, 아래, 왼쪽*/"); 
    str.append("    margin:1px 2px 1px 2px; /*위, 오른쪽, 아래, 왼쪽*/"); 
    str.append("  }"); 
    str.append("</style>"); 
    str.append("<DIV id='paging'>"); 
//    str.append("현재 페이지: " + nowPage + " / " + totalPage + "  "); 
 
    // 이전 10개 페이지로 이동
    // nowGrp: 1 (1 ~ 10 page)
    // nowGrp: 2 (11 ~ 20 page)
    // nowGrp: 3 (21 ~ 30 page) 
    // 현재 2그룹일 경우: (2 - 1) * 10 = 1그룹의 마지막 페이지 10
    // 현재 3그룹일 경우: (3 - 1) * 10 = 2그룹의 마지막 페이지 20
    int _nowPage = (nowGrp-1) * Musics.PAGE_PER_BLOCK;  
    if (nowGrp >= 2){ 
      str.append("<span class='span_box_1'><A href='"+listFile+"?&word="+word+"&nowPage="+_nowPage+"&genreno="+genreno+"'>이전</A></span>"); 
    } 
 
    // 중앙의 페이지 목록
    for(int i=startPage; i<=endPage; i++){ 
      if (i > totalPage){ // 마지막 페이지를 넘어갔다면 페이 출력 종료
        break; 
      } 
  
      if (nowPage == i){ // 페이지가 현재페이지와 같다면 CSS 강조(차별을 둠)
        str.append("<span class='span_box_2'>"+i+"</span>"); // 현재 페이지, 강조 
      }else{
        // 현재 페이지가 아닌 페이지는 이동이 가능하도록 링크를 설정
        str.append("<span class='span_box_1'><A href='"+listFile+"?word="+word+"&nowPage="+i+"&genreno="+genreno+"'>"+i+"</A></span>");   
      } 
    } 
 
    // 10개 다음 페이지로 이동
    // nowGrp: 1 (1 ~ 10 page),  nowGrp: 2 (11 ~ 20 page),  nowGrp: 3 (21 ~ 30 page) 
    // 현재 1그룹일 경우: (1 * 10) + 1 = 2그룹의 시작페이지 11
    // 현재 2그룹일 경우: (2 * 10) + 1 = 3그룹의 시작페이지 21
    _nowPage = (nowGrp * Musics.PAGE_PER_BLOCK)+1;  
    if (nowGrp < totalGrp){ 
      str.append("<span class='span_box_1'><A href='"+listFile+"?&word="+word+"&nowPage="+_nowPage+"&genreno="+genreno+"'>다음</A></span>"); 
    } 
    str.append("</DIV>"); 
     
    return str.toString(); 
  }

  @Override
  public int update(MusicVO musicVO) {
    int cnt = this.musicDAO.update(musicVO);
    return cnt;
  }

  @Override
  public int passwd_check(HashMap<String, Object> hashmap) {
    int passwd_cnt = this.musicDAO.passwd_check(hashmap);
    return passwd_cnt;
  }

  @Override
  public int delete(int musicno) {
    int cnt = this.musicDAO.delete(musicno);
    return cnt;
  }

}
