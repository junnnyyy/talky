package forever.young.talky.config.kafka

import forever.young.talky.entity.Message
import forever.young.talky.serializer.MessageSerializer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import java.util.HashMap

@Configuration
class KafkaProducerConfig(
    @Value("\${kafka.producer.bootstrap-servers}")
    private val bootStrapServer: String,
) {

    @Bean
    fun produceFactory(): ProducerFactory<String, Message> {
        val configProps: MutableMap<String, Any> = HashMap()
        configProps[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootStrapServer
        configProps[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        configProps[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = MessageSerializer::class.java
        return DefaultKafkaProducerFactory(configProps)
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, Message> {
        return KafkaTemplate(produceFactory())
    }
}