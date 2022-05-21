function recursive(target, array, index) {
    var result = 0;
    for (let i = index; i < array.length ; i++) {
        var temp = target;
        temp -= array[i]
        if (temp == 0){
            result++;
        } else if (temp < 0){
            continue;
        } else {
            result += recursive(temp, array, i+1)     }
    }
    return result;
}

function solution(numbers, target) {
    var answer = 0;
    var k = (numbers.reduce((pre, cur) => pre + cur) - target) / 2;
    
    return recursive(k, numbers, 0);
}
