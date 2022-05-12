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

let bridgeLength = +input();
let lampCount = +input();
let lampPositions = input().split(' ').map(v => +v);
let maxSpace = lampPositions[0];
lampPositions.forEach((currentPosition, index) => {
    let space = 0;
    if ((index + 1) == lampCount) {
        space = bridgeLength - currentPosition; // 마지막은 가로등이 하나로 전부 채워야함
    } else {
        space = Math.ceil((lampPositions[index + 1] - currentPosition) / 2); // 가로등 사이를 채우는데 필요한 공간 값을 구함 가로등 공간은 정수이므로 ceil 해줌
    }
    
    maxSpace = Math.max(maxSpace, space);
    
});

console.log(maxSpace); // 결과 값 출력
