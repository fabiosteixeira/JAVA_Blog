package com.template.app.rest.company;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.template.app.entity.CompanyEntity;
import com.template.app.exception.AppException;

/**
 * Class Rest to provide company rest operations
 * 
 * @author rogerio.baldini
 *
 */
@Path("/product")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class CompanyRest {
	
	private final static Logger LOGGER = Logger.getLogger(CompanyRest.class.getName());
	

	@GET
	@Path("/all")
	public List<CompanyEntity> getAllCompanies() throws AppException{
		LOGGER.info("CompanyRest.getAllCompanies");
		List<CompanyEntity> listCompanies = new ArrayList<CompanyEntity>();
		listCompanies.add(new CompanyEntity(1L));
		listCompanies.add(new CompanyEntity(2L));
		listCompanies.add(new CompanyEntity(3L));
		LOGGER.info("CompanyRest.getAllCompanies: "+listCompanies);
		return listCompanies;
	}

	
	
}
