package wiki.neoul.common.exceptions.general;

/**
 * 리소스가 이미 있는 경우에 대한 예외<br/>
 * 이 예외의 전담 핸들러는 409 상태 코드로 응답<br/>
 * 저장하려는 리소스가 이미 존재함<br/>
 *
 * @author hyeyoom
 */
public class ResourceConflictedException extends Exception {

    public ResourceConflictedException(String message) {
        super(message);
    }
}
