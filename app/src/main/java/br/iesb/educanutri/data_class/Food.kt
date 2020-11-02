package br.iesb.educanutri.data_class

data class Food(
    val name: String? = null,
    val group: String? = null,
    val price: Double? = null,
    val energy: Double? = null,
    val protein: Double? = null,
    val fiber: Double? = null,
    val lipids: Double? = null,
    val zinc: Double? = null,
    val magnesium: Double? = null,
    val carbohydrate: Double? = null,
    val iron: Double? = null,
    val calcium: Double? = null,
    var id: String? = null
)