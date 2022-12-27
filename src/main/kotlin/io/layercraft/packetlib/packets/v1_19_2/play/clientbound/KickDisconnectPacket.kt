package io.layercraft.packetlib.packets.v1_19_2.play.clientbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 *  | 0x19 | play | clientbound
 *
 * @property reason reason
 * @see <a href="https://wiki.vg/Protocol#Disconnect_.28play.29">https://wiki.vg/Protocol#Disconnect_.28play.29</a>
 */

@MinecraftPacket(id = 0x19, state = PacketState.PLAY, direction = PacketDirection.CLIENTBOUND)
data class KickDisconnectPacket(
    val reason: String,
) : ClientBoundPacket {

    companion object : PacketSerializer<KickDisconnectPacket> {
        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): KickDisconnectPacket {
            val reason = input.readString()

            return KickDisconnectPacket(reason)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: KickDisconnectPacket) {
            output.writeString(value.reason)
        }
    }
}