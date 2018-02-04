package freeapk.com.alqurantranslation.Modules.Database

import freeapk.com.alqurantranslation.Entities.Models.Quran

/**
 * Created by Candra Triyadi on 01/02/2018.
 */
class DatabaseInteractor (var db: DatabaseHelper): DatabaseInput {

    lateinit var output: DatabaseOutput

    override fun getAllData() {

    }

    override fun updateData(data: Quran) {
//        db.insertData(data)
    }

    override fun getDataById(id: Int) {

    }

    override fun getDataBySurahId(id: Int) {
        val list = db.getDataBySurahId(id)
    }
}