<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<style type="text/css">
/* fieldset 전체 적용 */
.genre_music_left{
  width: 100%;
  margin: 0px auto; 
  border-left: none; 
  border-right: none;
  border-top: solid 1px #DDDDDD;  
  border-bottom: solid 1px #DDDDDD;  
  text-align: left;
}
 
/* <UL> 태그에 적용 */
.genre_music_list_left{
  padding-left: 10%; 
  line-height: 20px;
}
 
/* 장르 이름에 적용, Spring에서 사용 */
.genre_name {
  margin-left: 5%;
  font-weight: bold;
  list-style-image: url("${pageContext.request.contextPath}/music/images/genre_img.png");
}
 
/* 음악 제목에 적용, Spring에서 사용 */
.music_name{
  margin-left: 5%;
  list-style-image: url("${pageContext.request.contextPath}/music/images/music_img.png");
}
</style>
 
<fieldset class='genre_music_left' >
  <DIV>
    <A href="${pageContext.request.contextPath}/music/list.do" 
         class='genre_name' style="margin-left: 0.2%;">전체 보기</A>
    <span style='font-size:0.9em; color: #555555;'>(${total_count })</span>
  </DIV>
  <UL class='genre_music_list_left' >
    <c:forEach var="genre_music_name" items="${name_title_list}">
      ${genre_music_name}
    </c:forEach>
  </UL>
</fieldset>
<br>