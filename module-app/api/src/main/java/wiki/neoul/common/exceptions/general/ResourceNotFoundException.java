package wiki.neoul.common.exceptions.general;

/**
 * 리소스가 없는 경우에 대한 예외<br/>
 * 이 예외의 전담 핸들러는 404 상태 코드로 응답<br/>
 * 요청한 리소스가 존재하지 않음<br/>
 *
 * @author hyeyoom
 */
public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
