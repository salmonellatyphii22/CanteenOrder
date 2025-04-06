package com.example.canteen.ui.theme

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.canteen.CartActivity
import com.example.canteen.R
import com.example.canteen.model.FoodItem
import com.example.canteen.viewmodel.CartViewModel
import com.example.canteen.adapter.FoodAdapter
import com.example.canteen.MyApplication

class MenuActivity : AppCompatActivity() {

    private lateinit var cartViewModel: CartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ✅ Shared ViewModel using Application's provider
        cartViewModel = (application as MyApplication)
            .viewModelProvider[CartViewModel::class.java]

        // ✅ Sample menu items
        val menuItems = listOf(
            FoodItem("1", "Maggie", 70.00, R.drawable.maggie),
            FoodItem("2", "Pasta", 80.00, R.drawable.pasta),
            FoodItem("3", "Momos", 100.00, R.drawable.momos),
            FoodItem("4", "Spring Roll", 60.00, R.drawable.spring_roll),
            FoodItem("5", "Sandwich", 40.00, R.drawable.sandwich),
            FoodItem("6", "Burger", 100.00, R.drawable.burger),
            FoodItem("7", "Paneer Roll", 120.00, R.drawable.paneer_roll),
            FoodItem("8", "Dosa", 150.00, R.drawable.dosa),
            FoodItem("9", "Chole Bhature", 80.00, R.drawable.chola_bhatura),
            FoodItem("10", "Samosa", 15.00, R.drawable.samosa),
            FoodItem("11", "Water", 20.00, R.drawable.water),
            FoodItem("12", "Lassi", 80.00, R.drawable.lassi),
            FoodItem("13", "Sprite", 50.00, R.drawable.sprite),
            FoodItem("14", "CocaCola", 40.00, R.drawable.cocacola),
            FoodItem("15", "ThumbsUp", 50.00, R.drawable.thumbs_up)
        )

        // ✅ Set up adapter and RecyclerView
        val adapter = FoodAdapter(menuItems, onClick = { item ->
            cartViewModel.addToCart(item)
            Toast.makeText(this, "${item.name} added to cart!", Toast.LENGTH_SHORT).show()
        })

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun openCart(view: View) {
        startActivity(Intent(this, CartActivity::class.java))
    }
}
