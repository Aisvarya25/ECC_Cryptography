package net.javaguides.springboot.controller;


import org.springframework.data.jpa.repository.JpaRepository;

public interface FileEntityRepository extends JpaRepository<FileEntity, Long> {
}