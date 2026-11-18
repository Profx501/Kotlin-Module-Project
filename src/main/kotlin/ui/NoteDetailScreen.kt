package ui

import model.Note

class NoteDetailScreen(
    val note: Note
) : Screen<Unit> {

    override fun start() {
        println("[INFO] Название заметки: ${note.name}\nТекст: ${note.text}")
    }
}