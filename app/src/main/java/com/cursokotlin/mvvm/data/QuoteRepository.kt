package com.cursokotlin.mvvm.data

import com.cursokotlin.mvvm.data.database.dao.QuoteDao
import com.cursokotlin.mvvm.data.database.entities.QuoteEntity
import com.cursokotlin.mvvm.data.model.QuoteModel
import com.cursokotlin.mvvm.data.network.QuoteService
import com.cursokotlin.mvvm.domain.model.Quote
import com.cursokotlin.mvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase():List<Quote>{
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}