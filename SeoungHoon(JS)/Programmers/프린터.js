function solution(priorities, location) {
    var answer = 0;
    while(priorities.length > 0) {
        let max = Math.max(...priorities);
        let next = priorities.shift();
        priorities.push(next);
        
        if(next == max) {        
            priorities.pop();                 
            answer++;   
            if(location == 0) {
                break;
            }
        }
        
        location = location == 0 ? priorities.length - 1 : location - 1;    
    }
    return answer;
}
