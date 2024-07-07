package com.pykube.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pykube.net.Signup;
import com.pykube.repo.SignupRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SignupService {

    @Autowired
    private SignupRepository signupRepository;

    public Signup saveSignup(Signup signup) {
        return signupRepository.save(signup);
    }

    public List<Signup> getAllSignups() {
        return signupRepository.findAll();
    }

    public Optional<Signup> getSignupById(Long id) {
        return signupRepository.findById(id);
    }

    public void deleteSignup(Long id) {
        signupRepository.deleteById(id);
    }
}
