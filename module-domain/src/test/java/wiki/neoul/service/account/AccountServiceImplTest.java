package wiki.neoul.service.account;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import wiki.neoul.domain.account.Account;
import wiki.neoul.domain.account.dto.AccountReqDto;
import wiki.neoul.exceptions.EmailAlreadyExistException;
import wiki.neoul.repository.account.AccountRepository;

import java.util.Optional;

import static org.mockito.Mockito.when;

public class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    private AccountServiceImpl mockAccountService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockAccountService = new AccountServiceImpl(accountRepository);
    }

    @Test(expected = EmailAlreadyExistException.class)
    public void 가입_시_이메일이_이미_존재하는_경우_익셉션이_발생함() throws Exception {
        // given
        final AccountReqDto dto = new AccountReqDto();
        final String email = "sysadmin@neoul.wiki";
        dto.setMail(email);
        dto.setName("관리자나부랭이ㅇㅅㅇ!!");
        dto.setPassword("심각하고고귀한비밀번호!!");

        // when
        when(accountRepository.findByMail(email))
                .thenReturn(Optional.of(new Account()));

        // then
        mockAccountService.join(dto);
    }
}
