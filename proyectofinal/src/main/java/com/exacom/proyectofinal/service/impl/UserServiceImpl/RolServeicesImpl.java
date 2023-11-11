package com.exacom.proyectofinal.service.impl.UserServiceImpl;

import com.exacom.proyectofinal.domain.RolDTO;
import com.exacom.proyectofinal.exceptions.CoreException;
import com.exacom.proyectofinal.mapper.RolMapper;
import com.exacom.proyectofinal.repository.RolRepository;
import com.exacom.proyectofinal.service.RolServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.exacom.proyectofinal.Util.Util.getCoreException;

@Service
@RequiredArgsConstructor

public class RolServeicesImpl implements RolServices {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;
    @Override
    public RolDTO finById(Long id) throws CoreException {
         var rol = rolRepository.findById(id).orElseThrow(()->getCoreException("No se encontro el rol : " + id,
                 "No se encotro error especificado",
                 HttpStatus.NOT_FOUND));
        return rolMapper.toDTO(rol);
    }

    @Override
    public List<RolDTO> findAll() {

        return rolRepository.findAll().stream().map(rolMapper::toDTO).toList();
    }

    @Override
    public String save(RolDTO rolDTO) throws CoreException {
        if(rolDTO.getId() !=null ){
            throw getCoreException("El rol que intenta crear ya existe ","El rol que intenta crear ya existe ",HttpStatus.BAD_REQUEST);
        }
        var rol = rolMapper.toEntity(rolDTO);
        rol = rolRepository.save(rol);
        return "El rol ha sido guardado de manera Exitosa " + rol.getId() +" con nombre" + rol.getName() +".";
    }

    @Override
    public String update(RolDTO rolDTO) throws CoreException {

        return save(rolDTO).replace("GUARDADO","Se ha actulizado el resgistro" + rolDTO.getName());
    }

    @Override
    public String delete(Long id) {
        rolRepository.deleteById(id);
        return " El rol :" + id + "ha sido eliminado";
    }


}
