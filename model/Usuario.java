package model;

public class Usuario {
   private String nome;
   public String getNome() {
	return nome;
}

   public void setNome(String nome) {
	this.nome = nome;
   }

   public int getIdade() {
	return idade;
   }

   public void setIdade(int idade) {
	this.idade = idade;
   }

   public char getSexo() {
	return sexo;
   }

   public void setSexo(char sexo) {
	this.sexo = sexo;
   }
   
   public void apresentar() {
	   System.out.println(nome);
	   System.out.println(idade);
	   System.out.println(sexo);
   }
   

   private int idade;
   private char sexo;
   
   public Usuario (String nome,int idade,char sexo) {
	   this.nome=nome;
	   this.idade=idade;
	   this.sexo=sexo;
   }
}
