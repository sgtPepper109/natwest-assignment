package natwest.assignment.user.user_service;

import natwest.assignment.user.user_controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;
    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(UserService.class);

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getStatus(String moveByComputer, String moveByUser) {
        if (moveByComputer.equals("Rock")) {
            if (moveByUser.equals("Paper"))
                return "Win";
            else if (moveByUser.equals("Scissors"))
                return "Lose";
            else
                return "Tie";
        } else if (moveByComputer.equals("Paper")) {
            if (moveByUser.equals("Scissors"))
                return "Win";
            else if (moveByUser.equals("Rock"))
                return "Lose";
            else
                return "Tie";
        } else { // scissors
            if (moveByUser.equals("Paper"))
                return "Win";
            else if (moveByUser.equals("Rock"))
                return "Lose";
            else
                return "Tie";
        }
    }

    public String play(String moveByUser) {
        String moveByComputer = this.restTemplate.getForObject("http://computer-service/computer/getMoveByComputer", String.class);
        log.info("INFO: moveByUser: {}", moveByUser);
        log.info("INFO: moveByComputer: {}", moveByComputer);

        if (moveByComputer != null) {
            return getStatus(moveByComputer, moveByUser) + " (Move By Computer: " + moveByComputer + ")"; // win or lose or tie
        } else {
            return "Error";
        }
    }

}
