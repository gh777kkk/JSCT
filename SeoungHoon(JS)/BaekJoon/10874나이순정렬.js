const [n, ...members] = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");
console.log(
    members
        .map(v => ({age: parseInt(v.split(" ")[0]), name: v.split(" ")[1]}))
        .sort((a, b) => a.age - b.age)
        .map(v => String(v.age) + " " + v.name)
        .join("\n")
);
