PGDMP                         v            serviciosya    9.5.14    10.4 +    u           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            v           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            w           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            x           1262    16393    serviciosya    DATABASE     �   CREATE DATABASE serviciosya WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE serviciosya;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            y           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    6            z           0    0    SCHEMA public    ACL     �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                  postgres    false    6                        3079    12355    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            {           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    16432    CITY_SEQ    SEQUENCE     s   CREATE SEQUENCE public."CITY_SEQ"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public."CITY_SEQ";
       public       postgres    false    6            �            1259    16422    CITY    TABLE     �   CREATE TABLE public."CITY" (
    "ID_CIUDAD" bigint DEFAULT nextval('public."CITY_SEQ"'::regclass) NOT NULL,
    "NAME" bit varying(60) NOT NULL,
    "PROVINCE_ID" bigint NOT NULL
);
    DROP TABLE public."CITY";
       public         postgres    false    185    6            �            1259    16459 
   CLIENT_SEQ    SEQUENCE     u   CREATE SEQUENCE public."CLIENT_SEQ"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public."CLIENT_SEQ";
       public       postgres    false    6            �            1259    16449    CLIENT    TABLE     s   CREATE TABLE public."CLIENT" (
    "ID_CLIENT" bigint DEFAULT nextval('public."CLIENT_SEQ"'::regclass) NOT NULL
);
    DROP TABLE public."CLIENT";
       public         postgres    false    192    6            �            1259    16434    COUNTRY_SEQ    SEQUENCE     v   CREATE SEQUENCE public."COUNTRY_SEQ"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public."COUNTRY_SEQ";
       public       postgres    false    6            �            1259    16412    COUNTRY    TABLE     �   CREATE TABLE public."COUNTRY" (
    "ID" bigint DEFAULT nextval('public."COUNTRY_SEQ"'::regclass) NOT NULL,
    "NAME" bit varying(50) NOT NULL
);
    DROP TABLE public."COUNTRY";
       public         postgres    false    186    6            �            1259    16438    OCCUPATION_SEQ    SEQUENCE     y   CREATE SEQUENCE public."OCCUPATION_SEQ"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public."OCCUPATION_SEQ";
       public       postgres    false    6            �            1259    16394 
   OCCUPATION    TABLE     �   CREATE TABLE public."OCCUPATION" (
    "ID" bigint DEFAULT nextval('public."OCCUPATION_SEQ"'::regclass) NOT NULL,
    "NAME" character varying(48) NOT NULL,
    "DESCRIPTION" character varying(140) NOT NULL,
    "PARENT" bigint
);
     DROP TABLE public."OCCUPATION";
       public         postgres    false    188    6            �            1259    16444    PERSON    TABLE       CREATE TABLE public."PERSON" (
    "NAME" bit varying(50) NOT NULL,
    "LAST_NAME" bit varying(50) NOT NULL,
    "ADDRESS" bit varying(50) NOT NULL,
    "PHONE" bigint NOT NULL,
    "BIRTHDAY" date NOT NULL,
    "EMAIL" character varying(50) NOT NULL,
    "DNI" bigint NOT NULL
);
    DROP TABLE public."PERSON";
       public         postgres    false    6            �            1259    16461    PROVIDER_SEQ    SEQUENCE     w   CREATE SEQUENCE public."PROVIDER_SEQ"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public."PROVIDER_SEQ";
       public       postgres    false    6            �            1259    16454    PROVIDER    TABLE     y   CREATE TABLE public."PROVIDER" (
    "ID_PROVIDER" bigint DEFAULT nextval('public."PROVIDER_SEQ"'::regclass) NOT NULL
);
    DROP TABLE public."PROVIDER";
       public         postgres    false    193    6            �            1259    16436    PROV_SEQ    SEQUENCE     s   CREATE SEQUENCE public."PROV_SEQ"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public."PROV_SEQ";
       public       postgres    false    6            �            1259    16427    PROVINCE    TABLE     �   CREATE TABLE public."PROVINCE" (
    "ID_PROV" bigint DEFAULT nextval('public."PROV_SEQ"'::regclass) NOT NULL,
    "NAME" bit varying(50) NOT NULL,
    "COUNTRY" bit varying(50) NOT NULL
);
    DROP TABLE public."PROVINCE";
       public         postgres    false    187    6            h          0    16422    CITY 
   TABLE DATA               D   COPY public."CITY" ("ID_CIUDAD", "NAME", "PROVINCE_ID") FROM stdin;
    public       postgres    false    183   o+       o          0    16449    CLIENT 
   TABLE DATA               /   COPY public."CLIENT" ("ID_CLIENT") FROM stdin;
    public       postgres    false    190   �+       g          0    16412    COUNTRY 
   TABLE DATA               1   COPY public."COUNTRY" ("ID", "NAME") FROM stdin;
    public       postgres    false    182   �+       f          0    16394 
   OCCUPATION 
   TABLE DATA               M   COPY public."OCCUPATION" ("ID", "NAME", "DESCRIPTION", "PARENT") FROM stdin;
    public       postgres    false    181   �+       n          0    16444    PERSON 
   TABLE DATA               g   COPY public."PERSON" ("NAME", "LAST_NAME", "ADDRESS", "PHONE", "BIRTHDAY", "EMAIL", "DNI") FROM stdin;
    public       postgres    false    189   �+       p          0    16454    PROVIDER 
   TABLE DATA               3   COPY public."PROVIDER" ("ID_PROVIDER") FROM stdin;
    public       postgres    false    191    ,       i          0    16427    PROVINCE 
   TABLE DATA               B   COPY public."PROVINCE" ("ID_PROV", "NAME", "COUNTRY") FROM stdin;
    public       postgres    false    184   ,       |           0    0    CITY_SEQ    SEQUENCE SET     9   SELECT pg_catalog.setval('public."CITY_SEQ"', 1, false);
            public       postgres    false    185            }           0    0 
   CLIENT_SEQ    SEQUENCE SET     ;   SELECT pg_catalog.setval('public."CLIENT_SEQ"', 1, false);
            public       postgres    false    192            ~           0    0    COUNTRY_SEQ    SEQUENCE SET     <   SELECT pg_catalog.setval('public."COUNTRY_SEQ"', 1, false);
            public       postgres    false    186                       0    0    OCCUPATION_SEQ    SEQUENCE SET     ?   SELECT pg_catalog.setval('public."OCCUPATION_SEQ"', 1, false);
            public       postgres    false    188            �           0    0    PROVIDER_SEQ    SEQUENCE SET     =   SELECT pg_catalog.setval('public."PROVIDER_SEQ"', 1, false);
            public       postgres    false    193            �           0    0    PROV_SEQ    SEQUENCE SET     9   SELECT pg_catalog.setval('public."PROV_SEQ"', 1, false);
            public       postgres    false    187            �           2606    16426    CITY CITY_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public."CITY"
    ADD CONSTRAINT "CITY_pkey" PRIMARY KEY ("ID_CIUDAD");
 <   ALTER TABLE ONLY public."CITY" DROP CONSTRAINT "CITY_pkey";
       public         postgres    false    183            �           2606    16453    CLIENT CLIENT_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public."CLIENT"
    ADD CONSTRAINT "CLIENT_pkey" PRIMARY KEY ("ID_CLIENT");
 @   ALTER TABLE ONLY public."CLIENT" DROP CONSTRAINT "CLIENT_pkey";
       public         postgres    false    190            �           2606    16398    OCCUPATION OCCUPATION_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public."OCCUPATION"
    ADD CONSTRAINT "OCCUPATION_pkey" PRIMARY KEY ("ID");
 H   ALTER TABLE ONLY public."OCCUPATION" DROP CONSTRAINT "OCCUPATION_pkey";
       public         postgres    false    181            �           2606    16416    COUNTRY PAIS_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public."COUNTRY"
    ADD CONSTRAINT "PAIS_pkey" PRIMARY KEY ("ID");
 ?   ALTER TABLE ONLY public."COUNTRY" DROP CONSTRAINT "PAIS_pkey";
       public         postgres    false    182            �           2606    16448    PERSON PERSON_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public."PERSON"
    ADD CONSTRAINT "PERSON_pkey" PRIMARY KEY ("DNI");
 @   ALTER TABLE ONLY public."PERSON" DROP CONSTRAINT "PERSON_pkey";
       public         postgres    false    189            �           2606    16458    PROVIDER PROVIDER_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public."PROVIDER"
    ADD CONSTRAINT "PROVIDER_pkey" PRIMARY KEY ("ID_PROVIDER");
 D   ALTER TABLE ONLY public."PROVIDER" DROP CONSTRAINT "PROVIDER_pkey";
       public         postgres    false    191            �           2606    16431    PROVINCE PROVINCE_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public."PROVINCE"
    ADD CONSTRAINT "PROVINCE_pkey" PRIMARY KEY ("ID_PROV");
 D   ALTER TABLE ONLY public."PROVINCE" DROP CONSTRAINT "PROVINCE_pkey";
       public         postgres    false    184            �           2606    16399    OCCUPATION FKOCCUPATION    FK CONSTRAINT     �   ALTER TABLE ONLY public."OCCUPATION"
    ADD CONSTRAINT "FKOCCUPATION" FOREIGN KEY ("PARENT") REFERENCES public."OCCUPATION"("ID");
 E   ALTER TABLE ONLY public."OCCUPATION" DROP CONSTRAINT "FKOCCUPATION";
       public       postgres    false    181    181    2022            h      x������ � �      o      x������ � �      g      x������ � �      f      x������ � �      n      x������ � �      p      x������ � �      i      x������ � �     