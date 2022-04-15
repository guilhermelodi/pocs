package br.com.lodi.cloudgateway.store.controller

import br.com.lodi.cloudgateway.store.service.StoreService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/stores")
class StoreController(
   val storeService: StoreService
) {

    @GetMapping
    fun listAll() = storeService.listAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) = storeService.findById(id)

}