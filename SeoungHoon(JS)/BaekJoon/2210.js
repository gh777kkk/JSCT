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

let map = Array.from({length : 5}, v=>[]);
for(let i = 0; i < 5; i++){
    map[i] = input().split(' ').map(v => Number(v));
}

let result = new Set();
function find(row, column, str) {
    str += map[row][column];
    if(str.length == 6){
        result.add(str);
        return;
    }
    
    if(row < 4){
        find(row + 1, column, str);
    }
    
    if(row > 0){
        find(row - 1, column, str);
    }
    
    if(column < 4){
        find(row, column + 1, str);
    }
    
    if(column > 0){
        find(row, column - 1, str);
    }
}

for(let i = 0; i < 5; i++){
    for(let j = 0; j < 5; j++){
        find(i, j, '');
    }
}

console.log(result.size);
