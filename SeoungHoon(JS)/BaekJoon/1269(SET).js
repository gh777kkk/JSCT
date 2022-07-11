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

let [A, B] = input().split(' ').map(value => Number(value));
let AList = input().split(' ').map(value => Number(value));
let BList = input().split(' ').map(value => Number(value));

const ASet = new Set(AList);
let intersectionCount = 0;

for(let i = 0; i < B; i++ ){
    if(ASet.has(BList[i])){
        intersectionCount++;
    }
}

console.log(A + B - (intersectionCount * 2)); // 대칭 차집합을 교집합을 빼줌으로 구했다.
