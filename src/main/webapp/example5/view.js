console.log("view.js test");

// 개별 조회
const waitingFind = async () => {

    console.log("watingFind test");
    const url = new URLSearchParams(location.search);
    const wno = url.get('wno');
    const response = await fetch(`/waiting/find?wno=${wno}`);
    const data = await response.json();

    const phoneBox = document.querySelector('.phoneBox');
    const countBox = document.querySelector('.countBox');
    const phone = data.phone;
    const count = data.count;

    phoneBox.innerHTML = phone;
    countBox.innerHTML = count;

} // func e
waitingFind();

// 삭제
const waitingDelete = async () => {
    console.log("waitingDelete test");

    const wno = new URLSearchParams( location.search).get('wno');
    
    let check = confirm('진짜 삭제할겁니까?');
    if(check == true){
        const option = { method : "delete"}
        const response = await fetch(`/waiting?wno=${wno}` , option );
        const data = await response.json();
        if(data == true ){
            alert("삭제 성공!!");
            location.href = "/example5/list.jsp"
        }else{
            alert("삭제 실패!!")
        }
    } // if e

} // func e

// 수정 페이지 이동
const waitingUpdateView = () => {

    console.log("waitingUpdateView test");
    const wno = new URLSearchParams(location.search).get('wno');
    location.href = `/example5/update.jsp?wno=${wno}`;
} // func e