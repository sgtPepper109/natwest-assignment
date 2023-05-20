package natwest.assignment.computer.computer_controller;

import natwest.assignment.computer.computer_service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/computer")
public class ComputerController {

    @Autowired
    private final ComputerService computerService;
    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(ComputerController.class);

    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @GetMapping("/getMoveByComputer")
    public ResponseEntity<String> play() {
        log.info("GET: /computer/getMoveByComputer");
        String moveByComputer = computerService.play();
        return new ResponseEntity<>(moveByComputer, HttpStatus.OK);
    }

}
