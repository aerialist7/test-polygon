package com.github.aerialist7

open class A {
    open val foo: String = "42"
}

class B : A() {
    override val foo: String by lazy {
        super.foo + "!"
    }
}

fun main() {
    B()
}
