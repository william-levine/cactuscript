package co.cactuscript.controller;

import co.cactuscript.exceptions.InvalidCodeStructureException;
import co.cactuscript.exceptions.UnknownTokenType;
import co.cactuscript.model.Cactus;
import co.cactuscript.model.Token;
import co.cactuscript.model.Tokeniser;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CodeController {
    @PostMapping("/code")
    public ResponseEntity<Map<String, Object>> executeCommand(@RequestBody List<String> codeStrings,  HttpSession session) {
        try {
            // use this cactus to update the cactus object, then return it serialised
            Cactus cactus = Cactus.fromSerialised((Map<String, Integer>) session.getAttribute("cactus"));
            try {
                List<Token<?>> tokens = Tokeniser.tokenise(codeStrings);
                Map<String, Object> returnTypes = new HashMap<>();
                returnTypes.put("response", "success"); // this is where the return values should go
                session.setAttribute("cactus", cactus.serialise());
                return ResponseEntity.ok(returnTypes);
            } catch (InvalidCodeStructureException | UnknownTokenType e) {
                return ResponseEntity.status(400).body(Map.of("error", e.getMessage()));
            }
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(400).body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/cactus")
    public ResponseEntity<Map<String, ?>> getCactusDefault(HttpSession session) {
        Cactus cactus = Cactus.fromSerialised(new HashMap<>());
        try {
            Map<String, Object> attributes = cactus.serialise();
            session.setAttribute("cactus", attributes);
            return ResponseEntity.ok(attributes);
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body(Map.of("error", e.getMessage()));
        }
    }
}
