package io.layercraft.packetlib.packets.v1_19_2.handshaking.serverbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Use Item | 0xfe | handshaking | serverbound
 *
 * @property payload payload
 * @see <a href="https://wiki.vg/Protocol#Use_Item">https://wiki.vg/Protocol#Use_Item</a>
 */

@MinecraftPacket(id = 0xfe, state = PacketState.HANDSHAKING, direction = PacketDirection.SERVERBOUND)
data class LegacyServerListPingPacket(
    val payload: UByte,
) : ServerBoundPacket {

    companion object : PacketSerializer<LegacyServerListPingPacket> {
        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): LegacyServerListPingPacket {
            val payload = input.readUByte()

            return LegacyServerListPingPacket(payload)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: LegacyServerListPingPacket) {
            output.writeUByte(value.payload)
        }
    }
}