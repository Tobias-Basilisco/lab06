package it.unibo.exceptions;

import java.io.IOException;

public class NetworkException extends IOException {
    final private static String DEFAULT_MSG = "Network error: no response";
    final private static String MSG_PASSED = "Network error while sending message: ";

    public NetworkException(){
        super(DEFAULT_MSG);
    }

    public NetworkException(final String message){
        super(MSG_PASSED + message);
    }
}
