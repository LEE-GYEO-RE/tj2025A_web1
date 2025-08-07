console.log("print.js test");

// 대기 현황 조회
const print = async ()=>{
    // fetch option
    const option = {method : "get"}

    // fetch 동기화 실행
    const response = await fetch("/waiting/print" , option )

    // 응답객체 json 변환
    const data = await response.json();

    // HTML 구성
    const waitingTbody = document.querySelector("#waitingTbody");

    let html = "";
    for( let i = 0 ; i < data.length ; i++ ){
        const waiting  = data[i];
        html += `<tr>
                    <td>${waiting.wno}</td>
                    <td>${waiting.phone}</td>   
                    <td>${waiting.count}</td>
                    <td>${waiting.wdate}</td>
                
                </tr>`
    } // for e

    // 출력
    waitingTbody.innerHTML = html;
} // func e
print(); // js 실행시 최초 실행