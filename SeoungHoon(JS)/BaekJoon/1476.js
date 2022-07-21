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

let [E, S, M] = input().split(' ').map(v => Number(v));
E = E % 15;
S = S % 28;
M = M % 19;
let result = 1;
for(let i = 1; i <= 15 * 28 * 19; i = i + result){
    if(i % 15 == E){
        result = 15;
        if(i % 28 == S){
            result = 15 * 28;
            if(i % 19  == M){
                console.log(i);
                break;
            }
        }
    }
}
