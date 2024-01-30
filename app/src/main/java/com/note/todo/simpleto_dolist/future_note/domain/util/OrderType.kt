package com.note.todo.simpleto_dolist.future_note.domain.util

sealed class OrderType {

    object Ascending: OrderType()
    object Descending: OrderType()

}