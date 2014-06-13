package edu.neumont.jjensen.model;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jjensen on 6/12/14.
 */

@Entity
@Table(name="Account")
@NamedQueries({
        @NamedQuery(name="byUsername", query="SELECT a FROM Account a WHERE a.username = :username")
})
public class Account {
    @Id
    @Column(name="id")
    @SequenceGenerator(name="account_seq", sequenceName="account_seq", initialValue=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="account_seq")
    private Long id;

    @Column(name="username", unique=true)
    private String username;

    @Column(name="password")
    private String password;

    @OneToMany(fetch=FetchType.EAGER, mappedBy="account", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<AccountRole> roles = new HashSet<>();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<AccountRole> getRoles() {
        return Collections.unmodifiableSet(roles);
    }

    public void addRole(Role user) {
        AccountRole ar = new AccountRole();
        ar.setRole(user);
        ar.setUsername(username);
        roles.add(ar);
    }

    public boolean hasRole(Role role) {
        for ( AccountRole accountRole : roles ) {
            if ( accountRole.getRole().equals(role) ) {
                return true;
            }
        }
        return false;
    }
}
