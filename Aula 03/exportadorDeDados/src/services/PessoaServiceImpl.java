package services;

import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.io.PrintWriter;

public class PessoaServiceImpl implements PessoaService {

    @Override
    public void salvarPessoaFisica(PessoaFisica pf) throws Exception {
        var pw = new PrintWriter("pessoafisica_" + pf.getId() + ".xml");

        pw.write("<?xml version='1.0' encoding='UTF-8'?>");
        pw.write("<pessoafisica>");
            pw.write("<id>" + pf.getId() + "</id>");
            pw.write("<nome>" + pf.getNome() + "</nome>");
            pw.write("<email>" + pf.getEmail() + "</email>");
            pw.write("<telefone>" + pf.getTelefone() + "</telefone>");
            pw.write("<cpf>" + pf.getCpf() + "</cpf>");
            pw.write("<datanascimento>" + pf.getDataNascimento() + "</datanascimento>");
        pw.write("</pessoafisica>");
        pw.close();
    }

    @Override
    public void salvarPessoaJuridica(PessoaJuridica pj) throws Exception {
        var pw = new PrintWriter("pessoajuridica_" + pj.getId() + ".xml");

        pw.write("<?xml version='1.0' encoding='UTF-8'?>");
        pw.write("<pessoajuridica>");
        pw.write("<id>" + pj.getId() + "</id>");
        pw.write("<nome>" + pj.getNome() + "</nome>");
        pw.write("<email>" + pj.getEmail() + "</email>");
        pw.write("<telefone>" + pj.getTelefone() + "</telefone>");
        pw.write("<cnpj>" + pj.getCnpj() + "</cnpj>");
        pw.write("</pessoajuridica>");
        pw.close();
    }
}
