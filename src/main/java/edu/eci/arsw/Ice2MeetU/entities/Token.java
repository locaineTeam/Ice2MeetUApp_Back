package edu.eci.arsw.Ice2MeetU.entities;

import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.io.Serializable;

/**
 * The type Token.
 */
public class Token extends JdkSerializationRedisSerializer implements Serializable {

    private static final long serialVersionUID = 7156526077883281623L;

    private String token;

    /**
     * Instantiates a new Token.
     */
    public Token() {
    }

    /**
     * Instantiates a new Token.
     *
     * @param token the token
     */
    public Token(String token){
        this.token=token;
    }

    /**
     * Gets token.
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets token.
     *
     * @param token the token
     */
    public void setToken(String token) {
        this.token = token;
    }
}
