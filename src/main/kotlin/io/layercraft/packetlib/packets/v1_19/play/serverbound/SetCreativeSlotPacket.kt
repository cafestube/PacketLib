package io.layercraft.packetlib.packets.v1_19.play.serverbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Use Item | 0x2a | play | serverbound
 *
 * @property slot slot
 * @see <a href="https://wiki.vg/Protocol#Use_Item">https://wiki.vg/Protocol#Use_Item</a>
 */

@MinecraftPacket(id = 0x2a, state = PacketState.PLAY, direction = PacketDirection.SERVERBOUND)
data class SetCreativeSlotPacket(
    val slot: Short,
) : ServerBoundPacket {

    companion object : PacketSerializer<SetCreativeSlotPacket> {
        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): SetCreativeSlotPacket {
            val slot = input.readShort()

            return SetCreativeSlotPacket(slot)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: SetCreativeSlotPacket) {
            output.writeShort(value.slot)
        }
    }
}