package br.com.datas;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Datas {

	
	public static void main(String[] args) {
		
		LocalDate hoje = LocalDate.now();
		LocalDate olimpiadasRio = LocalDate.of(1989, Month.JUNE, 15);
		int anos = hoje.getYear() - olimpiadasRio.getYear();	
		
		// Saber a diferença entre duas datas
		Period periodo = Period.between(olimpiadasRio, hoje); 
		//System.out.println(periodo.getYears());
		//System.out.println(periodo.getMonths());
		//System.out.println(periodo.getDays());
		
		
		// Incrementando e decrementando datas
		System.out.println(hoje.minusYears(1));
		System.out.println(hoje.minusMonths(4));
		System.out.println(hoje.minusDays(2));
		System.out.println("----------");
		System.out.println(hoje.plusYears(1));
		System.out.println(hoje.plusMonths(4));
		System.out.println(hoje.plusDays(2));
		
		// Uma API imutável ela nnunca vai alterar a data original
		// Os métodos dessa API de datas sempre vão retornar uma nova instancia da sua data.
		
		LocalDate proximaOlimpiadas = olimpiadasRio.plusYears(35);
		System.out.println(proximaOlimpiadas);
		System.out.println("----------");
		
		// Formatando as datas
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String valorFormatado = proximaOlimpiadas.format(formatador);
		System.out.println(valorFormatado);
		System.out.println("----------");
		
		// Trabalhando com medida de tempo	
		DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(formatadorComHoras));
	
		// Lidando com modelos mais específicos
		YearMonth anoEMes = YearMonth.of(2020, Month.AUGUST);
		System.out.println(anoEMes);
		
		LocalTime intervalo = LocalTime.of(12, 30);
		System.out.println(intervalo);
		
		// Mostrando data hora com timezone
		ZonedDateTime horaTimeZone = ZonedDateTime.now();
		System.out.println(horaTimeZone);
		
		System.out.println("---------");
		
		LocalDate novaData = LocalDate.of(2099, Month.JANUARY, 25);
		System.out.println(novaData);
		
		System.out.println("---------");
		
		DateTimeFormatter novoFormato = DateTimeFormatter.ofPattern("dd/MMMM/yyyy", new Locale("pt","BR"));
		LocalDate novaDataFormato = LocalDate.of(2099, Month.JANUARY, 25);
		String dataComFormato = novaData.format(novoFormato);
		System.out.println(dataComFormato.replace("/", " de "));
		
		LocalDate agoraNew = LocalDate.now();
		LocalDate dataFutura = LocalDate.of(2099, Month.JANUARY,25);
		
		Period novoPeriodo = Period.between(agoraNew, dataFutura);
		System.out.println(novoPeriodo);
		
		// Pesquisar a respeito
		Duration duration = Duration.between(LocalDateTime.parse("2018-01-18T06:30"), LocalDateTime.parse("2018-02-14T22:58"));
		long hours = duration.toHours();
		
		System.out.println(hours);
		
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		System.out.println(">>>" +LocalDateTime.now().format(format));
		
		
		
	}
	
}
