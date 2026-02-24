package basics

import kotlin.math.sqrt

class PrimeNumber(val range: Int) {
    fun getN(): Array<Int> {
        //TODO: Replace this with MutableList
        //Using immutable list takes lot of memory
        var result = emptyArray<Int>();
        for (i in 2..this.range) {
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
    val primeNumber = PrimeNumber(n);
    val res = primeNumber.getN();

    println(res.joinToString(","));
}