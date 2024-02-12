import java.util.ArrayList;
import java.util.List;

public class WeaponOrganizer {
    private List<Weapon> weapons;

    public WeaponOrganizer() {
        this.weapons = new ArrayList<>();
    }
    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }
    public List<Weapon> getWeapons() {
        return weapons;
    }
  
    public void inputWeapon() {
        Weapon weapon = Weapon.createWeaponFromUserInput();
        weapons.add(weapon);
        System.out.println("Weapon from Assassin's Creed Valhalla added successfully!");
    }

    public void displayWeapons() {
        System.out.println("\nOrganized Weapons from Assassin's Creed Valhalla:");

        for (Weapon weapon : weapons) {
            System.out.println("Name: " + weapon.getName() +
                    ", Type: " + weapon.getType() +
                    ", Rarity: " + weapon.getRarity());
        }
    }
}
