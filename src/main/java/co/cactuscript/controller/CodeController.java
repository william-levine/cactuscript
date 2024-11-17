package co.cactuscript.controller;

import co.cactuscript.exceptions.InvalidCodeStructureException;
import co.cactuscript.exceptions.UnknownCodeBlockType;
import co.cactuscript.model.CodeBlock;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CodeController {
    @PostMapping("/code")
    public ResponseEntity<String> runCode(@RequestBody List<String> codeStrings) {
        try {
            List<CodeBlock> codeBlocks = CodeBlock.parseCode(codeStrings);
        } catch (InvalidCodeStructureException | UnknownCodeBlockType e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.ok("Code ran successfully");
    }
}
