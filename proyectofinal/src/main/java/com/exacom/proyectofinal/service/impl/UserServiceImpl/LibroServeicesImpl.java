package com.exacom.proyectofinal.service.impl.UserServiceImpl;

import com.exacom.proyectofinal.domain.LibroDTO;
import com.exacom.proyectofinal.exceptions.CoreException;
import com.exacom.proyectofinal.mapper.LibroMapper;
import com.exacom.proyectofinal.repository.LibroRepository;
import com.exacom.proyectofinal.service.LibroServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.exacom.proyectofinal.Util.Util.getCoreException;

@Service
@RequiredArgsConstructor

public class LibroServeicesImpl implements LibroServices {

    private final LibroRepository libroRepository;
    private final LibroMapper libroMapper;
    @Override
    public LibroDTO finById(Long id) throws CoreException {

         var libro = libroRepository.findById(id).orElseThrow(()->getCoreException("No se encontro el libro : " + id,
                 "No se encotro error especificado",
                 HttpStatus.NOT_FOUND));
        return libroMapper.toDTO(libro);
    }

    @Override
    public List<LibroDTO> findAll() {

        return libroRepository.findAll().stream().map(libroMapper::toDTO).toList();
    }

    @Override
    public String save(LibroDTO libroDTO) throws CoreException {
        if (libroRepository.existsByIsbn(libroDTO.getIsbn())){
          throw   getCoreException( "Ya existe una ISBN especificado " +libroDTO.getIsbn(),
                  "Ya existe una ISBN especificado" +libroDTO.getIsbn(),HttpStatus.BAD_REQUEST);
        }
        var libro = libroMapper.toEntity(libroDTO);
        libro = libroRepository.save(libro);
        return "El libro ha sido guardado de manera Exitosa " + libro.getId() +" con nombre" + libro.getTittle() +".";
    }

    @Override
    public String update(LibroDTO libroDTO) throws CoreException {
        if (libroRepository.existsByIsbn(libroDTO.getIsbn())){
            throw   getCoreException( "Ya existe una ISBN especificado " +libroDTO.getIsbn(),
                    "Ya existe una ISBN especificado" +libroDTO.getIsbn(),HttpStatus.BAD_REQUEST);
        }
        return save(libroDTO).replace("GUARDADO","Se ha actulizado el resgistro" + libroDTO.getTittle());
    }

    @Override
    public String delete(Long id) {
        libroRepository.deleteById(id);
        return " El libro :" + id + "ha sido eliminado";
    }


}
