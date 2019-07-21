package wiki.neoul.service.account;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import wiki.neoul.domain.account.Account;
import wiki.neoul.domain.account.dto.AccountReqDto;
import wiki.neoul.exceptions.EmailAlreadyExistException;
import wiki.neoul.repository.account.AccountRepository;

@Slf4j
@Service
@Primary
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account getAccount(String id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account getAccountByMail(String mail) {
        return accountRepository.findByMail(mail).orElse(null);
    }

    @Override
    public Account join(AccountReqDto dto) throws EmailAlreadyExistException {
        if (accountRepository.findByMail(dto.getMail()).isPresent()) {
            throw new EmailAlreadyExistException("Email already exists in database!");
        }
        return accountRepository.save(dto.toEntity());
    }
}
