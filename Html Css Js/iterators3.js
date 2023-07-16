function iterateOver(...args) {
    let index = 0;
    let iterable = {
        [Symbol.iterator]() {
            let iterator = {
                next() {
                    if (index < args.length) {
                        return { value: args[index++] };
                    } else {
                        return { done: true };
                    }
                }
            };
            return iterator;
        }
    }
    return iterable;
}

for (let x of iterateOver('fee', 'fi', 'fo', 'fum')) {
    console.log(x);
}


function iterateOver1(n) {
    let index = 0;
    let iterable = {
        [Symbol.iterator]() {
            let iterator = {
                next() {
                    if (index < n) {
                        return { value: index++ };
                    } else {
                        return { done: true };
                    }
                }
            };
            return iterator;
        }
    }
    return iterable;
}

for (let x of iterateOver1(10)) {
    console.log(x);
}