package com.group.pdc_assignment_rpg;

import com.group.pdc_assignment_rpg.cli.GameTerminal;
import com.group.pdc_assignment_rpg.cli.InventoryView;
import com.group.pdc_assignment_rpg.exceptions.InvalidMapException;
import com.group.pdc_assignment_rpg.model.Inventory;
import com.group.pdc_assignment_rpg.utilities.MapLoaderUtility;
import java.util.List;

/**
 * Entry point to the RPG game.
 *
 * @author Vinson Beduya - 19089783 <vinsonemb.151994@gmail.com>
 */
public class MainDriver {

    public static void main(String[] args) {
        try {
            init();
        } catch (InvalidMapException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void init() throws InvalidMapException {
        // Dummy map.
        List<String> map = MapLoaderUtility.loadMap("sample");

        // Dummy inventory data.
        Inventory inventory = new Inventory();
        inventory.addMultiple("Sword,,Axe,,Armor,,Red Potion,,Mythical Andromeda's Spear");
        InventoryView inventoryView = new InventoryView(inventory);
        
        GameTerminal.start(map, inventoryView);
    }
}
