package bbl.micronaut

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/")
class HelloController(val greetingService: GreetingService) {

    @Get("/hello/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(name: String): String {
        return greetingService.greet(name)
    }
}