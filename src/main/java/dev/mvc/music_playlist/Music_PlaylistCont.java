package dev.mvc.music_playlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.playlist.PlaylistProcInter;
import dev.mvc.playlist.PlaylistVO;

@Controller
public class Music_PlaylistCont {
  @Autowired
  @Qualifier("dev.mvc.music_playlist.Music_PlaylistProc")
  private Music_PlaylistProcInter music_playlistProc;
  @Autowired
  @Qualifier("dev.mvc.playlist.PlaylistProc")
  private PlaylistProcInter playlistProc;
  

  public Music_PlaylistCont() {
    System.out.println("--> Music_PlaylistCont created.");
  }
  /**
   * ����� http://localhost:9090/team1/music_playlist/create.do
   * 
   * @return
   */
  @RequestMapping(value = "/music_playlist/create.do", method = RequestMethod.GET)
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/music_playlist/create"); // /webapp/music_playlist/create.jsp
    return mav; // forward
  }
  
//  /**
//   * ��� ó�� http://localhost:9090/resort/categrp/create.do
//   * 
//   * @return
//   */
//  @RequestMapping(value = "/music_playlist/create.do", method = RequestMethod.POST)
//  public ModelAndView create(Music_PlaylistVO music_PlaylistVO) {
//    // request.setAttribute("music_PlaylistVO", music_PlaylistVO) �ڵ� ����
//    int playlistno = music_PlaylistVO.getPlaylistno();
//    PlaylistVO playlistVO = this.playlistProc.read(playlistno);
//    int memberno = playlistVO.getmemberno();
//    
//    ModelAndView mav = new ModelAndView();
//    mav.setViewName("/music_playlist/create_msg"); // /webapp/categrp/create_msg.jsp
//    mav.addObject("playlistno", playlistno);
//    mav.addObject("memberno", memberno);
//    int cnt = this.music_playlistProc.create(music_PlaylistVO); // ��� ó��
//    
//    mav.addObject("cnt", cnt); // request.setAttribute("cnt", cnt)
//    return mav; // forward
//  }
  
  /**
   * Ajax ��� ó�� http://localhost:9090/team1/music_playlist/create_ajax.do
   * 
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/music_playlist/create_ajax.do", method = RequestMethod.POST,
      produces = "text/plain;charset=UTF-8")
  public String create_ajax(Music_PlaylistVO music_PlaylistVO) {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    int cnt = this.music_playlistProc.create(music_PlaylistVO); // ��� ó��
    JSONObject json = new JSONObject();
    json.put("cnt", cnt);
    System.out.println("cnt" + cnt);
    return json.toString(); // forward
  }
  /**
   * ��� http://localhost:9090/team1/music_playlist/list_all.do
   * 
   * @return
   */
  @RequestMapping(value = "/music_playlist/list_all.do", method = RequestMethod.GET)
  public ModelAndView list_all() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/music_playlist/list_all"); // /webapp/music_playlist/list.jsp

    List<Music_PlaylistVO> list = this.music_playlistProc.list_music_playlistno_asc();
    mav.addObject("list", list);

    return mav; // forward
    
  }
  /**
   * ��� http://localhost:9090/team1/music_playlist/list.do
   * 
   * @return
   */
  //********************�̵� ���� �ٲܰ�����
//  @RequestMapping(value = "/music_playlist/list.do", method = RequestMethod.GET)
//  public ModelAndView list(int playlistno) {
//    ModelAndView mav = new ModelAndView();
//    mav.setViewName("/music_playlist/list_ajax"); // /webapp/music_playlist/list_ajax.jsp
//    PlaylistVO playlistVO = this.playlistProc.read(playlistno);
//    int memberno = playlistVO.getmemberno();
//    int cnt_music = this.music_playlistProc.count_music(playlistno);
//    mav.addObject("cnt_music", cnt_music);
//    mav.addObject("playlistVO", playlistVO);
//    mav.addObject("memberno", memberno);
//    List<Music_PlaylistVO> list = this.music_playlistProc.list_by_playlistno(playlistno);
//    mav.addObject("list", list);
//    
//    System.out.println("memberno" + memberno);
//    System.out.println("playlistno" + playlistno);
//    System.out.println("cnt_music" + cnt_music);
//
//    return mav; // forward
//  }
  
