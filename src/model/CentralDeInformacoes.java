package model;

import java.util.ArrayList;
import java.util.List;

import entity.Canal;
import entity.Programa;
import entity.Usuario;

public class CentralDeInformacoes {

	private List<Programa> todosOsProgramas = new ArrayList<Programa>();
	private List<Canal> todosOsCanais = new ArrayList<Canal>();
	private List<Usuario> todosOsUsuarios = new ArrayList<Usuario>();
	private List<Programa> todasAsAgendas = new ArrayList<>();

	/**
	 * Metodo utilizado para salvar um programa
	 * @param programa
	 * @return
	 */
	public boolean adicionarProgramaDeTV(Programa programa) {
		Programa programas = this.recuperarProgramaDeTVporId(programa.getId());

		if (programas != null) {
			return false;
		}
		this.todosOsProgramas.add(programa);
		return true;
	}
	
	/**
	 * Metodo utilizado para recuperar um programa com busca no ID
	 * @param id
	 * @return
	 */

	public Programa recuperarProgramaDeTVporId(long id) {
		for (int i = 0; i < todosOsProgramas.size(); i++) {
			if (todosOsProgramas.get(i).getId() == id) {
				return todosOsProgramas.get(i);
			}
		}
		return null;
	}

	/**
	 * Metodo utilizado para excluir Programa
	 * @param programa
	 * @return
	 */
	public boolean excluirPrograma(Programa programa) {
		if (todosOsProgramas.contains(programa)) {
			todosOsProgramas.remove(programa);
			return true;
		}
		return false;
	}

	/**
	 * Metodo utilizado para salvar um canal
	 * @param canal
	 * @throws Exception
	 */
	public void salvarCanal(Canal canal) throws Exception {
		Canal canalNome = this.recuperarCanal(canal.getNome());
		if (canalNome != null) {
			throw new Exception("Já Existe Um Canal Com Este Nome!");
		}
		todosOsCanais.add(canal);
	}

	/**
	 * Metodo utiliazdo para recuperar um canal
	 * @param nome
	 * @return
	 */
	public Canal recuperarCanal(String nome) {
		for (int i = 0; i < todosOsCanais.size(); i++) {
			if (todosOsCanais.get(i).getNome().equals(nome)) {
				return todosOsCanais.get(i);
			}
		}
		return null;
	}

	/**
	 * Metodo para excluir um canal com busca no ID
	 * @param canal
	 * @return
	 */
	public boolean excluirCanal(Canal canal) {
		if (todosOsCanais.contains(canal)) {
			todosOsCanais.remove(canal);
			return true;
		}
		return false;
	}

	/**
	 * recuperar Canal por ID
	 * @param id
	 * @return
	 */
	public Canal recuperarCanalId(long id) {
		for (int i = 0; i < todosOsCanais.size(); i++) {
			if (todosOsCanais.get(i).getId() == id) {
				return todosOsCanais.get(i);
			}
		}
		return null;
	}

	/**
	 * Metodo utilizado para salvar Usuario
	 * @param usuario
	 * @return
	 */
	public boolean salvarUsuario(Usuario usuario) {
		for (int i = 0; i < todosOsUsuarios.size(); i++) {
			if (todosOsUsuarios.get(i).getNome().equals(usuario.getNome())) {
				return false;
			}
		}
		todosOsUsuarios.add(usuario);
		return true;
	}
	
	/**
	 * Metodo utilizado para recuperar Usuario pelo o nome
	 * @param nome
	 * @return
	 */

	public Usuario recuperarUsuario(String nome) {
		for (int i = 0; i < todosOsUsuarios.size(); i++) {
			if (todosOsUsuarios.get(i).getNome().equals(nome)) {
				return todosOsUsuarios.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Excluir Usuario 
	 * @param usuario
	 * @return
	 */

	public boolean excluirUsuario(Usuario usuario) {
		if (todosOsUsuarios.contains(usuario)) {
			todosOsUsuarios.remove(usuario);
			return true;
		}
		return false;
	}

	/**
	 * verificação de login.
	 * @param email
	 * @param senha
	 * @return
	 */
	public boolean isLogin(String email, String senha) {
		for (int i = 0; i < todosOsUsuarios.size(); i++) {
			if (todosOsUsuarios.get(i).getEmail().equals(email) && todosOsUsuarios.get(i).getSenha().equals(senha)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo utilizado para adicionar Agenda.
	 * @param AdicionarprogramaDeTV
	 * @return
	 */

	public boolean AdicionarAgenda(Programa programaDeTV) {
		for (int i = 0; i < todasAsAgendas.size(); i++) {
			if (todasAsAgendas.get(i).getId() == programaDeTV.getId()) {
				return false;
			}
		}
		todasAsAgendas.add(programaDeTV);
		return true;
	}
	/**
	 * Excluir Agenda
	 * @param excluirAgenDa
	 * @return
	 */

	public boolean excluirAgenda(Programa programaDeTV) {
		if (todasAsAgendas.contains(programaDeTV)) {
			todasAsAgendas.remove(programaDeTV);
			return true;
		}
		return false;
	}
	/**
	 * Recuperar Agenda por ID
	 * @param id
	 * @return
	 */
	public Programa recuperarAgenda(long id) {
		for (int i = 0; i < todasAsAgendas.size(); i++) {
			if (todasAsAgendas.get(i).getId() == id) {
				return todasAsAgendas.get(i);
			}
		}
		return null;
	}

	/**
	 * Método utilizado para excluir Agenda
	 */
	public void excluirAgendaSemUsuario() {
		for (int i = 0; i < todasAsAgendas.size(); i++) {
			if (todasAsAgendas.get(i) != null) {
				todasAsAgendas.remove(i);
			}
		}
	}

	public List<Canal> getTodosOsCanais() {
		return todosOsCanais;
	}

	public void setTodosOsCanais(ArrayList<Canal> todosOsCanais) {
		this.todosOsCanais = todosOsCanais;
	}

	public List<Usuario> getTodosOsUsuarios() {
		return todosOsUsuarios;
	}

	public void setTodosOsUsuarios(ArrayList<Usuario> todosOsUsuarios) {
		this.todosOsUsuarios = todosOsUsuarios;
	}

	public List<Programa> getTodasAsAgendas() {
		return todasAsAgendas;
	}

	public void setTodasAsAgendas(List<Programa> todasAsAgendas) {
		this.todasAsAgendas = todasAsAgendas;
	}

	public List<Programa> getTodosOsProgramas() {
		return todosOsProgramas;
	}

	public void setTodosOsProgramasSeriesRegulares(List<Programa> todosOsProgramas) {
		this.todosOsProgramas = todosOsProgramas;
	}
}