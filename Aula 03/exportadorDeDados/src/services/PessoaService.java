package services;

import entities.PessoaFisica;
import entities.PessoaJuridica;

public interface PessoaService {

    /**
     * Metodo abstrato para salvar Pessoa Fisica
     * @param pf
     * @throws Exception
     */
    void salvarPessoaFisica(PessoaFisica pf) throws Exception;

    /**
     * Metodo para salvar Pessoa Juridica
     * @param pj
     * @throws Exception
     */
    void salvarPessoaJuridica(PessoaJuridica pj) throws Exception;
}
