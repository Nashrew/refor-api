package com.nashsoft.refor_api.model

import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal

@Table("reforestations")
data class Reforestation(
    @Id
    @Column("id")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    val id: String? = null,

    @Column("name")
    val name: String,

    @Column("currentPercentage")
    val currentPercentage: BigDecimal,

    @Column("targetPercentage")
    val targetPercentage: BigDecimal
)