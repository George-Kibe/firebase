package com.kibe.UdemyCrud.service;

import com.kibe.UdemyCrud.dao.EmployeeRepository;
import com.kibe.UdemyCrud.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    // private EmployeeDAO employeeDAO;
    private EmployeeRepository employeeRepository;

    // @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    // @Transactional JPA provides this functionality
    @Override
    public Optional<Employee> findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;

        if(result.isPresent()){
            theEmployee = result.get();
        }
        else {
            throw new RuntimeException("Did not find Employee of ID: "+theId);
        }
        return Optional.of(theEmployee);
    }

    // @Transactional JPA provides this functionality
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }
    // @Transactional JPA provides this functionality
    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
