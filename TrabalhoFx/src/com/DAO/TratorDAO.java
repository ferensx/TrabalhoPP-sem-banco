package com.DAO;


import java.util.List;


import com.Entity.Trator;


public class TratorDAO {
	 public Trator inserirTrator(Trator trator) {
		    Trator tratorInserir  = new Trator();
	        tratorInserir.setMarca(trator.getMarca());
	        tratorInserir.setModelo(trator.getModelo());
	        tratorInserir.setAno(trator.getAno());
	        return tratorInserir;
	    }


	    public Trator findByModelo(String modelo, List<Trator> listaTrator) {
	        for (int i = 0; i < listaTrator.size(); i++) {
	            if(listaTrator.get(i).getModelo().equals(modelo)) {
	                return listaTrator.get(i);
	            }
	        }
	        return null;
	    }
	    public void Alterar(Trator produto, String modelo, List<Trator> listaTrator) {
	        for (int i = 0; i < listaTrator.size(); i++) {
	            if(listaTrator.get(i).getModelo().equals(modelo)) {
	                listaTrator.set(i, produto);
	            }
	        }
	    }
	    public void Deletar(String modelo, List<Trator> listaTrator) {
	        for (int i = 0; i < listaTrator.size(); i++) {
	            if(listaTrator.get(i).getModelo().equals(modelo)) {
	                listaTrator.remove(i);
	            }
	        }
	    }
	

}



