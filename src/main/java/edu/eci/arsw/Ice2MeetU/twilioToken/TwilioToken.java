package edu.eci.arsw.Ice2MeetU.twilioToken;


import com.twilio.jwt.accesstoken.AccessToken;
import com.twilio.jwt.accesstoken.ChatGrant;
import com.twilio.jwt.accesstoken.VideoGrant;
import com.twilio.jwt.accesstoken.VoiceGrant;
import edu.eci.arsw.Ice2MeetU.entities.Token;
import edu.eci.arsw.Ice2MeetU.persistence.cache.impl.TokenCacheRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TwilioToken {

    @Autowired
    @Qualifier("TokenCacheRedis")
    TokenCacheRedis tokenCacheRedis;

    public Token getToken(String user, String room){

        Token t = null;
        if(tokenCacheRedis.exists(user)){
            t = tokenCacheRedis.get(user);


        }
        else{
            System.out.println("jojojojo");
            String twilioAccountSid = "AC4ac6afd395a417a6a61179945e8abef0";
            String twilioApiKey = "SKc346bdc0cabf5c15a9cb850024acd47a";
            String twilioApiSecret = "V7gthu7BMNkuxVqQyQrzJLf0r9rO8fnn";

            String serviceSid = "IS8ff7b1767df04f65b607dec19e238920";
            String outgoingApplicationSid = "AP32c3fbfcb26ae1d41099f5372c7020c1";
            String identity = user;

            ChatGrant grant = new ChatGrant();
            grant.setServiceSid(serviceSid);

            // Create Voice grant
            VoiceGrant grantVoice = new VoiceGrant();
            grantVoice.setOutgoingApplicationSid(outgoingApplicationSid);

            // Optional: add to allow incoming calls
            grantVoice.setIncomingAllow(true);


            VideoGrant grantVideo = new VideoGrant().setRoom(room);

            AccessToken token = new AccessToken.Builder(twilioAccountSid, twilioApiKey, twilioApiSecret)
                    .identity(identity).grant(grant).grant(grantVoice).grant(grantVideo).build();

            for (int i = 0; i < 10000000; i++) {
                i += 0;

            }
            //System.out.println(token.toJwt());
            t = new Token(token.toJwt());
            tokenCacheRedis.set(user,t,5*60);

        }






        return t;
    }
}
