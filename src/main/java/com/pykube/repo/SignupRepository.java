package com.pykube.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pykube.net.Signup;

public interface SignupRepository extends JpaRepository<Signup, Long> {
}
