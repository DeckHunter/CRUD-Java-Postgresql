package Principal;

import java.math.BigDecimal;
import java.util.Scanner;

import Conexao.ConexaoBD;

public class Controle {
	
	static ConexaoBD JDBC = new ConexaoBD();
	static ConexaoBD connecte = new ConexaoBD();
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		JDBC.conexao();	
		
		boolean FinalizarCessão = false;
		
		while (FinalizarCessão == false){
			
			System.out.print("=============================================\n");
			System.out.print(" 1 - Adicionar Academia \n");
			System.out.print(" 2 - Adicionar Aluno \n");
			System.out.print(" 3 - Adicionar Instrutor \n");
			System.out.print(" 4 - Adicionar Supervisor \n");
			System.out.print("=============================================\n");
			System.out.print(" 5 - Listar Academias \n");
			System.out.print(" 6 - Listar Alunos \n");
			System.out.print(" 7 - Listar Supervisores \n");
			System.out.print(" 8 - Listar Instrutores \n");
			System.out.print("=============================================\n");
			System.out.print(" 9 - Remover Academia \n");
			System.out.print("10 - Remover Aluno \n");
			System.out.print("11 - Remover Supervisor \n");
			System.out.print("12 - Remover Instrutor \n");
			System.out.print("=============================================\n");
			System.out.print("13 - Editar Academia \n");
			System.out.print("14 - Editar Aluno \n");
			System.out.print("15 - Editar Supervisor \n");
			System.out.print("16 - Editar Instrutor \n");
			System.out.print("\n 0 - Sair  \n");
			System.out.print("=============================================\n");
			
			Scanner comando = new Scanner(System.in);
			String valor_Escolhido = comando.nextLine();
			
			switch (valor_Escolhido) {
			case "0": {
				System.out.print("\n Ate Mais \n");
				FinalizarCessão = true;
				break;
			}
			case "1": {
				
				System.out.print("\n Nome: ");
				Scanner nomeAc = new Scanner(System.in);
				String nomeAcademia = nomeAc.nextLine();
				
				System.out.print("\n Local: ");
				Scanner localAc = new Scanner(System.in);
				String localAcademia = localAc.nextLine();
				
				System.out.print("\n Preço: ");
				Scanner preçoAc = new Scanner(System.in);
				BigDecimal PreçoAcademia = preçoAc.nextBigDecimal();
				
				System.out.print("\n ID: ");
				Scanner IDAc = new Scanner(System.in);
				int IDAcademia = IDAc.nextInt();
				
				String sql = "INSERT INTO ACADEMIA"+"(Nome_Academia, Local_Academia, Preço, ID_Academia)"
							+"VALUES"+"("+ "'" +nomeAcademia + "'" + "," + "'" +localAcademia + "'" 
							+"," + PreçoAcademia + "," + IDAcademia +")";
				
				JDBC.ExecutarComando(sql);
				
				System.out.print("\n Academia Adicionada \n");
				break;
			}
			case "2": {
				
				System.out.print("\n Nome: ");
				Scanner nomeAl = new Scanner(System.in);
				String nomeAluno = nomeAl.nextLine();
				
				System.out.print("\n ID: ");
				Scanner IDAl = new Scanner(System.in);
				int IDAluno = IDAl.nextInt();
				
				System.out.print("\n ID Da Academia: ");
				Scanner IDAcm = new Scanner(System.in);
				int IDAcademiaMatriculado = IDAcm.nextInt();
				
				System.out.print("\n ID Instrutor: ");
				Scanner IDIns = new Scanner(System.in);
				int IDMeuInstrutor = IDIns.nextInt();
				
				
				String sql = "INSERT INTO ALUNO"+"(Nome_Aluno,ID_Aluno,ID_Academia_Matriculado,ID_Meu_Instrutor)"
						+"VALUES"+"("+ "'" +nomeAluno+ "'"  
						+","+IDAluno+","+IDAcademiaMatriculado+","+IDMeuInstrutor+")";
			
				JDBC.ExecutarComando(sql);
				System.out.print("\n Aluno Adicionado \n");
				break;
			}
			case "3": {
				
				
				System.out.print("\n Nome Instrutor: ");
				Scanner nomeIn = new Scanner(System.in);
				String nomeInstrutor = nomeIn.nextLine();
				
				System.out.print("\n ID Instrutor: ");
				Scanner IDIn = new Scanner(System.in);
				int IDInstrutor = IDIn.nextInt();
		
				System.out.print("\n Salario Instrutor: ");
				Scanner salarioIN = new Scanner(System.in);
				BigDecimal SalarioInstrutor = salarioIN.nextBigDecimal();
				
				
				String sql = "INSERT INTO INSTRUTOR"+"(Nome_Instrutor, ID_Instrutor,Salario)"+"VALUES"+"("+ "'" 
							+nomeInstrutor+ "'" + ","
							+IDInstrutor+ "," +SalarioInstrutor+")";
				JDBC.ExecutarComando(sql);
				
				System.out.print("\n Instrutor Adicionado \n");
				break;
			}
			case "4": {
				
				System.out.print("\n Nome Supervisor: ");
				Scanner nomeSP = new Scanner(System.in);
				String nomeSupervisor = nomeSP.nextLine();
				
				System.out.print("\n ID Supervisor: ");
				Scanner IDSP = new Scanner(System.in);
				int IDSupervisor = IDSP.nextInt();
		
				System.out.print("\n ID Da Academia: ");
				Scanner ID_A_SP = new Scanner(System.in);
				int ID_Academia_Supervisor = ID_A_SP.nextInt();
				
				System.out.print("\n Salario Supervisor: ");
				Scanner salarioSP = new Scanner(System.in);
				BigDecimal SalarioSupervisor = salarioSP.nextBigDecimal();
				
				String sql = "INSERT INTO SUPERVISOR"+"(Nome_Supervisor,ID_Supervisor,ID_Academia_Trabalha,Salario)"
						+"VALUES"+"("+ "'" 
						+nomeSupervisor+ "'" + ","
						+IDSupervisor+ "," +ID_Academia_Supervisor+","+SalarioSupervisor+")";
				JDBC.ExecutarComando(sql);

				System.out.print("\n Supervisor Adicionado \n");
				break;
			}
			case "5": {
				
				String sql = "SELECT * FROM ACADEMIA ORDER BY Nome_Academia ASC";
				JDBC.ListarAcademias(sql);

				
				System.out.print("\n Lista De Academias \n");
				break;
			}
			
			case "6": {
				
				String sql = "SELECT * FROM ALUNO ORDER BY Nome_Aluno ASC";
				JDBC.ListarAlunos(sql);

				System.out.print("\n Lista De Alunos \n");
				break;
			}
			case "7": {
				
				String sql = "SELECT * FROM SUPERVISOR ORDER BY Nome_Supervisor ASC";
				JDBC.ListarSupervisor(sql);
				
				System.out.print("\n Lista De Supervisores \n");
				break;
			}
			case "8": {
				
				String sql = "SELECT * FROM INSTRUTOR ORDER BY Nome_Instrutor ASC";
				JDBC.ListarInstrutor(sql);
				
				System.out.print("\n Lista De Instrutores \n");
				break;
			}
			case "9": {
				
				System.out.print("\n Remover \n");
				System.out.print("\n ID : ");
				Scanner IDAc = new Scanner(System.in);
				int IDAcademia = IDAc.nextInt();
				
				String sql = "DELETE " + "FROM ACADEMIA WHERE ID_Academia =" + IDAcademia;
				JDBC.ExecutarComando(sql);
	
				System.out.print("\n Academia Removida \n");
				break;
				
			}
			case "10": {
				
				System.out.print("\n ID: ");
				Scanner IDAl = new Scanner(System.in);
				int IDAluno = IDAl.nextInt();
				
				String sql = "DELETE " + "FROM ALUNO WHERE ID_ALUNO =" + IDAluno;
				JDBC.ExecutarComando(sql);
				
				System.out.print("\n Aluno Removido \n");
				break;
			}
			case "11": {
				
				System.out.print("\n ID Supervisor: ");
				Scanner IDSP = new Scanner(System.in);
				int IDSupervisor = IDSP.nextInt();
				
				String sql = "DELETE " + "FROM SUPERVISOR WHERE ID_Supervisor =" + IDSupervisor;
				JDBC.ExecutarComando(sql);
				
				System.out.print("\n Supervisor Removido \n");
				break;
			}
			case "12": {	
				
				System.out.print("\n Remover \n");
				System.out.print("\n ID : ");

				Scanner IDIn = new Scanner(System.in);
				int IDInstrutor = IDIn.nextInt();
				
				String sql = "DELETE " + "FROM INSTRUTOR WHERE ID_Instrutor =" + IDInstrutor;
				JDBC.ExecutarComando(sql);
	
				System.out.print("\n Instrutor Removido \n");
				break;
			}
			case "13": {
				
				System.out.print("\n ID: ");
				Scanner IDAc = new Scanner(System.in);
				int IDAcademia = IDAc.nextInt();
				
				System.out.print("\n Faça As Alteracoes Desejadas: ");
				
				System.out.print("\n Alterar Nome: ");
				Scanner nomeAc = new Scanner(System.in);
				String nomeAcademia = nomeAc.nextLine();
				
				System.out.print("\n Alterar Local: ");
				Scanner localAc = new Scanner(System.in);
				String localAcademia = localAc.nextLine();
				
				System.out.print("\n Alterar Preço: ");
				Scanner preçoAc = new Scanner(System.in);
				BigDecimal PreçoAcademia = preçoAc.nextBigDecimal();
				
				String sql = 
						"UPDATE ACADEMIA SET "+
						"Nome_Academia="+"'" + nomeAcademia +"'"+","+
						"Local_Academia="+ "'" + localAcademia+"'"+","+
						"Preço="+PreçoAcademia +
						"WHERE ID_Academia="+IDAcademia;
				
				JDBC.ExecutarComando(sql);
				System.out.print("\n Academia Alterada Com Sucesso \n");
				break;
			}
			case "14": {
				
				System.out.print("\n ID: ");
				Scanner IDAl = new Scanner(System.in);
				int IDAluno = IDAl.nextInt();
				
				System.out.print("\n Faça As Alteracoes Desejadas: ");
				
				System.out.print("\n Alterar Nome Aluno: ");
				Scanner nomeAl = new Scanner(System.in);
				String nomeAluno = nomeAl.nextLine();

				System.out.print("\n Alterar ID Academia: ");
				Scanner IDAcm = new Scanner(System.in);
				int IDAcademiaMatriculado = IDAcm.nextInt();
				
				System.out.print("\n Alterar Instrutor ID Instrutor: ");
				Scanner IDIns = new Scanner(System.in);
				int IDMeuInstrutor = IDIns.nextInt();
				
				String sql = 
						"UPDATE ALUNO SET "+
						"Nome_Aluno="+"'" + nomeAluno +"'"+","+
						"ID_Academia_Matriculado="+ IDAcademiaMatriculado+","+
						"ID_Meu_Instrutor="+IDMeuInstrutor+
						"WHERE ID_Aluno="+IDAluno;
				JDBC.ExecutarComando(sql);
				
				System.out.print("\nAluno Alterado Com Sucesso \n");
				break;
			}
			case "15": {
				
				System.out.print("\n ID Supervisor: ");
				Scanner IDSP = new Scanner(System.in);
				int IDSupervisor = IDSP.nextInt();
				
				System.out.print("\n Faça As Alteracoes Desejadas: ");
				
				System.out.print("\n Alterar Nome Supervisor: ");
				Scanner nomeSP = new Scanner(System.in);
				String nomeSupervisor = nomeSP.nextLine();
		
				System.out.print("\n Alterar ID Da Academia: ");
				Scanner ID_A_SP = new Scanner(System.in);
				int ID_Academia_Supervisor = ID_A_SP.nextInt();
				
				System.out.print("\n Alterar Salario Supervisor: ");
				Scanner salarioSP = new Scanner(System.in);
				BigDecimal SalarioSupervisor = salarioSP.nextBigDecimal();
				
				String sql = 
						"UPDATE SUPERVISOR SET "+
						"Nome_Supervisor="+"'" + nomeSupervisor +"'"+","+
						"ID_Academia_Trabalha="+ ID_Academia_Supervisor+","+
						"Salario="+SalarioSupervisor+
						"WHERE ID_Supervisor="+IDSupervisor;
				JDBC.ExecutarComando(sql);
				
				System.out.print("\nSupervisor Alterado Com Sucesso \n");
				break;
			}
			case "16": {
				
				System.out.print("\n ID Instrutor: ");
				
				Scanner IDIn = new Scanner(System.in);
				int IDInstrutor = IDIn.nextInt();
				
				System.out.print("\n Faça As Alteracoes Desejadas: ");
				
				System.out.print("\n Alterar Nome Instrutor: ");
				Scanner nomeIn = new Scanner(System.in);
				String nomeInstrutor = nomeIn.nextLine();
				
				System.out.print("\n Alterar Salario Instrutor: ");
				Scanner salarioIN = new Scanner(System.in);
				BigDecimal SalarioInstrutor = salarioIN.nextBigDecimal();
				
				String sql = 
						"UPDATE INSTRUTOR SET "+
						"Nome_Instrutor="+"'" + nomeInstrutor +"'"+","+
						"Salario="+SalarioInstrutor+
						"WHERE ID_Instrutor="+IDInstrutor;
				
				JDBC.ExecutarComando(sql);
				
				System.out.print("\nInstrutor Alterado Com Sucesso \n");
				break;
			}
			default:
				System.out.print("\n Erro : Comando " + "'" + valor_Escolhido + "'" +" Invalido \n\n");
				break;
			}
			
		}
	}	
}
