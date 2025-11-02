package com.senati.senati_web_JeffersonTrujillo.controller;
import com.senati.senati_web_JeffersonTrujillo.model.Response;
import com.senati.senati_web_JeffersonTrujillo.service.UserService;
import com.senati.senati_web_JeffersonTrujillo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "https://wedjeffer-dmgehnhpbwgbf2df.mexicocentral-01.azurewebsites.net")
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

    @PostMapping ("/api/user")
    public ResponseEntity<User> newUser(@RequestBody User user){
        return userService.newUser(user);
    }

    @DeleteMapping ("/api/user/{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable int id) {
        Response response = userService.deleteUser(id);
        if (response.getCode() == 200) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


    @PutMapping ("/api/user/{id}")
    public ResponseEntity<User> newUser(@PathVariable int id,@RequestBody User user){
        return userService.updateUser(id, user);
    }
}
