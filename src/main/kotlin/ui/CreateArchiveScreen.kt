package ui

import model.Archive
import repository.NotesRepository

class CreateArchiveScreen : Screen<Unit> {

    override fun start() {
        println("Введите название Архива: ")
        val nameArchive = readln().trim()
        if (nameArchive.isEmpty()) {
            println("[WARNING] Название архива не должно быть пустым!!")
            return
        }
        val archive = Archive(name = nameArchive)
        NotesRepository.addArchive(archive)
    }
}