package me.sirgregg.gchantessentials.enchants;

import com.codingforcookies.armorequip.ArmorEquipEvent;
import com.codingforcookies.armorequip.ArmorType;
import me.sirgregg.gchantbase.GchantBase;
import me.sirgregg.gchantbase.enchantsys.BaseEnchant;
import me.sirgregg.gchantbase.enchantsys.EnchantType;
import me.sirgregg.gchantbase.enchantsys.wrapper.EnchantWrapper;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class SpeedEnchant extends BaseEnchant {
	private static List<Material> materials = new ArrayList<>();

	static {
		materials.add(Material.LEATHER_BOOTS);
		materials.add(Material.GOLD_BOOTS);
		materials.add(Material.CHAINMAIL_BOOTS);
		materials.add(Material.IRON_BOOTS);
		materials.add(Material.DIAMOND_BOOTS);
	}

	public SpeedEnchant() {
		super("Speed", 1, 3, materials, EnchantType.ARMOR);
		GchantBase.getEnchantManager().registerEnchant(this);
	}

	@EventHandler
	public void onEquipUnEquip(ArmorEquipEvent e) {
		if (!e.getType().equals(ArmorType.BOOTS)) return;
		Player player = e.getPlayer();

		if (e.getNewArmorPiece() != null && e.getNewArmorPiece().getType() != Material.AIR) { // Equipping
			ItemStack boots = e.getNewArmorPiece();

			List<EnchantWrapper> wrappers = GchantBase.getWrapper().getWrappers(boots);

			if (wrappers == null || wrappers.size() < 1) return;

			int level = -1;

			for (EnchantWrapper wrapper : wrappers) {
				if (wrapper.getEnchant() instanceof SpeedEnchant) {
					level = wrapper.getLevel();
					break;
				}
			}

			if (hasEnchant(boots)) {
				player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, level - 1, true, false));
			}
		} else if (e.getOldArmorPiece() != null && e.getOldArmorPiece().getType() != Material.AIR) { // Unequipping
			ItemStack boots = e.getOldArmorPiece();

			if (hasEnchant(boots)) {
				player.removePotionEffect(PotionEffectType.SPEED);
			}
		}
	}
}
