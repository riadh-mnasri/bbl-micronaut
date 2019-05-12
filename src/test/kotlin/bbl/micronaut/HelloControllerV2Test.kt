package bbl.micronaut

import io.micronaut.test.annotation.MicronautTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject


@MicronautTest
class HelloControllerV2Test {

    @Inject
    lateinit var helloClient: HelloClient

    @Test
    fun testGreetingService() {
        Assertions.assertThat(helloClient.hello("Enedis").blockingGet()).isEqualTo("Hello Enedis")
    }

}
