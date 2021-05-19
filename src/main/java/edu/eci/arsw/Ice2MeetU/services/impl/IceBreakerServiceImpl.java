package edu.eci.arsw.Ice2MeetU.services.impl;

import edu.eci.arsw.Ice2MeetU.entities.IceBreaker;
import edu.eci.arsw.Ice2MeetU.services.IceBreakerService;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * The type Ice breaker service.
 */
@Repository
public class IceBreakerServiceImpl implements IceBreakerService {

    /**
     * The constant SPANISH_ICE_BREAKER.
     */
    public static final ArrayList<String> SPANISH_ICE_BREAKER = new ArrayList<String>(
            Arrays.asList("¿Cuantos colores tiene el arcoiris?",
                    "¿Qué fue primero, el huevo o la gallina?",
                    "Crees en los fantasmas?"));
    /**
     * The constant ENGLISH_ICE_BREAKER.
     */
    public static final ArrayList<String> ENGLISH_ICE_BREAKER = new ArrayList<String>(
            Arrays.asList("How many colors does the rainbow have?",
                    "What was the first; the egg or the chicken?",
                    "Do you believe in ghosts?"));
    /**
     * The constant GERMAN_ICE_BREAKER.
     */
    public static final ArrayList<String> GERMAN_ICE_BREAKER = new ArrayList<String>(
            Arrays.asList("Wie viele Farben hat der Regenbogen?",
                    "Was war das erste, das Ei oder das Huhn?",
                    "Glaubst du an Geister?"));

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
