console.log("info.js test")

// [1] 마이페이지 조회
const onInfo = async() =>{

    try{
        const option = { method : "GET"}
        const response = await fetch( "/member/info" , option );
        const data = await response.json();

        // fetch 결과 : 로그인 상태
        document.querySelector(".mno").innerHTML = data.mno;
        document.querySelector(".mid").innerHTML = data.mid;
        document.querySelector(".mname").innerHTML = data.mname;
        document.querySelector(".mphone").innerHTML = data.mphone;
        document.querySelector(".mdate").innerHTML = data.mdate;
    }catch(error){
        console.log(error);
        location.href = "/member/login.jsp";
    }
} 
onInfo();

// [2] 회원 탈퇴
const onDelete = async ()=>{
    // 삭제 확인
    let result = confirm("정말 탈퇴 하겠습니까?");
    if( result == false ){ return;} // 함수종료
    
    // 삭제 하기 위한 기존 패스워드 확인
    let oldpwd = prompt("현재 비밀번호를 입력하세요.");

    // fetch 실행
    try{
        const option = { method : "DELETE"}
        const response = await fetch( `/member/delete?oldpwd=${oldpwd}` , option );
        const data = await response.json();
        if( data == true ){
            alert("탈퇴 성공!"); location.href="/index.jsp"
        }else{
            alert("탈퇴 실패 : 현재 비밀번호가 일치하지 않습니다.")
        }
    }catch(error){ console.log(error)}
} // func e