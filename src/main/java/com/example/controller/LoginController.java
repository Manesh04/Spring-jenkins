package com.example.controller;

import com.example.entity.LoginDetails;
import com.example.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/demo")
    public String getData() {
        return "SpringBootCRUD Service";
    }

    @PostMapping("/saveDetails")
    public LoginDetails addLoginData(@Valid @RequestBody LoginDetails loginDetails) {
        return loginService.saveData(loginDetails);
    }

    @GetMapping("/getAllDetails")
    public List<LoginDetails> getAllData(LoginDetails loginDetails) {
        return loginService.getAllLogin(loginDetails);
    }

    @GetMapping("/getOneRecord/{id}")
    public Optional<LoginDetails> getOneRecord(@PathVariable("id") Long id) {
        return loginService.getOne(id);
    }

    @DeleteMapping("/deleteRecord/{id}")
    public String deleteInfo(@PathVariable("id") Long id) {
        return loginService.deleteData(id);
    }

    @PutMapping("/updateData/{id}")
    public LoginDetails updateData(@Valid @PathVariable("id") Long id, @RequestBody LoginDetails loginDetails) {
        return loginService.updateInfo(id, loginDetails);
    }

}
