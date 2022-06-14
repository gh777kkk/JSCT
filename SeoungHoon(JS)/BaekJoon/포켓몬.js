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

const [pocketmonCount, problemCount] = input().split(' ').map(v => Number(v));
let pocketmons = [];
let result = [];
for(let i = 0; i < pocketmonCount; i++ ){
    pocketmons.push(input()); 
}

const pocketmonMap = new Map(pocketmons.map((v,i) => [v, i+1]))

for(let i =0; i<problemCount; i++){
    const value = input();
    if(Number.isNaN(parseInt(value))){
        result.push(pocketmonMap.get(value));
    }else{
        result.push(pocketmons[Number(value) -1]);
    }
}

console.log(result.join('\n')); // 결과 값 출력
