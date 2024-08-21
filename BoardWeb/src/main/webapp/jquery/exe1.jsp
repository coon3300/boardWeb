<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exe1</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		// 이벤트 등록
		$('#addBtn').on('click', function(){
			// 요소추가
			//$('#list').append($('<li>111</li>'));
			//let newElem = $('<li/>').html($('#userVal').val());
			let btn = $('<button>삭제</button>').on('click', function(){
				console.log(this);
				//$(this).parent().hide();
				//$(this).hide(1000);
				$(this).parent().hide(1000);
			}); // btn.
			
			//let newElem = $('<li/>').html($('#userVal').val() + " ")
			//												.append('<button>삭제</button>');
			let newElem = $('<li/>').html($('#userVal').val() + " ")
															.append(btn);
			$('#list').append(newElem);
		});

		// 홀수 이벤트.
		$('#oddBtn').on('click', function(){
			//$('#list li:even').css('background', 'red');
			//$('#list li:first').css('background', 'red');
			//$('#list li:eq(1)').css('background', 'red');
			$('#list li:gt(2)').css('background', 'red');
		});
		
		// 짝수 이벤트.
		$('#evenBtn').on('click', function(){
			//$('#list li:odd').css('color', 'blue');
			//$('#list li:gt(1)').css('color', 'blue');
			//$('#list li:lt(3)').css('color', 'blue');
			//$('#list li:contains(사과4)').css('background', 'blue');
			//$('#list li:has(span)').css('background', 'blue');
			$('#list li:not(:has(span))').css('background', 'blue');
		});
		
	});
</script>
</head>
<body>
	입력 : <input id = "userVal"> <!-- val() -->
	<button id="addBtn">추가</button>
	<!-- 
	<button id="oddBtn">홀수</button>
	<button id="evenBtn">짝수</button>
	 -->
	<button id="oddBtn">3번째 이후</button>
	<!-- 
	<button id="evenBtn">4번째 이전</button>
	 -->
	<button id="evenBtn">사과</button>
	
	<div id="show">
		<ul id="list">
			<li>사과1 <span>span</span><button>삭제</button></li>
			<li>사과2 <button>삭제</button></li>
			<li>사과3 <button>삭제</button></li>
			<li>사과4 <button>삭제</button></li>
			<li>사과5 <button>삭제</button></li>
			<li>사과6 <button>삭제</button></li>
		</ul>
	</div>
</body>
</html>