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

const [M,N,K] = input().split(' ').map(x => Number(x));
const maxRowIndex = N - 1;
const maxColumnIndex = M -1;
const map = Array.from({length : N}, a => Array.from({length : M}, x => false));
let checks = [];

const checkBlock = (startRowIndex, startColumnIndex, endRowIndex, endColumnIndex) => {
    for (var rowIndex = startRowIndex; rowIndex < endRowIndex; rowIndex++) {
        for (var columnIndex = startColumnIndex; columnIndex < endColumnIndex; columnIndex++){
            map[rowIndex][columnIndex] = true;
        }
    }
}

const countRegion = () => {
    let count = 0;
    for (var rowIndex = 0; rowIndex <= maxRowIndex; rowIndex++) {
        for (var columnIndex = 0; columnIndex <= maxColumnIndex; columnIndex++){
            if(map[rowIndex][columnIndex] == false){
                let check = dfs(rowIndex, columnIndex);
                checks.push(check);
                
                count++;
            }
        }
    }
    return count;
}

const dfs = (row, column) => {
    let count = 0;
    if(map[row][column] == false){
        map[row][column] = true;
        count = 1;
        if(row < maxRowIndex){
            count = count + dfs(row + 1, column);
        }
        if(column < maxColumnIndex){
            count = count + dfs(row, column + 1);
        }
        if(column > 0){
            count = count + dfs(row, column -1)
        }
        if(row > 0) {
            count = count + dfs(row -1, column);
        }
    }
    
    return count;
}

for(var i = 0; i < K; i++){
    let [startRowIndex, startColumnIndex, endRowIndex, endColumnIndex] = input().split(' ').map(v => Number(v));
    checkBlock(startRowIndex, startColumnIndex, endRowIndex, endColumnIndex);
}


console.log(countRegion());
console.log(checks.sort((prev,current) => prev-current).join(' '));
