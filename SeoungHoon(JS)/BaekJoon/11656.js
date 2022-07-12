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

let array = [];
let s = input().split('');

for(let i = 0; i < s.length; i++){
    array.push(s.slice(i, s.length).join(''));
  
}

console.log(array.sort().join("\n")); // 결과 값 출력
