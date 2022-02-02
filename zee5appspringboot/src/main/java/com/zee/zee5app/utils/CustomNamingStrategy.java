package com.zee.zee5app.utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CustomNamingStrategy extends PhysicalNamingStrategyStandardImpl {

	private final static String POSTFIX = "_table";

	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
		// TODO Auto-generated method stub
		if (name == null)
			return null;
		final String newName = name.getText() + POSTFIX;

		return name.toIdentifier(newName);
	}

	@Override
	public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
		// TODO Auto-generated method stub
		if (name == null)
			return null;
		final String newName = name.getText() + POSTFIX;
		return Identifier.toIdentifier(name.getText().toLowerCase());
	}
}
