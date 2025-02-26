package com.example.Tutorly;

public class Chat {
    private String contactName;
    private String lastMessage;
    private String timestamp;

    public Chat(String contactName, String lastMessage, String timestamp) {
        this.contactName = contactName;
        this.lastMessage = lastMessage;
        this.timestamp = timestamp;
    }

    public String getContactName() {
        return contactName;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
