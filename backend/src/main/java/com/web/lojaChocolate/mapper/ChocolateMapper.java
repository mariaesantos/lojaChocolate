package com.web.lojaChocolate.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.lojaChocolate.dto.ChocolateDTO;
import com.web.lojaChocolate.model.Chocolate;
import com.web.lojaChocolate.model.Marca;
import com.web.lojaChocolate.model.Tipo;
import com.web.lojaChocolate.service.MarcaService;
import com.web.lojaChocolate.service.TipoService;

@Service
public class ChocolateMapper {
	@Autowired
	private MarcaService marcaService;
	
	@Autowired
	private TipoService tipoService;
	
	public ChocolateDTO domainToDto(Chocolate chocolate) {
		ChocolateDTO chocolateDto = new ChocolateDTO();
		Marca marca = marcaService.find(chocolate.getMarcaId());
		Tipo tipo = tipoService.find(chocolate.getTipoId());
		
		chocolateDto.id(chocolate.getId()).nome(chocolate.getNome()).preco(chocolate.getPreco())
		.marca(marca.getNome()).tipo(tipo.getNome()).tamanho(chocolate.getTamanho()).descricao(chocolate.getDescricao());
		
		return chocolateDto;
	}
	
	public List<ChocolateDTO> domainToDtoList(List<Chocolate> listChocolate) {
		List<ChocolateDTO> listChocolateDto = new ArrayList<>();
		for(Chocolate chocolate : listChocolate) {
			listChocolateDto.add(domainToDto(chocolate));
		}
		
		return listChocolateDto;
	}
}
