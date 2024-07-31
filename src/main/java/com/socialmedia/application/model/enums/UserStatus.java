package com.socialmedia.application.model.enums;

/**
 * The {@link UserStatus} provides the information when the user is online or offline
 */
public enum UserStatus {
    ONLINE,
    OFFLINE;
    @Override
    public String toString() {
        return switch (this) {
            case ONLINE -> "ONLINE";
            case OFFLINE -> "OFFLINE";
        };
    }
}
