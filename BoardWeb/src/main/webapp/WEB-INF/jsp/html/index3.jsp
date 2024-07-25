<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 여기는 html/index.jsp -->
<h3> 연습용 </h3>
<div id="show">
	<select class="form-control" id="searchGender">
		<option value="all">선택하세요</option>
		<option value="female">여성</option>
		<option value="male">남성</option>
	</select>
	<table class="table">
		<tbody id="empList">
			<!-- 사원번호 fname, lname, salary -->
			
		</tbody>
	</table>
</div>
<div>
    <table class="table" > 
        <tr>
            <th>친구이름</th><td><input type="text" class="form-control" id="fname"></td>
        </tr>
        <tr>
            <th>주소</th><td><input type="text" class="form-control" id="faddress"></td>
        </tr>
        <tr>
            <th>키</th><td><input type="number" class="form-control" id="height"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
            <button id="addBtn" class="btn btn-info">등록</button>
            <button id="modBtn" class="btn btn-warning">수정</button>
            <button id="delBtn" class="btn btn-primary">선택삭제</button>
            </td>
        </tr>
    </table>
</div>
<table class="table table-hover ">
<thead>
    <tr>
        <th>친구이름</th><th>주소</th><th>키</th><th>삭제</th><th><input type="checkbox"></th>
    </tr>
<tbody id = "list"></tbody>
</table>
<script src="js/json3.js"> </script>