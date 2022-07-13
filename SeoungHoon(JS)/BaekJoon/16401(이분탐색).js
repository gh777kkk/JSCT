const fs = require("fs");
const stdin = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString()
    : `` // 기본 입력값 설정 (백준 코딩테스트에서 비워놔도 무방하다.)
).split("\n");

const input = (() => {  //input()을 호출할 때마다 한줄씩 읽어온다.
  let line = 0;
  return () => stdin[line++];
})(); 

const [M, N] = input().split(' ').map(v=>Number(v));
const array = input().split(' ').map(v=>Number(v));

let start = 0; 
let end = Math.max(...array);

while(start < end){
    let middle = Math.ceil((end + start) / 2);
    
    let sum = array.reduce((a,b)=> a + Math.floor(b/middle), 0);
    if(sum < M){
        end = middle - 1;
    }
    else {
        start = middle;
    }
}

console.log(end); // 결과 값 출력
