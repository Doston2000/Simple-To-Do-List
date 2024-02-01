package com.note.todo.simpleto_dolist.future_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.note.todo.simpleto_dolist.ui.theme.BabyBlue
import com.note.todo.simpleto_dolist.ui.theme.LightGreen
import com.note.todo.simpleto_dolist.ui.theme.RedOrange
import com.note.todo.simpleto_dolist.ui.theme.RedPink
import com.note.todo.simpleto_dolist.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message:String):Exception(message)
