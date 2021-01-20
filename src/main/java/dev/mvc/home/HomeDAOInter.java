package dev.mvc.home;

import java.util.List;


public interface HomeDAOInter {

  public int create(HomeVO homeVO);
  

  public List<HomeVO> list_seqno_asc();
  

  public HomeVO read(int homeno);
  

  public int update(HomeVO homeVO);
  

  public int delete(int homeno);

}
