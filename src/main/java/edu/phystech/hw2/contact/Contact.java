package edu.phystech.hw2.contact;


record Contact(String username, String email) implements Comparable<Contact> {
    public static final String UNKNOWN_EMAIL = "unknown";

    Contact {
        if (username.isBlank()) {
            throw new InvalidContactFieldException("username");
        }
        if (email.matches("[A-Za-z0-9].*?@gmail\\.com") || email.equals("unknown")) {
        } else {
            throw new InvalidContactFieldException("email");
        }
    }

    Contact(String username) {
        this(username, UNKNOWN_EMAIL);
    }


    public int compareTo(Contact o) {
        if (this.username.length() < o.username.length()) {
            return -1;
        }
        if (this.username.length() > o.username.length()) {
            return 1;
        }
        return 0;
    }
}