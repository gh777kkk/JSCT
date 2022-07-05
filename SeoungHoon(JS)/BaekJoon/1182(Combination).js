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

const [N, S] = input().split(' ').map(value => Number(value));
const list = input().split(' ').map(value => Number(value));
let result = 0;

function combination(array, lastIndex){
    const sum = array.reduce((a,b) => a+b, null);
    if(sum == S){
        result++;
    }
    
    for (let i = lastIndex; i < N; i ++){
        array.push(list[i]);
        combination(array, i + 1);
        array.pop();
    }    
}

combination([],0);
console.log(result);
