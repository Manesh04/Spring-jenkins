package com.example.Controller;

import com.example.Entity.LoginDetails;
//import com.example.Repository.LoginRepo;
import com.example.Service.LoginService;
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
//    @Autowired
//    LoginRepo loginRepo;

    @PostMapping("/saveDetails")
    public LoginDetails addLoginData(@Valid @RequestBody LoginDetails loginDetails){
        return loginService.saveData(loginDetails);
                //loginRepo.save(loginDetails);
    }

    @GetMapping("/getAllDetails")
    public List<LoginDetails> getAllData(LoginDetails loginDetails){
        return loginService.getAllLogin(loginDetails);
                //loginRepo.findAll();
    }

    @GetMapping("/getOneRecord/{id}")
    public Optional<LoginDetails> getOneRecord(@PathVariable("id") Long id){
        return loginService.getOne(id);
                //loginRepo.findById(id);
    }

    @DeleteMapping("/deleteRecord/{id}")
    public String deleteInfo(@PathVariable("id") Long id){
        return loginService.deleteData(id);
//         loginRepo.deleteById(id);
       // return "Delete Successfully";

    }

    @PutMapping("/updateData/{id}")
    public LoginDetails updateData(@Valid @PathVariable("id") Long id,@RequestBody LoginDetails loginDetails){
//        LoginDetails ld = loginRepo.findById(id).get();
//        ld.setFirstName(loginDetails.getFirstName());
//        ld.setLastName(loginDetails.getLastName());
//        ld.setMobileNumber(loginDetails.getMobileNumber());
//        ld.setPassword(loginDetails.getPassword());
//                loginRepo.save(ld);
        return loginService.updateInfo(id, loginDetails);
    }

}
