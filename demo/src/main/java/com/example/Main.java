package com.example;

public class Main {
    public static void main(String[] args) {
        TabelaHash aluno = new TabelaHash();
        aluno.inserirAluno("1", "Lucas");
        aluno.inserirAluno("3", "Kaik");
        aluno.inserirAluno("2", "Isaac");
        aluno.inserirAluno("4", "Ramon");
        aluno.inserirAluno("7", "Hugo");
        aluno.inserirAluno("10", "Alan");
        aluno.inserirAluno("5", "Aniel");
        aluno.inserirAluno("6", "Pedro");
        aluno.inserirAluno("8", "Vinicius");
        aluno.inserirAluno("9", "Fulano");
        aluno.inserirAluno("11", "Cicrano");
        aluno.listar();
    }
}