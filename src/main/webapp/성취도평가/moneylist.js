
const moneyPrint = async () => {
    const response = await fetch("/member/money");
    const data = await response.json();
    const moneylistTbody = document.querySelector("#moneylistTbody");

    let html = '';
    for( let i = 0; i < data.length ; i++){
        const moneylist = data[i];
        html += `<tr>
                    <td>${moneylist.custno}</td>
                    <td>${moneylist.custname}</td>
                    <td>${moneylist.grade}</td>
                    <td>${moneylist.sales}</td>
                </tr>`
    } // for e

    moneylistTbody.innerHTML = html;

} // func e
moneyPrint();