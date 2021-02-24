<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>team1. Project</title>

<link href="../css/style.css" rel="Stylesheet" type="text/css">

<link href="../css/style.css" rel="Stylesheet" type="text/css">
<script type="text/JavaScript"
          src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
<script type="text/javascript">
  $(function(){
 
  });
</script>
 
</head> 
 
<body>
<jsp:include page="/menu/top.jsp" flush='false' />
 
<DIV class='title_line'>새로운 음악 등록</DIV>
 
<FORM name='frm' method='POST' action='./create.do' class="form-horizontal">
  <!-- <input type='hidden' name='likelist' value='N'>  -->
  <input type='hidden' name='singerno' value='1'>
  <input type='hidden' name='albumno' value='4'> 
  
  <!-- 미 설정 값들 -->
  <!-- <input type='hidden' name='youtube' value='youtube'> -->
  <!-- <input type='hidden' name='memberno' value='1'> -->
  <input type='hidden' name='genreno' value='1'>
  <input type='hidden' name='genre' value='발라드'>
  <!-- <input type='hidden' name='likesu' value='0'> -->
  <!-- <input type='hidden' name='replycnt' value='0'> -->
  <!-- <input type='hidden' name='cnt' value='0'> -->
  
   
  <!-- <input type='hidden' name='genreno' value='1'> --> <%-- 전달 해줘야 할 FK 3개 값들 고민좀해봐야할듯 --%>
  
  <div class="form-group">
     <label class="control-label col-md-3">곡 제목</label>
     <div class="col-md-9">
       <input type='text' name='title' value='눈의꽃' required="required" 
                 autofocus="autofocus" class="form-control" style='width: 30%;'>
     </div>
  </div> 
    
  <div class="form-group">
     <label class="control-label col-md-3">가수</label>
     <div class="col-md-9">
       <input type='text' name='singer' value='박효신' required="required" 
                 autofocus="autofocus" class="form-control" style='width: 30%;'>
     </div>
  </div>
  
  <div class="form-group">
     <label class="control-label col-md-3">앨범명</label>
     <div class="col-md-9">
       <input type='text' name='album' value='미안하다 사랑한다OST' required="required" 
                 autofocus="autofocus" class="form-control" style='width: 30%;'>
     </div>
  </div>
  
  <div class="form-group">
     <label class="control-label col-md-3">youtubeId</label>
     <div class="col-md-9">
       <input type='text' name='youtube' value='미안하다 사랑한다OST' required="required" 
                 autofocus="autofocus" class="form-control" style='width: 30%;'>
     </div>
  </div>
  
  
  <div class="form-group">
        
          
        <div class="col-md-9">
        <fieldset>
          <legend class="form">장르 선택</legend>
          <label class="check_box">
            <input type="checkbox" name='list_genre' value='1' checked="checked"> 발라드
          </label><br>
        
          <label style="cursor: pointer;">
            <input type="checkbox" name='genre2' value='2'> 락
          </label><br>
              
          <label style="cursor: pointer;">
            <input type="checkbox" name='genre3' value='3'> 메탈
          </label><br> 
             
          <label style="cursor: pointer;">
            <input type="checkbox" name='genre4' value='4'> 댄스
          </label><br> 
          
          <label style="cursor: pointer;">
            <input type="checkbox" name='genre4' value='5'> 힙합
          </label><br> 
        </fieldset>
      </div>
  </div>

  
  
  
  
  
  
  
  
  
  
  
  
  
 <!--  <div class="form-group">
     <label class="control-label col-md-3">장르</label>
     <div class="col-md-9">
       <input type='text' name='genre' value='발라드' required="required" 
                 autofocus="autofocus" class="form-control" style='width: 30%;'>
     </div>
  </div> -->
  
  <!-- <div class="form-group">
     <label class="control-label col-md-3">장르</label>
     <div class="col-md-9">
         <select name="col" size="1">
           <option value="bal" selected="selected">발라드</option>
           <option value="hip">힙합</option>
           <option value="roc">락</option>
           <option value="metal">메탈</option>
           <option value="acou">어쿠스틱</option>
         </select>
     </div>
  </div> -->
  
  <!-- <div class="form-group">
     <label class="control-label col-md-3">가사</label>
     <div class="col-md-9">
       <input type="text" name='lyrics' value='어느새 길어진 그림자를 따라서 땅거미 진 어둠 속을 그대와 걷고 있네요' required="required" 
                 autofocus="autofocus" class="form-control" style='width: 80%;'>
     </div>
  </div> -->
  
   <%-- <div class="form-group">   
      <div class="col-md-12">
           실제 컬럼명: file1, Spring File 객체 대응: file1MF
          <input type='file' class="form-control" name='file1MF' id='file1MF' 
                    value='' placeholder="파일 선택">
        </div>
      </div>  --%>
  
  <!-- <div class="form-group">   
    <label class="control-label col-md-3">비밀번호</label>
        <div class="col-md-9">
          <input type='password' class="form-control" name='passwd'  value='1234' placeholder="패스워드" style='width: 20%;'>
        </div>
      </div> -->
  

  <div class="content_bottom_menu" style="padding-right: 20%;">
    <button type="submit" class="btn btn-primary">등록</button>
    <button type="button" onclick="location.href='./list.do'" class="btn btn-primary">목록</button>
  </div>

</FORM>
 
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
 
</html>
