console.log("signup.js test");

// [1] 회원가입 처리

const signup = async() =>{

    // 만약에 유효성 검사 체크리스트에 false가 존재하면 회원가입 진행 불가능.
    if(signPass[0] == false ){
        alert("올바른 정보를 입력 후 가능합니다.");
        return;
    }

    // 1. 마크업의 DOM 객체 가져오기
    const idInput = document.querySelector(".idInput");
    const pwdInput = document.querySelector(".pwdInput");
    const nameInput = document.querySelector(".nameInput");
    const phoneInput = document.querySelector(".phoneInput");

    // 2. DOM 객체에서 입력받은 값 가져오기
    const mid = idInput.value;
    const mpwd = pwdInput.value;
    const mname = nameInput.value;
    const mphone = phoneInput.value;

    // 3. 객체화 시키기
    const obj = { mid , mpwd , mname , mphone };

    // 4. fetch 실행
    try{
        const option = { 
            method : "POST",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify( obj )
        }
        const response = await fetch( "/member/signup" , option );
        const data = await response.json();
        // 5. fetch 결과
        if( data > 0 ){
            alert(" 회원가입 성공!");
            location.href = "/member/login.jsp";
        }else{
            alert("회원가입 실패!!")
        }
    }catch(error){ console.log(error) }
} // func e

// <마크업> 이벤트 : onclick( 해당 마크업을 클릭했을 때 ) , onkeyup( 해당 마크업에 키를 땠을때 )

// *** 유효성검사 체크리스트 ***
const signPass = [false]; // 초기값은 실패 , 0인덱스 : 아이디체크 , 1인덱스 : 연락처 체크

// [2] 아이디 중복검사 : 입력할때마다 발동
const idCheck = async() =>{

    // 1. DOM객체 가져와서 DOM 객체에서 입력받은 값 한번에 가져오기
    const mid = document.querySelector(".idInput").value;
    const idCheck = document.querySelector(".idCheck");

    // 2. 유효성 검사1 길이검사
    if( mid.length < 6 ){
        idCheck.innerHTML = "아이디는 6글자 이상으로 가능합니다."
        signPass[0] = false; // 유효성 검사 상태 변경
        return; // 함수 강제 종료 , 아래코드는 실행 안됨.
    }

    // 2. 유효성 검사2 중복검사 , /member/check?type=검사할속성명&data=${검사할데이터}
    try{
        const option = { method : "GET"}
        const response = await fetch( `/member/check?type=mid&data=${mid}` , option );
        const data = await response.json();
        if( data == true ){
            idCheck.innerHTML = "사용중인 아이디 입니다." 
            signPass[0] = false; // 유효성 검사 상태 변경
        }else{
            idCheck.innerHTML = "사용가능한 아이디 입니다."
            signPass[0] = true; // 유효성 검사 상태 변경
        }
    }catch{

    }
} 


// [3] 연락처 중복검사 : 입력할때마다 발동
const phoneCheck = async() =>{
    // 1. DOM객체 가져와서 DOM 객체에서 입력받은 값 한번에 가져오기
    const mphone = document.querySelector(".phoneInput").value;
    const phoneCheck = document.querySelector(".phoneCheck");

    // 유효성 검사 체크리스트
    const signPass = [false];

    // 2. 유효성 검사 , 중복검사 , /member/check?type=검사할속성명&data=${검사할데이터}
    try{
        const option = { method : "GET"}
        const response = await fetch( `/member/check?type=mphone&data=${mphone}` , option );
        const data = await response.json();
        if( data == true ){
            phoneCheck.innerHTML = "사용중인 연락처가 있습니다.."
            signPass[0] = false; // 유효성 검사 상태 변경
        }else{
            phoneCheck.innerHTML = "등록된 연락처 없습니다."
            signPass[0] = true; // 유효성 검사 상태 변경
        }
    }catch{

    }
} 
