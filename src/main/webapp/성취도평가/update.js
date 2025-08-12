
// 조회한 회원 수정
const memberUpdate = async () => {
    const custno = new URLSearchParams(location.search).get('custno');
    const custname = document.querySelector('.custname').value;
    const phone = document.querySelector('.phone').value;
    const address = document.querySelector('.address').value;
    const joindate = document.querySelector('.joindate').value;
    const grade = document.querySelector('.grade').value;
    const city = document.querySelector('.city').value;

    const obj = { custno , custname , phone, address , joindate , grade , city };
        const option = {
        method : "PUT",
        headers : { "Content-Type" : "application/json"},
        body : JSON.stringify( obj )
    }
    const response = await fetch("/member/update" , option );
    const data = await response.json();

    if( data == true) {
        alert("수정 성공!");
        location.href = `/성취도평가/memberlist.jsp`
    }else{
        alert("수정 실패!")
    }

} // func e