package me.GargatheOro.PathfinderCore.Main;

import me.GargatheOro.PathfinderCore.Items.ItemInit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TESTEVENT {
	//OnMineEvent can be called whatever you want. BreakEvent is the official Minecraft code function for when someone breaks a block.
	//event can be whatever you want to call it, think of it like an acronym that refers to the BreakEvent.
	public void onMineEvent(BreakEvent event) {
		//EntityPlayer refers to a player, and miner is to EntityPlayer as event is to BreakEvent: just a nickname
		//event.GetPlayer(); refers to the player who did the event. I am basically saying "miner" is the player who broke the block.
		EntityPlayer miner = event.getPlayer();
		//Another nickname just like miner is, except referring to the broken block in the event.
		Block minedblock = event.getState().getBlock();
		//Literally saying "if the person who broke the block is holding an item in their mainhand that IS NOT my silver ingot in
		//my mod (change ItemInit.SILVER_INGOT to whatever your item you want to break things is by the way), THEN do what's in {}
		//If you would like two items to work, use an or function. Here's an example: 
		//miner.getHeldItemMainhand().getItem() != ItemInit.SILVER_INGOT || ItemInit.BRONZE_INGOT
		//You can add as many as you would like with the || which means or in Java.
		if(miner.getHeldItemMainhand().getItem() != Items.STONE_PICKAXE) {
			//Literally saying "if the mined block is Stone, then do the following.
			if(minedblock.equals(Blocks.STONE)) {
				//Cancel the break block event
				event.setCanceled(true);
				//End the code
				return;
			}
		}
	}
}
