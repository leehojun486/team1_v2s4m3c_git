package dev.mvc.singer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dev.mvc.singer.SingerProc")
public class SingerProc implements SingerProcInter {
  @Autowired
  public SingerDAOInter singerDAO;
  
  public SingerProc() {
    System.out.println("--> SingerProc Created !");
  }
  /*      ---------------------------------------------        */
  
  @Override
  public int create(SingerVO singerVO) {
    int cnt = this.singerDAO.create(singerVO);
    
    return cnt;
  }

  @Override
  public List<SingerVO> list_singerno_asc() {
    List<SingerVO> list = this.singerDAO.list_singerno_asc();

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
  
  @Override
  public int img_update(SingerVO singerVO) {
    int cnt = this.singerDAO.update_img(singerVO);
    return cnt;
  }
  
  @Override
  public int img_delete(SingerVO singerVO) {
    int cnt = this.singerDAO.update_img(singerVO);
    return cnt;
  }
  
  @Override
  public int img_create(SingerVO singerVO) {
    int cnt = this.singerDAO.update_img(singerVO);
    return cnt;
  }

  @Override
  public int update_singerrec_up(int singerno) {
    int cnt = this.singerDAO.update_singerrec_up(singerno);
    return cnt;
  }
  
  @Override
  public int update_singerrec_down(int singerno) {
    int cnt = this.singerDAO.update_singerrec_down(singerno);
    return cnt;
  }
  
  @Override
  public List<Singer_Singer_Review_join> read_join(int singerno) {
    List<Singer_Singer_Review_join> list = this.singerDAO.read_join(singerno);
    return list;
  }

  
}
