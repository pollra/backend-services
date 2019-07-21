package wiki.neoul.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;
import wiki.neoul.domain.account.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {

    Optional<Account> findByMail(String mail);
}
