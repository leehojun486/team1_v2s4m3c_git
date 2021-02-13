package dev.mvc.music_playlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dev.mvc.music_playlist.Music_PlaylistProc")
public class Music_PlaylistProc implements Music_PlaylistProcInter{
  @Autowired
  private Music_PlaylistDAOInter music_playlistDAO;
  
  public Music_PlaylistProc() {
    System.out.println("--> Music_PlaylistProc created");
  }
  @Override
  public int create(Music_PlaylistVO music_PlaylistVO) {
    int cnt = this.music_playlistDAO.create(music_PlaylistVO);
    return cnt;
  }

  @Override
  public List<Music_PlaylistVO> list_music_playlistno_asc() {
    List<Music_PlaylistVO> list = this.music_playlistDAO.list_music_playlistno_asc();
    return list;
  }

  @Override
  public Music_PlaylistVO read(int music_playlistno) {
    Music_PlaylistVO music_PlaylistVO = this.music_playlistDAO.read(music_playlistno);
    return music_PlaylistVO;
  }

  @Override
  public int update(Music_PlaylistVO music_PlaylistVO) {
    int cnt = this.music_playlistDAO.update(music_PlaylistVO);
    return cnt;
  }

  @Override
  public int delete(int music_playlistno) {
    int cnt = this.music_playlistDAO.delete(music_playlistno);
    return cnt;
  }
  @Override
  public List<Music_PlaylistVO> list_by_playlistno(int playlistno) {
    List<Music_PlaylistVO> list = this.music_playlistDAO.list_by_playlistno(playlistno);
    return list;
  }
  @Override
  public int count_music(int playlistno) {
    int cnt = this.music_playlistDAO.count_music(playlistno);
    return cnt;
  }
  @Override
  public List<Music_Playlist_Music_joinVO> list_by_join(int playlistno) {
    List<Music_Playlist_Music_joinVO> list = this.music_playlistDAO.list_by_join(playlistno);
    return list;
  }
  @Override
  public List<Music_Playlist_Music_joinVO> list_by_join_search(HashMap<String, Object> hashMap) {
    List<Music_Playlist_Music_joinVO> list = music_playlistDAO.list_by_join_search(hashMap);
    return list;
  }

  @Override
  public int search_count(HashMap<String, Object> hashMap) {
    int count = music_playlistDAO.search_count(hashMap);
    return count;
  }
  
