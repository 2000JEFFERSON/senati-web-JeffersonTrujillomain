package com.senati.senati_web_JeffersonTrujillo.controller;
import com.senati.senati_web_JeffersonTrujillo.model.Response;
import com.senati.senati_web_JeffersonTrujillo.service.UserService;
import com.senati.senati_web_JeffersonTrujillo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping ("/api/users")
    public ResponseEntity<User> newUser(@RequestBody User user){
        return userService.newUser(user);
    }
    @DeleteMapping ("/api/users/{id}")
    public Response deleteUser(@PathVariable int id){
        return  userService.deleteUser(id);
    }
    //public ResponseEntity<User> deleteUser(@PathVariable int id) {
       // userService.deleteUser(id);
       // return ResponseEntity.noContent().build();
    //}

    @PutMapping ("/api/users/{id}")
    public ResponseEntity<User> newUser(@PathVariable int id,@RequestBody User user){
        return userService.updateUser(id, user);
    }
}
