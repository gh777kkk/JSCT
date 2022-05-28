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

const [lineCount, brandCount] = input().split(' ').map(v => Number(v));
const setCount = Math.ceil(lineCount / 6);
const remainder = lineCount % 6;
let result = 1000;
let minSetPrice = 1000;
let minEachPrice = 1000;

for(let i = 0; i < brandCount; i++){
    const [all, one] = input().split(' ').map(v=>Number(v));
    minSetPrice = Math.min(all, minSetPrice);
    minEachPrice = Math.min(one, minEachPrice);
}

const combination = minSetPrice * (setCount -1) + (remainder * minEachPrice) ;
result = Math.min(minSetPrice * setCount, minEachPrice * lineCount, combination);

console.log(result); // 결과 값 출력
