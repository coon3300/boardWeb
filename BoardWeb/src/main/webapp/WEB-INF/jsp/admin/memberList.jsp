<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>회원목록...</h3>
		<!-- <table class="table table-dark table-striped-columns"> -->
<ul class="nav nav-pills">

	<c:choose>
		<c:when test="${res eq 'Admin'}">
		  <li class="nav-item">
		    <!-- <a class="nav-link active" aria-current="page" href="memberList.do?res=Admin&orderBy=${orderBy }">관리자</a> -->
		    <a class="nav-link active" aria-current="page" href="memberList.do?res=Admin">관리자</a>
		  </li>
		  <li class="nav-item">
		    <!-- <a class="nav-link" href="memberList.do?res=User&orderBy=${orderBy }">사용자</a> -->
		    <a class="nav-link" href="memberList.do?res=User">사용자</a>
		  </li>
		</c:when>
		<c:otherwise>
		  <li class="nav-item">
		    <!-- <a class="nav-link" href="memberList.do?res=Admin&orderBy=${orderBy }">관리자</a> -->
		    <a class="nav-link" href="memberList.do?res=Admin">관리자</a>
		  </li>
		  <li class="nav-item">
		    <!-- <a class="nav-link active" aria-current="page" href="memberList.do?res=User&orderBy=${orderBy }">사용자</a> -->
		    <a class="nav-link active" aria-current="page" href="memberList.do?res=User">사용자</a>
		  </li>
		</c:otherwise>  
	</c:choose>  
</ul>
		
		
		<table class="table table-warnning table-striped">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col"><a href="memberList.do?orderBy=member_id&res=${res }">아이디</a></th>
                <th scope="col">비밀번호</th>
                <th scope="col"><a href="memberList.do?orderBy=member_nm&res=${res }">이름</a></th>
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
		    <c:forEach var="member" items="${memberList }" varStatus="stat">
		    <tr>
		        <td scope="row">${stat.count}</td>
		        <td>${member.memberId }</td>
		        <td>${member.memberPw }</a></td>
		        <td>${member.memberNm }</td>
		        <td>${member.responsibility }</td>
		    </tr>
		    </c:forEach>
	    </tbody>
    </table>