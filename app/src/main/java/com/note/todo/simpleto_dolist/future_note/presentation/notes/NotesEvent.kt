package com.note.todo.simpleto_dolist.future_note.presentation.notes

import com.note.todo.simpleto_dolist.future_note.domain.model.Note
import com.note.todo.simpleto_dolist.future_note.domain.util.NoteOrder

sealed class NotesEvent {

    data class Order(val noteOrder: NoteOrder) : NotesEvent()
    data class DeleteNote(val note: Note) : NotesEvent()
    object RestoreNote : NotesEvent()
    object ToggleOrderSection : NotesEvent()

}