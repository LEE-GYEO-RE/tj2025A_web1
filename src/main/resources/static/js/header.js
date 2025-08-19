// * JS 실행 확인
console.log("header.js test");

// [1] 내정보 요청해서 메뉴 나누기
const myinfo = async () =>{
    const logMenu = document.querySelector('#log-menu');    // 어디에?
    let html = '';                                          // 무엇을?
    try {
        // 1. fetch  실행
        const option = { method : "get"}
        const response = await fetch("/member/info" , option ); 
        const data = await response.json(); console.log(data);
        // ** 비로그인시 응답자료가 null 이라서 .json() 타입변환 못하고 함수에서 오류 발생. -> catch로 이동 **
        // 2. [로그인중] 로그인 했을 때 정상 통신 fetch
        html +=`<li> <span>${data.mid}님 </span></li>
                <li><a href="/member/info.jsp"> 내정보 </a></li>
                <li><a href="#" onclick="logout()"> 로그아웃 </a></li>`
    }catch{
        // 2. [비로그인중] 로그인 안했을 때 비정상 통신 fetch
        html += `<li> <a href="/member/login.jsp"> 로그인 </a></li>
                <li> <a href="/member/signup.jsp"> 회원가입 </a></li>
                <li> <a href="/member/find.jsp"> 아이디/비번찾기 </a></li>
                `
    }

    logMenu.innerHTML = html; // 출력

} // func e
myinfo(); // header.jsp 열릴 때마다 1번 최초 실행


// [2] 로그아웃
// 1. GET/DELETE 형식 
const logout = async() =>{
    try{
        // 1. fetch 실행
        const option = { method : "GET"}
        const response = await fetch( "/member/logout" , option );
        const data = await response.json(); console.log(data);
        // 2. fetch통신 결과
        if( data == true ){
            alert("로그아웃 했습니다.")
            location.href="/index.jsp";
        }else{
            alert("비정상 요청 및 관리자에게 문의");
        }
    }catch{ }
} // func e

