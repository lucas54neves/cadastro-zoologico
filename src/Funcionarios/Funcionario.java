package Funcionarios;

import java.util.*;

public class Funcionario {
    private final String mCpf;
    private final String mNome;
    private final String mSexo;
    private final Date mDataAdminicao;
    private String mFuncao;

    public Funcionario(String mCpf, String mNome, String mSexo, Date mDataAdminicao, String mFuncao) {
        this.mCpf = mCpf;
        this.mNome = mNome;
        this.mSexo = mSexo;
        this.mDataAdminicao = mDataAdminicao;
        this.mFuncao = mFuncao;
    }
    
    public String getCpf() {
        return mCpf;
    }

    public String getNome() {
        return mNome;
    }

    public String getSexo() {
        return mSexo;
    }

    public Date getDataAdminicao() {
        return mDataAdminicao;
    }

    public String getFuncao() {
        return mFuncao;
    }

    public void setFuncao(String novaFuncao) {
        this.mFuncao = novaFuncao;
    }
}
