
console.log("update.js test");

const params = new URL(location.href).searchParams;
const pno = params.get('pno'); console.log(pno);



// [*] 썸머노트 실행
$(document).ready(function() {
    $('#summernote').summernote({
        lang: 'ko-KR' , // default: 'en-US'
        minHeight : 300 , // 썸머노트 구역 최소높이
    });
});

// 기존 게시물 정보 가져오기
const getPost = async () => {
    const respone = await fetch(`/post/view?pno=${pno}`); // option  생략
    const data = await respone.json();

    document.querySelector('.cno').value = data.cno;
    document.querySelector('.ptitle').value = data.ptitle;
    document.querySelector('.note-editable').innerHTML = data.pcontent;

} // func e


// 수정처리
const updatePost = async () =>{

    const cno = document.querySelector(".cno").value;
    const ptitle = document.querySelector(".ptitle").value;
    const pcontent = document.querySelector(".pcontent").value;

    // 2. 
    const obj = { cno , ptitle , pcontent , pno };
    const option = {
        method : "put" ,
        headers : {"content-type" : "application/json"},
        body : JSON.stringify(obj)
    }
    try{
        const response = await fetch("/post" , option);
        const data = await response.json();
        if( data > 0 ){
            alert("수정 성공!");
            location.href = `post.jsp?cno=1`;
        }else{
            alert("수정 실패!");
        }
    }catch(e){ console.log(e);}

} // func e

// 이전 작성내용 최초 실행
getPost();