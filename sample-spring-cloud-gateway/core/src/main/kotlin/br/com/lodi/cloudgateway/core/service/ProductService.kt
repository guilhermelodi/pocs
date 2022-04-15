package br.com.lodi.cloudgateway.core.service

import br.com.lodi.cloudgateway.core.domain.ProductResponse
import org.springframework.stereotype.Service

@Service
class ProductService {

    fun listAll() = productList;

    fun findById(id: Long) =
        productList.stream()
            .filter { it.id == id }
            .findFirst()
            .get()

    companion object {
        val productList = listOf(
            ProductResponse(1L, 1L, "PlayStation 4", 2200.0),
            ProductResponse(2L, 1L, "PlayStation 5", 9000.0),
            ProductResponse(3L, 2L, "Xbox 360", 500.0),
            ProductResponse(3L, 2L, "Xbox One", 2000.0),
            ProductResponse(3L, 2L, "Xbox Series X", 4000.0),
        )
    }
}