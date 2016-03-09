package exemplosThrift;
	
import br.gov.saude.esus.cds.transport.generated.thrift.common.HeaderCdsCadastroThrift;
import br.gov.saude.esus.transport.common.api.configuracaodestino.VersaoThrift;
import br.gov.saude.esus.transport.common.generated.thrift.DadoInstalacaoThrift;
import br.gov.saude.esus.transport.common.generated.thrift.DadoTransporteThrift;
import br.gov.saude.esus.transport.common.generated.thrift.*;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import br.gov.saude.esus.cds.transport.generated.thrift.cadastroindividual.*;
import exemplosThrift.InformacoesEnvioDto;
import utils.ThriftSerializer;
import utils.ZipWriterExemplo;

public class TesteCadastroIndividualMaker {
	
	private static CadastroIndividualThrift cadastroIndividual;
	private static HeaderCdsCadastroThrift dadosGerais;
	private static CondicoesDeSaudeThrift condicoesDeSaude;
	private static EmSituacaoDeRuaThrift emSituacaoDeRua;
	private static IdentificacaoUsuarioCidadaoThrift identificacaoUsuarioCidadao;
	private static InformacoesSocioDemograficasThrift informacoesSocioDemograficas;
	private static InformacoesEnvioDto informacoesEnvio;
	private static DadoInstalacaoThrift originadora;
	private static DadoInstalacaoThrift remetente;
	private static DadoTransporteThrift dadoTransporte;
	
	public static void main(String[] args) {
		cadastroIndividual = new CadastroIndividualThrift();
		dadosGerais = new HeaderCdsCadastroThrift();
		condicoesDeSaude = new CondicoesDeSaudeThrift();
		emSituacaoDeRua = new EmSituacaoDeRuaThrift();
		identificacaoUsuarioCidadao = new IdentificacaoUsuarioCidadaoThrift();
		informacoesSocioDemograficas = new InformacoesSocioDemograficasThrift();
		informacoesEnvio = new InformacoesEnvioDto();
		originadora = new DadoInstalacaoThrift();
		remetente = new DadoInstalacaoThrift();
		dadoTransporte = new DadoTransporteThrift();
		
		inicializaDados();
		
//		System.out.println(Arrays.toString(informacoesEnvio.getDadoSerializado()));
		for(byte b: informacoesEnvio.getDadoSerializado()) {
			System.out.print(b);
		}
		
		ZipWriterExemplo.generateZip(dadoTransporte, "C:\\transporteThrifteSUS.zip");
	}
	
	public static void inicializaDados() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String uuiFicha = "5444428" + UUID.randomUUID() + "";
		VersaoThrift versaoThrift = new VersaoThrift(2, 0, 0);
		List<Long> deficiencias = new ArrayList<Long>();
		List<Long> doencas = new ArrayList<Long>();
		byte[] dadoSerializado;
		
		
		informacoesEnvio.setUuidDadoSerializado(uuiFicha);
		informacoesEnvio.setCodIbge("4205407");
		informacoesEnvio.setTipoDadoSerializado(2l);
		informacoesEnvio.setVersao(versaoThrift);
		informacoesEnvio.setIneDadoSerializado("268224");
		
		cadastroIndividual.setUuid(uuiFicha);
		cadastroIndividual.setTpCdsOrigem(3);
		cadastroIndividual.setFichaAtualizada(false);
		cadastroIndividual.setStatusTermoRecusaCadastroIndividualAtencaoBasica(false);
		
		dadosGerais.setCnsProfissional("708407713297266");
		dadosGerais.setCnesUnidadeSaude("5444428");
		dadosGerais.setIneEquipe("1382855330");
		dadosGerais.setCodigoIbgeMunicipio("4205407");
		try {
			dadosGerais.setDataAtendimento(sdf.parse("21/01/2016 15:24:35").getTime());
		} catch (ParseException e) {
			System.out.println("Problemas na data.");
			e.printStackTrace();
		}
		
