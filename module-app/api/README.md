# API module

Service API

## 1. Rules

## 1.1 Handling exceptions

응답 예외는 글로벌하게 처리하되 다음과 같은 원칙을 가진다.  

1. `응답 상태(Response Status)`에 대한 상위 익셉션이 존재하고 이에 대한 핸들러가 존재
2. 필요하다면 상위 익셉션을 상속받아서 예외를 정의할 것
3. 이 모듈에서 정의한 익셉션은 절대로 외부에서 참조해서는 안됨

이를 유지하면 다른 모듈에 대한 오염을 방지하면서 예외에 대한 처리 방식을 일관성 있게 유지할 수 있다.  

또한 위의 이유로 컨트롤러는 정상적인 응답에 대해서만 동작하고 모든 예외는 핸들러에게 전파하는 방식으로 작성한다.  