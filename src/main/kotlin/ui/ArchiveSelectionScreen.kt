package ui

import model.Archive
import repository.NotesRepository

class ArchiveSelectionScreen : Screen<Archive> {

    val archives = NotesRepository.archives

    override fun start(): Archive? {
        if (archives.isEmpty()) {
            println("[WARNING] Архив пока пустой.")
            return null
        }
        println("Выбирете архив: ")
        NotesRepository.archives.forEachIndexed { index, archive ->
            println("${index}. -> ${archive.name}")
        }
        val archiveNumber = readln().toIntOrNull()
        if (archiveNumber == null) {
            println("[WARNING] Номер архива должен состоять из цифр.")
            return null
        }
        if (archiveNumber !in archives.indices) {
            println("[WARNING] Номер архива должен состоять из цифр от 0 до ${archives.size}.")
            return null
        }
        return archives[archiveNumber]
    }
}