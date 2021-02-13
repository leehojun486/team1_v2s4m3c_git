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
  
});

  function insert(playlistno){
    var params = 'musicno=' + $('#musicno', frm).val() + "&";
    params += 'playing_seq=' + $('#playing_seq', frm).val() + "&"; // 직렬화, 폼의 데이터를 키와 값의 구조로 조합
    params += 'playlistno=' + playlistno;
    alert(params);

    var msg = '';
    $.ajax({
      url: '../music_playlist/insert.do', // spring execute
      type: 'post',  // post
      cache: false, // 응답 결과 임시 저장 취소
      async: true,  // true: 비동기 통신
      dataType: 'json', // 응답 형식: json, html, xml...
      data: params,      // 데이터
      success: function(rdata) { // 서버로부터 성공적으로 응답이 온경우
        alert('dd')
        if (rdata.cnt > 0) {
          msg = "음악 추가에 성공했습니다."
          msg += " <button type='button' onclick='location.reload(true)'>확인</button>";
        } else {
          msg = "음악 추가에 실패했습니다."
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
 
  <DIV class='title_line'>음악을 추가할 플레이 리스트를 선택하세요.</DIV>
  <FORM name='frm' id='frm' method='POST' action=''>
    <input type='hidden' name='musicno' id='musicno' value='${param.musicno }'>
    <input type='hidden' name='playing_seq' id='playing_seq' value=1>
  </FORM>
  <DIV id='panel1' style="width: 40%; text-align: center; margin: 10px auto; display: none;">
  </DIV>
 

 
  
<TABLE class='table table-striped'>
  <colgroup>
    <col style='width: 10%;'/>
    <col style='width: 40%;'/>
    <col style='width: 20%;'/>
    <col style='width: 10%;'/>    
    <col style='width: 20%;'/>
  </colgroup>
 
  <thead>  
  <TR>
    <TH class="th_bs">플레이 리스트 이름</TH>
  </TR>
  </thead>
  
  <tbody>
  <c:forEach var="playlistVO" items="${list}">
    <c:set var="playlistno" value="${playlistVO.playlistno }" />
    <TR>
      <TD class="td_bs">${playlistVO.playlistname }</TD>
      
      <TD class="td_bs">
        <A href="javascript:insert(${playlistVO.playlistno})" title="수정"><span class="glyphicon glyphicon-pencil"></span></A>
      </TD>   
    </TR>   
  </c:forEach> 
  </tbody>
</TABLE>
 
 
<jsp:include page="/menu/bottom.jsp" />
</body>
 
</html> 
 
 
 