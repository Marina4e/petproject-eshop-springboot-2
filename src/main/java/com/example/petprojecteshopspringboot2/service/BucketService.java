package com.example.petprojecteshopspringboot2.service;

import com.example.petprojecteshopspringboot2.domain.Bucket;
import com.example.petprojecteshopspringboot2.domain.User;
import com.example.petprojecteshopspringboot2.dto.BucketDTO;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user, List<Long> productIds);

    void addProducts(Bucket bucket, List<Long> productIds);

    BucketDTO getBucketByUser(String name);

    void commitBucketToOrder(String username);
}
