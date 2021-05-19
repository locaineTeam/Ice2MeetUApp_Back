package edu.eci.arsw.Ice2MeetU.entities;

/**
 * The type Command value.
 */
public class CommandValue {
    private String message;

    /**
     * Instantiates a new Command value.
     */
    public CommandValue(){
    }

    /**
     * Instantiates a new Command value.
     *
     * @param message the message
     */
    public CommandValue(String message) {
        this.message = message;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
