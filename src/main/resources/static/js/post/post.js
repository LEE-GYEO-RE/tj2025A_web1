
console.log("post.jsp test");

// [1] 사용자 요청한 URL 에서 cno(카테고리)/page(현페이지번호) 가져오기
// 현재 페이지의 URL에서 매개변수(?) 쿼리스트링 값 반환
const params = new URL(location.href).searchParams;
const cno = params.get('cno');      console.log(cno);
const page = params.get('page') || 1;       // 만약에 page 가 존재하지 않으면 1
const key = params.get('key') || '';        // 만약에 key 존재하지 않으면 '' 공백
const keyword = params.get('keyword') || '';


// [2] 요청 매개변수를 이용한 fetch 게시물 요청하기
const findAll = async () => {   console.log("findAll test");

    // 2-1  : try{}catch{}
    try{
        // 2-2 fetch 이용한 게시물 요청
        const url = `/post?cno=${ cno }&page=${ page }&key=${key}&keyword=${keyword}`;
        const respone = await fetch( url ); // get 형식은 option 생략가능
        const data = await respone.json();  console.log(data); // data <---> pageDto

        // 2-3 fetch 결과 inneHTML 테이블에 출력하기
        const postBody = document.querySelector(".postBody");
        let html = '';
            // fetch 로부터 받은 데이터를 html 문자열로 반환
            data.data.forEach((post) => {   // data.data <---> pageDto{data}
                // post <---> postDto{}
                html += `<tr>
                            <td> ${post.pno} </td>
                            <td> ${post.ptitle} </td>
                            <td> ${post.mid} </td>
                            <td> ${post.pdate} </td>
                            <td> ${post.pview} </td>
                        </tr>`
            })

        postBody.innerHTML = html;

        // 3. 페이징 버튼 출력 함수 호출
        viewPageButtons(data);

    }catch(e){console.log(e);}


} // func e
// [3] 페이징 버튼 출력 함수 , *** findAll 함수 안에서 아래부분 실행
const viewPageButtons = async (data)=>{

    // 백엔드로 부터 받은 pageDto <--> data{}
    let currentPage = parseInt(data.currentPage); // parseInt( 자료 ) : 자료를 int 타입으로 변환
    let totalPage = data.totalPage;
    let startBtn = data.startBtn;
    let endBtn = data.endBtn;

    // ************** 페이징 처리시 검색 유지 ****************** //
    const searchUrl = `&key=${key}&keyword=${keyword}`;

    const pageBtnBox = document.querySelector(".pageBtnBox");
    let html = '';
    // ********************** 이전버튼 : 만약 현재페이지가 1이하이면 1고정 *********************** //
    html += `<li> 
                <a href="post.jsp?cno=${ cno }&page=${currentPage <= 1 ? 1 : currentPage -1}${searchUrl}"> 이전 </a> </li>`
    // ********************** 페이지버튼 : startBtn 부터 endBtn 까지 1씩 증가 반복 *********************** //
    for( let i = startBtn; i <= endBtn ; i++){
        html += `<li> <a href="post.jsp?cno=${cno}&page=${i}${searchUrl}" style="${ i == currentPage ? 'color:red' : '' }"> ${i} </a> </li>`
    }

    // ********************** 다음버튼 : 만약 다음페이지가 전체페이지수보다 커지면 전체페이지수로 고정 *********************** //
    html += `<li> 
                <a href="post.jsp?cno=${ cno }&page=${currentPage+1 >= totalPage ? totalPage : currentPage +1}${searchUrl}"> 다음 </a> </li>`
    
    pageBtnBox.innerHTML = html;

} // func e

// [4] 검색 버튼 클릭했을때
const onSearch = async () =>{
    // 입력받은 key 와 keyword 값 가져오기
    const newKey = document.querySelector(".key").value;
    const newKeyword = document.querySelector(".keyword").value;

    // 페이지 이동 , 검색하면 주로 1페이지 이동
    location.href = `post.jsp?cno=${ cno }&page=${ 1 }&key=${newKey}&keyword=${newKeyword}`;


} // func e



findAll(); // JS 실행시 최초 1번 실행





