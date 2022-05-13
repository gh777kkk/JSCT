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

let length = +input();
let map = [];
for(var i = 0; i < length; i++){
    let row = input().split(' ').map(v => +v);
    map.push(row);
}

let success = false;

function jump(row,column){ // DFS
    const jumpNumber = map[row -1][column -1];
    
    if(jumpNumber == -1) {
        success = true;
        return;
    }
    
    if(jumpNumber == 0) { // 여러번 접근하지 않도록 초기화 해줍니다
        return;
    }
    
    if(row + jumpNumber <= length){
        jump(row+jumpNumber, column);
    }
    
    if(column + jumpNumber <= length){
        jump(row, column+jumpNumber);
    }
    
    map[row-1][column-1] = 0;
}

jump(1,1);

console.log(success ? 'HaruHaru' : 'Hing'); // 결과 값 출력
