package com.example.Onboarding.services;

import com.example.Onboarding.model.Lawyer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ChecklistInterface {
    Checklist registeremployee(Checklist stud);
    Checklist updateemployee(Checklist stud);
    void deleteemployee(Long stud);
    List<Checklist> employeeList();
    Checklist findemployeeByemployeeId(Long stud);

    Page<Checklist> pagenateemployee(int pageNo, int pageSize);

}
