// [*] 썸머노트 실행
$(document).ready(function() {
    $('#summernote').summernote({
        lang: 'ko-KR' , // default: 'en-US'
        minHeight : 300 , // 썸머노트 구역 최소높이
        placeholder : '여기에 내용 입력해주세요.' , // 가이드 라인
    });
});



console.log("write.js test");

// [1] 글쓰기 요청
const onWrite = async () => {

    // 1. 첨부파일 있는 게시물 : multipart/form vs 에디터 : 첨부파일 없고 내용에 텍스트 + 이미지 포함 
    const cno = document.querySelector(".cno").value;
    const ptitle = document.querySelector(".ptitle").value;
    const pcontent = document.querySelector(".pcontent").value;

    // 2. 
    const obj = { cno , ptitle , pcontent };
    const option = {
        method : "post" ,
        headers : {"content-type" : "application/json"},
        body : JSON.stringify(obj)
    }
    try{
        const response = await fetch("/post" , option);
        const data = await response.json();
        if(data > 0 ){
            alert("등록성공!");
        }else{
            alert("등록실패!");
        }
    }catch(e){ console.log(e);}

} // func e