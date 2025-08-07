console.log("save.js test");

// [1] 등록 fetch , 동기
const save = async () => {
    // 1. 입력받은 값을 가져오기
    const snameInput = document.querySelector(".sname");
    const skorInput = document.querySelector(".skor");
    const smathInput = document.querySelector(".smath");
    const sname = snameInput.value;
    const skor = skorInput.value;
    const smath = smathInput.value;

    // 2. 입력받은 값을 객체화 하기
    const object = { sname : sname , skor : skor , smath : smath }
    // 속성명과 속성값 명이 같으면 생략 가능,  아래처럼 해도됨
    // const data = { sname , skor , smath }

    // 3. 배열에 저장하기 였지만 , 이제는 x
    // fetch option
    const option = {
        method : "post",
        headers : {"Content-Type": "application/json"},
        body : JSON.stringify(object)
    } // option e

    // 4. fetch 동기 실행
    const response = await fetch( "/student/save" , option )
    const data = await response.json();

    // 5. 만약에 결과가 true 이면
    if(data == true ){
        alert("등록 성공");
        location.href = "/student/find.jsp"; // JS 에서 페이지 전환
    }else{
        alert("등록 실패");
    }

    // ------> 원래 fetch 쓰기 전에는 로컬이나 배열에 저장해서 썼음
    // 이제는 fetch 써서 java에서 쓴 db 와 연동해서 쓸거임 지금처럼.

    // 백엔드 만듬 ---> 탈랜드로 테스트 ---> fetch 로 js 연동 ---> 굿 


} // func e