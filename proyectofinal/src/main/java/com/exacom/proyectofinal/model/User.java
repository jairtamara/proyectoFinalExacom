package com.exacom.proyectofinal.model;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="users")
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,length = 32 ,nullable = false)
    private String username;
    @Column(length = 34 , nullable = false)
    private String pass;
    @Column(unique = true,length = 64, nullable = false)
    private String email;
    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn (name = "user_id" , referencedColumnName = "id" ,nullable = false),
            inverseJoinColumns = @JoinColumn(name = "rol_id" , referencedColumnName = "id", nullable = false)
    )
    private List <Rol> roles;
    @Column(nullable = false)
    private boolean enabled;
    @CreationTimestamp
    @Column(updatable = false ,nullable = false)
    private LocalDateTime created;
    @UpdateTimestamp
    @JoinColumn (insertable = false)
    private LocalDateTime updated;




}
