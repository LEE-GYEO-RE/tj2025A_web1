console.log("pwdupdate.js test");

// 패스워드 수정

const onPwdUpdate = async() =>{

    const oldpwd = document.querySelector(".oldpwd").value;
    const newpwd = document.querySelector(".newpwd").value;
    const obj = { oldpwd , newpwd }
    try{
        const option = { 
            method : "put",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify( obj )
        }
        const response = await fetch( "/member/update/password" , option );
        const data = await response.json();

        if( data == true){
            alert("수정 완료!!");
            location.href = "/index.jsp";
        }else{
            alert("수정 실패!!");
        }
    }catch(error){ console.log(error); }
} // func e
