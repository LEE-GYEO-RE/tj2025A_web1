console.log("write.js test");

// 회원번호 자동생성
const setNextCustno = async () => {
  try {
    const response = await fetch('/member/next-custno');
    const data = await response.json();
    document.getElementById('custno').value = data;
  } catch (error) {
    console.error('Error fetching next custno:', error);
  }
};

document.addEventListener("DOMContentLoaded", setNextCustno);

/*
5. document.getElementById('custno').value = data;
document.getElementById('custno')는 HTML 문서에서 id="custno"인 태그(여기서는 <input>)를 찾는 거야.

.value는 그 <input> 태그에 입력된 값 또는 보여지는 값을 의미해.

그래서 서버에서 받아온 data를 <input> 태그 안에 자동으로 넣어주는 거야.

6. document.addEventListener("DOMContentLoaded", setNextCustno);
이건 이벤트 리스너 등록하는 거야.

"DOMContentLoaded" 이벤트는 HTML 문서가 모두 로딩되고 파싱이 끝났을 때 발생해.

즉, HTML이 다 준비되면 그때 setNextCustno 함수를 실행하라는 뜻이야.

이렇게 해야 <input id="custno">가 아직 안 만들어진 상태에서 값을 넣으려는 오류를 막을 수 있어. */