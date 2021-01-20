package dev.mvc.singer_review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dev.mvc.singer_review.Singer_reviewProc")
public class Singer_reviewProc implements Singer_reviewProcInter {

  @Autowired
  private Singer_reviewDAOInter singer_reviewDAO;
  
  public Singer_reviewProc() {
    System.out.println("--> Singer_reviewProc created");
  }
  
  @Override
  public int create(Singer_reviewVO singer_reviewVO) {
    int cnt = this.singer_reviewDAO.create(singer_reviewVO);
    return cnt;
  }
  
  @Override
  public List<Singer_reviewVO> list_date_asc() {
    List<Singer_reviewVO> list = this.singer_reviewDAO.list_date_asc();
    return list;
  }
  
  @Override
  public Singer_reviewVO read(int reviewno) {
    Singer_reviewVO singer_reviewVO = this.singer_reviewDAO.read(reviewno);
    return singer_reviewVO;
  }
  
  @Override
  public int update(Singer_reviewVO singer_reviewVO) {
    int cnt = this.singer_reviewDAO.update(singer_reviewVO);
    return cnt;
  }
  

  @Override
  public int delete(int reviewno) {
    int cnt = this.singer_reviewDAO.delete(reviewno);
    return cnt;
  }
  
  @Override
  public int update_reviewrec_up(int reviewno) {
    int cnt = this.singer_reviewDAO.update_reviewrec_up(reviewno);
    return cnt;
  }
  
  @Override
  public int update_reviewrec_down(int reviewno) {
    int cnt = this.singer_reviewDAO.update_reviewrec_down(reviewno);
    return cnt;
  }
  
  @Override
  public int update_reviewcmtcnt_up(int reviewno) {
    int cnt = this.singer_reviewDAO.update_reviewcmtcnt_up(reviewno);
    return cnt;
  }
  
  @Override
  public int update_reviewcmtcnt_down(int reviewno) {
    int cnt = this.singer_reviewDAO.update_reviewcmtcnt_down(reviewno);
    return cnt;
  }
  
}
