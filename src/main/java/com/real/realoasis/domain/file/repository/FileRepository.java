package com.real.realoasis.domain.file.repository;

import com.real.realoasis.domain.file.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
