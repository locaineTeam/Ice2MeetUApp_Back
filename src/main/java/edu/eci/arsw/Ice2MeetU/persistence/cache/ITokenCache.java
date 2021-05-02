package edu.eci.arsw.Ice2MeetU.persistence.cache;

import edu.eci.arsw.Ice2MeetU.entities.Token;
import org.springframework.stereotype.Service;

@Service
public interface ITokenCache {

    boolean exists(String name);

    Token get(String name);

    void set(String name, Token payload, long TTL);

}
