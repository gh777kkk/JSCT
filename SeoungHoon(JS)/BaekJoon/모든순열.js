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
const max = +input();
const result = [];
function permitation(array, used){
    if(array.length == max) {
        result.push(array.join(' '));
    }
    
    for (let i = 1; i <= max; i++){
        if(!used.has(i)){
            array.push(i);
            used.add(i);
            permitation(array, used);
            array.pop();
            used.delete(i);
        }
    }
}

permitation([], new Set());

console.log(result.join('\n'));// 결과 값 출력
