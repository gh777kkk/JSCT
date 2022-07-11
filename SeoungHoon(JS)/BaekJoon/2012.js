const fs = require("fs");
const stdin = ( process.platform === "linux"? fs.readFileSync("/dev/stdin").toString() : 
`` // 기본 입력값 설정 (백준 코딩테스트에서 비워놔도 무방하다.)
).split("\n");

const input = (() => {  //input()을 호출할 때마다 한줄씩 읽어온다.
  let line = 0;
  return () => stdin[line++];
})(); 

let count = +input();
let checks = Array.from({length : count}, v => false); // 원하는 등수로 할당할 수 있는지 검사한다.
const lefts = [];

for(let i = 0; i < count; i++ ){
    const valueIndex = +input() - 1; // 등수를 index로 치환
    if(checks[valueIndex] == false){
        checks[valueIndex] = true;
    }
    else {
        lefts.push(valueIndex); // 원하는 등수가 할당 되었으면 나머지로 분류한다
    }
}
lefts.sort((a,b) => a-b); //오름차순 정렬
checks = checks.map((v,i) => v == false ? i : -1).filter(v => v > -1).sort((a,b) => a-b); 
let result = 0; 
// 차이의 최소값을 구하므로 index끼리 계산하여도 무방
// 오름차순 정렬을 하였으므로 순서대로 계산하면 최소값이 도출됨
lefts.forEach((v,i) => result = result + Math.abs(v-checks[i])); 
console.log(result); // 결과 값 출력
