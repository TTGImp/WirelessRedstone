package wirelessredstone.api;

import wirelessredstone.network.packets.PacketWireless;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;

public interface IDevicePacketExecutor extends IPacketExecutor {
	/**
	 * Execute the packet.
	 * 
	 * @param packet The redstone wireless device packet.
	 * @param world The world object.
	 * @param entityplayer the player
	 */
	public void execute(PacketWireless packet, World world, EntityPlayer entityplayer);
}