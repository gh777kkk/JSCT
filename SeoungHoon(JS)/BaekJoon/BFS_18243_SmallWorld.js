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
var firstLine = input();
var peopleCount = +firstLine.split(' ')[0];
var connections = Array.from({length: peopleCount}, v => []);
var connectionCount = +firstLine.split(' ')[1];

for(var i = 0; i < connectionCount; i++){
    var line = input();
    var personA = +line.split(' ')[0] - 1;
    var personB = +line.split(' ')[1] - 1;
    
    connections[personA].push(personB);
    connections[personB].push(personA);
}

var isSmallWorld = true;

connections.forEach(v => {
    if(v.length == 0) {
        isSmallWorld = false;
    }
});

function check(personIndex){
    var checks = Array.from({length : peopleCount}, v => -1);
    var queue = [personIndex];
    checks[personIndex] = 0; // 몇 단계에서 도달했는지 체크
    while(queue.length > 0){
        var nextPersonIndex = queue.shift(); // 너비우선 (우선적으로 돌아야될 항목들을 queue로 정리하여 순회)
        var nextPersonConnection = connections[nextPersonIndex];
              nextPersonConnection.forEach(v => {
            if (checks[v] == -1) {
                if (checks[nextPersonIndex] == 6) { // 이전 단계가 6단계인데 도달하지 않은 항목이 있으면 Big World
                    isSmallWorld = false;
                    return;
                }
                checks[v] = checks[nextPersonIndex] + 1;
                queue.push(v);
            }
        });
    }
    
    for (var i = 0; i < peopleCount; i++) {
        if (checks[i] == -1) { // Connection을 다 돌았음에도 도달하지 않은 사람이 있다면 끊어진 Network여서 small network 만족하지 않음
            isSmallWorld = false;
            return;
        }
    }
}

for (var i = 0; i < peopleCount; i++) {
    if (!isSmallWorld) {
        break;
    }
   check(i);
}

console.log(isSmallWorld ? 'Small World!' : 'Big World!');
