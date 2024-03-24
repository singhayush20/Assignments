package com.ayushsingh.ta_candidate.model.roles;

import com.ayushsingh.ta_candidate.model.entity.Candidate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity(name = "consumer_role")
public class ConsumerRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role", nullable = false, unique = true)
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private Set<Candidate> candidates;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsumerRole that = (ConsumerRole) o;
        return Objects.equals(roleId, that.roleId) && Objects.equals(roleName, that.roleName) && Objects.equals(consumers, that.consumers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleName);
    }
}
