package io.layercraft.packetlib.packets.v1_19.play.serverbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface
import io.layercraft.packetlib.types.Position

/**
 * Use Item | 0x1c | play | serverbound
 *
 * @property status status
 * @property location location
 * @property face face
 * @property sequence sequence
 * @see <a href="https://wiki.vg/Protocol#Use_Item">https://wiki.vg/Protocol#Use_Item</a>
 */

@MinecraftPacket(id = 0x1c, state = PacketState.PLAY, direction = PacketDirection.SERVERBOUND)
data class BlockDigPacket(
    val status: Int, // varint
    val location: Position,
    val face: Byte,
    val sequence: Int, // varint
) : ServerBoundPacket {

    companion object : PacketSerializer<BlockDigPacket> {
        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): BlockDigPacket {
            val status = input.readVarInt()
            val location = input.readPosition()
            val face = input.readByte()
            val sequence = input.readVarInt()

            return BlockDigPacket(status, location, face, sequence)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: BlockDigPacket) {
            output.writeVarInt(value.status)
            output.writePosition(value.location)
            output.writeByte(value.face)
            output.writeVarInt(value.sequence)
        }
    }
}