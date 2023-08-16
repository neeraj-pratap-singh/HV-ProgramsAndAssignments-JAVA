package GradedAssignmentonJavaasanOOPs;

import java.util.*;

class TimeSlots {
    public static final List<String> slots;

    static {
        slots = new ArrayList<>();
        for (int i = 9; i < 17; i++) {
            slots.add(String.format("%02d:00 - %02d:00", i, i + 1));
        }
    }
}

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
    private static List<Visitor> visitors;

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

    public static void listVisitors() {
        System.out.println("\nVisitors List:");
        System.out.println("------------------------------------------------");
        for (Visitor visitor : visitors) {
            System.out.println("Name: " + visitor.getName() + " | Age: " + visitor.getAge() + " | Phone: " + visitor.getPhoneNumber()
                + " | Date: " + visitor.getAppointmentDate() + " | Time: " + visitor.getAppointmentTime());
        }
        System.out.println("------------------------------------------------");
    }

    public List<Visitor> getVisitors() { return visitors; }

    public boolean isTimeSlotAvailable(String date, String time) {
        List<String> times = appointments.get(date);
        return times == null || !times.contains(time);
    }
}

public class ClinicApp {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==============================================");
            System.out.println(" Welcome to the Small Clinic Appointment Management System");
            System.out.println("==============================================");
            System.out.println("1. View Visitors List");
            System.out.println("2. Add New Visitor");
            System.out.println("3. Edit Visitor Details");
            System.out.println("4. View Appointment Schedule for a Day");
            System.out.println("5. Book an Appointment");
            System.out.println("6. Edit/Cancel Appointment");
            System.out.println("7. Exit");
            System.out.print("Please enter your choice: ");
            int choice = validateInput(scanner, 1, 7);

