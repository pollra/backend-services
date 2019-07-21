package wiki.neoul.api.account;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import wiki.neoul.common.exceptions.general.ResourceConflictedException;
import wiki.neoul.common.exceptions.general.ResourceNotFoundException;
import wiki.neoul.domain.account.Account;
import wiki.neoul.domain.account.dto.AccountReqDto;
import wiki.neoul.domain.account.dto.AccountResDto;
import wiki.neoul.exceptions.EmailAlreadyExistException;
import wiki.neoul.service.account.AccountService;

import javax.validation.Valid;
import java.util.Optional;

/**
 * 현재는 권한 고려를 안한 상태이므로 일단 진행<br/>
 * Wiki 문서의 ACL 분리를 할 필요가 있어서 보류 중..!<br/>
 *
 * @author hyeyoom
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountV1Controller {

    private AccountService accountService;

    public AccountV1Controller(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public AccountResDto getAccount(@PathVariable String id) throws ResourceNotFoundException {
        final Account account = Optional
                .ofNullable(accountService.getAccount(id))
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new AccountResDto(account);
    }

    @PostMapping
    public AccountResDto join(@RequestBody @Valid AccountReqDto dto) throws Exception {
        Account account;
        try {
            account = Optional
                    .ofNullable(accountService.join(dto))
                    .orElseThrow(() -> new Exception("How can it be null..?"));
        } catch (EmailAlreadyExistException e) {
            throw new ResourceConflictedException("Email already exists!");
        }
        return new AccountResDto(account);
    }
}
