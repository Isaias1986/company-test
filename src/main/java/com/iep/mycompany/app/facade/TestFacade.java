package com.iep.mycompany.app.facade;

import com.iep.commons.facade.BaseFacade;
import com.iep.mycompany.app.domain.entity.Test;
import com.iep.mycompany.app.domain.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestFacade extends BaseFacade<Test> {

    private final TestRepository repository;

    @Autowired
    protected TestFacade(TestRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
