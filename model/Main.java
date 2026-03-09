package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import control.Arquivos;

public class Main {

	public static void main(String[] args) throws IOException {
	
      Scanner ler = new Scanner(System.in);
      Arquivos arquivos = new Arquivos();
      String nome;
      char sexo;
      int idade=-1, id;
      
      int opcao=-1;
      
      while(opcao != 0) {
    	  System.out.println("-------MENU-------");
    	  System.out.println("1- Cadastrar ");
    	  System.out.println("2- Lista ");
    	  System.out.println("3- Buscar Id ");
    	  System.out.println("4- Editar ");
    	  System.out.println("5- Deletar ");
    	  System.out.println("0- Sair ");
    	  
    	  System.out.println("Escolha uma opção: ");
    	  opcao= ler.nextInt();
    	  
    	  
    	  switch(opcao) {
    	  
    	  case 1://Cadastrar usuari0
    		  System.out.println("Digite o nome : ");
    		  ler.nextLine();
    		  nome =ler.nextLine();
    		  while(nome.isEmpty()){
    			  System.out.println("Nome inválido\nDigite um nome válido: ");
    			  nome=ler.nextLine();
    		  }
    		  System.out.println("Digite a idade : ");
    		  idade =ler.nextInt();
    		  while(idade <0) {
    			  System.out.println("Idade Inválida\n Digite uma idade válida: ");
    			  idade=ler.nextInt();
    		  }
    		  System.out.println("Digite o sexo (F/M) : ");
    		  ler.nextLine();
    		  sexo=ler.next().charAt(0);
    		   
    		  arquivos.cadastrarUsuario(nome,idade,sexo);
           break;
    	  
    	  case 2: //Listar usuario
    	  ArrayList<String>lista = arquivos.lerArquivo();
    	  if (lista.isEmpty()){
    		  System.out.println("Nenhum usuario cadastrado !");
    	  }else {
    		  System.out.println("------Lista Atualizada-----");
    		  for( String linha :lista) {
    			  System.out.println(linha);
    			  
    		  }
    	  }
    	  
    	  break;
    	  
    	  case 3://Buscar ID
    		  System.out.println("Digite o ID que deseja buscar : ");
    		  id=ler.nextInt();
    		  ler.nextLine();
    		  
    		  String busca =arquivos.buscarUsuarioporID(id);
    		 if (busca ==null) {
    			 System.out.println("ID não encontrado .");
    		 }else {
    			 System.out.println("ID Encontrado: ");
    			 System.out.println(busca);
    		 }
    		 break;
    		
    		      		  
    	  case 4://Editar usuario
    		  System.out.println("Digite o ID que deseja editar:");
    		  id= ler.nextInt();
    		  ler.nextLine();
    		  
    		  String usuario= arquivos.buscarUsuarioporID(id);
    		  
    		  if (usuario ==null) {
    			  System.out.println("Usuario não encontrado !");
    			  break;
    			  
    		  }
    		  System.out.println("Dados atuais: ");
    		  System.out.println(usuario);
    		  
    		  System.out.println("Digite o nome :");
    		  nome =ler.nextLine();
    		  
    		  System.out.println("Digite a idade :");
    		  idade=ler.nextInt();
    		  ler.nextLine();
    		  System.out.println("Digite o sexo :");
    		  sexo=ler.next().charAt(0);
    		  
    		  arquivos.atualizarUsuario(id, nome, idade, sexo);
    		  
    		 break;
    	  
    	  case 5://Deletar usuario
    		  System.out.println("Digite o ID que deseja deletar :");
    	      id= ler.nextInt();
    	  
    	  boolean resultado= arquivos.deletarUsuario(id);
    	  if(resultado) {
    		  System.out.println("Usuario deletado com sucesso !");
    		  	 
    	  } else {
    		  System.out.println("ID não encotrado ");
    	  }
    	  break;
    	  
    	  case 0:System.out.println("Programa Encerrado");
    	  break;
    	  
    	  default: System.out.println("Opção Inválida !");
    	  
    	  }
    	  
      } ler.close();
      
       
	}
	

}
