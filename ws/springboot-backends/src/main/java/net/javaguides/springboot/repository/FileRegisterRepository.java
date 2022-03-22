package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Files;

@Repository
public interface FileRegisterRepository extends JpaRepository<Files, Long>{

}
