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
  public List<MusicVO> list_by_singerno() {
    List<MusicVO> list = this.musicDAO.list_by_singerno();
    
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
      �럹�씠吏��뿉�꽌 異쒕젰�븷 �떆�옉 �젅肄붾뱶 踰덊샇 怨꾩궛 湲곗�媛�, nowPage�뒗 1遺��꽣 �떆�옉
   1 �럹�씠吏� �떆�옉 rownum: nowPage = 1, (1 - 1) * 10 --> 0 
   2 �럹�씠吏� �떆�옉 rownum: nowPage = 2, (2 - 1) * 10 --> 10
   3 �럹�씠吏� �떆�옉 rownum: nowPage = 3, (3 - 1) * 10 --> 20
   */
  
    int beginOfPage = ((Integer)map.get("nowPage") - 1) * Musics.RECORD_PER_PAGE; // RECORD_PER_PAGE :: 10�쑝濡� �엫�쓽 �꽕�젙�빐�몺
    
    // �떆�옉 rownum 寃곗젙
    // 1 �럹�씠吏� = 0 + 1, 2 �럹�씠吏� = 10 + 1, 3 �럹�씠吏� = 20 + 1 
    int startNum = beginOfPage + 1; 
    
    //  醫낅즺 rownum
    // 1 �럹�씠吏� = 0 + 10, 2 �럹�씠吏� = 0 + 20, 3 �럹�씠吏� = 0 + 30
    int endNum = beginOfPage + Musics.RECORD_PER_PAGE;   
    /*
    1 �럹�씠吏�: WHERE r >= 1 AND r <= 10
    2 �럹�씠吏�: WHERE r >= 11 AND r <= 20
    3 �럹�씠吏�: WHERE r >= 21 AND r <= 30
    */
    map.put("startNum", startNum);
    map.put("endNum", endNum);
   
    List<MusicVO> list = this.musicDAO.list_by_genreno_search_paging(map);
   
    return list;
  }
  
  /** 
   * SPAN�깭洹몃�� �씠�슜�븳 諛뺤뒪 紐⑤뜽�쓽 吏��썝, 1 �럹�씠吏�遺��꽣 �떆�옉 
   * �쁽�옱 �럹�씠吏�: 11 / 22   [�씠�쟾] 11 12 13 14 15 16 17 18 19 20 [�떎�쓬] 
   *
   * @param listFile 紐⑸줉 �뙆�씪紐� 
   * @param genreno �옣瑜대쾲�샇 
   * @param search_count 寃��깋(�쟾泥�) �젅肄붾뱶�닔 
   * @param nowPage     �쁽�옱 �럹�씠吏�
   * @param word 寃��깋�뼱
   * @return �럹�씠吏� �깮�꽦 臾몄옄�뿴
   */ 
  @Override
  public String pagingBox(String listFile, int genreno, int search_count, int nowPage, String word){ 
    int totalPage = (int)(Math.ceil((double)search_count/Musics.RECORD_PER_PAGE)); // �쟾泥� �럹�씠吏�  , ceil :: �삱由�
    int totalGrp = (int)(Math.ceil((double)totalPage/Musics.PAGE_PER_BLOCK));// �쟾泥� 洹몃９ 
    int nowGrp = (int)(Math.ceil((double)nowPage/Musics.PAGE_PER_BLOCK));    // �쁽�옱 洹몃９ 
    int startPage = ((nowGrp - 1) * Musics.PAGE_PER_BLOCK) + 1; // �듅�젙 洹몃９�쓽 �럹�씠吏� 紐⑸줉 �떆�옉  
    int endPage = (nowGrp * Musics.PAGE_PER_BLOCK);             // �듅�젙 洹몃９�쓽 �럹�씠吏� 紐⑸줉 醫낅즺   
     
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
    str.append("    padding:1px 6px 1px 6px; /*�쐞, �삤瑜몄そ, �븘�옒, �쇊履�*/"); 
    str.append("    margin:1px 2px 1px 2px; /*�쐞, �삤瑜몄そ, �븘�옒, �쇊履�*/"); 
    str.append("  }"); 
    str.append("  .span_box_2{"); 
    str.append("    text-align: center;");    
    str.append("    background-color: #668db4;"); 
    str.append("    color: #FFFFFF;"); 
    str.append("    font-size: 1em;"); 
    str.append("    border: 1px;"); 
    str.append("    border-style: solid;"); 
    str.append("    border-color: #cccccc;"); 
    str.append("    padding:1px 6px 1px 6px; /*�쐞, �삤瑜몄そ, �븘�옒, �쇊履�*/"); 
    str.append("    margin:1px 2px 1px 2px; /*�쐞, �삤瑜몄そ, �븘�옒, �쇊履�*/"); 
    str.append("  }"); 
    str.append("</style>"); 
    str.append("<DIV id='paging'>"); 
//    str.append("�쁽�옱 �럹�씠吏�: " + nowPage + " / " + totalPage + "  "); 
 
    // �씠�쟾 10媛� �럹�씠吏�濡� �씠�룞
    // nowGrp: 1 (1 ~ 10 page)
    // nowGrp: 2 (11 ~ 20 page)
    // nowGrp: 3 (21 ~ 30 page) 
    // �쁽�옱 2洹몃９�씪 寃쎌슦: (2 - 1) * 10 = 1洹몃９�쓽 留덉�留� �럹�씠吏� 10
    // �쁽�옱 3洹몃９�씪 寃쎌슦: (3 - 1) * 10 = 2洹몃９�쓽 留덉�留� �럹�씠吏� 20
    int _nowPage = (nowGrp-1) * Musics.PAGE_PER_BLOCK;  
    if (nowGrp >= 2){ 
      str.append("<span class='span_box_1'><A href='"+listFile+"?&word="+word+"&nowPage="+_nowPage+"&genreno="+genreno+"'>�씠�쟾</A></span>"); 
    } 
 
    // 以묒븰�쓽 �럹�씠吏� 紐⑸줉
    for(int i=startPage; i<=endPage; i++){ 
      if (i > totalPage){ // 留덉�留� �럹�씠吏�瑜� �꽆�뼱媛붾떎硫� �럹�씠 異쒕젰 醫낅즺
        break; 
      } 
  
      if (nowPage == i){ // �럹�씠吏�媛� �쁽�옱�럹�씠吏��� 媛숇떎硫� CSS 媛뺤“(李⑤퀎�쓣 �몺)
        str.append("<span class='span_box_2'>"+i+"</span>"); // �쁽�옱 �럹�씠吏�, 媛뺤“ 
      }else{
        // �쁽�옱 �럹�씠吏�媛� �븘�땶 �럹�씠吏��뒗 �씠�룞�씠 媛��뒫�븯�룄濡� 留곹겕瑜� �꽕�젙
        str.append("<span class='span_box_1'><A href='"+listFile+"?word="+word+"&nowPage="+i+"&genreno="+genreno+"'>"+i+"</A></span>");   
      } 
    } 
 
    // 10媛� �떎�쓬 �럹�씠吏�濡� �씠�룞
    // nowGrp: 1 (1 ~ 10 page),  nowGrp: 2 (11 ~ 20 page),  nowGrp: 3 (21 ~ 30 page) 
    // �쁽�옱 1洹몃９�씪 寃쎌슦: (1 * 10) + 1 = 2洹몃９�쓽 �떆�옉�럹�씠吏� 11
    // �쁽�옱 2洹몃９�씪 寃쎌슦: (2 * 10) + 1 = 3洹몃９�쓽 �떆�옉�럹�씠吏� 21
    _nowPage = (nowGrp * Musics.PAGE_PER_BLOCK)+1;  
    if (nowGrp < totalGrp){ 
      str.append("<span class='span_box_1'><A href='"+listFile+"?&word="+word+"&nowPage="+_nowPage+"&genreno="+genreno+"'>�떎�쓬</A></span>"); 
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
