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
let list = input().split(' ').map(value => Number(value));
let checkList = new Array({length : list.length}, v => false);
let temp = [];
let result = 0;

function permitation(index){ // 순열을 이용한 완전 탐색
    if(index == count) {
        let sum =0;
        for(let i = 0; i < temp.length - 1; i++){
            sum += Math.abs(temp[i] - temp[i+1]);
        }
        
        result = Math.max(sum, result);
   }
    
    for(let i = 0; i < count; i++){
        if(checkList[i] == true){
            continue;
        }
        
        checkList[i] = true;
        temp.push(list[i]); // 백 트래킹 하나의 재귀호출마다 자릿수 하나를 채워 넣음
        permitation(index+1);
        temp.pop();
        checkList[i] = false;
    }
}

permitation(0);

console.log(result);
