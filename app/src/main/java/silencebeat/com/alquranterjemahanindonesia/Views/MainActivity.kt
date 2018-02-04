package silencebeat.com.alquranterjemahanindonesia.Views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import freeapk.com.alqurantranslation.Modules.ArabicLiteration.Literation
import freeapk.com.alqurantranslation.Modules.ArabicLiteration.LiterationInteractor
import freeapk.com.alqurantranslation.Modules.Database.DatabaseHelper
import silencebeat.com.alquranterjemahanindonesia.R

class MainActivity : AppCompatActivity(), Literation {

    val interactor = LiterationInteractor(this, this)
    val databaseHelper = DatabaseHelper(this)

    override fun successInputDatabase() {
        openNextActivity()
    }

    override fun failedInputDatabase() {
        databaseHelper.clearTable()
        interactor.setData()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (databaseHelper.isDataAvailable()){
            openNextActivity()
        }else{
            databaseHelper.clearTable()
            interactor.setData()
        }
    }

    fun openNextActivity(){
        val intent = Intent(this, ListSurahActivity::class.java)
        startActivity(intent)
        finish()
    }
}
