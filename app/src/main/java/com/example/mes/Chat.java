package com.example.mes;

public class Chat {
    private final String senderName;
    private final String lastMessage;
    private final String messageTime;

    public Chat(String senderName, String lastMessage, String messageTime) {
        this.senderName = senderName;
        this.lastMessage = lastMessage;
        this.messageTime = messageTime;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public String getMessageTime() {
        return messageTime;
    }
}
