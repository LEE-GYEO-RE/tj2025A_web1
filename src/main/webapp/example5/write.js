console.log("write.js test");

// 등록
const waitingAdd = async () => {
    console.log("waitingAdd test");

    const phone = document.querySelector('.phone').value;
    const count = document.querySelector('.count').value;
    const obj = {phone , count};

    const option = {
        method : "POST" ,                                       // HTTP METHOD(보내는방법) 
        headers : { "Content-Type" : "application/json" },      // HTTP HEADER(부가정보/설정)
        body : JSON.stringify( obj )                            // HTTP BODY(보내는내용물)
    }
    const response = await fetch("/waiting" , option );
    const data = await response.json();

    if( data == true ){
        alert("대기 등록 성공!");
        location.href = "/example5/list.jsp"
    }else{
        alert("대기 등록 실패!");
    }
} // func e