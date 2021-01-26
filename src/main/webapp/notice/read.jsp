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
$(function() {
  $('#delete').on('click', del_form);
}); 

function del_form(noticeno){
  var params = $('#frm').serialize();
  alert('params:' + params)

  $.ajax({
      url: './read_ajax.do', // spring execute
      type: 'get',  // post, get
      cache: false, // 응답 결과 임시 저장 취소
      async: true,  // true: 비동기 통신
      dataType: 'json', // 응답 형식: json, html, xml...
      data: params,      // 데이터
      success: function(rdata) { // 서버로부터 성공적으로 응답이 온경우
        if (rdata.title.length > 0) {
          msg = "『" + rdata.title + "』 공지사항을 삭제하시겠습니까?<br>";
          msg += "공지사항을 삭제하면 복구 할 수 없습니다.";
          msg += " <button type=\"button\" onclick=\"delete_proc("+rdata.noticeno+")\">삭제 진행</button>";//, '"+rdata.title+"'
          msg += " <button type=\"button\" onclick='location.reload(true)'>취소</button>";
        } else {
          msg = "『" + rdata.title + "』 공지사항 정보가 없습니다.";
          msg += " <button type='button' onclick='location.reload(true)'>확인</button>";
        }
        $('#panel1').html(msg); // 메시지 출력
      },
      // Ajax 통신 에러, 응답 코드가 200이 아닌경우, dataType이 다른경우 
      error: function(request, status, error) { // callback 함수
        var msg = 'ERROR\n';
        msg += 'request.status: '+request.status + '\n';
        msg += 'message: '+error;
        console.log(msg);
      }
    });
  var gif = '';
  gif +="<div style='margin: 0px auto; text-align: center;'>";
  gif +="  <img src='./images/ani04.gif' style='width: 10%;'>";
  gif +="</div>";
    
  $('#panel1').html(gif);
  $('#panel1').show(); // 출력 */    
}

  function delete_proc(noticeno){
  var params = 'noticeno=' + noticeno;
  var msg = '';
  
  $.ajax({
    url: './delete_ajax.do', // spring execute
    type: 'post',  // post
    cache: false, // 응답 결과 임시 저장 취소
    async: true,  // true: 비동기 통신
    dataType: 'json', // 응답 형식: json, html, xml...
    data: params,      // 데이터
    success: function(rdata) { // 서버로부터 성공적으로 응답이 온경우
      if (rdata.cnt > 0) {
        msg = "공지사항을 삭제했습니다."
        msg += " <button type='button' onclick='location.reload(true)'>확인</button>";
      } else {
        msg = "공지사항 삭제에 실패했습니다."
      }
      $('#panel1').html(msg); // 메시지 출력
    },
    // Ajax 통신 에러, 응답 코드가 200이 아닌경우, dataType이 다른경우 
    error: function(request, status, error) { // callback 함수
      var msg = 'ERROR\n';
      msg += 'request.status: '+request.status + '\n';
      msg += 'message: '+error;
      console.log(msg);
    }
  });
    
  // 처리중 출력
  var gif = '';
  gif +="<div style='margin: 0px auto; text-align: center;'>";
  gif +="  <img src='./images/ani04.gif' style='width: 10%;'>";
  gif +="</div>";
    
  $('#panel1').html(gif);
  $('#panel1').show(); // 출력 */    
}
  
  
  
</script>
</head> 
 
<body>
<jsp:include page="/menu/top.jsp" />

<DIV class='title_line'>${noticeVO.title}</DIV>
<form id='frm' method="get">
<input type='hidden' name='noticeno' id='noticeno' value='${noticeVO.noticeno }'>
</form>
<DIV id='panel1' style="width: 40%; text-align: center; margin: 10px auto;">
</DIV>
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
  
  <button type='button' id='delete'
                    class="btn btn-info">삭제
  </button>
<jsp:include page="/menu/bottom.jsp" />
</body>
 
</html> 
 
 
 