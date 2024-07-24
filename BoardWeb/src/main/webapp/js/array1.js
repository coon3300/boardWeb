/**
 *	array1.js 
 */
// 등록 버튼에 클릭이벤트 추가.
document.getElementById('addBtn').addEventListener('click',function(e){	
	let name = document.getElementById('fname').value;
	let address = document.getElementById('faddress').value;
	let height = document.getElementById('fheight').value;
	
	if(!name || !address || !height){
		alert('값을 입력하세요.');
		return;
	}
	
	let friend = {name, address, height}
	
	let tr = makeTr(friend);
	
	list.appendChild(tr);
	
	fname.value='';
	faddress.value='';
	fheight.value='';

})
// 수정 버튼에 클릭이벤트 추가.
document.getElementById('modBtn').addEventListener('click',function(e){	
	let name = document.getElementById('fname').value;
	let address = document.getElementById('faddress').value;
	let height = document.getElementById('fheight').value;
	
	let qname = document.querySelector('#fname').value;
	let qaddress = document.querySelector('#faddress').value;
	let qheight = document.querySelector('#fheight').value;
	
	// 화면상에 있는 tr을 대상으로 변경해야하니까...
	document.querySelectorAll('#list tr').forEach(function(tr){
		// tr의 첫 번째 자식요소의 innerHTML : 이름. 비료 fname의 value 같을 때
		// faddress, height의 value를 tr의 두 번째, 세번째 자식요소의 innerHTML에 대입.
    if(name == tr.children[0].innerHTML){
			//tr.children[0].innerHTML = name;	
			//tr.children[1].innerHTML = address;
			//tr.children[2].innerHTML = height;
			tr.children[0].innerHTML = qname;	
			tr.children[1].innerHTML = qaddress;
			tr.children[2].innerHTML = qheight;
		}
	});
	
})


// 체크 박스에 클릭이벤트 추가.
document.getElementById('cBox').addEventListener('change',function(e){	
	let cb = document.getElementById('cBox').checked;

	
	// 화면상에 있는 tr을 대상으로 변경해야하니까...
	document.querySelectorAll('#list tr').forEach(function(tr){
		// tr의 첫 번째 자식요소의 innerHTML : 이름. 비료 fname의 value 같을 때
		// faddress, height의 value를 tr의 두 번째, 세번째 자식요소의 innerHTML에 대입.

			//tr.children[4].innerHTML = cb;
			//tr.children[4].children[0].setAttribute('checked',cb);
			tr.children[4].children[0].checked =cb;
	});
	
})

const friends = [
	{name: "홍길동", address: "대구 111번지", height: 170},
	{name: "가나다", address: "부산 222번지", height: 175},
	{name: "어어어", address: "대전 333번지", height: 180}
];

makeList();

function makeList(){
	//<tr><td>값1</td><td>값2</td><td>값3</td></tr>
	friends.forEach(function(friend){
		
	let tr = makeTr(friend);

	document.getElementById('list').appendChild(tr);
	});		
	
}

// friend => tr 생성.
function makeTr(friend = {name: 'Hong', address: 'Seoul', height: 170}){
	
	function detailCallback(e){
			document.getElementById('fname').value = tr.children[0].innerHTML;
			document.getElementById('faddress').value = tr.children[1].innerHTML;
			document.getElementById('fheight').value = tr.children[2].innerHTML;		
	} // end of detailCallback.
	
	// tr만드는 부분.
	let tr = document.createElement('tr');
	tr.addEventListener('click',detailCallback);

	
	for(let prop in friend){
		let td = document.createElement('td');
		td.innerHTML = friend[prop];
		tr.appendChild(td);
	}
	// 삭제 버튼
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.setAttribute('class', 'btn btn-danger'); // <button class="btn btn-danger">

	btn.addEventListener('click',function(e){
		console.log(e);
		e.target.parentElement.parentElement.remove();
	});
	btn.innerHTML = '삭제';
	td.appendChild(btn);
	tr.appendChild(td);
	
	// 체크박스
	td = document.createElement('td');
	let cb = document.createElement('input');
	cb.setAttribute('type', 'checkbox'); // <button class="btn btn-danger">
	td.appendChild(cb);
	tr.appendChild(td);
	
	// tr만드는 부분.
	
	return tr;
}