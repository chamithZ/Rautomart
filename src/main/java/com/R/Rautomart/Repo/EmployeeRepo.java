package com.R.Rautomart.Repo;

import com.R.Rautomart.Entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<employee,Integer> {
}
