import java.util.Scanner;

public class Weapon {
    private String name;
    private String type;
    private String rarity;

    private static final String[] VALID_WEAPON_TYPES = {"Sword", "Axe", "Dagger", "Greatsword", "Spear"};
    private static final String[] VALID_RARITIES = {"Common", "Fine", "Superior", "Flawless", "Mythical"};

    public Weapon(String name, String type, String rarity) {
        this.name = name;
        this.type = type;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getRarity() {
        return rarity;
    }

    public static Weapon createWeaponFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        System.out.print("Enter the name of the Assassin's Creed Valhalla weapon: ");
        String name = scanner.nextLine();

        String type = getUserInput("Enter the type of weapon (Sword, Axe, Dagger, Greatsword, Spear): ", VALID_WEAPON_TYPES);
        String rarity = getUserInput("Enter the rarity of the weapon (Common, Fine, Superior, Flawless, Mythical): ", VALID_RARITIES);

        return new Weapon(name, type, rarity);
    }

    private static String getUserInput(String prompt, String[] validOptions) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        String userInput;

        do {
            System.out.print(prompt);
            userInput = scanner.nextLine().trim();

            // Check if the entered value is in the list of valid options
            if (!isValidOption(userInput, validOptions)) {
                System.out.println("Invalid input. Please enter a valid option.");
            }
        } while (!isValidOption(userInput, validOptions));

        return userInput;
    }

    private static boolean isValidOption(String input, String[] validOptions) {
        for (String validOption : validOptions) {
            if (validOption.equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }
}
