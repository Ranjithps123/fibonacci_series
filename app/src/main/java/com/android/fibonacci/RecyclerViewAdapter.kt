package com.android.fibonacci
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class RecyclerViewAdapter(private var count: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TAG = RecyclerViewAdapter::class.qualifiedName

    override fun getItemCount(): Int {
        return count
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fibonacci_list_row, parent, false)
        return RegularViewHolder(view)
    }

    // binding data to each cell
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as RegularViewHolder
        holder.cell_no.text = "Cell "+(position+1)
        holder.febonacci_no.text = "Fibonacci "+(FibonacciCalculation.getFibonacciNumber(position + 1))
    }

    // add items to recycler view
    fun addItems(itemsAddCount : Int) {
        count +=itemsAddCount
        notifyItemRangeInserted(count-itemsAddCount, count)
    }

    inner class RegularViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var cell_no: TextView
        var febonacci_no: TextView

        init {
            itemView.setOnClickListener(this)
            cell_no = itemView.findViewById<View>(R.id.cell_no) as TextView
            febonacci_no = itemView.findViewById<View>(R.id.fibonacci_no) as TextView
        }

        override fun onClick(view: View) {
            Log.d(TAG, "onClick " + cell_no.text)
            Toast.makeText(itemView.context, "onClick " + cell_no.text, Toast.LENGTH_SHORT).show()
        }
    }

}
