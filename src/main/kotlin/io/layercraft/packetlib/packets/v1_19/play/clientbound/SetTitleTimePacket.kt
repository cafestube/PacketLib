package io.layercraft.packetlib.packets.v1_19.play.clientbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Use Item | 0x5b | play | clientbound
 *
 * @property fadeIn fadeIn
 * @property stay stay
 * @property fadeOut fadeOut
 * @see <a href="https://wiki.vg/Protocol#Use_Item">https://wiki.vg/Protocol#Use_Item</a>
 */

@MinecraftPacket(id = 0x5b, state = PacketState.PLAY, direction = PacketDirection.CLIENTBOUND)
data class SetTitleTimePacket(
    val fadeIn: Int,
    val stay: Int,
    val fadeOut: Int,
) : ClientBoundPacket {

    companion object : PacketSerializer<SetTitleTimePacket> {
        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): SetTitleTimePacket {
            val fadeIn = input.readInt()
            val stay = input.readInt()
            val fadeOut = input.readInt()

            return SetTitleTimePacket(fadeIn, stay, fadeOut)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: SetTitleTimePacket) {
            output.writeInt(value.fadeIn)
            output.writeInt(value.stay)
            output.writeInt(value.fadeOut)
        }
    }
}