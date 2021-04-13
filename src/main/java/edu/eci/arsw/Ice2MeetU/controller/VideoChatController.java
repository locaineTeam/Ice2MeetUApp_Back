package edu.eci.arsw.Ice2MeetU.controller;

import edu.eci.arsw.Ice2MeetU.twilioToken.TwilioToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class VideoChatController {
    @Autowired
   private TwilioToken twilioTokenService;

    @RequestMapping(value="/getTwilioToken",method= RequestMethod.GET)

//    public ResponseEntity<?> getToken(@PathVariable String user) {
//        return new ResponseEntity<>(twilioTokenService.getToken(user), HttpStatus.ACCEPTED);
//    }
    public ResponseEntity<?> getToken(@RequestParam String identity, @RequestParam String room) {

        return new ResponseEntity<>(twilioTokenService.getToken(identity, room), HttpStatus.ACCEPTED);

    }


}
