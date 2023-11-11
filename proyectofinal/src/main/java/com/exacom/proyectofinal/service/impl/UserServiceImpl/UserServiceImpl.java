package com.exacom.proyectofinal.service.impl.UserServiceImpl;

import com.exacom.proyectofinal.domain.UserDTO;
import com.exacom.proyectofinal.exceptions.CoreException;
import com.exacom.proyectofinal.mapper.UserMapper;
import com.exacom.proyectofinal.repository.RolRepository;
import com.exacom.proyectofinal.repository.UserRepository;
import com.exacom.proyectofinal.service.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import static com.exacom.proyectofinal.Util.Util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServices {
    //@Autowired
    //private UserRepository  userRepository;

    private final  UserRepository  userRepository;
    private final RolRepository rolRepository;
    private final UserMapper userMapper ;

  /*  public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }*/

    @Override
    public UserDTO findById(long id) throws CoreException {
       var user =  userRepository.findById(id).orElseThrow(
               () -> getCoreException(
                       "No se encontro el usuario con el id: " + id,
                       "No se encontro el usuario con el id: " + id,
                       HttpStatus.NOT_FOUND
               ));
        return userMapper.toDTO(user);

    }

    @Override
    public UserDTO findByEmail(String email) throws CoreException {
        var user = userRepository.findByEmail(email).orElseThrow(
                () -> getCoreException(
                        "No se encontro el usuario con el email: " + email,
                        "No se encontro el usuario con el email: " + email,
                        HttpStatus.NOT_FOUND
                ));
        return userMapper.toDTO(user);
    }

    @Override
    public List<UserDTO> findAll() {
        var users = userRepository.findAll();
        return users.stream().map(userMapper::toDTO).toList();

    }

    @Override
    public String save(UserDTO userDTO) throws CoreException {
        if (userRepository.existsByEmail(userDTO.getEmail()
                //,userDTO.getId()==1
                )){
            throw getCoreException("el email ingresado ya existe por favor ccalidar ",
                    "el email ingresado ya existe por favor ccalidar ",
                    HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByUsername(userDTO.getEmail()
                //,userDTO.getId()) == 1
        )){
            throw getCoreException("el username ingresado ya existe por favor ccalidar ",
                    "el email username ya existe por favor ccalidar ",
                    HttpStatus.BAD_REQUEST);
        }
        var user = userMapper.toEntity(userDTO);
        rolRepository.saveAll(user.getRoles());
        userRepository.save(user);
        return "Se creo el usuario con el ID: " +user.getId();
    }

    @Override
    public String update(UserDTO userDTO) throws CoreException {
        /*if (userRepository.existsByEmail(userDTO.getEmail())){
            throw getCoreException("el email ingresado ya existe por favor ccalidar ",
                    "el email ingresado ya existe por favor ccalidar ",
                    HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByUsername(userDTO.getEmail())){
            throw getCoreException("el username ingresado ya existe por favor ccalidar ",
                    "el email username ya existe por favor ccalidar ",
                    HttpStatus.BAD_REQUEST);*/
        return save(userDTO).replace("se creo","se actualiza");

    }

    @Override
   public String delete(UserDTO userDTO) {
        return null;
    }

    @Override
    public String delete(long id) {
        userRepository.deleteById(id);
        return "Se ha eliminado el usduario con el ID :" + id + "correctamente";
    }

    /*private CoreException getCoreException(String messageUser, String developMessage, HttpStatus status){
         return CoreException.builder()
                 .userMessage(messageUser)
                 .developMessage(developMessage)
                 .errorCode(status.value())
                 .erroType(status.name())
                 .build();
    }*/

}
