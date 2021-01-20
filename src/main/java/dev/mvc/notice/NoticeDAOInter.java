package dev.mvc.notice;

import java.util.List;

import dev.mvc.member.MemberVO;

public interface NoticeDAOInter {
  
  /**
   * �������� ���
   * @param noticeVO
   * @return
   */
  public int create(NoticeVO noticeVO);
  
  /**
   * �������� ���
   * @return
   */
  public List<NoticeVO> list_all();
  
  /**
   * �������� ��ȸ
   * @param noticeno
   * @return
   */
  public NoticeVO read(int noticeno);
  
  /**
   * �������� ����
   * @param noticeVO
   * @return
   */
  public int update(NoticeVO noticeVO);
  
  /**
   * �������� ����
   * @param noticeno
   * @return
   */
  public int delete(int noticeno);
  

}
