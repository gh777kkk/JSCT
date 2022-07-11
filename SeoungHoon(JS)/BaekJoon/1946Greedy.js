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
for(let i = 0; i < count; i++ ){
    let result = 0;
    const peopleCount = +input();
    const peopleRanks = [];
    for(let j = 0; j < peopleCount; j++){
        const rank = input().split(' ').map(value => Number(value));
        peopleRanks.push(rank);
    }
    
    peopleRanks.sort((a,b) => a[0]-b[0]); // 서류 순으로 정렬
  
    let secondRanks = peopleCount + 1;
    for(let j = 0; j < peopleRanks.length; j++){
        if(peopleRanks[j][1] < secondRanks){ // 서류 순서가 낮은 순으로 기준이 되는 면접 순보다 높은지 판단
            secondRanks = peopleRanks[j][1]; // 가장 높은 면접 순서를 기준으로 다시 설정
            result++; // 결과 값 추가
        }
    }
    
    console.log(result);
}
