package br.com.lodi.springkafkatestcontainer.producer

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/produce")
class Controller(
    private val producer: Producer
) {

    @GetMapping("/{value}")
    fun produce(@PathVariable value: String) =
        producer.produce(value)

}