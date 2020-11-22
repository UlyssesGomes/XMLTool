import model.Car;
import model.User;
import utils.XMLFileTool;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String ... args) throws JAXBException, IOException {
        Scanner scan = new Scanner(System.in);
        XMLFileTool xmlTool = new XMLFileTool();

        showOptions();

        int option;
        do {
            option = scan.nextInt();
            if(option == 1) {
                User u = (User) xmlTool.loadObjectFromXmlFile(new File("user.xml"), User.class);
                System.out.println("User " + u.getLastName() + " loaded.");
            } else if(option == 2) {
                User u = createUser();
                xmlTool.saveObject(u, new File("user.xml"), User.class);
                System.out.println("User " + u.getLastName() + " saved.");
            } else if(option == 3) {
                Car c = (Car) xmlTool.loadObjectFromXmlFile(new File("car.xml"), Car.class);
                System.out.println("Car loaded");
                System.out.println("Car: " + c.getTradeMark() + "\nModel: " + c.getModel() + "\nOwner: " + c.getOwner());
            } else if(option == 4) {
                Car c = createCar();
                xmlTool.saveObject(c, new File("car.xml"), Car.class);
                System.out.println("Car " + c.getTradeMark() + " saved.");
            }
        } while(option != 5);
    }

    private static void showOptions() {
        System.out.println("1 - read user from xml file");
        System.out.println("2 - write user into a xml file");
        System.out.println("3 - read car from xml file");
        System.out.println("4 - write car into a xml file");
        System.out.println("5 - exit");
    }

    private static User createUser() {
        User u = new User();
        u.setFirstName("Neji ");
        u.setLastName("Hyuga");
        u.setAge(31);
        u.setSex("Male");

        return u;
    }

    private static Car createCar() {
        User u = createUser();
        Car car =  new Car();
        car.setModel("Model 3");
        car.setTradeMark("Tesla");
        car.setOwner(u);

        return car;
    }
}
