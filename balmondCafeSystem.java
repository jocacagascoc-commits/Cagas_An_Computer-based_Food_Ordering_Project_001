import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class balmondCafeSystem {

    static DateTimeFormatter date = DateTimeFormatter.ofPattern("MMMM dd, yyyy | hh:mm");
    static Scanner sc = new Scanner(System.in);
    static int orderNumber = 1;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nWELCOME TO BALMOND'S CAFE");
            System.out.println("************************************");
            System.out.println("1. ORDER");
            System.out.println("2. EXIT");
            System.out.print("\nENTER CHOICE: ");

            String choice = sc.nextLine();

            if (choice.equals("1")) {
                processOrder();
            } else if (choice.equals("2")) {
                break;
            } else {
                System.out.println("\nINVALID!\n");
            }
        }
    }

    public static void processOrder() {

        ArrayList<String> items = new ArrayList<>();
        ArrayList<Integer> qtys = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();

        double total = 0;

        while (true) {
            System.out.println("\nCAFE MENU");
            System.out.println("************************************");
            System.out.println("1. GREEN COFFEE - 55.55");
            System.out.println("2. BROWN COFFEE - 30.48");
            System.out.println("3. BLACK COFFEE - 25.50");
            System.out.println("4. BACK");
            System.out.print("\nENTER CHOICE: ");

            String choice = sc.nextLine();

            if (choice.equals("4")) {
                return;
            }

            if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3")) {
                System.out.println("\nINVALID!\n");
                continue;
            }

            String name = "";
            double price = 0;

            if (choice.equals("1")) {
                name = "GREEN COFFEE";
                price = 55.55;
            } else if (choice.equals("2")) {
                name = "BROWN COFFEE";
                price = 30.48;
            } else if (choice.equals("3")) {
                name = "BLACK COFFEE";
                price = 25.50;
            }

            System.out.print("\nENTER QUANTITY: ");
            String qtyInput = sc.nextLine();

            if (!qtyInput.matches("\\d+")) {
            System.out.println("\nINVALID!\n");
            continue;
            }

            int qty = Integer.parseInt(qtyInput);

            double subtotal = price * qty;
            total += subtotal;

            items.add(name);
            qtys.add(qty);
            prices.add(price);

            while (true) {
                System.out.println("\nORDER LIST");
                System.out.println("************************************");

                for (int i = 0; i < items.size(); i++) {
                    System.out.println(items.get(i) + " X" + qtys.get(i));
                }

                System.out.printf("TOTAL: %.2f\n", total);

                System.out.println("\n1. CONFIRM");
                System.out.println("2. ADD");
                System.out.print("\nENTER CHOICE: ");

                String confirm = sc.nextLine();

                if (confirm.equals("2")) {
                    break;
                } else if (!confirm.equals("1")) {
                    System.out.println("\nINVALID!\n");
                } else {

                    System.out.print("\nENTER NAME: ");
                    String customerName = sc.nextLine();

                    while (true) {
                        System.out.print("\nENTER MONEY: ");
                        String moneyInput = sc.nextLine();

                        if (!moneyInput.matches("\\d+(\\.\\d+)?")) {
                            System.out.println("\nINVALID!\n");
                            continue;
                        }

                        double money = Double.parseDouble(moneyInput);

                        if (money < total) {
                            System.out.println("\nNOT ENOUGH MONEY!\n");
                        } else {

                            double change = money - total;
                            
                            System.out.println("\nCUSTOMER COPY");
                            System.out.println("************************************");
                            System.out.println("DATE: " + date.format(LocalDateTime.now()));
                            System.out.println("ORDER NO: " + orderNumber);
                            System.out.println("NAME: " + customerName);

                            for (int i = 0; i < items.size(); i++) {
                                System.out.println(items.get(i) + " X" + qtys.get(i));
                            }

                            System.out.printf("TOTAL: %.2f\n", total);
                            System.out.printf("MONEY: %.2f\n", money);
                            System.out.printf("CHANGE: %.2f\n", change);

                            System.out.println("\nCREW COPY");
                            System.out.println("************************************");
                            System.out.println("DATE: " + date.format(LocalDateTime.now()));
                            System.out.println("ORDER NO: " + orderNumber);
                            System.out.println("NAME: " + customerName);

                            for (int i = 0; i < items.size(); i++) {
                                System.out.println(items.get(i) + " X" + qtys.get(i));
                            }

                            System.out.printf("TOTAL: %.2f\n", total);
                            System.out.printf("MONEY: %.2f\n", money);
                            System.out.printf("CHANGE: %.2f\n", change);

                            orderNumber++;
                            if (orderNumber > 99) {
                                orderNumber = 1;
                            }

                            System.out.print("\nPRESS ENTER TO PROCEED");
                            sc.nextLine();
                            return;
                        }
                    }
                }
            }
        }
    }
}
