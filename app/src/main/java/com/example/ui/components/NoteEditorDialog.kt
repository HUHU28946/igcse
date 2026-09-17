package com.example.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.data.model.Subject
import com.example.ui.viewmodel.StudyViewModel

@Composable
fun NoteEditorDialog(
    subject: Subject?,
    viewModel: StudyViewModel
) {
    val uiState = viewModel.uiState.value

    Dialog(onDismissRequest = { viewModel.closeNoteDialog() }) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .testTag("note_editor_dialog")
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Text(
                    text = "Personal Study Note",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = subject?.let { "${it.name} (${it.code}) - ${it.level.shortName}" } ?: "General Studies",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = uiState.newNoteTitle,
                    onValueChange = { viewModel.updateNoteInputs(it, uiState.newNoteContent) },
                    label = { Text("Title / Topic") },
                    placeholder = { Text("e.g. Surds Formulas, Trigonometry identities") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("note_title_input"),
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = uiState.newNoteContent,
                    onValueChange = { viewModel.updateNoteInputs(uiState.newNoteTitle, it) },
                    label = { Text("Your Study Notes & Key Points") },
                    placeholder = { Text("Write formulas, definitions, key tips, or notes to remember...") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .testTag("note_content_input"),
                    maxLines = 8,
                    shape = RoundedCornerShape(10.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        onClick = { viewModel.closeNoteDialog() },
                        modifier = Modifier.testTag("cancel_note_button")
                    ) {
                        Text("Cancel")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = { viewModel.saveStudentNote(subject) },
                        enabled = uiState.newNoteTitle.isNotBlank(),
                        modifier = Modifier.testTag("save_note_button"),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Save Note")
                    }
                }
            }
        }
    }
}
