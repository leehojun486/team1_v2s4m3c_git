package dev.mvc.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.mvc.member.MemberDAOInter;

@Component("dev.mvc.notice.NoticeProc")

public class NoticeProc implements NoticeProcInter {
  @Autowired
  private NoticeDAOInter NoticeDAO;
  
  @Override
  public int create(NoticeVO noticeVO) {
    int cnt = this.NoticeDAO.create(noticeVO);
    return cnt;
  }

  @Override
  public List<NoticeVO> list_all() {
    List<NoticeVO> list = this.NoticeDAO.list_all();
    return list;
  }

  @Override
  public NoticeVO read(int noticeno) {
    NoticeVO noticeVO = this.NoticeDAO.read(noticeno);
    return noticeVO;
  }

  @Override
  public int update(NoticeVO noticeVO) {
    int cnt = this.NoticeDAO.update(noticeVO);
    return cnt;
  }

  @Override
  public int delete(int noticeno) {
    int cnt = this.NoticeDAO.delete(noticeno);
    return cnt;
  }

}
