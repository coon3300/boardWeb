<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="UTF-8">
	<title>jQuery Element Insert</title>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script>
		$(function() {
			$("#firstBtn").on("click", function() {
				// id가 "list"인 요소의 맨 마지막에 id가 "firstItem"인 요소를 추가함.
				$("#firstItem").appendTo("#list");
			});
			$("#secondBtn").on("click", function() {
				// id가 "list"인 요소의 맨 마지막에 id가 "secondItem"인 요소를 추가함.
				$("#secondItem").appendTo("#list");
			});
			$("#thirdBtn").on("click", function() {
				// id가 "list"인 요소의 맨 마지막에 id가 "thirdItem"인 요소를 추가함.
				$("<li>새로 추가된 아이템이에요!</li>").appendTo("#list");
			});
		});
	</script>
</head>

<body>

	<h1>.appendTo() 메소드</h1>
	<p>아래 버튼들을 왼쪽에서부터 차례대로 눌러보세요!</p>
	<ul id="list">
		<li id="firstItem">첫 번째 아이템이에요!</li>
		<li id="secondItem">두 번째 아이템이에요!</li>
		<li id="thirdItem">세 번째 아이템이에요!</li>
	</ul>
	<button id="firstBtn">첫 번째 아이템 추가</button>
	<button id="secondBtn">두 번째 아이템 추가</button>
	<button id="thirdBtn">세 번째 아이템 추가</button>
	
</body>

</html>