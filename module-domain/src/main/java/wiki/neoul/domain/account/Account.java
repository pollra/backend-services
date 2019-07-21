package wiki.neoul.domain.account;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import wiki.neoul.domain.account.constants.AccountStatus;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString(exclude = "accountProfile")
@Table(name = "accounts")
@EqualsAndHashCode(of = "id")
public class Account {

    /**
     * ID
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private String id;

    /**
     * Required for Sign-In
     */
    @Column(updatable = false, nullable = false, unique = true)
    private String mail;

    /**
     * Required for Sign-in
     */
    @Column(nullable = false)
    private String password;

    /**
     * Indicates whether account is available
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus status = AccountStatus.ACTIVE;

    /**
     * User profile info
     */
    @Setter(AccessLevel.NONE)
    @OneToOne(optional = false, mappedBy = "account", cascade = CascadeType.ALL)
    private AccountProfile accountProfile;

    /**
     * Convenient method
     *
     * @param accountProfile    user profile
     */
    public void setAccountProfile(AccountProfile accountProfile) {
        accountProfile.setAccount(this);
        this.accountProfile = accountProfile;
    }
}
