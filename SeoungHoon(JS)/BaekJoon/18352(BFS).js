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

const [N, M, K, X] = input().split(' ').map(value => Number(value));
const cityMap = Array.from({length: N + 1}, (v,i) => {
    return {city:(i), connectedCity:[], distance:-1};
});
for(let i = 0; i < M; i++ ){
    const [start, end] = input().split(' ').map(value => Number(value));
   
    cityMap[start].connectedCity.push(end);
}

let result = [];
let queue = [cityMap[X]];

while(queue.length > 0){
    let current = queue.shift();
    current.distance += 1;
    if(current.distance > K){
        break;
    }
    
    if(current.distance == K){
        result.push(current.city);
    }

    for (let i = 0; i < current.connectedCity.length; i++){
        if(cityMap[current.connectedCity[i]].distance < 0){ // 거리값으로 방문 체크
            cityMap[current.connectedCity[i]].distance = current.distance;
            queue.push(cityMap[current.connectedCity[i]]);
        }
    }
}

console.log(result.length == 0 ? -1 : result.sort((a,b) => a-b).join('\n'));
