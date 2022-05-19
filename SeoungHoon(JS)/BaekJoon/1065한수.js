const fs = require("fs");
const stdin = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString()
    : `` // 기본 입력값 설정 (백준 코딩테스트에서 비워놔도 무방하다.)
).split("\n");

const input = (() => {  
  let line = 0;
  return () => stdin[line++];
})(); 

let max = +input();
let result = max;

for(let i = 1; i <= max; i++ ){
    let value = i + '';
    let values = value.split('').map(v => Number(v)); // 각 자리 숫자의 배열로 변환해줌
    
    if (values.length === 1) { // 1자리만 있을 때 조건을 만족
        continue;
    }
    
    let difference = values[1]- values[0];
    for(let j = 0; j < values.length -1; j++){
        if(values[j+1] - values[j] != difference) {
            result--; // 등차수열을 만족하지 않으면 result에서 제거
            break;
        }
    }
}
console.log(result); // 결과 값 출력
