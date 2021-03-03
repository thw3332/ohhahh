<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#div1{width:96%; margin:0 auto;  text-align: center; }
	#title_div{width:100%; margin:0 auto;  text-align: center; }
	hr{width:96%; position:relative; z-index:-1; margin-top:50px; margin-left:15px;}
	#review{display:block; border:2px solid #ccc; 
			font-weight: bold; width:150px; height:50px; 
			font-size:35px; line-height: 50px; text-align: center;
			margin:20px auto; position: absolute; top: 357px; left:46%;
			background: white;
	}
	#shopTop{
    	width: 96%;
    	margin: 0 5px 0 15px;
        height: 200px;
        background-image: url(img/shop_up.jpg);
    }
    #shopTop p{
    	width: 300px;
        color: white;
        font-size: 2em;
        font-weight: bold;
        padding-top: 80px;
        text-align: center;
        margin-left: 43%;
        margin-right: 50%;
    }
    #shopTop a{
		text-decoration: none;
	}
	#shopTop a p{
		cursor: pointer;
	}
	input[type=text]{width:500px; height:40px;}
	input[type=button]{
	width:100px; height:40px; 
	font-size: 15px; color:white; background: #CFA987;
	border: none; margin:20px; font-weight: bold;
	cursor: pointer; outline: none;
	}
	input[type=submit]{
	width:100px; height:40px; 
	font-size: 15px; color:white; background: #3E3E3E;
	border: none; margin:20px; font-weight: bold;
	cursor: pointer; outline: none;
	}
	#bulist{background: #848484; color:white;}
	#budel{background: #FA5858; color:white;}
	table{ border-collapse:collapse;  width: 700px; 	text-align: center;
			padding-top: 80px;	padding-bottom: 80px; margin-left: auto;
			margin-right: auto;  margin-top: 50px;
 	}
 	tr{border-bottom:1px solid #cccccc; height:50px;}
	th{border-bottom: 1px solid #cccccc; width:50px; text-align: right;}
	td{width:110px; text-align: left; padding-left:10px;}
	h3{text-align: center; margin:0 auto;border-bottom: 1px solid #cccccc; 
			width:865px; padding:10px;
		    margin-top: 50px; 
		}
	textarea{margin:10px 0;}
	#filP{margin-bottom: 11px;}
	.commentT{display:none;   }
	/* #comment1{display: block;} */
	.commentModify{display:none;}
	.commentSee{font-size: 13px;}
	.td_id{background:#EEECEC;text-align: center; padding-left:0;}
	#reply_content{height:80px;width:90%;}
	#p1{font-size:12px; margin-top:10px;}
	.span_id{font-size:12px; font-weight: bold; }
	#b_con{padding:5px; border: none; outline: none;}
	textarea{padding:5px;border-radius: 5px;}
	#re_td_id1{text-align: center; padding-left:0;}
	#re_td_id2{text-align: right; padding-left:0;}
	#re_form{display:inline-block;}
	#re_content_enter{width:280px; height:40px; border: 1px solid lightgray; border-radius:5px;}
	#reply_form input[type=text]{ width:380px; height:40px; border: 1px solid lightgray; border-radius:5px; position: absolute; left: 900px;margin-top: 9px;  }
	#reply_form input[type=submit]{width:70px; height:40px; 
	font-size: 12px; color:#3E3E3E; background: white;
	border: 1px solid lightgray; margin:10px; font-weight: bold;
	cursor: pointer; outline: none;   }
	#re_td_see{text-align: right;}
	#re_td_see p{display:inline-block;}
	#reply_form{display:inline-block;}
	#re_form{display:inline-block;}
	#commentsee_td2{text-align: center;}
	#re_content_enter_td{text-align: center;}
	#enter_reply{width:70px; height:40px; 
	font-size: 12px; color:#3E3E3E; background: white;
	border: 1px solid lightgray; margin:10px; font-weight: bold;
	cursor: pointer; outline: none;}
	#reply_button{background:none; border:none; color:black; width:60px; height:20px; margin:5px;font-size:12px;}
	#reply_modify{background:none; border:none; color:black; width:60px; height:20px; margin:5px;font-size:12px;}
	#reply_delete{background:none; border:none; color:black; width:60px; height:20px; margin:5px;font-size:12px;}
	#commentsubmit_td{border-top: 1px solid lightgray;}
	
</style>
</head>
<body>
<div id="shopTop">
	<a href="BoardList.do?headerr=five"><p>REVIEW</p></a>
</div>
<div id="div1">
<div id="title_div">
	<hr>
	<span id="review">REVIEW</span>
</div>
<h3>${board_title}</h3>
<table>
	<tr>
		<th>작성자</th>
		<td class="tds">${id}</td>
		<th>작성일</th>
		
		<c:set var="now" value="<%=new java.util.Date()%>" />
		<fmt:formatDate var="currDate" pattern="yyyy-MM-dd" value="${now}" />
		<fmt:formatDate var="currDate1" pattern="HH:mm" value="${now}" />
								
		<fmt:parseDate var="write_date_format" value="${board_date}" pattern="yyyy-MM-dd HH:mm:ss" />
		<fmt:formatDate var="wirte_date" value="${write_date_format}" pattern="yyyy-MM-dd HH:mm"/>
		<fmt:formatDate var="wirte_date1" value="${write_date_format}" pattern="yyyy-MM-dd"/>
		<c:choose>
		<c:when test="${wirte_date1==currDate }">
		<fmt:formatDate var="wirte_time" value="${write_date_format}" pattern="HH:mm"/>
		</c:when>
		<c:otherwise> 
		<fmt:formatDate var="wirte_time" value="${write_date_format}" pattern="yyyy-MM-dd"/>
		</c:otherwise>
		</c:choose>
		
		<td class="tds">${wirte_time }</td>
		<th>조회</th>
		<td class="tds">${cnt}</td>
	</tr>
	<tr>
		<td colspan="6"><textarea rows="10" cols="120" name = "content" readonly="readonly" id="b_con">${board_content }</textarea>
		<p id="filP">첨부파일 : <a href="img/${board_img }">${board_img }</a></p>
		</td>
	</tr>
	<tr>
		<td><input type='button' value='목록보기' id="bulist" onclick="location.href='BoardList.do?headerr=five'"></td>
		<c:if test="${board_code != mincode }"><td><input type='button' value='이전글' onclick="location.href='Boardselectbefore.do?board_code=${board_code}'"></td></c:if>
		<c:if test="${board_code != maxcode }"><td><input type='button' value='다음글' onclick="location.href='Boardselectafter.do?board_code=${board_code}'"></td></c:if>
		<td><input type='button' value='수정' onclick="location.href='AlertMsg.jsp'"></td>
		<td></td>
		<td><input type='button' value='삭제' id="budel" onclick="location.href='Boarddelete.do'"></td>
	</tr>
		
	<form action="BoardComment2.do?headerr=five&board_title=${board_title}&myid=${id}&id=${log}&board_date=${board_date }&cnt=${cnt}&board_content=${board_content}&board_img=${board_img}" method="post">
	<tr>
		<td class="td_id">
		<c:if test="${empty log}" >
				<span class="span_id">로그인 후 이용해주세요</span>
		</c:if>
		<c:if test="${not empty log}">
				<c:if test="${log!='손님'}" >
					<span class="span_id">${log}</span><br>
					<span><small>[${currDate1 }]</small></span>
				</c:if>
				<c:if test="${log=='손님'}" >
					<span class="span_id">로그인 후 이용해주세요</span>
				</c:if>
		</c:if>
		</td>
		<td colspan="4">
			<p id="p1">답글달기 </p>
			<div id="borderContent">
				<input type="hidden" name="ref" value="${ref}">
				<input type="hidden" name="re_step" value="${re_step}">
				<input type="hidden" name="re_level" value="${re_level}">
				<textarea name="content"  id="reply_content"  placeholder="명예훼손, 개인정보 유출, 인격권 침해, 허위사실 유포 등은 이용약관 및 관련법률에 의해 제재를 받을 수 있습니다. 건전한 댓글문화 정착을 위해 이용에 주의를 부탁드립니다."></textarea>
			</div>
		</td>
		<td id="commentsubmit_td"><input type="submit" value="등록" ></td>
	</tr>
	</form>
	<c:set var="i" value="0"></c:set>
	<c:forEach var="comment" items="${a}">
	<fmt:parseDate var="write_date_format" value="${comment.board_date }" pattern="yyyy-MM-dd HH:mm:ss" />
	<fmt:formatDate var="wirte_date" value="${write_date_format}" pattern="yyyy-MM-dd HH:mm"/>
		<c:set var="i" value="${i+1}"></c:set>
		<tr>
			<c:choose>
				<c:when test="${comment.re_step==3}">
					<td id="re_td_id2" colspan="2" ><span class="span_id">▶&nbsp; ${comment.id} <br> [${wirte_date }]</span></td>
					<td id="commentsee_td2" colspan="2"><p class="commentSee" id="commentSee${i}">${comment.board_content}</p></td>
				</c:when>
				<c:otherwise>
					<td id="re_td_id1" colspan="2" ><span class="span_id">▶&nbsp; ${comment.id} <br> [${wirte_date}]</span></td>
					<td id="commentsee_td1" ><p class="commentSee" id="commentSee${i}">${comment.board_content}</p></td>
				</c:otherwise>
			</c:choose>
			<td colspan="3" id="re_td_see">
				<form id="reply_form" action="BoardCommentModify.do?headerr=five&board_title=${board_title}&myid=${id}&id=${comment.id}&log=${log}&board_date=${board_date}&cnt=${cnt}&board_content=${board_content}&board_img=${board_img}" method="post">
					<input type="hidden" name="ref" value="${comment.ref}">
					<input type="hidden" name="re_step" value="${comment.re_step}">
					<input type="hidden" name="re_level" value="${comment.re_level}">
					<input class="commentModify" id="commentModify${i}" type="text" name="content" value="${comment.board_content}"> 
					<input class="commentModify" id="commentModifyBtn${i}" type="submit" value="확인">
				</form>
				<c:if test="${comment.board_content != '삭제된 글입니다　' }">
				<form id="re_form${i }" action="BoardCommentDelete.do?headerr=five&board_title=${board_title}&myid=${id}&id=${comment.id}&log=${log}&board_date=${board_date}&cnt=${cnt}&board_content=${board_content}&board_img=${board_img}&ref=${comment.ref}&re_step=${comment.re_step}&re_level=${comment.re_level}" method="post">
					<c:if test="${comment.re_step!=3}">
						<input type="button" value="답글▼" onclick="btnClick(${i})" id="reply_button">
					</c:if>
					<input type="button" value="수정▲" onclick="btnModify(${i})" id="reply_modify">
					<input type="submit" value="삭제ⓧ" id="reply_delete">
				</form>
				</c:if>
			</td>
		</tr>
		
		<tr class="commentT" id="comment${i}">
			<td id="re_td_id2" colspan="2"><span class="span_id">▶&nbsp; ${comment.id}<br> [${wirte_date }]</span></td>
			<td colspan="4" id="re_content_enter_td">
			<form action="BoardComment.do?headerr=five&board_title=${board_title}&myid=${id}&id=${log}&board_date=${board_date}&cnt=${cnt}&board_content=${board_content}&board_img=${board_img}" method="post">
				<input type="hidden" name="ref" value="${comment.ref}">
				<input type="hidden" name="re_step" value="${comment.re_step}">
				<input type="hidden" name="re_level" value="${comment.re_level}">
				<input type="text" name="content" id="re_content_enter">
				<input type="submit" value="입력" id="enter_reply">
			</form>
			</td>
		</tr>
	</c:forEach>
</table>
</div>
<script>
	// 답글달기 버튼을 클릭하면 답글을 달수 있는 블럭을 생성
	function btnClick(i){
		var comment = document.getElementById("comment"+i);
		if(comment.style.display=="table-row"){
			comment.style.display="none";
		}else{
			comment.style.display="table-row";
		
		}
	}  
	
	 function btnModify(i){
		var commentSee = document.getElementById("commentSee"+i);
		var commentModify = document.getElementById("commentModify"+i);
		var commentModifyBtn = document.getElementById("commentModifyBtn"+i);
		var re_form = document.getElementById("re_form"+i);
		if(commentModify.style.display=="inline-block"){
			commentModify.style.display="none";
			commentModifyBtn.style.display="none";
			commentSee.style.display="inline-block";
			re_form.style.display="inline-block";
		}else{
			commentModify.style.display="inline-block";
			commentModifyBtn.style.display="inline-block";
			re_form.style.display="none";
			commentSee.style.display="none";
		}
	}
	 
	
</script>
</body>
</html>