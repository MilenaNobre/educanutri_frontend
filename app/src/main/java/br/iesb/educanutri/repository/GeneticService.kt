package br.iesb.educanutri.repository

import retrofit2.Call
import retrofit2.http.GET

interface GeneticService {
    @GET("genetic/")
    fun runGeneticAlgorithm():Call<String>
}