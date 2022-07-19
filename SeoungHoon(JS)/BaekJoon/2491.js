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

let result = 0;
let tempResult = 1;
let equalLength = 0;
const N = +input();
const list = input().split(' ').map(v=>Number(v));
let isIncreaseSequence = true;

for(var i = 1; i < N; i++){
    if(list[i-1] == list[i]){
        tempResult++;
        equalLength++;
    }
    else if(list[i-1] < list[i] && isIncreaseSequence){
        tempResult++;
        equalLength = 0;
    }
    else if(list[i-1] > list[i] && !isIncreaseSequence){
        tempResult++;
        equalLength = 0;
    }
    else {
        result = Math.max(result, tempResult);
        tempResult = 2 + equalLength;
        equalLength = 0;
        isIncreaseSequence = !isIncreaseSequence;
    }
}

console.log(Math.max(result, tempResult)); // 결과 값 출력
