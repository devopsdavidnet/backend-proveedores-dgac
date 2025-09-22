-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler version: 1.1.6
-- PostgreSQL version: 15.0
-- Project Site: pgmodeler.io
-- Model Author: ---

-- Database creation must be performed outside a multi lined SQL file. 
-- These commands were put in this file only as a convenience.
-- 
-- object: rbs_prueba | type: DATABASE --
-- DROP DATABASE IF EXISTS rbs_prueba;
CREATE DATABASE rbs_prueba
	ENCODING = 'UTF8'
	LC_COLLATE = 'es_BO.UTF-8'
	LC_CTYPE = 'es_BO.UTF-8'
	TABLESPACE = pg_default
	OWNER = postgres;
-- ddl-end --


-- object: rbs | type: SCHEMA --
-- DROP SCHEMA IF EXISTS rbs CASCADE;
CREATE SCHEMA rbs;
-- ddl-end --
ALTER SCHEMA rbs OWNER TO postgres;
-- ddl-end --

SET search_path TO pg_catalog,public,rbs;
-- ddl-end --

-- object: rbs.param_direcciones_id_direccion_seq | type: SEQUENCE --
-- DROP SEQUENCE IF EXISTS rbs.param_direcciones_id_direccion_seq CASCADE;
CREATE SEQUENCE rbs.param_direcciones_id_direccion_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;

-- ddl-end --
ALTER SEQUENCE rbs.param_direcciones_id_direccion_seq OWNER TO postgres;
-- ddl-end --

-- object: rbs.param_direcciones | type: TABLE --
-- DROP TABLE IF EXISTS rbs.param_direcciones CASCADE;
CREATE TABLE rbs.param_direcciones (
	id_direccion integer NOT NULL DEFAULT nextval('rbs.param_direcciones_id_direccion_seq'::regclass),
	codigo character varying(10),
	descripcion character varying(100),
	estado_registro character varying(2),
	usuario_actual character varying(100) NOT NULL,
	fecha_creacion_registro timestamp DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT param_direcciones_pkey PRIMARY KEY (id_direccion)
);
-- ddl-end --
COMMENT ON TABLE rbs.param_direcciones IS E'Tabla parametrica que contiene datos de direcciones';
-- ddl-end --
ALTER TABLE rbs.param_direcciones OWNER TO postgres;
-- ddl-end --

-- object: rbs.param_unidades_id_unidad_seq | type: SEQUENCE --
-- DROP SEQUENCE IF EXISTS rbs.param_unidades_id_unidad_seq CASCADE;
CREATE SEQUENCE rbs.param_unidades_id_unidad_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;

-- ddl-end --
ALTER SEQUENCE rbs.param_unidades_id_unidad_seq OWNER TO postgres;
-- ddl-end --

-- object: rbs.param_unidades | type: TABLE --
-- DROP TABLE IF EXISTS rbs.param_unidades CASCADE;
CREATE TABLE rbs.param_unidades (
	id_unidad integer NOT NULL DEFAULT nextval('rbs.param_unidades_id_unidad_seq'::regclass),
	id_direccion integer,
	codigo character varying(10),
	descripcion character varying(100),
	estado_registro character varying(2),
	usuario_actual character varying(100) NOT NULL,
	fecha_creacion_registro timestamp DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT param_unidades_pkey PRIMARY KEY (id_unidad)
);
-- ddl-end --
COMMENT ON TABLE rbs.param_unidades IS E'Tabla parametrica que contiene las unidades de direcciones';
-- ddl-end --
ALTER TABLE rbs.param_unidades OWNER TO postgres;
-- ddl-end --

-- object: rbs.param_especialidades_id_especidalidad_seq | type: SEQUENCE --
-- DROP SEQUENCE IF EXISTS rbs.param_especialidades_id_especidalidad_seq CASCADE;
CREATE SEQUENCE rbs.param_especialidades_id_especidalidad_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;

