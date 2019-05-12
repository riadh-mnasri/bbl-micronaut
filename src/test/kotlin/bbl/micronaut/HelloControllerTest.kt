package bbl.micronaut

import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


@MicronautTest
class HelloControllerTest {

    lateinit var server: EmbeddedServer
    lateinit var helloClient: HelloClient

    @BeforeEach
    fun setup() {

        server = ApplicationContext.run(EmbeddedServer::class.java)

        helloClient = server
                .applicationContext
                .getBean(HelloClient::class.java)
    }

    @AfterEach
    fun teardown() {
        server.close()
    }

    @Test
    fun testHelloWorldResponse() {
        org.junit.jupiter.api.Assertions.assertEquals("Hello World", helloClient.hello("World").blockingGet())
    }
}
