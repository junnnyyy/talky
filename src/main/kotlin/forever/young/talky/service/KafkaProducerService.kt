package forever.young.talky.service

import forever.young.talky.entity.Message
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class KafkaProducerService(
    private val kafkaTemplate: KafkaTemplate<String, Message>
) {
    fun sendMessage(topic: String, message: Message): Mono<Void> {
        return kafkaTemplate.send(topic, message.id, message).then()
    }
}