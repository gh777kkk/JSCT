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
let zeroCountList = [1,0,1,1];
let oneCountList = [0,1,1,2];
let zeroCount = 0;
let oneCount = 0;

function fibonacci(n) {
    if(zeroCountList.length <= n){
        for(let i = zeroCountList.length; i <= n; i++){
            zeroCountList.push(zeroCountList[i-2] + zeroCountList[i-1]);
            oneCountList.push(oneCountList[i-2] + oneCountList[i-1]);
        }
    }
    zeroCount = zeroCountList[n];
    oneCount = oneCountList[n]
}

for(let i = 0; i < count; i++ ){
    const value = +input();
    fibonacci(value);
    console.log(zeroCount + ' ' + oneCount);
    zeroCount = oneCount =0;
}
