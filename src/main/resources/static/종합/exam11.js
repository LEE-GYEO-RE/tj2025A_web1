// 1. 연동 테스트
console.log("1.exam11.js"); // 1.exam11

// 2. 함수 연동 테스트
// 일반 함수 선언 : function 함수명( ){ }

// 람다식 함수 선언 : const 함수명 = ( ) => { }
// 람다식으로 쓰셈 그게 최신임

// 3. 등록
const boardWrite = ( ) => {
    console.log("boardWrite() 테스트");

    // 3. 함수 기능 구현 - fetch
    // (1) 보낼 데이터 객체 준비 - 샘플
    let data = {"bcontent" : "JS테스트중" , "bwriter" : "유재석"}

    // (2) fetch 옵션 : 3가지 ( method , headers , body )
    let option ={
        method : "POST" , // 1) method
        headers : { "Content-Type" : "application/json"} , // 2) headers
        body : JSON.stringify( data ) // 3) body
    } // option e
    // (3) fetch ( url , option )
    //      .then( response => response.json() )    // 응답자료를 타입변환
    //      .then( data => { } )                    // 타임변환된 자료
    //      .catch(error=> {} )
    fetch("/board" , option )
            .then( response => response.json() )
            .then( data => { console.log(data) } )
            .catch( error => {console.log(error) } )

} // func e

// 4. 전체 조회
const boardPrint = () => {
    console.log("boardPrint() 테스트")
    // (1) 보낼 데이터 - 없음
    // (2) fetch option , GET 생략가능
    let option = { method : "GET"}
    // (3) fetch 실행
    fetch("/board" , option )
        .then( response => response.json() )
        .then( data => { console.log( data) } )
        .catch( error => { console.log( error ) } )
} // func e

// 5. 삭제
const boardDelete = () => {
    console.log("boardDelete() 테스트 ")
    // 1) 보낼 데이터 준비 - 샘플
    let bno =3; // 존재하는 bno 3번으로 테스트
    // 2) fetch option 준비
    let option = { method : "DELETE"}
    // 3) fetch 실행 (url에 쿼리스트링 써서 몇번인지 쓰는데 , `백틱${}` 사용해야함)
    fetch(`/board?bno=${bno}` , option )
        .then( response => response.json())
        .then( data => { console.log( data )})
        .catch( error => {console.log( error )})

} // func e

// 6. 수정
const boardUpdate = () => {
    console.log( "boardUpdate() 테스트 ")
    // 1) 보낼 데이터 - 뭐를 수정할거냐?
    let data = {"bno" : 4 , "bcontent" : "JS에서수정테스트"}
    // 2) fetch option 준비
    let option = {
        method : "PUT", // http 메소드
        headers : {"Content-Type" : "application/json"},    // 보낼 자료의 타입
        body : JSON.stringify( data ) // 보낼 자료
    }
    // 3) fetch  실행
    fetch("/board", option )
         .then( response => response.json())
         .then( data => { console.log( data )})
         .catch( error => {console.log( error )})

} // func e
























