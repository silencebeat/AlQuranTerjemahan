package silencebeat.com.alquranterjemahanindonesia.Supports.Utils

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
/**
 * Created by Candra Triyadi on 30/12/2017.
 */
abstract class Adapter<TipeData, ViewHolder: RecyclerView.ViewHolder>(var mLayout: Int,
                                                                      var mViewhOlderClass: Class<ViewHolder>,
                                                                      var mModelClass: Class<TipeData>,
                                                                      var mData: List<TipeData>): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(mLayout, parent, false)
        val constructor = mViewhOlderClass.getConstructor(View::class.java)
        return constructor.newInstance(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = getItem(position)
        bindView(holder, model, position)
    }

    abstract protected fun bindView(holder: ViewHolder, tipeData: TipeData, position: Int)

    private fun getItem(position: Int): TipeData{
        return mData[position]
    }

    override fun getItemCount(): Int {
        return mData.size
    }

}