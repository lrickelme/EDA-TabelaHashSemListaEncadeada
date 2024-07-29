package com.example;

public class TabelaHash {
    private Aluno[] tabela = new Aluno[10];
    private final Aluno Deleted = new Aluno("Deleted", "-1");
    private Aluno elemento;

    public TabelaHash() {
    }

    private int calcularHash(String matricula) {
        return Integer.parseInt(matricula) % tabela.length;
    }

    public String pegarValor(String matricula) {
        int hash = calcularHash(matricula);
        for (int i = hash; i < tabela.length; i++) {
            elemento = tabela[i];
            if (elemento != null && elemento.getMatricula().equals(matricula)) {
                return elemento.getNome();
            }
        }
        return "Aluno não existe";
    }

    public void inserirAluno(String matricula, String nome) {
        Aluno aluno = new Aluno(nome, matricula);
        int hash = calcularHash(matricula);
        if (!estaCheia()) {
            if (tabela[hash] == null || tabela[hash] == Deleted) {
                tabela[hash] = aluno;
            } else {
                while (tabela[hash] != null && tabela[hash] != Deleted) {
                    hash = (hash + 1) % tabela.length;
                }
                tabela[hash] = aluno;
            }
        } else {
            redimensionar();
            inserirAluno(matricula, nome);
        }
    }

    private boolean estaCheia() {
        int contador = 0;
        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] != null && tabela[i] != Deleted) {
                contador++;
            }
        }
        return contador == tabela.length;
    }

    public boolean removerValor(String matricula) {
        int hash = calcularHash(matricula);
        for (int i = hash; i < tabela.length; i++) {
            elemento = tabela[i];
            if (elemento != null && elemento != Deleted && elemento.getMatricula().equals(matricula)) {
                tabela[i] = Deleted;
                return true;
            }
        }
        return false;
    }

    private void redimensionar() {
        Aluno[] tabelaAntiga = tabela;
        tabela = new Aluno[tabelaAntiga.length * 2];

        for (Aluno aluno : tabelaAntiga) {
            if (aluno != null && aluno != Deleted) {
                inserirAluno(aluno.getMatricula(), aluno.getNome());
            }
        }
    }

    public void mostrar() {
        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] != null && tabela[i] != Deleted) {
                System.out.println(tabela[i].getNome());
            } else {
                System.out.println("Vazio");
            }
        }
    }
}