            switch (choice) {
                case 1:
                    clinic.listVisitors();
                    break;
                case 2:
                    addNewVisitor(scanner, clinic);
                    break;
                case 3:
                    editVisitorDetails(scanner, clinic);
                    break;
                case 4:
                    viewAppointmentSchedule(scanner, clinic);
                    break;
                case 5:
                    bookAppointment(scanner, clinic);
                    break;
                case 6:
                    editOrCancelAppointment(scanner, clinic);
                    break;
                case 7:
                    System.out.println("Thank you for using the Appointment Management System!");
                    scanner.close();
                    return;
            }
        }
    }

    private static int validateInput(Scanner scanner, int min, int max) {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    break;
                } else {
                    System.out.print("Invalid input. Please enter a number between " + min + " and " + max + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number between " + min + " and " + max + ": ");
            }
        }
        return input;
    }

    private static String validateDate(Scanner scanner) {
        String date;
        while (true) {
            date = scanner.nextLine();
            if (date.matches("\\d{2}-\\d{2}-\\d{4}")) {
                break;
            } else {
                System.out.print("Invalid date format. Enter date in DD-MM-YYYY format: ");
            }
        }
        return date;
    }

    private static String validateName(Scanner scanner) {
        String name;
        while (true) {
            name = scanner.nextLine().trim();
            if (name.matches("[a-zA-Z\\s]+") && !name.isEmpty()) {
                break;
            } else {
                System.out.print("Invalid name. Please enter alphabetic characters only: ");
            }
        }
        return name;
    }

    private static String validatePhoneNumber(Scanner scanner) {
        String phoneNumber;
        while (true) {
            phoneNumber = scanner.nextLine();
            if (phoneNumber.matches("\\d{10}")) {
                break;
            } else {
                System.out.print("Invalid phone number. Please enter a 10-digit number: ");
            }
        }
        return phoneNumber;
    }

    private static int validateAge(Scanner scanner) {
        int age;
        while (true) {
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 0 && age <= 150) {
                    break;
                } else {
                    System.out.print("Invalid age. Please enter a number between 0 and 150: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid age. Please enter a number between 0 and 150: ");
            }
        }
        return age;
    }

    private static void addNewVisitor(Scanner scanner, Clinic clinic) {
        System.out.print("Enter Visitor Name: ");
        String name = validateName(scanner);
        System.out.print("Enter Visitor Age: ");
        int age = validateAge(scanner);
        System.out.print("Enter Visitor Phone Number: ");
        String phoneNumber = validatePhoneNumber(scanner);
        System.out.print("Select Appointment Date (DD-MM-YYYY): ");
        String date = validateDate(scanner);

        // Check available time slots
        List<String> availableSlots = new ArrayList<>();
        for (int i = 0; i < TimeSlots.slots.size(); i++) {
            String slot = TimeSlots.slots.get(i);
            if (clinic.isTimeSlotAvailable(date, slot)) {
                availableSlots.add(slot);
                System.out.println((availableSlots.size()) + ". " + slot);
            }
        }

        if (availableSlots.isEmpty()) {
            System.out.println("No available time slots for this date.");
            return;
        }

        System.out.print("Select Time Slot: ");
        int timeSlot = validateInput(scanner, 1, availableSlots.size()) - 1;
        String time = availableSlots.get(timeSlot);
        Visitor visitor = new Visitor(name, age, phoneNumber, date, time);
        clinic.addVisitor(visitor);
        System.out.println("Visitor " + name + "'s appointment on " + date + " at " + time + " has been booked.");
    }

    private static void editVisitorDetails(Scanner scanner, Clinic clinic) {
        System.out.print("Enter Visitor Index to Edit: ");
        int visitorIndex = validateInput(scanner, 1, clinic.getVisitors().size()) - 1;
        System.out.print("Enter New Name: ");
        String name = validateName(scanner);
        System.out.print("Enter New Age: ");
        int age = validateAge(scanner);
        System.out.print("Enter New Phone Number: ");
        String phoneNumber = validatePhoneNumber(scanner);
        clinic.editVisitorDetails(visitorIndex, name, age, phoneNumber);
        System.out.println("Visitor details updated successfully.");
    }

    private static void viewAppointmentSchedule(Scanner scanner, Clinic clinic) {
        System.out.print("Enter date to view appointments (DD-MM-YYYY): ");
        String viewDate = validateDate(scanner);
        clinic.viewAppointmentSchedule(viewDate);
    }

    private static void bookAppointment(Scanner scanner, Clinic clinic) {
        System.out.print("Select Appointment Date (DD-MM-YYYY): ");
        String date = validateDate(scanner);

        // Check available time slots
        List<String> availableSlots = new ArrayList<>();
        for (int i = 0; i < TimeSlots.slots.size(); i++) {
            String slot = TimeSlots.slots.get(i);
            if (clinic.isTimeSlotAvailable(date, slot)) {
                availableSlots.add(slot);
                System.out.println((availableSlots.size()) + ". " + slot);
            }
        }

        if (availableSlots.isEmpty()) {
            System.out.println("No available time slots for this date.");
            return;
        }

        System.out.print("Select Time Slot: ");
        int timeSlot = validateInput(scanner, 1, availableSlots.size()) - 1;
        String time = availableSlots.get(timeSlot);
        clinic.bookAppointment(date, time);
        System.out.println("Appointment on " + date + " at " + time + " has been booked.");
    }

    private static void editOrCancelAppointment(Scanner scanner, Clinic clinic) {
        System.out.print("Enter Visitor Index to Edit or Cancel Appointment: ");
        int visitorIndex = validateInput(scanner, 1, clinic.getVisitors().size()) - 1;
        System.out.print("Do you want to Edit (E) or Cancel (C) the appointment? ");
        String choice = scanner.next().toUpperCase().trim();

        while (!(choice.equals("E") || choice.equals("C"))) {
            System.out.print("Invalid choice. Enter E for Edit or C for Cancel: ");
            choice = scanner.next().toUpperCase().trim();
        }

        scanner.nextLine();

        if (choice.equals("E")) {
            System.out.print("Select New Appointment Date (DD-MM-YYYY): ");
            String date = validateDate(scanner);
            System.out.print("Select New Time Slot: ");
            int timeSlot = validateInput(scanner, 1, TimeSlots.slots.size()) - 1;
            String time = TimeSlots.slots.get(timeSlot);
            clinic.editAppointment(visitorIndex, date, time);
            System.out.println("Appointment updated successfully.");
        } else if (choice.equals("C")) {
            clinic.cancelAppointment(visitorIndex);
            System.out.println("Appointment canceled successfully.");
        }
    }
}
