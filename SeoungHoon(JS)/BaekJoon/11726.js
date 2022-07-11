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

let result = 0;
const n = +input();
let list = [1,1];

for(let i = 2; i <= n; i++){
    list.push((list[i-1] + list[i-2])%10007);
}

console.log(list[n]);

/// 맞는 코드 

for(let i = 2; i <= n; i++){
    list.push((list[i-1] + list[i-2]));
}

console.log(list[n]%10007);

/// 틀린 코드 

// 두 개가 어떤 차이가 있어서 맞고 틀리는지 이유를 알기가 힘드네요 ㅜㅜ
