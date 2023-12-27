import java.util.Scanner;

public class Menu {
    public void LibraryApplication(Library library){
        Scanner scanner = new Scanner(System.in);
        int answer,answerUser,answerUser1,answerAdmin,answerlibrary;
        do {
            System.out.println("Are you a:");
            System.out.println("1/User");
            System.out.println("2/Admin");
            System.out.println("3/Supplier");
            System.out.println("4/Library info");
            System.out.println("5/Exit");
            answer = scanner.nextInt();
            scanner.nextLine();
            switch (answer) {
                case 1: {
                    do {
                        System.out.println("Would you like to:");
                        System.out.println("1/Create a new User account");
                        System.out.println("2/Log in");
                        answerUser = scanner.nextInt();
                        scanner.nextLine();
                    } while ((answerUser != 1) && (answerUser != 2));
                    User user;
                    switch (answerUser) {
                        case 1: {
                            user = library.addUser();
                            break;
                        }
                        case 2: {
                            System.out.println("Enter your User ID: ");
                            int idUser = scanner.nextInt();
                            user = library.findUser(idUser);
                            break;
                        }
                        default:
                            user = null;
                            break;
                    }
                    if (user != null) {
                        System.out.println("Welcome " + user.firstName + " " + user.LastName + "!");
                        do {
                            System.out.println("Do you want to:");
                            System.out.println("1/Borrow a book");
                            System.out.println("2/Return a book");
                            System.out.println("3/Donate a book");
                            System.out.println("4/Study");
                            System.out.println("5/Upgrade membership");
                            System.out.println("6/Downgrade membership");
                            System.out.println("7/Display User info");
                            System.out.println("8/Log out");
                            answerUser1 = scanner.nextInt();
                            scanner.nextLine();
                            switch (answerUser1) {
                                case 1:
                                    user.borrowBook(library);
                                    break;
                                case 2:
                                    user.returnBook(library);
                                    break;
                                case 3:
                                    user.donateBook(library);
                                    break;
                                case 4:
                                    user.study();
                                    break;
                                case 5:
                                    user.upgradeTier();
                                    break;
                                case 6:
                                    user.downgradeTier();
                                    break;
                                case 7:
                                    System.out.println(user);
                                    break;
                                default:
                                    break;
                            }
                        } while (answerUser1 != 8);
                    }
                    break;
                }
                case 2: {
                    do {
                        System.out.println("Would you like to:");
                        System.out.println("1/Create a new Admin account");
                        System.out.println("2/Log in");
                        answerAdmin = scanner.nextInt();
                        scanner.nextLine();
                    } while ((answerAdmin != 1) && (answerAdmin != 2));
                    Admin admin;
                    switch (answerAdmin) {
                        case 1: {
                            admin = library.addAdmin();
                            break;
                        }
                        case 2: {
                            System.out.println("Enter your User ID: ");
                            int idAdmin = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter password");
                            String password = scanner.nextLine();
                            admin = library.findAdmin(idAdmin, password);
                            break;
                        }
                        default:
                            admin = null;
                            break;
                    }
                    if (admin != null) {
                        System.out.println("Welcome " + admin.firstName + " " + admin.LastName + "!");
                        do {
                            System.out.println("Do you want to:");
                            System.out.println("1/Add User");
                            System.out.println("2/Ban a User");
                            System.out.println("3/Display info");
                            System.out.println("4/Log out");
                            answerUser = scanner.nextInt();
                            scanner.nextLine();
                            switch (answerUser) {
                                case 1:
                                    admin.addUser(library);
                                    break;
                                case 2:
                                    admin.removeUser(library);
                                    break;
                                case 3:
                                    System.out.println(admin.toString());
                                    break;
                                default:
                                    break;
                            }
                        } while (answerUser != 4);
                    }
                    break;
                }
                case 3: {
                    System.out.println("What is the name of your supplying company?");
                    String name = scanner.nextLine();
                    Supplier supplier = new Supplier(name);
                    supplier.addBooks(library);
                    break;
                }
                case 4: {
                    do {
                        System.out.println("Do you want to:");
                        System.out.println("1/Display all current Users");
                        System.out.println("2/Display all current Admins");
                        System.out.println("3/Display all Books");
                        System.out.println("4/Display the Booking history");
                        System.out.println("5/Exit");
                        answerlibrary = scanner.nextInt();
                        scanner.nextLine();
                        switch (answerlibrary) {
                            case 1:
                                library.displayUsers();
                                break;
                            case 2:
                                library.displayAdmins();
                                break;
                            case 3:
                                library.displayBooks();
                                break;
                            case 4:
                                library.displayBookings();
                                break;
                            default:
                                break;
                        }
                    } while (answerlibrary != 5);
                    break;
                }
                default:
                    break;
            }
        } while (answer != 5);
        scanner.close();
    }
}
