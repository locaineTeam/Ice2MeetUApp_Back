package edu.eci.arsw.Ice2MeetU.services.impl;

import edu.eci.arsw.Ice2MeetU.entities.CommandValue;
import edu.eci.arsw.Ice2MeetU.entities.Commands;
import edu.eci.arsw.Ice2MeetU.persistence.exceptions.CommandMessagesException;
import edu.eci.arsw.Ice2MeetU.services.CommandMessageService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * The type Command message service.
 */
@Component
public class CommandMessageServiceImpl implements CommandMessageService {

    private HashMap<String, Commands> commands = new HashMap<>();
    private HashMap<String, String[]> pairs = new HashMap<>();

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

        addToPairs();
    }

    private void addToPairs() {
        // <editor-fold defaultstate="collapsed" desc="Hello Group">
        String[] aux={ "hola", "hallo"};
        pairs.put("hello",aux);
        aux= new String[]{ "hello", "hallo"};
        pairs.put("hola",aux);
        aux= new String[]{ "hola", "hello"};
        pairs.put("hallo",aux);
        // </editor-fold">
        // <editor-fold defaultstate="collapsed" desc="Help Group">
        aux= new String[]{ "help", "ayuda"};
        pairs.put("hilfe",aux);
        aux= new String[]{ "ayuda", "hilfe"};
        pairs.put("help",aux);
        aux= new String[]{ "help", "hilfe"};
        pairs.put("ayuda",aux);
        // </editor-fold">
        // <editor-fold defaultstate="collapsed" desc="HRU Group">
        aux= new String[]{ "comtas", "howru"};
        pairs.put("wgeht",aux);
        aux= new String[]{ "wgeht", "howru"};
        pairs.put("comtas",aux);
        aux= new String[]{ "comtas", "wgeht"};
        pairs.put("howru",aux);
        // </editor-fold">
        // <editor-fold defaultstate="collapsed" desc="Bye Group">
        aux= new String[]{ "chau", "bye"};
        pairs.put("tsch",aux);
        aux= new String[]{ "tsch", "bye"};
        pairs.put("chau",aux);
        aux= new String[]{ "tsch", "chau"};
        pairs.put("bye",aux);
        // </editor-fold">

    }

    private String[] getPairs(String key) throws CommandMessagesException {
        if(!pairs.containsKey(key)) throw new CommandMessagesException(CommandMessagesException.LANGUAGE_NO_FOUND,key);
        return pairs.get(key);

    }

    @Override
    public CommandValue getMessageByCommandAndLanguage(String command, String language) throws CommandMessagesException {
        command = command.toLowerCase();
        language = language.toLowerCase();
        if(!commands.containsKey(language)) throw new CommandMessagesException(CommandMessagesException.LANGUAGE_NO_FOUND,language);
        String[] pairs = getPairs(command);
        String message = commands.get(language).getMessageByCommand(command);
        for (String s: pairs){
            if(!commands.get(language).getMessageByCommand(s).equals("") && message.equals("")) {
                message = commands.get(language).getMessageByCommand(s);
            }
        }
        if(message.equals("")) throw new CommandMessagesException(CommandMessagesException.COMMAND_NO_FOUND,command);
        return new CommandValue(message);
    }


}
