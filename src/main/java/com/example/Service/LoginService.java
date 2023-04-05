package com.example.Service;

import com.example.entity.LoginDetails;
import com.example.payloads.LoginDetailsDTO;
import com.example.repository.LoginRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    LoginRepo loginRepo;

    //Create Data
    public LoginDetails saveData(LoginDetails loginDetails) {
        return loginRepo.save(loginDetails);
    }

    //Read all data
    public List<LoginDetails> getAllLogin(LoginDetails loginDetails) {

        return loginRepo.findAll();
    }

    //Read One Record
    public Optional<LoginDetails> getOne(Long id) {
        return loginRepo.findById(id);
    }


    //
    //Delete
    public String deleteData(Long id) {

        loginRepo.deleteById(id);
        return "Delete Successfully...";
    }

    //Update
    public LoginDetails updateInfo(Long id, LoginDetails loginDetails) {
        LoginDetails ld = loginRepo.findById(id).get();
        ld.setFirstName(loginDetails.getFirstName());
        ld.setLastName(loginDetails.getLastName());
        ld.setMobileNumber(loginDetails.getMobileNumber());
        ld.setPassword(loginDetails.getPassword());
        return loginRepo.save(ld);
    }

//    ---------------------------------------------------------------------------------

    public LoginDetails dtoToUser(LoginDetailsDTO detailsDTO){
        LoginDetails loginDetails = this.modelMapper.map(detailsDTO, LoginDetails.class);
        return loginDetails;
    }

    public LoginDetailsDTO loginDetailsToDTO(LoginDetails loginDetails){
        LoginDetailsDTO detailsDTO = this.modelMapper.map(loginDetails, LoginDetailsDTO.class);
        return detailsDTO;
    }
}
