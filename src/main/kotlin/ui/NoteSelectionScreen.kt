package ui

import model.Archive
import model.Note

class NoteSelectionScreen(
    val archive: Archive?
) : Screen<Note> {
    override fun start(): Note? {
        if (archive?.notes?.isEmpty() == true) {
            println("[WARNING] Заметки пока пусты.")
            return null
        }
        println("Выбирете заметку: ")
        archive?.notes?.forEachIndexed { index, note ->
            println("[${archive.name}]   ${index}. -> ${note.name}")
        }
        val numberNote = readln().toIntOrNull()
        if (numberNote == null) {
            println("[WARNING] Номер заметки должен состоять из цифр.")
            return null
        }
        if (archive?.notes?.indices?.contains(numberNote) != true) {
            println(
                "[WARNING] Номер заметки должен состоять из цифр от 0 до ${archive?.notes?.size}."
            )
            return null
        }
        return archive.notes[numberNote]
    }
}