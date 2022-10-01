package br.com.fiap.Challengesprint3.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass // faz com que nao crie uma tabela no banco, ja q especialista so sera usado
					// para herança
public class Especialista {

	// verificar implementação do uuid
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codEspecialista;

	private String nomeEspecialista;

	private String email;

	private String senha;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtNascimento;

	private Integer telefoneDDD;

	private Integer telefone;

	private String descricaoSobre;

	private String tipoEspecialidade;

	@Enumerated(value = EnumType.STRING)
	private EspecialistaTipo tipo;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Genero genero;

	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	public Especialista() {
	}

	public Especialista(Long codEspecialista, String nomeEspecialista, String email, String senha, Date dtNascimento,
			Integer telefoneDDD, Integer telefone, String descricaoSobre, String tipoEspecialidade,
			EspecialistaTipo tipo, Genero genero, Endereco endereco) {
		this.codEspecialista = codEspecialista;
		this.nomeEspecialista = nomeEspecialista;
		this.email = email;
		this.senha = senha;
		this.dtNascimento = dtNascimento;
		this.telefoneDDD = telefoneDDD;
		this.telefone = telefone;
		this.descricaoSobre = descricaoSobre;
		this.tipoEspecialidade = tipoEspecialidade;
		this.tipo = tipo;
		this.genero = genero;
		this.endereco = endereco;
	}

	public Long getCodEspecialista() {
		return codEspecialista;
	}

	public void setCodEspecialista(Long codEspecialista) {
		this.codEspecialista = codEspecialista;
	}

	public String getNomeEspecialista() {
		return nomeEspecialista;
	}

	public void setNomeEspecialista(String nomeEspecialista) {
		this.nomeEspecialista = nomeEspecialista;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Integer getTelefoneDDD() {
		return telefoneDDD;
	}

	public void setTelefoneDDD(Integer telefoneDDD) {
		this.telefoneDDD = telefoneDDD;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public String getDescricaoSobre() {
		return descricaoSobre;
	}

	public void setDescricaoSobre(String descricaoSobre) {
		this.descricaoSobre = descricaoSobre;
	}

	public String getTipoEspecialidade() {
		return tipoEspecialidade;
	}

	public void setTipoEspecialidade(String tipoEspecialidade) {
		this.tipoEspecialidade = tipoEspecialidade;
	}

	public EspecialistaTipo getTipo() {
		return tipo;
	}

	public void setTipo(EspecialistaTipo tipo) {
		this.tipo = tipo;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Especialista [codEspecialista=" + codEspecialista + ", descricaoSobre=" + descricaoSobre
				+ ", dtNascimento=" + dtNascimento + ", email=" + email + ", endereco=" + endereco + ", genero="
				+ genero + ", nomeEspecialista=" + nomeEspecialista + ", senha=" + senha + ", telefone=" + telefone
				+ ", telefoneDDD=" + telefoneDDD + ", tipo=" + tipo + ", tipoEspecialidade=" + tipoEspecialidade + "]";
	}

}
