package dev.mvc.genre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.mvc.music.MusicVO;

@Component("dev.mvc.genre.GenreProc")
public class GenreProc implements GenreProcInter {
  @Autowired
  private GenreDAOInter genreDAO;
  
  public GenreProc() {
    System.out.println("--team1> GenreProc Created !");
  }
  /*      ---------------------------------------------        */
  
  @Override
  public int create(GenreVO genreVO) {
    int cnt = this.genreDAO.create(genreVO);
    
    return cnt;
  }

  @Override
  public List<GenreVO> list() {
    List<GenreVO> list = this.genreDAO.list();
    
    return list;
  }
  
  @Override
  public List<GenreVO> list_seqno_asc() {
    List<GenreVO> list = this.genreDAO.list_seqno_asc();
    return list;
  }


  @Override
  public GenreVO read(int genreno) {
    GenreVO genreVO = this.genreDAO.read(genreno);
    
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

  
}
