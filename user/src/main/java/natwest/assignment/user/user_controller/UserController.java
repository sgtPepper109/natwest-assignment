package natwest.assignment.user.user_controller;

import natwest.assignment.user.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;
    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(UserController.class);

    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping("/play")
    public ResponseEntity<String> play(@RequestParam String moveByUser) { // "Rock" or "Paper" or "Scissors"
        log.info("GET: /user/play");
        String winOrLoseOrTie = userService.play(moveByUser);
        return new ResponseEntity<>(winOrLoseOrTie, HttpStatus.OK);
    }

}
