package wiki.neoul.domain.account;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString(exclude = "account")
@EqualsAndHashCode(of = "id")
public class AccountProfile {

    /**
     * Account.id (UUID)
     */
    @Id
    private String id;

    /**
     * displayed name for another users
     */
    @Column(nullable = false)
    private String displayName;

    /**
     * thumbnail url
     */
    private String thumbnailUrl;

    /**
     * Bio for short
     */
    private String shortBio;

    /**
     * Joined Date
     */
    @Column(updatable = false, nullable = false)
    private Timestamp joinedDate = new Timestamp(System.currentTimeMillis());

    /**
     * Account entity
     */
    @MapsId
    @OneToOne
    private Account account;
}
