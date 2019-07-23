package com.bespinglobal.dcos.ic.api.component;

import com.bespinglobal.dcos.ic.api.service.EmployeeService;
import com.bespinglobal.dcos.ic.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Project : Information-Collector
 * Class : ServiceComponent
 * Version : 2019.07.18 v0.1
 * Created by taehyoung.yim on 2019-07-18.
 * *** 저작권 주의 ***
 */
@Component
public class ServiceComponent {

    private EmployeeService employeeService;
    private PersonService personService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) { this.employeeService = employeeService; }

    @Autowired
    public void setPersonService(PersonService personService) { this.personService = personService; }

    public EmployeeService getEmployeeService() { return employeeService; }
    public PersonService getPersonService()  {return personService; }
}
