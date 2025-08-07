console.log("add.js test");

// 등록 fetch , 동기화

const add = async () => {
    const phoneInput = document.querySelector(".phone");
    const countInput = document.querySelector(".count");
    const phone = phoneInput.value;
    const count = countInput.value;

    // 입력받은 값 객체화
    const object = { phone , count }

    // fetch option
    const option = {
        method : "post",
        headers : {"Content-Type": "application/json"},
        body : JSON.stringify(object)
    } // option e

    // fetch 동기 실행
    const response = await fetch("/waiting/add" , option )
    const data = await response.json();

    if(data == true ){
        alert("등록 성공")
        location.href = "/waiting/print.jsp";
    }else{
        alert("등록 실패")
    } // if e


} // func e