package com.example.wishlist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var items: MutableList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemRv = findViewById<RecyclerView>(R.id.itemRv)
        items = listOf<Item>(Item("", "", "")).toMutableList()

        val adapter = Adapter(items)
        itemRv.adapter = adapter
        itemRv.layoutManager = LinearLayoutManager(this)

        var nameEdit = findViewById<EditText>(R.id.editName)
        var priceEdit = findViewById<EditText>(R.id.editPrice)
        var urlEdit = findViewById<EditText>(R.id.editUrl)

        val addButton = findViewById<Button>(R.id.button)

        addButton.setOnClickListener {
            if(nameEdit.text.isNotEmpty()){
                if(items[0].name == "") {
                    items[0] = (
                            Item(
                                nameEdit.text.toString(),
                                priceEdit.text.toString(),
                                urlEdit.text.toString()
                            )
                            )
                }else{
                    items.add(
                        Item(
                            nameEdit.text.toString(),
                            priceEdit.text.toString(),
                            urlEdit.text.toString()
                        )
                    )
                }
                Toast.makeText(it.context, nameEdit.text.toString() + " added", Toast.LENGTH_SHORT)
                    .show()
                adapter.notifyDataSetChanged()
            }else{
                Toast.makeText(it.context, "Must fill in ITEM attribute to add item", Toast.LENGTH_SHORT)
                    .show()
            }
            hideSoftKeyboard(nameEdit)
            hideSoftKeyboard(priceEdit)
            hideSoftKeyboard(urlEdit)
            nameEdit.text.clear()
            priceEdit.text.clear()
            urlEdit.text.clear()
        }

    }
    private fun hideSoftKeyboard(view: View) {
        val imm =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}