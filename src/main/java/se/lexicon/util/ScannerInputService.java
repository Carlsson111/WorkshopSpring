package se.lexicon.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class ScannerInputService implements UserInputService{


    //@Autowired //field injection
    private Scanner scanner;
    @Autowired
    public ScannerInputService(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getString() {
        System.out.println("Enter a String");
        return scanner.nextLine();
    }

    @Override
    public int getInt() {
        return 0;
    }
}