-- ddl-end --
ALTER SEQUENCE rbs.param_especialidades_id_especidalidad_seq OWNER TO postgres;
-- ddl-end --

-- object: rbs.param_especialidades | type: TABLE --
-- DROP TABLE IF EXISTS rbs.param_especialidades CASCADE;
CREATE TABLE rbs.param_especialidades (
	id_especidalidad integer NOT NULL DEFAULT nextval('rbs.param_especialidades_id_especidalidad_seq'::regclass),
	id_unidad integer,
	codigo character varying(20),
	descripcion character varying(200),
	estado_registro character varying(2),
	usuario_actual character varying(100) NOT NULL,
	fecha_creacion_registro timestamp DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT param_especialidades_pkey PRIMARY KEY (id_especidalidad)
);
-- ddl-end --
COMMENT ON TABLE rbs.param_especialidades IS E'Tabla parametrica que contiene las especialidades de dna es decir ATM MET, AIM, MAP, SAR';
-- ddl-end --
ALTER TABLE rbs.param_especialidades OWNER TO postgres;
-- ddl-end --

-- object: rbs.param_lista_de_verificaciones_id_lista_verificacion_seq | type: SEQUENCE --
-- DROP SEQUENCE IF EXISTS rbs.param_lista_de_verificaciones_id_lista_verificacion_seq CASCADE;
CREATE SEQUENCE rbs.param_lista_de_verificaciones_id_lista_verificacion_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;

-- ddl-end --
ALTER SEQUENCE rbs.param_lista_de_verificaciones_id_lista_verificacion_seq OWNER TO postgres;
-- ddl-end --

-- object: rbs.param_lista_de_verificaciones | type: TABLE --
-- DROP TABLE IF EXISTS rbs.param_lista_de_verificaciones CASCADE;
CREATE TABLE rbs.param_lista_de_verificaciones (
	id_lista_verificacion integer NOT NULL DEFAULT nextval('rbs.param_lista_de_verificaciones_id_lista_verificacion_seq'::regclass),
	id_especialidad integer,
	codigo character varying(20),
	descripcion character varying(200),
	estado_registro character varying(2),
	usuario_actual character varying(100) NOT NULL,
	fecha_creacion_registro timestamp DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT lista_verficacion_pkey PRIMARY KEY (id_lista_verificacion)
);
-- ddl-end --
COMMENT ON TABLE rbs.param_lista_de_verificaciones IS E'Tabla parametrica principal que almacena las listas de verificacion';
-- ddl-end --
ALTER TABLE rbs.param_lista_de_verificaciones OWNER TO postgres;
-- ddl-end --

-- object: rbs.param_items_id_item_seq | type: SEQUENCE --
-- DROP SEQUENCE IF EXISTS rbs.param_items_id_item_seq CASCADE;
CREATE SEQUENCE rbs.param_items_id_item_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;

-- ddl-end --
ALTER SEQUENCE rbs.param_items_id_item_seq OWNER TO postgres;
-- ddl-end --

-- object: rbs.param_items | type: TABLE --
-- DROP TABLE IF EXISTS rbs.param_items CASCADE;
CREATE TABLE rbs.param_items (
	id_item integer NOT NULL DEFAULT nextval('rbs.param_items_id_item_seq'::regclass),
	id_lista_verificacion integer NOT NULL,
	nro_item_dna integer,
	referencia character varying(500),
	codigo_requisito character varying(20),
	pregunta_requisito text,
	estado_registro character varying(2),
	usuario_actual character varying(100) NOT NULL,
	fecha_creacion_registro timestamp DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT items_pkey PRIMARY KEY (id_item)
);
-- ddl-end --
COMMENT ON TABLE rbs.param_items IS E'Tabla parametrica que almancena lo item de una listas de verificaci';
-- ddl-end --
ALTER TABLE rbs.param_items OWNER TO postgres;
-- ddl-end --

