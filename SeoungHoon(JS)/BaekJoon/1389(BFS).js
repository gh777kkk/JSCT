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

const [N, M] = input().split(' ').map(v=>Number(v));
const relation = Array.from({length  : N + 1}, v => []);

for(let i =0; i<M; i++){
    const [start, end] = input().split(' ').map(v=>Number(v));
    relation[start].push(end);
    relation[end].push(start);
}

function bfs(person){
    const queue = [person];
    const distance = Array.from({length  : N + 1}, v => -1);
    distance[person] = 0;
    while(queue.length > 0){
        const current = queue.shift();
        relation[current].forEach(v => {
            if(distance[v] == -1){
                distance[v] = distance[current] + 1;
                queue.push(v);
            }
        });
    }
    
    return distance.reduce((a,b) => a+b,0);
}

let result = 100;
let answer = 0;
for(let i = 1; i <= N; i++){
    const value = bfs(i);
    if(value < result){
        result = value;
        answer = i;
    }
}

console.log(answer); // 결과 값 출력
