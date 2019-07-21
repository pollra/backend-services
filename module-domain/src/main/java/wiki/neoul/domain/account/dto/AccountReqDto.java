package wiki.neoul.domain.account.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import wiki.neoul.domain.account.Account;
import wiki.neoul.domain.account.AccountProfile;
import wiki.neoul.utils.EncryptionUtil;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Getter
@Setter
@ToString
public class AccountReqDto {

    /**
     * mail for sign-in
     */
    @NotBlank(message = "error.validation.blankMail")
    @Email(message = "error.validation.wrongMail")
    private String mail;

    /**
     * password for sign-in
     */
    @Min(message = "error.validation.minPass", value = 8)
    @NotBlank(message = "error.validation.blankPass")
    private String password;

    /**
     * name that will be displayed
     */
    @NotBlank(message = "error.validation.blankName")
    private String name;

    public Account toEntity() {
        Account account = new Account();
        account.setMail(mail);
        try {
            account.setPassword(EncryptionUtil.generateHash(password));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ignore) { }

        AccountProfile profile = new AccountProfile();
        profile.setDisplayName(name);

        account.setAccountProfile(profile);
        return account;
    }
}
