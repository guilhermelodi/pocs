package br.com.lodi.cloudgateway.core.controller

import br.com.lodi.cloudgateway.core.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/products")
class ProductController(
    val productService: ProductService
) {

    @GetMapping
    fun listAll() = productService.listAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) = productService.findById(id)

}