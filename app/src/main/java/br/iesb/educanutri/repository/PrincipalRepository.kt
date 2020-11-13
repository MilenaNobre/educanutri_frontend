package br.iesb.educanutri.repository

import android.content.Context
import br.iesb.educanutri.data_class.Food
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class PrincipalRepository(private val context: Context, url: String) : Retrofit(context, url) {
    private val database = FirebaseDatabase.getInstance()
    private val service = retrofit.create(GeneticService::class.java)

    fun saveNewFood(
        food: Food
    ) {
        val reference = database.getReference("food")

        reference.push().setValue(food)
    }

    fun checkPassword(callback: (Array<String?>) -> Unit) {
        val query = database.getReference("password")

        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val list = snapshot.children
                val allPass = mutableListOf<String?>()

                list.forEach { snap ->
                    val value = snap.getValue(String::class.java)

                    allPass.add(value)
                }
                callback(allPass.toTypedArray())
            }

        })
    }

    fun getAllFoods(callback: (MutableSet<Food>) -> Unit) {
        val foods = mutableSetOf<Food>()
        val reference = database.getReference("food")

        reference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                //
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                foods.clear()

                val list = snapshot.children

                list.forEach { snap ->
                    val food = snap.getValue(Food::class.java)

                    if (food != null) {
                        food.id = snap.key
                        foods.add(food)
                    }
                }

                callback(foods)
            }
        })
    }

    fun deleteFood(id: String) {
        val reference = database.getReference("food/$id")

        reference.removeValue()
    }
}