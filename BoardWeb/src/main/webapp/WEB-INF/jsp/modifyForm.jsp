<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>수정화면(modifyForm.jsp)</h3>
<% BoardVO board = (BoardVO) request.getAttribute("board"); %>
<form action="updateBoard.do">
<input type="hidden" name="bno" value="<%=board.getBoardNo() %>">
<table class="table">
    <tr>
        <th>제목</th>
        <td><input class="form-control" type="text" name="title" value="<%=board.getTitle()%>"></td>
    </tr>

    <tr>
        <th>내용</th>
        <td><textarea class="form-control" name="content"><%=board.getContent()%></textarea></td>
    </tr>

    <tr>
        <th>작성자</th>
        <td colspan="3"><%=board.getWriter() %></td>
    </tr>

    <tr>
        <td colspan="2" align="center">
        <input class="btn btn-primary" type="submit" value="수정"> 
				<button class="btn btn-warning" type="button"> 취소 </button>			
        </td>
    </tr>

</table>
</form>
