package wirelessredstone.addon.camouflager.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import wirelessredstone.addon.camouflager.core.lib.CamouLib;
import wirelessredstone.addon.camouflager.inventory.slot.SlotBlock;
import wirelessredstone.tileentity.ContainerRedstoneWireless;

public class ContainerCamouflagedRedstoneWireless extends
		ContainerRedstoneWireless {

	InventoryPlayer	playerInventory;

	public ContainerCamouflagedRedstoneWireless(InventoryPlayer playerInventory, TileEntity tileentity) {
		super(tileentity);
		this.playerInventory = playerInventory;
		this.bindLocalInventory();
		this.bindPlayerInventory(	0,
									84);
	}

	protected void bindLocalInventory() {
		this.addSlotToContainer(new SlotBlock(this.redstoneWireless, 0, 80, 36));
	}

	protected void bindPlayerInventory(int playerColOffset, int playerRowOffset) {
		// Player inventory
		for (int row = 0; row < 3; ++row) {
			for (int column = 0; column < 9; ++column) {
				int slotIndex = column + row * 9 + 9;
				this.addSlotToContainer(new Slot(this.playerInventory, slotIndex, (8 + column * 18 + playerColOffset), (row * 18 + playerRowOffset)));
			}
		}

		// Hotbar inventory
		for (int column = 0; column < 9; ++column) {
			int slotIndex = column;
			this.addSlotToContainer(new Slot(this.playerInventory, slotIndex, (8 + column * 18 + playerColOffset), 58 + playerRowOffset));
		}
	}

	private ItemStack transferBlockToSlot(EntityPlayer player, int slotShiftClicked) {
		ItemStack stackCopy = null;
		Slot slot = (Slot) this.inventorySlots.get(slotShiftClicked);

		if (slot != null && slot.getHasStack()) {
			ItemStack stackInSlot = slot.getStack();
			if (CamouLib.isBlock(stackInSlot)) {
				stackCopy = stackInSlot.copy();
				if (slotShiftClicked < 1) {
					if (!this.mergeItemStack(	stackInSlot,
												1,
												this.inventorySlots.size(),
												true)) {
						return null;
					}
				} else if (!this.mergeItemStack(stackInSlot,
												0,
												1,
												false)) {
					return null;
				}

				if (stackInSlot.stackSize == 0) {
					slot.putStack((ItemStack) null);
				} else {
					slot.onSlotChanged();
				}
			}
		}

		return stackCopy;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotID) {
		ItemStack stack = this.transferBlockToSlot(	player,
													slotID);

		return stack;
	}
}