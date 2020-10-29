package basic

import java.lang.IllegalStateException
import kotlin.math.abs

/**
 * Taylor series for sin(x)
 * sin(x) = x - x^3/3! + x^5/5! - x^7/7! = sum((-1)^n * x^n/n!)
 *
 * THIS CODE IS WRONG!
 */
fun sin(x: Double, eps: Double): Double {
    var result = 0.0
    var term = x
    var degree = 1
    var factorial = 1

    while (term >= eps) {
        result += term
        factorial *= (degree + 1) * (degree + 2)
        degree += 2
        term *= -(x * x) / factorial
    }

    return result
}


fun main() {
    // I just place this code here
    check(Math.PI * 1000)   // sin(1000PI) = sin(0) = 0
    check(0.0)              // sin(0.0) = 0
    check(Math.PI)                // sin(PI) = 0
    check(Math.PI * 3 / 2)  // sin(3PI/2) = -1
    println("haha")
}

fun check(value: Double) {
    val eps = 1E-10
    val delta = abs(sin(value, eps) - kotlin.math.sin(value))
    if (delta > eps) {
        throw IllegalStateException(
            "Wrong result. Expected ${kotlin.math.sin(value)} for value=$value, sin(x) = ${sin(value, eps)}"
        )
    }
}