package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;

import model.Usuario;

public class Arquivos {
 public Arquivos() {
	 
 }
 
 
        public ArrayList<String> lerArquivo() throws IOException {
        	ArrayList<String> linhas = new ArrayList<String>();
        	File arquivo = new File("cadastro.txt");

        	if (!arquivo.exists()) {
        	    arquivo.createNewFile();
        	}
        	InputStream is = new FileInputStream("cadastro.txt");
        	InputStreamReader isr = new InputStreamReader(is);
        	BufferedReader br = new BufferedReader(isr);
        	
        	String linha= br.readLine();
        	while(linha != null){
        		
        		linhas.add(linha);
        		linha = br.readLine();
        		
        	}
        	
        	is.close();
        	isr.close();
        	br.close();
        	
        	
			return linhas;
        }
        public void reescreverArquivo(ArrayList<String> linhas) throws IOException {
        	OutputStream os =new FileOutputStream("cadastro.txt");//  atualizar e salva.
            OutputStreamWriter osw = new OutputStreamWriter(os);
        	BufferedWriter bw = new BufferedWriter(osw);
        	
        	for(int i =0; i< linhas.size(); i++) { 
        		
        		bw.write(linhas.get(i));
        		bw.newLine();
        	}
               bw.close();
               osw.close();
               os.close();
                
               
              
        }
        public boolean atualizarUsuario(int id, String nome, int idade, char sexo) throws IOException {
        	ArrayList<String> linhas= lerArquivo();
        	boolean encontrado=false;
        	for (int i =0; i < linhas.size();i ++) {
        		if (linhas.get(i).startsWith(id+",")) {
        			
        		String novoUsuario =id+","+nome+","+idade+","+sexo;
        		linhas.set(i,novoUsuario);
        		
        		encontrado= true;
        		break;
        			
        		}
				
			}
        	if(encontrado) {
        		reescreverArquivo(linhas);
        		 System.out.println("Usuario atualizado com sucesso!");
        	} else {
        		 System.out.println("ID não encontrado !");
        	}
        	return encontrado;
        	
        }
         
        public boolean deletarUsuario(int id) throws IOException {
        	ArrayList<String> linhas =lerArquivo();
        	boolean encontrado=false;
        	for(int i =0; i< linhas.size(); i++) {
        	
        		if (linhas.get(i).startsWith(id+",")) {
        			linhas.remove(i);
        			encontrado=true;
        			break;
        				
        		}
        		
        	} if(encontrado) {
        		reescreverArquivo(linhas);
        	} return encontrado;
        	
        }
        
        public String buscarUsuarioporID (int id ) throws IOException {
        	ArrayList<String> linhas =lerArquivo();
        	
        	for (String linha : linhas) {
        		if(linha.startsWith(id+",")) {
        			return linha;
        		}
        		
				
			} 
        	return null;
        } 
        
        
        
        
        public int gerarID() throws IOException {
        	
        	BufferedReader br= new BufferedReader(new FileReader("cadastro.txt"));
        	
        	String linha;
        	int ultimoID= 0;
        	
        	while((linha = br.readLine()) !=null) {
        	
        		String[] partes= linha.split(",");
        		int id= Integer.parseInt(partes[0]);
        		
        		if(id>ultimoID) {
        			ultimoID=id;
        		}	
        		
        	}
        	br.close();
        	return ultimoID +1;   
        }

		public void cadastrarUsuario(String nome, int idade, char sexo) throws IOException {
			
			ArrayList<String> linhas =lerArquivo(); //ler
			int novoID= 1;
			
			if(!linhas.isEmpty()) { //"Se a lista NÃO estiver vazia"
				
				String ultimaLinha= linhas.get(linhas.size()-1);
				String [] partes = ultimaLinha.split(","); //divide a String usando vírgula.
				
				int ultimoId = Integer.parseInt(partes[0]);
				
			novoID= ultimoId +1;
			
			}
			String novoUsuario=novoID+","+nome+","+idade+","+sexo;
			
			linhas.add(novoUsuario);
			reescreverArquivo(linhas);
			System.out.println("Novo usuario Cadastrado com sucesso ! ID : "+ novoID);
			
			
				
			
		}
        	 
			
        	}
      
        	    
        	
	
        	
        

		
			
			
			
        


