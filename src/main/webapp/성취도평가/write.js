console.log("write.js test");

// 회원번호 자동생성
const setNextCustno = async () => {
  try {
    const response = await fetch('/member/next-custno');
    const data = await response.json();
    document.getElementById('custno').value = data;       // HTMl 문서에서 id = "custno" 인 태그 찾는 메소드 , 서버에서 받아온 data를 input 태그 안에 자동 넣어주기
  } catch (error) {
    console.error('Error fetching next custno:', error);
  }
};

document.addEventListener("DOMContentLoaded", setNextCustno); // 이벤트 리스너 등록 , 이벤트는 HTML 문서 모두 로딩되고 파싱 끝났을 때 발생 , HTML이 다 준비되면 setNextCustno 함수 실행

// 등록
const memberAdd = async () =>{
    const custname = document.querySelector(".custname").value;
    const address = document.querySelector(".address").value;
    const phone = document.querySelector(".phone").value;
    const grade = document.querySelector(".grade").value;
    const city = document.querySelector(".city").value;
    const joindate = document.querySelector(".joindate").value;

    const obj = {custname , address , phone , grade , city , joindate };

    const option = {
        method : "POST" ,                                       // HTTP METHOD(보내는방법) 
        headers : { "Content-Type" : "application/json" },      // HTTP HEADER(부가정보/설정)
        body : JSON.stringify( obj )                            // HTTP BODY(보내는내용물)
    }

    const response = await fetch("/member/add" , option);
    const data = await response.json();

    if(data == true ){
      alert("대기 등록 성공!");
      location.href = "/성취도평가/memberlist.jsp"
    }else{
      alert("대기 등록 실패!");
    }

} // func e