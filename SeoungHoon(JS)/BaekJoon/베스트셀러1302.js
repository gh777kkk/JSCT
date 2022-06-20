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

let count = +input();
let map = new Map();

for(let i = 0; i < count; i++ ){
    const inputName = input();
    const beforeCount = map.get(inputName) ?? 0;
    map.set(inputName, beforeCount + 1);
}

let result = '';
let max = 0;
map.forEach((value, key) =>  {
    if(value > max){
        max = value;
        result = key;
    }
    
    if(value == max && result > key) {
        result = key;
    }
})

console.log(result); // 결과 값 출력
