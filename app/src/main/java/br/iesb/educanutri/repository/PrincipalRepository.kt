package br.iesb.educanutri.repository

import android.content.Context
import br.iesb.educanutri.data_class.Food
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class PrincipalRepository(context: Context) {
    private val database = FirebaseDatabase.getInstance()

    fun saveNewFood(
        food: Food
    ) {
        val reference = database.getReference("food")

        reference.push().setValue(food)
    }

    fun checkPassword(password: String, callback: (String?) -> Unit) {
        val query = database.getReference("password")

        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val list = snapshot.children

                list.forEach { snap ->
                    val value = snap.getValue(String::class.java)

                    callback(value)
                }
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