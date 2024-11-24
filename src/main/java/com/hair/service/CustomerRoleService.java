package com.hair.service;

import com.hair.repository.CustomerRepository;
import com.hair.repository.CustomerRoleRepository;
import com.hair.repository.RoleRepository;
import com.hair.responseDTO.CustRolName;
import com.hair.model.CustomerRole;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerRoleService {
    private final CustomerRoleRepository customerRoleRepository;
    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;

    public CustomerRoleService(CustomerRoleRepository userRoleRepository,
                               CustomerRepository userRepository,
                               RoleRepository roleRepository) {
        this.customerRoleRepository = userRoleRepository;
        this.customerRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<CustRolName> findAll() {
        List<CustomerRole> listUsRol = customerRoleRepository.findAll();
        List<CustRolName> listUsRolName = new ArrayList<>();
        for (CustomerRole item : listUsRol) {
            CustRolName custRolName = new CustRolName();
            custRolName.setUserId(item.getUserId());

            custRolName.setRoleId(item.getRoleId());
            custRolName.setRoleName(roleRepository.findById(item.getRoleId()).get().getRole());
            listUsRolName.add(custRolName);
        }
        return listUsRolName;
    }

    public Optional<CustomerRole> findById(Long id) {
        return customerRoleRepository.findById(id);
    }

    public Optional<CustomerRole> create(CustomerRole customerRole) {
        return Optional.of(customerRoleRepository.save(customerRole));
    }

    public void delete(Long id) {
        customerRoleRepository.deleteById(id);
    }

    public Optional<CustomerRole> update(CustomerRole customerRole) {
        Optional<CustomerRole> usRol = customerRoleRepository.findById(customerRole.getId());
        if (usRol.isPresent()) {
            usRol.get().setUserId(customerRole.getUserId());
            usRol.get().setRoleId(customerRole.getRoleId());
        }
        return usRol;
    }
}

