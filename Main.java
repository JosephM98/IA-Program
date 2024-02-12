import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    final WeaponOrganizer organizer = new WeaponOrganizer();
    GUI gui = new GUI(organizer);
    Scanner scanner = new Scanner(System.in);

    System.out.println("Assassin's Creed Valhalla Weapon Organizer Program");

    char choice;
    do {
      gui.displayWeaponsInConsole(); //calls the method from GUI.java

        System.out.print("Do you want to input another weapon? (y/n): ");
        choice = scanner.next().charAt(0);

        scanner.nextLine(); // Consume the newline character
    } while (choice == 'y' || choice == 'Y');

    gui.displayWeaponsInConsole(); // Call the displayWeaponsInConsole method from the GUI class

    organizer.displayWeapons();
    System.out.println("Program Ended.");

    scanner.close();
  }
}
