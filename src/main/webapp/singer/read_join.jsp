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
    review_list_view();
  });

  function btn_review_like(reviewno) {
    var params = 'reviewno=' + reviewno; 
    // var params = $('#frm_create').serialize();   // 직렬화, 폼의 데이터들을 키와 값의 구조로 조합
    var msg = '';
      $.ajax({
        url: '../singer_review/update_reviewrec_up.do', // spring execute
        type: 'get',  // post
        cache: false, // 응답 결과 임시 저장 취소
        async: true,  // true: 비동기 통신
        dataType: 'json', // 응답 형식: json, html, xml...
        data: params,      // 데이터
        success: function(rdata) { // 서버로부터 성공적으로 응답이 온경우
          if (rdata.cnt > 0) {
            console.log("cnt = 1");
          } else {
            console.log("cnt = 0");
          }
          review_list_view();
          // $("#review_table").load(" #review_table");
          // $("#review_contents").html()
        },
        // Ajax 통신 에러, 응답 코드가 200이 아닌경우, dataType이 다른경우 
        error: function(request, status, error) { // callback 함수
          var msg = 'ERROR\n';
          msg += 'request.status: '+request.status + '\n';
          msg += 'message: '+error;
          console.log(msg);
        }
      });
  };

  function review_list_view() {

    var params = 'singerno=' + ${singerVO.singerno };

    $.ajax({
      url: "../singer/list_join.do", // action 대상 주소
      type: "get",           // get, post
      cache: false,          // 브러우저의 캐시영역 사용안함.
      async: true,           // true: 비동기
      dataType: "json",   // 응답 형식: json, xml, html...
      data: params,        // 서버로 전달하는 데이터
      success: function(rdata) { // 서버로부터 성공적으로 응답이 온경우
        // $("#reply_list").attr("data-replyPage", replyPage+1);  // 개발자정의 속성 쓰기 페이징 아직 안함
        // alert(rdata);
        var msg = '';
        
        $('#review_table').html(''); // 패널 초기화, val(''): 안됨
        
        for (i=0; i < rdata.list.length; i++) {
          var row = rdata.list[i];
          
          msg += "<DIV style='width: 100%;' id='review_contents'>";
          msg += "  <table style='width: 100%'>";
          msg += "    <tr>";
          msg += "      <td class='review_membericon' rowspan='4'>멤버아이콘</td>";
          msg += "    </tr>";
          msg += "    <tr>";
          msg += "      <td><span class='review_membername'>멤버이름</span>";
          msg += "        <span class='review_rdate'>"+row.reviewdate.substring(5, 10)+"</span>";
          msg += "      </td>";
          msg += "    </tr>";
          msg += "    <tr>";
          msg += "      <td><div class='review_content'>"+row.reviewcon+"</div></td>";
          msg += "    </tr>";
          msg += "    <tr>";
          msg += "      <td><span class='review_recommend'>";
          msg += "        <A href=\"javascript:btn_review_like("+row.reviewno+")\" title=\"좋아요\"><span class=\"glyphicon glyphicon-heart\"></span></A>";
          msg +=          row.reviewrec+"</span>";
          msg += "      </td>";
          msg += "      <div class='review_line'></div>";
          msg += "    </tr>";
          msg += "  </table>";
          msg += "</DIV>";
        }
        // alert(msg);
        $('#review_table').append(msg);
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
<c:set var="singerno" value="${singerVO.singerno}" />
<c:set var="musicno" value="${musicVO.musicno}" />
<%-- <c:set var="contentsno" value="${contentsVO.contentsno }" /> --%>

<jsp:include page="/menu/top.jsp" flush='false' />
  <DIV class='title_line'>
    가수 조회
  </DIV>
  
  <ASIDE class="aside_left">
    조회 > ${singerVO.name }
  </ASIDE>
  <ASIDE class="aside_right">
    <A href="./create.do">글 등록</A>
    
    <c:choose>
      <c:when test="${singerVO.portrait.trim().length() > 0 }">
        <span class='menu_divide' > | </span> 
        <A href='./img_update.do?singerno=${singerno }'>메인 이미지 변경/삭제</A>     
      </c:when>
      <c:otherwise>
        <span class='menu_divide' > | </span> 
        <A href='./img_create.do?singerno=${singerno }'>메인 이미지 등록</A>     
      </c:otherwise>
    </c:choose>
    <span class='menu_divide' > | </span>
    <A href="javascript:location.reload();">새로고침</A>
    <span class='menu_divide' > | </span> 
    <A href='./list.do'>목록</A>
    <span class='menu_divide' > | </span> 
    <A href='./update.do?singerno=${singerno }'>수정</A>
    <span class='menu_divide' > | </span> 
    <A href='./delete.do?singerno=${singerno }'>삭제</A>
    
  </ASIDE>
  
  <div class='menu_line'></div>

  <FORM name='frm' method="get" action='./update.do'>
      <input type="hidden" name="singerno" value="${param.singerno}">
      
      <table class="fieldset_singer">
          <tr>
            <td>
              <c:set var="portrait" value="${singerVO.portrait }" />
              <c:if test="${portrait.endsWith('jpg') || portrait.endsWith('png') || portrait.endsWith('gif')}">
                <DIV class="img_center">
                  <IMG src="./storage/main_images/${portrait }" style="width: 50%;"> 
                </DIV>
              </c:if>
            </td>
          </tr>
          <tr>
            <td>
              <div class="singer_name">
                ${singerVO.name }
              </div>
              <div class="singer_country">
                ${singerVO.genre }
              </div>
              <div class="singer_country">
                ${singerVO.sex } / ${singerVO.country }
              </div>
              <div class="singer_line"></div>
              <div style="text-align: left; font-size: 1.1em; font-weight: bold; margin-bottom:20px;">
                소개
              </div>
              <div>
                ${singerVO.intro }
              </div>
              <div style="margin-top:20px; text-align: center;">
                <A href="./update_singerrec_up.do?singerno=${singerno }" title="좋아요"><span class="glyphicon glyphicon-heart"></span></A>
                 ${singerVO.singerrec}
              </div>
            </td>
          </tr>
      </table>
  </FORM>
  
  <DIV style='width: 100%;'>
    <FORM name='frm' method='POST' action='../singer_review/create.do' class="form-horizontal">
               
      <!-- FK memberno 지정 -->
      <input type='hidden' name='memberno' id='memberno' value='${sessionScope.memberno }'>
      <!-- FK categrpno 지정 -->
      <input type='hidden' name='singerno' id='singerno' value='${param.singerno }'>
      <c:choose>
        <c:when test="${sessionScope.memberid == null}">
          <div class="form-group">   
            <div class="col-md-12">
              <textarea class="form-control" name='reviewcon' id='reviewcon' rows="4" placeholder="로그인을 하셔야 댓글을 작성할 수 있습니다."></textarea>
            </div>
          </div>
         </c:when>
        <c:otherwise>
          <div class="form-group">   
            <div class="col-md-12">
              <textarea class="form-control" name='reviewcon' id='reviewcon' rows="4" placeholder="내용"></textarea>
            </div>
          </div>
          <DIV class='singer_bottom_menu'>
            <button type="submit" class="btn btn-info">등록</button>
            <button type="button" 
                          onclick="location.href='./list.do?categrpno=${param.categrpno}'" 
                          class="btn btn-info">취소</button>
          </DIV>
        </c:otherwise>
      </c:choose>
    </FORM>
  </DIV>
  
  <div id='review_table'>
    <%-- <c:forEach var="singer_review_join" items="${list }">
          <c:set var="reviewno" value="${singer_review_join.reviewno }" />
          <DIV style='width: 100%;' id='review_contents'>
            <table style='width: 100%'>
              <tr>
                <td class='review_membericon' rowspan="4">멤버아이콘</td>
              </tr>
              <tr>
                <td><span class='review_membername'>멤버이름</span> <span class='review_rdate'>${singer_review_join.reviewdate.substring(5, 10)}</span>
                </td>
              </tr>
              <tr>
                <td><div class='review_content'>${singer_review_join.reviewcon}</div></td>
              </tr>
              <tr>
              <td><span class='review_recommend'>
                <A href="javascript:btn_review_like(${reviewno })" title="좋아요"><span class="glyphicon glyphicon-heart"></span></A>
                ${singer_review_join.reviewrec}</span>

                <span class='review_icon'>
                  <A href="../singer_review/update.do?reviewno=${reviewno }" title="수정"><span class="glyphicon glyphicon-pencil"></span></A>
                  <A href="../singer_review/delete.do?reviewno=${reviewno }" title="삭제"><span class="glyphicon glyphicon-trash"></span></A>
                </span>
                
                <span class='review_comment'>  <A href="../reviewcmt/list_create.do?reviewno=${reviewno}">답글달기</A></span>
                <div class='review_showcmt'>
                  <c:if test="${singer_review_join.reviewcmtcnt > '0'}">
                    <A href="../reviewcmt/list.do?reviewno=${reviewno}" style="color:#6699FF">${singer_review_join.reviewcmtcnt } 개의 답글펼치기</A>
                  </c:if>
                </div>
                <div class='review_line'></div>
              </td>
            </tr>
          </table>
        </DIV>
      </c:forEach> --%>
    </div>
  
  
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>

</html>