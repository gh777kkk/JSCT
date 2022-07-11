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

const [N, M] = input().split(' ').map(value => Number(value));
const list = input().split(' ').map(value => Number(value)).sort((a,b) => a-b);
const sums = list.reduce((acc, cur) => { acc.push(acc[acc.length -1] + cur);
    return acc;
}, [0]);
const totalSum = sums[sums.length -1];
sums.shift();
let result = 0;
let [start, end] = [0, list.length];
while(start < end) {
    const middle = Math.floor((start + end) / 2);
    const value = totalSum - ((N - middle - 1) * list[middle]) - sums[middle]; // middle 순서의 높이만큼 잘랐을때 가져가는 양
    if(value < M){ // 원하는 양보다 적을 경우 많이 자를 수 있는 범위로 좁힌다.
        end = middle; // 자르는 높이의 최대값이 줄어든다.
    }else {
        start = middle + 1;
    }
}

result = list[end];
let count = 0;
let value = totalSum  - ((N - end - 1) * list[end]) - sums[end]; 
while(value < M){
    value += N - end;
    count++;
}
console.log(result - count);
