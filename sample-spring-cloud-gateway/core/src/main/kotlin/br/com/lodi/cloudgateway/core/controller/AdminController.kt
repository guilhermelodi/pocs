package br.com.lodi.cloudgateway.core.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AdminController {

    @GetMapping("/admin")
    fun test() = "Test admin"

}