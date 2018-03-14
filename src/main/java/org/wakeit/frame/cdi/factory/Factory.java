/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.cdi.factory;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.wakeit.frame.cdi.annotation.qualifier.Maven;
import org.wakeit.frame.model.MavenModel;

/**
 * Class Factory
 *
 * @author edivandoalves
 * @date Mar 6, 2018
 * 
 * 
 */
public class Factory {
	
	@Maven
	@Produces
	@ApplicationScoped
	public MavenModel getMavenModel() throws IOException {
		final Reader reader = new FileReader(getClass().getClassLoader().getResource("project.properties").getFile());
		final Properties properties = new Properties();
		properties.load(reader);
		MavenModel model = new MavenModel();
		model.setVersion(properties.getProperty("version"));
		model.setArtifactId(properties.getProperty("artifactId"));
		return model;
	}
	
	

}
