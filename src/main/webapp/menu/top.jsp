<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
// String root = request.getContextPath(); // /resort 
// ${pageContext.request.contextPath}
%>

<link href="css/style.css" rel="stylesheet" type="text/css">

<!--가로형 3단 드롭다운 메뉴-->

 <!-- 화면 상단 메뉴 -->
  <div id="header">
    <div class="first_header">
      <div class="first_header_inner">
        <ul class="etc">
           <c:choose>
        <c:when test="${sessionScope.id == null}">
       <a href="${pageContext.request.contextPath}/member/create.do">Create Account  </a> /
       <a href="${pageContext.request.contextPath}/member/login.do">  Login</a>
          </c:when>
        <c:otherwise>
            ${sessionScope.id } <a   href='${pageContext.request.contextPath}/member/logout.do' >Logout</A>
        </c:otherwise>
      </c:choose>      
        </ul>
      </div>
    </div>
    </div>

  <div class="menu">
    <ul>
      <li><a class="active" href="http://localhost:9090/team1/">Home</a></li>
      <li><a href="${pageContext.request.contextPath}/playlist/list.do/list.do">Stream</a></li>
      <li><a href="${pageContext.request.contextPath}/notice/list_all.do">Notice</a></li>
      <li><a href="${pageContext.request.contextPath}/faq/list_all.do ">FAQ</a></li>

      
    </ul>
</div>
<!-- 화면을 2개로 분할하여 좌측은 메뉴, 우측은 내용으로 구성 -->  
  <DIV class="row" style='margin-top: 2px;'>

    </div>
      




