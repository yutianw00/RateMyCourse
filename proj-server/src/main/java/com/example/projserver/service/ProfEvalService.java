package com.example.projserver.service;

import com.example.projserver.entity.ProfEval;

import java.util.List;

public interface ProfEvalService {
    boolean addProfEval(ProfEval profEval);

    List<ProfEval> getAllProfEvals();

    List<ProfEval> getProfEvalsWithUser(String user);

    boolean deleteProfEval(int id);

    boolean editProfEval(ProfEval profEval);
}
