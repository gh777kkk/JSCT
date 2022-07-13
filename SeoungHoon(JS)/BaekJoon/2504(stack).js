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

let stacks = Array.from({length: 30}, v => []);
let inputs = input().split('');
let depth = 0;
let startBrackets = [];

for(let i = 0; i < inputs.length; i++){
    if(inputs[i] ==='('){
        depth++;
        startBrackets.push('(');
        continue;
    }   
    
    if(inputs[i] ==='['){
        depth++;
        startBrackets.push('[');
        continue;
    }   
    
    if(inputs[i] === ')'){
        const lastChar = startBrackets.pop();
        if(lastChar == undefined || lastChar != '('){
            stacks[0] = [];
            break;
        }
        
       if(stacks[depth].length > 0){
            const sum = stacks[depth].reduce((a,b) => a+b,0);
            stacks[depth] = [];
            depth--;
            stacks[depth].push(2*sum);
            continue;
        }
        
        depth--;
        stacks[depth].push(2);
    }   
    
    if(inputs[i] === ']'){
      const lastChar = startBrackets.pop();
        if(lastChar == undefined || lastChar != '['){
            stacks[0] = [];
            break;
        }
        
        if(stacks[depth].length > 0){
            const sum = stacks[depth].reduce((a,b) => a+b,0);
            stacks[depth] = [];
            depth--;
            stacks[depth].push(3*sum);
            continue;
        }
        
        depth--;
        stacks[depth].push(3);
    }   
}

console.log(stacks[0].reduce((a,b) => a+b,0)); // 결과 값 출력
