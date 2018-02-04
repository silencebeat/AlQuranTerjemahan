package freeapk.com.alqurantranslation.Modules.ArabicLiteration

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.os.AsyncTask
import silencebeat.com.alquranterjemahanindonesia.R
import silencebeat.com.alquranterjemahanindonesia.Supports.Data.LocalData
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * Created by Candra Triyadi on 01/02/2018.
 */
class LiterationInteractor(var context: Context, var literationInterface: Literation): AsyncTask<Void, Void, Void>() {

    lateinit var db: SQLiteDatabase
    val dbHelper = LocalData(context)

    fun setData(){
        db = dbHelper.writableDatabase
        execute()
    }

    override fun doInBackground(vararg params: Void?): Void? {
        insertFromFile(R.raw.original, R.raw.translate)
        return null
    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
        literationInterface.successInputDatabase()
    }

    fun insertFromFile(resourceIdOriginal: Int, resourceIdTranslation: Int) {
        try {
            val insertsStream = context.resources.openRawResource(resourceIdOriginal)
            val insertReader = BufferedReader(InputStreamReader(insertsStream))

            val insertsStream2 = context.resources.openRawResource(resourceIdTranslation)
            val insertReader2 = BufferedReader(InputStreamReader(insertsStream2))

            db.beginTransaction()

            while (insertReader.ready()) {
                val insertStmt = insertReader.readLine()
                db.execSQL(insertStmt)
            }

            while (insertReader2.ready()) {
                val insertStmt = insertReader2.readLine()
                db.execSQL(insertStmt)
            }

            db.setTransactionSuccessful()
            db.endTransaction()

            insertReader.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }
}