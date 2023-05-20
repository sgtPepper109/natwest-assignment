package natwest.assignment.computer.computer_service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class ComputerService {

    Random rand = new Random();
    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(ComputerService.class);
    List<String> moves = Arrays.asList("Rock", "Paper", "Scissors"); // index 0 is Rock, 1, Paper, 2 is scissors

    public int generateRandomNumber() {
        int min = 0;
        int max = 2; // 0 for 'Rock', 1 for 'Paper', 3 for 'Scissors'
        return this.rand.nextInt(max - min + 1) + min;
    }

    public String play() {
        int randomNumber = generateRandomNumber();
        String moveByComputer = this.moves.get(randomNumber);
        log.info("INFO: random move generated: {}", moveByComputer);
        return moveByComputer;
    }

}
