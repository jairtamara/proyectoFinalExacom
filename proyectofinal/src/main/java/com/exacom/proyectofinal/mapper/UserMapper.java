package com.exacom.proyectofinal.mapper;

import com.exacom.proyectofinal.domain.RolDTO;
import com.exacom.proyectofinal.domain.UserDTO;
import com.exacom.proyectofinal.model.Rol;
import com.exacom.proyectofinal.model.User;
import lombok.Builder;
import org.springframework.stereotype.Component;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Builder
public class UserMapper implements StandarMapper<User, UserDTO> {

    private final  RolMapper rolMapper;
    @Override
    public User toEntity(UserDTO dto) {
        var roles = new ArrayList<Rol>();
        if (dto.getRoles() != null){
            dto.getRoles().stream().map(rolMapper::toEntity).forEach(roles::add);

        }
        return User.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .pass(dto.getPass())
                .email(dto.getEmail())
                .roles(roles)
                .enabled(dto.isEnabled())
                .build();
    }

    @Override
    public UserDTO toDTO(User Entity) {
        var roles = new ArrayList<RolDTO>();
        if (Entity.getRoles() != null){
            //Entity.getRoles().stream().map(rolMapper::toEntity).forEach(roles::add);
        }
        return  UserDTO.builder()
                .id(Entity.getId())
                .username(Entity.getUsername())
                .pass(Entity.getPass())
                .email(Entity.getEmail())
                .roles(roles)
                .enabled(Entity.isEnabled())
                .build();

    }
}
