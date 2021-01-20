package dev.mvc.notice;

import java.util.List;

public interface NoticeProcInter {

  /**
   * 공지사항 등록
   * @param noticeVO
   * @return
   */
  public int create(NoticeVO noticeVO);
  
  /**
   * 공지사항 목록
   * @return
   */
  public List<NoticeVO> list_all();
  
  /**
   * 공지사항 조회
   * @param noticeno
   * @return
   */
  public NoticeVO read(int noticeno);
  
  /**
   * 공지사항 수정
   * @param noticeVO
   * @return
   */
  public int update(NoticeVO noticeVO);
  
  /**
   * 공지사항 삭제
   * @param noticeno
   * @return
   */
  public int delete(int noticeno);
  
}
