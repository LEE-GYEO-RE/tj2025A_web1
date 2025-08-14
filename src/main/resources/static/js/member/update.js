console.log("update.js test");


// 기존 정보 불러오기
const onInfo = async () =>{
        try{
        const option = { method : "GET"}
        const response = await fetch( "/member/info" , option );
        const data = await response.json();
        document.querySelector(".mno").innerHTML = data.mno;
        document.querySelector(".mid").innerHTML = data.mid;

    }catch(error){ console.log(error); }
}
onInfo();

// 회원 정보 수정
const onUpdate = async() =>{
    const mname = document.querySelector(".mname").value;
    const mphone = document.querySelector(".mphone").value;

    const obj = { mname , mphone };
    try{
        const option = { 
            method : "put",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify( obj )
        }
        const response = await fetch( "/member/update" , option );
        const data = await response.json();

        if( data == true ){
            alert("수정 성공!");
            location.href = "/index.jsp";
        }else{
            alert("수정 실패")
        }
    }catch(error){ console.log( error );
    }
} // func e

