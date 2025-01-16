package com.nashsoft.refor_api.service

import com.nashsoft.refor_api.model.Reforestation
import com.nashsoft.refor_api.repository.ReforestationRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ReforestationService(private val reforestationRepository: ReforestationRepository) {
    fun getReforestations(): List<Reforestation> = reforestationRepository.findAll().toList()
    fun getReforestation(id: String): Reforestation? = reforestationRepository.findByIdOrNull(id)
    fun saveReforestation(reforestation: Reforestation): Reforestation = reforestationRepository.save(reforestation)
}