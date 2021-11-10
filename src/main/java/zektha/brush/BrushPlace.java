package zektha.brush;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BrushPlace implements Listener {
    @EventHandler
    public void onDrop(PlayerDropItemEvent event){
        Player player = event.getPlayer();
        Item drop = event.getItemDrop();
        ItemStack itemdrop = drop.getItemStack();
        ItemStack itemstack = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = itemstack.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE+"BRUSH");
        ItemStack item = drop.getItemStack();
        if(itemdrop.getItemMeta().getDisplayName().equals(meta.getDisplayName())) {
            event.setCancelled(true);
        }
    }
}
