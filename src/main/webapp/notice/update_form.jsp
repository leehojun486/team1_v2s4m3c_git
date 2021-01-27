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
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<script type="text/javascript">

$(function(){
  CKEDITOR.replace('contents');  // <TEXTAREA>태그 id 값
  $('#submit').on('click', rep);
});
function rep(){
  var str = $('#contents').val();
  str = str.replace(/(?:\r\n|\r|\n)/g, '<br>');
  $('#contents').val(str);
}
  
</script>
</head> 
 
<body>
<jsp:include page="/menu/top.jsp" />

<DIV class='title_line'>${noticeVO.title}</DIV>
<FORM name='update' id='frm_update' method='POST' action='./update.do'>
      <input type='hidden' name='noticeno' id='noticeno' value='${noticeVO.noticeno }'>
      <label>공지사항 제목</label>
      <p>
      <input type="text" name='title' value='${noticeVO.title }'>
      <div>
      <label>공지사항 내용</label>
      <p>
      <textarea rows="10" cols="30" style="width: 80%" name='contents' id='contents'></textarea>
      </div>
      <button type="submit" id='submit'>저장</button>
      <button type="button" onclick="location.href='./read.do?${noticeVO.noticeno }'">취소</button>
</FORM>
  <button type='button' 
                    onclick="location.href='./list_all.do'"
                    class="btn btn-info">목록
  </button>
  
 
<jsp:include page="/menu/bottom.jsp" />
</body>
 
</html> 
 
 
 