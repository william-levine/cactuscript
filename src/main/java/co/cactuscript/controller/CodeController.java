package co.cactuscript.controller;

import co.cactuscript.exceptions.InvalidCodeStructureException;
import co.cactuscript.exceptions.UnknownTokenType;
import co.cactuscript.model.Cactus;
import co.cactuscript.model.Token;
import co.cactuscript.model.Tokeniser;
import co.cactuscript.model.enums.Attribute;
import co.cactuscript.model.enums.Command;
import co.cactuscript.model.enums.TokenType;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class CodeController {
    @PostMapping("/code")
    public ResponseEntity<Map<String, Object>> executeCommand(@RequestBody List<String> tokenStrings,  HttpSession session) {
        try {
            // use this cactus to update the cactus object, then return it serialised
            Cactus cactus = Cactus.fromSerialised((Map<String, Integer>) session.getAttribute("cactus"));
            try {
                List<Token<?>> tokens = Tokeniser.tokenise(tokenStrings);
                Map<String, Object> returnTypes = new HashMap<>();


                for (int i = 0; i < tokens.size(); i++) {
                    if (tokens.get(i).getType().equals(TokenType.COMMAND)) {
                        if (tokens.get(i).getValue().equals(Command.GET)) {
                            Optional<?> attributeOptional =
                                    Command.get(cactus, (Attribute)tokens.get(i + 1).getValue());

                            if (attributeOptional.isPresent()) {
                                System.out.println(attributeOptional.get().toString());
                                returnTypes.put("response", attributeOptional.get()); // this is where the return values should go
                            }
                            else {
                                System.out.println("Not present");
                            }
                        }
                        else if (tokens.get(i).getValue().equals(Command.SET)) {
                            boolean success = Command.set(cactus, (Attribute)tokens.get(i + 1).getValue(), (Integer)20);

                            if (success) {
                                System.out.println("success setting value");
                            }
                            else {
                                System.out.println("failure setting value");
                            }
                        }
                    }
                }

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
