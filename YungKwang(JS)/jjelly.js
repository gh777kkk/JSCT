const fs = require("fs");
const input = (process.platform === "linux" ? 
fs.readFileSync("/dev/stdin").toString() : 
`3
3 1 10
1 5 4
3 1 -1`).trim().split("\n");

const size = Number(input.shift());
const map = input.slice();
let map2 = []
for(const m of map){
    map2.push(m.split(' ').map(Number));
}

const start = map2[0][0]
let num = start
console.log(check(num, 0))
// check(num, 0)


// function check(y, x){
//     let result = 'Hing'
//     while(y){
//         if(y >= size){
//             y--
//             x++
//             continue;  
//         } 
//         if(x >= size) break;
//         if(map2[y][x] === -1){
//             result = 'HaruHaru'
//             break;
//         }
//         check(y+map2[y][x], x)
//         y--
//         x++
//     }
//     return result
// }

function check(y, x){
    // console.log(y,x, "#@#")
    while(y>=size){
        y--
        x++
    }
    if(x>=size) {
        return 'Hing'
    }
    if(map2[y][x] === -1) {
        console.log("!!!!!!") 
        return 'HaruHaru'
    }
    // console.log(y,x, map2[y][x])
    check(y+map2[y][x], x)
    // y--
    // x++
    return 'Hing'
}

// console.log(test(true))

function test(a){
    if(a){
        return 'test2'
    }
    return 'test1'
}