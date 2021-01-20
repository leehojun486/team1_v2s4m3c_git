package dev.mvc.singer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dev.mvc.singer.SingerProc")
public class SingerProc implements SingerProcInter {
  @Autowired
  public SingerDAOInter singerDAO;
  
  public SingerProc() {
    System.out.println("--team1> SingerProc Created !");
  }
  /*      ---------------------------------------------        */
  
  @Override
  public int create(SingerVO singerVO) {
    int cnt = this.singerDAO.create(singerVO);
    
    return cnt;
  }

  @Override
  public List<SingerVO> list_singer() {
    List<SingerVO> list = this.singerDAO.list_singer();

    return list;
  }

  @Override
  public SingerVO read(int singerno) {
    SingerVO singerVO = this.singerDAO.read(singerno);
    
    return singerVO;
  }
  
  @Override
  public SingerVO read_update(int singerno) {
    SingerVO singerVO = this.singerDAO.read(singerno);
    
    return singerVO;
  }

  @Override
  public int update(SingerVO singerVO) {
    int cnt = this.singerDAO.update(singerVO);
    
    return cnt;
  }

  @Override
  public int delete(int singerno) {
    int cnt = this.singerDAO.delete(singerno);
    
    return cnt;
  }

 

  
}
