package ui

import model.Archive
import model.Note

class CreateNoteScreen(
    val archive: Archive
) : Screen<Unit> {

    override fun start() {
        println("Введите название заметки: ")
        val nameNote = readln()
        println("Введите текст: ")
        val text = readln()
        if (nameNote.isEmpty() || text.isEmpty()) {
            println("[WARNING] Название заметки и текст не должны быть пустыми!!!")
            return
        }
        val note = Note(name = nameNote, text = text)
        archive.notes.add(note)
    }
}