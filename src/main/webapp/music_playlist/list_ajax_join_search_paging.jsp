<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
 
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
//2. This code loads the IFrame Player API code asynchronously.

$(function() {
  $('#btn_send').on('click', send);
  setTimeout(function(){
    list();
    }, 1500)
  });
var youtubeId = "";


function changelist(playlist){
  var playlist = playlist.substring(1, playlist.length-1);
  var array = playlist.split(',');
  for ( var i in array ) {
    if( i >=1 ){
      array[i] = array[i].substring(1, array[i].length);
      }
    array[i] = array[i];
  }
  return array;
}

function play(youtube){
  youtubeId = youtube;
  onYouTubeIframeAPIReady();
  }

var tag = document.createElement('script');
tag.src = "https://www.youtube.com/iframe_api";
var firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

// 3. This function creates an <iframe> (and YouTube player)
//    after the API code downloads.

function loadVideo(videoID) {
  if(player) { player.loadVideoById(videoID); }
}
 
function onYouTubeIframeAPIReady() {
    player = new YT.Player('player', {
    height: '180',
    width: '500',
    videoId: youtubeId,
    events: {
      'onReady': onPlayerReady,
      'onStateChange': onPlayerStateChange
    }
  });
}

// 4. The API will call this function when the video player is ready.
function onPlayerReady(event) {
  event.target.playVideo();
}

// 5. The API calls this function when the player's state changes.
//    The function indicates that when playing a video (state=1),
//    the player should play for six seconds and then stop.
var done = false;
function onPlayerStateChange(event) {
  if (event.data == YT.PlayerState.PLAYING && !done) {
    done = true;
  }
}

function changeVideoAndStart() {
  player.loadVideoById("iCkYw3cRwLo", 0, "large");
 }
 function stopVideo() {
  player.stopVideo();
} 
 function pauseYoutube() {
   player.pauseVideo();
}
 function list(){
   var array = changelist($('#playlist', frm).val());
   player.loadPlaylist({
   playlist:array,
   startSeconds:0,
   });
 }

