package GB_SOS.DataAccessLaeyr;

import java.io.IOException;

public class DBException extends IOException{
    public DBException(String message) {
        super(message);
    }
}
