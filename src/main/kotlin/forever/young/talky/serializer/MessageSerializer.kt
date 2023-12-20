package forever.young.talky.serializer

import forever.young.talky.entity.Message
import org.apache.kafka.common.serialization.Serializer

class MessageSerializer:Serializer<Message> {
    override fun serialize(p0: String?, p1: Message?): ByteArray {
        TODO("Not yet implemented")
    }
}