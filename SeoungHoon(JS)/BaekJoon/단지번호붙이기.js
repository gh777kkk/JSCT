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

const mapLength = +input();
let map = [];
let result = [];
for(let i = 0; i < mapLength; i++ ){
    const row = input().split('').map(v => v == '1');
    map.push(row);
}

let count = 0;
function dfs (rowIndex, columnIndex){
    if(map[rowIndex][columnIndex] == true){
        map[rowIndex][columnIndex] = false;
        count++;
        
        if(rowIndex > 0){
        dfs(rowIndex -1, columnIndex);
        }
        if(rowIndex < mapLength - 1){
            dfs(rowIndex + 1, columnIndex);
        }
        if(columnIndex > 0){
            dfs(rowIndex, columnIndex -1);
        }
        if(columnIndex < mapLength - 1){
            dfs(rowIndex, columnIndex + 1);
        }
    }
}

for(let rowIndex = 0; rowIndex < mapLength; rowIndex++) {
    for(let columnIndex = 0; columnIndex < mapLength; columnIndex++){
        if(map[rowIndex][columnIndex] == true){
            dfs(rowIndex, columnIndex);
            result.push(count);
            count = 0;
        }
    }
}

result = result.sort((a,b) => a-b);
console.log(result.length + '\n' + result.join('\n')); // 결과 값 출력
