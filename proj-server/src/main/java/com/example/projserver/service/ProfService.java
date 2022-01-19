package com.example.projserver.service;

import com.example.projserver.entity.Course;
import com.example.projserver.entity.Prof;

import java.util.List;

public interface ProfService {
    boolean addProf(Prof prof);

    List<Prof> getAllProfs();

    boolean deleteProf(int id);

    boolean editProf(Prof prof);
}
