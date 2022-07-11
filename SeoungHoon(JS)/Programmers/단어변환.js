function isNext(target, source){
    let count = 0;
    let sources = source.split('');
    let targets = target.split('');
    for(let i = 0; i < targets.length; i++){
        if(count > 1){
            return false;
        }
        if(sources[i] != targets[i]){
            count++;
        }
    };    
    
    return count == 1;    
}

function solution(begin, target, words) {
    let queue = [[begin,0]];
    let checks = new Array(words.length);
    var answer = 0;
    while(queue.length > 0){
        var current = queue.shift();     
        for(let i = 0; i < words.length; i++){
            let value = words[i];                
            if(checks[i] != true && isNext(current[0], value)){
                if(value == target){
                    answer = current[1] + 1;
                    queue = [];
                    break;
                }
                queue.push([value, current[1] + 1]);
                checks[i] = true;
            }
        }
    }
    
    return answer;    
}
