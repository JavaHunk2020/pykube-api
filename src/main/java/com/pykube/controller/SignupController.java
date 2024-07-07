package com.pykube.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pykube.net.Signup;
import com.pykube.service.SignupService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/signups")
public class SignupController {

    @Autowired
    private SignupService signupService;

    @PostMapping
    public Signup createSignup(@RequestBody Signup signup) {
        return signupService.saveSignup(signup);
    }

    @GetMapping
    public List<Signup> getAllSignups() {
        return signupService.getAllSignups();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Signup> getSignupById(@PathVariable Long id) {
        Optional<Signup> signup = signupService.getSignupById(id);
        return signup.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Signup> updateSignup(@PathVariable Long id, @RequestBody Signup signupDetails) {
        Optional<Signup> signup = signupService.getSignupById(id);
        if (signup.isPresent()) {
            Signup existingSignup = signup.get();
            existingSignup.setName(signupDetails.getName());
            existingSignup.setEmail(signupDetails.getEmail());
            existingSignup.setMobile(signupDetails.getMobile());
            existingSignup.setDateOfJoining(signupDetails.getDateOfJoining());
            existingSignup.setGender(signupDetails.getGender());
            existingSignup.setPhoto(signupDetails.getPhoto());
            existingSignup.setAddress(signupDetails.getAddress());

            Signup updatedSignup = signupService.saveSignup(existingSignup);
            return ResponseEntity.ok(updatedSignup);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSignup(@PathVariable Long id) {
        signupService.deleteSignup(id);
        return ResponseEntity.noContent().build();
    }
}

