package br.iesb.educanutri.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.iesb.educanutri.data_class.Food
import br.iesb.educanutri.interactor.PrincipalInteractor
import br.iesb.educanutri.repository.DayMenuDTO

class PrincipalViewModel(app: Application) : AndroidViewModel(app) {
    private val interactor = PrincipalInteractor(app.applicationContext)
    val foods = MutableLiveData<MutableList<Food>>()
    val geneticResults = MutableLiveData<MutableList<DayMenuDTO>>()

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
        callback: (Array<String>) -> Unit
    ) {
        interactor.saveNewFood(
            name,
            group,
            price.replace(',', '.'),
            energy,
            protein,
            fiber,
            lipids,
            zinc,
            magnesium,
            carbohydrate,
            iron,
            calcium
        ) { response ->
            if (response == "EMPTY") {
                callback(arrayOf("ERROR", "Preencha todos os campos"))
            } else {
                callback(
                    arrayOf(
                        "ERROR",
                        "Alimento salvo com sucesso! Um administrador irá avaliar e inserir na consulta."
                    )
                )
            }
        }
    }

    fun checkPassword(password: String, callback: (Array<String>) -> Unit) {
        interactor.checkPassword(password) { response ->
            if (response == "EMPTY") {
                callback(arrayOf("ERROR", "Informe a senha!"))
            } else if (response == "WRONG") {
                callback(arrayOf("ERROR", "Senha errada. Verifique e tente novamente"))
            } else {
                callback(arrayOf("OK", "Senha correta!"))
            }
        }
    }

    fun getAllFoods() {
        interactor.getAllFoods { foodList ->
            foods.value?.clear()

            val allFoods = mutableListOf<Food>()

            foodList.forEach { food ->
                allFoods.add(food)
            }

            foods.value = allFoods
        }
    }

    fun deleteFood(id: String, callback: (Array<String>) -> Unit) {
        interactor.deleteFood(id) { response ->
            if (response == "OK") {
                callback(arrayOf("OK", "Alimento excluído com sucesso!"))
            }
        }
    }

    fun geneticAlgorithm(tam_pop: String, qtd_days: String) {
        interactor.geneticAlgorithm(tam_pop, qtd_days) { result ->
            val menus = mutableListOf<DayMenuDTO>()
            result?.menus?.forEach { dayMenuArray ->
                dayMenuArray.forEach { dayMenu ->
                    menus.add(dayMenu)
                }
            }
            geneticResults.value = menus
        }
    }
}