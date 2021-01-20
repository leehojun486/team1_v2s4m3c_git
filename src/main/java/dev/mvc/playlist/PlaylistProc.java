package dev.mvc.playlist;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dev.mvc.playlist.PlaylistProc")
public class PlaylistProc implements PlaylistProcInter{
  @Autowired
  private PlaylistDAOInter playlistDAO;
  
  public PlaylistProc() {
    System.out.println("--> PlaylistProc created");
  }
  
  @Override
  public int create(PlaylistVO playlistVO) {
    int cnt = this.playlistDAO.create(playlistVO);
    return cnt;
  }

  @Override
  public List<PlaylistVO> list_playlistno_asc() {
    List<PlaylistVO> list = this.playlistDAO.list_playlistno_asc();
    return list;
  }

  @Override
  public PlaylistVO read(int playlistno) {
    PlaylistVO playlistVO = this.playlistDAO.read(playlistno);
    return playlistVO;
  }

  @Override
  public int update(PlaylistVO playlistVO) {
    int cnt = this.playlistDAO.update(playlistVO);
    return cnt;
  }
  
  @Override
  public int user_update(PlaylistVO playlistVO) {
    int cnt = this.playlistDAO.user_update(playlistVO);
    return cnt;
  }

  @Override
  public int delete(int playlistno) {
    int cnt = this.playlistDAO.delete(playlistno);
    return cnt;
  }
  
  @Override
  public int user_delete(HashMap<String, Object> hashMap) {
    int cnt = this.playlistDAO.user_delete(hashMap);
    return cnt;
  }

  @Override
  public int likes_up(int playlistno) {

    int cnt = this.playlistDAO.likes_up(playlistno);
    return cnt;
  }

  @Override
  public List<PlaylistVO> read_by_memberno(int memberno) {
    List<PlaylistVO> playlistVO = this.playlistDAO.read_by_memberno(memberno);
    return playlistVO;
  }

 

  
  
  

}
