console.log("findId.js test");


// 아이디 찾기
const findMid = async() =>{

    const mname = document.querySelector(".mname").value;
    const mphone = document.querySelector(".mphone").value;

    const obj = { mname , mphone }

    try{
        const option = { 
            method : "POST",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify( obj )
        }
        const response = await fetch( "/member/find" , option );
        const data = await response.json();
        if( data.mid != null  ){
            alert(`당신의 아이디는 ${data.mid}입니다.`)
        }else{
            alert("이름이나 연락처가 일치하지 않습니다.")
        }

    }catch(error){ console.log(error); }
} // func e