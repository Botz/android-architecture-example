package de.dabotz.shoppinglist

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import de.dabotz.shoppinglist.models.GroceryListItem
import kotlinx.android.synthetic.main.vh_grocerylist.view.*

/**
 * Created by Botz on 06.07.17.
 */
class GroceryListItemAdapter(val onClickListener: (item:GroceryListItem) -> Unit): RecyclerView.Adapter<GroceryListItemAdapter.GroceryListItemViewHolder>() {

    var data: List<GroceryListItem> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int) = GroceryListItemViewHolder(parent.inflate(R.layout.vh_grocerylist))

    override fun onBindViewHolder(viewHolder: GroceryListItemViewHolder, position: Int) {
        println("Bind ViewHolder Position: ${position}")
        viewHolder.bindView(data[position], onClickListener)
    }

    override fun getItemCount(): Int {
        println("Item Size: ${data.size}")
        return data.size
    }


    class GroceryListItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindView(groceryListItem: GroceryListItem, onClickListener: (item: GroceryListItem) -> Unit) {
            itemView.groceryListItemName.text = groceryListItem.name
            itemView.setOnClickListener {
                onClickListener(groceryListItem)
            }
        }
    }

}