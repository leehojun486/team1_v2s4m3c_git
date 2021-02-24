package dev.mvc.music;

import java.util.HashMap;
import java.util.List;

public interface MusicProcInter {

  /**
   * �깮�꽦 :: <Xmp> <insert id="create" parameterType="MusicVO"> </Xmp>
   * 
   * @param musicVO
   * @return
   */
  public int create(MusicVO musicVO);

  /**
   * 紐⑸줉議고쉶 :: <Xmp> <select id="list" resultType="MusicVO"> </Xmp>
   * 
   * @return
   */
  public List<MusicVO> list();

  /**
   * 媛��닔踰덊샇濡� 紐⑸줉議고쉶 <Xmp> <select id="list_by_singerno" resultType="MusicVO"> </Xmp>
   * 
   * @param singerno
   * @return
   */
  public List<MusicVO> list_by_singerno();

  /**
   * 紐⑸줉 - 異쒕젰�닚�꽌 �젙�젹 :: <select id="list_seqno_asc" resultType="MusicVO">
   * 
   * @return
   */
  public List<MusicVO> list_seqno_asc();

  /**
   * 湲� �씫湲� :: <Xmp> <select id="read" resultType="MusicVO" parameterType="int">
   * </Xmp>
   * 
   * @param musicno
   * @return
   */
  public MusicVO read(int musicno);

  /** 
   * 醫뗭븘�슂 由ъ뒪�듃 異붽��븯湲� 
   * 
   * @param musicVO
   * @return
   */
  /* public int add_likelist(MusicVO musicVO); */

  /**
   * 醫뗭븘�슂 由ъ뒪�듃 �궘�젣�븯湲�
   * 
   * @param musicVO
   * @return
   */
  /* public int delete_likelist(MusicVO musicVO); */

  /**
   * 寃��깋 紐⑸줉
   * 
   * @param MusicVO
   * @return
   */
  public List<MusicVO> list_search(MusicVO musicVO);

  /**
   * �넻�빀 VO 湲곕컲 join
   * 
   * @return
   */
  public List<Genre_Music_Join> list_join();

  /**
   * �넻�빀 VO 湲곕컲 join
   * 
   * @return
   */
  public List<Genre_Music_Join> list_join_by_genreno(int genreno);

  /**
   * �쟾泥� �젅肄붾뱶 媛��닔
   * 
   * @return
   */
  public int total_count();

  /**
   * �옣瑜대퀎 寃��깋 �젅肄붾뱶 媛��닔
   * 
   * @param hashMap
   * @return
   */
  public int search_count(HashMap<String, Object> hashMap);

  /**
   * 寃��깋 + �럹�씠吏� 紐⑸줉
   * 
   * @param map
   * @return
   */
  public List<MusicVO> list_by_genreno_search_paging(HashMap<String, Object> map);

  /**
   * �럹�씠吏� 紐⑸줉 臾몄옄�뿴 �깮�꽦, Box �삎�깭
   * 
   * @param listFile     紐⑸줉 �뙆�씪紐�
   * @param genreno      移댄뀒怨좊━踰덊샇
   * @param search_count 寃��깋 媛��닔
   * @param nowPage      �쁽�옱 �럹�씠吏�, nowPage�뒗 1遺��꽣 �떆�옉
   * @param word         寃��깋�뼱
   * @return
   */
  public String pagingBox(String listFile, int genreno, int search_count, int nowPage, String word);
  
  /**
   * �닔�젙 泥섎━
   * @param musicVO
   * @return
   */
  public int update(MusicVO musicVO);

  /**
   * �뙣�뒪�썙�뱶 寃��궗
   * 
   * @param hashmap
   * @return
   */
  public int passwd_check(HashMap<String, Object> hashmap);

  /**
   * �궘�젣
   * 
   * @param musicno
   * @return
   */
  public int delete(int musicno);

}
