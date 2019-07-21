package wiki.neoul.types;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Error response for Bad requests
 *
 * @author hyeyoom
 */
@Getter
@Setter
public class RestErrorResponse {

    /**
     * 응답 상태 코드<br/>
     */
    private final int status;

    /**
     * 응답 메세지<br/>
     */
    private final String message;

    /**
     * 에러 필드에 대한 응답 페이로드<br/>
     */
    private List<ErrorDetail> errors = new ArrayList<>();

    public RestErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public void addError(String errorKey, String errorMessage) {
        ErrorDetail ed = new ErrorDetail();
        ed.setErrorKey(errorKey);
        ed.setErrorMessage(errorMessage);
        this.errors.add(ed);
    }

    @Getter
    @Setter
    private static class ErrorDetail {

        /**
         * 요청 시 잘못된 부분의 키
         */
        private String errorKey;

        /**
         * 에러 내용
         */
        private String errorMessage;
    }
}
