console.log("example3.js test")

// (1) 비동기 fetch
// 람다식 함수 : const func1 = ( ) => { }
// 선언적 함수 : function func1(){}

// 비동기(여러작업을 동시적으로 처리) 이기 때문에 ,
// fetch 가 실행되고 결과(response)가 오기전에 다음코드로 이동

// func1() 의 예측 : console 찍히는게 1 , 2 , 3 나와야 하는데 1 , 3 , 2 가 나옴
// 즉] JS는 응답을 기다리지 않는다.

// 동기화 하려면 fetch 앞에 await 써야함 쓰고 , then 쓰지 않음
//  그럼 1 , 2 , 3 찍힐 거임

// (1) 비동기 fetch : 여러개의 흐름
const func1 = ( ) => {
    console.log("[1] fetch 전")
    // (fetch)
    const option = { method : "GET"}
    fetch("/day06/exam1" , option)
        .then( response => response.json())
        .then( data => {
            console.log(data)
            console.log("[2] fetch 통신 결과")
        })
        .catch( error => {console.log(error)})

    console.log("[3] fetch 후")
} // func1 e

// (2) 동기 fetch : 하나의 흐름 , 관례적으로 동기식으로 fetch 쓰는게 많음
// async : 이거 안쓰면 안뜸
const func2 = async () => {

    console.log("[1] fetch 전 ")
    // (fetch)
    const option = { method : "GET" }
    try {
        const response = await fetch( "/day06/exam1" , option )
        const data = await response.json();
        console.log( data );
    }catch( error ){
        console.log( error );
    }
    console.log("[2] fetch 통신 결과 ")

    console.log("[3] fetch 후 ")


} // func2 e