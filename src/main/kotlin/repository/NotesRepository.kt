package repository

import model.Archive

object NotesRepository {

    private val _archives = mutableListOf<Archive>()
    val archives
        get() = _archives.toList()


    fun addArchive(archive: Archive) {
        _archives.add(archive)
    }
}