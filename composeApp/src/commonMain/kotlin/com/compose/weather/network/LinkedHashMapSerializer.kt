package com.compose.weather.network

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual


object LinkedHashMapSerializer : KSerializer<LinkedHashMap<String, String>> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("LinkedHashMap") {
        element<String>("key")
        element<String>("value")
    }

    override fun serialize(encoder: Encoder, value: LinkedHashMap<String, String>) {
        val compositeOutput = encoder.beginStructure(descriptor)
        value.forEach { (key, value) ->
            compositeOutput.encodeStringElement(descriptor, 0, key)
            compositeOutput.encodeStringElement(descriptor, 0, value)
        }
        compositeOutput.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): LinkedHashMap<String, String> {
        val compositeInput = decoder.beginStructure(descriptor)
        val map = LinkedHashMap<String, String>()
        loop@ while (true) {
            when (val index = compositeInput.decodeElementIndex(descriptor)) {
                CompositeDecoder.DECODE_DONE -> break@loop
                0 -> {
                    val key = compositeInput.decodeStringElement(descriptor, 0)
                    val value = compositeInput.decodeStringElement(descriptor, 0)
                    map[key] = value
                }

                else -> throw SerializationException("Unknown index $index")
            }
        }
        compositeInput.endStructure(descriptor)
        return map
    }
}
