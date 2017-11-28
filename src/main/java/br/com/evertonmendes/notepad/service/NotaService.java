package br.com.evertonmendes.notepad.service;

import br.com.evertonmendes.notepad.model.Nota;
import br.com.evertonmendes.notepad.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {
    @Autowired
    NotaRepository notaRepository;

    public void salvar(Nota nota){
        Nota aux = notaRepository.findByTitulo(nota.getTitulo());
        if(aux!=null){
            nota.setId(aux.getId());
        }
        notaRepository.save(nota);
    }

    public List<Nota> buscarTodas(){
        return notaRepository.findAll();
    }

    public Nota buscar(String titulo){
        Nota nota = notaRepository.findByTitulo(titulo);
        if(nota==null){
            return new Nota();
        }else{
            return notaRepository.findByTitulo(titulo);
        }

    }
}
