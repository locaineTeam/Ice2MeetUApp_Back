package edu.eci.arsw.Ice2MeetU.entities;

import java.util.HashMap;

/**
 * The type Commands.
 */
public class Commands {
    private HashMap<String, String> messages;

    /**
     * Instantiates a new Commands.
     */
    public Commands() {
        messages = new HashMap<>();
    }

    /**
     * Gets message by command.
     *
     * @param command the command
     * @return the message by command
     */
    public String getMessageByCommand(String command) {
        return messages.containsKey(command) ? messages.get(command) : "";
    }

    /**
     * Add command.
     *
     * @param command the command
     * @param message the message
     */
    public void addCommand(String command, String message) {
        messages.put(command, message);
    }

    @Override
    public String toString() {
        return "Commands{" + "messages=" + messages + '}';
    }
}