-- object: rbs.param_orientaciones_id_orientacion_seq | type: SEQUENCE --
-- DROP SEQUENCE IF EXISTS rbs.param_orientaciones_id_orientacion_seq CASCADE;
CREATE SEQUENCE rbs.param_orientaciones_id_orientacion_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;

-- ddl-end --
ALTER SEQUENCE rbs.param_orientaciones_id_orientacion_seq OWNER TO postgres;
-- ddl-end --

-- object: rbs.param_orientaciones | type: TABLE --
-- DROP TABLE IF EXISTS rbs.param_orientaciones CASCADE;
CREATE TABLE rbs.param_orientaciones (
	id_orientacion integer NOT NULL DEFAULT nextval('rbs.param_orientaciones_id_orientacion_seq'::regclass),
	id_item integer NOT NULL,
	orientacion_para_examen text,
	codificacion_codigo_peligro character varying(50),
	estado_registro character varying(2),
	usuario_actual character varying(100) NOT NULL,
	fecha_registro timestamp DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT param_orientaciones_pkey PRIMARY KEY (id_orientacion)
);
-- ddl-end --
COMMENT ON TABLE rbs.param_orientaciones IS E'Tabla parametrica que almancena las orientacion de cada item';
-- ddl-end --
ALTER TABLE rbs.param_orientaciones OWNER TO postgres;
-- ddl-end --

-- object: rbs.param_estado_cumplimiento_req_id_estado_cumplimiento_requis_seq | type: SEQUENCE --
-- DROP SEQUENCE IF EXISTS rbs.param_estado_cumplimiento_req_id_estado_cumplimiento_requis_seq CASCADE;
CREATE SEQUENCE rbs.param_estado_cumplimiento_req_id_estado_cumplimiento_requis_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;

-- ddl-end --
ALTER SEQUENCE rbs.param_estado_cumplimiento_req_id_estado_cumplimiento_requis_seq OWNER TO postgres;
-- ddl-end --

-- object: rbs.param_estado_cumplimiento_requisitos | type: TABLE --
-- DROP TABLE IF EXISTS rbs.param_estado_cumplimiento_requisitos CASCADE;
CREATE TABLE rbs.param_estado_cumplimiento_requisitos (
	id_estado_cumplimiento_requisito integer NOT NULL DEFAULT nextval('rbs.param_estado_cumplimiento_req_id_estado_cumplimiento_requis_seq'::regclass),
	estado_cumlimineto_requisito character varying(30),
	descripcion character varying(100),
	estado_registro character varying(2),
	usuario_creado_actual character varying(100) NOT NULL,
	fecha_creacion_registro timestamp DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT param_estado_cumplimiento_requisitos_pkey PRIMARY KEY (id_estado_cumplimiento_requisito)
);
-- ddl-end --
COMMENT ON TABLE rbs.param_estado_cumplimiento_requisitos IS E'Tabla parametrica que almancena el estado de cumplimineto de los items';
-- ddl-end --
ALTER TABLE rbs.param_estado_cumplimiento_requisitos OWNER TO postgres;
-- ddl-end --

-- object: rbs.param_estado_de_implementacion_id_estado_de_implementacion_seq | type: SEQUENCE --
-- DROP SEQUENCE IF EXISTS rbs.param_estado_de_implementacion_id_estado_de_implementacion_seq CASCADE;
CREATE SEQUENCE rbs.param_estado_de_implementacion_id_estado_de_implementacion_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;

-- ddl-end --
ALTER SEQUENCE rbs.param_estado_de_implementacion_id_estado_de_implementacion_seq OWNER TO postgres;
-- ddl-end --

