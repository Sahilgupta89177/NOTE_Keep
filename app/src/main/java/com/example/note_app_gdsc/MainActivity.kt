package com.example.note_app_gdsc


import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.note_app_gdsc.data.NotesDataSource
import com.example.note_app_gdsc.model.Note
import com.example.note_app_gdsc.screen.NoteScreen
import com.example.note_app_gdsc.screen.NoteViewModel
import com.example.note_app_gdsc.ui.theme.NOTE_APP_GDSCTheme
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalComposeUiApi::class)
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NOTE_APP_GDSCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val noteViewModel:NoteViewModel by viewModels()
                    NotesApp(noteViewModel =noteViewModel)





                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalComposeUiApi
@Composable
fun NotesApp(noteViewModel: NoteViewModel= viewModel()) {
    val notesList = noteViewModel.getAllNotes()

    NoteScreen(notes= notesList,
        onRemoveNote = { noteViewModel.removeNote(it) },
        onAddNote = { noteViewModel.addNote(it) })

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable

@Preview(showBackground = true)

fun DefaultPreview() {
    NOTE_APP_GDSCTheme {

    }
}