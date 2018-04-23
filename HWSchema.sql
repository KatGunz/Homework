-- Drop table

-- DROP TABLE public.employee

CREATE TABLE public.employee (
	employee_id int8 NOT NULL GENERATED ALWAYS AS IDENTITY,
	firstname varchar NOT NULL,
	lastname varchar NOT NULL,
	CONSTRAINT employee_pk PRIMARY KEY (employee_id),
	CONSTRAINT employee_un UNIQUE (firstname, lastname)
)
WITH (
	OIDS=FALSE
) ;
