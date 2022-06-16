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

const [rowMax, columnMax] = input().split(' ').map(v=>+v);;
let map = [];
let stack = [[0,0,1]]; // 거리값까지 함께 저장 _ 거리값을 다른 배열로 체크하는 로직은 시간 초과.

for (let i = 0; i < rowMax; i++){
    map.push(input().split('').map(v => +v));
}

const direction = [
        [0, 1], [0, -1], [1, 0], [-1, 0]
];

while (stack.length) {
    const [rowIndex, columnIndex, distance] = stack.shift();
    
    for (let i = 0; i < direction.length; i++) { // 4방향 검사하여 distance 추가하는 로직
        const rowPosition = rowIndex + direction[i][0];
        const columnPosition = columnIndex + direction[i][1]
        
        if(rowPosition < rowMax && columnPosition < columnMax && rowPosition > -1 && columnPosition > -1){
            if(map[rowPosition][columnPosition] === 1){
                map[rowPosition][columnPosition] = distance + 1;
                stack.push([rowPosition, columnPosition, distance + 1]);
            }
        }
    }
}

console.log(map[rowMax -1][columnMax -1]);  // 성공한 로직 


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

const [row, column] = input().split(' ').map(v=>+v);;
let map = [];
let checks = Array.from({length : row + 1}, v => Array.from({length : column + 1}, v => false));
let queue = [[0,0]];
let tempQueue = [];

for (let i = 0; i < row; i++){
    map.push(input().split('').map(v => +v));
}

function AddNewWay(rowIndex, columnIndex){
    if(map[rowIndex][columnIndex] == 1 && checks[rowIndex][columnIndex] == false) {
        tempQueue.push([rowIndex,columnIndex]);
    }
}

let count = 0;
while (queue.length > 0) {
    const [rowIndex, columnIndex] = queue.shift();
    
    if(rowIndex == row -1 && columnIndex == column -1) {
        break;
    }
    
    checks[rowIndex][columnIndex] = true;
    
    if(rowIndex > 0){
       AddNewWay(rowIndex -1, columnIndex)
    }
    
    if(rowIndex < row - 1) {
        AddNewWay(rowIndex + 1, columnIndex);
    }
    
    
    if(columnIndex > 0){
        AddNewWay(rowIndex, columnIndex -1)
    }
    
    if(columnIndex < column - 1) {
        AddNewWay(rowIndex, columnIndex + 1);
    }
    
    if(queue.length == 0) {
        queue = queue.concat(tempQueue);
        tempQueue = [];
        count++;
    }
}

console.log(count); // 초기 로직
for (let i = 0; i < rowMax; i++){
