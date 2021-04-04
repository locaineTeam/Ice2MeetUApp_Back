package edu.eci.arsw.Ice2MeetU.twilioToken;

import com.twilio.jwt.accesstoken.AccessToken;
import com.twilio.jwt.accesstoken.ChatGrant;
import org.springframework.stereotype.Service;

@Service
public class TwilioToken {
    public AccessToken getToken(String user){
        String twilioAccountSid = "AC4ac6afd395a417a6a61179945e8abef0";
        String twilioApiKey = "SKc346bdc0cabf5c15a9cb850024acd47a";
        String twilioApiSecret = "V7gthu7BMNkuxVqQyQrzJLf0r9rO8fnn";

        String serviceSid = "IS8ff7b1767df04f65b607dec19e238920";
        String identity = user;

        ChatGrant grant = new ChatGrant();
        grant.setServiceSid(serviceSid);

        AccessToken token = new AccessToken.Builder(twilioAccountSid, twilioApiKey, twilioApiSecret)
                .identity(identity).grant(grant).build();

//        System.out.println(token.toJwt());

        return token;
    }
}
