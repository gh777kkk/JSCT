const fs = require("fs");
const stdin = fs.readFileSync("/dev/stdin").toString().split("\n");
const input = (() => {
    let line = 0;  
    return () => stdin[line++];
})(); 

const expression = input().split('');

let list = [];
expression.forEach(value => {
    if(Number.isInteger(+value)){
        list.push(+value);
    }
    else{
        const tail = list.pop();
        const prev = list.pop();
        if(value === '+'){
            list.push(tail+prev);
        }
        if(value === '-'){
            list.push(prev-tail);
        }
        if(value === '*'){
            list.push(tail*prev);
        }
        if(value === '/'){
            list.push(prev/tail);
        }
    }
});

console.log(list.pop()); // 결과 값 출력
