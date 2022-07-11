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
const count = +input();
const list = [];
const result = [];
let unsorted = false;

for(let i = 0; i < count; i++){
    const item = input().split(' ').map(value => Number(value));
    if(item == 0) {
        if(unsorted){
            unsorted = false;
            list.sort((a,b) => a - b);
        }
      result.push(list.length > 0 ? list.pop() : -1);   
    } else {
        item.shift();
        list.push(...item);
        unsorted = true;
    }
}

console.log(result.join("\n"));
