package io.layercraft.packetlib.packets.v1_19_2.play.clientbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Use Item | 0x4b | play | clientbound
 *
 * @property chunkX chunkX
 * @property chunkZ chunkZ
 * @see <a href="https://wiki.vg/Protocol#Use_Item">https://wiki.vg/Protocol#Use_Item</a>
 */

@MinecraftPacket(id = 0x4b, state = PacketState.PLAY, direction = PacketDirection.CLIENTBOUND)
data class UpdateViewPositionPacket(
    val chunkX: Int, // varint
    val chunkZ: Int, // varint
) : ClientBoundPacket {

    companion object : PacketSerializer<UpdateViewPositionPacket> {
        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): UpdateViewPositionPacket {
            val chunkX = input.readVarInt()
            val chunkZ = input.readVarInt()

            return UpdateViewPositionPacket(chunkX, chunkZ)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: UpdateViewPositionPacket) {
            output.writeVarInt(value.chunkX)
            output.writeVarInt(value.chunkZ)
        }
    }
}