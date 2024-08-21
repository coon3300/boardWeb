/**
 * basic.js
 */
//document.addEventListener('DOMContentLoaded', function(){
$(document).ready(function(){
	
		// jquery 객체 vs dom 객체.
		
		//let obj = $('#show');
		//obj = document.getElementById('show');
		
		let obj = $('.show');
		
	
		//obj.html('Hello1');
		
		obj[0].innerHTML ='Hello';
		obj.eq(1).html('World');
		
		//$(obj[0]).html('Hello3');
		//$(obj[1]).html('World3');
		
		
		//obj[0].innerHTML = 'Hello4';
		//obj[1].innerHTML = 'Hello4';
		
		console.log(obj);
		
		// jquery 객체 생성.
		//console.log($('<button />'));
		//$('#show').append($('<button>삭제</button>')); // <button>삭제</button>
		$('#show').append($('<button />').html('삭제')); // <button>삭제</button>
	
})
