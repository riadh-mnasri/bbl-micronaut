package bbl.micronaut

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class HelloControllerTest {
    @Inject
    @Client("/")
    internal var client: RxHttpClient? = null // <2>

    @Test
    @Throws(Exception::class)
    fun testHello() {
        val request = HttpRequest.GET<Any>("/hello") // <3>
        val body = client!!.toBlocking().retrieve(request)

        Assertions.assertThat(body).isNotEmpty()
        Assertions.assertThat(body).isEqualTo("Hello Enedis!")
    }
}
