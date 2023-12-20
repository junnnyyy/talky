package forever.young.talky.service

import forever.young.talky.entity.Message
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class KafkaProducerService(
    private val kafkaTemplate: ReactiveKafkaProducerTemplate<String, Message>
) {
    fun sendMessage(topic: String, message: Message): Mono<Void> {
        return kafkaTemplate.send(topic, message.id, message).then()
    }
}