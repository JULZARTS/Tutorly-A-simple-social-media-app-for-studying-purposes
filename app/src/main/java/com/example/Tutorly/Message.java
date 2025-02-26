package com.example.Tutorly;

public class Message {
    private String sender;
    private String recipient;
    private String text;
    private String timestamp;

    public Message() {} // Empty constructor for Firebase

    public Message(String sender, String recipient, String text, String timestamp) {
        this.sender = sender;
        this.recipient = recipient;
        this.text = text;
        this.timestamp = timestamp;
    }

    public String getSender() { return sender; }
    public String getRecipient() { return recipient; }
    public String getText() { return text; }
    public String getTimestamp() { return timestamp; }
}
