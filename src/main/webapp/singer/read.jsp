<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>team1. Project</title>

<link href="../css/style.css" rel="Stylesheet" type="text/css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>

<body>
<c:set var="singerno" value="${singerVO.singerno}" />
<c:set var="musicno" value="${musicVO.musicno}" />
<%-- <c:set var="contentsno" value="${contentsVO.contentsno }" /> --%>

<jsp:include page="/menu/top.jsp" flush='false' />
  <DIV class='title_line'>
    가수 조회
  </DIV>
  
  <ASIDE class="aside_left">
    조회 > ${singerVO.singer }
  </ASIDE>
  <ASIDE class="aside_right">
    <A href="./create.do">글 등록</A>
    <span class='menu_divide' > | </span>
    <A href='../attachfile/create.do?contentsno=${contentsno }&cateno=${cateno }'>파일 등록</A>
    <span class='menu_divide' > | </span>
    <A href="javascript:location.reload();">새로고침</A>
    <span class='menu_divide' > | </span> 
    <A href='./list.do?cateno=${cateno }'>목록</A>
    <span class='menu_divide' > | </span> 
    <A href='./update.do?singerno=${singerno }'>수정</A>
    <span class='menu_divide' > | </span> 
    <A href='./delete.do?singerno=${singerno }'>삭제</A>
    
  </ASIDE> 
  
  <div class='menu_line'></div>

  <FORM name='frm' method="get" action='./update.do'>
      <input type="hidden" name="singerno" value="${param.singerno}">
      
      <fieldset class="fieldset">
        <ul>
          <li class="li_none" style='border-bottom: solid 1px #AAAAAA;'>
            <span>가수명 : ${singerVO.singer}</span>
          </li>
          <li class="li_none">
            <span>소속사 : ${singerVO.agency}</span>
          </li>
          <li class="li_none">
            <span>나이 : ${singerVO.age}</span>
          </li>
          <li class="li_none">
            <span>성별 : ${singerVO.sex}</span>
          </li>
          <li class="li_none">
            <%-- <DIV style='text-decoration: none;'>
              검색어(키워드): ${singerVO. } IP: ${contentsVO.ip }
            </DIV> --%>
          </li>
        </ul>
      </fieldset>
  </FORM>


<!-- -- -->
<DIV class='menu_line'></DIV>
  
  <div style='width: 100%;'>
    <table class="table table-striped" style='width: 100%;'>
      <colgroup>
        <col style="width: 17%;"></col>
        <col style="width: 15%;"></col>
        <col style="width: 10%;"></col>
        <col style="width: 15%;"></col>  
        <col style="width: 8%;"></col>
        <col style="width: 12%;"></col>
                
      </colgroup>
      <%-- table 컬럼 --%>
      <thead>
        <tr>
          <th style='text-align: center;'>음악명</th>
          <th style='text-align: center;'>앨범명</th>
          
          <th style='text-align: center;'>장르</th>
          <th style='text-align: center;'>등록일</th>
          <th style='text-align: center;'>좋아요</th>
          <th style='text-align: center;'>재생시간</th>
          
        </tr>
      
      </thead>
       
      <%-- table 내용 --%>
      <tbody>
        <c:forEach var="musicVO" items="${list }">
          <c:set var="singerno" value="${param.singerno }" /> 
          <tr> 
            <td>
              <a href="../music/read.do?musicno=${musicVO.musicno }">${musicVO.title}</a> 
            </td> 
          <td style='text-align: center;'>${musicVO.album}</td>
          
          <td style='text-align: center;'>${musicVO.genre}</td>
          <td style='text-align: center;'>${musicVO.rdate.substring(0, 10)}</td>
          <td style='text-align: center;'>${musicVO.likesu}</td>
          <td style='text-align: center;'>${musicVO.musiclong}</td>
          </tr>
        </c:forEach>
        
      </tbody>
    </table>
    <br><br>
  </div>




<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>

</html>