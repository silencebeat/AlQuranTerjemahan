package freeapk.com.alqurantranslation.Modules.Database

import android.content.Context
import freeapk.com.alqurantranslation.Entities.Models.Quran
import silencebeat.com.alquranterjemahanindonesia.Supports.Data.LocalData

/**
 * Created by Candra Triyadi on 01/02/2018.
 */
class DatabaseHelper(context: Context) {

    lateinit var output: DatabaseOutput

    val localData = LocalData(context)
    companion object {
        val TABLE= "Quran"
        val TABLE_TRANSLATATION= "Translate"
        val ID = "ID"
        val DATABASEID = "DatabaseID"
        val SURATID = "SuraID"
        val VERSEID = "VerseID"
        val AYAHTEXT = "AyahText"
    }

    fun isDataAvailable(): Boolean{
        val db = localData.writableDatabase
        val selectQuery = "Select (select count(*) from Quran) as Count1, (select count(*) from Translate) as Count2"
        val cursor = db.rawQuery(selectQuery, null)
        var count1 = 0
        var count2 = 0
        if (cursor.moveToFirst()){
            do{
                count1 = cursor.getInt(0)
                count2 = cursor.getInt(1)
            }while (cursor.moveToNext())
        }
        cursor.close()

        if (count1 == 6236 && count2 == 6236)
            return true
        return false
    }

    fun clearTable(){
        val db = localData.writableDatabase
        db.delete(TABLE, null, null)
        db.delete(TABLE_TRANSLATATION, null, null)
        db.close()
    }

    fun getDataBySurahId(idSurah: Int){
        val db = localData.writableDatabase
        val list = ArrayList<Quran>()
        var index = 0

        val selectQuery = "SELECT * FROM 'Quran' WHERE SuraID = $idSurah ORDER BY 'VerseID'"
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()){
            do{
                val quran = Quran(cursor.getInt(0), cursor.getInt(1),
                        cursor.getInt(2), cursor.getInt(3), cursor.getString(4),
                        "")
                list.add(quran)
            }while (cursor.moveToNext())
        }

        val selectQueryTranslate = "SELECT * FROM 'Translate' WHERE SuraID = $idSurah ORDER BY 'VerseID'"
        val cursorTranslate = db.rawQuery(selectQueryTranslate, null)
        if (cursorTranslate.moveToFirst()){
            do{
                list[index].translation = cursorTranslate.getString(4)
                index ++
            }while (cursorTranslate.moveToNext())
        }

        cursor.close()
        cursorTranslate.close()
        output.successGetDataBySurahId(list)
    }

}