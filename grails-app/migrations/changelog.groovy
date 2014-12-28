databaseChangeLog = {

	changeSet(author: "fernando (generated)", id: "1419739829409-1") {
		createTable(tableName: "authentication_token") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "token", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-2") {
		createTable(tableName: "carga_horaria") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "fecha", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "horas", type: "INT") {
				constraints(nullable: "false")
			}

			column(name: "proyecto_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "usuario_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "horas_ajustadas", type: "INT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-3") {
		createTable(tableName: "cliente") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "cuit", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "nombre", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "relativesvnurl", type: "VARCHAR(255)")
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-4") {
		createTable(tableName: "config_var") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "clave", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "valor", type: "VARCHAR(255)")
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-5") {
		createTable(tableName: "contacto") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "cliente_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "nombre", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-6") {
		createTable(tableName: "customer") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "vat", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "address", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-7") {
		createTable(tableName: "email_asociado") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "usuario_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-8") {
		createTable(tableName: "feriado") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "fecha", type: "DATETIME") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-9") {
		createTable(tableName: "oauthid") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "access_token", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "provider", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-10") {
		createTable(tableName: "openid") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "url", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-11") {
		createTable(tableName: "persistent_logins") {
			column(name: "series", type: "VARCHAR(64)") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "last_used", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "token", type: "VARCHAR(64)") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "VARCHAR(64)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-12") {
		createTable(tableName: "presupuesto") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "cliente_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "proyecto_id", type: "BIGINT")

			column(name: "solicitud_cliente", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-13") {
		createTable(tableName: "presupuesto_item") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "presupuesto_id", type: "BIGINT")

			column(name: "class", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "entry_to_string", type: "VARCHAR(1000)")

			column(name: "mensaje_commit", type: "VARCHAR(255)")

			column(name: "relative_url", type: "VARCHAR(255)")

			column(name: "revision", type: "BIGINT")
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-14") {
		createTable(tableName: "proyecto") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "estado", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "nombre", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "color", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-15") {
		createTable(tableName: "quote_line") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "amount", type: "DOUBLE") {
				constraints(nullable: "false")
			}

			column(name: "currency", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "customer_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-16") {
		createTable(tableName: "rol") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-17") {
		createTable(tableName: "telefono") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "contacto_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "numero", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "tipo_telefono", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-18") {
		createTable(tableName: "transaction") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "amount", type: "DOUBLE") {
				constraints(nullable: "false")
			}

			column(name: "currency", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "customer_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "parent_id", type: "BIGINT")

			column(name: "quote_line_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "rate", type: "DOUBLE") {
				constraints(nullable: "false")
			}

			column(name: "type", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-19") {
		createTable(tableName: "usuario") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "horas", type: "INT") {
				constraints(nullable: "false")
			}

			column(name: "nombre", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "alias", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-20") {
		createTable(tableName: "usuario_rol") {
			column(name: "rol_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "usuario_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-21") {
		addPrimaryKey(columnNames: "rol_id, usuario_id", tableName: "usuario_rol")
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-37") {
		createIndex(indexName: "email", tableName: "email_asociado", unique: "true") {
			column(name: "email")
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-38") {
		createIndex(indexName: "fecha", tableName: "feriado", unique: "true") {
			column(name: "fecha")
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-39") {
		createIndex(indexName: "UK_2hy0on28oron3v471plrnu1k0", tableName: "oauthid", unique: "true") {
			column(name: "access_token")
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-40") {
		createIndex(indexName: "identity_idx", tableName: "oauthid", unique: "false") {
			column(name: "access_token")

			column(name: "provider")
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-41") {
		createIndex(indexName: "url", tableName: "openid", unique: "true") {
			column(name: "url")
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-42") {
		createIndex(indexName: "authority", tableName: "rol", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-43") {
		createIndex(indexName: "alias", tableName: "usuario", unique: "true") {
			column(name: "alias")
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-44") {
		createIndex(indexName: "username", tableName: "usuario", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-22") {
		addForeignKeyConstraint(baseColumnNames: "proyecto_id", baseTableName: "carga_horaria", baseTableSchemaName: "loki_v2", constraintName: "FKBA434843299C8E24", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "proyecto", referencedTableSchemaName: "loki_v2", referencesUniqueColumn: "false")
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-23") {
		addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "carga_horaria", baseTableSchemaName: "loki_v2", constraintName: "FKBA43484327480B30", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "usuario", referencedTableSchemaName: "loki_v2", referencesUniqueColumn: "false")
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-24") {
		addForeignKeyConstraint(baseColumnNames: "cliente_id", baseTableName: "contacto", baseTableSchemaName: "loki_v2", constraintName: "FKDE2D604F164387B0", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "cliente", referencedTableSchemaName: "loki_v2", referencesUniqueColumn: "false")
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-25") {
		addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "email_asociado", baseTableSchemaName: "loki_v2", constraintName: "FK9D950B6C27480B30", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "usuario", referencedTableSchemaName: "loki_v2", referencesUniqueColumn: "false")
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-26") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "oauthid", baseTableSchemaName: "loki_v2", constraintName: "FK_m55d9kulbi1h29t7xs23ohd0w", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "usuario", referencedTableSchemaName: "loki_v2", referencesUniqueColumn: "false")
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-27") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "openid", baseTableSchemaName: "loki_v2", constraintName: "FKC3C3C8E5908A7173", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "usuario", referencedTableSchemaName: "loki_v2", referencesUniqueColumn: "false")
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-28") {
		addForeignKeyConstraint(baseColumnNames: "cliente_id", baseTableName: "presupuesto", baseTableSchemaName: "loki_v2", constraintName: "FK8E1C7B3164387B0", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "cliente", referencedTableSchemaName: "loki_v2", referencesUniqueColumn: "false")
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-29") {
		addForeignKeyConstraint(baseColumnNames: "proyecto_id", baseTableName: "presupuesto", baseTableSchemaName: "loki_v2", constraintName: "FK8E1C7B3299C8E24", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "proyecto", referencedTableSchemaName: "loki_v2", referencesUniqueColumn: "false")
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-30") {
		addForeignKeyConstraint(baseColumnNames: "presupuesto_id", baseTableName: "presupuesto_item", baseTableSchemaName: "loki_v2", constraintName: "FK2702441F794F610", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "presupuesto", referencedTableSchemaName: "loki_v2", referencesUniqueColumn: "false")
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-31") {
		addForeignKeyConstraint(baseColumnNames: "customer_id", baseTableName: "quote_line", baseTableSchemaName: "loki_v2", constraintName: "FK_lambdmgi0obxi9o9oi8m3f8j2", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "customer", referencedTableSchemaName: "loki_v2", referencesUniqueColumn: "false")
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-32") {
		addForeignKeyConstraint(baseColumnNames: "contacto_id", baseTableName: "telefono", baseTableSchemaName: "loki_v2", constraintName: "FKAEE86AF466C0D1E4", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "contacto", referencedTableSchemaName: "loki_v2", referencesUniqueColumn: "false")
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-33") {
		addForeignKeyConstraint(baseColumnNames: "customer_id", baseTableName: "transaction", baseTableSchemaName: "loki_v2", constraintName: "FK_btane64ls5uag9j1yuq0yepow", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "customer", referencedTableSchemaName: "loki_v2", referencesUniqueColumn: "false")
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-34") {
		addForeignKeyConstraint(baseColumnNames: "quote_line_id", baseTableName: "transaction", baseTableSchemaName: "loki_v2", constraintName: "FK_dq5hxmcm0jby2hwqdyrouwb4m", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "quote_line", referencedTableSchemaName: "loki_v2", referencesUniqueColumn: "false")
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-35") {
		addForeignKeyConstraint(baseColumnNames: "rol_id", baseTableName: "usuario_rol", baseTableSchemaName: "loki_v2", constraintName: "FK3118953EE6200690", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "rol", referencedTableSchemaName: "loki_v2", referencesUniqueColumn: "false")
	}

	changeSet(author: "fernando (generated)", id: "1419739829409-36") {
		addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "usuario_rol", baseTableSchemaName: "loki_v2", constraintName: "FK3118953E27480B30", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "usuario", referencedTableSchemaName: "loki_v2", referencesUniqueColumn: "false")
	}
}
