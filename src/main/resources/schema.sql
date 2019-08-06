-- Adminer 4.7.2 PostgreSQL dump

DROP TABLE IF EXISTS "customer";
DROP SEQUENCE IF EXISTS customer_id_seq;
CREATE SEQUENCE customer_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;

CREATE TABLE "public"."customer" (
    "id" integer DEFAULT nextval('customer_id_seq') NOT NULL,
    "first_name" character varying(45),
    "last_name" character varying(45),
    "email" character varying(45),
    CONSTRAINT "customer_id" PRIMARY KEY ("id")
) WITH (oids = false);

INSERT INTO "customer" ("id", "first_name", "last_name", "email") VALUES
(1,	'Boreallus',	'Sibius',	'boreallus.sibius@ultramarines.mil'),
(2,	'Maneureas',	'Sicassius',	'maneureas.sicassius@imperiumofman.gov'),
(3,	'Alararr',	'Icefisted',	'alararr25@imperialguard.org'),
(4,	'Sarpeshan',	'Aqios',	'sarpeshan.aqios@deathwatch.net'),
(5,	'Viteratos',	'Vibius',	'viteratos.vibius@imperialnavy.mil'),
(6,	'Canor',	'Frosthorn',	'c.frosthorn@mechanicus.net');

-- 2019-08-04 14:33:41.492828+00