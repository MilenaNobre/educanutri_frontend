package br.iesb.educanutri.repository

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

data class BreakfastSnackDTO(
    val foods: Array<FoodDTO>? = null
)

data class PlateDTO(
    val cor: Int? = null,
    val id: Int? = null,
    val nome: String? = null,
    val tipo: Int? = null,
    val consistencia: Int? = null
)

data class LunchDTO(
    val plates: Array<PlateDTO>? = null
)

data class DayMenuDTO(
    val breakfast: BreakfastSnackDTO? = null,
    val lunch: LunchDTO? = null,
    val snack: BreakfastSnackDTO? = null
)

data class GeneticDTO(
    val menus: Array<DayMenuDTO>? = null
)