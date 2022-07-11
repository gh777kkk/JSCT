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
const [pointCount, lineCount] = input().split(' ').map(value => Number(value));
let map = Array.from({length : pointCount}, v => []);
let checks = new Set();
let result = 0;

for(let i = 0; i < lineCount; i++){
    const [a, b] = input().split(' ').map(value => Number(value)).sort((a,b) => a-b);
    map[a-1].push(b);
    map[b-1].push(a);
}

function dfs(startPoint){
    if(!checks.has(startPoint)) {
        checks.add(startPoint);
        map[startPoint -1].forEach(value => dfs(value));
    }
}

for(let i = 0; i < pointCount; i++){
    let startPoint = i + 1;
    if(!checks.has(startPoint)){
        dfs(startPoint);
        result++;
    }
}

console.log(result);// 결과 값 출력
