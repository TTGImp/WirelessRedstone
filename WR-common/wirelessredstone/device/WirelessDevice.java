/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details. You should have received a copy of the GNU
 * Lesser General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>
 */
package wirelessredstone.device;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import wirelessredstone.api.IWirelessDevice;
import wirelessredstone.core.lib.NBTLib;
import wirelessredstone.data.WirelessCoordinates;

/**
 * A wireless device.<br>
 * Contains the device data.
 * 
 * @author Eurymachus
 */
public abstract class WirelessDevice implements IWirelessDevice {

	protected int				xCoord, yCoord, zCoord;
	protected EntityLivingBase	owner;
	protected String			freq;
	protected boolean			state;
	protected int				dimension;

	protected WirelessDevice(World world, EntityLivingBase entity) {
		this.owner = entity;
		this.setCoords(	(int) entity.posX,
						(int) entity.posY,
						(int) entity.posZ);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbttagcompound) {
		if (nbttagcompound == null) {
			nbttagcompound = new NBTTagCompound();
		}
		nbttagcompound.setInteger(	"x",
									this.xCoord);
		nbttagcompound.setInteger(	"y",
									this.yCoord);
		nbttagcompound.setInteger(	"z",
									this.zCoord);
		nbttagcompound.setString(	NBTLib.FREQUENCY,
									this.freq);
		nbttagcompound.setBoolean(	NBTLib.STATE,
									this.state);
		nbttagcompound.setInteger(	NBTLib.DIMENSION,
									this.dimension);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbttagcompound) {
		this.xCoord = nbttagcompound.getInteger("x");
		this.yCoord = nbttagcompound.getInteger("y");
		this.zCoord = nbttagcompound.getInteger("z");
		this.freq = nbttagcompound.getString(NBTLib.FREQUENCY);
		this.state = nbttagcompound.getBoolean(NBTLib.STATE);
		this.dimension = nbttagcompound.getInteger(NBTLib.DIMENSION);
	}

	@Override
	public EntityLivingBase getOwner() {
		return this.owner;
	}

	@Override
	public void setOwner(EntityLiving entity) {
		this.owner = entity;
	}

	@Override
	public String getFreq() {
		return this.freq;
	}

	@Override
	public void setCoords(WirelessCoordinates coords) {
		int x = coords.getX(), y = coords.getY(), z = coords.getZ();
		this.setCoords(	x,
						y,
						z);
	}

	@Override
	public void setCoords(int x, int y, int z) {
		this.xCoord = x;
		this.yCoord = y;
		this.zCoord = z;
	}

	@Override
	public WirelessCoordinates getCoords() {
		return new WirelessCoordinates(this.xCoord, this.yCoord, this.zCoord);
	}

	@Override
	public World getWorld() {
		return DimensionManager.getWorld(this.dimension);
	}

	@Override
	public void setFreq(String freq) {
		this.freq = freq;
	}

	@Override
	public void activate(World world, Entity entity) {
		this.state = true;
		if (!world.isRemote) {
			this.doActivateCommand();
		}
	}

	@Override
	public void deactivate(World world, Entity entity, boolean isForced) {
		this.state = true;
		if (!world.isRemote) {
			this.doDeactivateCommand();
		}
	}

	@Override
	public abstract void doActivateCommand();

	@Override
	public abstract void doDeactivateCommand();

	protected abstract String getActivateCommand();

	protected abstract String getDeactivateCommand();

	@Override
	public abstract boolean isBeingHeld(EntityLivingBase entityliving);

	@Override
	public int getSizeInventory() {
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return null;
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
	}

	@Override
	public int getInventoryStackLimit() {
		return 0;
	}

	@Override
	public void onInventoryChanged() {
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return false;
	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

}
