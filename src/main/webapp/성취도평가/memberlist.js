
// 전체 조회
const memberPrint = async () => {
    const response = await fetch("/member");
    const data = await response.json();
    const memberlistTbody = document.querySelector("#memberlistTbody");

    let html = '';
    for( let i = 0; i < data.length ; i++ ){
        const memberlist = data[i];
        html += `<tr> 
                    <td><a href = "update.jsp?custno=${memberlist.custno}">${memberlist.custno}</a></td>
                    <td>${memberlist.custname}</td>
                    <td>${memberlist.phone}</td>
                    <td>${memberlist.address}</td>
                    <td>${memberlist.joindate}</td>
                    <td>${memberlist.grade}</td>
                    <td>${memberlist.city}</td>
                </tr>`
    }
    memberlistTbody.innerHTML = html;
} // func e
memberPrint();