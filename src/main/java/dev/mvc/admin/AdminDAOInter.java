 package dev.mvc.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;




public interface AdminDAOInter {
 
  /**
   * 중복 아이디 검사
   * @param id
   * @return 중복 아이디 갯수
   */
  public int checkID(String adminid);
  /**
   * 회원가입
   * @param MEMBERVO
   * @return 등록된 갯수
   */
  public int create(AdminVO adminVO);
  
  /**
   * 회원 전체 목록
   * @return
   */
  public List<AdminVO> list();
  
  /**
   * 회원 조회
   * @param memberno
   * @return
   */
  public AdminVO read(int adminno);
  
  /**
   * 회원 정보 조회
   * @param memberid
   * @return
   */
  public AdminVO readById(String adminid);
  
  
  /**
  * 수정 처리
  * @param memberVO
  * @return
  */
 public int update(AdminVO adminVO);
 
 /**
  * 회원 삭제 처리
  * @param memberno
  * @return
  */
 public int delete(int adminno);
 
 /**
  * 현재 패스워드 검사
  * @param map
  * @return 0: 일치하지 않음, 1: 일치함
  */
 public int passwd_check(HashMap<String, Object> map);
 
 /**
  * 패스워드 변경
  * @param map
  * @return 변경된 패스워드 갯수
  */
 public int passwd_update(HashMap<String, Object> map);
 
 /**
  * 로그인 처리
  */
 public int login(Map<String, Object> map);
 
 
  
}
