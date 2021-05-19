package edu.eci.arsw.Ice2MeetU.controller;

import edu.eci.arsw.Ice2MeetU.services.IceBreakerService;
import edu.eci.arsw.Ice2MeetU.services.impl.IceBreakerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Ice breaker controller.
 */
@RestController
@RequestMapping("/")
@CrossOrigin(origins="*")

public class IceBreakerController {
    /**
     * The Ice breaker service.
     */
    @Autowired
    public IceBreakerServiceImpl iceBreakerService;

    /**
     * Get ice breaker response entity.
     *
     * @param language the language
     * @return the response entity
     */
    @RequestMapping(value="/getIceBreaker", method= RequestMethod.GET)
    public ResponseEntity<?> getIceBreaker(@RequestParam String language){
        return new ResponseEntity<>(iceBreakerService.getRandomIceBreaker(language), HttpStatus.ACCEPTED);
    }

}
