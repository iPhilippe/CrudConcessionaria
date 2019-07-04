package br.com.fabrica.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Carro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4528117813267091640L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer chassi;
	private String modelo;
	
	@OneToOne
	@JoinColumn(name = "chave_id", referencedColumnName = "id")
	private Chave chave;
	
	@OneToOne
	@JoinColumn(name = "documento_id", referencedColumnName = "id")
	private Documento documento;
	

	@ManyToOne
	@JoinColumn(name = "fabricante_id", referencedColumnName = "id")
	private Fabricante fabricante;
	
	@ManyToMany
	@JoinTable(
		name = "carro_acessorio",
		joinColumns = @JoinColumn(name = "carro_id"),
		inverseJoinColumns = @JoinColumn(name = "acessorio_id"))
	private List<Acessorio> acessorios;

	public Documento getDocumento() {
		return documento;
	}
	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
	public Integer getChassi() {
		return chassi;
	}
	public void setChassi(Integer chassi) {
		this.chassi = chassi;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Chave getChave() {
		return chave;
	}
	public void setChave(Chave chave) {
		this.chave = chave;
	}
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	public List<Acessorio> getAcessorios() {
		return acessorios;
	}
	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	
}
