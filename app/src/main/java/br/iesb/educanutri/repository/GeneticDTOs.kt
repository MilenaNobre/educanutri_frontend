package br.iesb.educanutri.repository

import com.google.gson.annotations.SerializedName

data class FoodDTO(
    var id: Int? = null,
    val valor: Double? = null,
    val proteinas: Double? = null,
    val lipideos: Double? = null,
    val calcio: Double? = null,
    val ferro: Double? = null,
    val magnesio: Double? = null,
    val nome: String? = null,
    val energia: Double? = null,
    val carboidratos: Double? = null,
    val fibras: Double? = null,
    val zinco: Double? = null,
    val grupo: Double? = null
)

data class PlateDTO(
    val cor: Int? = null,
    val id: Int? = null,
    val nome: String? = null,
    val tipo: Int? = null,
    val consistencia: Int? = null
)

data class DayMenuDTO(
    @SerializedName("desjejum")
    val breakfast: Array<FoodDTO>? = null,
    @SerializedName("almoco")
    val lunch: Array<PlateDTO>? = null,
    @SerializedName("lanche")
    val snack: Array<FoodDTO>? = null
)

data class GeneticDTO(
    @SerializedName("resultado")
    val menus: Array<Array<DayMenuDTO>>? = null
)