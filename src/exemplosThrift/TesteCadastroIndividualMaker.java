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
		String uuiFicha = "172340" + UUID.randomUUID() + "";
		VersaoThrift versaoThrift = new VersaoThrift(2, 0, 0);
		List<Long> deficiencias = new ArrayList<Long>();
		byte[] dadoSerializado;
		
		
		informacoesEnvio.setUuidDadoSerializado(uuiFicha);
		informacoesEnvio.setCodIbge("2931350");
		informacoesEnvio.setTipoDadoSerializado(2l);
		informacoesEnvio.setVersao(versaoThrift);
		informacoesEnvio.setIneDadoSerializado("268224");
		
		cadastroIndividual.setUuid(uuiFicha);
		cadastroIndividual.setTpCdsOrigem(3);
		cadastroIndividual.setFichaAtualizada(false);
		cadastroIndividual.setStatusTermoRecusaCadastroIndividualAtencaoBasica(false);
		
		dadosGerais.setCnsProfissional("980016279446897");
		dadosGerais.setCnesUnidadeSaude("172340");
		dadosGerais.setIneEquipe("268224");
		dadosGerais.setCodigoIbgeMunicipio("2931350");
		try {
			dadosGerais.setDataAtendimento(sdf.parse("08/12/2009 15:24:35").getTime());
		} catch (ParseException e) {
			System.out.println("Problemas na data.");
			e.printStackTrace();
		}
		
		identificacaoUsuarioCidadao.setNumeroCartaoSus("203475247580005");
		identificacaoUsuarioCidadao.setStatusEhResponsavel(true);
		identificacaoUsuarioCidadao.setNomeCidadao("MARILEIA DE SOUZA SANTANA");
		identificacaoUsuarioCidadao.setNomeSocialCidadao("LEIA");
		identificacaoUsuarioCidadao.setRacaCorCidadao(4l);
		identificacaoUsuarioCidadao.setSexoCidadao(1l);
		identificacaoUsuarioCidadao.setNomeMaeCidadao("MRIA");
		identificacaoUsuarioCidadao.setDesconheceNomeMae(false);
		identificacaoUsuarioCidadao.setNacionalidadeCidadao(1l);
		identificacaoUsuarioCidadao.setCodigoIbgeMunicipioNascimento("2915601");
		try {
			identificacaoUsuarioCidadao.setDataNascimentoCidadao(sdf.parse("19/02/1999 00:00:00").getTime());
		} catch (ParseException e) {
			System.out.println("Erro de data");
			e.printStackTrace();
		}
		
		informacoesSocioDemograficas.setStatusFrequentaEscola(false);
		informacoesSocioDemograficas.setSituacaoMercadoTrabalhoCidadao(68l);
		informacoesSocioDemograficas.setGrauInstrucaoCidadao(51l);
		informacoesSocioDemograficas.setResponsavelPorCrianca(1l);
		informacoesSocioDemograficas.setStatusFrequentaBenzedeira(true);
		informacoesSocioDemograficas.setStatusPossuiPlanoSaudePrivado(true);
		informacoesSocioDemograficas.setStatusDesejaInformarOrientacaoSexual(true);
		informacoesSocioDemograficas.setOrientacaoSexualCidadao(6l);
		informacoesSocioDemograficas.setMotivoSaidaCidadao(136l);
		informacoesSocioDemograficas.setStatusTemAlgumaDeficiencia(true);
		deficiencias.add(12l);
		informacoesSocioDemograficas.setDeficienciasCidadao(deficiencias);
		
		emSituacaoDeRua.setStatusSituacaoRua(false);		
		
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
