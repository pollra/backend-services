package wiki.neoul.common.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import wiki.neoul.common.exceptions.general.ResourceConflictedException;
import wiki.neoul.types.RestErrorResponse;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ResourceConflictedExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ResourceConflictedException.class)
    public RestErrorResponse handleResourceConflictedException(ResourceConflictedException e) {
        return null;
    }
}
