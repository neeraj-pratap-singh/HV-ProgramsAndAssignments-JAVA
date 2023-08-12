package GradedAssignmentonJavaasanOOPs;

import java.util.*;

class Visitor {
    private String name;
    private int age;
    private String phoneNumber;
    private String appointmentDate;
    private String appointmentTime;

    public Visitor(String name, int age, String phoneNumber, String appointmentDate, String appointmentTime) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(String appointmentDate) { this.appointmentDate = appointmentDate; }
    public String getAppointmentTime() { return appointmentTime; }
    public void setAppointmentTime(String appointmentTime) { this.appointmentTime = appointmentTime; }
}

class Clinic {
    private Map<String, List<String>> appointments; // Map of date to time slots
    private List<Visitor> visitors;

    public Clinic() {
        appointments = new HashMap<>();
        visitors = new ArrayList<>();
    }

    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
        String date = visitor.getAppointmentDate();
        String time = visitor.getAppointmentTime();
        appointments.computeIfAbsent(date, k -> new ArrayList<>()).add(time);
    }

    public void editVisitorDetails(int index, String name, int age, String phoneNumber) {
        Visitor visitor = visitors.get(index);
        visitor.setName(name);
        visitor.setAge(age);
        visitor.setPhoneNumber(phoneNumber);
    }

    public void viewAppointmentSchedule(String date) {
        List<String> times = appointments.get(date);
        if (times != null) {
            System.out.println("Appointments for " + date + ":");
            for (String time : times) {
                System.out.println(time);
            }
        } else {
            System.out.println("No appointments for this date.");
        }
    }

    public void bookAppointment(String date, String time) {
        appointments.computeIfAbsent(date, k -> new ArrayList<>()).add(time);
    }

    public void editAppointment(int visitorIndex, String date, String time) {
        Visitor visitor = visitors.get(visitorIndex);
        appointments.get(visitor.getAppointmentDate()).remove(visitor.getAppointmentTime());
        bookAppointment(date, time);
        visitor.setAppointmentDate(date);
        visitor.setAppointmentTime(time);
    }

    public void cancelAppointment(int visitorIndex) {
        Visitor visitor = visitors.get(visitorIndex);
        appointments.get(visitor.getAppointmentDate()).remove(visitor.getAppointmentTime());
        visitors.remove(visitorIndex);
    }

    public void listVisitors() {
        for (Visitor visitor : visitors) {
            System.out.println("Name: " + visitor.getName() + ", Age: " + visitor.getAge() + ", Phone: " + visitor.getPhoneNumber()
                + ", Date: " + visitor.getAppointmentDate() + ", Time: " + visitor.getAppointmentTime());
        }
    }

    public List<Visitor> getVisitors() { return visitors; }
}

public class ClinicApp {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("Welcome to the Small Clinic Appointment Management System");
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("1. View Visitors List");
            System.out.println("2. Add New Visitor");
            System.out.println("3. Edit Visitor Details");
            System.out.println("4. View Appointment Schedule for a Day");
            System.out.println("5. Book an Appointment");
            System.out.println("6. Edit/Cancel Appointment");
            System.out.println("7. Exit");
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.print("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    clinic.listVisitors();
                    break;
                case 2:
                    System.out.print("Enter Visitor's Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Visitor's Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Visitor's Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Select Appointment Date (DD-MM-YYYY): ");
                    String date = scanner.nextLine();
                    System.out.println("Available Time Slots:");
                    System.out.println("1. 09:00 AM - 10:00 AM");
                    System.out.println("2. 11:00 AM - 12:00 PM");
                    System.out.print("Select Time Slot: ");
                    int timeSlot = scanner.nextInt();
                    scanner.nextLine();
                    String time = timeSlot == 1 ? "09:00 AM - 10:00 AM" : "11:00 AM - 12:00 PM";
                    Visitor visitor = new Visitor(name, age, phoneNumber, date, time);
                    clinic.addVisitor(visitor);
                    System.out.println("Visitor " + name + "'s appointment on " + date + " at " + time + " has been booked.");
                    break;
                case 3:
                    System.out.println("Select the visitor you want to edit:");
                    List<Visitor> visitors = clinic.getVisitors();
                    for (int i = 0; i < visitors.size(); i++) {
                        System.out.println((i + 1) + ". " + visitors.get(i).getName());
                    }
                    System.out.print("Choice: ");
                    int editChoice = scanner.nextInt() - 1;
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    clinic.editVisitorDetails(editChoice, newName, newAge, newPhoneNumber);
                    System.out.println("Details updated.");
                    break;
                case 4:
                    System.out.print("Enter date to view appointments (DD-MM-YYYY): ");
                    String viewDate = scanner.nextLine();
                    clinic.viewAppointmentSchedule(viewDate);
                    break;
                case 5:
                    // Similar to case 2 but without creating a new visitor
                    // Just book the appointment
                    break;
                case 6:
                    // Similar to case 3 but for editing/canceling an appointment
                    break;
                case 7:
                    System.out.println("Thank you for using the Appointment Management System!");
                    return;
            }
        }
    }
}
