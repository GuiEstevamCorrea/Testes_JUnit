package com.example.projetoteste.business;

import com.example.projetoteste.infrastructure.PessoaRepository;
import com.example.projetoteste.infrastructure.entity.Pessoa;
import com.example.projetoteste.infrastructure.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;
import static org.springframework.util.Assert.notNull;

@Service
@Slf4j
public class PessoaService {

    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public List<Pessoa> buscaPessoasPorCpf(String cpf) {
        try {
            notNull(cpf, "Cpf é obrigatório!");

            return repository.findPessoa(cpf);
        } catch (final Exception e) {
            throw new BusinessException(format("Erro ao buscar pessoas por cpf = %s", cpf), e);
        }

    }

}