  @Override
  public ArrayList<Music_Playlist_Music_joinVO> list_by_join_search_paging(HashMap<String, Object> map) {
    /* 
    ���������� ����� ���� ���ڵ� ��ȣ ��� ���ذ�, nowPage�� 1���� ����
    1 ������ ���� rownum: nowPage = 1, (1 - 1) * 10 --> 0 
    2 ������ ���� rownum: nowPage = 2, (2 - 1) * 10 --> 10
    3 ������ ���� rownum: nowPage = 3, (3 - 1) * 10 --> 20
    */
    int beginOfPage = ((Integer)map.get("nowPage") - 1) * Music_Playlist.RECORD_PER_PAGE;
 // ���� rownum ����
    // 1 ������ = 0 + 1, 2 ������ = 10 + 1, 3 ������ = 20 + 1 
    int startNum = beginOfPage + 1;
    
    //  ���� rownum
    // 1 ������ = 0 + 10, 2 ������ = 0 + 20, 3 ������ = 0 + 30
    int endNum = beginOfPage + Music_Playlist.RECORD_PER_PAGE;   
    /*
    1 ������: WHERE r >= 1 AND r <= 10
    2 ������: WHERE r >= 11 AND r <= 20
    3 ������: WHERE r >= 21 AND r <= 30
    */
    map.put("startNum", startNum);
    map.put("endNum", endNum);
    ArrayList<Music_Playlist_Music_joinVO> list = this.music_playlistDAO.list_by_join_search_paging(map);
    return list;
  }
  
  
  @Override
  public String pagingBox(String listFile, int playlistno, String m_music, int search_count, int nowPage) {
    int totalPage = (int)(Math.ceil((double)search_count/Music_Playlist.RECORD_PER_PAGE)); // ��ü ������  
    
    int totalGrp = (int)(Math.ceil((double)totalPage/Music_Playlist.PAGE_PER_BLOCK));// ��ü �׷� 
    
    int nowGrp = (int)(Math.ceil((double)nowPage/Music_Playlist.PAGE_PER_BLOCK));    // ���� �׷� 
    
    int startPage = ((nowGrp - 1) * Music_Playlist.PAGE_PER_BLOCK) + 1; // Ư�� �׷��� ������ ��� ����  
    
    int endPage = (nowGrp * Music_Playlist.PAGE_PER_BLOCK);             // Ư�� �׷��� ������ ��� ����   
     
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
    str.append("    padding:1px 6px 1px 6px; /*��, ������, �Ʒ�, ����*/"); 
    str.append("    margin:1px 2px 1px 2px; /*��, ������, �Ʒ�, ����*/"); 
    str.append("  }"); 
    str.append("  .span_box_2{"); 
    str.append("    text-align: center;");    
    str.append("    background-color: #668db4;"); 
    str.append("    color: #FFFFFF;"); 
    str.append("    font-size: 1em;"); 
    str.append("    border: 1px;"); 
    str.append("    border-style: solid;"); 
    str.append("    border-color: #cccccc;"); 
    str.append("    padding:1px 6px 1px 6px; /*��, ������, �Ʒ�, ����*/"); 
    str.append("    margin:1px 2px 1px 2px; /*��, ������, �Ʒ�, ����*/"); 
    str.append("  }"); 
    str.append("</style>"); 
    str.append("<DIV id='paging'>"); 
//    str.append("���� ������: " + nowPage + " / " + totalPage + "  "); 
 
    // ���� 10�� �������� �̵�
    // nowGrp: 1 (1 ~ 10 page)
    // nowGrp: 2 (11 ~ 20 page)
    // nowGrp: 3 (21 ~ 30 page) 
    // ���� 2�׷��� ���: (2 - 1) * 10 = 1�׷��� ������ ������ 10
    // ���� 3�׷��� ���: (3 - 1) * 10 = 2�׷��� ������ ������ 20
    int _nowPage = (nowGrp-1) * Music_Playlist.PAGE_PER_BLOCK;  
    if (nowGrp >= 2){ 
      str.append("<span class='span_box_1'><A href='"+listFile+"?nowPage="+_nowPage+"&playlistno="+playlistno+"'>����</A></span>"); 
    } 
 
    // �߾��� ������ ���
    for(int i=startPage; i<=endPage; i++){ 
      if (i > totalPage){ // ������ �������� �Ѿ�ٸ� ���� ��� ����
        break; 
      } 
  
      if (nowPage == i){ // �������� ������������ ���ٸ� CSS ����(������ ��)
        str.append("<span class='span_box_2'>"+i+"</span>"); // ���� ������, ���� 
      }else{
        // ���� �������� �ƴ� �������� �̵��� �����ϵ��� ��ũ�� ����
        str.append("<span class='span_box_1'><A href='"+listFile+"?nowPage="+i+"&playlistno="+playlistno+"'>"+i+"</A></span>");   
      } 
    } 
 
    // 10�� ���� �������� �̵�
    // nowGrp: 1 (1 ~ 10 page),  nowGrp: 2 (11 ~ 20 page),  nowGrp: 3 (21 ~ 30 page) 
    // ���� 1�׷��� ���: (1 * 10) + 1 = 2�׷��� ���������� 11
    // ���� 2�׷��� ���: (2 * 10) + 1 = 3�׷��� ���������� 21
    _nowPage = (nowGrp * Music_Playlist.PAGE_PER_BLOCK)+1;  
    if (nowGrp < totalGrp){ 
      str.append("<span class='span_box_1'><A href='"+listFile+"?nowPage="+_nowPage+"&playlistno="+playlistno+"'>����</A></span>"); 
    } 
    str.append("</DIV>"); 
     
    return str.toString(); 
  }
  @Override
  public int insert(Music_PlaylistVO music_PlaylistVO) {
    int cnt = this.music_playlistDAO.insert(music_PlaylistVO);
    return cnt;
  }
  
  
  
  
  
}
