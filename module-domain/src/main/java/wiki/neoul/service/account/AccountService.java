package wiki.neoul.service.account;

import wiki.neoul.domain.account.Account;
import wiki.neoul.domain.account.dto.AccountReqDto;
import wiki.neoul.exceptions.EmailAlreadyExistException;

/**
 * User Service
 *
 * @author hyeyoom
 */
public interface AccountService {

    /**
     * @param id        UUID key
     * @return          Account entity. null if not existing
     */
    Account getAccount(String id);

    /**
     * @param mail      User mail(UQ)
     * @return          Account entity. null if not existing
     */
    Account getAccountByMail(String mail);

    /**
     * @param dto       Request DTO
     * @return          Account entity. null if not existing
     * @throws EmailAlreadyExistException   Thrown if email already exists
     */
    Account join(AccountReqDto dto) throws EmailAlreadyExistException;
}
