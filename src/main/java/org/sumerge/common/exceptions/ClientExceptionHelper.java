package org.sumerge.common.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class ClientExceptionHelper {


    private ClientExceptionHelper() {
    }

    @SuppressWarnings("unchecked")
    public ClientFailureException decodeClientError(String msg,
                                                    Response response, ObjectMapper jacksonObjectMapper) {
        String errorCode = "";
        if (response.body() != null) {
            Map<String, Object> responseMap;
            try {
                responseMap = jacksonObjectMapper.readValue(response.body().asReader(), Map.class);
                log.error(jacksonObjectMapper.writeValueAsString(responseMap));
                msg = responseMap.get("errorMsg") == null ? msg : (String) responseMap.get("errorMsg");
                errorCode = responseMap.get("errorCode").toString();

                return new ClientFailureException(msg, errorCode);
            } catch (Exception e) {
                log.error("Error Deccording Rest Service exception", e);
            }
        }
        return new ClientFailureException(msg, errorCode);
    }

}
