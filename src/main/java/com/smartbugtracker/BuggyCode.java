package com.smartbugtracker;

public class BuggyCode {

    public void obviousBugs() {
        if (true) { // PMD: Avoid if statements with literal booleans
        }

        int unused = 10; // PMD: Unused local variable

        System.out.println("Still running");
    }
}
