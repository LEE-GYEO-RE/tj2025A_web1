console.log('update.js test');

// 개별 조회
const waitingFind = async () => {
    console.log("waitingFind test");
    const wno = new URLSearchParams(location.search).get('wno');
    const response = await fetch(`/waiting/find?wno=${wno}`);
    const data = await response.json();
    document.querySelector('.phone').innerHTML = data.phone;
    document.querySelector('.count').innerHTML = data.count;

} // func e
waitingFind();

// 개별 수정
const waitingUpdate = async () => {
    console.log("waitingUpdate test");

    const wno = new URLSearchParams(location.search).get('wno');
    const phone = document.querySelector('.phone').value;
    const count = document.querySelector('.count').value;

    const obj = {wno , phone , count };
        const option = {
        method : "PUT",
        headers : { "Content-Type" : "application/json"},
        body : JSON.stringify( obj )
    }
    const response = await fetch("/waiting" , option );
    const data = await response.json();

    if( data == true ){
        alert('수정 성공!');
        location.href = `/example5/view.jsp?wno=${wno}`
    }else{
        alert('수정 실패!!')
    }
} // func e