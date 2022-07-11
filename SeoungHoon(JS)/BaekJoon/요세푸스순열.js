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

const [count, step] = input().split(' ').map(value => Number(value));
let line = Array.from({length:count}, (value,index) => index + 1);
let index = step - 1;
let correctValue = 0;
let result = [];
while(line.length > 0){
    if (index < line.length){
        result.push(line.splice(index,1)[0]);
        index += (step -1);
    }
    else {
        correctValue = index - line.length;
        while(line.length <= correctValue){
            correctValue -= line.length;
        }
        result.push(line.splice(correctValue,1)[0]);
        index = correctValue + (step -1);
    }
}
console.log('<' + result.join(', ') + '>'); 
