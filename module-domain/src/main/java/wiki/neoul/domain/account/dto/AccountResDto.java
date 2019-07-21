package wiki.neoul.domain.account.dto;

import lombok.Getter;
import lombok.ToString;
import wiki.neoul.domain.account.Account;

import java.util.Objects;

/**
 * 프론트에 보여질 정보
 *
 * @author hyeyoom
 */
@Getter
@ToString
public class AccountResDto {

    /**
     * 식별 키
     */
    private String id;

    /**
     * 메일
     */
    private String mail;

    /**
     * 닉네임
     */
    private String displayName;

    /**
     * 썸네일 주소
     */
    private String thumbnailUrl;

    public AccountResDto(Account account) {
        Objects.requireNonNull(account);

        this.id = account.getId();
        this.mail = account.getMail();
        this.displayName = account.getAccountProfile().getDisplayName();
        this.thumbnailUrl = account.getAccountProfile().getThumbnailUrl();
    }
}
