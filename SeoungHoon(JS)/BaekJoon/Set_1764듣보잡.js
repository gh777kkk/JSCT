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

let [aCount,bCount] = input().split(' ');
let aList = new Set();
let bList = new Set(); // Set을 이용하면 중복값을 자동으로 제거해주고 item이 있는지 확인하는 함수가 있다
let result = [];

for(let i = 0; i < aCount; i++ ){
   aList.add(input());
}

for(let i = 0; i < bCount; i++ ){
   bList.add(input());
}

let answer = [];
bList.forEach((item) => {
    if(aList.has(item)) answer.push(item);
})
answer.sort();

console.log(answer.length);
console.log(answer.join("\n"));
// 다른 방법으로는 이분탐색을 이용해서 진행할 수가 있습니다
