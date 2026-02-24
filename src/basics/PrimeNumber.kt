package basics

import kotlin.math.sqrt

class PrimeNumber() {
    fun getN(range: Int): Array<Int> {
        //TODO: Replace this with MutableList
        //Using immutable list takes lot of memory
        var result = emptyArray<Int>();
        for (i in 2..range) {
            if(isPrime(i)){
                result += i;
            }
        }
        return result;
    }

    fun isPrime(num: Int): Boolean {
        var isPrime: Boolean = true;
        for (j in 2..sqrt(num.toDouble()).toInt()) {
            if (num % j == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}


fun main() {
    println("Enter range n:");
    val n = readln().toInt();
    println("Prime numbers upto: $n");
    val primeNumber = PrimeNumber();
    val res = primeNumber.getN(n);

    println(res.joinToString(","));
}