function send() {
  // alert('send() execute.');
  // return;
  
  // $('#btn_close').attr("data-focus", "이동할 태그 지정");
  
  // var frm = $('#frm'); // id가 frm인 태그 검색
  // $('#frm').attr('action', './create_ajax.do');
  // var id = $('#id', frm).val(); // frm 폼에서 id가 'id'인 태그 검색
  //var params = 'playlistno=' + ${param.playlistno};
  var params = 'playlistno=' + ${param.playlistno} + "&";
  params += 'musicno=' + $('#musicno', frm).val() + "&";
  params += 'playing_seq=' + $('#playing_seq', frm).val(); // 직렬화, 폼의 데이터를 키와 값의 구조로 조합
  alert('params: ' + params);
  // return;

  var msg = '';
  $.ajax({
    url: './create_ajax.do', // spring execute
    type: 'post',  // post
    cache: false, // 응답 결과 임시 저장 취소
    async: true,  // true: 비동기 통신
    dataType: 'json', // 응답 형식: json, html, xml...
    data: params,      // 데이터
    success: function(rdata) { // 서버로부터 성공적으로 응답이 온경우
      if (rdata.cnt > 0) {
        msg = " 재생 목록 등록했습니다."
        msg += " <button type='button' onclick='location.reload(true)'>확인</button>";
      } else {
        msg = "재생 목록 등록에 실패했습니다."
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

function update_form(music_playlistno) {
  // $('#btn_close').attr("data-focus", "이동할 태그 지정");
  
  // var frm = $('#frm'); // id가 frm인 태그 검색
  // $('#frm').attr('action', './read_ajax.do');
  $("#btn_send").off("click");
  $('#btn_send').on('click', update_proc);
      
  // var id = $('#id', frm).val(); // frm 폼에서 id가 'id'인 태그 검색
  var params = 'music_playlistno=' + music_playlistno;
  // var params = 'contentsno=' + ${param.contentsno};
  // var params = $('#frm_create').serialize(); // 직렬화, 폼의 데이터를 키와 값의 구조로 조합
  // alert('params: ' + params);
  // return;

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
    //music_playlistno, playlistno, playing_seq, musicno
      $('#music_playlistno', frm).val(rdata.music_playlistno);
      $('#playlistno', frm).val(rdata.playlistno);
      $('#playing_seq', frm).val(rdata.playing_seq);
      $('#musicno', frm).val(rdata.musicno);

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
function cancel() {
  $('#music_playlistno', frm).val(0);
  $('#playlistno', frm).val('');
  $('#playing_seq', frm).val('');
  $('#musicno', frm).val('');

  $('#btn_send').html('등록');

  $('#panel1').html('');
  $('#panel1').hide();
}

function update_proc() {
  // alert('update_proc() execute.');
  // return;
  // $('#btn_close').attr("data-focus", "이동할 태그 지정");
  
  // var frm = $('#frm'); // id가 frm인 태그 검색
  // $('#frm').attr('action', './update_ajax.do');
  // var id = $('#id', frm).val(); // frm 폼에서 id가 'id'인 태그 검색
  // var params = 'contentsno=' + ${param.contentsno};
  var params = $('#frm').serialize(); // 직렬화, 폼의 데이터를 키와 값의 구조로 조합
  alert('params: ' + params);
  // return;

  var msg = '';
  $.ajax({
    url: './update_ajax.do', // spring execute
    type: 'post',  // get
    cache: false, // 응답 결과 임시 저장 취소
    async: true,  // true: 비동기 통신
    dataType: 'json', // 응답 형식: json, html, xml...
    data: params,      // 데이터
    success: function(rdata) { // 서버로부터 성공적으로 응답이 온경우
      alert("dd");
      if (rdata.cnt > 0) {
        msg = " 재생목록을 수정했습니다."
        msg += "<button type='button' onclick='location.reload(true)'>확인</button>";
      } else {
        msg = "재생 목록 수정에 실패했습니다."
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
  <DIV class='title_line'>
    <div style="position: absolute; right: 20px; top: 250px;">
    <a href="../music/list.do">음악 등록☞</a>
  </div>
    <p>수록된 음악 수: ${cnt_music}♬</p>
  </DIV>
  <DIV id='panel_create' style='padding: 10px 0px 10px 0px; background-color: #F9F9F9; width: 100%; text-align: center;'>
  <form action="./list.do" method="get">
    <input type='hidden' name='playlistno' id='playlistno' value='${param.playlistno }'>
    <c:choose>
        <c:when test="${param.m_music != '' }"> <%-- 검색하는 경우 --%>
          <input type='text' name='m_music' id='m_music' value='${param.m_music }' 
                     style='width: 20%;'>
        </c:when>
        <c:otherwise> <%-- 검색하지 않는 경우 --%>
          <input type='text' name='m_music' id='m_music' value='' style='width: 20%;'>
        </c:otherwise>
      </c:choose>
      <button type='submit'>제목 검색</button>
      <c:if test="${param.m_music.length() > 0 }">
        <button type='button' 
                     onclick="location.href='./list.do?playlistno=${playlistVO.playlistno}&m_music='">검색 취소</button>  
      </c:if>
    </form>
    <FORM name='frm' id='frm' method='POST' action=''>
      <!-- <input type='hidden' name='lang' id='lang' value='en'> --> <!-- ko, en -->
    <input type='hidden' name='playlistno' id='playlistno' value='${param.playlistno }'>
    <input type='hidden' name='playlist' id='playlist' value='${playlist }'>
    <input type='hidden' name='music_playlistno' id='music_playlistno' value='${param.music_playlistno }'>
    <input type='hidden' name='memberno' id='memberno' value='${param.memberno }'>
    </FORM>
      <DIV id='panel1' style="width: 40%; text-align: center; margin: 10px auto; display: none;"></DIV>
    </DIV>
    <div class='img_center'>
      <div id='player'>
      </div>
      <p>
    </div>
 
  
<TABLE class='table table-striped'>
  <colgroup>
    <col style='width: 10%;'/>
    <col style='width: 35%;'/>
    <col style='width: 30%;'/>
    <col style='width: 20%;'/>
  </colgroup>
 
  <thead>  
  <TR>
    <TH class="th_bs">재생순서</TH>
    <TH class="th_bs">음악</TH>
    <TH class="th_bs">가수</TH>
    <TH class="th_bs">stream</TH>
    
  </TR>
  </thead>
  
  <tbody>
  <c:forEach var="Music_Playlist_Music_joinVO" items="${list}">
    <c:set var="music_playlistno" value="${music_PlaylistVO.music_playlistno }" />
    <TR>
      <TD class="td_bs">${Music_Playlist_Music_joinVO.r }</TD>
      <TD class="td_bs">${Music_Playlist_Music_joinVO.m_music }</TD>
      <TD class="td_bs">${Music_Playlist_Music_joinVO.m_singer }</TD>
      
      <TD class="td_bs">
        <input type='hidden' name='youtube' id='youtube' value='${Music_Playlist_Music_joinVO.youtube }'>
        <A href="javascript:loadVideo('${Music_Playlist_Music_joinVO.youtube }')" title="재생"><span class="glyphicon glyphicon-play"></span></A>
        <A href="javascript:pauseYoutube()" title="일시정지"><span class="glyphicon glyphicon-pause"></span></A>
        <A href="./read_delete.do?music_playlistno=${Music_Playlist_Music_joinVO.music_playlistno }" title="삭제"><span class="glyphicon glyphicon-trash"></span></A>
      </TD>   
    </TR>   
  </c:forEach> 
  </tbody>
</TABLE>
<c:forEach var="Music_Playlist_Music_joinVO" items="${list}">
    <c:set var="music_playlistno" value="${music_PlaylistVO.music_playlistno }" />
<%-- <iframe width="500" height="300" src="${Music_Playlist_Music_joinVO.youtube }" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen> --%>
</c:forEach>

 <DIV class='bottom_menu'>${paging }</DIV>
 
<jsp:include page="/menu/bottom.jsp" />
</body>
 
</html> 
 
 
 