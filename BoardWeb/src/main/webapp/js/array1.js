/**
 *	array1.js 
 */

// 등록 버튼에 클릭이벤트 추가.
document.getElementById('addBtn').addEventListener('click', addBtnFnc);

function addBtnFnc(e){
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
}

/**

// 체크 박스에 클릭이벤트 추가.(id 생성해서 내가)
document.getElementById('cBox').addEventListener('change',function(e){	
	let cb = document.getElementById('cBox').checked;
	document.querySelectorAll('#list tr').forEach(function(tr){
			//tr.children[4].innerHTML = cb;
			//tr.children[4].children[0].setAttribute('checked',cb);
			tr.children[4].children[0].checked =cb;
	});
})
 * 
 */


// thead에 있는 체크박스 이벤트 등록.
//document.querySelector('div.container-fluid>table>thead input[type="checkbox"]')//
document.querySelector('#show>table>thead input[type="checkbox"]')//
    .addEventListener('change', changeFnc);

function changeFnc(e) {
		console.log(e.target.checked);
		console.log(document.querySelectorAll('#show>table>tbody input[type="checkbox"]:checked').length);
    // 찾으려는 대상 체크박스.
    //document.querySelectorAll('div.container-fluid>table>tbody input[type="checkbox"]')//
    document.querySelectorAll('#show>table>tbody input[type="checkbox"]')//
        .forEach(function(item) {
            console.log(item);
            item.checked = e.target.checked;
        });
}

// 체크박스 전부 선택 되면 상단에 체크
/**
 * 
console.log(document.querySelectorAll('#show>table>tbody input[type="checkbox"]'));
//document.querySelector('div.container-fluid>table>thead input[type="checkbox"]')//
document.querySelectorAll('#show>table>tbody> input[type="checkbox"]')
        .forEach(function(item) {
            console.log(item);
            item.addEventListener('change', checkFnc);
        });
 */


/**
 * 체크 버튼 실패
const checkAll = document.querySelectorAll('#show>table>tbody input[type="checkbox"]');
for (const check of checkAll) {
  check.addEventListener('click', checkFnc);
}

function checkFnc(e) {
		let cntAll = document.querySelectorAll('#show>table>tbody input[type="checkbox"]').length;
		let cntChecked = document.querySelectorAll('#show>table>tbody input[type="checkbox"]:checked').length;
    // 찾으려는 대상 체크박스.
    //document.querySelectorAll('div.container-fluid>table>tbody input[type="checkbox"]')//
    
    console.log("cntAll : " + cntAll + "cntChecked" + cntChecked);
    if(cntAll == cntChecked){
			document.querySelectorAll('#show>table>thead input[type="checkbox"]').checked = true//
			
		}else{
			document.querySelectorAll('#show>table>thead input[type="checkbox"]').checked = false//
			
		}
}
 * 
 */


// 수정 버튼에 클릭이벤트 추가.
document.getElementById('modBtn').addEventListener('click',modBtnFnc);	

function modBtnFnc(e){
		// 화면상에 있는 tr을 대상으로 변경해야하니까...
	document.querySelectorAll('#list tr').forEach(function(tr){
		
		let name = document.getElementById('fname').value;
		let address = document.getElementById('faddress').value;
		let height = document.getElementById('fheight').value;
		
		let qname = document.querySelector('#fname').value;
		let qaddress = document.querySelector('#faddress').value;
		let qheight = document.querySelector('#fheight').value;		
		
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
}

// 선택삭제 버튼에 클릭이벤트 추가.
document.getElementById('delBtn').addEventListener('click',delBtnFnc);	

function delBtnFnc(e){
		console.log(e.target.checked);
		console.log(document.querySelectorAll('#show>table>tbody input[type="checkbox"]:checked').length);
		
    //document.querySelectorAll('div.container-fluid>table>tbody input[type="checkbox"]')//
    document.querySelectorAll('#show>table>tbody input[type="checkbox"]:checked')//
        .forEach(function(item) {
            console.log(item);
						item.parentElement.parentElement.remove();
        });
}


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

function detailCallback(e){
		console.log(e.target.parentElement);
		e.stopPropagation(); // click : button > td > tr > ... : 버블링 차단(영역 단위 이벤트라서??)

		// tr 가져오는 방법이 다름.
		let tr = e.target.parentElement; //이벤트를 대상으로 tr영역을 찾아야 함.
		// this : 1) 함수 영역의 window 2) 이벤트 대상 3) 객체에서는 객체  
		tr = this;
		
		document.getElementById('fname').value = tr.children[0].innerHTML;
		document.getElementById('faddress').value = tr.children[1].innerHTML;
		document.getElementById('fheight').value = tr.children[2].innerHTML;		
} // end of detailCallback.

// friend => tr 생성.
function makeTr(friend = {name: 'Hong', address: 'Seoul', height: 170}){

	// tr만드는 부분.
	let tr = document.createElement('tr');
	//tr.addEventListener('click',detailCallback);
	//tr.addEventListener('click',detailCallback, true);
	tr.addEventListener('click',detailCallback, false);

	
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
		e.stopPropagation(); // click : button > td > tr > ... : 버블링 차단
		e.target.parentElement.parentElement.remove();
	}, false); // defalut : false
	btn.innerHTML = '삭제';
	td.appendChild(btn);
	tr.appendChild(td);
	
	// 체크박스 추가.
	td = document.createElement('td');
	let inp = document.createElement('input');
	inp.setAttribute('type', 'checkbox'); // <button class="btn btn-danger">
	td.appendChild(inp);
	tr.appendChild(td);
	
	// 체크박스에 이벤트 등록
	inp.addEventListener('change', function(e){
		// thead의 체크박스 변경하기
			//let allCnt = document.querySelectorAll('div.container-fluid>table>tbody input[type="checkbox"]')
			//let cnkCnt = document.querySelectorAll('div.container-fluid>table>tbody input[type="checkbox"]:checked')
			//let theadCheck = document.querySelector('div.container-fluid>table>thead input[type="checkbox"]')
			let allCnt = document.querySelectorAll('#show>table>tbody input[type="checkbox"]')
			let cnkCnt = document.querySelectorAll('#show>table>tbody input[type="checkbox"]:checked')
			let theadCheck = document.querySelector('#show>table>thead input[type="checkbox"]')
			if(allCnt.length == cnkCnt.length){
				theadCheck.checked = true;
			} else {
				theadCheck.checked = false;
			}
	});
	
	td.appendChild(inp);
	tr.appendChild(td);

	
	return tr;
}