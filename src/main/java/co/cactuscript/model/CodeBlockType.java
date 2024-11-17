//package co.cactuscript.model;
//
//import co.cactuscript.model.CodeBlock;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public enum CodeBlockType {
//    COMMAND,
//    VARIABLE,
//    STOP;
//
//    public static CodeBlockType determineType (String token) {
//        if (token.equals("get") || token.equals("put")) {
//            return COMMAND;
//        } else if (token.equals("stop")) {
//            return STOP;
//        } else if (CodeBlock.checkIfValidAttribute(token)) {
//            return VARIABLE;
//        } else {
//            throw new IllegalArgumentException("Unknown code block type: " + token);
//        }
//    }
//
//    public static ArrayList<CodeBlockType> getValidNextTypes(CodeBlockType type) {
//        return switch (type) {
//            case COMMAND -> new ArrayList<>(List.of(VARIABLE));
//            case VARIABLE -> new ArrayList<>(List.of(STOP));
//            case STOP -> new ArrayList<>(List.of(COMMAND));
//        };
//    }
//}
