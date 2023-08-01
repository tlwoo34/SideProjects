CREATE TABLE inventory (id serial,
					   name varchar(100) NOT NULL,
					   upc bigint NOT NULL, 
					   quantity int NOT NULL,
					   CONSTRAINT pk_inventory PRIMARY KEY(id)
					  );
					  
CREATE TABLE role (id serial, 
				  name varchar(100) NOT NULL,
				  CONSTRAINT pk_role PRIMARY KEY(id)
				  );
				  
CREATE TABLE team (id serial, 
				  name varchar (100) NOT NULL,
				  CONSTRAINT pk_team PRIMARY KEY(id)
				  );
				  
CREATE TABLE personnel (id serial, 
					   name varchar(100) NOT NULL,
					   team_id int, 
					   role_id int NOT NULL,
					   CONSTRAINT pk_personnel PRIMARY KEY(id),
						CONSTRAINT personnel_role_id_fkey FOREIGN KEY (role_id) REFERENCES role(id),
						CONSTRAINT personnel_team_id_fkey FOREIGN KEY (team_id) REFERENCES team(id)
					  );
				  
CREATE TABLE transactions (id serial, 
						  personnel_id int, 
						  inventory_id int, 
						  quantity int NOT NULL, 
						  timestamp TIMESTAMP,
						  CONSTRAINT pk_transactions PRIMARY KEY(id),
						   CONSTRAINT transactions_inventory_id_fkey FOREIGN KEY(inventory_id) REFERENCES inventory(id),
						   CONSTRAINT transactions_personnel_id_fkey FOREIGN KEY(personnel_id) REFERENCES personnel(id)
						 );
						 
CREATE TABLE role_permissions (role_id int,
							  inventory_id int,
							  CONSTRAINT role_permissions_inventory_id_fkey FOREIGN KEY(inventory_id)
							  REFERENCES inventory(id),
							  CONSTRAINT role_permissions_role_id_fkey FOREIGN KEY (role_id)
							  REFERENCES role(id)
							  );
							  
CREATE TABLE team_permissions (team_id int, 
							  inventory_id int,
							  CONSTRAINT team_permissions_inventory_id_fkey FOREIGN KEY(inventory_id)
							  REFERENCES inventory(id),
							  CONSTRAINT team_permissions_team_id_fkey FOREIGN KEY(team_id) 
							  REFERENCES team(id)
							  );
			
					  