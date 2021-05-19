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
        command.addCommand("ayuda","#AYUDA - muestra todos los comandos </br> #HOLA - Muestra un hola! </br> #COMTAS - Saluda con un como estás </br> #CHAU - Despide");
        command.addCommand("hola","HOLA!");
        command.addCommand("comtas","¿Cómo estás?");
        command.addCommand("chau","Adios! Hasta la vista!");
        commands.put("spanish",command);
        // </editor-fold">
        // <editor-fold defaultstate="collapsed" desc="English Commands">
        command = new Commands();
        command.addCommand("help","#HELP - shows all commands  </br>  #HELLO - shows a hello </br> #HOWRU - shows a How are you </br> #BYE - shows a bye");
        command.addCommand("hello","Hello!");
        command.addCommand("howru","Hey! How are you?");
        command.addCommand("bye","bye!");
        commands.put("english",command);
        // </editor-fold">
        // <editor-fold defaultstate="collapsed" desc="German Commands">
        command = new Commands();
        command.addCommand("hilfe","#HILFE - zeigt alle Befehle </br> #HALLO - zeigt hallo! </br> #WGEHT - zeigt wie geht es dir </br> #TSCH - zeigt wie geht es dir");
        command.addCommand("hallo","Hallo!");
        command.addCommand("wgeht","wie gehts?");
        command.addCommand("tsch","Tschüss");
        commands.put("german",command);
        // </editor-fold">
    }

    @Override
    public String getMessageByCommandAndLanguage(String command, String language) throws CommandMessagesException {
        command = command.toLowerCase();
        language = language.toLowerCase();
        if(!commands.containsKey(language)) throw new CommandMessagesException(CommandMessagesException.LANGUAGE_NO_FOUND,language);
        String message = commands.get(language).getMessageByCommand(command);
        if(message.equals("")) throw new CommandMessagesException(CommandMessagesException.COMMAND_NO_FOUND,command);
        return message;
    }
}
