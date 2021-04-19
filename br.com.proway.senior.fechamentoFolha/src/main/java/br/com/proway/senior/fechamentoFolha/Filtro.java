package br.com.proway.senior.fechamentoFolha;

public class Filtro {	
	
	/**
	 * Filtra os Colaboradores por e-mail
	 * 
	 * Recebe os par�metros para verficar se o Colaborador existe e o retorna
	 * 
	 * @param email; referente ao Colaborador que o usu�rio deseja saber sobre 
	 * @param cadastro; lista de todos os colaboradores cadastrados
	 * 
	 * @return Colaborador/null Colaborador desejado/Colaborador n�o existe
	 */	
	static public Colaborador filtro(String email, CadastroColaborador cadastro) { 
		for(Colaborador c : cadastro.getColaboradores()) {
			if(c.getEmail() == email) {				
				return c; 
			}
		}
		return null;  
	}

	/**
	 * Filtra os Colaboradores por ID
	 * 
	 * Recebe os par�metros para verficar se o Colaborador existe e o retorna 
	 * 
	 * @param userId; ID referente ao Colaborador que o usu�rio deseja saber sobre 
	 * @param cadastro; lista de todos os colaboradores cadastrados
	 * 
	 * @return Colaborador/null Colaborador desejado/Colaborador n�o existe
	 */	
	static public Colaborador filtro(int userId, CadastroColaborador cadastro) {
		for(Colaborador c : cadastro.getColaboradores()) {
			if(c.getId() == userId) {			
				return c;
			}
		}
		return null;
	}
	
	/**
	 * Filtra as Folhas de determinado Colaborador por ID
	 * 
	 * Recebe os par�metros para verficar se a Folha de determinado Colaborador existe e a retorma 
	 * 
	 * @param c; Colaborador dono da folha
	 * @param idFolha; ID da Folha desejada
	 * 
	 * @return Folha/null Folha desejado/Folha n�o existe
	 */		
	static public FolhaProvisoria filtro(Colaborador c, int idFolha) {
		for(FolhaProvisoria folhaProvisoria : c.getTotalFolhas()) {
			if(folhaProvisoria.getId() == idFolha) {
				return folhaProvisoria;
			}
		}
		return null;  
	}
	
	/**
	 * Filtra as Folhas de determinado Colaborador por data
	 * 
	 * Recebe os par�metros para verficar se a Folha de determinado Colaborador existe e a retorma 
	 * 
	 * @param c; Colaborador Dono da folha
	 * @param data; Data da Folha desejada
	 * 
	 * @return Folha/null Folha desejado/Folha n�o existe
	 */	
	static public FolhaProvisoria filtro(Colaborador c, String data) {
		for(FolhaProvisoria folhaProvisoria : c.getTotalFolhas()) {
			if(data == folhaProvisoria.getData()) {			
				return folhaProvisoria;
			}
		}
		return null;
	}
	
}