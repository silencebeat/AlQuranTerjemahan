package freeapk.com.alqurantranslation.Views.ViewHolders

import android.support.v7.widget.RecyclerView
import android.view.View
import freeapk.com.alqurantranslation.Entities.Models.Quran
import kotlinx.android.synthetic.main.list_verse.view.*

/**
 * Created by Candra Triyadi on 01/02/2018.
 */
class VerseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


    fun onBind(model: Quran) = with(itemView){

        val number = "${model.verseId}".replace("1", "١").replace("0", "٠")
                .replace("2", "٢").replace("3", "٣").replace("4", "٤")
                .replace("5","٥" ).replace("6", "٦").replace("7", "٧")
                .replace("9", "٩").replace("8", "٨")
        text_verse_id.text = "-$number-"
        text_original.text = model.ayahText
        text_translate.text = model.translation.replace("\\\"", "\"")

    }
}