		identificacaoUsuarioCidadao.setNumeroCartaoSus("127984422070002");
		identificacaoUsuarioCidadao.setStatusEhResponsavel(true);
		identificacaoUsuarioCidadao.setNomeCidadao("MARIA C�NDIDA DA SILVA");
		identificacaoUsuarioCidadao.setNomeSocialCidadao("MARIA");
		identificacaoUsuarioCidadao.setRacaCorCidadao(1l);
		identificacaoUsuarioCidadao.setSexoCidadao(1l);
		identificacaoUsuarioCidadao.setNomeMaeCidadao("SILVIA C�NDIDA DA SILVA");
		identificacaoUsuarioCidadao.setDesconheceNomeMae(false);
		identificacaoUsuarioCidadao.setNacionalidadeCidadao(1l);
		identificacaoUsuarioCidadao.setCodigoIbgeMunicipioNascimento("4314902");
		identificacaoUsuarioCidadao.setPaisNascimento(31);
		try {
			identificacaoUsuarioCidadao.setDataNascimentoCidadao(sdf.parse("19/02/1999 00:00:00").getTime());
		} catch (ParseException e) {
			System.out.println("Erro de data");
			e.printStackTrace();
		}
		
		informacoesSocioDemograficas.setRelacaoParentescoCidadao(141);
		informacoesSocioDemograficas.setOcupacaoCodigoCbo2002("312320");
		informacoesSocioDemograficas.setStatusFrequentaEscola(true);
		informacoesSocioDemograficas.setGrauInstrucaoCidadao(60l);
		informacoesSocioDemograficas.setResponsavelPorCrianca(1l);
		informacoesSocioDemograficas.setStatusFrequentaBenzedeira(true);
		informacoesSocioDemograficas.setStatusPossuiPlanoSaudePrivado(true);
		informacoesSocioDemograficas.setStatusDesejaInformarOrientacaoSexual(true);
		informacoesSocioDemograficas.setOrientacaoSexualCidadao(5l);
		informacoesSocioDemograficas.setMotivoSaidaCidadao(136l);
		informacoesSocioDemograficas.setStatusTemAlgumaDeficiencia(true);
		deficiencias.add(12l);
		deficiencias.add(13l);
		deficiencias.add(14l);
		deficiencias.add(15l);
		deficiencias.add(16l);
		informacoesSocioDemograficas.setDeficienciasCidadao(deficiencias);
		
		condicoesDeSaude.setStatusEhGestante(true);
		condicoesDeSaude.setMaternidadeDeReferencia("carmela dutra");
		condicoesDeSaude.setSituacaoPeso(22l);
		condicoesDeSaude.setStatusEhFumante(true);
		condicoesDeSaude.setStatusEhDependenteAlcool(false);
		condicoesDeSaude.setStatusEhDependenteOutrasDrogas(true);
		condicoesDeSaude.setStatusTemHipertensaoArterial(false);
		condicoesDeSaude.setStatusTemDiabetes(true);
		condicoesDeSaude.setStatusTeveAvcDerrame(true);
		condicoesDeSaude.setStatusTeveInfarto(true);
		condicoesDeSaude.setStatusTeveDoencaCardiaca(true);
		doencas.add(24l);
		doencas.add(25l);
		doencas.add(26l);
		condicoesDeSaude.setDoencaCardiaca(doencas);
		doencas.clear();
		condicoesDeSaude.setStatusTemTeveDoencasRins(true);
		doencas.add(27l);
		doencas.add(28l);
		doencas.add(29l);
		condicoesDeSaude.setDoencaRins(doencas);
		doencas.clear();
		condicoesDeSaude.setStatusTemDoencaRespiratoria(true);
		doencas.add(30l);
		doencas.add(31l);
		doencas.add(32l);
		doencas.add(33l);
		condicoesDeSaude.setDoencaRespiratoria(doencas);
		condicoesDeSaude.setStatusTemTeveCancer(false);
		condicoesDeSaude.setStatusTemHanseniase(false);
		condicoesDeSaude.setStatusTemTuberculose(false);
		condicoesDeSaude.setStatusTeveInternadoEm12Meses(true);
		condicoesDeSaude.setDescricaoCausaInternacaoEm12Meses("pneumonia");
		condicoesDeSaude.setStatusTratamentoPsiquicoOuProblemaMental(false);
		condicoesDeSaude.setStatusEstaAcamado(true);
		condicoesDeSaude.setStatusEstaDomiciliado(false);
		condicoesDeSaude.setStatusUsaPlantaMedicinais(true);
		condicoesDeSaude.setDescricaoPlantasMedicinaisUsadas("erva mate");
		condicoesDeSaude.setStatusUsaOutrasPraticasIntegrativasOuComplementares(true);
		condicoesDeSaude.setDescricaoOutraCondicao1("condi��o 1");
		condicoesDeSaude.setDescricaoOutraCondicao2("condicao 2");
		condicoesDeSaude.setDescricaoOutraCondicao3("condicao 3");
		
