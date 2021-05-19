package edu.eci.arsw.Ice2MeetU.services.impl;

import edu.eci.arsw.Ice2MeetU.entities.CommandValue;
import edu.eci.arsw.Ice2MeetU.entities.Commands;
import edu.eci.arsw.Ice2MeetU.persistence.exceptions.CommandMessagesException;
import edu.eci.arsw.Ice2MeetU.services.CommandMessageService;
import org.springframework.stereotype.Component;

import java.util.HashMap;

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
        command.addCommand("ayuda","#AYUDA - muestra todos los comandos \n #HOLA - Muestra un hola! \n #COMTAS - Saluda con un como estás \n #CHAU - Despide");
        command.addCommand("hola","HOLA!");
        command.addCommand("comtas","¿Cómo estás?");
        command.addCommand("chau","Adios! Hasta la vista!");
        commands.put("spanish",command);
        // </editor-fold">
        // <editor-fold defaultstate="collapsed" desc="English Commands">
        command = new Commands();
        command.addCommand("help","#HELP - shows all commands  \\n  #HELLO - shows a hello \\n #HOWRU - shows a How are you \\n #BYE - shows a bye");
        command.addCommand("hello","Hello!");
        command.addCommand("howru","Hey! How are you?");
        command.addCommand("bye","bye!");
        commands.put("english",command);
        // </editor-fold">
        // <editor-fold defaultstate="collapsed" desc="German Commands">
        command = new Commands();
        command.addCommand("hilfe","#HILFE - zeigt alle Befehle \n #HALLO - zeigt hallo! \n #WGEHT - zeigt wie geht es dir \n #TSCH - zeigt wie geht es dir");
        command.addCommand("hallo","Hallo!");
        command.addCommand("wgeht","wie gehts?");
        command.addCommand("tsch","Tschüss");
        commands.put("german",command);
        // </editor-fold">
    }

    @Override
    public CommandValue getMessageByCommandAndLanguage(String command, String language) throws CommandMessagesException {
        command = command.toLowerCase();
        language = language.toLowerCase();
        if(!commands.containsKey(language)) throw new CommandMessagesException(CommandMessagesException.LANGUAGE_NO_FOUND,language);
        String message = commands.get(language).getMessageByCommand(command);
        if(message.equals("")) throw new CommandMessagesException(CommandMessagesException.COMMAND_NO_FOUND,command);
        return new CommandValue(message);
    }
}