-- object: rbs.param_estado_de_implementacion | type: TABLE --
-- DROP TABLE IF EXISTS rbs.param_estado_de_implementacion CASCADE;
CREATE TABLE rbs.param_estado_de_implementacion (
	id_estado_de_implementacion integer NOT NULL DEFAULT nextval('rbs.param_estado_de_implementacion_id_estado_de_implementacion_seq'::regclass),
	estado_de_implementacion character varying(30),
	descripcion character varying(100),
	estado_registro character varying(2),
	usuario_creado_actual character varying(100) NOT NULL,
	fecha_creacion_registro timestamp DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT param_estado_de_implementacion_pkey PRIMARY KEY (id_estado_de_implementacion)
);
-- ddl-end --
COMMENT ON TABLE rbs.param_estado_de_implementacion IS E'Tabla parametrica que contiene los estados de implementación de cada orietnación';
-- ddl-end --
ALTER TABLE rbs.param_estado_de_implementacion OWNER TO postgres;
-- ddl-end --

-- object: rbs.orps_id_orp_seq | type: SEQUENCE --
-- DROP SEQUENCE IF EXISTS rbs.orps_id_orp_seq CASCADE;
CREATE SEQUENCE rbs.orps_id_orp_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;

-- ddl-end --
ALTER SEQUENCE rbs.orps_id_orp_seq OWNER TO postgres;
-- ddl-end --

-- object: rbs.param_orps | type: TABLE --
-- DROP TABLE IF EXISTS rbs.param_orps CASCADE;
CREATE TABLE rbs.param_orps (
	id_orp integer NOT NULL DEFAULT nextval('rbs.orps_id_orp_seq'::regclass),
	id_especialidad integer NOT NULL,
	correlativo integer NOT NULL,
	parametro_riegos_organizacion text,
	nivel_tres_menos_deseableo character varying(500),
	nivel_dos_promedio character varying(500),
	nivel_uno_mas_deseable character varying(500),
	estado_registro character varying(2),
	usuario_actual character varying(100) NOT NULL,
	fecha_registro timestamp DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT orp_pkey PRIMARY KEY (id_orp)
);
-- ddl-end --
ALTER TABLE rbs.param_orps OWNER TO postgres;
-- ddl-end --

-- object: rbs.sms_id_sms_seq | type: SEQUENCE --
-- DROP SEQUENCE IF EXISTS rbs.sms_id_sms_seq CASCADE;
CREATE SEQUENCE rbs.sms_id_sms_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;

-- ddl-end --
ALTER SEQUENCE rbs.sms_id_sms_seq OWNER TO postgres;
-- ddl-end --

-- object: rbs.param_sms | type: TABLE --
-- DROP TABLE IF EXISTS rbs.param_sms CASCADE;
CREATE TABLE rbs.param_sms (
	id_sms integer NOT NULL DEFAULT nextval('rbs.sms_id_sms_seq'::regclass),
	id_especialidad integer NOT NULL,
	correlativo integer NOT NULL,
	codigo_componente integer NOT NULL,
	descripcion_componente text,
	codigo_elemento integer NOT NULL,
	descipcion_elemento text,
	codigo_indicador_cumplimiento integer NOT NULL,
	descripcion_inidicador_cumplimiento text,
	peso integer NOT NULL,
	estado_registro character varying(2),
	usuario_actual character varying(100) NOT NULL,
	fecha_registro timestamp DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT sms_pkey PRIMARY KEY (id_sms)
);
-- ddl-end --
ALTER TABLE rbs.param_sms OWNER TO postgres;
-- ddl-end --

-- object: rbs.valor_sms_eficiencia_id_valor_sms_seq | type: SEQUENCE --
-- DROP SEQUENCE IF EXISTS rbs.valor_sms_eficiencia_id_valor_sms_seq CASCADE;
CREATE SEQUENCE rbs.valor_sms_eficiencia_id_valor_sms_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;

-- ddl-end --
ALTER SEQUENCE rbs.valor_sms_eficiencia_id_valor_sms_seq OWNER TO postgres;
-- ddl-end --

