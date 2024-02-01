package com.note.todo.simpleto_dolist.future_note.presentation.notes

import com.note.todo.simpleto_dolist.future_note.domain.model.Note
import com.note.todo.simpleto_dolist.future_note.domain.util.NoteOrder
import com.note.todo.simpleto_dolist.future_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisibility: Boolean = false
)
