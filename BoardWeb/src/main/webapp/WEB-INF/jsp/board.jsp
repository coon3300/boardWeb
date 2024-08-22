<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://cdn.datatables.net/2.1.4/css/dataTables.dataTables.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.datatables.net/2.1.4/js/dataTables.js"></script>

<h3>게시판 상세화면(board.jsp)</h3>



<form action="removeBoard.do">
	<input type="hidden" name="bno" value="${board.boardNo}"> <input
		type="hidden" name="page" value="${page}">
	<table class="table">
		<tr>
			<th class="col-sm-3">글번호</th>
			<td class="col-sm-3">${board.boardNo}</td>
			<th class="col-sm-3">조회수</th>
			<td class="col-sm-3">${board.viewCnt}</td>
		</tr>

		<tr>
			<th>제목</th>
			<td colspan="3">${board.title}</td>
		</tr>

		<tr>
			<th>내용</th>
			<td colspan="3">${board.content}</td>
		</tr>

		<tr>
			<th>작성자</th>
			<td colspan="3">${board.writer}</td>
		</tr>

		<tr>
			<th>파일</th>
				<td colspan="3">
				<c:choose>
					<c:when test="${empty board.image}">
						이미지없음
					</c:when>
					<c:otherwise>
						<img width="250px" src="images/${board.image }">
					</c:otherwise>
				</c:choose></td>
		</tr>

		<tr>
			<td colspan="4" align="center"><c:choose>
					<c:when test="${logid == board.writer}">
						<input class="btn btn-danger" type="submit" value="삭제화면">
						<button class="btn btn-warning" type="button">수정화면</button>
					</c:when>
					<c:otherwise>
						<input class="btn btn-danger" disabled="submit" value="삭제화면">
						<button class="btn btn-warning" disabled type="button">수정화면</button>
					</c:otherwise>
				</c:choose></td>
		</tr>
	</table>
</form>

	<!-- 댓글 관련.. -->
	<div class="container reply">	
		<!-- 등록. -->
		
		<div class="header">
			<input class="col-sm-6" id="content">
			<button class="col-sm-2" id="addReply">댓글 등록</button>
			<button class="col-sm-2" id="deleteReply">댓글 삭제</button>
		</div>		
		
		<!-- 목록. -->
		<table id="example" class="display" style="width:100%">
        <thead>
            <tr>
                <th>댓글 번호</th>
                <th>댓글 내용</th>
                <th>작성자</th>
                <th>작성일시</th>
            </tr>
        </thead>
        <tfoot>
        </tfoot>
    </table>
		
	</div>

	<script>
		const bno = "${board.boardNo}";
		const replyer = "${logid}";
		document.querySelector('form>table button.btn.btn-warning')
				.addEventListener('click', function(e) {
					location.href = 'modifyBoard.do?bno=${board.boardNo}';
				});
		
		
		/* datatables 연습용. */
		let table = $('#example').DataTable({
		    ajax: 'replyList.do?bno=' + bno,
		    columns: [
		        { data: 'replyNo' },
		        { data: 'replyContent' },
		        { data: 'replyer' },
		        { data: 'replyDate' }
		    ],
		    lengthMenu: [
		        [5, 10, 50, -1],
		        [5, 10, 50, 'All']
		    ],
		    columnDefs: [
		        {
		            // The `data` parameter refers to the data for the cell (defined by the
		            // `data` option, which defaults to the column being worked with, in
		            // this case `data: 0`.
		            render: function (data, type, row) {
		                return '<button class="btn btn-danger" onclick="deleteRow(' + row.replyNo + ')">삭제</button>';
		            },
		            targets: 4
		        }
		    ]
		});
		
		
		// 댓글 등록 이벤트.
		$('#addReply').on('click', function () {
		    $.ajax({
		        url: 'addReply.do',
		        data: {
			            	replyer: replyer,
			            	content: $('#content').val(),
			            	bno: bno
		        },
		        dataType: 'json',
		        success: function(result) {
		        		if(result.retCode == 'Success'){
									let rvo = result.retVal;
			            // 받아온 데이터를 table.row.add에 추가
			            table.row.add({ 'replyNo': rvo.replyNo,
			                            'replyContent': rvo.replyContent,
			                            'replyer': rvo.replyer,
			                            'replyDate': rvo.replyDate
			            }).draw(false);
			            
			            $('#content').val('');
		        		}
		        },
		        error: function(err) {
		        }
		    });
		});		
		
		//var table = $('#example').DataTable();
		 
		$('#example tbody').on('click', 'tr', function () {
		    if ($(this).hasClass('selected')) {
		        $(this).removeClass('selected');
		    }
		    else {
		        table.$('tr.selected').removeClass('selected');
		        $(this).addClass('selected');
		    }
				console.log('1 : ' + $('tr.selected').children('td:eq(0)').text());
			
		});
		 
		// 댓글 삭제 이벤트.
		$('#deleteReply').click(function () {

		    $.ajax({
		        url: 'removeReply.do',
		        data: {
		        	rno: $('tr.selected').children('td:first').text()
		        },
		        dataType: 'json',
		        success: function(result) {
		        		if(result.retCode == 'Success'){
							    table.row('.selected').remove().draw(false);
		        		}
		        },
		        error: function(err) {
		        }
		    });
		});
		
		function deleteRow(rno){
		    $.ajax({
		        url: 'removeReply.do',
		        data: {
		        	rno: rno
		        },
		        dataType: 'json',
		        success: function(result) {
		        		if(result.retCode == 'Success'){
							    table.row('.selected').remove().draw(false);
		        		}else{
		        			alert('삭제 실패');
		        		}
		        },
		        error: function(err) {
		        	alert
		        }
		    });
		}
		

	</script>
