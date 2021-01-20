package dev.mvc.membermusic;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dev.mvc.membermusic.MemberMusicProc")
public class MemberMusicProc implements MemberMusicProcInter {
  @Autowired
  private MemberMusicDAOInter membermusicDAO;
  
  public MemberMusicProc() {
    System.out.println("--team1> MemberMusicProc created !");
  }
  /*--------------------------------*/
  
  @Override
  public int create(MemberMusicVO MemberMusicVO) {
    int cnt = this.membermusicDAO.create(MemberMusicVO);
    
    return cnt;
  }

  @Override
  public List<MemberMusicVO> list() {
    List<MemberMusicVO> list = this.membermusicDAO.list();
    
    return list;
  }
  
  /** @@@@@@ **/
  @Override
  public List<MemberMusicVO> list_memberno() {
    List<MemberMusicVO> list = this.membermusicDAO.list_memberno();
    
    return list;
  }
  
  @Override
  public MemberMusicVO read(int memberno) {
    MemberMusicVO membermusicVO = this.membermusicDAO.read(memberno);
    
    return membermusicVO;
  }

  @Override
  public int delete(HashMap<String, Object> hashMap) {
    int cnt = this.membermusicDAO.delete(hashMap);
    
    return cnt;
  }

}