		emSituacaoDeRua.setQuantidadeAlimentacoesAoDiaSituacaoRua(35);
		deficiencias.clear();
		deficiencias.add(37l);
		deficiencias.add(38l);
		deficiencias.add(39l);
		deficiencias.add(40l);
		deficiencias.add(41l);
		emSituacaoDeRua.setOrigemAlimentoSituacaoRua(deficiencias);
		emSituacaoDeRua.setStatusTemAcessoHigienePessoalSituacaoRua(true);
		deficiencias.clear();
		deficiencias.add(42l);
		deficiencias.add(43l);
		deficiencias.add(44l);
		deficiencias.add(45l);
		emSituacaoDeRua.setStatusSituacaoRua(true);
		emSituacaoDeRua.setTempoSituacaoRua(18l);
		emSituacaoDeRua.setStatusAcompanhadoPorOutraInstituicao(true);
		emSituacaoDeRua.setOutraInstituicaoQueAcompanha("ufsc");
		emSituacaoDeRua.setStatusRecebeBeneficio(true);
		emSituacaoDeRua.setStatusPossuiReferenciaFamiliar(true);
		emSituacaoDeRua.setStatusVisitaFamiliarFrequentemente(true);
		emSituacaoDeRua.setGrauParentescoFamiliarFrequentado("m�e");
		
		cadastroIndividual.setUuid(uuiFicha);
		cadastroIndividual.setTpCdsOrigem(3);
		cadastroIndividual.setFichaAtualizada(false);
		cadastroIndividual.setStatusTermoRecusaCadastroIndividualAtencaoBasica(false);	
		cadastroIndividual.setDadosGerais(dadosGerais);
		cadastroIndividual.setIdentificacaoUsuarioCidadao(identificacaoUsuarioCidadao);
		cadastroIndividual.setInformacoesSocioDemograficas(informacoesSocioDemograficas);
		cadastroIndividual.setCondicoesDeSaude(condicoesDeSaude);
		cadastroIndividual.setEmSituacaoDeRua(emSituacaoDeRua);
		
		dadoSerializado = ThriftSerializer.serialize(cadastroIndividual);
		
		
		dadoTransporte.setCnesDadoSerializado("172340");
		dadoTransporte.setCodIbge("2931350");
		dadoTransporte.setTipoDadoSerializado(2l);
		dadoTransporte.setIneDadoSerializado("268224");
		dadoTransporte.setUuidDadoSerializado(uuiFicha);
		dadoTransporte.setNumLote(0l);
		dadoTransporte.setVersao(versaoThrift);
		dadoTransporte.setDadoSerializado(dadoSerializado);		
		
		uuiFicha = UUID.randomUUID() + "";
		originadora.setContraChave("002F-A4C7-4307-9000-64BE-2BF8-0197-40A8");
		originadora.setUuidInstalacao(uuiFicha);
		originadora.setCpfOuCnpj("25367556000141");
		originadora.setNomeOuRazaoSocial("Mariana Melo");
		
		remetente.setContraChave("002F-A4C7-4307-9000-64BE-2BF8-0197-40A8");
		remetente.setUuidInstalacao(uuiFicha);
		remetente.setCpfOuCnpj("25367556000141");
		remetente.setNomeOuRazaoSocial("Mariana Melo");
		
		dadoTransporte.setOriginadora(originadora);
		dadoTransporte.setRemetente(remetente);
		
		informacoesEnvio.setDadoSerializado(dadoSerializado);
	}

}
