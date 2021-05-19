package edu.eci.arsw.Ice2MeetU.services;


import edu.eci.arsw.Ice2MeetU.entities.IceBreaker;

/**
 * The interface Ice breaker service.
 */
public interface IceBreakerService {
    /**
     * Gets random ice breaker.
     *
     * @param language the language
     * @return the random ice breaker
     */
    IceBreaker getRandomIceBreaker(String language);

}
