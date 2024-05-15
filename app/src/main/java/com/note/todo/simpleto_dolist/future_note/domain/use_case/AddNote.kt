package com.note.todo.simpleto_dolist.future_note.domain.use_case

import com.note.todo.simpleto_dolist.future_note.domain.model.InvalidNoteException
import com.note.todo.simpleto_dolist.future_note.domain.model.Note
import com.note.todo.simpleto_dolist.future_note.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNote(private val repository: NoteRepository) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty.")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty.")
        }
        repository.insertNote(note)
    }

}