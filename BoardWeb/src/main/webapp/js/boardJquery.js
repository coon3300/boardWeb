/**
 * boardJquery.js
 * jqurey 용 Ajax 사용.
 */
console.log('jqurey start.')
let page = 1;
$.ajax({
	url: 'replyList.do', // 서버 url 호출.
	data: { bno: bno, page: page },// 서버에 전달할 parameter.
	dataType: 'json', // 서버로 전달 받은 content 타입.
	success: function(result) {
		console.log(result);
		$.each(result, function(i, elem) {
			console.log("요기 => ", i, elem);
			let temp = $('#replyList li:eq(0)').clone();
			temp.attr('data-rno', elem.replyNo);
			//temp.attr('style', 'display:block'); // 속성(attribute) 변경.
			temp.css('display', 'block'); // 속성(attribute) 변경.
			temp.find('span:eq(0)').html(elem.replyNo);
			temp.find('span').eq(1).html(elem.replyContent);
			temp.find('span').eq(2).html(elem.replyer);
			// 버튼 생성을 새로..
			//let btn = $('<button>삭제</button></span>').on('click', function() {
			//		//$(this).parent().parent().fadeOut();
			//		$(this).parent().parent().remove();
			//});
			let btn = $('<button>삭제</button></span>').on('click', deleteRow);
			
			temp.find('span').eq(3).html(btn);

			$('#replyList').append(temp);
		});
	},
	erorr: function(err) {
		console.err(err);
	}
});

function deleteRow() {
	let li =	$(this).parent().parent();
	let rno = li.data('rno');
	// 삭제 ajax.
	$.ajax({
		url: 'removeReply.do',
		data: {rno: rno},
		dataType: 'json',
		success: function(result){
			console.log(result);
			if(result.retCode == 'Success'){
				//li.fadeOut();
				li.remove();
			}else{
				alert('처리중 예외 발생.')
			}
		},
		erorr:function(err){
			console.err(err);
		}
	});
}

$(document).ready(function(){
	$('#addReply').on('click', addRow);
});


function addRow() {
	
	let content = $('#content').val();
	console.log("content : " + content);
	
		$.ajax({
			url: 'addReply.do',
			data: {
				replyer: replyer,
				content: content,
				bno: bno
			},
			dataType: 'json',
			success: function(result){
				console.log(result);
				if(result.retCode == 'Success'){
					//$('#replyList').append(makeRow(result.retVal));
					$('#replyList').prepend(makeRow(result.retVal));
					$('#content').val(''); // 입력 초기화
				}else{
					alert('처리중 예외 발생.')
				}				
			},
			error: function(err){
				console.log(err);
			}
		});
}

function makeRow(elem = {}) {
	let temp = $('#replyList li:eq(0)').clone();
	temp.attr('data-rno', elem.replyNo); // selectKey
	temp.css('display', 'block'); // 속성(attribute) 변경.
	temp.find('span:eq(0)').html(elem.replyNo);
	temp.find('span').eq(1).html(elem.replyContent);
	temp.find('span').eq(2).html(elem.replyer);
	let btn = $('<button>삭제</button></span>').on('click', deleteRow);
	temp.find('span').eq(3).html(btn);	
	return temp;
}
