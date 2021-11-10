package zektha.brush;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class BrushItem implements Listener {

    private final Plugin plugin = Brush.getPlugin(Brush.class);
    @EventHandler
    public void blockBreak(BlockDamageEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        List<String> lore = new ArrayList<>();
        ItemMeta meta = item.getItemMeta();
        String delim = " ";
        Block block = event.getBlock();
        assert meta != null;
        if(meta.getLore() != null){
            String res = String.join(delim, meta.getLore());
            if (item.getType() == Material.BLAZE_ROD && (player.hasPermission("brush.getbrush"))) {
                if (res.equals(player.getName())) {

                    Location loc = block.getLocation();


                    if (!regionexist(player , block)) {
                        int x = loc.getBlockX();
                        int y = loc.getBlockY();
                        int z = loc.getBlockZ();
                        World world = event.getBlock().getWorld();


                        if (world.getBlockAt(x , y , z).getType() != Material.BEDROCK) {
                            event.setInstaBreak(true);
                        }
                        if (world.getBlockAt(x-1 , y , z).getType() != Material.BEDROCK && ((player.hasPermission("brush.brush3") || (player.hasPermission("brush.brush4")))))  {
                            Block b = world.getBlockAt(x-1, y, z);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }
                        if (world.getBlockAt(x-1 , y , z-1).getType() != Material.BEDROCK && ((player.hasPermission("brush.brush3") || (player.hasPermission("brush.brush4"))))) {
                            Block b = world.getBlockAt(x-1, y, z-1);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }
                        if (world.getBlockAt(x-1 , y , z+1).getType() != Material.BEDROCK && ((player.hasPermission("brush.brush3") || (player.hasPermission("brush.brush4"))))) {
                            Block b = world.getBlockAt(x-1, y, z+1);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }
                        if (world.getBlockAt(x , y , z+1).getType() != Material.BEDROCK) {
                            Block b = world.getBlockAt(x, y, z+1);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }
                        if (world.getBlockAt(x , y , z-1).getType() != Material.BEDROCK ) {
                            Block b = world.getBlockAt(x, y, z-1);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }
                        if (world.getBlockAt(x+1 , y , z).getType() != Material.BEDROCK && ((player.hasPermission("brush.brush3") || (player.hasPermission("brush.brush4"))))) {
                            Block b = world.getBlockAt(x+1, y, z);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }
                        if (world.getBlockAt(x+1 , y , z+1).getType() != Material.BEDROCK && ((player.hasPermission("brush.brush3") || (player.hasPermission("brush.brush4"))))) {
                            Block b = world.getBlockAt(x+1, y, z+1);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }
                        if (world.getBlockAt(x+1 , y , -1).getType() != Material.BEDROCK && ((player.hasPermission("brush.brush3") || (player.hasPermission("brush.brush4"))))) {
                            Block b = world.getBlockAt(x+1, y, z-1);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }
                        if (world.getBlockAt(x , y , -2).getType() != Material.BEDROCK && (player.hasPermission("brush.brush4"))) {
                            Block b = world.getBlockAt(x, y, z-2);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }
                        if (world.getBlockAt(x+1 , y , -2).getType() != Material.BEDROCK && (player.hasPermission("brush.brush4"))) {
                            Block b = world.getBlockAt(x+1, y, z-2);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }
                        if (world.getBlockAt(x+2 , y , -2).getType() != Material.BEDROCK && (player.hasPermission("brush.brush4"))) {
                            Block b = world.getBlockAt(x+2, y, z-2);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }
                        if (world.getBlockAt(x-1 , y , -2).getType() != Material.BEDROCK && (player.hasPermission("brush.brush4"))) {
                            Block b = world.getBlockAt(x-1, y, z-2);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }
                        if (world.getBlockAt(x-2 , y , -2).getType() != Material.BEDROCK && (player.hasPermission("brush.brush4"))) {
                            Block b = world.getBlockAt(x-2, y, z-2);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }

                        if (world.getBlockAt(x , y , +2).getType() != Material.BEDROCK && (player.hasPermission("brush.brush4"))) {
                            Block b = world.getBlockAt(x, y, z+2);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }
                        if (world.getBlockAt(x+1 , y , +2).getType() != Material.BEDROCK && (player.hasPermission("brush.brush4"))) {
                            Block b = world.getBlockAt(x+1, y, z+2);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }
                        if (world.getBlockAt(x+2 , y , +2).getType() != Material.BEDROCK && (player.hasPermission("brush.brush4"))) {
                            Block b = world.getBlockAt(x+2, y, z+2);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }
                        if (world.getBlockAt(x-1 , y , +2).getType() != Material.BEDROCK && (player.hasPermission("brush.brush4"))) {
                            Block b = world.getBlockAt(x-1, y, z+2);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }
                        if (world.getBlockAt(x-2 , y , +2).getType() != Material.BEDROCK && (player.hasPermission("brush.brush4"))) {
                            Block b = world.getBlockAt(x-2, y, z+2);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }

                        if (world.getBlockAt(x-2 , y , +1).getType() != Material.BEDROCK && (player.hasPermission("brush.brush4"))) {
                            Block b = world.getBlockAt(x-2, y, z+1);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }
                        if (world.getBlockAt(x-2 , y ,z).getType() != Material.BEDROCK && (player.hasPermission("brush.brush4"))) {
                            Block b = world.getBlockAt(x-2, y, z);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }
                        if (world.getBlockAt(x-2 , y , -1).getType() != Material.BEDROCK && (player.hasPermission("brush.brush4"))) {
                            Block b = world.getBlockAt(x-2, y, z-1);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }

                        if (world.getBlockAt(x+2 , y , +1).getType() != Material.BEDROCK && (player.hasPermission("brush.brush4"))) {
                            Block b = world.getBlockAt(x+2, y, z+1);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }
                        if (world.getBlockAt(x+2 , y ,z).getType() != Material.BEDROCK && (player.hasPermission("brush.brush4"))) {
                            Block b = world.getBlockAt(x+2, y, z);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }
                        if (world.getBlockAt(x+2 , y , -1).getType() != Material.BEDROCK && (player.hasPermission("brush.brush4"))) {
                            Block b = world.getBlockAt(x+2, y, z-1);
                            if(!regionexist(player , b)){
                                b.breakNaturally();
                            }
                        }

                    }
                }
            }
        }
    }


    public boolean regionexist(Player player, Block block){
        int i = 0;
        List<String> list = plugin.getConfig().getStringList("Regions");
        if (list.isEmpty()) {
            List<String> liste = Arrays.asList("spawn","spawn2");
            plugin.getConfig().set("Regions", liste);
            plugin.saveConfig();
        }
        else{
            String world = player.getWorld().getName();
            RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
            RegionManager manager = container.get(BukkitAdapter.adapt(Objects.requireNonNull(Bukkit.getWorld(world))));
            assert manager != null;
            ApplicableRegionSet set = manager.getApplicableRegions(BukkitAdapter.asBlockVector(block.getLocation()));
            for(ProtectedRegion region : set) {
                if(plugin.getConfig().getStringList("Regions").contains(region.getId())) {
                    i = 1;
                }
            }
        }
        return i == 1;
    }
}
