package com.exacom.proyectofinal.service.impl.UserServiceImpl;

import com.exacom.proyectofinal.domain.AutorDTO;
import com.exacom.proyectofinal.exceptions.CoreException;
import com.exacom.proyectofinal.mapper.AutorMapper;
import com.exacom.proyectofinal.repository.AutorRepository;
import com.exacom.proyectofinal.service.AutorServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.exacom.proyectofinal.Util.Util.getCoreException;

@Service
@RequiredArgsConstructor

public class AutorServeicesImpl implements AutorServices {

    private final AutorRepository autorRepository;
    private final AutorMapper autorMapper;
    @Override
    public AutorDTO finById(Long id) throws CoreException {
         var autor = autorRepository.findById(id).orElseThrow(()->getCoreException("No se encontro el Autor : " + id,
                 "No se encotro error especificado",
                 HttpStatus.NOT_FOUND));
        return autorMapper.toDTO(autor);
    }

    @Override
    public List<AutorDTO> findAll() {

        return autorRepository.findAll().stream().map(autorMapper::toDTO).toList();
    }

    @Override
    public String save(AutorDTO autorDTO) throws CoreException {
                                     if(autorDTO.getId() !=null ){
            throw getCoreException("El Autor que intenta crear ya existe ","El Autor que intenta crear ya existe ",HttpStatus.BAD_REQUEST);
        }
        var autor = autorMapper.toEntity(autorDTO);
        autor = autorRepository.save(autor);
        return "El Autor ha sido guardado de manera Exitosa " + autor.getId() +" con nombre" + autor.getName() +".";
    }

    @Override
    public String update(AutorDTO autorDTO) throws CoreException {

        return save(autorDTO).replace("GUARDADO","Se ha actulizado el resgistro" + autorDTO.getName());
    }

    @Override
    public String delete(Long id) {
        autorRepository.deleteById(id);
        return " El Autor :" + id + "ha sido eliminado";
    }


}
