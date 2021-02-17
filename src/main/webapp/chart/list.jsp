<!--  AJAX추가 전 백업본 -->
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
  $(function(){
   getList();
  });
  function getJoin(name) {
    var name = name;
    
    $.ajax({
      url: "../chart/read_join.do", // action 대상 주소
      type: "get",           // get, post
      cache: false,          // 브러우저의 캐시영역 사용안함.
      async: true,           // true: 비동기
      dataType: "json",   // 응답 형식: json, xml, html...
      data:{'name': name},
      success: function(rdata) { // 서버로부터 성공적으로 응답이 온경우
       var msg = "";

       var row = rdata.list_join[0].singerno;
       msg+= "<A href='../singer/read.do?singerno='"+row+">";        
       
      return msg;

      },
      // Ajax 통신 에러, 응답 코드가 200이 아닌경우, dataType이 다른경우 
      error: function(request, status, error) { // callback 함수
        var msg = 'ERROR request.status: '+request.status + '/ ' + error;
        console.log(msg);
      }
    });
  }
  

    
  function getList() {
    $.ajax({
      url: "../chart/list_ajax.do", // action 대상 주소
      type: "get",           // get, post
      cache: false,          // 브러우저의 캐시영역 사용안함.
      async: true,           // true: 비동기
      dataType: "json",   // 응답 형식: json, xml, html...
      success: function(rdata) { // 서버로부터 성공적으로 응답이 온경우
       var msg = "";

         
       msg+= "<table class='table table-striped' style='width: 100%;'>";
       msg+= " <caption>관리자만 접근가능합니다.</caption>";
       msg+= " <colgroup>";
       msg+= "   <col style='width: 25%;'/>";
       msg+= "    <col style='width: 50%;'/>";
       msg+= "   <col style='width: 25%;'/>";
       msg+= "    </colgroup>";
       msg+= "    <TR>";
       msg+= " <TH class='th'>No</TH>";
       msg+= " <TH class='th'>Title</TH>";
       msg+= "   <TH class='th'>Artist</TH>";
       msg+= "    </TR>";
       for (i=0; i < rdata.list.length; i++){
         var row = rdata.list[i];  
       msg+= " <TR>";
       msg+= " <TD class='td'>"+row.chartno+"</TD>";
       msg+= " <TD class='td'>"+row.music+"</TD>      "; 

       msg+= " <TD class='td'>"+getJoin(row.artist)+row.artist+"</A></TD>";
       

       }   
       msg+= " </TR>";
        
      msg+= " </TABLE>";
       
        // alert(msg);
      $('#table').html(msg);

      },
      // Ajax 통신 에러, 응답 코드가 200이 아닌경우, dataType이 다른경우 
      error: function(request, status, error) { // callback 함수
        var msg = 'ERROR request.status: '+request.status + '/ ' + error;
        console.log(msg);
      }
    });
  }
  
</script>
</head> 
 
<body>
<jsp:include page="/menu/top.jsp" flush='false' />
 
  <DIV class='title_line'>
    회원
  </DIV>

  <ASIDE class="aside_left">
      <A href='./member/list.do'>인기 차트</A>  
  </ASIDE>
  
  

 <div></div>
  <div id='table'></div>
  <div id='tables'></div>
 

 
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
 
</html>