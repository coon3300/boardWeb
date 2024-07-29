// 등록 버튼에 클릭이벤트 추가
document.getElementById('addBtn').addEventListener('click', function(e) {
	let name = document.getElementById('fname').value;
	let address = document.getElementById('faddress').value;
	let heigth = document.getElementById('heigth').value;

	if(!name || !address || !heigth){
			alert('값을 입력하세요');
			return;
	}

	let friend = { name, address, heigth }

	console.log(name);

	// tr 만드는 부분
	let tr = makeTr(friend);
	list.appendChild(tr);



	alert('OK');

	fname.value = '';
	faddress.value = '';
	heigth.value = '';

})


const friends = [
	{ name: "북조선", address: "개성공단", height: 170 },
	{ name: "김감치", address: "파판월드", height: 167 },
	{ name: "안예림", address: "능금마을", height: 160 }
]

makeList();
function makeList() {
	// <tr><td>값1</td><td>값2</td><td>값3</td><td><button>삭제</button></td></tr>
	friends.forEach(function(friend) {
			let tr = makeTr(friend);
			document.getElementById('list').appendChild(tr);
	});
}

// friend -> tr 생성
function makeTr(friend = { name: 'Hong', address: 'Seoul', height: 177 }) {
	// tr 만드는 부분
	let tr = document.createElement('tr');
	tr.addEventListener('click',function(e){

	document.getElementById('fname').value = tr.children[0].innerHTML;
	document.getElementById('faddress').value = tr.children[1].innerHTML;
	document.getElementById('heigth').value = tr.children[2].innerHTML;


			console.log(e);
	});

	for (let prop in friend) {
			let td = document.createElement('td');
			td.innerHTML = friend[prop];
			tr.appendChild(td);
	}
	// 삭제버튼
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.addEventListener('click', function(e) {
			e.target.parentElement.parentElement.remove();
			console.log(e);
	})
	btn.innerHTML = '삭제';
	td.appendChild(btn)
	tr.appendChild(td)


	return tr;
}