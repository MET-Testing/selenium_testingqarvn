package org.met.testing.challenges.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;

import java.io.FileReader;
import java.io.IOException;

public class FixtureUtils {

    private static final Logger logger = LogManager.getLogger();

    private static final JSONParser jsonparser = new JSONParser();

    private static FileReader readFile(String path) {
        try {
            return new FileReader(path);
        }  catch (IOException e) {
            logger.error("ERROR readFile", e);
            Assertions.fail(String.format("No se pudo leer el archivo %s", path));
            return null;
        }
    }

    public static JSONObject map(String path) {
        try {
            return (JSONObject)jsonparser.parse(readFile(path));
        } catch (IOException | ParseException e) {
            logger.error("ERROR map", e);
            Assertions.fail(String.format("No se pudo mapear el contenido del archivo %s", path));
            return null;
        }
    }

    public static String getString(JSONObject map, String key) {
        return (String) map.get(key);
    }

    public static JSONObject getJSONObject(JSONObject map, String key) {
        return (JSONObject) map.get(key);
    }
}
