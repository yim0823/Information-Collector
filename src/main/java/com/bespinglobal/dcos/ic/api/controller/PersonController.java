package com.bespinglobal.dcos.ic.api.controller;

import com.bespinglobal.dcos.ic.api.component.ServiceComponent;
import com.bespinglobal.dcos.ic.api.response.ApiResponseDto;
import com.bespinglobal.dcos.ic.api.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Project : Information-Collector
 * Class : PersonController
 * Version : 2019.07.16 v0.1
 * Created by taehyoung.yim on 2019-07-16.
 * *** 저작권 주의 ***
 */
@RestController
@RequestMapping("persons")
public class PersonController {

    private ServiceComponent service;

    @Autowired
    public void setServiceComponent(ServiceComponent service) { this.service = service; }

    @GetMapping
    public ApiResponseDto<PersonDto.ResponseList> findAll() {
        return ApiResponseDto.createOK(new PersonDto.ResponseList(service.getPersonService().findAll()));
    }

    @GetMapping("{id}")
    public ApiResponseDto<PersonDto.ResponseOne> findById(@PathVariable("id") Long id) {
        return ApiResponseDto.createOK(new PersonDto.ResponseOne(service.getPersonService().findById(id)));
    }

    @PostMapping
    public ApiResponseDto<PersonDto.ResponseOne> add(@RequestBody @Valid PersonDto.Create create) {
        return ApiResponseDto.createOK(new PersonDto.ResponseOne(service.getPersonService().add(create)));
    }

    @DeleteMapping("{id}")
    public ApiResponseDto delete(@PathVariable("id") Long id) {
        service.getPersonService().delete(id);

        return ApiResponseDto.DEFAULT_OK;
    }

    @PutMapping("{id}")
    public ApiResponseDto<PersonDto.ResponseOne> update(@PathVariable("id") Long id, @Valid @RequestBody PersonDto.Update update) {
        return ApiResponseDto.createOK(new PersonDto.ResponseOne(service.getPersonService().update(id, update)));
    }
}
