package com.projectes.projectelogin.db

object ClasesContract {
    val TABLE_NAME = "clases"
    val COLUMN_NAME_TITOL = "titol"
    val COLUMN_NAME_SUBTITOL = "subtitol"
    val COLUMN_NAME_DESCRIPCIO = "descripcio"

    val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${TABLE_NAME} (" +
                "id INTEGER PRIMARY KEY," +
                "${COLUMN_NAME_TITOL} TEXT," +
                "${COLUMN_NAME_SUBTITOL} TEXT," +
                "${COLUMN_NAME_DESCRIPCIO} TEXT)"

    val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${TABLE_NAME}"
}
