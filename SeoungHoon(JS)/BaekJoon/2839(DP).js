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

const weight = +input();

let result = Math.floor(weight/5);
let remainder = weight % 5;
let count = 3;
while(count > 0 && result > -1){
    if(remainder % 3 == 0){
        result += remainder / 3;
        break;
    }
    else {
        remainder += 5;
        result -= 1;
    }
    
    count--;
}

console.log(count == 0 ? -1 :result);
