package com.nashsoft.refor_api.controller

import com.nashsoft.refor_api.model.Reforestation
import com.nashsoft.refor_api.service.ReforestationService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
class ReforestationController(private val reforestationService: ReforestationService) {
    @GetMapping("/reforestations")
    @Operation(summary = "List reforestations", description = "List all reforestations")
    fun listReforestations() = reforestationService.getReforestations()

    @PostMapping("/reforestations")
    @Operation(summary = "Add reforestation", description = "Add a new reforestation")
    fun addReforestation(@RequestBody reforestation: Reforestation): ResponseEntity<Reforestation> {
        val newReforestation = reforestationService.saveReforestation(reforestation)
        return ResponseEntity.created(URI("/${newReforestation.id}")).body(newReforestation)
    }
}