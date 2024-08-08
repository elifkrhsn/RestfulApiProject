package com.example.demo.specification;

import com.example.demo.filter.FilterEmployee;
import com.example.demo.model.Employee;
import com.example.demo.model.Level;
import com.example.demo.model.WorkMode;
import com.example.demo.model.ContractType;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSpecification {

    public static Specification<Employee> filter(final FilterEmployee filter) {
        return new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if (filter.getFirstName() != null) {
                    predicates.add(cb.like(cb.lower(root.get("firstName")), "%" + filter.getFirstName().toLowerCase() + "%"));
                }
                if (filter.getLastName() != null) {
                    predicates.add(cb.like(cb.lower(root.get("lastName")), "%" + filter.getLastName().toLowerCase() + "%"));
                }
                if (filter.getEmail() != null) {
                    predicates.add(cb.equal(root.get("email"), filter.getEmail()));
                }
                if (filter.getPhoneNumber() != null) {
                    predicates.add(cb.equal(root.get("phoneNumber"), filter.getPhoneNumber()));
                }
                if (filter.getBirthDate() != null) {
                    predicates.add(cb.equal(root.get("birthDate"), filter.getBirthDate()));
                }
                if (filter.getLevel() != null) {
                    predicates.add(cb.equal(root.get("level"), filter.getLevel()));
                }
                if (filter.getWorkMode() != null) {
                    predicates.add(cb.equal(root.get("workMode"), filter.getWorkMode()));
                }
                if (filter.getContractType() != null) {
                    predicates.add(cb.equal(root.get("contractType"), filter.getContractType()));
                }
                if (filter.getTeam() != null) {
                    predicates.add(cb.equal(root.get("team"), filter.getTeam()));
                }
                if (filter.getStartDate() != null) {
                    predicates.add(cb.greaterThanOrEqualTo(root.get("startDate"), filter.getStartDate()));
                }
                if (filter.getEndDate() != null) {
                    predicates.add(cb.lessThanOrEqualTo(root.get("endDate"), filter.getEndDate()));
                }

                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}
