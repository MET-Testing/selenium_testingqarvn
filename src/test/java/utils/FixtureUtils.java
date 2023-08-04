package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class FixtureUtils {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static final TypeReference<Map<String, Map<String, String>>> typeRef = new TypeReference<>() {};

    private static String readFile(String path) {
        try {
            return Files.readString(Path.of(path));
        }  catch (IOException e) {
            Assertions.fail(String.format("No se pudo leer el archivo %s", path));
            return null;
        }
    }

    public static Map<String, Map<String, String>> map(String path) {
        try {
            return MAPPER.readValue(readFile(path), typeRef);
        }  catch (JsonProcessingException e) {
            Assertions.fail(String.format("No se pudo mapear el contenido del archivo %s", path));
            return null;
        }
    }
}
