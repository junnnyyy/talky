package forever.young.talky

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TalkyApplication

fun main(args: Array<String>) {
	runApplication<TalkyApplication>(*args)
}
