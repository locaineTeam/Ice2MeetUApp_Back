package edu.eci.arsw.Ice2MeetU.services;


import edu.eci.arsw.Ice2MeetU.entities.IceBreaker;

public interface IceBreakerService {
    IceBreaker getRandomIceBreaker(String language);

}
