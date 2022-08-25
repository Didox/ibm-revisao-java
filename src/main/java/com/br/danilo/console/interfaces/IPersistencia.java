package com.br.danilo.console.interfaces;

import java.util.List;

public interface IPersistencia {
    public IEntidade getEntidade();
    public void salvar(IEntidade entidade);
    public List<IEntidade> todos();
}
