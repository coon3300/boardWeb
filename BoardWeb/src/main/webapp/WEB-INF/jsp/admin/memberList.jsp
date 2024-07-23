<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>회원목록...</h3>
		<!-- <table class="table table-dark table-striped-columns"> -->
		<table class="table table-warnning table-striped">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col"><a href="memberList.do?order=member_id">아이디</a></th>
                <th scope="col">비밀번호</th>
                <th scope="col"><a href="memberList.do?order=member_nm">이름</a></th>
                <th scope="col">권한</th>
            </tr>
        </thead>
    <%--
        String name = (String) request.getAttribute("myName");
				PageDTO paging = (PageDTO) request.getAttribute("paging");
				
				// 추가 속성을 받아온다.
				String keyword = (String) request.getAttribute("keyword");
				String searchCondition = (String) request.getAttribute("searchCondition");
    --%>
	    <tbody>
		    <c:forEach var="user" items="${userList }" varStatus="stat">
		    <tr>
		        <td scope="row">${stat.count}</td>
		        <td>${user.memberId }</td>
		        <td>${user.memberPw }</a></td>
		        <td>${user.memberNm }</td>
		        <td>${user.responsibility }</td>
		    </tr>
		    </c:forEach>
	    </tbody>
    </table>