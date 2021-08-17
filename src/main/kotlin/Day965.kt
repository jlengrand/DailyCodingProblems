/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

UTF-8 is a character encoding that maps each symbol to one, two, three, or four bytes.

For example, the Euro sign, €, corresponds to the three bytes 11100010 10000010 10101100. The rules for mapping characters are as follows:

For a single-byte character, the first bit must be zero.
For an n-byte character, the first byte starts with n ones and a zero. The other n - 1 bytes all start with 10.
Visually, this can be represented as follows.

 Bytes   |           Byte format
-----------------------------------------------
   1     | 0xxxxxxx
   2     | 110xxxxx 10xxxxxx
   3     | 1110xxxx 10xxxxxx 10xxxxxx
   4     | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx

Write a program that takes in an array of integers representing byte values, and returns whether it is a valid UTF-8 encoding.
 */

fun charSize(n : Int) : Int {

    val three = 128 + 64 + 32
    val two = 128 + 64
    val one = 128

    return when{
        n > three -> 3
        n > two -> 2
//        n > one -> 1
        else -> 1
    }
}

fun validCharacter(l : List<Int>) : Boolean {
    return if (l.size == 1 && l[0] < 64) true
    else {
        ( (l.size == charSize(l[0] - 1)) && l.drop(1).all { it in 128..191 })
    }
}

fun allValid(seq : List<Int>) : Boolean{
    var l = seq
    while(l.isNotEmpty()){
        val charSize = charSize(l[0])
        val nextChar = l.take(charSize)
        l = l.drop(charSize)
        if(!validCharacter(nextChar)) return false
    }

    return true
}

fun main(args: Array<String>) {

    val test1 = listOf(197, 130, 1)
    val test2 = listOf(235, 140, 4)
    val test3 = (test1 + test2)

    println(allValid(test1))
    println(allValid(test2))
    println(allValid(test3))
}