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
const peopleCount = +input();
const times = input().split(' ').map(value => Number(value)).sort((a,b) => a-b); ////js sort는 ASCII 문자 순서로 정렬되어 숫자의 크기대로 나오지 않음
let result = times[0];
times.reduce((previous, current) =>  { 
    var value = previous + current;
    result += value;
    return value;
});

console.log(result);// 결과 값 출력
