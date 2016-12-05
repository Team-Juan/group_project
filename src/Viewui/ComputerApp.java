/**
 * Computer Database System
 * @author https://github.com/Team-Juan
 */

package Viewui;

import Util.Validator;
import java.util.Scanner;

import Model.Computer;
import Model.IComputerDAO;
import Model.datastore.mysql.ComputerDAO;

/**
 * This application can retrieve, update, delete, and modify database information about computer systems.
 * @author Team-Juan
 * @version 1.0
 */

public class ComputerApp {
	
	IComputerDAO compList = new ComputerDAO();
    Scanner sc = new Scanner(System.in);

    public ComputerApp() {
        menuLoop();
    }

    private void menuLoop() {
        int id;
        String brand, model, features, location, field, search;
        String choice = "1";
        while (!choice.equals("0")) {
            System.out.println("\nComputer App");
            System.out.println("0 = Quit");
            System.out.println("1 = List All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Record");
            System.out.println("4 = Update Record");
            System.out.println("5 = Delete Record");
            System.out.println("6 = Search Record");
            System.out.println("7 = Location Search");
            choice = Validator.getLine(sc, "Number of choice: ", "^[0-7]$");

            switch (choice) {
                case "1":
                    System.out.println(compList.toString());
                    break;
                case "2":
                    id = Validator.getInt(sc, "New computer ID: ");
                    brand = Validator.getLine(sc, "Brand: ");
                    model = Validator.getLine(sc, "Model: ");
                    features = Validator.getLine(sc, "Features: ");
                    location = Validator.getLine(sc, "Location: ");
                    compList.createData(new Computer(id, brand, model, features, location));
                    break;
                case "3":
                    id = Validator.getInt(sc, "Computer id to retrieve: ");
                    System.out.println(compList.retrieveDataById(id));
                    break;
                case "4":
                    id = Validator.getInt(sc, "Computer ID to update: ");
                    brand = Validator.getLine(sc, "Brand: ");
                    model = Validator.getLine(sc, "Model: ");
                    features = Validator.getLine(sc, "Features: ");
                    location = Validator.getLine(sc, "Location: ");
                    compList.updateData(new Computer(id, brand, model, features, location));
                    break;
                case "5":
                    id = Validator.getInt(sc, "Computer ID to delete: ");
                    System.out.println(compList.retrieveDataById(id));
                    String ok = Validator.getLine(sc, "Delete this record? (y/n) ", "^[yYnN]$");
                    if (ok.equalsIgnoreCase("Y")) {
                        compList.deleteData(id);
                    }
                    break;
                case "6":
                	field = Validator.getLine(sc,  "Field to search for: ");
                	search = Validator.getLine(sc,  "String to search for: ");
                	System.out.println(compList.searchData(field, search));
                	break;
                case "7":
                	search = Validator.getLine(sc,  "Location to search for: ");
                	System.out.println(compList.searchData("location", search));
                	break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ComputerApp();
    }
}
