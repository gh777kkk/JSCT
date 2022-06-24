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
const count = +input();
const stairList = [];
const totalList = new Array(count).fill(0);
for(let i = 0; i < count; i++){
    stairList.push(+input());  
}

totalList[0] = stairList[0];
totalList[1] = Math.max(stairList[0] + stairList[1], stairList[1]);
totalList[2] = Math.max(stairList[0] + stairList[2], stairList[1] + stairList[2]); 


for (let i = 3; i < count; i++){ // DP를 이용하여 최대값을 계산
    totalList[i] = Math.max(stairList[i -1] + totalList[i-3], totalList[i -2]) + stairList[i];
}


console.log(totalList[count -1]);
