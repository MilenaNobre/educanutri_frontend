package br.iesb.educanutri.repository

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GeneticService {
    @GET("genetic/{tam_pop}/{qtd_dias}")
    fun runGeneticAlgorithm(
        @Path("tam_pop") tam_pop: Int,
        @Path("qtd_dias") qtd_dias: Int
    ): Call<GeneticDTO>
}