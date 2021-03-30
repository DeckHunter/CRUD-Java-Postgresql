package Conexao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoBD {
	
	Connection connection = null;
	public void conexao(){
		
        String host="localhost";
        String port="5432";
        String db_name="Projeto_Final";
        String username="postgres";
        String password="";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password+"");
            if (connection != null) {
                System.out.println("Connection OK \n");
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
        	System.out.print("Erro");
        }
	}
	
	public void ExecutarComando(String Sql){
		try {
			PreparedStatement stmt = connection.prepareStatement(Sql);
			stmt.execute();
			
		} catch (SQLException e) {
			System.out.print("Erro => " + e.getMessage());
		}
	}
	
	public void ListarAcademias(String Sql){
		try {
			PreparedStatement stmt = connection.prepareStatement(Sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				String nome = rs.getString("Nome_Academia");
				String local = rs.getString("Local_Academia");
				BigDecimal preço = rs.getBigDecimal("Preço");
				int ID = rs.getInt("ID_Academia");

				System.out.print("\n================================\n");
				System.out.print("#       " +"ID: "+ID+"\n");
				System.out.print("#       " +"Nome: "+nome+" \n");
				System.out.print("#       " +"Local: "+local+"\n");
				System.out.print("#       " +"Preço: R$ "+preço+" \n");
				System.out.print("================================\n");
				
			}
			rs.close();
			
		} catch (SQLException e) {
			System.out.print("Erro");
		}
	}
	public void ListarAlunos(String Sql){
		try {
			PreparedStatement stmt = connection.prepareStatement(Sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				String nome = rs.getString("Nome_Aluno");
				int ID_M = rs.getInt("ID_Academia_Matriculado");
				int ID = rs.getInt("ID_Aluno");
				int ID_Ins = rs.getInt("ID_Meu_Instrutor");
				
				System.out.print("\n================================\n");
				System.out.print("#       " +"ID: "+ID+" \n");
				System.out.print("#       " +"Nome: "+nome+" \n");
				System.out.print("#       " +"ID Academia: "+ID_M+"\n");
				System.out.print("#       " +"ID DO Instrutor: "+ID_Ins+"\n");
				System.out.print("================================\n");
				
			}
			rs.close();
			
		} catch (SQLException e) {
			System.out.print("Erro");
		}
	}
	public void ListarInstrutor(String Sql){
		try {
			PreparedStatement stmt = connection.prepareStatement(Sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				
				String nome = rs.getString("Nome_Instrutor");
				int ID = rs.getInt("ID_Instrutor");
				BigDecimal preço = rs.getBigDecimal("Salario");
				
				System.out.print("\n================================\n");
				System.out.print("#       " +"ID: "+ID+" \n");
				System.out.print("#       " +"Nome: "+nome+"\n");
				System.out.print("#       " +"Salario : R$ "+preço+"\n");
				System.out.print("================================\n");
				
			}
			rs.close();
			
		} catch (SQLException e) {
			System.out.print("Erro");
		}
	}
	public void ListarSupervisor(String Sql){
		try {
			PreparedStatement stmt = connection.prepareStatement(Sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				
				String nome = rs.getString("Nome_Supervisor");
				int ID = rs.getInt("ID_Supervisor");
				int ID_A = rs.getInt("ID_Academia_Trabalha");
				BigDecimal preço = rs.getBigDecimal("Salario");
				
				System.out.print("\n================================\n");
				System.out.print("#       " +"ID: "+ID+"\n");
				System.out.print("#       " +"Nome: "+nome+"\n");
				System.out.print("#       " +"Salario : R$ "+preço+"\n");
				System.out.print("#       " +"ID Da Academia : "+ID_A+"\n");
				System.out.print("================================\n");

			}
			rs.close();
			
		} catch (SQLException e) {
			System.out.print("Erro");
		}
	}
}
