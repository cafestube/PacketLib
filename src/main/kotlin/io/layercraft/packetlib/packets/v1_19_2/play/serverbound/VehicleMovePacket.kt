package io.layercraft.packetlib.packets.v1_19_2.play.serverbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Move Vehicle (serverbound) | 0x18 | play | serverbound
 *
 * @param x x
 * @param y y
 * @param z z
 * @param yaw yaw
 * @param pitch pitch
 * @see <a href="https://wiki.vg/index.php?title=Protocol&oldid=17873#Move_Vehicle_.28serverbound.29">https://wiki.vg/Protocol#Move_Vehicle_.28serverbound.29</a>
 */

@MinecraftPacket(id = 0x18, state = PacketState.PLAY, direction = PacketDirection.SERVERBOUND)
data class VehicleMovePacket(
    val x: Double,
    val y: Double,
    val z: Double,
    val yaw: Float,
    val pitch: Float,
) : ServerBoundPacket {
    companion object : PacketSerializer<VehicleMovePacket> {
        override fun deserialize(input: MinecraftProtocolDeserializeInterface<*>): VehicleMovePacket {
            val x = input.readDouble()
            val y = input.readDouble()
            val z = input.readDouble()
            val yaw = input.readFloat()
            val pitch = input.readFloat()

            return VehicleMovePacket(x, y, z, yaw, pitch)
        }

        override fun serialize(output: MinecraftProtocolSerializeInterface<*>, value: VehicleMovePacket) {
            output.writeDouble(value.x)
            output.writeDouble(value.y)
            output.writeDouble(value.z)
            output.writeFloat(value.yaw)
            output.writeFloat(value.pitch)
        }
    }
}