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

 
<script type="text/javascript">
  $(function() {
    $('#btn_send').on('click', send);
  });

  function send() {
    var params = $('#frm').serialize();

    var msg = '';
    $.ajax({
      url: './create_ajax.do', // spring execute
      type: 'post',
      cache: false,
      async: true,
      dataType: 'json',
      data: params,
      success: function(rdata) {
        if(rdata.cnt > 0) {
          msg = "『" + $('#genrename').val() + "』 장르를 등록했습니다.";
          msg += " <button type='button' onclick='location.reload(true)'>확인</button>";
        } else {
          msg = "『" + $('#genrename').val() + "』 장르 등록에 실패했습니다.";
        }
        $('#panel1').html(msg);
    }, 
    // Ajax 통신 에러, 응답 코드가 200이 아닌경우, dataType이 다른 경우
    error: function(request, status, error) {
      var msg = 'EEROR\n';
      msg += 'request.status: ' + request.status + '\n';
      msg += 'message: ' + error;
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
  } // </function_send>

  function update_form(genreno) {
    $("#btn_send").off("click");
    $('#btn_send').on('click', update_proc);
        
    var params = 'genreno=' + genreno;

    var msg = '';
    $.ajax({
      url: './read_ajax.do', // spring execute
      type: 'get',  // post, get
      cache: false, // 응답 결과 임시 저장 취소
      async: true,  // true: 비동기 통신
      dataType: 'json', // 응답 형식: json, html, xml...
      data: params,      // 데이터
      success: function(rdata) { // 서버로부터 성공적으로 응답이 온경우
        var frm = $('#frm');
        $('#genreno', frm).val(rdata.genreno);
        $('#genrename', frm).val(rdata.genrename);

        $('#btn_send').html('수정');
        
        $('#panel1').hide(); // 숨기기    
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

  function update_proc() {
    var params = $('#frm').serialize(); // 직렬화, 폼의 데이터를 키와 값의 구조로 조합

    var msg = '';
    $.ajax({
      url: './update_ajax.do', // spring execute
      type: 'post',  // post
      cache: false, // 응답 결과 임시 저장 취소
      async: true,  // true: 비동기 통신
      dataType: 'json', // 응답 형식: json, html, xml...
      data: params,      // 데이터
      success: function(rdata) { // 서버로부터 성공적으로 응답이 온경우
        if (rdata.cnt > 0) {
          msg = "『" + $('#genrename').val() + "』 장르를 수정했습니다."
          msg += " <button type='button' onclick='location.reload(true)'>확인</button>";
        } else {
          msg = "『" + $('#genrename').val() + "』 장르 수정에 실패했습니다."
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

  function delete_form(genreno) { 
    var params = 'genreno=' + genreno;

    var msg = '';
    $.ajax({
      url: './read_ajax.do', // spring execute
      type: 'get',  // post, get
      cache: false, // 응답 결과 임시 저장 취소
      async: true,  // true: 비동기 통신
      dataType: 'json', // 응답 형식: json, html, xml...
      data: params,      // 데이터
      success: function(rdata) { // 서버로부터 성공적으로 응답이 온경우
        if (rdata.genrename.length > 0) {
          msg = "『" + rdata.genrename + "』 장르를 삭제하시겠습니까?<br>";
          msg += "장르를 삭제하면 복구 할 수 없습니다.";
          msg += " <button type=\"button\" onclick=\"delete_proc("+genreno+", '"+rdata.genrename+"')\">삭제 진행</button>";
          msg += " <button type='button' onclick='cancel()'>취소</button>";
        } else {
          msg = "『" + rdata.genrename + "』 장르가 없습니다.";
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
      
    // 처리중 출력
    var gif = '';
    gif +="<div style='margin: 0px auto; text-align: center;'>";
    gif +="  <img src='./images/ani04.gif' style='width: 10%;'>";
    gif +="</div>";
      
    $('#panel1').html(gif);
    $('#panel1').show(); // 출력 */    
  }

  function delete_proc(genreno, genrename) {
    var params = 'genreno=' + genreno;

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
          msg = "『" + genrename + "』 장르를 삭제했습니다."
          msg += " <button type='button' onclick='location.reload(true)'>확인</button>";
        } else {
          msg = "『" + genrename + "』 장르 삭제에 실패했습니다."
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

  
  function cancel() {
    $('#genreno', frm).val(0);
    $('#genrename', frm).val('');

    $('#btn_send').html('등록');

    $('#panel1').html('');
    $('#panel1').hide();
  }
  
  
  
</script>
 
 
</head>
 
<body>
<jsp:include page="/menu/top.jsp" flush='false' />
  <DIV class="title_line">
    등록된 모든 장르
  </DIV>
  
  <ASIDE class="aside_left">
    전체 보기 
  </ASIDE>
  <ASIDE class="aside_right">
  
    <A href="javascript:location.reload();">새로고침</A>
    
  </ASIDE> 
  <DIV class='menu_line'></DIV>
  
  <%-- ajax --%>
  <DIV id='panel_create' style='padding: 10px 0px 10px 0px; background-color: #F9F9F9; width: 100%; text-align: center;'>
    <FORM name='frm' id='frm' method='POST' action=''>
      <!-- <input type='hidden' name='lang' id='lang' value='en'> --> <!-- ko, en -->
      <input type='hidden' name='genreno' id='genreno' value='0'>
              
              
          <%-- <label>장르</label>
      <input type='text' name='genrename' id='genrename' value='장르 입력' required="required" style='width: 25%;'>           --%>
      
       <c:choose>
         <c:when test="${sessionScope.adminid != null}">
      <div class="custom-select" >
      <label>Create Genre</label>
          <select name='genrename' id='genrename'  style='width: 10%;'>
          <option value='Classic' selected="selected">Classic</option>
          <option value='Ballad'>Ballad</option>
          <option value='Rap'>Rap</option>
          <option value='Chill'>Chill</option>
          <option value='Pop'>Pop</option>
          <option value='Rock'>Rock</option>      
      </select>           
      <button type="button" id='btn_send' class="btn btn-secondary">Add</button>
           <button type="button" onclick="history.back()" class="btn btn-info">Quit</button>
      </div>
         </c:when>
     </c:choose>

  
            
  

          
      
 
    </FORM>
    
  </DIV>
  
  <DIV id='panel1' style="width: 40%; text-align: center; margin: 10px auto; display: none;"></DIV> 
  <%-- /ajax --%>
  
  <div style='width: 100%;'>
    <table class="table table-striped" style='width: 100%;'>
      <colgroup>
        <col style="width: 10%;"></col>
        <col style="width: 30%;"></col>
        <col style="width: 15%;"></col>
      </colgroup>
      <%-- table 컬럼 --%>
      <thead>
        <tr>       
        
     <c:choose>
         <c:when test="${sessionScope.adminid != null}">
          <th style='text-align: center;'>장르 번호</th>
         <th style='text-align: center;'>장르명</th>
         <th style='text-align: center;'>기타</th>
         </c:when>
           <c:otherwise>
         <th style='text-align: center;'>장르명</th>
             </c:otherwise>
      </c:choose>
      
      


      
        </tr>
      </thead>
      
      <%-- table 내용 --%>
      <tbody>
        <c:forEach var="genreVO" items="${list }">
          <c:set var="genreno" value="${genreVO.genreno }" />
              <tr> 
      
           <c:choose>
                 <c:when test="${sessionScope.adminid != null}">
                    <td style='text-align: center;'>${genreVO.genreno}</td>
                      <td class="td_bs">
                      <td style='text-align: center;'>
                      <a href="../album/list.do?genreno=${genreno}">${genreVO.genrename}</a> </td> 
                <a href="javascript:update_form(${genreno })" title="수정"><span class="glyphicon glyphicon-pencil"></span></A>
                <a href="javascript:delete_form(${genreno })" title="삭제"><span class="glyphicon glyphicon-trash"></span></A>
                </c:when>
                  <c:otherwise> 
                      <td style='text-align: center;'>
                      <a href="../album/list.do?genreno=${genreno}">${genreVO.genrename}</a> </td> 
                   </c:otherwise>
           </c:choose>
         
         
              
   
              
         
            
            
          <c:choose>
           <c:when test="${sessionScope.adminid != null}">

               </c:when>
           </c:choose>
         
            </td>   
          </tr>
        </c:forEach>
        
      </tbody>
    </table>
    <br><br>
  </div>
 
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
 
</html>