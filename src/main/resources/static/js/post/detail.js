
console.log("detail.js test");

const params = new URL(location.href).searchParams;
const pno = params.get('pno'); console.log(pno);

// [1] 개별조회 
const getPost = async()=>{
    // 1. fetch 로부터 출력할 게시물 조회 요청 
    const response = await fetch( `/post/view?pno=${ pno }` ); // GET 방식은 OPTION 생략가능
    const data = await response.json();
    // 2. 응답받은 자료를 특정한 html에 출력한다.
    document.querySelector('.mid').innerHTML = data.mid;
    document.querySelector('.pview').innerHTML = data.pview;
    document.querySelector('.pdate').innerHTML = data.pdate;
    document.querySelector('.ptitle').innerHTML = data.ptitle;
    document.querySelector('.pcontent').innerHTML = data.pcontent;
    // 3. 내가 쓴글이면 삭제버튼과 수정버튼 만들기
    if( data.host ){
        document.querySelector('.etcBox').innerHTML = `
                        <button type="button" onclick="deletePost()"> 삭제 </button>
                        <button type="button" onclick="location.href='update.jsp?pno=${ pno }' "> 수정 </button>
                        `
    }
} // func end


// 개별 삭제
const deletePost = async () =>{
    const option = { method : "delete"}
    const respone = await fetch(`/post?pno=${pno}` , option);
    const data = await respone.json();

    if( data == true ){
        alert("삭제 성공");
        location.href = 'post.jsp?cno=1' // 카테고리 번호 임의값 1 , 1번 카테고리로 이동
    }else{
        alert("삭제 실패");
    }

} // func e


// 댓글 등록
const writeReply = async () =>{
    const rcontent = document.querySelector(".rcontent").value;
    const obj = { pno , rcontent }
    const option = {
        method : "post" , 
        headers : { "content-type" : "application/json"},
        body : JSON.stringify(obj)
    }

    const respone = await fetch(`/post/reply` , option);
    const data = await respone.json();

    if(data == 0){
        alert(" 댓글 등록 실패");
    }else{
        alert(" 댓글 등록 성공")
        // 전체 댓글 조회 재렌더링(재호출)
        findAllReply();
    }
} // func e


// 댓글 조회 ( 최초 한번 실행 , 댓글쓰기 성공시 재호출 시 실행)
const findAllReply = async ()=>{
    const respone = await fetch(`/post/reply?pno=${pno}`);
    const data = await respone.json(); console.log(data);

    const replyList = document.querySelector(".replyList");

    let html = '';
        data.forEach( (reply) => { // data : [ {} , {} , {}] , reply : {} // forEach : 요소 하나씩
            html += `<div>
                        <div> 
                            작성자 : <span> ${ reply.mid } </span>
                            작성일 : <span> ${ reply.rdate } </span>
                        </div>
                        <div>
                            ${reply.rcontent}
                        </div>
                    </div>`
        });

    replyList.innerHTML = html;

}

// 최초 1번 실행되는 함수
getPost();
findAllReply();