//  /**
//   * ��� http://localhost:9090/team1/music_playlist/list.do
//   * 
//   * @return
//   */
//  //********************�̵� ���� �ٲܰ�����22222
//  @RequestMapping(value = "/music_playlist/list.do", method = RequestMethod.GET)
//  public ModelAndView list(int playlistno, String m_music) {
//    ModelAndView mav = new ModelAndView();
//    mav.setViewName("/music_playlist/list_ajax_join_search"); // /webapp/music_playlist/list_ajax_join_search.jsp
//    PlaylistVO playlistVO = this.playlistProc.read(playlistno);
//    
//    HashMap<String, Object> map = new HashMap<String, Object>();
//    map.put("playlistno", playlistno); 
//    map.put("m_music", m_music);
//    int memberno = playlistVO.getmemberno();
//    int cnt_music = this.music_playlistProc.count_music(playlistno);
//    mav.addObject("cnt_music", cnt_music);
//    mav.addObject("playlistVO", playlistVO);
//    mav.addObject("memberno", memberno);
//    List<Music_Playlist_Music_joinVO> list = this.music_playlistProc.list_by_join_search(map);
//    mav.addObject("list", list);
//    
//
//    return mav; // forward
//  }
  /**
   * ��� http://localhost:9090/team1/music_playlist/list.do
   * 
   * @return
   */
  //********************�̵� ���� �ٲܰ�����22222
  @RequestMapping(value = "/music_playlist/list.do", method = RequestMethod.GET)
  public ModelAndView list(int playlistno, String m_music,
                                  @RequestParam(value="nowPage", defaultValue="1")int nowPage) {
    System.out.println("--->nowPage" + nowPage);
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/music_playlist/list_ajax_join_search_paging"); // /webapp/music_playlist/list_ajax_join_search.jsp
    PlaylistVO playlistVO = this.playlistProc.read(playlistno);
    
    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("playlistno", playlistno); 
    map.put("m_music", m_music);
    map.put("nowPage", nowPage);
    
    int search_count = music_playlistProc.search_count(map);
    mav.addObject("search_count", search_count);
    
    int memberno = playlistVO.getmemberno();
    int cnt_music = this.music_playlistProc.count_music(playlistno);
    mav.addObject("cnt_music", cnt_music);
    mav.addObject("playlistVO", playlistVO);
    mav.addObject("memberno", memberno);
    String paging = music_playlistProc.pagingBox("list.do", playlistno, m_music, search_count, nowPage);
    mav.addObject("paging", paging);
    mav.addObject("nowPage", nowPage);
    List<Music_Playlist_Music_joinVO> list = this.music_playlistProc.list_by_join_search_paging(map);
    mav.addObject("list", list);
    String youtubeId = "";
    int i = 0;
    List<String> playlist = new ArrayList<>(list.size());
    for (i=0; i<list.size(); i++) {
      youtubeId =list.get(i).getYoutube();
      playlist.add(youtubeId);
    }
    System.out.println("playlist" + playlist);
    mav.addObject("playlist", playlist);
    

    return mav; // forward
  }
  
  
  /**
   * ��ȸ + ������ http://localhost:9090/team1/music_playlist/read_update.do
   * 
   * @return
   */
  @RequestMapping(value = "/music_playlist/read_update.do", method = RequestMethod.GET)
  public ModelAndView read_update(int music_playlistno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/music_playlist/read_update"); // /webapp/music_playlist/read_update.jsp

    Music_PlaylistVO music_PlaylistVO = this.music_playlistProc.read(music_playlistno);
    mav.addObject("music_PlaylistVO", music_PlaylistVO);

    List<Music_PlaylistVO> list = this.music_playlistProc.list_music_playlistno_asc();
    mav.addObject("list", list);

    return mav; // forward
  }
  
  @ResponseBody
  @RequestMapping(value = "/music_playlist/read_ajax.do", method = RequestMethod.GET,
                              produces = "text/plain;charset=UTF-8")
  public String read_ajax(int music_playlistno) {

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Music_PlaylistVO musicPlaylistVO = this.music_playlistProc.read(music_playlistno);

   JSONObject json = new JSONObject();
   System.out.println("�������?");
   //music_playlistno, playlistno, playing_seq, musicno
   json.put("music_playlistno", music_playlistno);
   json.put("playlistno", musicPlaylistVO.getPlaylistno());
   json.put("playing_seq", musicPlaylistVO.getPlaying_seq());
   json.put("musicno", musicPlaylistVO.getMusicno());
   
   return json.toString();
  }
  /**
   * ���� ó��
   * 
   * @param music_PlaylistVO
   * @return
   */
  @RequestMapping(value = "/music_playlist/update.do", method = RequestMethod.POST)
  public ModelAndView update(Music_PlaylistVO music_PlaylistVO) {

    ModelAndView mav = new ModelAndView();

    int cnt = this.music_playlistProc.update(music_PlaylistVO);
    mav.addObject("cnt", cnt); // request�� ����

    mav.setViewName("/music_playlist/update_msg"); // webapp/music_playlist/update_msg.jsp

    return mav;
  }
  /**
   * Ajax ��� ���� ó�� http://localhost:9090/resort/categrp/update_ajax.do
   * 
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/music_playlist/update_ajax.do", method = RequestMethod.POST,
                          produces = "text/plain;charset=UTF-8")
  public String update_ajax(Music_PlaylistVO music_PlaylistVO) {
    
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    int cnt = this.music_playlistProc.update(music_PlaylistVO);
    System.out.println("cnt: " + cnt);
    
    JSONObject json = new JSONObject();
    json.put("cnt", cnt);

    return json.toString();
  }
  /**
   * ������ http://localhost:9090/resort/music_playlist/read_delete.do
   * @return
   */
  @RequestMapping(value = "/music_playlist/read_delete.do", method = RequestMethod.GET)
  public ModelAndView read_delete(int music_playlistno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/music_playlist/read_delete"); // /webapp/music_playlist/read_delete.jsp

    Music_PlaylistVO music_PlaylistVO = this.music_playlistProc.read(music_playlistno);
    mav.addObject("music_PlaylistVO", music_PlaylistVO);

    List<Music_PlaylistVO> list = this.music_playlistProc.list_music_playlistno_asc();
    mav.addObject("list", list);

    return mav; // forward
  }
  /**
   * ���� ó��
   * @param music_playlistno
   * @return
   */
  @RequestMapping(value = "/music_playlist/delete.do", method = RequestMethod.POST)
  public ModelAndView delete(int music_playlistno) {
    ModelAndView mav = new ModelAndView();
    Music_PlaylistVO music_PlaylistVO = this.music_playlistProc.read(music_playlistno);
    mav.addObject("playlistno", music_PlaylistVO.getPlaylistno());
    int cnt = this.music_playlistProc.delete(music_playlistno);
    mav.addObject("cnt", cnt); // request�� ����
    
    

    mav.setViewName("/music_playlist/delete_msg"); // /webapp/music_playlist/delete_msg.jsp

    return mav;
  }
  
  @ResponseBody
  @RequestMapping(value = "/music_playlist/insert.do", method = RequestMethod.POST,
      produces = "text/plain;charset=UTF-8")
  public String insert(Music_PlaylistVO music_PlaylistVO) {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    int cnt = this.music_playlistProc.insert(music_PlaylistVO); // ��� ó��
    JSONObject json = new JSONObject();
    json.put("cnt", cnt);
    System.out.println("cnt" + cnt);
    return json.toString(); // forward
  }
}
