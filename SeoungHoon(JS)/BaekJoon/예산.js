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

const regionCount = +input();
const requestedBugets = input().split(' ').map(v => +v).sort((a,b) => a-b);
const totalBuget = +input();

function getBuget(maxBuget){ // maxBuget을 설정했을 때 소요되는 예산값 구하는 함수
    return requestedBugets.reduce((prev,cur) => prev + Math.min(maxBuget,cur),0);
}

function binarySearch(target, start, end){ // 빠르게 해당 값을 구하기 위해서 이분 탐색 함수
    if(start > end){
        return end; // 정확히 떨어지는 값을 찾지 못했을 경우는 제일 적게 남는 값으로 반환
    }
    const middle = Math.floor((start+end)/2);
    const middleBuget = getBuget(middle);
    if(middleBuget == target){
        return middle; // 예산이 정확히 떨어지는 값을 찾으면 반환
    }
    
    if(middleBuget < target){
        return binarySearch(target, middle + 1, end);
    } else {
        return binarySearch(target, start, middle - 1);
    }
}

var result = binarySearch(totalBuget, 1, requestedBugets[regionCount -1]);
console.log(result);
