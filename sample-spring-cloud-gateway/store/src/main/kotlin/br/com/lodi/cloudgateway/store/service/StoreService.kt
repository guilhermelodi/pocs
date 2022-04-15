package br.com.lodi.cloudgateway.store.service

import br.com.lodi.cloudgateway.store.domain.StoreResponse
import org.springframework.stereotype.Service

@Service
class StoreService {

    fun listAll() = storeList;

    fun findById(id: Long) =
        storeList.stream()
            .filter { it.id == id }
            .findFirst()
            .get()

    companion object {
        val storeList = listOf(
            StoreResponse(1L, "Sony", "Av. X, 500"),
            StoreResponse(2L, "Microsoft", "Av. M, 360"),
        )
    }
}