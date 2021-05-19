package edu.eci.arsw.Ice2MeetU.persistence.exceptions;

/**
 * The type Command messages exception.
 */
public class CommandMessagesException  extends Exception{

    /**
     * The constant COMMAND_NO_FOUND.
     */
    public static final String COMMAND_NO_FOUND = "No existe el comando seleccionado: ";
    /**
     * The constant LANGUAGE_NO_FOUND.
     */
    public static final String LANGUAGE_NO_FOUND = "No hay mensaje con este lenguaje: ";

    /**
     * Instantiates a new Command messages exception.
     *
     * @param message the message
     */
    public CommandMessagesException(String message){
        super(message);
    }

    /**
     * Instantiates a new Command messages exception.
     *
     * @param message    the message
     * @param attributes the attributes
     */
    public CommandMessagesException(String message, String attributes){
        super(message+attributes);
    }
}
