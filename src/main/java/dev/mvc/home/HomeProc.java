package dev.mvc.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dev.mvc.home.HomeProc")
public class HomeProc implements HomeProcInter{
  @Autowired
  private HomeDAOInter homeDAO;
  
  public HomeProc() {
    System.out.println("--> homeProc created");
  }
  
  @Override
  public int create(HomeVO homeVO) {
    int cnt = this.homeDAO.create(homeVO);
    return cnt;
  }

  @Override
  public List<HomeVO> list_seqno_asc() {
    List<HomeVO> list = this.homeDAO.list_seqno_asc();
    return list;
  }

  @Override
  public HomeVO read(int homeno) {
    HomeVO homeVO = this.homeDAO.read(homeno);
    return homeVO;
  }

  @Override
  public int update(HomeVO homeVO) {
    int cnt = this.homeDAO.update(homeVO);
    return cnt;
  }

  @Override
  public int delete(int homeno) {
    int cnt = this.homeDAO.delete(homeno);
    return cnt;
  }

}
