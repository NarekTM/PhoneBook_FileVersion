package main;

import static main.Loader.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK +
                "*****************************************" + ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK +
                "*** Welcome to PhoneBook application! ***" + ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK +
                "******* Created by Narek & Lilith *******" + ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK +
                "*****************************************" + ANSI_RESET);

//        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK +
//                "*****************************************\n" +
//                "*** Welcome to PhoneBook application! ***\n" +
//                "******* Created by Narek & Lilith *******\n" +
//                "*****************************************" + ANSI_RESET);

        start();
    }
}
