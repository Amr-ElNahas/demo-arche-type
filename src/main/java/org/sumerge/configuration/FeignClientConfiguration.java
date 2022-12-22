package org.sumerge.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Logger;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.sumerge.common.exceptions.ClientExceptionHelper;
import org.sumerge.common.exceptions.ClientFailureException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration {

    org.slf4j.Logger log = LoggerFactory.getLogger(FeignClientConfiguration.class);


    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }


    @Autowired
    private ObjectMapper jacksonObjectMapper;

    @Autowired
    ClientExceptionHelper clientExceptionHelper;

    @Bean
    public ErrorDecoder coreErrorDecoder() {
        return new CustomErrorDecoder();
    }

    public class CustomErrorDecoder implements ErrorDecoder {

        @Override
        public ClientFailureException decode(String methodKey, Response response) {

            String msg = "connector failed";
            return clientExceptionHelper.decodeClientError(msg, response, jacksonObjectMapper);

        }
    }
}

