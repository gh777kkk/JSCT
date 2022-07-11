const fs  = require("fs");
const stdin  = (
process.platform == = "linux" ? fs.readFileSync("/dev/stdin").toString() : `` ).split("\n");

const input  = (() => { //input()을 호출할 때마다 한줄씩 읽어온다.
    let line = 0;
    return () => stdin[line++];
})();

const sentense  = input().split("");
const reverse  = (word) => {
    return word.split("").reverse().join("");
}


let result = "";
let word = "";

let isTag = false;
for(var i = 0; i<sentense.length; i++){
  if (sentense[i] == '>') {
      word += sentense[i];
      result += word;
      word = "";
      isTag = false;
      continue;
  }

  if (sentense[i] == '<') {
      if (word == "") {
          word += sentense[i];
      }
      else {
          result += reverse(word);
          word = sentense[i];
      }

      isTag = true;
      continue;
  }

  if (!isTag) {
      if (sentense[i] == ' ') {
          result += reverse(word) + sentense[i];
          word = "";
      }
      else {
          word += sentense[i];
      }
  }
  else {
      word += sentense[i];
  }
}

console.log(result + reverse(word));
