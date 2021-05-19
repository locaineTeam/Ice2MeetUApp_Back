package edu.eci.arsw.Ice2MeetU.services.impl;

import edu.eci.arsw.Ice2MeetU.entities.Commands;
import edu.eci.arsw.Ice2MeetU.persistence.exceptions.CommandMessagesException;
import edu.eci.arsw.Ice2MeetU.services.CommandMessageService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Locale;

/**
 * The type Command message service.
 */
@Component
public class CommandMessageServiceImpl implements CommandMessageService {

    private HashMap<String, Commands> commands = new HashMap<>();

    /**
     * Instantiates a new Command message service.
     */
    public CommandMessageServiceImpl(){
        // <editor-fold defaultstate="collapsed" desc="Spanish Commands">
        Commands command = new Commands();
        command.addCommand("ayuda","#AYUDA - shows all commands  </br> #HOLA - shows a hello!");
        command.addCommand("hola","HOLA!");
        commands.put("spanish",command);
        // </editor-fold">
        // <editor-fold defaultstate="collapsed" desc="English Commands">
        command = new Commands();
        command.addCommand("help","#HELP - shows all commands  </br>  #HELLO - shows a hello");
        command.addCommand("hello","HELLO!");
        commands.put("english",command);
        // </editor-fold">
        // <editor-fold defaultstate="collapsed" desc="German Commands">
        command = new Commands();
        command.addCommand("Hilfe","#HILFE - shows all commands </br> #HALLO - shows a hello!");
        command.addCommand("hallo","HALLO!");
        commands.put("german",command);
        // </editor-fold">
    }

    @Override
    public String getMessageByCommandAndLanguage(String command, String language) throws CommandMessagesException {
        command = command.toLowerCase();
        language = language.toLowerCase();
        System.out.println("ALL VALUE: "+ commands.toString());
        if(!commands.containsKey(language)) throw new CommandMessagesException(CommandMessagesException.LANGUAGE_NO_FOUND,language);
        String message = commands.get(language).getMessageByCommand(command);
        if(message.equals("")) throw new CommandMessagesException(CommandMessagesException.COMMAND_NO_FOUND,command);
        return message;
    }
}
