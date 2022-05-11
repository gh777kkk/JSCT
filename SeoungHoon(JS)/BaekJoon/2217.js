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

let count = +input();
let lopes = [];
for(let i = 0; i < count; i++ ){
    lopes.push(+input()); 
}

lopes = lopes.sort((a,b) => a - b); // 오름차순 정렬
var maxWeights = lopes.map((element, index) => element * (count - index)); // 각각의 값이 사용되었다고 가정했을 때 최대 중량을 계산
console.log(Math.max(...maxWeights)); 
