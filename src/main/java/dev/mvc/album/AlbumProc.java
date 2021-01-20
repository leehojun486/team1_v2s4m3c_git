package dev.mvc.album;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dev.mvc.album.AlbumProc")
public class AlbumProc implements AlbumProcInter {
  @Autowired
  private AlbumDAOInter albumDAO;
  
  public AlbumProc() {
    System.out.println("--team1> AlbumProc Created !");
  }
  
  /*      ---------------------------------------------        */
  
  @Override
  public int create(AlbumVO albumVO) {
    int cnt = this.albumDAO.create(albumVO);
    
    return cnt;
  }

  @Override
  public List<AlbumVO> list() {
    List<AlbumVO> list = this.albumDAO.list();
    
    return list;
  }

  @Override
  public AlbumVO read(int albumno) {
    AlbumVO albumVO = this.albumDAO.read(albumno);
    
    return albumVO;
  }

  
}
