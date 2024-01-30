package com.note.todo.simpleto_dolist.future_note.domain.util

sealed class NoteOrder(val orderType: OrderType) {

    class Title(orderType: OrderType):NoteOrder(orderType)
    class Date(orderType: OrderType):NoteOrder(orderType)
    class Color(orderType: OrderType):NoteOrder(orderType)

}