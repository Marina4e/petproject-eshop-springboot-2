package com.example.petprojecteshopspringboot2.dao;

import com.example.petprojecteshopspringboot2.domain.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BucketRepository extends JpaRepository<Bucket, Long> {
}
