import kotlin.math.abs

/*
This problem was asked by Microsoft.

Given a clock time in hh:mm format, determine, to the nearest degree, the angle between the hour and the minute hands.

Bonus: When, during the course of a day, will the angle be zero?
 */

fun main(args: Array<String>) {
    println(getBetterAngle(5, 30))
    println(getBetterAngle(9, 0))
    println(getBetterAngle(12, 0))
    println(getBetterAngle(15, 15))
    println(getBetterAngle(3, 15))

    println("====")
    find0angle()
}

fun to12(h:Int) = h % 12

fun getMinutes(m: Int) = m*360/60

fun getSimpleHours(h: Int) = to12(h)*360/12

fun getBetterHours(h: Int, m:Int) = to12(h)*360/12 + (360/12)*m/60

fun getAngle(h: Int, m: Int) = abs(getBetterHours(h, m) - getMinutes(m))

fun getBetterAngle(h: Int, m: Int) : Int {
    return if(abs(getBetterHours(h, m) - getMinutes(m)) < 180)
        abs(getBetterHours(h, m) - getMinutes(m))
    else
        360 - abs(getBetterHours(h, m) - getMinutes(m))
}

fun find0angle() {
    for(h in 0..11)
        for(m in 0..59)
            if(getBetterAngle(h ,m) == 0) println("$h:$m")

}