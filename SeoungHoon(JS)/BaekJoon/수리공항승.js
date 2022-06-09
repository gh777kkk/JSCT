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
const [leakedPointCount, tapeLength] = input().split(' ').map(value => Number(value));
const leakedPoints = input().split(' ').map(value => Number(value)).sort((a,b) => a-b);
let result = leakedPointCount > 0 ? 1 : 0;

for(let i = 0; i < leakedPointCount -1; i++){
    const distance = leakedPoints[i+1] - leakedPoints[i];
    if (distance < tapeLength){
        leakedPoints[i+1] = leakedPoints[i];
    } else {
        result++;
    }
}

console.log(result);// 결과 값 출력
