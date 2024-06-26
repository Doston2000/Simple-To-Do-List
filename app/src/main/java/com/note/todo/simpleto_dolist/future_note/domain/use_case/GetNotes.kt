package com.note.todo.simpleto_dolist.future_note.domain.use_case

import com.note.todo.simpleto_dolist.future_note.domain.model.Note
import com.note.todo.simpleto_dolist.future_note.domain.repository.NoteRepository
import com.note.todo.simpleto_dolist.future_note.domain.util.NoteOrder
import com.note.todo.simpleto_dolist.future_note.domain.util.OrderType
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.Flow

class GetNotes(
    val repository: NoteRepository
) {

    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)): Flow<List<Note>> {
        return repository.getNotes().map { notes ->

            when (noteOrder.orderType) {

                is OrderType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }

                is OrderType.Descending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }

            }

        }
    }

}