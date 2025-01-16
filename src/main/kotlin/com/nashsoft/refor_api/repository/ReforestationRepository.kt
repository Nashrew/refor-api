package com.nashsoft.refor_api.repository

import com.nashsoft.refor_api.model.Reforestation
import org.springframework.data.repository.CrudRepository

interface ReforestationRepository : CrudRepository<Reforestation, String>