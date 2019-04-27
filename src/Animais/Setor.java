package Animais;

import Animais.*;
import Funcionarios.*;

public class Setor {
    private final Animal mAnimais;
    private Funcionario mResponsavel;
    private final String mSetor;

    public Setor(Animal mAnimais, Funcionario mResponsavel, String mSetor) {
        this.mAnimais = mAnimais;
        this.mResponsavel = mResponsavel;
        this.mSetor = mSetor;
    }

    public Animal getAnimais() {
        return mAnimais;
    }

    public Funcionario getResponsavel() {
        return mResponsavel;
    }

    public String getSetor() {
        return mSetor;
    }

    public void setResponsavel(Funcionario novoResponsavel) {
        this.mResponsavel = novoResponsavel;
    }
}