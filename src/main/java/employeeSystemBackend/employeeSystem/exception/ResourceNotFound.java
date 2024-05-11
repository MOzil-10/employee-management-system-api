package employeeSystemBackend.employeeSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {

    //When ever a record does not exist in the database, we throw this exception|
    //The API will return a not found status to the client
    private static final long serialVersionId = 1l;

    public ResourceNotFound(String message) {
        super(message);
    }
}
