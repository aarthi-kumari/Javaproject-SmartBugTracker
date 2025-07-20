package com.smartbugtracker.model;

public class Bug {
    private String file;
    private String rule;
    private String priority;
    private String message;
    private int line; // ✅ make sure this exists

    // Getters and Setters
    public String getFile() { return file; }
    public void setFile(String file) { this.file = file; }

    public String getRule() { return rule; }
    public void setRule(String rule) { this.rule = rule; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public int getLine() { return line; } // ✅ make sure this getter is present
    public void setLine(int line) { this.line = line; }
}
