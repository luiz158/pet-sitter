package com.ps.repos.impl;

import com.ps.base.RequestStatus;
import com.ps.ents.Request;
import com.ps.ents.User;
import com.ps.repos.RequestRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;
//import javax.inject.Qualifier;
import javax.sql.DataSource;
import java.util.Set;

/**
 * Created by iuliana.cosmina on 3/21/16.
 */
@Named("requestRepo")
@Description("This is not the bean you are looking for")
public class JdbcRequestRepo extends JdbcAbstractRepo<Request> implements RequestRepo {
    private Logger logger = LoggerFactory.getLogger(JdbcRequestRepo.class);

    @PostConstruct
    private void init(){
        logger.info(" ... initializing requestRepo ...");
    }

    @PreDestroy
    private void destroy(){
        logger.info(" ... destroying requestRepo ...");
    }

    public JdbcRequestRepo() {
    }

    @Inject
    public JdbcRequestRepo(@Named("dataSource") DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public Set<Request> findAllForUser(User user) {
        return null;
    }

    @Override
    public Set<Request> findByStatus(RequestStatus status) {
        return null;
    }
}
