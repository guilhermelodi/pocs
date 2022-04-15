package br.com.lodi.cloudgateway.core.domain

data class ProductResponse(
    var id: Long,

    var storeId: Long,

    var name: String,

    var value: Double
)
