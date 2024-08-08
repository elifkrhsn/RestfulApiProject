package com.example.demo.specification;

import com.example.demo.filter.FilterProject;
import com.example.demo.model.Project;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProjectSpecification {

    public static Specification<Project> filter(final FilterProject filter) {
        return new Specification<Project>() {
            @Override
            public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if (filter.getProjectName() != null) {
                    predicates.add(cb.like(cb.lower(root.get("projectName")), "%" + filter.getProjectName().toLowerCase() + "%"));
                }
                if (filter.getProjectType() != null) {
                    predicates.add(cb.equal(root.get("projectType"), filter.getProjectType()));
                }
                if (filter.getDepartment() != null) {
                    predicates.add(cb.equal(root.get("department"), filter.getDepartment()));
                }
                if (filter.getVpnUsername() != null) {
                    predicates.add(cb.equal(root.get("vpnUsername"), filter.getVpnUsername()));
                }
                if (filter.getVpnPassword() != null) {
                    predicates.add(cb.equal(root.get("vpnPassword"), filter.getVpnPassword()));
                }
                if (filter.getEnvironmentInfo() != null) {
                    predicates.add(cb.like(cb.lower(root.get("environmentInfo")), "%" + filter.getEnvironmentInfo().toLowerCase() + "%"));
                }

                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
