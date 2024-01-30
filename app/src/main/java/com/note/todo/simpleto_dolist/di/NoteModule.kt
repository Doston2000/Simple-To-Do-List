package com.note.todo.simpleto_dolist.di

import android.app.Application
import androidx.room.Room
import com.note.todo.simpleto_dolist.future_note.data.data_source.NoteDatabase
import com.note.todo.simpleto_dolist.future_note.data.repository.NoteRepositoryImpl
import com.note.todo.simpleto_dolist.future_note.domain.repository.NoteRepository
import com.note.todo.simpleto_dolist.future_note.domain.use_case.DeleteNote
import com.note.todo.simpleto_dolist.future_note.domain.use_case.GetNotes
import com.note.todo.simpleto_dolist.future_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Provides
    @Singleton
    fun providerNoteDatabase(app: Application): NoteDatabase {

        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()

    }

    @Provides
    @Singleton
    fun providerNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun providerNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository)
        )
    }

}