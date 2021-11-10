package zektha.brush;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Commands implements Listener, CommandExecutor {
    public String cmd1 = "givebrush";
    public String cmd2 = "getbrush";
    public String cmd3 = "delbrush";
    private boolean have;
    @Override
    public boolean onCommand(CommandSender sender,Command cmd,String label, String[] args) {
        if(sender instanceof Player){
            if(cmd.getName().equalsIgnoreCase(cmd1) && sender.hasPermission("brush.givebrush")){
                String name = args[0];
                Player player = Bukkit.getPlayer(name);
                ItemStack itemstack = new ItemStack(Material.BLAZE_ROD);
                ItemMeta meta = itemstack.getItemMeta();
                assert meta != null;
                meta.setDisplayName(ChatColor.DARK_PURPLE+"BRUSH");
                List<String> lore = new ArrayList<>();
                assert player != null;
                lore.add(player.getName());
                meta.setLore(lore);
                String delim = " ";
                itemstack.setItemMeta(meta);
                player.getInventory().addItem(itemstack);
                return true;
            }
            if(cmd.getName().equalsIgnoreCase(cmd2) && sender.hasPermission("brush.getbrush")){
                Player player = ((Player) sender).getPlayer();
                ItemStack itemstack = new ItemStack(Material.BLAZE_ROD);
                ItemMeta meta = itemstack.getItemMeta();
                meta.setDisplayName(ChatColor.DARK_PURPLE+"BRUSH");
                for(int i = 0; i < player.getInventory().getSize(); i++){
                    ItemStack itm = player.getInventory().getItem(i);
                    if(itm != null && itm.getItemMeta().getDisplayName().equals(meta.getDisplayName())){
                        have = true;
                        break;
                    }
                    else{
                        have = false;
                    }

                }
                if(have){
                    sender.sendMessage("You already have brush");
                }
                else{

                    List<String> lore = new ArrayList<>();
                    lore.add(player.getName());
                    meta.setLore(lore);
                    String delim = " ";
                    itemstack.setItemMeta(meta);
                    itemstack.setAmount(1);
                    player.getInventory().addItem(itemstack);
                    sender.sendMessage(ChatColor.GOLD + "You received brush");
                }
                return true;
            }
            if(cmd.getName().equalsIgnoreCase(cmd3) && sender.hasPermission("brush.delbrush")){
                ItemStack itemstack = new ItemStack(Material.BLAZE_ROD);
                ItemMeta meta = itemstack.getItemMeta();
                meta.setDisplayName(ChatColor.DARK_PURPLE+"BRUSH");
                String name = args[0];
                Player player = Bukkit.getPlayer(name);
                Player sendere = ((Player) sender).getPlayer();
                if(!args[0].isEmpty()){
                    for(int i = 0; i < player.getInventory().getSize(); i++){
                        ItemStack itm = player.getInventory().getItem(i);
                        if(itm != null && itm.getItemMeta().getDisplayName().equals(meta.getDisplayName())){
                            int amt = itm.getAmount() - 999999;
                            itm.setAmount(amt);
                            player.getInventory().setItem(i, amt > 0 ? itm : null);
                        }
                    }
                }else{
                    for(int i = 0; i < sendere.getInventory().getSize(); i++){
                        ItemStack itm = sendere.getInventory().getItem(i);
                        if(itm != null && itm.getItemMeta().getDisplayName().equals(meta.getDisplayName())){
                            int amt = itm.getAmount() - 999999;
                            itm.setAmount(amt);
                            sendere.getInventory().setItem(i, amt > 0 ? itm : null);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}
