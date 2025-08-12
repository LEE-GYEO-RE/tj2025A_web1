console.log("list.js test");

// 전체 조회
const waitingPrint = async () => {
    console.log("waitingPrint test");
    
    const response = await fetch("/waiting");
    const data = await response.json();
    const waitingTbody = document.querySelector("#waitingTbody");

    let html = '';
    for( let i = 0; i < data.length ; i++){
        const waiting = data[i];
        html += `<tr> 
                    <td> ${waiting.wno} </td>
                    <td> 
                        <a href = "/example5/view.jsp?wno=${waiting.wno}">
                            ${waiting.phone}
                        </a>    
                    </td>
                    <td>${waiting.count}</td>
                </tr>`
    } // for e

    waitingTbody.innerHTML = html;


} // func e
waitingPrint();