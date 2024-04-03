package listas_lineares;

public class TesteListaCircular {

	public static void main(String[] args) {
		 ListaCircular lista = new ListaCircular();
	        
		 lista.inserirInicio(8);
		 lista.inserirInicio(5);
		 lista.inserirInicio(4);
	        
	     System.out.println(lista.mostrarLista());
	     
	     System.out.println("Lista apos valor removido");
	     lista.deleteComValor(5);
	     System.out.println(lista.mostrarLista());
	        

	}

}
