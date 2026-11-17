package ui

import model.Archive
import model.Note

object Menu {
    const val MAX_OPERATION_CODE = 3
    lateinit var currentArchive: Archive
        private set

    fun showMenu(startMenu: MenuType) {
        var current: MenuType? = startMenu

        while (current != null) {
            val menuType = current
            println("Список ${menuType.titleMenu}:")
            println("0. Создать ${menuType.titleMenu}")
            println("1. Выбрать ${menuType.titleMenu}")
            println("2. Назад")

            val operationCode = readln().toIntOrNull()
            if (!validateOperationCode(operationCode)) {
                println(
                    "[WARNING] Код операции должен состоять из цифр от 0 до ${
                        MAX_OPERATION_CODE - 1
                    }."
                )
                continue
            }


            current = when (menuType) {
                MenuType.ARCHIVE -> when (operationCode) {
                    0 -> {
                        CreateArchiveScreen().start()
                        MenuType.ARCHIVE
                    }

                    1 -> {
                        val archive = ArchiveSelectionScreen().start()
                        if (archive is Archive) {
                            currentArchive = archive
                            MenuType.NOTE
                        } else {
                            MenuType.ARCHIVE
                        }
                    }

                    else -> null
                }

                MenuType.NOTE -> when (operationCode) {
                    0 -> {
                        CreateNoteScreen(currentArchive).start()
                        MenuType.NOTE
                    }

                    1 -> {
                        val note = NoteSelectionScreen(currentArchive).start()
                        if (note is Note) NoteDetailScreen(note).start()
                        MenuType.NOTE
                    }

                    else -> MenuType.ARCHIVE
                }
            }
        }
    }

    private fun validateOperationCode(
        number: Int?
    ) = number != null && number in 0 until MAX_OPERATION_CODE

}