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

const peopleCount = Number(input());
let peple = [];
let max = new Date('1991 1 1');
let min = new Date('2010 12 31');
let youngestPerson = '';
let oldestPerson = '';
for(let i = 0; i < peopleCount; i++ ){
    const [name, day, month, year] = input().split(' ');
    const date = new Date(year + ' ' + month + ' ' + day);
    if (date >= max){
        max = date;
        youngestPerson = name;
    }
    
    if (date <= min){
        min = date;
        oldestPerson = name;
    }
}

console.log(youngestPerson + '\n' + oldestPerson); // 결과 값 출력
