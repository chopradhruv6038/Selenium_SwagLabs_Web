package Org.SwagLabs.Utils;

import Org.SwagLabs.Objects.yourInformationCheckout;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {


    public static yourInformationCheckout desiralizeJson(InputStream yourInformationData, yourInformationCheckout yourInformationCheckout) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

       return objectMapper.readValue(yourInformationData, yourInformationCheckout.getClass());

    }





}
