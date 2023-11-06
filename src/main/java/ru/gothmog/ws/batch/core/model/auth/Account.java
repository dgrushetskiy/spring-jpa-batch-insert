package ru.gothmog.ws.batch.core.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.gothmog.ws.batch.core.model.AbstractEntity;

import javax.persistence.Index;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ForeignKey;
import javax.persistence.FetchType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "accounts", indexes = {@Index(name = "idx_account_uuid_unq", columnList = "public_id", unique = true),
                                     @Index(name = "idx_account_username_unq", columnList = "username", unique = true),
                                     @Index(name = "idx_account_email_unq", columnList = "email", unique = true),
                                     @Index(name = "idx_account_phone_unq", columnList = "phone", unique = true)})
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Account extends AbstractEntity {

    @NotNull
    @Column(name = "public_id", nullable = false, unique = true)
    private UUID publicId;

    @Size(max = 200)
    @NotNull
    @Column(name = "username", nullable = false, length = 200, unique = true)
    private String username;

    @Size(max = 200)
    @NotNull
    @Column(name = "email", nullable = false, length = 200, unique = true)
    private String email;

    @Size(max = 512)
    @NotNull
    @Column(name = "passwd", nullable = false, length = 512)
    private String passwd;

    @Size(max = 15)
    @NotNull
    @Column(name = "phone", nullable = false, length = 15, unique = true)
    private String phone;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "department_id", nullable = false, foreignKey = @ForeignKey(name = "fk_account_department"))
    private Department department;

}
