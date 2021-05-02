package edu.eci.arsw.Ice2MeetU.entities;

import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.io.Serializable;

public class Token extends JdkSerializationRedisSerializer implements Serializable {

    private static final long serialVersionUID = 7156526077883281623L;

    private String token;
    public Token() {
    }

    public Token(String token){
        this.token=token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
