package edu.eci.arsw.Ice2MeetU.persistence.exceptions;

public class CommandMessagesException  extends Exception{

    public static final String COMMAND_NO_FOUND = "No existe el comando seleccionado";
    public static final String LANGUAGE_NO_FOUND = "No hay mensaje con este lenguaje: ";

    public CommandMessagesException(String message){
        super(message);
    }
    public CommandMessagesException(String message, String attributes){
        super(message+attributes);
    }
}
