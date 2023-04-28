package Parcial1.controller;

import Parcial1.model.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

//REST API
@RestController
public class UserController {

    private UserRepository repository = new UserRepository();

    @PostMapping(value ="users/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> create(@RequestBody User user){
        try {
            repository.createUser(user);
            return ResponseEntity.status(200).body(new StatusInfo( 200,  "Usuario creado correctamente "));
        } catch (Exception e) {
            return ResponseEntity.status(409).body(new StatusInfo( 409,  "Usuario repetido en la base de datos "));
        }

    }
    @PosMapping (value = "user/create", consumes= "application/json", produces = "application/json")
    public Users create (@RequestBody User user){
        repository.createUser(user);
        return users;

    }

    @GetMapping(value= "user/all", produces = " application/json")
    public ArrayList<User> getAll(){

        return repository.getAll();
    }


    @PostMapping(value = "login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object>login(@RequestBody User user){
        try{
            User dbuser= repository.getUserByEmailAndPassword(user.getEmail(),user.getPass());
            return  ResponseEntity.status(200).body(dbuser);

        }catch(Exception ex){
            return ResponseEntity.status(401).body(new StatusInfo(401, ex.getMessage()));
        }
    }
}