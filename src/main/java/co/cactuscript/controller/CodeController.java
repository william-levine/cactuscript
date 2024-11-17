package co.cactuscript.controller;

import co.cactuscript.exceptions.InvalidCodeStructureException;
import co.cactuscript.exceptions.UnknownTokenType;
import co.cactuscript.model.Token;
import co.cactuscript.model.Tokeniser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CodeController {
    @PostMapping("/code")
    public ResponseEntity<String> executeCommand(@RequestBody List<String> codeStrings) {
        try {
            List<Token<?>> tokens = Tokeniser.tokenise(codeStrings);



        } catch (InvalidCodeStructureException | UnknownTokenType e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.ok("Code ran successfully");
    }
}
