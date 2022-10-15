package com.example.note_app_gdsc.screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note_app_gdsc.data.NotesDataSource
import com.example.note_app_gdsc.model.Note


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch



class NoteViewModel : ViewModel() {

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    // val noteList = _noteList.asStateFlow()
    private var noteList = mutableStateListOf<Note>()

    init {
           noteList.addAll(NotesDataSource().loadNotes())

                }


    fun addNote(note: Note) {
        noteList.add(note)
    }


    fun removeNote(note: Note) {

        noteList.remove(note)
    }


    fun getAllNotes():List<Note>  {
        return noteList
    }



        }
       // noteList.addAll(NotesDataSource().loadNotes())




