package com.parcelnotfound.backend.repository;

import com.parcelnotfound.backend.entity.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository <Test, String> {
    Test findById (Integer id);
}
