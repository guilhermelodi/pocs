package br.com.lodi.cloudgateway.shipping.controller

import br.com.lodi.cloudgateway.shipping.domain.ShippingStoreResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class ShippingController {

    @GetMapping("/shipping/stores/{storeId}/destination/{zipCode}")
    fun calculateShipping(@PathVariable storeId: Long, @PathVariable zipCode: String) =
        ShippingStoreResponse(storeId, Random.nextInt(1, 100))

}