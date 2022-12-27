package io.layercraft.packetlib.packets.v1_19.play.clientbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Update Advancements | 0x64 | play | clientbound
 *
 * @property reset reset
 * @see <a href="https://wiki.vg/Protocol#Update_Advancements">https://wiki.vg/Protocol#Update_Advancements</a>
 */

@MinecraftPacket(id = 0x64, state = PacketState.PLAY, direction = PacketDirection.CLIENTBOUND)
data class AdvancementsPacket(
    val reset: Boolean,
) : ClientBoundPacket {

    companion object : PacketSerializer<AdvancementsPacket> {
        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): AdvancementsPacket {
            val reset = input.readBoolean()

            return AdvancementsPacket(reset)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: AdvancementsPacket) {
            output.writeBoolean(value.reset)
        }
    }
}