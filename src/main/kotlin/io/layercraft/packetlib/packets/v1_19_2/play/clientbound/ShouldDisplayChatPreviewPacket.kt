package io.layercraft.packetlib.packets.v1_19_2.play.clientbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Use Item | 0x4e | play | clientbound
 *
 * @property should_display_chat_preview should_display_chat_preview
 * @see <a href="https://wiki.vg/Protocol#Use_Item">https://wiki.vg/Protocol#Use_Item</a>
 */

@MinecraftPacket(id = 0x4e, state = PacketState.PLAY, direction = PacketDirection.CLIENTBOUND)
data class ShouldDisplayChatPreviewPacket(
    val should_display_chat_preview: Boolean,
) : ClientBoundPacket {

    companion object : PacketSerializer<ShouldDisplayChatPreviewPacket> {
        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): ShouldDisplayChatPreviewPacket {
            val should_display_chat_preview = input.readBoolean()

            return ShouldDisplayChatPreviewPacket(should_display_chat_preview)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: ShouldDisplayChatPreviewPacket) {
            output.writeBoolean(value.should_display_chat_preview)
        }
    }
}