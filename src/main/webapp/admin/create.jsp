<%@ page contentType="text/html; charset=UTF-8" %>


<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>Resort world</title>

<link href="../css/style.css" rel="Stylesheet" type="text/css">

<script type="text/JavaScript"
          src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
  $(function() { // 자동 실행
    // id가 'btn_send'인 태그를 찾아 'click' 이벤트 처리자(핸들러)로 send 함수를 등록
    $('#btn_checkID').on('click', checkID);  
    // document.getElementById('btn_checkID').addEventListener('click', checkID); 동일
    $('#btn_close').on('click', setFocus); // Dialog창을 닫은후의 focus 이동
    $('#btn_send').on('click', send); 
  });

  // jQuery ajax 요청
  function checkID() {
    // $('#btn_close').attr("data-focus", "이동할 태그 지정");
    
    var frm = $('#frm'); // id가 frm인 태그 검색
    var adminid = $('#adminid', frm).val(); // frm 폼에서 id가 'id'인 태그 검색
    var params = '';
    var msg = '';

    if ($.trim(adminid).length == 0) { // id를 입력받지 않은 경우
      msg = 'ID를 입력하세요.<br>ID 입력은 필수 입니다.<br>ID는 3자이상 권장합니다.';
      
      $('#modal_content').attr('class', 'alert alert-danger'); // Bootstrap CSS 변경
      $('#modal_title').html('ID 중복 확인'); // 제목 
      $('#modal_content').html(msg);        // 내용
      $('#modal_panel').modal();              // 다이얼로그 출력
      return false;
    } else {  // when ID is entered
      params = 'adminid=' + adminid;
      // var params = $('#frm').serialize(); // 직렬화, 폼의 데이터를 키와 값의 구조로 조합
      // alert('params: ' + params);

      $.ajax({
        url: './checkID.do', // spring execute
        type: 'get',  // post
        cache: false, // 응답 결과 임시 저장 취소
        async: true,  // true: 비동기 통신
        dataType: 'json', // 응답 형식: json, html, xml...
        data: params,      // 데이터
        success: function(rdata) { // 서버로부터 성공적으로 응답이 온경우
          // alert(rdata);
          var msg = "";
          
          if (rdata.cnt > 0) {
            $('#modal_content').attr('class', 'alert alert-danger'); // Bootstrap CSS 변경
            msg = "이미 사용중인 ID 입니다.";
            $('#btn_close').attr("data-focus", "adminid");
          } else {
            $('#modal_content').attr('class', 'alert alert-success'); // Bootstrap CSS 변경
            msg = "사용 가능한 ID 입니다.";
            $('#btn_close').attr("data-focus", "adminpass");
            // $.cookie('checkId', 'TRUE'); // Cookie 기록
          }
          
          $('#modal_title').html('ID 중복 확인'); // 제목 
          $('#modal_content').html(msg);        // 내용
          $('#modal_panel').modal();              // 다이얼로그 출력
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
  /*     var gif = '';
      gif +="<div style='margin: 0px auto; text-align: center;'>";
      gif +="  <img src='./images/ani04.gif' style='width: 10%;'>";
      gif +="</div>";
      
      $('#panel2').html(gif);
      $('#panel2').show(); // 출력 */
      
    }

  }

  function setFocus() {  // focus 이동
    var tag = $('#btn_close').attr('data-focus'); // 포커스를 적용할 태그 id 가져오기
    $('#' + tag).focus(); // 포커스 지정
  }

  function send() { // 회원 가입 처리
    // 패스워드를 정상적으로 2번 입력했는지 확인
    if ($('#adminpass').val() != $('#adminpass2').val()) {
      msg = '입력된 패스워드가 일치하지 않습니다.<br>';
      msg += "패스워드를 다시 입력해주세요.<br>"; 
      
      $('#modal_content').attr('class', 'alert alert-danger'); // CSS 변경
      $('#modal_title').html('패스워드 일치 여부  확인'); // 제목 
      $('#modal_content').html(msg);  // 내용
      $('#modal_panel').modal();         // 다이얼로그 출력
      
      $('#btn_send').attr('data-focus', 'passwd');
      
      return false; // submit 중지
    }

    $('#frm').submit();
  }
</script>
</head> 


<body>
<jsp:include page="/menu/top.jsp" flush='false' />

  <!-- ********** Modal 알림창 시작 ********** -->
  <div id="modal_panel" class="modal fade"  role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">×</button>
          <h4 class="modal-title" id='modal_title'></h4><!-- 제목 -->
        </div>
        <div class="modal-body">
          <p id='modal_content'></p>  <!-- 내용 -->
        </div>
        <div class="modal-footer">
          <button type="button" id="btn_close" data-focus="" class="btn btn-default" 
                      data-dismiss="modal">닫기</button>
        </div>
      </div>
    </div>
  </div>
  <!-- ********** Modal 알림창 종료 ********** -->

  <DIV class='title_line'>
    회원 가입
  </DIV>

  <ASIDE class="aside_left">
      *: 필수 입력  
  </ASIDE>
  <ASIDE class="aside_right">
    <A href="javascript:location.reload();">새로고침</A>
    <span class='menu_divide' >│</span> 
    <A href='./create.do'>관리자 가입</A>
    <span class='menu_divide' >│</span> 
    <A href='./create.do'>목록</A>
  </ASIDE> 

  <div class='menu_line'></div>
  
  <FORM name='frm' id='frm' method='POST' action='./create.do' class="form-horizontal"enctype="multipart/form-data">>

    <div class="form-group">
      <label for="adminid" class="col-md-2 control-label" style='font-size: 0.9em;'>아이디*</label>    
      <div class="col-md-10">
        <input type='text' class="form-control" name='adminid' id='adminid' value='' required="required" style='width: 30%;' placeholder="아이디" autofocus="autofocus">
        <button type='button' id="btn_checkID" class="btn btn-info btn-md">중복확인</button>
        <SPAN adminid='adminid_span'></SPAN> <!-- ID 중복 관련 메시지 -->        
      </div>
    </div>   
                
    <div class="form-group">
      <label for="adminpass" class="col-md-2 control-label" style='font-size: 0.9em;'>패스워드*</label>    
      <div class="col-md-10">
        <input type='password' class="form-control" name='adminpass' id='adminpass' value='' required="required" style='width: 30%;' placeholder="패스워드">
      </div>
    </div>   

    <div class="form-group">
      <label for="adminpass2" class="col-md-2 control-label" style='font-size: 0.9em;'>패스워드 확인*</label>    
      <div class="col-md-10">
        <input type='password' class="form-control" name='adminpass2' id='adminpass2' value='' required="required" style='width: 30%;' placeholder="패스워드">
      </div>
    </div>   
    
    <div class="form-group">
      <label for="adminname" class="col-md-2 control-label" style='font-size: 0.9em;'>성명*</label>    
      <div class="col-md-10">
        <input type='text' class="form-control" name='adminname' id='adminname' 
                   value='' required="required" style='width: 30%;' placeholder="성명">
      </div>
    </div>  
    
   
    
    <div class="form-group">
      <div class="col-md-offset-2 col-md-10">
        <button type="button" id='btn_send' class="btn btn-primary btn-md">다음</button>
        <button type="button" onclick="location.href='../index.jsp'" class="btn btn-primary btn-md">취소</button>

      </div>
    </div>   
  </FORM>

<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>

</html>

