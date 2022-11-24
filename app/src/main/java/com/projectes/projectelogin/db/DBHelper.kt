package com.projectes.projectelogin.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.projectes.projectelogin.Clase
import com.projectes.projectelogin.db.ClasesContract.COLUMN_NAME_DESCRIPCIO
import com.projectes.projectelogin.db.ClasesContract.COLUMN_NAME_SUBTITOL
import com.projectes.projectelogin.db.ClasesContract.COLUMN_NAME_TITOL
import com.projectes.projectelogin.db.ClasesContract.SQL_CREATE_ENTRIES
import com.projectes.projectelogin.db.ClasesContract.SQL_DELETE_ENTRIES
import com.projectes.projectelogin.db.ClasesContract.TABLE_NAME


class DBHelper (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 2
        const val DATABASE_NAME = "clases.db"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    fun insertLlibre(l: Clase) {
        val values = ContentValues()
        values.put(COLUMN_NAME_TITOL, l.titol)
        values.put(COLUMN_NAME_SUBTITOL, l.subtitol)
        values.put(COLUMN_NAME_DESCRIPCIO, l.descripcio)

        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
    }
    fun readClases(): MutableList<Clase> {
        val db = this.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        val llista: ArrayList<Clase> = ArrayList()
        if (cursor.moveToFirst()) {
            do {
                llista.add(
                    Clase(
                        cursor.getString(0),
                        cursor.getString(2),
                        cursor.getString(3)
                    )
                )
            } while (cursor.moveToNext())
        }
        cursor.close()
        return llista
    }
}