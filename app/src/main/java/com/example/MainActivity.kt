package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.components.NoteEditorDialog
import com.example.ui.screens.*
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.viewmodel.MainNavTab
import com.example.ui.viewmodel.StudyViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                StudyApp()
            }
        }
    }
}

@Composable
fun StudyApp(viewModel: StudyViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    // Handle back button logically
    BackHandler(
        enabled = uiState.activeLesson != null ||
                  uiState.activePastPaper != null ||
                  uiState.selectedSubject != null ||
                  uiState.mainNavigationTab != MainNavTab.SUBJECTS
    ) {
        when {
            uiState.activeLesson != null -> viewModel.closeLesson()
            uiState.activePastPaper != null -> viewModel.closePastPaper()
            uiState.selectedSubject != null -> viewModel.selectSubject(null)
            uiState.mainNavigationTab != MainNavTab.SUBJECTS -> viewModel.setMainNavTab(MainNavTab.SUBJECTS)
        }
    }

    // Snackbar/message banner auto-dismiss
    LaunchedEffect(uiState.messageBanner) {
        if (uiState.messageBanner != null) {
            kotlinx.coroutines.delay(2800)
            viewModel.dismissMessageBanner()
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            // Only show bottom navigation when not immersed in a lesson or paper reader
            if (uiState.activeLesson == null && uiState.activePastPaper == null) {
                NavigationBar(
                    modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars),
                    containerColor = MaterialTheme.colorScheme.surface,
                    tonalElevation = 6.dp
                ) {
                    NavigationBarItem(
                        selected = uiState.mainNavigationTab == MainNavTab.SUBJECTS,
                        onClick = { viewModel.setMainNavTab(MainNavTab.SUBJECTS) },
                        icon = {
                            Icon(
                                if (uiState.mainNavigationTab == MainNavTab.SUBJECTS) Icons.Default.School else Icons.Outlined.School,
                                contentDescription = "Subjects"
                            )
                        },
                        label = { Text("Subjects") },
                        modifier = Modifier.testTag("nav_subjects")
                    )

                    NavigationBarItem(
                        selected = uiState.mainNavigationTab == MainNavTab.UPDATES,
                        onClick = { viewModel.setMainNavTab(MainNavTab.UPDATES) },
                        icon = {
                            BadgedBox(
                                badge = {
                                    Badge { Text("NEW") }
                                }
                            ) {
                                Icon(
                                    if (uiState.mainNavigationTab == MainNavTab.UPDATES) Icons.Default.Campaign else Icons.Outlined.Campaign,
                                    contentDescription = "Updates"
                                )
                            }
                        },
                        label = { Text("Updates") },
                        modifier = Modifier.testTag("nav_updates")
                    )

                    NavigationBarItem(
                        selected = uiState.mainNavigationTab == MainNavTab.PRACTICE,
                        onClick = { viewModel.setMainNavTab(MainNavTab.PRACTICE) },
                        icon = {
                            Icon(
                                if (uiState.mainNavigationTab == MainNavTab.PRACTICE) Icons.Default.Quiz else Icons.Outlined.Quiz,
                                contentDescription = "Practice"
                            )
                        },
                        label = { Text("Practice") },
                        modifier = Modifier.testTag("nav_practice")
                    )

                    NavigationBarItem(
                        selected = uiState.mainNavigationTab == MainNavTab.REVISION_DESK,
                        onClick = { viewModel.setMainNavTab(MainNavTab.REVISION_DESK) },
                        icon = {
                            Icon(
                                if (uiState.mainNavigationTab == MainNavTab.REVISION_DESK) Icons.Default.Bookmarks else Icons.Outlined.Bookmarks,
                                contentDescription = "Revision"
                            )
                        },
                        label = { Text("Revision") },
                        modifier = Modifier.testTag("nav_revision")
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Main content based on state hierarchy
            when {
                uiState.activeLesson != null && uiState.selectedSubject != null -> {
                    LessonReaderScreen(
                        lesson = uiState.activeLesson!!,
                        subject = uiState.selectedSubject!!,
                        viewModel = viewModel
                    )
                }

                uiState.activePastPaper != null -> {
                    PastPaperDetailScreen(
                        paper = uiState.activePastPaper!!,
                        viewModel = viewModel
                    )
                }

                uiState.mainNavigationTab == MainNavTab.UPDATES -> {
                    SyllabusUpdatesScreen(viewModel = viewModel)
                }

                uiState.mainNavigationTab == MainNavTab.PRACTICE -> {
                    PracticeScreen(viewModel = viewModel)
                }

                uiState.mainNavigationTab == MainNavTab.REVISION_DESK -> {
                    RevisionDeskScreen(viewModel = viewModel)
                }

                uiState.selectedSubject != null -> {
                    SubjectDetailScreen(
                        subject = uiState.selectedSubject!!,
                        viewModel = viewModel
                    )
                }

                else -> {
                    SubjectsScreen(viewModel = viewModel)
                }
            }

            // Message Banner Overlay
            AnimatedVisibility(
                visible = uiState.messageBanner != null,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
            ) {
                uiState.messageBanner?.let { message ->
                    Snackbar(
                        shape = MaterialTheme.shapes.medium,
                        containerColor = MaterialTheme.colorScheme.inverseSurface,
                        contentColor = MaterialTheme.colorScheme.inverseOnSurface
                    ) {
                        Text(message, fontWeight = FontWeight.Medium)
                    }
                }
            }

            // Note Editor Dialog
            if (uiState.isNoteDialogOpen) {
                NoteEditorDialog(
                    subject = uiState.selectedSubject,
                    viewModel = viewModel
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}

