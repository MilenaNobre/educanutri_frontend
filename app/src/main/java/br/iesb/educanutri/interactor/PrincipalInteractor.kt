package br.iesb.educanutri.interactor

import android.content.Context
import br.iesb.educanutri.data_class.Food
import br.iesb.educanutri.repository.PrincipalRepository

class PrincipalInteractor(context: Context) {
    private val repository = PrincipalRepository(context, "https://ameless-0563456123.herokuapp.com/")

    fun saveNewFood(
        name: String,
        group: String,
        price: String,
        energy: String,
        protein: String,
        fiber: String,
        lipids: String,
        zinc: String,
        magnesium: String,
        carbohydrate: String,
        iron: String,
        calcium: String,
        callback: (String) -> Unit
    ) {
        if (name.isEmpty() || group.isEmpty() || price.isEmpty() || energy.isEmpty() ||
            protein.isEmpty() || fiber.isEmpty() || lipids.isEmpty() || zinc.isEmpty() ||
            magnesium.isEmpty() || carbohydrate.isEmpty() || iron.isEmpty() || calcium.isEmpty()
        ) {
            callback("EMPTY")
        } else {
            val food = Food(
                name,
                group,
                price.toDouble(),
                energy.toDouble(),
                protein.toDouble(),
                fiber.toDouble(),
                lipids.toDouble(),
                zinc.toDouble(),
                magnesium.toDouble(),
                carbohydrate.toDouble(),
                iron.toDouble(),
                calcium.toDouble()
            )

            repository.saveNewFood(food)

            callback("OK")
        }
    }

    fun checkPassword(password: String, callback: (String) -> Unit) {
        if (password.isEmpty()) {
            callback("EMPTY")
        } else {
            repository.checkPassword { response ->
                var verification = 0

                response.forEach { dbPass ->
                    if (dbPass == password) {
                        callback("OK")

                        verification++
                    }
                }

                if (verification == 0) {
                    callback("WRONG")
                }
            }
        }
    }

    fun getAllFoods(callback: (MutableSet<Food>) -> Unit) {
        repository.getAllFoods(callback)
    }

    fun deleteFood(id: String, callback: (String) -> Unit) {
        repository.deleteFood(id)

        callback("OK")
    }
}