let map = new Map().set('a', 1).set('b', 2);
for (let pair of map) {
    console.log(pair);
}

let set = new Set().add('a').add('b');
for (let x of set) {
    console.log(x);
}

let map1 = new Map().set(false, 'no').set(true, 'yes');
for (let [k,v] of map1) {
    console.log(`key = ${k}, value = ${v}`);
}


let arr = ['a', 'b', 'c'];
for (let [k,v] of arr.entries()) {
    console.log(`key = ${k}, value = ${v}`);
}
