package ui

interface Screen<T> {

    fun start(): T?
}