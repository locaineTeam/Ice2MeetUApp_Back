package edu.eci.arsw.Ice2MeetU.services.impl;

import edu.eci.arsw.Ice2MeetU.entities.IceBreaker;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@Repository
public class IceBreakerServiceImpl {

    public static final ArrayList<String> SPANISH_ICE_BREAKER = new ArrayList<String>(
            Arrays.asList("ESPAÑOL",
                    "ESPAÑOL",
                    "ESPAÑOL LATINOOOOOOO"));
    public static final ArrayList<String> ENGLISH_ICE_BREAKER = new ArrayList<String>(
            Arrays.asList("Geeks",
                    "for",
                    "Reeks"));
    public static final ArrayList<String> GERMAN_ICE_BREAKER = new ArrayList<String>(
            Arrays.asList("Geeks",
                    "for",
                    "Geeks"));

    public IceBreaker getRandomIceBreaker(String language){
        ArrayList <String> chosenLanguage;
        chosenLanguage=retrieveIceBreakerLanguageContext(language);
        Random random = new Random();
        int iceBreakerIndex = (int)random.nextInt(chosenLanguage.size());
        return new IceBreaker(chosenLanguage.get(iceBreakerIndex));
    }

    private ArrayList<String> retrieveIceBreakerLanguageContext(String language){

        ArrayList <String> chosenLanguage = null;

        switch (language){
            case ("spanish"):
                chosenLanguage=SPANISH_ICE_BREAKER;
                break;
            case "english":
                chosenLanguage=ENGLISH_ICE_BREAKER;
                break;
            case "german":
                chosenLanguage=GERMAN_ICE_BREAKER;
                break;
        }

        return chosenLanguage;
    }

}
