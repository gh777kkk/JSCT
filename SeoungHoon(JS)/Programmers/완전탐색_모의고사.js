function solution(answers) {
    const a1 = [1,2,3,4,5];
    const a2 = [2,1,2,3,2,4,2,5];
    const a3 = [3,3,1,1,2,2,4,4,5,5];
    var a1Score = answers.filter((answer, index) => answer === a1[index % a1.length]).length;
    var a2Score = answers.filter((answer, index) => answer === a2[index % a2.length]).length;
    var a3Score = answers.filter((answer, index) => answer === a3[index % a3.length]).length;

    var max = Math.max(a1Score,a2Score,a3Score);
    var result = [];
    
    if (a1Score === max) {result.push(1)};
    if (a2Score === max) {result.push(2)};
    if (a3Score === max) {result.push(3)};
	return result;
}
