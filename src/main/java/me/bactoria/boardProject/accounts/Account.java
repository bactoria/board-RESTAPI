package me.bactoria.boardProject.accounts;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder @NoArgsConstructor @AllArgsConstructor
@Getter @Setter @EqualsAndHashCode(of = "id")
public class Account {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;
    private String password;
    private String name;
    private String phone;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<AccountRole> roles;
}
