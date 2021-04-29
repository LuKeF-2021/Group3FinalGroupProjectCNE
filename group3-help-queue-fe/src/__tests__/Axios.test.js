  
import { TestScheduler } from "@jest/core";

const simpleFunc = ()=>{
    return "hello";
}
async function asyncFunc1(){
    return 1;
}

describe(`Suite - async function`,()=>{

    it(`testing our simpleFunc`,()=>{
        expect(simpleFunc()).toEqual("hello");
    })
    test(`async function 1`,()=>{
        expect(asyncFunc1()).resolves.toEqual(1);
    })

    it(`await async function resolves`,()=>{
        async function iUseAwait(){
            let myProm= new Promise((resolve,reject)=>{
                setTimeout( () => resolve("hello my friends"),2000);
            });
            let result = await myProm;
        };
        expect(iUseAwait()).resolves.toMatch("hello my friends");
    })
    it(`await async function reject`,()=>{
        async function iUseAwait(){
            let myProm= new Promise((resolve,reject)=>{
                setTimeout( () => reject("oh no!!!"),2000);
            });
            let result = await myProm;
        };
        expect(iUseAwait()).resolves.toMatch("oh no!!!");
    })

})