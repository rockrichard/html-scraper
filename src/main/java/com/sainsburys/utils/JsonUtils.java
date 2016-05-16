package com.sainsburys.utils;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Json Utilities
 *
 * Created by Richard Ho on 5/15/2016.
 */
public class JsonUtils {
    /**
     * Convert an object to Json String.
     * @param object
     * @return
     * @throws java.io.IOException
     */
    public String toJsonString(Object object, boolean usePrettyPrinter) throws IOException {
        JsonFactory factory = new JsonFactory();
        ObjectMapper mapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();

        JsonGenerator generator = factory.createJsonGenerator(stringWriter);

        if(usePrettyPrinter) {
            generator.useDefaultPrettyPrinter();
        }

        mapper.writeValue(generator, object);
        generator.close();
        return stringWriter.toString();
    }
}
