function 로그인() {
	id2 = 'root';
	id = prompt('아이디 입력');
	if (id == id2) { //무조건 == 
		alert('로그인 성공')
	} else {
		alert('로그인 실패')
	}
}

function 비교() {
	n = prompt('숫자 입력');
	n1 = 100;
	n2 = 200;
	

	if (n == n2 || n == n1) {
		alert('동일한 숫자')
	} else {
		alert('동일하지 않은 숫자')
	}
	
}

function 기분() {
	f = prompt('친구의 기분은?')
	m = prompt('나의 기분은?')

	if (f == m) {
		alert('똑같네!!')
	} else {
		alert('우린 달라')
	}
}
	
	
	
	
	
