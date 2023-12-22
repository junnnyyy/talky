package forever.young.talky.service

import forever.young.talky.config.kafka.EXAMPLE_TOPIC_NAME
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducerService(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    fun sendStringMessage(message: String) {
        kafkaTemplate.send(EXAMPLE_TOPIC_NAME, message)
    }
}