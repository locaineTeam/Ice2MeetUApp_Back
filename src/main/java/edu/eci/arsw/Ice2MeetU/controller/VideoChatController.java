package edu.eci.arsw.Ice2MeetU.controller;

import edu.eci.arsw.Ice2MeetU.twilioToken.TwilioToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Video chat controller.
 */
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class VideoChatController {
    @Autowired
   private TwilioToken twilioTokenService;

    /**
     * Gets token.
     *
     * @param identity the identity
     * @param room     the room
     * @return the token
     */
// <editor-fold defaultstate="collapsed" desc="Attributes">
    @RequestMapping(value="/getTwilioToken",method= RequestMethod.GET)


    public ResponseEntity<?> getToken(@RequestParam String identity, @RequestParam String room) {

        return new ResponseEntity<>(twilioTokenService.getToken(identity, room), HttpStatus.ACCEPTED);

    }
    // </editor-fold>


}
