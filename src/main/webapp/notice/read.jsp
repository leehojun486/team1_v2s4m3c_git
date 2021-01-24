<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>Resort world</title>
 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    
<script type="text/javascript">
 
  
</script>
</head> 
 
<body>
<jsp:include page="/menu/top.jsp" />

<DIV class='title_line'>${noticeVO.title}</DIV>
  <DIV class='container '>
      ${noticeVO.contents}
  </DIV>
  <button type='button' 
                    onclick="location.href='./list_all.do'"
                    class="btn btn-info">목록
  </button>
  <button type='button' 
                    onclick="location.href='./update_form.do?noticeno=${noticeVO.noticeno}'"
                    class="btn btn-info">수정
  </button>
  
  <button type='button' 
                    onclick="location.href='./delete.do?noticeno=${noticeVO.noticeno}'"
                    class="btn btn-info">삭제
  </button>
 
<jsp:include page="/menu/bottom.jsp" />
</body>
 
</html> 
 
 
 