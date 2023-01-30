<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   <!-- c태그를 쓸때 taglib가 있어야함 -->
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>댓글</title>
</head>
<body>
   <div style="text-align: center;">
         <input type="text" id="memberId">
         <input type="text" id="replyContent">
         <button id="btn_add">작성</button>
    </div>
   
   
   <div style="text-align: center;">
      <div id="replies"></div>
   </div>
   <div>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
   </div>

   <script type="text/javascript">
      $(document).ready(function() { 
         getAllReplies();
         $('#btn_add').click(function() { //작성버튼을 누르면
            var boardId = 3; // 게시판 번호 데이터
            var memberId = $('#memberId').val(); // 작성자 데이터
            var replyContent = $('#replyContent').val(); // 댓글 내용
            var obj = {
               'boardId' : boardId, //문자열로 보내짐 
               'memberId' : memberId,
               'replyContent' : replyContent
            };
            console.log(obj);

            // $.ajax로 송수신을 한다
            $.ajax({
               type : 'POST',
               url : 'replies',
               headers : {
                  'content-type' : 'application/json',
                  'x-HTTP-Method-Override' : 'POST'
               },
               data : JSON.stringify(obj), //JSON으로 변환
               success : function(result, status) {
                  console.log(result);
                  console.log(status);
                  if (status == 'success') {
                     alert('댓글 입력 성공');
                     getAllReplies();
                  }
               }
            });// end ajax()

         }); // end btn_add.click()

         // 게시판 댓글 전체 가져오기
         function getAllReplies() {
            var boardId = 3;

            var url = 'replies/all/' + boardId;
			console.log(url);
            $.getJSON(
                 url, 
                 function(data) {
                       // data : 서버에서 온 list 데이터가 저장되어 있음.
                       // getJSON()에서 json 데이터는 자동으로 parseng됨
                  
                       console.log("data="+data);
                    var list = ''; // 댓글 데이터를 HTML에 표현할 문자열 변수
                  
                    var loginId = '<%=(String)session.getAttribute("memberId") %>'; // 로그인한 아이디세션을 가져옴       
                 
                     // $(컬렉션).each() : 컬렉션 데이터를 반복문으로 꺼내는 함수
                     $(data).each(function(){
                        // this : 컬렉션의 한 줄 데이터를 의미
                         console.log(this);
                        
                        var disabled = '';
                        var readonly = '';
                        
                        if (loginId == this.memberId) {
                           disabled = '';
                           readonly = '';
                        } 
                        
                        var replyDateCreated = new Date(this.replyDateCreated);   
                        
                        list += '<div class="reply_item">'
                           + '<pre>'
                           + '<input type="hidden" id="replyId" value="'+ this.replyId +'"/>'
                           + '<input type="hidden" id="memberId" value="'+ this.memberId +'"/>'
                           + this.memberId
                           + '&nbsp;&nbsp;' //공백
                           + '<input type="text" '+ readonly +' id="replyContent" value="'+ this.replyContent +'"/>'
                           + '&nbsp;&nbsp;' 
                           + replyDateCreated
                           + '&nbsp;&nbsp;'
                           + '<button class="btn_update" ' + disabled +'>수정</button>'
                           + '<button class="btn_delete" ' + disabled +'>삭제</button>'
                           + '</pre>'
                           + '</div>';
                     }); // end each()
                     $('#replies').html(list);
                  } // end function()
              ); // end getJSON()
         } // end getAllReplies()
         
         // 수정 버튼을 클릭하면 선택된 댓글 수정
          $('#replies').on('click', '.reply_item .btn_update', function(){ //replies밑에 reply_item밑에 수정버튼을 누르면 그에대한 정보를가져오겟다
            console.log(this);
             
             // 선택된 댓글의 replyId, replyContent값을 저장
             // prevAll() : 선택된 노드 이전에 있는 모든 형제 노드를 접근
             var replyId = $(this).prevAll('#replyId').val();
             var replyContent = $(this).prevAll('#replyContent').val();
             console.log("선택된 댓글 번호 : " + replyId + ", 댓글 내용 : " + replyContent);
             
             // ajax 요청
             $.ajax({
                type : 'PUT',
                url : 'replies/' + replyId,
                headers : {
                    'content-type' : 'application/json',
                    'x-HTTP-Method-Override' : 'PUT'
                 },
                data : JSON.stringify({'replyContent' : replyContent}),
                success : function(result) {
                   console.log(result);
                   if(result == 1) {
                      alert('댓글 수정 성공!');
                      location.reload();
                   }
                }
             });
             
         }); // end replies.on() 
         
         // 삭제 버튼을 클릭하면 선택된 댓글 삭제
         $('#replies').on('click', '.reply_item .btn_delete', function(){ //replies밑에 reply_item밑에 삭제버튼을 누르면 그에대한 정보를가져오겟다
            console.log(this);
            
            // 선택된 댓글의 replyId, replyContent값을 저장
             // prevAll() : 선택된 노드 이전에 있는 모든 형제 노드를 접근
             var boardId = 3;
             var replyId = $(this).prevAll('#replyId').val();
             console.log("선택된 댓글 번호 : " + replyId);
             
             // ajax 요청
             $.ajax({
                type : 'DELETE',
                url : 'replies/' + replyId,
                headers : {
                    'content-type' : 'application/json',
                    'x-HTTP-Method-Override' : 'DELETE'
                 },
                data : JSON.stringify({
                   'boardId' : boardId
                }),
                success : function(result) {
                   console.log(result);
                   if(result == 1) {
                      alert('댓글 삭제 성공!');
                      location.reload();
                   }
                }
             });
             
         }); // end replies.on()
         
      }); // end document
   </script>
</body>
</html>