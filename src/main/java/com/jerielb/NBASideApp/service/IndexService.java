package com.jerielb.NBASideApp.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {
    private final Logger LOGGER = LogManager.getLogger(IndexService.class);
    
    @Autowired
    public IndexService() {}
}
