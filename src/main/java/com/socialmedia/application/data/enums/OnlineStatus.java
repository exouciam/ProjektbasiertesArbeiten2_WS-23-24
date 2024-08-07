package com.socialmedia.application.data.enums;

/**
 * The {@link OnlineStatus} provides the information when the user is online or offline
 */
public enum OnlineStatus {
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