-- object: rbs.valor_sms_eficiencia | type: TABLE --
-- DROP TABLE IF EXISTS rbs.valor_sms_eficiencia CASCADE;
CREATE TABLE rbs.valor_sms_eficiencia (
	id_valor_sms integer NOT NULL DEFAULT nextval('rbs.valor_sms_eficiencia_id_valor_sms_seq'::regclass),
	valor_eficiencia character varying(12) NOT NULL,
	descripcion_valor_eficiencia character varying(100),
	estado_registro character varying(2),
	usuario_actual character varying(100) NOT NULL,
	fecha_registro timestamp DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT valor_sms_eficiencia_pkey PRIMARY KEY (id_valor_sms)
);
-- ddl-end --
ALTER TABLE rbs.valor_sms_eficiencia OWNER TO postgres;
-- ddl-end --

-- object: param_unidades_id_direccion_fkey | type: CONSTRAINT --
-- ALTER TABLE rbs.param_unidades DROP CONSTRAINT IF EXISTS param_unidades_id_direccion_fkey CASCADE;
ALTER TABLE rbs.param_unidades ADD CONSTRAINT param_unidades_id_direccion_fkey FOREIGN KEY (id_direccion)
REFERENCES rbs.param_direcciones (id_direccion) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: param_especialidades_id_unidad_fkey | type: CONSTRAINT --
-- ALTER TABLE rbs.param_especialidades DROP CONSTRAINT IF EXISTS param_especialidades_id_unidad_fkey CASCADE;
ALTER TABLE rbs.param_especialidades ADD CONSTRAINT param_especialidades_id_unidad_fkey FOREIGN KEY (id_unidad)
REFERENCES rbs.param_unidades (id_unidad) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: param_lista_de_verificaciones_id_especialidad_fkey | type: CONSTRAINT --
-- ALTER TABLE rbs.param_lista_de_verificaciones DROP CONSTRAINT IF EXISTS param_lista_de_verificaciones_id_especialidad_fkey CASCADE;
ALTER TABLE rbs.param_lista_de_verificaciones ADD CONSTRAINT param_lista_de_verificaciones_id_especialidad_fkey FOREIGN KEY (id_especialidad)
REFERENCES rbs.param_especialidades (id_especidalidad) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: param_items_id_lista_verificacion_fkey | type: CONSTRAINT --
-- ALTER TABLE rbs.param_items DROP CONSTRAINT IF EXISTS param_items_id_lista_verificacion_fkey CASCADE;
ALTER TABLE rbs.param_items ADD CONSTRAINT param_items_id_lista_verificacion_fkey FOREIGN KEY (id_lista_verificacion)
REFERENCES rbs.param_lista_de_verificaciones (id_lista_verificacion) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: param_orientaciones_id_item_fkey | type: CONSTRAINT --
-- ALTER TABLE rbs.param_orientaciones DROP CONSTRAINT IF EXISTS param_orientaciones_id_item_fkey CASCADE;
ALTER TABLE rbs.param_orientaciones ADD CONSTRAINT param_orientaciones_id_item_fkey FOREIGN KEY (id_item)
REFERENCES rbs.param_items (id_item) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: orps_id_especialidad_fkey | type: CONSTRAINT --
-- ALTER TABLE rbs.param_orps DROP CONSTRAINT IF EXISTS orps_id_especialidad_fkey CASCADE;
ALTER TABLE rbs.param_orps ADD CONSTRAINT orps_id_especialidad_fkey FOREIGN KEY (id_especialidad)
REFERENCES rbs.param_especialidades (id_especidalidad) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: sms_id_especialidad_fkey | type: CONSTRAINT --
-- ALTER TABLE rbs.param_sms DROP CONSTRAINT IF EXISTS sms_id_especialidad_fkey CASCADE;
ALTER TABLE rbs.param_sms ADD CONSTRAINT sms_id_especialidad_fkey FOREIGN KEY (id_especialidad)
REFERENCES rbs.param_especialidades (id_especidalidad) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --


