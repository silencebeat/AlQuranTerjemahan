package silencebeat.com.alquranterjemahanindonesia.Supports.Data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import freeapk.com.alqurantranslation.Modules.Database.DatabaseHelper

/**
 * Created by Candra Triyadi on 01/02/2018.
 */
class LocalData (context: Context): SQLiteOpenHelper(context, "myalquran", null, 3 ) {

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_ORIGINAL = "CREATE TABLE IF NOT EXISTS "+ DatabaseHelper.TABLE+"(" +
                " "+DatabaseHelper.ID+" INTEGER PRIMARY KEY," +
                " "+DatabaseHelper.DATABASEID+" SMALLINT NOT NULL," +
                " "+DatabaseHelper.SURATID+" INTEGER NOT NULL," +
                " "+DatabaseHelper.VERSEID+" INTEGER NOT NULL," +
                " "+DatabaseHelper.AYAHTEXT+" TEXT CHARACTER)"

        val CREATE_TABLE_TRANSLATION = "CREATE TABLE IF NOT EXISTS "+DatabaseHelper.TABLE_TRANSLATATION+"(" +
                " "+DatabaseHelper.ID+" INTEGER PRIMARY KEY," +
                " "+DatabaseHelper.DATABASEID+" SMALLINT NOT NULL," +
                " "+DatabaseHelper.SURATID+" INTEGER NOT NULL," +
                " "+DatabaseHelper.VERSEID+" INTEGER NOT NULL," +
                " "+DatabaseHelper.AYAHTEXT+" TEXT CHARACTER)"
        db!!.execSQL(CREATE_TABLE_ORIGINAL)
        db!!.execSQL(CREATE_TABLE_TRANSLATION)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS "+DatabaseHelper.TABLE)
        db!!.execSQL("DROP TABLE IF EXISTS "+DatabaseHelper.TABLE_TRANSLATATION)
        onCreate(db)
    }
}