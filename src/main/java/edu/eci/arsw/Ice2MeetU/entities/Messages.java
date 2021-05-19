package edu.eci.arsw.Ice2MeetU.entities;

import java.util.HashMap;
import java.util.List;

public class Messages {
    private HashMap<String,String> allMessages = new HashMap<>();

    public String getMessageByLanguage(String language){
        return allMessages.containsKey(language)?allMessages.get(language):"";
    }

}
