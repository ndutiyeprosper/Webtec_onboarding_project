package com.example.bibafrica.services.implementation;

import com.example.bibafrica.model.Lawyer;
import com.example.bibafrica.repository.LawyerRepository;
import com.example.bibafrica.services.LawyerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewHires implements ChecklistInterface {
    @Autowired
    checkListRepo employeeRepository;

    @Override
    public Checklist registeremployee(Checklist stud) {
        return employeeRepository.save(stud);
    }

    @Override
    public Checklist updateemployee(Checklist stud) {
        return employeeRepository.save(stud);
    }

    @Override
    public void deleteemployee(Long stud) {
        employeeRepository.deleteById(stud);
    }


    @Override
    public List<Checklist> employeeList() {
        return employeeRepository.findAll();
    }

    @Override
    public Checklist findemployeeByemployeeId(Long stud) {
        return employeeRepository.findById(stud).get();
    }

    @Override
    public Page<Checklist> pagenateemployee(int pageNo, int pageSize) {
        Pageable pageable= PageRequest.of(pageNo -1,pageSize);
        return this.employeeRepository.findAll(pageable);
    }

}
