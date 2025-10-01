package com.smartbugtracker;

public class BuggyCode {

    public void obviousBugs() {
        if (true) { // PMD: Avoid if statements with literal booleans
        }

        int unused = 10; // PMD: Unused local variable

        try {
            int x = 1 / 0; // PMD: Avoid dividing by zero
        } catch (Exception e) {
            // PMD: Empty catch block
        }

        String s = null;
        if (s.equals("test")) { // PMD: NullPointerException possible
            System.out.println("Null string");
        }

        System.exit(1); // PMD: Avoid using System.exit

        System.out.println("Still running");
    }
}
