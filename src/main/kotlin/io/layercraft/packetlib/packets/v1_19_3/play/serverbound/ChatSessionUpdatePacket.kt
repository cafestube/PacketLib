package io.layercraft.packetlib.packets.v1_19_3.play.serverbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface
import java.util.UUID
/**
 * Player Session | 0x20 | play | serverbound
 *
 * @param sessionUUID sessionUUID
 * @param expireTime expireTime
 * @param publicKey publicKey
 * @param signature signature
 * @see <a href="https://wiki.vg/index.php?title=Protocol&oldid=18067#Player_Session">https://wiki.vg/Protocol#Player_Session</a>
 */

@MinecraftPacket(id = 0x20, state = PacketState.PLAY, direction = PacketDirection.SERVERBOUND)
data class ChatSessionUpdatePacket(
    val sessionUUID: UUID,
    val expireTime: Long,
    val publicKey: ByteArray,
    val signature: ByteArray,
) : ServerBoundPacket {
    companion object : PacketSerializer<ChatSessionUpdatePacket> {
        override fun deserialize(input: MinecraftProtocolDeserializeInterface<*>): ChatSessionUpdatePacket {
            val sessionUUID = input.readUUID()
            val expireTime = input.readLong()
            val publicKey = input.readVarIntByteArray()
            val signature = input.readVarIntByteArray()

            return ChatSessionUpdatePacket(sessionUUID, expireTime, publicKey, signature)
        }

        override fun serialize(output: MinecraftProtocolSerializeInterface<*>, value: ChatSessionUpdatePacket) {
            output.writeUUID(value.sessionUUID)
            output.writeLong(value.expireTime)
            output.writeVarIntByteArray(value.publicKey)
            output.writeVarIntByteArray(value.signature)
        }
    }
}