<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
// String root = request.getContextPath(); // /resort 
// ${pageContext.request.contextPath}
%>


<link href="css/menu.css" rel="stylesheet" type="text/css">

<!--가로형 3단 드롭다운 메뉴-->

 <!-- 화면 상단 메뉴 -->
  <div id="header">
    <div class="first_header">
      <div class="first_header_inner">
        <ul class="etc">
       <a href="${pageContext.request.contextPath}/member/create.do">Create Account  </a> /
      <a href="${pageContext.request.contextPath}/member/create.do">  Login</a>
        </ul>
      </div>
    </div>
    </div>
<div id="menu">

    <ul class="main1">

        <li><a href="#">Menu</a>

            <ul class="main2">

                <li><a href='${pageContext.request.contextPath}/index.jsp' > 홈</a></li>

                <li><A  href='${pageContext.request.contextPath}/genre/list_all.do'>장르</A></li>


                <li><A  href='${pageContext.request.contextPath}/music/list_all.do'>음악 목록</A></li>


            </ul>

        </li>

       </ul>

</div>
<!-- 화면을 2개로 분할하여 좌측은 메뉴, 우측은 내용으로 구성 -->  
  <DIV class="row" style='margin-top: 2px;'>

    </div>
      




