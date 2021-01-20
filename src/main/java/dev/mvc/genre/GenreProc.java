package dev.mvc.genre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dev.mvc.genre.GenreProc")
public class GenreProc implements GenreProcInter{
  @Autowired
  private GenreDAOInter genreDAO;
  
  public GenreProc() {
    System.out.println("--> genreProc created");
  }
  
  @Override
  public int create(GenreVO genreVO) {
    int cnt = this.genreDAO.create(genreVO);
    return cnt;
  }

  @Override
  public List<GenreVO> list_genreno_asc() {
    List<GenreVO> list = this.genreDAO.list_genreno_asc();
    return list;
  }
  @Override
  public List<GenreVO> list_by_homeno(int homeno) {
    List<GenreVO> list = this.genreDAO.list_by_homeno(homeno);
    return list;
  }

  @Override
  public GenreVO read(String genrename) {
    GenreVO genreVO = this.genreDAO.read(genrename);
    return genreVO;
  }

  @Override
  public int update(GenreVO genreVO) {
    int cnt = this.genreDAO.update(genreVO);
    return cnt;
  }

  @Override
  public int delete(int genreno) {
    int cnt = this.genreDAO.delete(genreno);
    return cnt;
  }

  @Override
  public List<Home_Genre_join> list_join() {
    List<Home_Genre_join> list=this.genreDAO.list_join();
    return list;
  }

  @Override
  public List<Home_Genre_join> list_join_by_homeno(int homeno) {
    List<Home_Genre_join> list=this.genreDAO.list_join_by_homeno(homeno);
    return list;
  }

}
