package com.example.movieapplication.data.repository

import com.example.movieapplication.data.api.ApplicationService
import javax.inject.Inject

class ApplicationRepository @Inject constructor(private val applicationService: ApplicationService) :
    BaseRepository() {

    suspend fun getMovieForSlider() = safeApiCall { applicationService.getMovieForSlider() }

    suspend fun getMovieList(page: Int) = safeApiCall { applicationService.getMovieList(page) }

    suspend fun getMovieDetails(id: Int) = safeApiCall { applicationService.getMovieDetails(id) }

}