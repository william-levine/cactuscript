package co.cactuscript.model;

import co.cactuscript.exceptions.InvalidCodeStructureException;
import co.cactuscript.exceptions.UnknownCodeBlockType;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeBlock {
    private final String code;
    private final CodeBlockType type;

    private CodeBlock(String code) {
        this.code = code;
        this.type = CodeBlockType.called(code);
    }

    public String getCode() {
        return code;
    }

    public CodeBlockType getType() {
        return type;
    }

    public static List<CodeBlock> parseCode(List<String> code) throws InvalidCodeStructureException, UnknownCodeBlockType {
        List<CodeBlock> codes = new ArrayList<CodeBlock>();
        List<CodeBlockType> validNextTypes = new ArrayList<>(Arrays.asList(CodeBlockType.COMMAND, CodeBlockType.STOP));
        for (String codeString : code) {
            try {
                CodeBlockType type = CodeBlockType.called(codeString);
                if (validNextTypes.contains(type)) {
                    validNextTypes = CodeBlockType.getValidNextTypes(type);
                    codes.add(new CodeBlock(codeString));
                } else {
                    throw new InvalidCodeStructureException("Invalid code block", type, codeString);
                }
            } catch (IllegalArgumentException e){
                throw new UnknownCodeBlockType("Unknown code block type", validNextTypes);
            }
        }
        return codes;
    }

    static boolean checkIfValidAttribute(String attribute) {
        Cactus cactus = new Cactus("Cactus");
        Field[] validFields = cactus.getClass().getFields();
        for (Field field : validFields) {
            if (field.getName().equals(attribute)) {
                return true;
            }
        }
        return false;
    }
}
