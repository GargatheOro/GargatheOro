package me.GargatheOro.PathfinderCore.Main;

import me.GargatheOro.PathfinderCore.Items.ItemInit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

public class TESTEVENT {
	public void onMineEvent(BreakEvent event) {
		EntityPlayer miner = event.getPlayer();
		if(miner.getHeldItemMainhand().getItem() != ItemInit.SILVER_INGOT) {
			event.setCanceled(true);
			return;
		}
	}
}